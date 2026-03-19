/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package batallapokemon;
import java.util.*; // importar scanner y random

public class RTO2_SEM7_2C_AAFL_BatallaPokemon{

    static Scanner sc = new Scanner(System.in); // leer teclado
    static Random rand = new Random(); // numeros aleatorios

    // buffs por jugador
    static double[] buffDanio = new double[2]; // multiplicador de ataque
    static double[] buffDefensa = new double[2]; // multiplicador defensa
    static boolean[] buffCritico = new boolean[2]; // critico garantizado
    static boolean[] saltoTurno = new boolean[2]; // perder turno por pocion

    public static void main(String[] args) {

        // arrays [jugador][criatura]
        String[][] nombres = new String[2][3]; // nombres
        String[][] tipos = new String[2][3]; // tipos
        int[][] vida = new int[2][3]; // vida
        int[][] ataque = new int[2][3]; // ataque
        int[][] defensa = new int[2][3]; // defensa

        // registro de criaturas
        for (int j = 0; j < 2; j++) { // recorrer jugadores
            System.out.println("Jugador " + (j + 1));

            for (int i = 0; i < 3; i++) { // 3 criaturas

                nombres[j][i] = pedirNombre("Nombre criatura: "); // validar nombre
                tipos[j][i] = pedirTipo(); // pedir tipo

                vida[j][i] = pedirNumero("Vida: "); // pedir vida
                ataque[j][i] = pedirNumero("Ataque: "); // pedir ataque
                defensa[j][i] = pedirNumero("Defensa: "); // pedir defensa
            }
        }

        int vivosJ1 = 3; // criaturas vivas jugador 1
        int vivosJ2 = 3; // criaturas vivas jugador 2

        // ciclo del juego
        while (vivosJ1 > 0 && vivosJ2 > 0) {

            int c1 = elegirCriatura(nombres, vida, 0); // elegir criatura jugador 1
            int c2 = elegirCriatura(nombres, vida, 1); // elegir criatura jugador 2

            boolean turnoJ1 = lanzarMoneda(); // decidir quien empieza

            // combate
            while (vida[0][c1] > 0 && vida[1][c2] > 0) {

                if (turnoJ1) {
                    turnoJugador(0, 1, c1, c2, nombres, vida, ataque, defensa, tipos);
                    turnoJ1 = false; // cambiar turno
                } else {
                    turnoJugador(1, 0, c2, c1, nombres, vida, ataque, defensa, tipos);
                    turnoJ1 = true; // cambiar turno
                }
            }

            // verificar derrota
            if (vida[0][c1] <= 0) {
                System.out.println(nombres[0][c1] + " derrotado");
                vivosJ1--;
            } else {
                System.out.println(nombres[1][c2] + " derrotado");
                vivosJ2--;
            }
        }

        // ganador
        if (vivosJ1 > 0)
            System.out.println("Jugador 1 gana");
        else
            System.out.println("Jugador 2 gana");
    }

    // pedir nombre solo letras
    static String pedirNombre(String msg) {
        String nombre;
        do {
            System.out.print(msg);
            nombre = sc.nextLine();
        } while (!nombre.matches("[a-zA-Z]+")); // validar letras
        return nombre;
    }

    // pedir numero con try catch
    static int pedirNumero(String msg) {
        int num = 0;
        while (true) {
            try {
                System.out.print(msg);
                num = sc.nextInt();
                sc.nextLine(); // limpiar buffer
                if (num > 0) break; // solo positivos
            } catch (Exception e) {
                System.out.println("Error");
                sc.nextLine(); // limpiar error
            }
        }
        return num;
    }

    // pedir tipo valido
    static String pedirTipo() {
        String tipo;
        do {
            System.out.print("Tipo fuego agua planta: ");
            tipo = sc.nextLine().toLowerCase();
        } while (!(tipo.equals("fuego") || tipo.equals("agua") || tipo.equals("planta")));
        return tipo;
    }

    // elegir criatura viva
    static int elegirCriatura(String[][] nombres, int[][] vida, int jugador) {
        int op;
        while (true) {
            try {
                System.out.println("Jugador " + (jugador + 1) + " elige:");
                for (int i = 0; i < 3; i++) {
                    if (vida[jugador][i] > 0) // solo vivos
                        System.out.println((i + 1) + " " + nombres[jugador][i]);
                }
                op = sc.nextInt() - 1;
                sc.nextLine();
                if (op >= 0 && op < 3 && vida[jugador][op] > 0) break;
            } catch (Exception e) {
                sc.nextLine();
            }
        }
        return op;
    }

    // moneda
    static boolean lanzarMoneda() {
        System.out.print("Jugador 1 elige cara o cruz: ");
        String eleccion = sc.nextLine().toLowerCase();

        String resultado = rand.nextBoolean() ? "cara" : "cruz";

        System.out.println("Salio: " + resultado);

        return eleccion.equals(resultado);
    }

    // turno
    static void turnoJugador(int jA, int jD, int cA, int cD,
                            String[][] nombres, int[][] vida,
                            int[][] ataque, int[][] defensa,
                            String[][] tipos) {

        System.out.println("\nTurno de " + nombres[jA][cA]);

        // saltar turno
        if (saltoTurno[jA]) {
            System.out.println("Turno saltado por pocion");
            saltoTurno[jA] = false;
            return;
        }

        // curacion especial
        if (buffDanio[jA] == -30) {
            vida[jA][cA] += 30;
            System.out.println("Cura +30 aplicada");
            buffDanio[jA] = 0;
        }

        // menu
        System.out.println("1 atacar 2 defender 3 curar 4 pocion");
        int op = pedirNumero("Opcion: ");

        switch (op) {

            case 1: // ataque
                double atk = ataque[jA][cA]; // ataque base
                double def = defensa[jD][cD]; // defensa rival

                // buff dano
                if (buffDanio[jA] > 0) {
                    atk *= buffDanio[jA];
                    buffDanio[jA] = 0;
                }

                // buff defensa enemigo
                if (buffDefensa[jD] > 0) {
                    def *= buffDefensa[jD];
                    buffDefensa[jD] = 0;
                }

                // formula proporcional (nunca 0)
                double danioReal = atk * (100.0 / (100 + def));
                int danio = (int) danioReal;

                // ventaja tipo
                if (ventajaTipo(tipos[jA][cA], tipos[jD][cD]))
                    danio *= 1.5;

                // critico
                if (buffCritico[jA] || rand.nextInt(100) < 10) {
                    danio *= 2;
                    System.out.println("Critico");
                    buffCritico[jA] = false;
                }

                if (danio < 1) danio = 1; // dano minimo

                vida[jD][cD] -= danio; // quitar vida

                System.out.println(nombres[jD][cD] + " pierde " + danio);
                System.out.println("Vida restante " + vida[jD][cD]);
                break;

            case 2: // defender
                defensa[jA][cA] += 5;
                System.out.println("Defensa aumenta");
                break;

            case 3: // curar
                vida[jA][cA] += 10;
                System.out.println("Cura +10");
                break;

            case 4: // pocion
                int tipo = rand.nextInt(4);

                System.out.println("Pocion usada");

                switch (tipo) {
                    case 0:
                        System.out.println("Pocion dano x2.5 siguiente turno");
                        buffDanio[jA] = 2.5;
                        break;
                    case 1:
                        System.out.println("Pocion defensa x2 siguiente turno");
                        buffDefensa[jA] = 2;
                        break;
                    case 2:
                        System.out.println("Pocion cura +30 siguiente turno");
                        buffDanio[jA] = -30;
                        break;
                    case 3:
                        System.out.println("Pocion critico garantizado");
                        buffCritico[jA] = true;
                        break;
                }

                saltoTurno[jA] = true; // pierde turno
                return;
        }
    }

    // ventaja de tipos
    static boolean ventajaTipo(String a, String b) {
        return (a.equals("fuego") && b.equals("planta")) ||
               (a.equals("agua") && b.equals("fuego")) ||
               (a.equals("planta") && b.equals("agua"));
    }
}
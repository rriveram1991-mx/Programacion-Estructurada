/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;
import java.util.Scanner; // Importamos Scanner para leer datos

public class RTO1_SEM8_2C_AAFL_RPG {

    public static void main(String[] args) {  // Metodo principal donde inicia el programa
        // TODO code application logic here
         Scanner sc = new Scanner(System.in); // Objeto para entrada de datos

        // MATRICES PARA GUARDAR DATOS DE LOS HEROES
        String[][] nombres = new String[2][3]; // 2 jugadores, 3 heroes cada uno
        int[][] vida = new int[2][3]; // Vida de cada heroe
        int[][] ataque = new int[2][3]; // Ataque fisico
        int[][] magia = new int[2][3]; // Ataque magico
        int[][] energia = new int[2][3]; // Energia disponible
        boolean[][] vivo = new boolean[2][3]; // Estado de vida (true = vivo)
        int[][] curaciones = new int[2][3]; // Numero de curaciones usadas

        // REGISTRO DE HEROES
        for (int i = 0; i < 2; i++) { // Recorre jugadores
            System.out.println("Jugador " + (i + 1));

            for (int j = 0; j < 3; j++) { // Recorre heroes

                // VALIDACION DEL NOMBRE
                while (true) {
                    try {
                        System.out.print("Nombre: ");
                        String nombre = sc.next();

                        // Solo permite letras
                        if (!nombre.matches("[a-zA-Z]+")) {
                            throw new Exception("Nombre invalido");
                        }

                        nombres[i][j] = nombre; // Guarda nombre
                        break; // Sale si es correcto

                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                // LECTURA DE ATRIBUTOS CON VALIDACION
                vida[i][j] = leerNumero(sc, "Vida: ");
                ataque[i][j] = leerNumero(sc, "Ataque: ");
                magia[i][j] = leerNumero(sc, "Magia: ");
                energia[i][j] = leerNumero(sc, "Energia: ");

                vivo[i][j] = true; // El heroe inicia vivo
                curaciones[i][j] = 0; // Inicia sin curaciones
            }
        }

        int turno = 0; // Contador de turnos

        // BUCLE PRINCIPAL DEL JUEGO
        while (tieneVivos(vivo, 0) && tieneVivos(vivo, 1)) {

            int jugador = turno % 2; // Alterna entre jugador 0 y 1
            int enemigo = (jugador == 0) ? 1 : 0; // Define enemigo

            System.out.println("\nTurno Jugador " + (jugador + 1));

            int heroe;

            // SELECCION DE HEROE VALIDO
            while (true) {
                mostrarHeroes(nombres, vida, vivo, jugador);
                heroe = leerNumero(sc, "Elige heroe: ");

                // Validacion de rango y que este vivo
                if (heroe >= 0 && heroe < 3 && vivo[jugador][heroe]) {
                    break;
                } else {
                    System.out.println("Heroe invalido");
                }
            }

            // MENU DE ACCIONES
            int opcion = leerNumero(sc, "1.Ataque fisico 2.Ataque magico 3.Curarse 4.Cambiar: ");

            if (opcion == 4) continue; // Cambiar heroe, no hace accion

            // CURACION
            if (opcion == 3) {
                if (curaciones[jugador][heroe] < 2) { // Maximo 2 curaciones
                    vida[jugador][heroe] += 20;
                    curaciones[jugador][heroe]++;
                    System.out.println("Se curo 20");
                } else {
                    System.out.println("No puede curarse mas");
                }
                turno++;
                continue;
            }

            int objetivo;

            // SELECCION DE ENEMIGO VALIDO
            while (true) {
                mostrarHeroes(nombres, vida, vivo, enemigo);
                objetivo = leerNumero(sc, "Elige enemigo: ");

                if (objetivo >= 0 && objetivo < 3 && vivo[enemigo][objetivo]) {
                    break;
                } else {
                    System.out.println("Objetivo invalido");
                }
            }

            int dano = 0; // Variable para dano

            // ATAQUE FISICO
            if (opcion == 1) {
                dano = ataque[jugador][heroe];
            }

            // ATAQUE MAGICO
            else if (opcion == 2) {
                if (energia[jugador][heroe] >= 10) {
                    dano = magia[jugador][heroe];
                    energia[jugador][heroe] -= 10;
                } else {
                    System.out.println("Sin energia");
                    continue;
                }
            }

            // EVENTO CRITICO (20 porciento)
            int prob = (int)(Math.random() * 100);
            if (prob < 20) {
                dano *= 2;
                System.out.println("Golpe critico");
            }

            // APLICAR DANO
            vida[enemigo][objetivo] -= dano;

            System.out.println(nombres[jugador][heroe] + " hace " + dano + " de dano");

            // VERIFICAR MUERTE
            if (vida[enemigo][objetivo] <= 0) {
                vida[enemigo][objetivo] = 0;
                vivo[enemigo][objetivo] = false;
                System.out.println("Murio " + nombres[enemigo][objetivo]);
            } else {
                System.out.println("Vida restante: " + vida[enemigo][objetivo]);
            }

            turno++;
        }

        // GANADOR
        if (!tieneVivos(vivo, 0)) {
            System.out.println("Gana Jugador 2");
        } else {
            System.out.println("Gana Jugador 1");
        }
    }

    // FUNCION PARA LEER NUMEROS CON VALIDACION
    public static int leerNumero(Scanner sc, String mensaje) {
        int num;

        while (true) {
            try {
                System.out.print(mensaje);
                num = Integer.parseInt(sc.next());

                if (num < 0) {
                    throw new Exception("Numero invalido");
                }

                return num;

            } catch (Exception e) {
                System.out.println("Error, ingresa numero valido");
            }
        }
    }

    // VERIFICA SI UN JUGADOR TIENE HEROES VIVOS
    public static boolean tieneVivos(boolean[][] vivo, int jugador) {
        for (int i = 0; i < 3; i++) {
            if (vivo[jugador][i]) return true;
        }
        return false;
    }

    // MUESTRA LOS HEROES DISPONIBLES
    public static void mostrarHeroes(String[][] nombres, int[][] vida, boolean[][] vivo, int jugador) {
        for (int i = 0; i < 3; i++) {
            if (vivo[jugador][i]) {
                System.out.println(i + ". " + nombres[jugador][i] + " (HP: " + vida[jugador][i] + ")");
            }
        }
    }
}
    
    


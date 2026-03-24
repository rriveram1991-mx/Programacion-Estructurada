import java.util.Scanner;

public class RTO1_SEM8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];

        for (int i = 0; i < 2; i++) {
            System.out.println("\n--- Registro Jugador " + (i + 1) + " ---");
            for (int j = 0; j < 3; j++) {
                System.out.print("Nombre del héroe " + (j + 1) + ": ");
                nombres[i][j] = sc.next();
                vida[i][j] = 100;    // Vida base
                ataque[i][j] = 15;  // Ataque base
                magia[i][j] = 25;   // Magia base
                energia[i][j] = 30; // Energía base
                vivo[i][j] = true;
                curaciones[i][j] = 0;
            }
        }

        int turnoJugador = 0; //Inicia Jugador 1 

        //BUCLE PRINCIPAL DE BATALLA
        while (quedanVivos(vivo, 0) && quedanVivos(vivo, 1)) {
            int rival = (turnoJugador == 0) ? 1 : 0;
            System.out.println("\n--- TURNO JUGADOR " + (turnoJugador + 1) + " ---");

            //Selección de Héroe Atacante
            int hAtacante = seleccionarHeroe(nombres, vivo, turnoJugador, sc);
            
            //Selección de Objetivo
            int hObjetivo = seleccionarHeroe(nombres, vivo, rival, sc);

            //Menú de Acciones
            System.out.println("Acción para " + nombres[turnoJugador][hAtacante] + ": 1.Ataque | 2.Magia | 3.Curar");
            int accion = sc.nextInt();

            procesarAccion(accion, turnoJugador, hAtacante, rival, hObjetivo, nombres, vida, ataque, magia, energia, curaciones, vivo);

            //Cambio de turno
            turnoJugador = rival;
        }

        System.out.println("\n¡PARTIDA TERMINADA! El Jugador " + (quedanVivos(vivo, 0) ? "1" : "2") + " es el ganador.");
    }

    //LÓGICA DE ACCIONES Y COMBATE
    public static void procesarAccion(int accion, int jA, int hA, int jR, int hR, String[][] n, int[][] v, int[][] at, int[][] m, int[][] e, int[][] c, boolean[][] vivo) {
        int daño = 0;

        switch (accion) {
            case 1: //Ataque Físico
                daño = at[jA][hA];
                if (Math.random() < 0.20) { //Evento Crítico
                    daño *= 2;
                    System.out.println("¡GOLPE CRÍTICO!");
                }
                v[jR][hR] -= daño;
                System.out.println(n[jA][hA] + " atacó a " + n[jR][hR] + " causando " + daño + " de daño.");
                break;

            case 2: //Ataque Mágico
                if (e[jA][hA] >= 10) {
                    daño = m[jA][hA];
                    v[jR][hR] -= daño;
                    e[jA][hA] -= 10;
                    System.out.println(n[jA][hA] + " lanzó un hechizo a " + n[jR][hR] + " (" + daño + " de daño).");
                } else {
                    System.out.println("¡Sin energía! El héroe pierde el turno por agotamiento.");
                }
                break;

            case 3: //Curación
                if (c[jA][hA] < 2) {
                    v[jA][hA] += 20;
                    c[jA][hA]++;
                    System.out.println(n[jA][hA] + " se ha curado. Vida actual: " + v[jA][hA]);
                } else {
                    System.out.println("Ya no puedes curarte más veces.");
                }
                break;
        }

        //Validación de Muerte
        if (v[jR][hR] <= 0) {
            v[jR][hR] = 0;
            vivo[jR][hR] = false;
            System.out.println("¡" + n[jR][hR] + " ha caído en batalla!");
        } else if (accion != 3) {
            System.out.println("Vida restante de " + n[jR][hR] + ": " + v[jR][hR]);
        }
    }

    public static boolean quedanVivos(boolean[][] vivo, int jugador) {
        return vivo[jugador][0] || vivo[jugador][1] || vivo[jugador][2];
    }

    public static int seleccionarHeroe(String[][] n, boolean[][] vivo, int j, Scanner sc) {
        int eleccion;
        do {
            System.out.println("Selecciona héroe del Jugador " + (j + 1) + ":");
            for (int i = 0; i < 3; i++) {
                if (vivo[j][i]) System.out.println(i + ". " + n[j][i]);
            }
            eleccion = sc.nextInt();
        } while (eleccion < 0 || eleccion > 2 || !vivo[j][eleccion]);
        return eleccion;
    }
}

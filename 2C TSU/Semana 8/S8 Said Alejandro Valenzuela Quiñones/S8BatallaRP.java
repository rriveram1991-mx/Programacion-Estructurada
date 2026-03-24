package s8batallarp;

import java.util.Scanner;

public class S8BatallaRP {

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
            System.out.println("\nJugador " + (i + 1));
            System.out.println("===== CONFIGURACION DE HEROES =====");
            for (int j = 0; j < 3; j++) {

                System.out.print("\nNombre: ");
                nombres[i][j] = sc.next();

                System.out.print("Vida: ");
                vida[i][j] = sc.nextInt();

                System.out.print("Ataque: ");
                ataque[i][j] = sc.nextInt();

                System.out.print("Magia: ");
                magia[i][j] = sc.nextInt();

                System.out.print("Energia: ");
                energia[i][j] = sc.nextInt();

                vivo[i][j] = true;
                curaciones[i][j] = 0;
            }
        }

        int j1 = 0, j2 = 0;

        
        j1 = elegirHeroe(sc, nombres, vivo, 0);
        j2 = elegirHeroe(sc, nombres, vivo, 1);

        int turno = 0; 

        while (hayVivos(vivo, 0) && hayVivos(vivo, 1)) {

            int jugador = turno;
            int enemigo = (turno == 0) ? 1 : 0;

            int hActual = (jugador == 0) ? j1 : j2;
            int hEnemigo = (jugador == 0) ? j2 : j1;

            System.out.println("\nTurno Jugador " + (jugador + 1));
            System.out.println("Heroe: " + nombres[jugador][hActual]);

            System.out.println("1. Ataque fisico");
            System.out.println("2. Ataque magico");
            System.out.println("3. Curarse");
            System.out.println("4. Cambiar heroe");

            int op = sc.nextInt();

            switch (op) {

                case 1:
                    int daño = ataque[jugador][hActual];

                    int prob = (int) (Math.random() * 100);
                    if (prob < 20) {
                        daño *= 2;
                        System.out.println("Golpe critico");
                    }

                    vida[enemigo][hEnemigo] -= daño;

                    System.out.println(nombres[jugador][hActual] + " ataca a " +
                            nombres[enemigo][hEnemigo] + " por " + daño);

                    break;

                case 2:
                    if (energia[jugador][hActual] >= 10) {

                        int dañoMag = magia[jugador][hActual];

                        int probM = (int) (Math.random() * 100);
                        if (probM < 20) {
                            dañoMag *= 2;
                            System.out.println("Golpe critico");
                        }

                        vida[enemigo][hEnemigo] -= dañoMag;
                        energia[jugador][hActual] -= 10;

                        System.out.println("Ataque magico por " + dañoMag);

                    } else {
                        System.out.println("No tienes energia suficiente");
                        continue;
                    }
                    break;

                case 3:
                    if (curaciones[jugador][hActual] < 2) {
                        vida[jugador][hActual] += 20;
                        curaciones[jugador][hActual]++;
                        System.out.println("Se cura +20 vida");
                    } else {
                        System.out.println("Ya no puedes curarte mas");
                        continue;
                    }
                    break;

                case 4:
                    int nuevo = elegirHeroe(sc, nombres, vivo, jugador);

                    if (jugador == 0) {
                        j1 = nuevo;
                    } else {
                        j2 = nuevo;
                    }

                    continue; 

                default:
                    continue;
            }

            if (vida[enemigo][hEnemigo] <= 0) {
                vida[enemigo][hEnemigo] = 0;
                vivo[enemigo][hEnemigo] = false;

                System.out.println(nombres[enemigo][hEnemigo] + " ha muerto");

                if (hayVivos(vivo, enemigo)) {
                    int nuevo = elegirHeroe(sc, nombres, vivo, enemigo);

                    if (enemigo == 0) {
                        j1 = nuevo;
                    } else {
                        j2 = nuevo;
                    }
                }
            }

            System.out.println("Vida enemigo: " + vida[enemigo][hEnemigo]);

            turno = (turno == 0) ? 1 : 0;
        }

        if (!hayVivos(vivo, 0)) {
            System.out.println("Gana Jugador 2");
        } else {
            System.out.println("Gana Jugador 1");
        }
    }

    public static int elegirHeroe(Scanner sc, String[][] nombres, boolean[][] vivo, int jugador) {

        int opcion;

        do {
            System.out.println("\nJugador " + (jugador + 1) + " elige heroe:");
            for (int i = 0; i < 3; i++) {
                System.out.println(i + ". " + nombres[jugador][i] +
                        (vivo[jugador][i] ? " (VIVO)" : " (MUERTO)"));
            }

            opcion = sc.nextInt();

            if (!vivo[jugador][opcion]) {
                System.out.println("No puedes elegir un heroe muerto");
            }

        } while (!vivo[jugador][opcion]);

        return opcion;
    }

    public static boolean hayVivos(boolean[][] vivo, int jugador) {
        for (int i = 0; i < 3; i++) {
            if (vivo[jugador][i]) return true;
        }
        return false;
    }
}
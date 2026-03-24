/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana8;

/**
 *
 * @author Ernesto Montalvo
 */
import java.util.Scanner;

public class Batalla_RPG {
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
            System.out.println("Registro Jugador " + (i + 1));
            for (int j = 0; j < 3; j++) {
                System.out.print("Nombre de héroe " + (j + 1) + ": ");
                nombres[i][j] = sc.next();

                System.out.print("Vida: ");
                vida[i][j] = sc.nextInt();

                System.out.print("Ataque: ");
                ataque[i][j] = sc.nextInt();

                System.out.print("Magia: ");
                magia[i][j] = sc.nextInt();

                System.out.print("Mana inicial: ");
                energia[i][j] = sc.nextInt();

                vivo[i][j] = true;
                curaciones[i][j] = 0;
            }
        }

        int jugador1_vivos = 3;
        int jugador2_vivos = 3;

        while (jugador1_vivos > 0 && jugador2_vivos > 0) {

            System.out.println("\nJugador 1 elige héroe (0-2): ");
            int c1 = sc.nextInt();

            if (!vivo[0][c1]) {
                System.out.println("Ese héroe está muerto");
                continue;
            }

            System.out.println("Jugador 2 elige héroe (0-2): ");
            int c2 = sc.nextInt();

            if (!vivo[1][c2]) {
                System.out.println("Ese héroe está muerto");
                continue;
            }

            while (vida[0][c1] > 0 && vida[1][c2] > 0) {

                System.out.println("\nTurno Jugador 1 (" + nombres[0][c1] + ")");
                System.out.println("1. Ataque físico");
                System.out.println("2. Ataque mágico");
                System.out.println("3. Curarse");
                System.out.println("4. Cambiar héroe");

                int opc1 = sc.nextInt();

                if (opc1 == 1) {
                    int daño = ataque[0][c1];

                    int prob = (int) (Math.random() * 100);
                    if (prob < 20) {
                        daño *= 2;
                        System.out.println("¡Golpe crítico!");
                    }

                    vida[1][c2] -= daño;
                    System.out.println("Daño: " + daño);
                }

                else if (opc1 == 2) {
                    if (energia[0][c1] >= 10) {
                        int daño = magia[0][c1];
                        energia[0][c1] -= 10;

                        vida[1][c2] -= daño;
                        System.out.println("Ataque mágico: " + daño);
                    } else {
                        System.out.println("Sin energía suficiente");
                        continue;
                    }
                }

                else if (opc1 == 3) {
                    if (curaciones[0][c1] < 2) {
                        vida[0][c1] += 20;
                        curaciones[0][c1]++;
                        System.out.println("Curación +20");
                    } else {
                        System.out.println("Límite de curaciones alcanzado");
                        continue;
                    }
                }

                else if (opc1 == 4) {
                    System.out.println("Elige otro héroe (0-2): ");
                    int nuevo = sc.nextInt();

                    if (vivo[0][nuevo]) {
                        c1 = nuevo;
                        System.out.println("Cambio realizado");
                    } else {
                        System.out.println("Héroe muerto");
                    }
                    continue;
                }

                if (vida[1][c2] <= 0) {
                    vida[1][c2] = 0;
                    vivo[1][c2] = false;
                    jugador2_vivos--;
                    System.out.println(nombres[1][c2] + " ha muerto");
                    break;
                }

                System.out.println("\nTurno Jugador 2 (" + nombres[1][c2] + ")");
                System.out.println("1. Ataque físico");
                System.out.println("2. Ataque mágico");
                System.out.println("3. Curarse");
                System.out.println("4. Cambiar héroe");

                int opc2 = sc.nextInt();

                if (opc2 == 1) {
                    int daño = ataque[1][c2];

                    int prob = (int) (Math.random() * 100);
                    if (prob < 20) {
                        daño *= 2;
                        System.out.println("¡Golpe crítico!");
                    }

                    vida[0][c1] -= daño;
                    System.out.println("Daño: " + daño);
                }

                else if (opc2 == 2) {
                    if (energia[1][c2] >= 10) {
                        int daño = magia[1][c2];
                        energia[1][c2] -= 10;

                        vida[0][c1] -= daño;
                        System.out.println("Ataque mágico: " + daño);
                    } else {
                        System.out.println("Sin energía suficiente");
                        continue;
                    }
                }

                else if (opc2 == 3) {
                    if (curaciones[1][c2] < 2) {
                        vida[1][c2] += 20;
                        curaciones[1][c2]++;
                        System.out.println("Curación +20");
                    } else {
                        System.out.println("Límite de curaciones alcanzado");
                        continue;
                    }
                }

                else if (opc2 == 4) {
                    System.out.println("Elige otro héroe (0-2): ");
                    int nuevo = sc.nextInt();

                    if (vivo[1][nuevo]) {
                        c2 = nuevo;
                        System.out.println("Cambio realizado");
                    } else {
                        System.out.println("Héroe muerto");
                    }
                    continue;
                }

                if (vida[0][c1] <= 0) {
                    vida[0][c1] = 0;
                    vivo[0][c1] = false;
                    jugador1_vivos--;
                    System.out.println(nombres[0][c1] + " ha muerto");
                    break;
                }
            }
        }

        if (jugador1_vivos > 0) {
            System.out.println("\nJugador 1 gana");
        } else {
            System.out.println("\nJugador 2 gana");
        }

        sc.close();
    }
}
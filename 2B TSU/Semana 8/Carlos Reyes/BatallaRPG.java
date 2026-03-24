/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package batallarpg;

import java.util.Scanner;

/**
 *
 * @author juanc
 */
public class BatallaRPG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];
        
        for (int i=0; i < 2; i++) {
            System.out.println("Jugador " + (i + 1));

            for (int j = 0; j < 3; j++) {
                System.out.print("Nombre del heroe " + (j + 1) + ": ");
                nombres[i][j] = sc.next();

                System.out.print("Vida: ");
                vida[i][j] = sc.nextInt();

                System.out.print("Ataque: ");
                ataque[i][j] = sc.nextInt();

                System.out.print("Magia: ");
                magia[i][j] = sc.nextInt();

                energia[i][j] = 50; // mana inicial
                vivo[i][j] = true;
                curaciones[i][j] = 0;
            }
        }

        int jugadorActual = 0;

        // BUCLE PRINCIPAL
        while (hayVivos(vivo, 0) && hayVivos(vivo, 1)) {

            int enemigo = (jugadorActual == 0) ? 1 : 0;

            System.out.println("\nTurno del Jugador " + (jugadorActual + 1));

            int heroe;
            do {
                mostrarHeroes(nombres, vida, vivo, jugadorActual);
                System.out.print("Elige heroe: ");
                heroe = sc.nextInt();
            } while (!vivo[jugadorActual][heroe]);

            System.out.println("1. Ataque físico");
            System.out.println("2. Ataque mágico");
            System.out.println("3. Curarse");
            System.out.println("4. Cambiar heroe");
            int opcion = sc.nextInt();

            int objetivo = 0;

            if (opcion == 1 || opcion == 2) {
                do {
                    mostrarHeroes(nombres, vida, vivo, enemigo);
                    System.out.print("Elige enemigo: ");
                    objetivo = sc.nextInt();
                } while (!vivo[enemigo][objetivo]);
            }

            int daño = 0;

            switch (opcion) {

                case 1: // ATAQUE FISICO
                    daño = ataque[jugadorActual][heroe];
                    daño = aplicarCritico(daño);

                    vida[enemigo][objetivo] -= daño;

                    System.out.println("Ataque físico de " + nombres[jugadorActual][heroe]);
                    break;

                case 2: // ATAQUE MAGICO
                    if (energia[jugadorActual][heroe] >= 10) {

                        daño = magia[jugadorActual][heroe];
                        daño = aplicarCritico(daño);

                        vida[enemigo][objetivo] -= daño;
                        energia[jugadorActual][heroe] -= 10;

                        System.out.println("Ataque mágico de " + nombres[jugadorActual][heroe]);

                    } else {
                        System.out.println("No hay suficiente energía");
                        continue;
                    }
                    break;

                case 3: // CURARSE
                    if (curaciones[jugadorActual][heroe] < 2) {
                        vida[jugadorActual][heroe] += 20;
                        curaciones[jugadorActual][heroe]++;
                        System.out.println("Se curó 20 puntos");
                    } else {
                        System.out.println("Ya no puede curarse");
                        continue;
                    }
                    break;

                case 4:
                    continue;
            }

            // RESULTADOS DEL ATAQUE
            if (opcion == 1 || opcion == 2) {
                if (vida[enemigo][objetivo] <= 0) {
                    vida[enemigo][objetivo] = 0;
                    vivo[enemigo][objetivo] = false;

                    System.out.println(nombres[enemigo][objetivo] + " ha muerto");
                } else {
                    System.out.println("Daño: " + daño);
                    System.out.println("Vida restante: " + vida[enemigo][objetivo]);
                }
            }

            jugadorActual = enemigo;
        }

        // GANADOR
        if (!hayVivos(vivo, 0)) {
            System.out.println("Gana Jugador 2");
        } else {
            System.out.println("Gana Jugador 1");
        }
    }

    // FUNCIONES

    public static boolean hayVivos(boolean[][] vivo, int jugador) {
        for (int i = 0; i < 3; i++) {
            if (vivo[jugador][i]) return true;
        }
        return false;
    }

    public static void mostrarHeroes(String[][] nombres, int[][] vida, boolean[][] vivo, int jugador) {
        for (int i = 0; i < 3; i++) {
            if (vivo[jugador][i]) {
                System.out.println(i + ". " + nombres[jugador][i] + " (HP: " + vida[jugador][i] + ")");
            }
        }
    }

    public static int aplicarCritico(int daño) {
        int prob = (int)(Math.random() * 100);

        if (prob < 20) {
            System.out.println("¡Golpe crítico!");
            daño *= 2;
        }

        return daño;
            

    }
    
}

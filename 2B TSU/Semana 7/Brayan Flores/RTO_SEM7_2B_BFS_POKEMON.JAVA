RTO_SEM7_2B_BFS_POKEMON
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemon.gpt;

import java.util.Scanner;

public class BatallaPokemon {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Arrays bidimensionales
        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];

        // REGISTRO DE CRIATURAS
        for (int j = 0; j < 2; j++) {
            System.out.println("Jugador " + (j + 1));

            for (int i = 0; i < 3; i++) {
                System.out.print("Nombre de la criatura " + (i + 1) + ": ");
                nombres[j][i] = sc.next();

                System.out.print("Vida (HP): ");
                vida[j][i] = sc.nextInt();

                System.out.print("Ataque: ");
                ataque[j][i] = sc.nextInt();
            }
        }

        // Criaturas activas
        int c1 = 0;
        int c2 = 0;

        // BATALLA
        while (c1 < 3 && c2 < 3) {

            System.out.println("\nJugador 1 elige criatura:");
            for (int i = 0; i < 3; i++) {
                if (vida[0][i] > 0) {
                    System.out.println(i + ". " + nombres[0][i] + " (HP: " + vida[0][i] + ")");
                }
            }
            c1 = sc.nextInt();

            System.out.println("\nJugador 2 elige criatura:");
            for (int i = 0; i < 3; i++) {
                if (vida[1][i] > 0) {
                    System.out.println(i + ". " + nombres[1][i] + " (HP: " + vida[1][i] + ")");
                }
            }
            c2 = sc.nextInt();

            // COMBATE ENTRE LAS DOS CRIATURAS
            while (vida[0][c1] > 0 && vida[1][c2] > 0) {

                // Turno Jugador 1
                System.out.println("\n" + nombres[0][c1] + " ataca!");
                vida[1][c2] -= ataque[0][c1];

                System.out.println(nombres[1][c2] + " pierde " + ataque[0][c1] + " de vida");
                System.out.println("Vida restante: " + vida[1][c2]);

                if (vida[1][c2] <= 0) {
                    System.out.println(nombres[1][c2] + " ha sido derrotado!");
                    break;
                }

                // Turno Jugador 2
                System.out.println("\n" + nombres[1][c2] + " ataca!");
                vida[0][c1] -= ataque[1][c2];

                System.out.println(nombres[0][c1] + " pierde " + ataque[1][c2] + " de vida");
                System.out.println("Vida restante: " + vida[0][c1]);

                if (vida[0][c1] <= 0) {
                    System.out.println(nombres[0][c1] + " ha sido derrotado!");
                    break;
                }
            }

            // Verificar si quedan criaturas
            boolean j1Vivo = false;
            boolean j2Vivo = false;

            for (int i = 0; i < 3; i++) {
                if (vida[0][i] > 0) j1Vivo = true;
                if (vida[1][i] > 0) j2Vivo = true;
            }

            if (!j1Vivo) {
                System.out.println("\nJugador 2 gana! ");
                System.out.println("SE AH GANADO UNAS PASTILLAS DE VIAGRA");
                break;
            }

            if (!j2Vivo) {
                System.out.println("\nJugador 1 gana!");
                System.out.println("SE AH GANADO UNAS PASTILLAS DE VIAGRA");
                break;
            }
        }

        sc.close();
    }
}
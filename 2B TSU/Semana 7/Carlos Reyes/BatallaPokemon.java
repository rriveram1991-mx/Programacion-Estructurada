/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package batalla.pokemon;

import java.util.Scanner;

/**
 *
 * @author juanc
 */
public class BatallaPokemon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // [jugador][criatura]
        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];

        // REGISTRO DE CRIATURAS
        for (int j = 0; j < 2; j++) {
            System.out.println("\n=== Registro Jugador " + (j + 1) + " ===");

            for (int i = 0; i < 3; i++) {
                System.out.print("Nombre del pokemon " + (i + 1) + ": ");
                nombres[j][i] = sc.nextLine();

                System.out.print("Vida (HP): ");
                vida[j][i] = sc.nextInt();

                System.out.print("Ataque: ");
                ataque[j][i] = sc.nextInt();
                sc.nextLine(); // limpiar buffer
            }
        }

        // Criaturas disponibles
        boolean[][] viva = new boolean[2][3];
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 3; i++) {
                viva[j][i] = true;
            }
        }

        int derrotadasJ1 = 0;
        int derrotadasJ2 = 0;

        // BATALLA PRINCIPAL
        while (derrotadasJ1 < 3 && derrotadasJ2 < 3) {

            // Selección jugador 1
            System.out.println("\nJugador 1, elige tu pokemon:");
            for (int i = 0; i < 3; i++) {
                if (viva[0][i]) {
                    System.out.println(i + " - " + nombres[0][i] + " (HP: " + vida[0][i] + ")");
                }
            }
            int c1 = sc.nextInt();

            // Selección jugador 2
            System.out.println("\nJugador 2, elige tu pokemon:");
            for (int i = 0; i < 3; i++) {
                if (viva[1][i]) {
                    System.out.println(i + " - " + nombres[1][i] + " (HP: " + vida[1][i] + ")");
                }
            }
            int c2 = sc.nextInt();

            System.out.println("\n¡Comienza la batalla!");

            // COMBATE ENTRE DOS CRIATURAS
            while (vida[0][c1] > 0 && vida[1][c2] > 0) {

                // Turno jugador 1
                System.out.println("\n" + nombres[0][c1] + " ataca!");
                vida[1][c2] -= ataque[0][c1];

                System.out.println(nombres[1][c2] + " pierde " + ataque[0][c1] + " de vida");
                System.out.println("Vida restante: " + vida[1][c2]);

                if (vida[1][c2] <= 0) {
                    System.out.println(nombres[1][c2] + " ha sido derrotado!");
                    viva[1][c2] = false;
                    derrotadasJ2++;
                    break;
                }

                // Turno jugador 2
                System.out.println("\n" + nombres[1][c2] + " ataca!");
                vida[0][c1] -= ataque[1][c2];

                System.out.println(nombres[0][c1] + " pierde " + ataque[1][c2] + " de vida");
                System.out.println("Vida restante: " + vida[0][c1]);

                if (vida[0][c1] <= 0) {
                    System.out.println(nombres[0][c1] + " ha sido derrotado!");
                    viva[0][c1] = false;
                    derrotadasJ1++;
                    break;
                }
            }
        }

        // RESULTADO FINAL
        if (derrotadasJ1 == 3) {
            System.out.println("\n🏆 ¡Jugador 2 gana!");
        } else {
            System.out.println("\n🏆 ¡Jugador 1 gana!");
        }
    }
}   
    
    


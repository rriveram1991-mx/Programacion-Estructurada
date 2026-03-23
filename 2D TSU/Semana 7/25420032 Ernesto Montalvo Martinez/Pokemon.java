/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana7;

import java.util.Scanner;

/**
 *
 * @author Ernesto Montalvo
 */
public class Pokemon {
    public static void main (String[]args){
        
    Scanner sc = new Scanner(System.in);

        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];

        for (int i = 0; i < 2; i++) {
            System.out.println("Registro Jugador " + (i + 1) + "");
            for (int j = 0; j < 3; j++) {
                System.out.print("Nombre de pokemon " + (j + 1) + ": ");
                nombres[i][j] = sc.next();
                System.out.print("Vida: ");
                vida[i][j] = sc.nextInt();
                System.out.print("Ataque: ");
                ataque[i][j] = sc.nextInt();
            }
        }
        int pokemonesj1 = 3;
        int pokemonesj2 = 3;

        while (pokemonesj1 > 0 && pokemonesj2 > 0) {

            System.out.println("\nJugador 1 elige pokemon (0-2): ");
            int c1 = sc.nextInt();
            System.out.println("Jugador 2 elige pokemon (0-2): ");
            int c2 = sc.nextInt();

            if (vida[0][c1] <= 0) {
                System.out.println("Pokemon derrotado");
                continue;
            }
            if (vida[1][c2] <= 0) {
                System.out.println("El pokemon ya ha sido derrotado");
                continue;
            }
            System.out.println("\n¡A pelear!");

            while (vida[0][c1] > 0 && vida[1][c2] > 0) {
                System.out.println(nombres[0][c1] + " ataca");
                vida[1][c2] -= ataque[0][c1];
                System.out.println(nombres[1][c2] + " pierde " + ataque[0][c1] + " de vida");
                System.out.println("Vida restante: " + vida[1][c2]);

                if (vida[1][c2] <= 0) {
                    System.out.println(nombres[1][c2] + " Derrotado");
                    pokemonesj2--;
                    break;
                }

                System.out.println(nombres[1][c2] + " Ataca");
                vida[0][c1] -= ataque[1][c2];
                System.out.println(nombres[0][c1] + " pierde " + ataque[1][c2] + " de vida");
                System.out.println("Vida restante: " + vida[0][c1]);

                if (vida[0][c1] <= 0) {
                    System.out.println(nombres[0][c1] + " Derrotado");
                    pokemonesj1--;
                    break;
                }
            }
        }

        if (pokemonesj1> 0) {
            System.out.println("\nJugador 1 gana!");
        } else {
            System.out.println("\nJugador 2 gana!");
        }

        sc.close();
    }
}
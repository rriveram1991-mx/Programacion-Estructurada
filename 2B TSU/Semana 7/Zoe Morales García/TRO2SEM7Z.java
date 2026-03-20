/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tro2sem7z;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class TRO2SEM7Z {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] nombres = new String[2][3];
        int[][][] stats = new int[2][3][2];
        for (int j = 0; j < 2; j++) {
            System.out.println("\n--- REGISTRO JUGADOR " + (j + 1) + " ---");
            for (int i = 0; i < 3; i++) {
                System.out.println("Pokémon " + (i + 1) + ":");
                System.out.print("  Nombre: "); nombres[j][i] = sc.next();
                System.out.print("  Vida: ");   stats[j][i][0] = sc.nextInt();
                System.out.print("  Ataque: "); stats[j][i][1] = sc.nextInt();
            }
        }


        System.out.print("\nJugador 1 elige su Pokémon (1, 2 o 3): ");
        int p1 = sc.nextInt() - 1; // Restamos 1 para que el "1" del usuario sea el "0" del array
        System.out.println("Jugador 1 elige: " + nombres[0][p1]);

        System.out.print("Jugador 2 elige su Pokémon (1, 2 o 3): ");
        int p2 = sc.nextInt() - 1;
        System.out.println("Jugador 2 elige: " + nombres[1][p2]);

        int derrotadosJ1 = 0, derrotadosJ2 = 0;
        int turno = 1;


        while (derrotadosJ1 < 3 && derrotadosJ2 < 3) {
            
            if (turno == 1) {
       
                System.out.println("\n" + nombres[0][p1] + " ataca!");
                stats[1][p2][0] -= stats[0][p1][1]; // Vida J2 -= Ataque J1
                
                System.out.println(nombres[1][p2] + " pierde " + stats[0][p1][1] + " de vida");
                System.out.println("Vida restante: " + (stats[1][p2][0] > 0 ? stats[1][p2][0] : 0));

                if (stats[1][p2][0] <= 0) {
                    System.out.println(nombres[1][p2] + " ha sido derrotado!");
                    derrotadosJ2++;
                    
                    if (derrotadosJ2 < 3) {
                        System.out.print("Jugador 2, elige tu próximo Pokémon (1, 2 o 3): ");
                        p2 = sc.nextInt() - 1;
                      
                        while (stats[1][p2][0] <= 0) {
                            System.out.print("Ese Pokémon ya no puede luchar. Elige otro: ");
                            p2 = sc.nextInt() - 1;
                        }
                        System.out.println("Jugador 2 elige: " + nombres[1][p2]);
                    }
                }
                turno = 2;

            } else {
                System.out.println("\n" + nombres[1][p2] + " ataca!");
                stats[0][p1][0] -= stats[1][p2][1]; 
                
                System.out.println(nombres[0][p1] + " pierde " + stats[1][p2][1] + " de vida");
                System.out.println("Vida restante: " + (stats[0][p1][0] > 0 ? stats[0][p1][0] : 0));

                if (stats[0][p1][0] <= 0) {
                    System.out.println(nombres[0][p1] + " ha sido derrotado!");
                    derrotadosJ1++;
                    
                    if (derrotadosJ1 < 3) {
                        System.out.print("Jugador 1, elige tu próximo Pokémon (1, 2 o 3): ");
                        p1 = sc.nextInt() - 1;
                        while (stats[0][p1][0] <= 0) {
                            System.out.print("Ese Pokémon ya no puede luchar. Elige otro: ");
                            p1 = sc.nextInt() - 1;
                        }
                        System.out.println("Jugador 1 elige: " + nombres[0][p1]);
                    }
                }
                turno = 1;
            }
        }
        System.out.println("\n-------------------------");
        if (derrotadosJ1 == 3) {
            System.out.println("¡Jugador 2 gana!");
            System.out.println("BIEN ECHO JUGAROR 2");
        } else {
            System.out.println("¡Jugador 1 gana!");
            System.out.println("BIEN ECHO JUGADOR 1");

        }
        System.out.println("-------------------------");
    }
}
    

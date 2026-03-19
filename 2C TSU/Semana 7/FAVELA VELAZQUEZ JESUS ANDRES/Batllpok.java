/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package batllpok;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Batllpok {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       Scanner scanner = new Scanner(System.in);
        // Arrays bidimensionales [Jugador][puchamon]
        String[][] nombres = new String[2][3];
        int[][] hp = new int[2][3];
        int[][] ataque = new int[2][3];

        // Registro de datos 
        for (int i = 0; i < 2; i++) {
            System.out.println("\nJugador " + (i + 1) + ", registra tus 3 puchamones:");
            for (int j = 0; j < 3; j++) {
                System.out.print("Nombre " + (j + 1) + ": ");
                nombres[i][j] = scanner.next();
                System.out.print("HP: ");
                hp[i][j] = scanner.nextInt();
                System.out.print("Ataque: ");
                ataque[i][j] = scanner.nextInt();
            }
        }

        // Selección inicial de criaturas
        System.out.println("\n=== INICIO DEL COMBATE ===");
        System.out.println("DARKAR, elige tu criatura puchamon (1, 2 o 3): ");
        int c1 = scanner.nextInt() - 1; // Restamos 1 para que coincida con el índice 0, 1, 2
        
        System.out.println("VAGINA, elige tu puchamon inicial (1, 2 o 3): "); //
        int c2 = scanner.nextInt() - 1;

        // Bucle principal de la batalla
        while (true) {
            System.out.println("\n" + nombres[0][c1] + " vs " + nombres[1][c2]);

            // Turno Jugador 1
            System.out.println("-> " + nombres[0][c1] + " ataca!");
            hp[1][c2] -= ataque[0][c1];
            
            // IF para decidir si el puchamon del J2 murió
            if (hp[1][c2] <= 0) {
                System.out.println("¡" + nombres[1][c2] + " ha sido derrotado!");
                
                // Verificar si al J2 le quedan otros puchamones vivos
                boolean alguienVivo = false;
                for(int k=0; k<3; k++) { if(hp[1][k] > 0) alguienVivo = true; }

                if (!alguienVivo) {
                    System.out.println("¡Jugador 2 no tiene más puchamones! GANA JUGADOR 1");
                    break; 
                }

                // Selección manual del siguiente puchamon
                System.out.println("Jugador 2, elige tu siguiente criatura:");
                for(int k=0; k<3; k++) {
                    if(hp[1][k] > 0) System.out.println(k+1 + ". " + nombres[1][k] + " (HP: " + hp[1][k] + ")");
                }
                c2 = scanner.nextInt() - 1;
                continue; // Reinicia el ciclo con el nuevo puchamon
            } else {
                System.out.println(nombres[1][c2] + " HP restante: " + hp[1][c2]);
            }

            // Turno Jugador 2
            System.out.println("-> " + nombres[1][c2] + " ataca!");
            hp[0][c1] -= ataque[1][c2];

            if (hp[0][c1] <= 0) {
                System.out.println("¡" + nombres[0][c1] + " ha sido derrotado!");
                
                boolean alguienVivo = false;
                for(int k=0; k<3; k++) { if(hp[0][k] > 0) alguienVivo = true; }

                if (!alguienVivo) {
                    System.out.println("¡Jugador 1 no tiene más puchamones! GANA JUGADOR 2");
                    break;
                }

                System.out.println("Jugador 1, elige tu siguiente puchamon:");
                for(int k=0; k<3; k++) {
                    if(hp[0][k] > 0) System.out.println(k+1 + ". " + nombres[0][k] + " (HP: " + hp[0][k] + ")");
                }
                c1 = scanner.nextInt() - 1;
            } else {
                System.out.println(nombres[0][c1] + " HP restante: " + hp[0][c1]);
            }
        }
        scanner.close();
    }
}   
        
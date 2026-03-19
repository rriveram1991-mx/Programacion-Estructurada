/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simuladorbatallasmejorado;

import java.util.Scanner;

/**
 *
 * @author miguelgu
 */
public class Simuladorbatallasmejorado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String nombres[][] = new String[2][3];
        int vida[][] = new int[2][3];
        int ataque[][] = new int[2][3];
        boolean derrotado[][] = new boolean[2][3];

        //aqui se hace el registro de los puchamones
        for (int j = 0; j < 2; j++) {
            System.out.println("===== Jugador " + (j + 1) + " =====");

            for (int i = 0; i < 3; i++) {
                System.out.print("Nombre del puchamon #" + (i + 1) + ": ");
                nombres[j][i] = input.nextLine();

                System.out.print("Vida: ");
                vida[j][i] = input.nextInt();

                System.out.print("Ataque: ");
                ataque[j][i] = input.nextInt();
                input.nextLine();

                derrotado[j][i] = false;
            }
        }

        // esta parte es para elegir el pokemon inicial
        System.out.println("\nJugador 1 elige su puchamon:");
        for (int i = 0; i < 3; i++) {
            System.out.println(i + ". " + nombres[0][i]);
        }
        int actual1 = input.nextInt();

        System.out.println("\nJugador 2 elige su puchamon:");
        for (int i = 0; i < 3; i++) {
            System.out.println(i + ". " + nombres[1][i]);
        }
        int actual2 = input.nextInt();

        while (true) {

            // se abre el menu para el jugador 1
            System.out.println("\n--- Turno Jugador 1 ---");
            System.out.println("1. Ataque normal");
            System.out.println("2. Ataque especial (doble daño)");
            System.out.println("3. Cambiar puchamon");
            int opcion1 = input.nextInt();

            if (opcion1 == 3) {
                System.out.println("Elige otro puchamon:");
                for (int i = 0; i < 3; i++) {
                    if (!derrotado[0][i]) {
                        System.out.println(i + ". " + nombres[0][i]);
                    }
                }
                actual1 = input.nextInt();
            } else {

                int daño = ataque[0][actual1];

                if (opcion1 == 2) {
                    daño = daño * 2;
                    System.out.println("==== ATAQUE ESPECIAL ====");
                }

                System.out.println(nombres[0][actual1] + " ataca!");
                vida[1][actual2] -= daño;

                System.out.println("Vida de " + nombres[1][actual2] + ": " + vida[1][actual2]);

                if (vida[1][actual2] <= 0) {
                    System.out.println(nombres[1][actual2] + " derrotado!");
                    derrotado[1][actual2] = true;
                }
            }

            // aqui se verifica para ver si el jugador 2 perdio
            int contador2 = 0;
            for (int i = 0; i < 3; i++) {
                if (derrotado[1][i]) {
                    contador2++;
                }
            }
            if (contador2 == 3) {
                System.out.println("\nJugador 1 gana!");
                break;
            }

            // aqui se despliega el menu para el jugador 2
            System.out.println("\n--- Turno Jugador 2 ---");
            System.out.println("1. Ataque normal");
            System.out.println("2. Ataque especial (doble daño)");
            System.out.println("3. Cambiar puchamon");
            int opcion2 = input.nextInt();

            if (opcion2 == 3) {
                System.out.println("Elige otro puchamon:");
                for (int i = 0; i < 3; i++) {
                    if (!derrotado[1][i]) {
                        System.out.println(i + ". " + nombres[1][i]);
                    }
                }
                actual2 = input.nextInt();
            } else {

                int daño = ataque[1][actual2];

                if (opcion2 == 2) {
                    daño = daño * 2;
                    System.out.println("=== ATAQUE ESPECIAL ===");
                }

                System.out.println(nombres[1][actual2] + " ataca!");
                vida[0][actual1] -= daño;

                System.out.println("Vida de " + nombres[0][actual1] + ": " + vida[0][actual1]);

                if (vida[0][actual1] <= 0) {
                    System.out.println(nombres[0][actual1] + " derrotado!");
                    derrotado[0][actual1] = true;
                }
            }

            // Aqui verifica si el jugador 1 perdio
            int contador1 = 0;
            for (int i = 0; i < 3; i++) {
                if (derrotado[0][i]) {
                    contador1++;
                }
            }
            if (contador1 == 3) {
                System.out.println("\nJugador 2 gana!");
                break;
            }
        }
    }
}
    
    


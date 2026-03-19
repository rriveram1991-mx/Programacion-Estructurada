/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemon;

import java.util.Scanner;

/**
 *
 * @author juang
 */
public class Pokemon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);

        // 1. Declaración de Arrays Bidimensionales
        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];

        System.out.println("--- REGISTRO DE CRIATURAS ---");

        // 2. Registro de datos con FOR
        for (int jugador = 0; jugador < 2; jugador++) {
            System.out.println("\nRegistro para el Jugador " + (jugador + 1) + ":");
            for (int criatura = 0; criatura < 3; criatura++) {
                System.out.print("Nombre criatura " + (criatura + 1) + ": ");
                nombres[jugador][criatura] = scanner.next();
                System.out.print("Vida (HP): ");
                vida[jugador][criatura] = scanner.nextInt();
                System.out.print("Ataque base: ");
                ataque[jugador][criatura] = scanner.nextInt();
            }
        }

        System.out.println("\n==================================");
        System.out.println("     ¡COMIENZA LA BATALLA!      ");
        System.out.println("==================================");

        // 3. Elección del Pokémon inicial (CON VALIDACIÓN)
        int actJ1;
        do {
            System.out.println("\nJugador 1, elige tu Pokémon inicial (1, 2 o 3): ");
            actJ1 = scanner.nextInt() - 1;
        } while (actJ1 < 0 || actJ1 > 2 || vida[0][actJ1] <= 0);
        
        int actJ2;
        do {
            System.out.println("Jugador 2, elige tu Pokémon inicial (1, 2 o 3): ");
            actJ2 = scanner.nextInt() - 1;
        } while (actJ2 < 0 || actJ2 > 2 || vida[1][actJ2] <= 0);

        boolean juegoTerminado = false;

        // 4. Ciclo WHILE principal para la batalla
        while (!juegoTerminado) {
            
            // ==========================================
            //           TURNO DEL JUGADOR 1
            // ==========================================
            System.out.println("\n--- TURNO JUGADOR 1 ---");
            System.out.println("En combate: " + nombres[0][actJ1] + " (HP: " + Math.max(0, vida[0][actJ1]) + ")");
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Atacar\n2. Cambiar de Pokémon");
            int accionJ1 = scanner.nextInt();

            if (accionJ1 == 1) {
                System.out.println("Elige tu ataque:");
                System.out.println("1. Ataque Normal (" + ataque[0][actJ1] + ")\n2. Ataque Fuerte (" + (ataque[0][actJ1] + 15) + ")");
                int tipoAtaque = scanner.nextInt();
                int danoJ1 = (tipoAtaque == 2) ? ataque[0][actJ1] + 15 : ataque[0][actJ1];
                if (tipoAtaque == 2) vida[0][actJ1] -= 5;

                System.out.println("\n¡" + nombres[0][actJ1] + " ataca!");
                vida[1][actJ2] -= danoJ1;
                System.out.println(nombres[1][actJ2] + " pierde " + danoJ1 + " de vida");

            } else if (accionJ1 == 2) {
                int nuevoJ1;
                do {
                    System.out.println("Elige un Pokémon vivo (1, 2 o 3): ");
                    for (int i = 0; i < 3; i++) {
                        if (vida[0][i] > 0) System.out.println((i + 1) + ". " + nombres[0][i] + " (HP: " + vida[0][i] + ")");
                    }
                    nuevoJ1 = scanner.nextInt() - 1;
                } while (vida[0][nuevoJ1] <= 0);
                actJ1 = nuevoJ1;
            }

            // Validar derrota J2
            if (vida[1][actJ2] <= 0) {
                System.out.println("\n¡" + nombres[1][actJ2] + " ha sido derrotado!");
                if (vida[1][0] <= 0 && vida[1][1] <= 0 && vida[1][2] <= 0) {
                    System.out.println("¡JUGADOR 1 GANA LA PARTIDA!");
                    juegoTerminado = true; break;
                }
                do {
                    System.out.println("Jugador 2, elige tu siguiente Pokémon (1, 2 o 3): ");
                    actJ2 = scanner.nextInt() - 1;
                } while (vida[1][actJ2] <= 0);
            }

            // ==========================================
            //           TURNO DEL JUGADOR 2
            // ==========================================
            if (!juegoTerminado) {
                System.out.println("\n--- TURNO JUGADOR 2 ---");
                System.out.println("En combate: " + nombres[1][actJ2] + " (HP: " + Math.max(0, vida[1][actJ2]) + ")");
                System.out.println("¿Qué deseas hacer?");
                System.out.println("1. Atacar\n2. Cambiar de Pokémon");
                int accionJ2 = scanner.nextInt();

                if (accionJ2 == 1) {
                    System.out.println("1. Normal (" + ataque[1][actJ2] + ")\n2. Fuerte (" + (ataque[1][actJ2] + 15) + ")");
                    int tipoAtaque2 = scanner.nextInt();
                    int danoJ2 = (tipoAtaque2 == 2) ? ataque[1][actJ2] + 15 : ataque[1][actJ2];
                    if (tipoAtaque2 == 2) vida[1][actJ2] -= 5;

                    System.out.println("\n¡" + nombres[1][actJ2] + " ataca!");
                    vida[0][actJ1] -= danoJ2;
                    System.out.println(nombres[0][actJ1] + " pierde " + danoJ2 + " de vida");

                } else if (accionJ2 == 2) {
                    int nuevoJ2;
                    do {
                        System.out.println("Elige un Pokémon vivo (1, 2 o 3): ");
                        for (int i = 0; i < 3; i++) {
                            if (vida[1][i] > 0) System.out.println((i + 1) + ". " + nombres[1][i] + " (HP: " + vida[1][i] + ")");
                        }
                        nuevoJ2 = scanner.nextInt() - 1;
                    } while (vida[1][nuevoJ2] <= 0);
                    actJ2 = nuevoJ2;
                }

                // Validar derrota J1
                if (vida[0][actJ1] <= 0) {
                    System.out.println("\n¡" + nombres[0][actJ1] + " ha sido derrotado!");
                    if (vida[0][0] <= 0 && vida[0][1] <= 0 && vida[0][2] <= 0) {
                        System.out.println("¡JUGADOR 2 GANA LA PARTIDA!");
                        juegoTerminado = true;
                    } else {
                        do {
                            System.out.println("Jugador 1, elige tu siguiente Pokémon (1, 2 o 3): ");
                            actJ1 = scanner.nextInt() - 1;
                        } while (vida[0][actJ1] <= 0);
                    }
                }
            }
        }
        scanner.close();
    }
}
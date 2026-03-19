/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen;

/**
 *
 * @author gl873
 */
import java.util.Scanner;

public class PokemonBatalla {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        
        String criaturas[][] = new String[2][3];
        int hp[][] = new int[2][3];
        int atk[][] = new int[2][3];

        int pociones[] = {2, 2}; // cada jugador tiene 2 pociones

        // REGISTRO
        for (int jugador = 0; jugador < 2; jugador++) {
            System.out.println("\nJugador " + (jugador + 1));

            for (int criatura = 0; criatura < 3; criatura++) {
                System.out.println("Criatura " + (criatura + 1));

                System.out.print("Nombre: ");
                criaturas[jugador][criatura] = leer.next();

                System.out.print("Vida: ");
                hp[jugador][criatura] = leer.nextInt();

                System.out.print("Ataque: ");
                atk[jugador][criatura] = leer.nextInt();
            }
        }

        int restantes1 = 3;
        int restantes2 = 3;

        // batalla principal
        while (restantes1 > 0 && restantes2 > 0) {

            System.out.println("\n--- SELECCION ---");

            System.out.println("Jugador 1 elige (0-2): ");
            int eleccion1 = leer.nextInt();

            System.out.println("Jugador 2 elige (0-2): ");
            int eleccion2 = leer.nextInt();

            // validar que no estén muertos
            if (hp[0][eleccion1] <= 0 || hp[1][eleccion2] <= 0) {
                System.out.println("Elegiste una criatura muerta, intenta otra.");
                continue;
            }

            // pelea
            while (hp[0][eleccion1] > 0 && hp[1][eleccion2] > 0) {

                // turno jugador 1
                System.out.println("\nTurno Jugador 1");
                System.out.println("1. Atacar");
                System.out.println("2. Poción");
                int opcion1 = leer.nextInt();

                if (opcion1 == 1) {
                    int daño = atk[0][eleccion1];

                    if (Math.random() < 0.2) {
                        daño *= 2;
                        System.out.println("¡Golpe crítico!");
                    }

                    hp[1][eleccion2] -= daño;
                    System.out.println(criaturas[0][eleccion1] + " hizo " + daño + " de daño");
                } else {
                    if (pociones[0] > 0) {
                        hp[0][eleccion1] += 10;
                        pociones[0]--;
                        System.out.println("Usaste poción (+10 vida)");
                    } else {
                        System.out.println("Ya no tienes pociones");
                    }
                }

                System.out.println("Vida rival: " + hp[1][eleccion2]);

                if (hp[1][eleccion2] <= 0) {
                    System.out.println(criaturas[1][eleccion2] + " fue derrotado");
                    restantes2--;
                    break;
                }

                // turno jugador 2
                System.out.println("\nTurno Jugador 2");
                System.out.println("1. Atacar");
                System.out.println("2. Poción");
                int opcion2 = leer.nextInt();

                if (opcion2 == 1) {
                    int daño = atk[1][eleccion2];

                    if (Math.random() < 0.2) {
                        daño *= 2;
                        System.out.println("¡Golpe crítico!");
                    }

                    hp[0][eleccion1] -= daño;
                    System.out.println(criaturas[1][eleccion2] + " hizo " + daño + " de daño");
                } else {
                    if (pociones[1] > 0) {
                        hp[1][eleccion2] += 10;
                        pociones[1]--;
                        System.out.println("Usaste poción (+10 vida)");
                    } else {
                        System.out.println("Ya no tienes pociones");
                    }
                }

                System.out.println("Vida rival: " + hp[0][eleccion1]);

                if (hp[0][eleccion1] <= 0) {
                    System.out.println(criaturas[0][eleccion1] + " fue derrotado");
                    restantes1--;
                    break;
                }
            }
        }

        // resultado final
        if (restantes1 > 0) {
            System.out.println("\nGana Jugador 1");
        } else {
            System.out.println("\nGana Jugador 2");
        }

      
    }
}
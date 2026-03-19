/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rto.pkg2.sem7.pkg2d.ezco;

import java.util.Scanner;

/**
 *
 * @author Zoé
 */
public class RTO2SEM72DEZCO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Scanner leer = new Scanner(System.in);

        // Arrays para almacenar nombres, vida y ataque de cada Pokémon
        String nombres[][] = new String[2][3]; // fila: jugador, columna: Pokémon
        int vida[][] = new int[2][3];         // vida de cada Pokémon
        int ataque[][] = new int[2][3];       // valor de ataque de cada Pokémon

        // MENÚ Y DAÑOS
        System.out.println("MENÚ DE ATAQUES");
        System.out.println("ATAQUE 1 = 9 DE DAÑO");
        System.out.println("ATAQUE 2 = 15 DE DAÑO");
        System.out.println("ATAQUE 3 = 19 DE DAÑO");
        System.out.println("ATAQUE 4 = 30 DE DAÑO");
        System.out.println("ATAQUE 5 = 45 DE DAÑO");
        System.out.println("PRESIONE ENTER PARA COMENZAR");
        leer.nextLine();
        // REGISTRO DE POKÉMONS
        for (int jugador = 0; jugador < 2; jugador++) {
            for (int criatura = 0; criatura < 3; criatura++) {
                System.out.println("TURNO DE JUGADOR " + (jugador + 1));
                System.out.println("Ingrese la criatura " + (criatura + 1) + ":");
                nombres[jugador][criatura] = leer.nextLine();

                System.out.println("Ingrese la vida de la criatura: (1-100) ");
                vida[jugador][criatura] = leer.nextInt();

                System.out.println("Ingrese el ataque que usará (1-5):");
                int opcion = leer.nextInt();
                // Asignamos el daño según el ataque elegido
                switch(opcion){
                    case 1: ataque[jugador][criatura] = 9; break;
                    case 2: ataque[jugador][criatura] = 15; break;
                    case 3: ataque[jugador][criatura] = 19; break;
                    case 4: ataque[jugador][criatura] = 30; break;
                    case 5: ataque[jugador][criatura] = 45; break;
                    default: ataque[jugador][criatura] = 10; // valor por defecto
                }
                leer.nextLine(); // Limpiamps el buffer
            }
        }
        // ESTADO DE LOS JUGADORES
        boolean jugador1tienepokemons = true;
        boolean jugador2tienepokemons = true;
        // BUCLE PRINCIPAL DE LA BATALLA
        while (jugador1tienepokemons && jugador2tienepokemons) {
            // JUGADOR 1 ELIGE POKÉMON
            System.out.println("\nTURNO DE JUGADOR 1 - Elige tu Pokémon:");
            for (int i = 0; i < 3; i++) {
                if (vida[0][i] > 0) { // mostramos solo Pokémon vivos
                    System.out.println(i + ": " + nombres[0][i] + " -- VIDA: " + vida[0][i]);
                }
            }
            int pokemon1 = leer.nextInt();
            // JUGADOR 2 ELIGE POKÉMON
            System.out.println("\nTURNO DE JUGADOR 2 - Elige tu Pokémon:");
            for (int i = 0; i < 3; i++) {
                if (vida[1][i] > 0) { // mostramos solo Pokémon vivos
                    System.out.println(i + ": " + nombres[1][i] + " -- VIDA: " + vida[1][i]);
                }
            }
            int pokemon2 = leer.nextInt();
            // BUCLE DE COMBATE ENTRE POKÉMON SELECCIONADOS
            while (vida[0][pokemon1] > 0 && vida[1][pokemon2] > 0) {

                //TURNO JUGADOR 1
                System.out.println("\nTURNO JUGADOR 1");
                System.out.println(nombres[0][pokemon1] + " ¡ATACA!");
                vida[1][pokemon2] -= ataque[0][pokemon1]; // restamos vida del oponente
                if (vida[1][pokemon2] < 0) vida[1][pokemon2] = 0; // evitar vida negativa
                System.out.println(nombres[1][pokemon2] + " PIERDE " + ataque[0][pokemon1] + " DE VIDA. Vida restante: " + vida[1][pokemon2]);
                if (vida[1][pokemon2] <= 0) { // si Pokémon 2 muere, termina el duelo
                    System.out.println(nombres[1][pokemon2] + " HA SIDO DERROTADO!");
                    break;
                }
                //TURNO JUGADOR 2
                System.out.println("\nTURNO JUGADOR 2");
                System.out.println(nombres[1][pokemon2] + " ¡ATACA!");
                vida[0][pokemon1] -= ataque[1][pokemon2]; // restamos vida del Pokémon 1
                if (vida[0][pokemon1] < 0) vida[0][pokemon1] = 0;
                System.out.println(nombres[0][pokemon1] + " PIERDE " + ataque[1][pokemon2] + " DE VIDA. Vida restante: " + vida[0][pokemon1]);

                if (vida[0][pokemon1] <= 0) { // si Pokémon 1 muere, termina el duelo
                    System.out.println(nombres[0][pokemon1] + " HA SIDO DERROTADO!");
                    break;
                }
            }
            // revisamos si los jugadores todavía tienen pokemons vivos
            jugador1tienepokemons = false;
            jugador2tienepokemons = false;
            for (int i = 0; i < 3; i++) {
                if (vida[0][i] > 0) jugador1tienepokemons = true;
                if (vida[1][i] > 0) jugador2tienepokemons = true;
            }
        }
        // declaramos un ganador
        if (jugador1tienepokemons) {
            System.out.println("\n¡JUGADOR 1 GANA LA BATALLA!");
        } else {
            System.out.println("\n¡JUGADOR 2 GANA LA BATALLA!");
        }
        leer.close();
    }
}
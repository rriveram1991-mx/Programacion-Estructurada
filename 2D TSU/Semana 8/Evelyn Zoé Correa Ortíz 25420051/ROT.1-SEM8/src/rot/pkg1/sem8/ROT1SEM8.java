/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rot.pkg1.sem8;

import java.util.Scanner;

/**
 *
 * @author Zoé
 */
public class ROT1SEM8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        // Arrays para almacenar nombres, vida y ataque de cada Pokémon
        String nombres[][] = new String[2][3];
        int vida[][] = new int[2][3];
        int ataque[][] = new int[2][3];
        int magia[][] = new int [2][3];
        int energia [][]=new int [2][3];
        boolean vivo [][] = new boolean[2][3];
        int curaciones[][] = new int [2][3];

        // MENÚ ORIGINAL (NO SE TOCA)
        System.out.println("MENÚ DE ATAQUES");
        System.out.println("ATAQUE 1 = 9 DE DAÑO");
        System.out.println("ATAQUE 2 = 15 DE DAÑO");
        System.out.println("ATAQUE 3 = 19 DE DAÑO");
        System.out.println("ATAQUE 4 = 30 DE DAÑO");
        System.out.println("ATAQUE 5 = 45 DE DAÑO");
        System.out.println("PRESIONE ENTER PARA COMENZAR");
        leer.nextLine();
        for (int jugador = 0; jugador < 2; jugador++) {
            for (int criatura = 0; criatura < 3; criatura++) {
                System.out.println("TURNO DE JUGADOR " + (jugador + 1));
                System.out.println("Ingrese la criatura " + (criatura + 1) + ":");
                nombres[jugador][criatura] = leer.nextLine();
                System.out.println("Ingrese la vida:");
                vida[jugador][criatura] = leer.nextInt();
                System.out.println("Ingrese ataque (1-5):");
                int opcion = leer.nextInt();
                // convierte opción a daño real
                switch(opcion){
                    case 1: ataque[jugador][criatura] = 9; break;
                    case 2: ataque[jugador][criatura] = 15; break;
                    case 3: ataque[jugador][criatura] = 19; break;
                    case 4: ataque[jugador][criatura] = 30; break;
                    case 5: ataque[jugador][criatura] = 45; break;
                }
                //  ataque más fuerte que el normal
                magia[jugador][criatura] = ataque[jugador][criatura] + 10;

                // limita usar magia (para que no spamees magia)
                energia[jugador][criatura] = 30;

                // vivo = controla si el personaje sigue en juego
                vivo[jugador][criatura] = true;
                
                // curaciones = contador para limitar cuántas veces se cura
                curaciones[jugador][criatura] = 0;
               leer.nextLine();
            }
        }
        // ESTADO DE LOS JUGADORES
        boolean jugador1tienepokemons = true;
        boolean jugador2tienepokemons = true;
        while (jugador1tienepokemons && jugador2tienepokemons) {
            System.out.println("TURNO DE JUGADOR 1 - Elige tu Pokémon:");
            for (int i = 0; i < 3; i++) {
                // solo muestra los que siguen vivos
                if (vivo[0][i]) {
                    System.out.println(i + ": " + nombres[0][i] + " VIDA: " + vida[0][i]);
                }
            }
            int pokemon1 = leer.nextInt();
            // evita usar muertos → si está muerto, lo obliga a elegir otro
            while (!vivo[0][pokemon1]) {
                System.out.println("Ese Pokémon está muerto, elige otro:");
                pokemon1 = leer.nextInt();
            }
            System.out.println("\nTURNO DE JUGADOR 2 - Elige tu Pokémon:");
            for (int i = 0; i < 3; i++) {
                if (vivo[1][i]) {
                    System.out.println(i + ": " + nombres[1][i] + " VIDA: " + vida[1][i]);
                }
            }
            int pokemon2 = leer.nextInt();
            while (!vivo[1][pokemon2]) {
                System.out.println("Ese Pokémon está muerto, elige otro:");
                pokemon2 = leer.nextInt();
            }
            while (vida[0][pokemon1] > 0 && vida[1][pokemon2] > 0) {
                System.out.println("\n1. Ataque físico  2. Ataque mágico  3. Curarse");
                int opcion = leer.nextInt();
                if (opcion == 1) {
                    // usa daño base
                    int daño = ataque[0][pokemon1];
                    // probabilidad de crítico
                    int prob = (int)(Math.random() * 100);
                    if (prob < 20) {
                        // lógica: duplica daño → golpe fuerte aleatorio
                        daño *= 2;
                        System.out.println("¡GOLPE CRÍTICO!");
                    }
                    // resta vida al enemigo
                    vida[1][pokemon2] -= daño;
                    System.out.println("Daño hecho: " + daño);
                }
                else if (opcion == 2) {
                    // solo si tiene energía
                    if (energia[0][pokemon1] >= 10) {
                        int daño = magia[0][pokemon1];
                        int prob = (int)(Math.random() * 100);
                        if (prob < 20) {
                            daño *= 2;
                            System.out.println("¡GOLPE CRÍTICO!");
                        }
                        vida[1][pokemon2] -= daño;
                        // consume energía, limita uso
                        energia[0][pokemon1] -= 10;
                        System.out.println("Daño mágico: " + daño);
                    } else {
                        // si no tiene energía no hace nada
                        System.out.println("No tienes energía");
                        continue;
                    }
                }
                else if (opcion == 3) {
                    // máximo 2 curaciones
                    if (curaciones[0][pokemon1] < 2) {
                        vida[0][pokemon1] += 20;
                        // guarda cuántas veces ya se curó
                        curaciones[0][pokemon1]++;
                        System.out.println("Te curaste 20 de vida");
                    } else {
                        System.out.println("Ya no puedes curarte");
                        continue;
                    }
                }
                if (vida[1][pokemon2] <= 0) {
                    // evita negativos
                    vida[1][pokemon2] = 0;
                    // lo marca como muerto → desaparece del juego
                    vivo[1][pokemon2] = false;
                    System.out.println(nombres[1][pokemon2] + " HA SIDO DERROTADO!");
                    break;
                }
                System.out.println("Vida restante enemigo: " + vida[1][pokemon2]);
                int daño = ataque[1][pokemon2];
                int prob = (int)(Math.random() * 100);
                if (prob < 20) {
                    daño *= 2;
                    System.out.println("CRÍTICO ENEMIGO!");
                }
                vida[0][pokemon1] -= daño;
                if (vida[0][pokemon1] <= 0) {
                    vida[0][pokemon1] = 0;
                    vivo[0][pokemon1] = false;
                    System.out.println(nombres[0][pokemon1] + " HA SIDO DERROTADO!");
                    break;
                }

                System.out.println("Tu vida restante: " + vida[0][pokemon1]);
            }
            // reinicia en falso
            jugador1tienepokemons = false;
            jugador2tienepokemons = false;

            //si encuentra uno vivo → vuelve true
            for (int i = 0; i < 3; i++) {
                if (vivo[0][i]) jugador1tienepokemons = true;
                if (vivo[1][i]) jugador2tienepokemons = true;
            }
        }

        if (jugador1tienepokemons) {
            System.out.println("\n¡JUGADOR 1 GANA LA BATALLA!");
        } else {
            System.out.println("\n¡JUGADOR 2 GANA LA BATALLA!");
        }

        leer.close();
    }
}
    
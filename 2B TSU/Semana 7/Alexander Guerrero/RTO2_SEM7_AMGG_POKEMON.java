/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rto.pkg2_sem7_amgg_pokemon;

import java.util.Scanner;

/**
 *
 * @author Lex
 */
public class RTO2_SEM7_AMGG_POKEMON {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner leer = new Scanner(System.in);

        String[][] Criaturas = new String[2][3];
        int[][][] stats = new int[2][3][2]; // [jugador][criatura][0:vida, 1:ataque]
        int selcriat, conti = 2, j, c;
        
        // Índices para saber qué criatura está peleando actualmente por cada jugador
        int[] indexActivo = {0, 0}; 

        // 1. Registro de datos (Tu código original)
        for (j = 0; j < 2; j++) {
            System.out.println("\n--- Jugador #" + (j + 1) + " ---");
            for (c = 0; c < 3; c++) {
                System.out.print("Nombre del pokemon " + (c + 1) + ": ");
                Criaturas[j][c] = leer.next();
                System.out.print("Vida de " + Criaturas[j][c] + ": ");
                stats[j][c][0] = leer.nextInt();
                System.out.print("Ataque de " + Criaturas[j][c] + ": ");
                stats[j][c][1] = leer.nextInt();
            }
        }

        // 2. Selección inicial de criaturas
        for (j = 0; j < 2; j++) {
            System.out.println("\nJugador " + (j + 1) + ", elija su pokemon inicial (0, 1 o 2):");
            for (int i = 0; i < 3; i++) {
                System.out.println(i + ". " + Criaturas[j][i] + " (HP: " + stats[j][i][0] + ")");
            }
            indexActivo[j] = leer.nextInt();
        }

        // 3. Bucle de Batalla
        do {
            int c1 = indexActivo[0]; // Pokemon actual J1
            int c2 = indexActivo[1]; // Pokemon actual J2

            System.out.println("\n--- ¡ENFRENTAMIENTO! ---");
            System.out.println(Criaturas[0][c1] + " (J1) vs " + Criaturas[1][c2] + " (J2)");

            // Ambos se atacan al mismo tiempo
            stats[1][c2][0] -= stats[0][c1][1]; // J1 ataca a J2
            stats[0][c1][0] -= stats[1][c2][1]; // J2 ataca a J1

            System.out.println(Criaturas[0][c1] + " queda con " + Math.max(0, stats[0][c1][0]) + " de vida.");
            System.out.println(Criaturas[1][c2] + " queda con " + Math.max(0, stats[1][c2][0]) + " de vida.");

            // Revisar si alguien murió o si quieren continuar
            System.out.println("\n¿Desean continuar la batalla? SI(2) | RENDIRSE(1)");
            conti = leer.nextInt();

            if (conti == 2) {
                // Opción para que cada jugador cambie si su criatura murió o si quiere otra
                for (j = 0; j < 2; j++) {
                    if (stats[j][indexActivo[j]][0] <= 0) {
                        System.out.println("\n¡El pokemon del Jugador " + (j + 1) + " ha muerto! DEBE elegir otra.");
                        seleccionarNueva(j, Criaturas, stats, indexActivo, leer);
                    } else {
                        System.out.println("\nJugador " + (j + 1) + ", ¿Quieres cambiar de pokemon? SI(1) | NO(2)");
                        selcriat = leer.nextInt();
                        if (selcriat == 1) {
                            seleccionarNueva(j, Criaturas, stats, indexActivo, leer);
                        }
                    }
                }
            }

            // Condición de victoria: si alguien se queda sin criaturas vivas
            if (stats[0][0][0] <= 0 && stats[0][1][0] <= 0 && stats[0][2][0] <= 0) {
                System.out.println("¡Jugador 1 ya no tiene pokemones! Ganador Jugador 2.");
                conti = 1;
            } else if (stats[1][0][0] <= 0 && stats[1][1][0] <= 0 && stats[1][2][0] <= 0) {
                System.out.println("¡Jugador 2 ya no tiene pokemones! Ganador Jugador 1.");
                conti = 1;
            }

        } while (conti != 1);

        System.out.println("--- FIN DEL JUEGO ---");
    
    }

    private static void seleccionarNueva(int j, String[][] Criaturas, int[][][] stats, int[] indexActivo, Scanner leer) {
        System.out.println("\nElija nueva criatura para el Jugador " + (j + 1) + ":");
        for (int i = 0; i < 3; i++) {
            // Mostramos si está vivo o muerto
            String estado = (stats[j][i][0] > 0) ? "HP: " + stats[j][i][0] : "SIN VIDA";
            System.out.println(i + ". " + Criaturas[j][i] + " (" + estado + ")");
        }
    
        int seleccion = leer.nextInt();
    
        // Validamos que la selección sea válida (0, 1 o 2) y que tenga vida
        if (seleccion >= 0 && seleccion < 3 && stats[j][seleccion][0] > 0) {
            indexActivo[j] = seleccion;
            System.out.println("¡" + Criaturas[j][seleccion] + " entra al combate!");
        } else {
            System.out.println("Selección no válida o criatura sin vida. Se mantiene la anterior si es posible.");
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package batallapokemon;

import java.util.Scanner;

/**
 *
 * @author brand
 */
public class BatallaPokemon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // ===== CATÁLOGO =====
        String[] listaNombres = {"Pikachu", "Charizar", "Bulbasor", "Squirt", "Gengon", "Mewton"};
        int[] listaHP = {100, 150, 120, 130, 90, 200};
        int[] listaATQ = {30, 40, 25, 28, 45, 50};

        // ===== DATOS JUGADORES =====
        String[][] equipoNombre = new String[2][3];
        int[][] equipoHP = new int[2][3];
        int[][] equipoATQ = new int[2][3];

        // ===== SELECCIÓN DE EQUIPO =====
        for (int jugador = 0; jugador < 2; jugador++) {

            System.out.println("\n=== JUGADOR " + (jugador + 1) + " ELIGE SUS PUCHAMONES ===");

            for (int i = 0; i < listaNombres.length; i++) {
                System.out.println(i + " - " + listaNombres[i] + " (HP: " + listaHP[i] + ", ATQ: " + listaATQ[i] + ")");
            }

            for (int j = 0; j < 3; j++) {
                System.out.print("Selecciona puchamon " + (j + 1) + ": ");
                int opcion = entrada.nextInt();

                equipoNombre[jugador][j] = listaNombres[opcion];
                equipoHP[jugador][j] = listaHP[opcion];
                equipoATQ[jugador][j] = listaATQ[opcion];
            }
        }

        int caidosJ1 = 0;
        int caidosJ2 = 0;

        // ===== COMBATE GENERAL =====
        while (caidosJ1 < 3 && caidosJ2 < 3) {

            // ===== ELECCIÓN JUGADOR 1 =====
            System.out.println("\nJugador 1 elige puchamon:");
            for (int i = 0; i < 3; i++) {
                if (equipoHP[0][i] > 0) {
                    System.out.println(i + " - " + equipoNombre[0][i] + " (HP: " + equipoHP[0][i] + ")");
                } else {
                    System.out.println(i + " - " + equipoNombre[0][i] + " (DERROTADO)");
                }
            }

            int sel1 = entrada.nextInt();

            if (equipoHP[0][sel1] <= 0) {
                System.out.println("Ese puchamon ya está derrotado");
                continue;
            }

            // ===== ELECCIÓN JUGADOR 2 =====
            System.out.println("\nJugador 2 elige puchamon:");
            for (int i = 0; i < 3; i++) {
                if (equipoHP[1][i] > 0) {
                    System.out.println(i + " - " + equipoNombre[1][i] + " (HP: " + equipoHP[1][i] + ")");
                } else {
                    System.out.println(i + " - " + equipoNombre[1][i] + " (DERROTADO)");
                }
            }

            int sel2 = entrada.nextInt();

            if (equipoHP[1][sel2] <= 0) {
                System.out.println("Ese puchamon ya está derrotado");
                continue;
            }

            System.out.println("\n=== BATALLA ===");
            System.out.println(equipoNombre[0][sel1] + " VS " + equipoNombre[1][sel2]);

            // ===== PELEA POR TURNOS =====
            while (equipoHP[0][sel1] > 0 && equipoHP[1][sel2] > 0) {

                // Turno J1
                equipoHP[1][sel2] -= equipoATQ[0][sel1];

                if (equipoHP[1][sel2] < 0) equipoHP[1][sel2] = 0;

                System.out.println("\n" + equipoNombre[0][sel1] + " ataca!");
                System.out.println("Daño: " + equipoATQ[0][sel1]);
                System.out.println("Vida restante de " + equipoNombre[1][sel2] + ": " + equipoHP[1][sel2]);

                if (equipoHP[1][sel2] <= 0) {
                    System.out.println(equipoNombre[1][sel2] + " ha sido derrotado!");
                    caidosJ2++;
                    break;
                }

                // Turno J2
                equipoHP[0][sel1] -= equipoATQ[1][sel2];

                if (equipoHP[0][sel1] < 0) equipoHP[0][sel1] = 0;

                System.out.println("\n" + equipoNombre[1][sel2] + " ataca!");
                System.out.println("Daño: " + equipoATQ[1][sel2]);
                System.out.println("Vida restante de " + equipoNombre[0][sel1] + ": " + equipoHP[0][sel1]);

                if (equipoHP[0][sel1] <= 0) {
                    System.out.println(equipoNombre[0][sel1] + " ha sido derrotado!");
                    caidosJ1++;
                    break;
                }
            }
        }

        // ===== GANADOR =====
        if (caidosJ1 == 3) {
            System.out.println("JUGADOR 2 GANA");
        } else {
            System.out.println("JUGADOR 1 GANA");
        }
    }
}

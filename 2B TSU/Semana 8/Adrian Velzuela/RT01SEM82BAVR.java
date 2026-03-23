/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication49;

import java.util.Scanner;

/**
 *
 * @author adrianvalenzuelaramirez
 */
public class JavaApplication49 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        // Datos: [Jugador][Criatura]
        String[][] nom = new String[2][3];
        int[][] hpMax = new int[2][3]; // Guardamos la vida inicial para la barra
        int[][] hpAct = new int[2][3]; // Vida actual
        int[][] atk = new int[2][3];
        boolean[][] der = new boolean[2][3];

        // 1. REGISTRO ESTILIZADO
        System.out.println("========================================");
        System.out.println("   CONFIGURACIÓN DE BATALLA POKÉMON     ");
        System.out.println("========================================");

        for (int j = 0; j < 2; j++) {
            System.out.println("\n>>> ENTRENADOR " + (j + 1));
            for (int c = 0; c < 3; c++) {
                System.out.print("Nombre (" + (c + 1) + "): ");
                nom[j][c] = sn.next();
                System.out.print("Vida: ");
                hpMax[j][c] = sn.nextInt();
                hpAct[j][c] = hpMax[j][c];
                System.out.print("Ataque: ");
                atk[j][c] = sn.nextInt();
            }
        }

        int d1 = 0, d2 = 0;

        // 2. CICLO DE BATALLA
        while (d1 < 3 && d2 < 3) {
            int e1 = elegir(sn, nom, der, hpAct, hpMax, 0);
            int e2 = elegir(sn, nom, der, hpAct, hpMax, 1);

            System.out.println("\n\n\n\n\n\n\n\n\n\n"); // "Limpiar" consola
            System.out.println("¡" + nom[0][e1] + " VS " + nom[1][e2] + "!");

            while (hpAct[0][e1] > 0 && hpAct[1][e2] > 0) {
                // Turno Jugador 1
                atacar(nom[0][e1], nom[1][e2], atk[0][e1], hpAct, 1, e2, hpMax[1][e2]);
                if (hpAct[1][e2] <= 0) { der[1][e2] = true; d2++; break; }
                
                dormir(800); // Pausa para realismo

                // Turno Jugador 2
                atacar(nom[1][e2], nom[0][e1], atk[1][e2], hpAct, 0, e1, hpMax[0][e1]);
                if (hpAct[0][e1] <= 0) { der[0][e1] = true; d1++; break; }
                
                dormir(800);
            }
        }

        System.out.println("\n========================================");
        System.out.println(d2 == 3 ? "   ¡EL JUGADOR 1 ES EL CAMPEÓN!   " : "   ¡EL JUGADOR 2 ES EL CAMPEÓN!   ");
        System.out.println("========================================");
    }

    // Dibuja una barra de vida: [████░░░░] 50/100
    public static void imprimirBarra(String nombre, int actual, int max) {
        int porcentaje = (int) (((double) actual / max) * 20);
        if (porcentaje < 0) porcentaje = 0;
        
        String color = (actual > max * 0.5) ? "\u001B[32m" : (actual > max * 0.2) ? "\u001B[33m" : "\u001B[31m";
        String reset = "\u001B[0m";

        System.out.print(nombre + " [" + color);
        for (int i = 0; i < 20; i++) {
            if (i < porcentaje) System.out.print("█");
            else System.out.print("░");
        }
        System.out.println(reset + "] " + Math.max(0, actual) + "/" + max);
    }

    public static void atacar(String atacante, String victima, int daño, int[][] hp, int jV, int cV, int maxV) {
        System.out.println("\n" + atacante + " lanza un ataque feroz!");
        hp[jV][cV] -= daño;
        imprimirBarra(victima, hp[jV][cV], maxV);
    }

    public static int elegir(Scanner sn, String[][] n, boolean[][] d, int[][] h, int[][] m, int j) {
        while (true) {
            System.out.println("\n--- EQUIPO J" + (j + 1) + " ---");
            for (int i = 0; i < 3; i++) {
                if (!d[j][i]) imprimirBarra((i+1) + ". " + n[j][i], h[j][i], m[j][i]);
                else System.out.println((i+1) + ". [DERROTADO]");
            }
            System.out.print("Elige Pokémon: ");
            int s = sn.nextInt() - 1;
            if (s >= 0 && s < 3 && !d[j][s]) return s;
            System.out.println("No disponible.");
        }
    }

    public static void dormir(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rto.pkg1.sem8.pkg2b;

import java.util.Scanner;

/**
 *
 * @author lopez
 */
public class RTO1SEM82B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Scanner lr = new Scanner(System.in);

        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];

       
        for (int i = 0; i < 2; i++) {
            System.out.println("\n--- REGISTRO JUGADOR " + (i + 1) + " ---");
            for (int j = 0; j < 3; j++) {
                System.out.print("Nombre del heroe " + (j + 1) + ": ");
                nombres[i][j] = lr.next();
                vida[i][j] = 100; 
                ataque[i][j] = 15 + (int)(Math.random() * 10);
                magia[i][j] = 25 + (int)(Math.random() * 15);
                energia[i][j] = 30;  
                vivo[i][j] = true;
                curaciones[i][j] = 0;
            }
        }

        int turnoJugador = 0; 
        while (quedanVivos(vivo, 0) && quedanVivos(vivo, 1)) {
            int rival = (turnoJugador == 0) ? 1 : 0;
            
            System.out.println("\n===============================");
            System.out.println("TURNO DEL JUGADOR " + (turnoJugador + 1));
            System.out.println("===============================");

            
            int hSel = elegirHeroe(nombres, vivo, turnoJugador, lr);
            
            boolean turnoTerminado = false;
            while (!turnoTerminado) {
                System.out.println("\nHeroe: " + nombres[turnoJugador][hSel] + " (HP: " + vida[turnoJugador][hSel] + " | MP: " + energia[turnoJugador][hSel] + ")");
                System.out.println("1. Ataque Físico | 2. Magia (10 MP) | 3. Curarse (" + (2-curaciones[turnoJugador][hSel]) + " restantes) | 4. Cambiar Heroe");
                int opcion = lr.nextInt();

                switch (opcion) {
                    case 1:
                        int hEnemigo = elegirObjetivo(nombres, vivo, rival, lr);
                        ejecutarAtaque(nombres, ataque, vida, vivo, turnoJugador, hSel, rival, hEnemigo, false);
                        turnoTerminado = true;
                        break;

                    case 2: 
                        if (energia[turnoJugador][hSel] >= 10) {
                            int hEnemigoMag = elegirObjetivo(nombres, vivo, rival, lr);
                            ejecutarAtaque(nombres, magia, vida, vivo, turnoJugador, hSel, rival, hEnemigoMag, true);
                            energia[turnoJugador][hSel] -= 10;
                            turnoTerminado = true;
                        } else {
                            System.out.println("¡No tienes suficiente energia!");
                        }
                        break;

                    case 3: 
                        if (curaciones[turnoJugador][hSel] < 2) {
                            vida[turnoJugador][hSel] += 20;
                            curaciones[turnoJugador][hSel]++;
                            System.out.println(nombres[turnoJugador][hSel] + " se curo 20 HP. Total: " + vida[turnoJugador][hSel]);
                            turnoTerminado = true;
                        } else {
                            System.out.println("Ya no puedes curarte mas con este heroe.");
                        }
                        break;

                    case 4: 
                        hSel = elegirHeroe(nombres, vivo, turnoJugador, lr);
                        break;
                }
            }

            
            turnoJugador = rival;
        }

        
        if (quedanVivos(vivo, 0)) System.out.println("\n EL JUGADOR 1 HA GANADO LA BATALLA!");
        else System.out.println("\n EL JUGADOR 2 HA GANADO LA BATALLA!");
    }

    

    public static boolean quedanVivos(boolean[][] vivo, int jugador) {
        return vivo[jugador][0] || vivo[jugador][1] || vivo[jugador][2];
    }

    public static int elegirHeroe(String[][] nombres, boolean[][] vivo, int jugador, Scanner sc) {
        int eleccion;
        while (true) {
            System.out.println("Elige tu heroe:");
            for (int i = 0; i < 3; i++) {
                if (vivo[jugador][i]) System.out.println(i + ". " + nombres[jugador][i]);
            }
            eleccion = sc.nextInt();
            if (eleccion >= 0 && eleccion < 3 && vivo[jugador][eleccion]) return eleccion;
            System.out.println("Selección invalida.");
        }
    }

    public static int elegirObjetivo(String[][] nombres, boolean[][] vivo, int rival, Scanner sc) {
        int eleccion;
        while (true) {
            System.out.println("Elige objetivo enemigo:");
            for (int i = 0; i < 3; i++) {
                if (vivo[rival][i]) System.out.println(i + ". " + nombres[rival][i]);
            }
            eleccion = sc.nextInt();
            if (eleccion >= 0 && eleccion < 3 && vivo[rival][eleccion]) return eleccion;
            System.out.println("Objetivo no valido.");
        }
    }

    public static void ejecutarAtaque(String[][] nombres, int[][] poder, int[][] vida, boolean[][] vivo, int jAtaca, int hAtaca, int jDefiende, int hDefiende, boolean esMagia) {
        int dano = poder[jAtaca][hAtaca];
        
       
        if ((int)(Math.random() * 100) < 20) {
            dano *= 2;
            System.out.println("¡GOLPE CRITICO!");
        }

        vida[jDefiende][hDefiende] -= dano;
        System.out.println(nombres[jAtaca][hAtaca] + (esMagia ? " lanza un hechizo a " : " ataca a ") + nombres[jDefiende][hDefiende] + " causando " + dano + " de daño.");

        if (vida[jDefiende][hDefiende] <= 0) {
            vida[jDefiende][hDefiende] = 0;
            vivo[jDefiende][hDefiende] = false;
            System.out.println("¡" + nombres[jDefiende][hDefiende] + " ha muerto!");
        } else {
            System.out.println("Vida restante de " + nombres[jDefiende][hDefiende] + ": " + vida[jDefiende][hDefiende]);
        }
    }
}

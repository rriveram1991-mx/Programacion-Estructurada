/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rto1sem8;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class RTO1SEM8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];
        
        for (int i = 0; i < 2; i++) {
            System.out.println("Jugador " + (i + 1));

            for (int j = 0; j < 3; j++) {
                System.out.print("Nombre : "); nombres[i][j] = sc.next();
                System.out.print("Vida: "); vida[i][j] = sc.nextInt();
                System.out.print("Ataque: "); ataque[i][j] = sc.nextInt();
                System.out.print("Magia: "); magia[i][j] = sc.nextInt();
                System.out.print("Energia inicial: "); energia[i][j] = sc.nextInt();
                vivo[i][j] = true;
                curaciones[i][j] = 0;
            }
        }
        
        int turno = 0;
        boolean j1_vivos = true;
        boolean j2_vivos = true;
        while (j1_vivos && j2_vivos) {
            int jugador = turno % 2;
            int enemigo = (jugador == 0) ? 1 : 0;
            System.out.println("\nTurno Jugador " + (jugador + 1));
            for (int i = 0; i < 3; i++) {
                if (vivo[jugador][i]) {
                    System.out.println(i + ". " + nombres[jugador][i] + " (Vida: " + vida[jugador][i] + ")");
                } else {
                    System.out.println(i + ". " + nombres[jugador][i] + " (MUERTO)");
                }
            }
            int heroe = sc.nextInt();
            while (vivo[jugador][heroe] == false) {
                System.out.println("Muerto, elige otro:");
                heroe = sc.nextInt();
            }
            System.out.println("1. Ataque fisico");
            System.out.println("2. Ataque magico");
            System.out.println("3. Curarse");
            System.out.println("4. Cambiar ");
            int opcion = sc.nextInt();
            if (opcion == 4) {
                turno++;
                continue;
            }
            for (int i = 0; i < 3; i++) {
                if (vivo[enemigo][i]) {
                    System.out.println(i + ". " + nombres[enemigo][i] + " (Vida: " + vida[enemigo][i] + ")");
                } else {
                    System.out.println(i + ". " + nombres[enemigo][i] + " (MUERTO)");
                }
            }
            int objetivo = sc.nextInt();
            while (vivo[enemigo][objetivo] == false) {
                System.out.println("Enemigo muerto, elige otro:");
                objetivo = sc.nextInt();
            }

            int daño = 0;
            
            if (opcion == 1) {
                daño = ataque[jugador][heroe];
            } if (opcion == 2) {
                if (energia[jugador][heroe] >= 10) {
                    daño = magia[jugador][heroe];
                    energia[jugador][heroe] -= 10;
                } else {
                    System.out.println("Sin energia");
                    continue;
                }
            } if (opcion == 3) {
                if (curaciones[jugador][heroe] < 2) {
                    vida[jugador][heroe] += 20;
                    curaciones[jugador][heroe]++;
                    System.out.println("Se curo +20");
                } else {
                    System.out.println("No puedes curarte más");
                }
                turno++;
                continue;
            }

            int prob = (int)(Math.random() * 100);
            if (prob < 20) {
                daño *= 2;
                System.out.println("¡Golpe crítico!");
            }
            vida[enemigo][objetivo] -= daño;
            System.out.println("Daño: " + daño);
            if (vida[enemigo][objetivo] <= 0) {
                vida[enemigo][objetivo] = 0;
                vivo[enemigo][objetivo] = false;
                System.out.println("Murio " + nombres[enemigo][objetivo]);
            } else {
                System.out.println("Vida restante: " + vida[enemigo][objetivo]);
            }

            turno++;
            j1_vivos = false;
            j2_vivos = false;
            for (int i = 0; i < 3; i++) {
                if (vivo[0][i]) j1_vivos = true;
                if (vivo[1][i]) j2_vivos = true;
            }
        }

        if (!j1_vivos) {
            System.out.println("Gana Jugador 2");
        } else {
            System.out.println("Gana Jugador 1");
        }

    }
}

       


    

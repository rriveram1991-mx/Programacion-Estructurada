/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package batallarpg.rto.pkg1.sem8;

import java.util.Scanner;

/**
 *
 * @author jasun
 */
public class BatallaRPGRTO1SEM8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] jugadores = new String[2];
        String[][] heroes = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];

        for (int i = 0; i < 2; i++) {
            System.out.print("\nNombre jugador " + (i + 1) + ": ");
            jugadores[i] = sc.next();

            System.out.println("Registre sus 3 heroes:");
            for (int j = 0; j < 3; j++) {
                System.out.print("Nombre de heroe #" + (j + 1) + ": ");
                heroes[i][j] = sc.next();

                System.out.print("Vida de "+(heroes[i][j]));
                vida[i][j] = sc.nextInt();
                while (vida[i][j]<0) {
                    System.out.println("Error, vida negativa, ingresela de nuevo:");
                    vida[i][j]=sc.nextInt();
                }

                System.out.print("Ataque fisico de "+(heroes[i][j]));
                ataque[i][j] = sc.nextInt();
                while (ataque[i][j]<0) {
                    System.out.println("Error, ataque negativa, ingreselo de nuevo:");
                    ataque[i][j]=sc.nextInt();
                }

                System.out.print("Ataque magico de "+(heroes[i][j]));
                magia[i][j] = sc.nextInt();
                while (magia[i][j]<0) {
                    System.out.println("Error, magia negativa, ingresela de nuevo:");
                    magia[i][j]=sc.nextInt();
                }

                System.out.print("Energia de "+(heroes[i][j]));
                energia[i][j] = sc.nextInt();
                while (energia[i][j]<0) {
                    System.out.println("Error, energia negativa, ingresela de nuevo:");
                    energia[i][j]=sc.nextInt();
                }

                vivo[i][j] = true;
                curaciones[i][j] = 0;
            }
        }

        int turno = 0;

        while (true) {

            int jugador = turno % 2;
            int enemigo = (jugador == 0) ? 1 : 0;

            System.out.println("\n===== TURNO DE " + jugadores[jugador] + " =====");

            boolean accionRealizada = false;

            while (!accionRealizada) {

                System.out.println("Heroes disponibles:");
                for (int j = 0; j < 3; j++) {
                    if (vivo[jugador][j]) {
                        System.out.println((j + 1) + ". " + heroes[jugador][j] + " (Vida: " + vida[jugador][j] + ")");
                    }
                }

                System.out.print("Elige tu heroe: ");
                int hJugador = sc.nextInt() - 1;

                if (hJugador < 0 || hJugador >= 3 || !vivo[jugador][hJugador]) {
                    System.out.println("Heroe invalido");
                    continue;
                }

                System.out.println("Acciones:");
                System.out.println("1. Ataque fisico");
                System.out.println("2. Ataque magico");
                System.out.println("3. Curarse");
                System.out.println("4. Cambiar heroe");

                int accion = sc.nextInt();

                switch (accion) {

                    case 1:
                        System.out.println("A quién atacar?");
                        for (int j = 0; j < 3; j++) {
                            if (vivo[enemigo][j]) {
                                System.out.println((j + 1) + ". " + heroes[enemigo][j] + " (Vida: " + vida[enemigo][j] + ")");
                            }
                        }

                        int hEnemigo = sc.nextInt() - 1;

                        if (!vivo[enemigo][hEnemigo]) {
                            System.out.println("Enemigo invalido");
                            continue;
                        }

                        int daño = ataque[jugador][hJugador];

                        if (Math.random() * 100 < 20) {
                            daño *= 2;
                            System.out.println("Golpe critico!");
                        }

                        vida[enemigo][hEnemigo] -= daño;

                        System.out.println(heroes[jugador][hJugador] + " hizo " + daño +
                                " a " + heroes[enemigo][hEnemigo]);

                        if (vida[enemigo][hEnemigo] <= 0) {
                            vida[enemigo][hEnemigo] = 0;
                            vivo[enemigo][hEnemigo] = false;
                            System.out.println(heroes[enemigo][hEnemigo] + " ha muerto!");
                        } else {
                            System.out.println("Vida restante: " + vida[enemigo][hEnemigo]);
                        }

                        accionRealizada = true;
                        break;

                    case 2:
                        if (energia[jugador][hJugador] >= 10) {

                            System.out.println("A quien atacar con magia?");
                            for (int j = 0; j < 3; j++) {
                                if (vivo[enemigo][j]) {
                                    System.out.println((j + 1) + ". " + heroes[enemigo][j] + " (Vida: " + vida[enemigo][j] + ")");
                                }
                            }

                            int hEnemigo2 = sc.nextInt() - 1;

                            if (!vivo[enemigo][hEnemigo2]) {
                                System.out.println("Enemigo invalido");
                                continue;
                            }

                            int dañoMagico = magia[jugador][hJugador];

                            if (Math.random() * 100 < 20) {
                                dañoMagico *= 2;
                                System.out.println("Golpe critico!");
                            }

                            energia[jugador][hJugador] -= 10;
                            vida[enemigo][hEnemigo2] -= dañoMagico;

                            System.out.println(heroes[jugador][hJugador] +
                                    " hizo " + dañoMagico +
                                    " de daño magico a " + heroes[enemigo][hEnemigo2]);

                            if (vida[enemigo][hEnemigo2] <= 0) {
                                vida[enemigo][hEnemigo2] = 0;
                                vivo[enemigo][hEnemigo2] = false;
                                System.out.println(heroes[enemigo][hEnemigo2] + " ha muerto!");
                            } else {
                                System.out.println("Vida restante: " + vida[enemigo][hEnemigo2]);
                            }

                            accionRealizada = true;

                        } else {
                            System.out.println("No hay energia suficiente");
                        }
                        break;

                    case 3:
                        if (curaciones[jugador][hJugador] < 2) {
                            vida[jugador][hJugador] += 20;
                            curaciones[jugador][hJugador]++;
                            System.out.println("Se curO +20 (Usos: " + curaciones[jugador][hJugador] + "/2)");
                            accionRealizada = true;
                        } else {
                            System.out.println("No puedes curarte más de 2 veces");
                        }
                        break;

                    case 4:
                        System.out.println("Cambio de heroe...");
                        break;

                    default:
                        System.out.println("Opcion invalida");
                }
            }

            boolean enemigoVivo = false;
            for (int j = 0; j < 3; j++) {
                if (vivo[enemigo][j]) {
                    enemigoVivo = true;
                    break;
                }
            }

            if (!enemigoVivo) {
                System.out.println("\nGANA " + jugadores[jugador]);
                break;
            }

            turno++;
        }
    }
}
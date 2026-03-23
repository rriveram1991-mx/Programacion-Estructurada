/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rto.pkg1.sem8.pkg2e.agfl;
import java.util.Scanner;
/**
 *
 * @author gl873
 */
public class RTO1SEM82EAGFL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);

        String nombres[][] = new String[2][3];
        int vida[][] = new int[2][3];
        int ataque[][] = new int[2][3];
        int magia[][] = new int[2][3];
        int energia[][] = new int[2][3];
        boolean vivo[][] = new boolean[2][3];
        int curaciones[][] = new int[2][3];
        
        for (int j = 0; j < 2; j++) {
            System.out.println("\nJugador " + (j + 1));

            for (int i = 0; i < 3; i++) {
                System.out.println("Heroe " + (i + 1));

                System.out.print("Nombre: ");
                nombres[j][i] = leer.next();

                System.out.print("Vida: ");
                vida[j][i] = leer.nextInt();

                System.out.print("Ataque: ");
                ataque[j][i] = leer.nextInt();

                System.out.print("Magia: ");
                magia[j][i] = leer.nextInt();

                System.out.print("Energia: ");
                energia[j][i] = leer.nextInt();

                vivo[j][i] = true;
                curaciones[j][i] = 0;
            }
        }  
        while (true) {

            boolean j1 = false;
            boolean j2 = false;

            for (int i = 0; i < 3; i++) {
                if (vivo[0][i]) j1 = true;
                if (vivo[1][i]) j2 = true;
            }

            if (!j1 || !j2) break;

            System.out.println("\nJugador 1 elige (0-2): ");
            int h1 = leer.nextInt();

            if (!vivo[0][h1]) {
                System.out.println("Ese heroe esta muerto");
                continue;
            }

            System.out.println("Jugador 2 elige (0-2): ");
            int h2 = leer.nextInt();

            if (!vivo[1][h2]) {
                System.out.println("Ese heroe esta muerto");
                continue;
            }

            while (vida[0][h1] > 0 && vida[1][h2] > 0) {

                System.out.println("\nTurno J1 - " + nombres[0][h1]);
                System.out.println("1. Fisico  2. Magico  3. Curar  4. Cambiar");
                int op = leer.nextInt();

                if (op == 1) {
                    int daño = ataque[0][h1];

                    if ((int)(Math.random()*100) < 20) {
                        daño *= 2;
                        System.out.println("Critico!");
                    }

                    vida[1][h2] -= daño;
                    System.out.println("Daño: " + daño);

                } else if (op == 2) {

                    if (energia[0][h1] >= 10) {
                        int daño = magia[0][h1];

                        if ((int)(Math.random()*100) < 20) {
                            daño *= 2;
                            System.out.println("Critico!");
                        }

                        vida[1][h2] -= daño;
                        energia[0][h1] -= 10;

                    } else {
                        System.out.println("Sin energia");
                        continue;
                    }

                } else if (op == 3) {

                    if (curaciones[0][h1] < 2) {
                        vida[0][h1] += 20;
                        curaciones[0][h1]++;
                        System.out.println("Te curaste");
                    } else {
                        System.out.println("Ya no puedes curarte");
                        continue;
                    }

                } else if (op == 4) {
                    System.out.println("Nuevo heroe:");
                    h1 = leer.nextInt();
                    continue;
                }

                if (vida[1][h2] <= 0) {
                    vida[1][h2] = 0;
                    vivo[1][h2] = false;
                    System.out.println("Murio " + nombres[1][h2]);
                    break;
                }

                System.out.println("Vida enemigo: " + vida[1][h2]);

                
                System.out.println("\nTurno J2 - " + nombres[1][h2]);
                System.out.println("1. Fisico  2. Magico  3. Curar  4. Cambiar");
                op = leer.nextInt();

                if (op == 1) {
                    int daño = ataque[1][h2];

                    if ((int)(Math.random()*100) < 20) {
                        daño *= 2;
                        System.out.println("Critico!");
                    }

                    vida[0][h1] -= daño;

                } else if (op == 2) {

                    if (energia[1][h2] >= 10) {
                        int daño = magia[1][h2];

                        if ((int)(Math.random()*100) < 20) {
                            daño *= 2;
                            System.out.println("Critico!");
                        }

                        vida[0][h1] -= daño;
                        energia[1][h2] -= 10;

                    } else {
                        System.out.println("Sin energia");
                        continue;
                    }

                } else if (op == 3) {

                    if (curaciones[1][h2] < 2) {
                        vida[1][h2] += 20;
                        curaciones[1][h2]++;
                    } else {
                        System.out.println("Ya no puedes curarte");
                        continue;
                    }

                } else if (op == 4) {
                    System.out.println("Nuevo heroe:");
                    h2 = leer.nextInt();
                    continue;
                }

                if (vida[0][h1] <= 0) {
                    vida[0][h1] = 0;
                    vivo[0][h1] = false;
                    System.out.println("Murio " + nombres[0][h1]);
                    break;
                }

                System.out.println("Vida enemigo: " + vida[0][h1]);
            }
        }

        System.out.println("\nFIN DEL JUEGO");
    }
}
    
    


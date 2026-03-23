/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rto.pkg1sem8.pkg2d.sra;

import java.util.Scanner;

/**
 *
 * @author crist
 */
public class RTO1SEM82DSRA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 


   
        Scanner leer = new Scanner(System.in);

        String[][] nombres = new String[2][3];   //Aqui lo que hago es definir varias matrices que es del nombre vida ataque etc.. para que se guarde los datos de los jugadores
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];

        // Aqui registro los heroes osea el nombre de los usuarios los datos.
        for (int i = 0; i < 2; i++) {
            System.out.println("Jugador " + (i + 1));
            for (int j = 0; j < 3; j++) {
                System.out.print("Nombre del héroe " + (j + 1) + ": ");
                nombres[i][j] = leer.next();

                System.out.print("Vida: ");
                vida[i][j] = leer.nextInt();

                System.out.print("Ataque: ");
                ataque[i][j] = leer.nextInt();

                System.out.print("Magia: ");
                magia[i][j] = leer.nextInt();

                System.out.print("Energía: ");
                energia[i][j] = leer.nextInt();

                vivo[i][j] = true;
                curaciones[i][j] = 0;
            }
        }
//Esto me funciona para que no se repita las preguntas de arriba.
        int turno = 0;

      //uso el while para que se repita mientras ambos jugadores tengan al menos un héroe vivo.
        while (tieneVivos(vivo, 0) && tieneVivos(vivo, 1)) {

            int jugador = turno % 2;
            int enemigo = (jugador == 0) ? 1 : 0;

            System.out.println("Turno del Jugador " + (jugador + 1));

            int h;
            do {
                System.out.println("Elige tu héroe:");
                for (int i = 0; i < 3; i++) {
                    if (vivo[jugador][i]) {
                        System.out.println(i + " - " + nombres[jugador][i] + " (Vida: " + vida[jugador][i] + ")");
                    }
                }
                h = leer.nextInt();
            } while (!vivo[jugador][h]);

    
            int e;
            do {
                System.out.println("Elige enemigo:");
                for (int i = 0; i < 3; i++) {
                    if (vivo[enemigo][i]) {
                        System.out.println(i + " - " + nombres[enemigo][i] + " (Vida: " + vida[enemigo][i] + ")");
                    }
                }
                e = leer.nextInt();
            } while (!vivo[enemigo][e]);

           //Aqui seleccionan 
            System.out.println("1. Ataque físico");
            System.out.println("2. Ataque mágico");
            System.out.println("3. Curarse");
            System.out.println("4. Cambiar héroe");

            int opcion = leer.nextInt();

            int daño;

            switch (opcion) {

                case 1:
                    daño = ataque[jugador][h];

                    if (critico()) {
                        daño *= 2;
                        System.out.println("¡Golpe crítico!");
                    }

                    vida[enemigo][e] -= daño;

                    System.out.println(nombres[jugador][h] + " ataca a " + nombres[enemigo][e]);
                    System.out.println("Daño: " + daño);

                    break;

                case 2: 
                    if (energia[jugador][h] >= 10) {

                        daño = magia[jugador][h];

                        if (critico()) {
                            daño *= 2;
                            System.out.println("¡Golpe crítico!");
                        }

                        vida[enemigo][e] -= daño;
                        energia[jugador][h] -= 10;

                        System.out.println("Ataque mágico usado");
                        System.out.println("Daño: " + daño);

                    } else {
                        System.out.println("No hay suficiente energía");
                        continue;
                    }
                    break;

                case 3: 
                    if (curaciones[jugador][h] < 2) {
                        vida[jugador][h] += 20;
                        curaciones[jugador][h]++;
                        System.out.println("Se curó 20 puntos");
                    } else {
                        System.out.println("Ya no puedes curarte más");
                        continue;
                    }
                    break;

                case 4:
                    System.out.println("Cambio de héroe");
                    continue;

                default:
                    System.out.println("Opción inválida");
                    continue;
            }

            
            if (vida[enemigo][e] <= 0) {
                vida[enemigo][e] = 0;
                vivo[enemigo][e] = false;
                System.out.println(nombres[enemigo][e] + " ha muerto");
            } else {
                System.out.println("Vida restante: " + vida[enemigo][e]);
            }

            turno++;
        }

       
        if (!tieneVivos(vivo, 0)) {
            System.out.println("¡Jugador 2 gana!");
        } else {
            System.out.println("¡Jugador 1 gana!");
        }

      
    }

    public static boolean tieneVivos(boolean[][] vivo, int jugador) {
        for (int i = 0; i < 3; i++) {
            if (vivo[jugador][i]) {
                return true;
            }
        }
        return false;
    }

    
    public static boolean critico() {
        int prob = (int)(Math.random() * 100);
        return prob < 20;
    }
}
    //conclusion:
//En este programa hice un pequeño juego por turnos donde dos jugadores usan heroes con habilidades diferentes Use matrices para 
//guardar la información de cada personaje y estructuras como ciclos y condiciones para controlar el juego.

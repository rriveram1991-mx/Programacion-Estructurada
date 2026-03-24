/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rpg;

import java.util.Scanner;

/**
 *
 * @author juang
 */
public class Rpg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner sc = new Scanner(System.in);

        //  CREACION DE MATRICES 
        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];

        System.out.println("=== BATALLA RPG ===");
        
        // INGRESO MANUAL DE DATOS POR JUGADOR 
        for (int i = 0; i < 2; i++) {
            System.out.println("\nREGISTRO DEL JUGADOR " + (i + 1));
            for (int j = 0; j < 3; j++) {
                System.out.println("\nDatos del Heroe " + (j + 1) + ":");
                
                System.out.print("Nombre: ");
                nombres[i][j] = sc.next();
                
                System.out.print("Vida: ");
                vida[i][j] = sc.nextInt();
                
                System.out.print("Ataque fisico: ");
                ataque[i][j] = sc.nextInt();
                
                System.out.print("Ataque magico: ");
                magia[i][j] = sc.nextInt();
                
                System.out.print("Energia inicial: ");
                energia[i][j] = sc.nextInt();
                
                // Asignacion por defecto
                vivo[i][j] = true;
                curaciones[i][j] = 0;
            }
        }

        System.out.println("\nRegistro completo. Iniciando combate...");
        System.out.println("\n=== INICIO DE LA BATALLA ===");

        boolean jugador1_tiene_vivos = true;
        boolean jugador2_tiene_vivos = true;
        int turnoActual = 0; 
        int[] heroeActivo = {0, 0}; 

        // CICLO PRINCIPAL DE BATALLA 
        while (jugador1_tiene_vivos && jugador2_tiene_vivos) {
            int enemigo = (turnoActual == 0) ? 1 : 0;

            // Validacion de heroe activo muerto
            if (!vivo[turnoActual][heroeActivo[turnoActual]]) {
                System.out.println("\n[!] Jugador " + (turnoActual + 1) + ", tu heroe activo murio. Selecciona otro.");
                boolean seleccionValida = false;
                while (!seleccionValida) {
                    System.out.println("Heroes disponibles:");
                    for (int i = 0; i < 3; i++) {
                        if (vivo[turnoActual][i]) {
                            System.out.println(i + ": " + nombres[turnoActual][i] + " (Vida: " + vida[turnoActual][i] + ")");
                        }
                    }
                    int seleccion = sc.nextInt();
                    if (seleccion >= 0 && seleccion < 3 && vivo[turnoActual][seleccion]) {
                        heroeActivo[turnoActual] = seleccion;
                        seleccionValida = true;
                    } else {
                        System.out.println("Opcion no valida o heroe muerto.");
                    }
                }
            }

            int hA = heroeActivo[turnoActual]; 
            int hE = heroeActivo[enemigo];     
            boolean accionRealizada = false;

            while (!accionRealizada) {
                System.out.println("\n--- TURNO JUGADOR " + (turnoActual + 1) + " ---");
                System.out.println("Heroe: " + nombres[turnoActual][hA] + " | HP: " + vida[turnoActual][hA] + " | Energia: " + energia[turnoActual][hA]);
                System.out.println("Rival: " + nombres[enemigo][hE] + " | HP: " + vida[enemigo][hE]);
                System.out.println("1. Ataque fisico\n2. Ataque magico\n3. Curarse\n4. Cambiar heroe");
                System.out.print("Opcion: ");
                
                int opcion = sc.nextInt();
                int danio = 0;

                switch (opcion) {
                    case 1:
                        danio = ataque[turnoActual][hA];
                        // Evento aleatorio critico
                        if ((int)(Math.random() * 100) < 20) {
                            danio *= 2;
                            System.out.println("¡GOLPE CRITICO!");
                        }
                        vida[enemigo][hE] -= danio;
                        System.out.println(nombres[turnoActual][hA] + " hace " + danio + " de danio fisico.");
                        accionRealizada = true;
                        break;

                    case 2:
                        if (energia[turnoActual][hA] >= 10) {
                            energia[turnoActual][hA] -= 10;
                            danio = magia[turnoActual][hA];
                            if ((int)(Math.random() * 100) < 20) {
                                danio *= 2;
                                System.out.println("¡CRITICO MAGICO!");
                            }
                            vida[enemigo][hE] -= danio;
                            System.out.println(nombres[turnoActual][hA] + " usa magia y hace " + danio + " de danio.");
                            accionRealizada = true;
                        } else {
                            System.out.println("Energia insuficiente.");
                        }
                        break;

                    case 3:
                        if (curaciones[turnoActual][hA] < 2) {
                            vida[turnoActual][hA] += 20;
                            curaciones[turnoActual][hA]++;
                            System.out.println(nombres[turnoActual][hA] + " recupera 20 de vida.");
                            accionRealizada = true;
                        } else {
                            System.out.println("Limite de curaciones alcanzado.");
                        }
                        break;

                    case 4:
                        System.out.println("Selecciona heroe vivo:");
                        for (int i = 0; i < 3; i++) {
                            if (vivo[turnoActual][i] && i != hA) {
                                System.out.println(i + ": " + nombres[turnoActual][i] + " (Vida: " + vida[turnoActual][i] + ")");
                            }
                        }
                        int nuevo = sc.nextInt();
                        if (nuevo >= 0 && nuevo < 3 && vivo[turnoActual][nuevo] && nuevo != hA) {
                            heroeActivo[turnoActual] = nuevo;
                            hA = heroeActivo[turnoActual];
                            System.out.println("Cambiando a " + nombres[turnoActual][hA]);
                        } else {
                            System.out.println("Cambio no permitido.");
                        }
                        break;

                    default:
                        System.out.println("Opcion invalida.");
                }
            }

            //SISTEMA DE MUERTE 
            if (vida[enemigo][hE] <= 0) {
                vida[enemigo][hE] = 0;
                vivo[enemigo][hE] = false;
                System.out.println("Muerte: " + nombres[enemigo][hE] + " ha sido eliminado.");
            }

            // Comprobar estado de los jugadores
            jugador1_tiene_vivos = vivo[0][0] || vivo[0][1] || vivo[0][2];
            jugador2_tiene_vivos = vivo[1][0] || vivo[1][1] || vivo[1][2];

            // Alternar turno
     if (turnoActual == 0) {
                turnoActual = 1;
            } else {
                turnoActual = 0;
            }
        }

        // --- 5. CONDICION DE VICTORIA ---
        System.out.println("\n------------------------------------------");
        if (!jugador1_tiene_vivos) {
            System.out.println("RESULTADO: EL JUGADOR 2 GANA LA PARTIDA");
        } else {
            System.out.println("RESULTADO: EL JUGADOR 1 GANA LA PARTIDA");
        }
        System.out.println("------------------------------------------");

        sc.close();
    }
    
}
    

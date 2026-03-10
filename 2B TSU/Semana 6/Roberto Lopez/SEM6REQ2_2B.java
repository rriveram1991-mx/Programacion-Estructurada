/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sem6req2_2b;

import java.util.Scanner;

/**
 *
 * @author lopez
 */
public class SEM6REQ2_2B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
              Scanner sc = new Scanner(System.in);
        
        char[][] park = new char[4][5];
        
       
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                park[i][j] = 'L';
            }
        }

        System.out.println("--- SISTEMA DE ESTACIONAMIENTO ---");
       
        imprimirMapa(park);

        
        System.out.println("\nSeleccione coordenadas para estacionar:");
        System.out.print("Fila (0-3): ");
        int f = sc.nextInt();
        System.out.print("Columna (0-4): ");
        int c = sc.nextInt();

        
        if (f >= 0 && f < 4 && c >= 0 && c < 5) {
            if (park[f][c] == 'L') {
                park[f][c] = 'X';
                System.out.println("¡Vehiculo estacionado con exito!");
            } else {
                System.out.println("Error: El lugar ya está ocupado.");
            }
        } else {
            System.out.println("Error: Coordenadas fuera de rango.");
        }
        System.out.println("\nEstado actual del estacionamiento:");
        imprimirMapa(park);
    }

 
    public static void imprimirMapa(char[][] matriz) {
        System.out.println("    [0] [1] [2] [3] [4]"); 
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("[" + i + "] ");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" " + matriz[i][j] + "  ");
            }
            System.out.println();
        }  

    }
    
}

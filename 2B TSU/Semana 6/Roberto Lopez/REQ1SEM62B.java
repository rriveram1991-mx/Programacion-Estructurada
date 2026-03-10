/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req1sem62b;

import java.util.Scanner;

/**
 *
 * @author lopez
 */
public class REQ1SEM62B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Scanner lr = new Scanner(System.in);
     int[][] asientos = new int[3][3]; 
        int fila, columna;

        System.out.println("--- SALA DE CINE ---");
        
    
        mostrarMapa(asientos);

        System.out.print("\nIngrese la fila (1-3): ");
        fila = validarEntrada(lr, 1, 3);
        
        System.out.print("Ingrese el numero de asiento (1-3): ");
        columna = validarEntrada(lr, 1, 3);

        asientos[fila - 1][columna - 1] = 1;

        System.out.println("\nReserva exitosa. Estado actualizado:");
        mostrarMapa(asientos);
    }

   
    public static void mostrarMapa(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Fila " + (i + 1) + " ");
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 1) {
                    System.out.print("[ X ]"); // Ocupado
                } else {
                    System.out.print("[" + (j + 1) + "]"); // Disponible con su número
                }
            }
            System.out.println();
        }
    }
    public static int validarEntrada(Scanner lr, int min, int max) {
        int valor = lr.nextInt();
        while (valor < min || valor > max) {
            System.out.print("Invalido. Intente de nuevo ("+min+"-"+max+"): ");
            valor = lr.nextInt();
        }
        return valor;
    }
}
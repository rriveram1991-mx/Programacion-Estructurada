/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req3.sem6.pkg2d.rcmc;

import java.util.Scanner;

/**
 *
 * @author STAR KRIS
 */
public class REQ3SEM62DRCMC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [][][][] colum;
        
        Scanner sc = new Scanner(System.in);

        // Definimos un cine con 5 filas y 6 columnas de asientos
        char[][] asientos = new char[5][6];

        // Inicializamos todos los asientos como libres (L)
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                asientos[i][j] = 'L'; // L = Libre
            }
        }

        int opcion;
        do {
            System.out.println("\n--- MENÚ DEL CINE ---");
            System.out.println("1. Mostrar asientos");
            System.out.println("2. Reservar asiento");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mostrarAsientos(asientos);
                    break;
                case 2:
                    reservarAsiento(asientos, sc);
                    break;
                case 3:
                    System.out.println("Gracias por usar el sistema del cine.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);

        sc.close();
    }

    // Método para mostrar los asientos
    public static void mostrarAsientos(char[][] asientos) {
        System.out.println("\nEstado de los asientos (L=Libre, X=Ocupado):");
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                System.out.print(asientos[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para reservar un asiento
    public static void reservarAsiento(char[][] asientos, Scanner sc) {
        System.out.print("Introduce la fila (0-" + (asientos.length - 1) + "): ");
        int fila = sc.nextInt();
        System.out.print("Introduce la columna (0-" + (asientos[0].length - 1) + "): ");
        int columna = sc.nextInt();

        if (fila >= 0 && fila < asientos.length && columna >= 0 && columna < asientos[0].length) {
            if (asientos[fila][columna] == 'L') {
                asientos[fila][columna] = 'X'; // X = Ocupado
                System.out.println("¡Asiento reservado con éxito!");
            } else {
                System.out.println("Ese asiento ya está ocupado.");
            }
        } else {
            System.out.println("Posición inválida.");
        }
    }
}
        
        
    
    


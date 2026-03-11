/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req4.sem6.pkg2d.rcmc;

import java.util.Scanner;

/**
 *
 * @author STAR KRIS
 */
public class REQ4SEM62DRCMC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        

        Scanner sc = new Scanner(System.in);

        // Definimos un estacionamiento con 4 filas y 5 columnas
        int filas = 4;
        int columnas = 5;
        boolean[][] lugares = new boolean[filas][columnas]; 
        // false = libre, true = ocupado

        int opcion;
        do {
            System.out.println("\n--- MENÚ ESTACIONAMIENTO ---");
            System.out.println("1. Mostrar lugares");
            System.out.println("2. Estacionar vehículo");
            System.out.println("3. Retirar vehículo");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mostrarLugares(lugares);
                    break;
                case 2:
                    estacionar(lugares, sc);
                    break;
                case 3:
                    retirar(lugares, sc);
                    break;
                case 4:
                    System.out.println("Gracias por usar el sistema de estacionamiento.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

        sc.close();
    }

    // Mostrar estado de los lugares
    public static void mostrarLugares(boolean[][] lugares) {
        System.out.println("\nEstado de los lugares (O = libre, X = ocupado):");
        for (int i = 0; i < lugares.length; i++) {
            for (int j = 0; j < lugares[i].length; j++) {
                if (lugares[i][j]) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    // Estacionar vehículo
    public static void estacionar(boolean[][] lugares, Scanner sc) {
        System.out.print("Ingresa la fila (0-" + (lugares.length - 1) + "): ");
        int fila = sc.nextInt();
        System.out.print("Ingresa la columna (0-" + (lugares[0].length - 1) + "): ");
        int columna = sc.nextInt();

        if (fila >= 0 && fila < lugares.length && columna >= 0 && columna < lugares[0].length) {
            if (!lugares[fila][columna]) {
                lugares[fila][columna] = true;
                System.out.println("¡Vehículo estacionado con éxito!");
            } else {
                System.out.println("Ese lugar ya está ocupado.");
            }
        } else {
            System.out.println("Coordenadas inválidas.");
        }
    }

    // Retirar vehículo
    public static void retirar(boolean[][] lugares, Scanner sc) {
        System.out.print("Ingresa la fila (0-" + (lugares.length - 1) + "): ");
        int fila = sc.nextInt();
        System.out.print("Ingresa la columna (0-" + (lugares[0].length - 1) + "): ");
        int columna = sc.nextInt();

        if (fila >= 0 && fila < lugares.length && columna >= 0 && columna < lugares[0].length) {
            if (lugares[fila][columna]) {
                lugares[fila][columna] = false;
                System.out.println("Vehículo retirado con éxito.");
            } else {
                System.out.println("Ese lugar ya estaba libre.");
            }
        } else {
            System.out.println("Coordenadas inválidas.");
        }
    }
}

 
    


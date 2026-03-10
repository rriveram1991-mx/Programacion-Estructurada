/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estacionamiento;

import java.util.Scanner;

/**
 *
 * @author juanc
 */
public class Estacionamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion ;
        int [][] asientos = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
       Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEstado actual del estacionamiento :");
            for (int[] fila : asientos) {
                for (int asiento : fila) {
                    System.out.print((asiento == 0 ? "[X]" : "[" + asiento + "]") + " ");
                }
                System.out.println();
            }

            System.out.println("¿Escoja el lugar a ocupar? (1-9):");
            opcion = sc.nextInt();

            boolean encontrado = false;
            for (int i = 0; i < asientos.length; i++) {
                for (int j = 0; j < asientos[i].length; j++) {
                    if (asientos[i][j] == opcion && opcion != 0) {
                        asientos[i][j] = 0; 
                        System.out.println("Lugar " + opcion + " Listo, usted ya ocupa este lugar " + (i + 1));
                        encontrado = true;
                        break;
                    }
                }
                if (encontrado) break;
            }

            if (!encontrado) {
                System.out.println("Este lugar ya esta ocupado ");
            }

            System.out.println("¿Desea ocupar otro lugar? (1: Sí / 2: No)");
            int respuesta = sc.nextInt();
            if (respuesta != 1) {
                continuar = false;
            }
        }

        sc.close();
    }
    }
    


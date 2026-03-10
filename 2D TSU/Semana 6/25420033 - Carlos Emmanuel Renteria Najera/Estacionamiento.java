/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estacionamiento;

import java.util.Scanner;

/**
 *
 * @author Memer
 */
public class Estacionamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lr = new Scanner(System.in);
        
        int [][] Est = new int [5][2];
        
        int Fila = 0;
        int Columna = 0;
        
        System.out.println("Que columna quieres estar? (1 o 2)");
        Columna = lr.nextInt() - 1;
        
        System.out.println("En que fila quieres estar? (1 - 5)");
        Fila = lr.nextInt() - 1;
        
        if (Fila >= 0 && Fila < 5 || Columna >= 0 && Columna < 2 ) {
            Est[Fila][Columna] = 1;
            System.out.println("Asiento reservado: " + Est[Fila][Columna]);
        }
        else{
            System.out.println("asiento fuera de rango");
        }
        
        for (int[] j : Est) {
            for (int i : j) {          
                System.out.print(i + " ");      
            }
            System.out.println();
        }
    }
    
}

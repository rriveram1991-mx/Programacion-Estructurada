/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asientoscine;

import java.util.Scanner;

/**
 *
 * @author Memer
 */
public class AsientosCine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lr = new Scanner(System.in);
        
        int [][] Acine = new int [5][5];
        
        int Fila = 0;
        int Columna = 0;
        
        System.out.println("Que columna quieres estar? (1-5)");
        Columna = lr.nextInt() - 1;
        
        System.out.println("En que fila quieres estar? (1-5)");
        Fila = lr.nextInt() - 1;
        
        if (Fila >= 0 && Fila < 5 || Columna >= 0 && Columna < 5 ) {
            Acine[Fila][Columna] = 1;
            System.out.println("Asiento reservado: " + Acine[Fila][Columna]);
        }
        else{
            System.out.println("asiento reservado");
        }
        
        for (int[] j : Acine) {
            for (int i : j) {          
                System.out.print(i + " ");      
            }
            System.out.println();
        }
        
        
        
    }
    
}

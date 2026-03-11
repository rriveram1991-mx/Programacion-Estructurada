/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cine;

import java.util.Scanner;

/**
 *
 * @author jessr
 */
public class CINE {

    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
        
         int [][] matriz = {
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}
        };
        
        System.out.println("CINE (0 = libre, 1 = ocupado)");
        for(int i = 0; i < matriz.length; i++){
        for(int j = 0; j < matriz[i].length; j++){
            System.out.print(matriz[i][j] + " ");
        }
            System.out.println();  
        }
        System.out.println("Ingrese la fila: ");
       int fila = leer.nextInt();
        System.out.println("Ingrese la columna: ");
       int columna = leer.nextInt();
       
        matriz[fila][columna] = 1;
       
         for(int i = 0; i < matriz.length; i++){
        for(int j = 0; j < matriz[i].length; j++){
            System.out.print(matriz[i][j] + " ");
        }
            System.out.println();  
        }
    }
}

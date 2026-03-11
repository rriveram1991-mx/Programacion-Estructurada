/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.estacionamineto;

import java.util.Scanner;

/**
 *
 * @author jessr
 */
public class Estacionamineto {

    public static void main(String[] args) {
       Scanner leer = new Scanner (System.in);
       int[][] matriz = {
           {0,0,0,0,},
           {0,0,0,0,},
           {0,0,0,0,}
        };
       
      for(int i = 0; i < matriz.length; i++){
        for(int j = 0; j < matriz[i].length; j++){
            System.out.print(matriz[i][j] + " ");
        }
            System.out.println();  
        }
        System.out.println("Seleccione un fila para verificar que no este ocupado");
        int lugar = leer.nextInt();
        System.out.println("Seleccione un columna para verificar que no este ocupado");
        int Estacionamiento = leer.nextInt();
        
        matriz[lugar][Estacionamiento] = 1;
        
         for(int i = 0; i < matriz.length; i++){
        for(int j = 0; j < matriz[i].length; j++){
            System.out.print(matriz[i][j] + " ");
        }
            System.out.println();  
        }
    }
    
}


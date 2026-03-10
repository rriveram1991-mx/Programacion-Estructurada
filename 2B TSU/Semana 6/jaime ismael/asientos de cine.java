/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication67;

import java.util.Scanner;

/**
 *
 * @author Jaime Ismael
 */
public class JavaApplication67 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        int[][] asientos = {
        {0,0},
        {0,1},
           
    };
        System.out.println("asientos de cine");
        System.out.println("\neligue un asiento:");
        
        for (int x = 0; x < asientos.length; x++) {
    for (int y = 0; y < asientos.length; y++) {
        System.out.print(asientos[x][y] + " "); 
        
        System.out.println("dame la fila: ");
        opcion = leer.nextInt();
        
        System.out.println("dame la columna ");
        int opcion2 = leer.nextInt();
        
        int valor = asientos[opcion][opcion2];
        
        if (valor == 1){
            
            System.out.println("asiento ocupado");   
        }else {
            System.out.println("asiento reservado!!!");   
            asientos[opcion][opcion2] = 1;
        }
        
    }
}
        
        
        
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication59;

import java.util.Scanner;

/**
 *
 * @author Jaime Ismael
 */
public class JavaApplication59 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        //creamos un arreglo de 5 casillas 
        System.out.println("registro de notas: ");
        int[] notas = new int[5];
        
        for (int x = 0; x<4; x++){
            
            //el primer for recorre el arreglo y registra las calificaciones 
            System.out.println("dame la nota " + (x+1) + ": ");
                notas[x] = leer.nextInt();
        }
        for (int x =0; x<4; x++){
            //el segundo for imprime las notas guardadas 
            System.out.println("nota "+(x+1)+": " + notas[x]);   
        }
        System.out.println("Programado por jaime ismael");
        
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication68;

import java.util.Scanner;

/**
 *
 * @author Jaime Ismael
 */
public class JavaApplication68 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
         Scanner leer = new Scanner(System.in);
        int opcion = 0;
        int[][] estacionamientos = {
        {1,0},
        {0,0},
        };
        System.out.println("estacionamientos disponibles: ");
        for (int x = 0; x < estacionamientos.length; x++){
            for (int y = 0; y < estacionamientos.length; y++){
                
                System.out.println(estacionamientos[x][y]);   
                
            }
            }
              System.out.println("dame la columna: ");  
              int col = leer.nextInt();
              
              System.out.println("dame la fila: ");
              int fil = leer.nextInt();
              
              
              int valor = estacionamientos[col][fil];
              
              if (valor == 1){
                  System.out.println("estacionamiento ocupado");   
                  
              }else if (valor == 0){
                  System.out.println("estacionamiento disponible y estacionado"); 
                  estacionamientos[col][fil]= 1;
                  
              }
              }
                
            
        }
        
    
    


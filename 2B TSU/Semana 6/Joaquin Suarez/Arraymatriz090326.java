/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arraymatriz090326;

import java.util.Scanner;

/**
 *
 * @author ssjoa
 */
public class Arraymatriz090326 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
      Scanner leer = new Scanner(System.in);
      /*ejemplo de matriz solo como ejemplificacion*/
      int[][] matriz = 
      {
       {0,1},
       {0,1}
       };
      /*limites de la matriz*/
      int [][] sala = new int [2][2];
      /*inicio de terminal*/
      boolean entrar = true;
      
      /*declaracion de interfaz con el usuario*/
     while (entrar)
     {
     System.out.println("Bienvenido usuario");
     System.out.println("--------------------------");
     System.out.println("Asiento 1 fila 2, ocupado");
     System.out.println("--------------------------");
     System.out.println("Asiento 2, fila 1, ocupado");
     System.out.println("--------------------------");
     System.out.println("asientos disponibles [0][2] disponibles");
     /*for de "control para la columna*/
     for(int n = 0; n<sala.length; n++)
     {
         System.out.println("fila: "+n+ ":");
     /*for de control para la fila*/
     for (int x = 0; x < sala[n].length; x++)
     {
      String disponibilidad = (sala[n][x] == 0) ? "[disponible]" : "[ocupado]";
      System.out.println(disponibilidad + " ");
     }
         
     }
     System.out.println("Que asiento desea?");
     System.out.println("Fila (0-1):" );
     int fila = leer.nextInt();
     System.out.println("Columa: (0-1: ");
     int columna = leer.nextInt();
     /*nos aseguramos de que las opciones se capten y aislamos los asientos ocupados*/
    if (columna>= 0 && columna < 2 && fila >= 0 && fila < 2)
    {
     if(sala[fila][columna] == 0)
     {
      sala[fila][columna] = 1;
      System.out.println(" Asiento: " +columna+ " fila " +fila+ " ocupado ");
     }else
     {
     System.out.println("asiento " +fila+ " ; " +columna+" esta ocupado");
     }
        
    }else
    {
    System.out.println("error, intente de nuevo");    
    }
    /*interfaz de salida*/
    System.out.println("Quiere hacer otra operacion? [1 = salir] [2 =continuar]");
    int salida = leer.nextInt();
    if(salida !=2)
    {
     entrar = false;
    }
     }
          
          
          
          
          
          
          
      }  
        
        
        
        
        
        
    }
    



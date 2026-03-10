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
      int [][] estacionamiento = new int [2][2];
      /*inicio de terminal*/
      boolean entrar = true;
      
      /*declaracion de interfaz con el usuario*/
     while (entrar)
     {
     /*for de "control para la columna*/
     for(int n = 0; n<estacionamiento.length; n++)
     {
         System.out.println("fila: "+n+ ":");
     /*for de control para la fila*/
     for (int x = 0; x < estacionamiento[n].length; x++)
     {
      String disponibilidad = (estacionamiento[n][x] == 0) ? "[vacio]" : "[ocupado]";
      System.out.println(disponibilidad + " ");
     }
         
     }
     /*caputa de datos segun necsidades del usuario*/
     System.out.println("Ingrese su seccion (0-1):" );
     int fila = leer.nextInt();
     System.out.println("Ingrese su espacio: (0-1: ");
     int columna = leer.nextInt();
     /*nos aseguramos de que las opciones se capten y aislamos los asientos ocupados*/
    if (columna>= 0 && columna < 2 && fila >= 0 && fila < 2)
    {
     if(estacionamiento[fila][columna] == 0)
     {
      estacionamiento[fila][columna] = 1;
      System.out.println("Registro completado "+" seccion: "+fila+" espacio: "+columna);
     }else
     {
     System.out.println("seccion" +fila+ " ; " +columna+" ocupado");
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
    



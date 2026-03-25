/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estadodeanimo;

import java.util.Scanner;

/**
 *
 * @author ssjoa
 */
public class Estadodeanimo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
    Scanner leer = new Scanner(System.in);    
    int[] listaanimo = new int [7];
    int [][] actividades = new int [7][3];
    //matriz central//
    String[]ndias = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
    //conjunto de dias que se usan en el case 2//
    int usuario;
    int animo;
    double promedio;
    double bienestar = 0;
    int dias;
    int cadadia = 0;
    //variables generales//
    for (int x = 0; x < 7; x++)
    {
    for (int n = 0; n < 3; n++)
    {
    }
    }
    //acomodo de matriz//
    
    do
    {
    System.out.println("Buenos dias usuario que puedo hacer por ti hoy?");
    
    System.out.println("1.-Registrar estado de animo");
    System.out.println("2.- Registrar actividades");
    System.out.println("3.- Ver resumen");
    System.out.println("4.-Ver recomendacion");
    System.out.println("5.-Salir");
    usuario=leer.nextInt();
    //menu de usuario//
    
    switch(usuario)
    //caso ajustable segun la opcion  de usuario//
    {
     case 1:
         if(cadadia<7)
         {
         System.out.println("como te sientes hoy? del 1 al 5");
         listaanimo[cadadia]=leer.nextInt();
         cadadia++;
         }
        break;
        //bloque de rango de bienestar//
         
     case 2:
        for (int d = 0; d < 7; d++) 
        {
        System.out.println("Vayamos con: "+ndias[d]);
        for (int a = 0; a < 3; a++)
        {
        System.out.println("Hiciste la actividad de bienestar " + (a+1) + " hoy? " +  "1 = si / 2 = no");
        actividades[d][a]=leer.nextInt();
        }
        }
        break;
        //bloque de actividades//
        
     case 3:
        double totalanimo = 0;
        int totalact = 0;


        for (int i = 0; i < cadadia; i++)
        {
        totalanimo += listaanimo[i];
        }
        if(cadadia>0)
        {
        bienestar = totalanimo/cadadia;
        }else
        {
            bienestar=0;
        }
        for(int[]dia:actividades)
        {
        for(int accion:dia)    
        {
            if(accion==1)
            {
            totalact++;
            }
        }
        }
        //hasta aqui la idea es lograr calcular el promedio//
         System.out.println("Tu total de activades saludables es de: "+ totalact);
         
         System.out.println("Nivel de bienestar");
         if(bienestar<3)
         {
             System.out.println("Bajo");
         }else if (bienestar <=4)
         {
             System.out.println("Medio");
         }else
         {
             System.out.println("Alto");
         }
         break;
         //esta segunda parte busca calificar el total de puntos segun el total de actividades//
         
     case 4:
         if(bienestar<3)
         {
         System.out.println("Date un momento para pensar en ti; Todo tiene solucion despues de dormir un par horas");
         }else if(bienestar >=3)
         {
         System.out.println("Vas muy bien pero tal vez necesitas un momento para ti; Tomar el aire o correr un poco siempre son buenas opciones");
         }else
         {
         System.out.println("Felicidades, tus esfuerzos sin duda estan dando frutos");
         }
         break;
         //bloque de consejos//
         
     case 5:
         System.out.println("Saliendo del sistema");
         break;
         
     default:
         System.out.println("Opcion invalida");
    }
    }while(usuario != 5);
     //bloque de salida y fin//
      
         
        
            
            
            
            
            
         
    }
    }

         

            
    
    
    
    
    
    
    
    
    
    
    
        
        
        
    
    


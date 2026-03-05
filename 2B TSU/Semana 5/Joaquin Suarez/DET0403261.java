/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det040326.pkg1;

import java.util.Scanner;

/**
 *
 * @author ssjoa
 */
public class DET0403261 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        double suma = 0;/*double es mejor en caso de decimales*/
        int aprobados = 0;
        int calift= 0;/*contador para el total de las calificaciones*/


        // Captura de datos
        for (int i = 0; i < calificaciones.length; i++)
            /*el 0 es para iniciar el contador de forma logica*/
        {

            System.out.println("Ingrese calificación " + (i+1) + ": ");
            /*la indicacion (i+1) se inicia para asegurar de que la lectura del usuario no parte en formato de maquina, osea, desde el 0*/
            calificaciones[i] = sc.nextInt();
            while (calificaciones[i] < 0 ||calificaciones[i] >100)
                /*el || completa la accion para decir que si una opcion u otra son reales en lugar de accionarse en caso de que ambas lo sean*/
            {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
            suma+=calificaciones[i];/*contador de guardado para la suma de la calificacion*/
            calift++;
              
           }

        // Mostrar calificaciones
        for (int i = 0; i < calificaciones.length; i++)/*correcion de indicacion de la califiacion*/
        {
            System.out.println("Calificacion "+(i+1)+ ":" + calificaciones[i]);
        }
            
            
        

        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length)
        {
            if (calificaciones[j] > 70) 
            {
                aprobados++;
            }
            j++;/*dado que J inicia en 0, la condicion nunca tendra lugar, por ello la incrementamos segun el numero de aprobados*/
        }
       

        double promedio = suma / calificaciones.length;

        if (promedio >= 70)
        {
        System.out.println("Grupo aprobado");

        } else
        {
            System.out.println("Grupo reprobado");
        }

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
        System.out.println("Total de calificaciones ingresadas: "+calift);
    }
    }


        
        
        
        
        
        
        
        
        
        
        
        
    
   

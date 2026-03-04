/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication62;

//Requerimiento del Sistema
//
//El sistema debe:
//
//Permitir capturar 5 calificaciones.
//Validar que cada calificación esté entre 0 y 100.
//Mostrar todas las calificaciones ingresadas.
//Calcular el promedio.
//Mostrar cuántos alumnos aprobaron (>= 70).
//
//
//CODIGO 

import java.util.Scanner;

public class SistemaCalificaciones {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        
        // Captura de datos
        //intenta ingresaar un dato a una casilla que no existe 
        //se coloca el for en 0 para que empiecen los datos desde ahi 
        //y el limite del for no puede ser igual o mayor a la cantidad de casillas 
        //de el arreglo 
        for (int i = 0; i < calificaciones.length; i++) {
                                                         //se agrega un +1 al print para que se vea mas comodo    
            System.out.println("Ingrese calificación " + (i+1) + ": "); 
            
            calificaciones[i] = sc.nextInt();
             //la instruccion while de usar not para las dos condiciones 
            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            //falta hacer bien el sumador 
            suma = suma + cal;
        }

        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length) {
            if (calificaciones[j] > 70) {
                aprobados++;
            }//el while se repite infinitamente j nunca se incrementa por lo que hace un bucle infinito
            j++;
        }

        double promedio = (double) suma / 5;

        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
    }
}



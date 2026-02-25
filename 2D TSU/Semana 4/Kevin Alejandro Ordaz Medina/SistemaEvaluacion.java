/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemaevaluacion;

import java.util.Scanner;

public class SistemaEvaluacion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
        int contador = 0;

        System.out.println("=== SISTEMA DE EVALUACION ===");

        while (opcion != 4) {

            System.out.println("1. Capturar calificaciones");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar nivel");
            System.out.println("4. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    total=0;   //faltaba inicializar en 0 la variable dentro del case 1 
                    contador=0; // faltaba inicializar en 0 dentro del case 1
                    for (int i = 1; i <= 5;)  // ";" que cortaba el ciclo for 
                    {
                        System.out.print("Ingrese calificacion " + i + ": ");
                        int cal = sc.nextInt();

                        if (cal > 0 && cal <= 10)  // se quita el "=" porque no puede ser 0
                        {                             //faltaban corchetes
                            total = total + cal;
                            contador++;
                            i++;   //se le suma 1 a "i" para el for solo si se ingresa una calif valida
                        }
                        else     // faltaban corchetes
                        {
                            System.out.println("Calificacion invalida");   
                        }
                    }
                    break;

                case 2:
                    double promedio = total / contador;
                    System.out.println("Promedio: " + promedio);
                    break;
                    
                case 3:
                     if (total / contador >= 9) {   //faltaban corchetes
                        System.out.println("Excelente");
                     } else if (total / contador >= 8) {  // se cerraba la condicion con un ";"
                        System.out.println("Bueno");     //faltaban corchetes
                     } else if (total / contador >= 7) {  //faltaban corchetes
                        System.out.println("Regular");
                     } else
                     {
                        System.out.println("Reprobado");  //faltaban corchetes
                         
                     }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }

        }

        sc.close();
    }
}
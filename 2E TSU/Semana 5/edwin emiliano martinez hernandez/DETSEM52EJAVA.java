/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det.sem5.pkg2e.java;

import java.util.Scanner;


/**
 *
 * @author edwin
 */
public class DETSEM52EJAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[4];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        //error de ejcucion en la linea 28 cambie el i <= a i < por que tronaba
        for (int i = 0; i < calificaciones.length; i++) {

            System.out.println("Ingrese calificación " + (i+1) + ": ");
            calificaciones[i] = sc.nextInt();
        
            //error logico :en la linea 34 habia un && lo cambie a || por que no puedes tener un numero mayor a 100 y menor 0 al mismo tiempo.estaba mal la condicon
            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma += cal;
        }

        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length) {
            // error logico : enla linea 50 coloque  >= por que el 70 tambien cuenta como aprobado.
            if (calificaciones[j] >= 70) {
                aprobados++;
            }
              // ERROR LÓGICO: en la linea 54 Faltaba el j++ para que el contador avance, y quedaba en un bucle infinito
            j++;
        }
 // ERROR LÓGICO: Agregué el (double) para que la división no me de un entero 
        // truncado y pueda ver los decimales del promedio.
        double promedio = (double) suma / calificaciones.length;

        if (promedio >= 70) {
            System.out.println("Grupo aprobado");
        }  else {
            System.out.println("Grupo reprobado"); }

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
    }
}
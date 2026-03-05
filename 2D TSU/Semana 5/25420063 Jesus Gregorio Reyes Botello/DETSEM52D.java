/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.det.sem5.d;

import java.util.Scanner;

/**
 *
 * @author jessr
 */
public class DETSEM52D {

    public static void main(String[] args) {
        System.out.println("Hello World!");
         Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        //#1 i inicia en 1 debe seo 0
        //#2 tambiem en i <= calificaciones debe ser < 
        for (int i = 0; i < calificaciones.length; i++) {

            System.out.println("Ingrese calificación " + (i + 1) + ": ");
            calificaciones[i] = sc.nextInt();

            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        //#3 En la suma falta el + para acumular 
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma += cal;
        }

        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length) {
            if (calificaciones[j] > 70) {
                aprobados++;
            }
        //#4 Falta el contador
            j++;
        }
//#5 posible division entre 0 agregamos el couble al suma
        double promedio = (double) suma / calificaciones.length;

        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dt1.sem5;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DT1SEM5 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        //error en parametros del for
        for (int i = 0; i < calificaciones.length; i++) {

            System.out.println("Ingrese calificación " + (i+1) + ": ");
            calificaciones[i] = sc.nextInt();

            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        //contador de suma
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma += cal;
        }

        // Contar aprobados
        //contar j
        int j = 0;
        while (j < calificaciones.length) {
            if (calificaciones[j] > 70) {
                aprobados++;
            }
            j++;
        }

        double promedio = suma / calificaciones.length;

        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);

    }
}

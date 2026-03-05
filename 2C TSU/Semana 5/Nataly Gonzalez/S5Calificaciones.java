/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s5.calificaciones;

import java.util.Scanner;

/**
 *
 * @author UTT
 */
public class S5Calificaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        for (int i = 0; i < calificaciones.length; i++) {

            System.out.println("Ingrese calificación " + (i + 1) + ": ");
            calificaciones[i] = sc.nextInt();

            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones y sumar
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma += cal;

            if (cal >= 70) {
                aprobados++;
            }
        }

        double promedio = (double) suma / calificaciones.length;

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);

        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        sc.close();
    }
}
    

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det1.pkg3.sem5_2e;

import java.util.Scanner;

/**
 *
 * @author gl873
 */
public class DET1_3SEM5_2E {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Capturar calificaciones
        for (int i = 0; i < calificaciones.length; i++) {

            System.out.print("Ingrese calificación " + (i + 1) + ": ");
            calificaciones[i] = sc.nextInt();

            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.print("Calificación inválida. Intente otra vez: ");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones y sumar
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma += cal;
        }

        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length) {
            if (calificaciones[j] >= 70) {
                aprobados++;
            }
            j++;
        }

        double promedio = suma / calificaciones.length;

        System.out.println("Promedio: " + promedio);
        System.out.println("Alumnos aprobados: " + aprobados);

        sc.close();
    }
}


   
    


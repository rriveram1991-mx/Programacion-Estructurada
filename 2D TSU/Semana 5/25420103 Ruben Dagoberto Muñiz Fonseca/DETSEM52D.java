/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det.sem5.pkg2d;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class DETSEM52D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //El sistema debe:

//Permitir capturar 5 calificaciones.
//Validar que cada calificación esté entre 0 y 100.
//Mostrar todas las calificaciones ingresadas.
//Calcular el promedio.
//Mostrar cuántos alumnos aprobaron (>= 70).
         Scanner sc = new Scanner(System.in);
        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // 1. Captura y Validación (0 a 100)
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Ingrese calificación " + (i + 1) + ": ");
            calificaciones[i] = sc.nextInt();

            // Usamos || porque no puede ser menor a 0 y mayor a 100 al mismo tiempo
            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // 2. Mostrar calificaciones y sumar
        System.out.println("\nCalificaciones ingresadas:");
        for (int cal : calificaciones) {
            System.out.println("- " + cal);
            suma += cal; // Se usa += para acumular la suma
        }

        // 3. Contar aprobados (>= 70)
        int j = 0;
        while (j < calificaciones.length) {
            if (calificaciones[j] >= 70) {
                aprobados++;
            }
            j++; // IMPORTANTE: incrementar j para evitar ciclo infinito
        }

        // 4. Calcular promedio
        double promedio = (double) suma / calificaciones.length;

        // 5. Resultados
        System.out.println("\n--- Resultados ---");
        System.out.println("Promedio: " + promedio);
        System.out.println("Cantidad de aprobados: " + aprobados);

        if (promedio >= 70) {
            System.out.println("Estado: Grupo aprobado");
        } else {
            System.out.println("Estado: Grupo reprobado");
        }
    }
}

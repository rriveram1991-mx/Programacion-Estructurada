/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s5_calificaciones;

import java.util.Scanner;

public class S5_Calificaciones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Para permitir calificaciones con punto decimal cambiar el INT por DOUBLE.
        double[] calificaciones = new double[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos y validación
        // Se debe iniciar el ciclo en 0
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Ingrese calificacion " + (i + 1) + ": ");
            double nota = sc.nextDouble();

            // Cambiar el AND (&&) por OR (||) para que la validación sea correcta
            while (nota < 0 || nota > 100) {
                System.out.println("Calificación inválida (debe ser 0-100). Intente nuevamente:");
                // Agregar una variable nota para evitar que el arreglo guarde números fuera de rango
                nota = sc.nextDouble();
            }
            calificaciones[i] = nota;
        }

        System.out.println("\n--- Resultados ---");

        // Mostrar calificaciones y calcular suma
        for (double cal : calificaciones) {
            System.out.println("Calificacion: " + cal);
            suma += cal; // No estaba sumando 
            
            // Contar aprobados (>= 70 según requerimiento)
            if (cal >= 70) {
                aprobados++;
            }
        }

        // Promedio con decimales
        double promedio = (double) suma / calificaciones.length;

        System.out.println("-------------------");
        System.out.println("Promedio: " + promedio);
        System.out.println("Materias aprobadas: " + aprobados);
        
        if (promedio >= 70)
            System.out.println("Estado: Alumno aprobado");
        else
            System.out.println("Estado: Alumno reprobado");

    }
    
}

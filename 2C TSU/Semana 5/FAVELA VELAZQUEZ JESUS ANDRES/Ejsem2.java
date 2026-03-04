/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejsem2;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Ejsem2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        double suma = 0; // Usamos double para que el promedio no salga mocho
        int aprobados = 0;

        // 1. Capturar 5 calificaciones
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Ingrese calificación " + (i + 1) + ": ");
            calificaciones[i] = sc.nextInt();

            // 2. Validar entre 0 y 100
            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // 3. Mostrar todas las calificaciones y sumar
        System.out.println("\n--- Calificaciones Ingresadas ---");
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma += cal; // Aquí se van sumando todas
        }

        // 5. Contar aprobados (>= 70)
        int j = 0;
        while (j < calificaciones.length) {
            if (calificaciones[j] >= 70) {
                aprobados++;
            }
            j++; // ESTA LÍNEA es la que faltaba para que no saliera 0
        }

        // 4. Calcular el promedio
        double promedio = suma / calificaciones.length;

        System.out.println("\n--- Resultados Finales ---");
        System.out.println("Promedio del grupo: " + promedio);
        System.out.println("Alumnos aprobados: " + aprobados);

        if (promedio >= 70)
            System.out.println("Estado: Grupo aprobado");
        else
            System.out.println("Estado: Grupo reprobado");
    }
}
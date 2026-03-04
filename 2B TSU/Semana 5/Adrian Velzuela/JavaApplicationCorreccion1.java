/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication.correccion.pkg1;
import java.util.Scanner;
/**
 *
 * @author adrianvalenzuelaramirez
 */
public class JavaApplicationCorreccion1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // corrección : se cambió i=1 por i=0. Los arreglos siempre inician en el índice 0.
        // correccion : se cambió i <= length por i < length para evitar ArrayIndexOutOfBoundsException.
        for (int i = 0; i < calificaciones.length; i++) {

            System.out.println("Ingrese calificación " + (i + 1) + ": ");
            calificaciones[i] = sc.nextInt();

            // corrección : se cambió el operador '&&' por '||'. Una nota no puede ser menor a 0 Y mayor a 100 al mismo tiempo.
            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.println("Calificación inválida (Debe ser 0-100). Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }
        // mostrar calificaciones
        System.out.println("\n--- Calificaciones ingresadas ---");
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            // corrección : se cambió 'suma = cal' por 'suma += cal' para ir acumulando los valores.
            suma += cal; 
        }

        // contar aprobados
        int j = 0;
        // corrección : se agregó j++ al final del ciclo para evitar un bucle infinito.
        while (j < calificaciones.length) {
            // correccion: se cambió '>' por '>=' según el requerimiento (>= 70).
            if (calificaciones[j] >= 70) {
                aprobados++;
            }
            j++; 
        }

        // corrección : se usó double para forzar la división decimal y que el promedio sea exacto.
        double promedio = (double) suma / calificaciones.length;

        System.out.println("\n--- Resultados ---");
        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
    }
}
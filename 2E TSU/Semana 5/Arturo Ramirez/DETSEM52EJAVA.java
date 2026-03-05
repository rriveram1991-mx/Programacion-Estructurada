/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication54;
 import java.util.Scanner;
/**
 *
 * @author artur
 */
public class JavaApplication54 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       

        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.print("Ingrese calificación " + (i + 1) + ": ");
            calificaciones[i] = sc.nextInt();

            // Validar que esté entre 0 y 100
            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.print("Calificación inválida. Intente nuevamente: ");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones y calcular suma
        System.out.println("Calificaciones ingresadas:");
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma += cal;
        }

        // Contar aprobados (>= 70)
        for (int cal : calificaciones) {
            if (cal >= 70) {
                aprobados++;
            }
        }

        // Calcular promedio
        double promedio = (double) suma / calificaciones.length;

        // Mostrar resultados
        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
    }
}

    

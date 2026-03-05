/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semana.pkg5.sistemascalf;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Semana5Sistemascalf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        //  Captura de datos con validación
        for (int i = 0; i < calificaciones.length; i++) {

            System.out.print("Ingrese calificación " + (i + 1) + ": ");
            calificaciones[i] = sc.nextInt();

            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.print("Calificación inválida. Intente nuevamente: ");
                calificaciones[i] = sc.nextInt();
            }
        }

        //  Mostrar calificaciones y sumar
        System.out.println("Calificaciones ingresadas:");
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma += cal;
        }

        //  Calcular promedio
        double promedio = (double) suma / calificaciones.length;

        //  Contar aprobados (>=70)
        int j = 0;
        while (j < calificaciones.length) {
            if (calificaciones[j] >= 70) {
                aprobados++;
            }
            j++;
        }

        //  Mostrar resultados
        System.out.println("Promedio: " + promedio);
        System.out.println("Alumnos aprobados: " + aprobados);
        
        if (aprobados >= 3)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");
        sc.close();
    }
}

    
    


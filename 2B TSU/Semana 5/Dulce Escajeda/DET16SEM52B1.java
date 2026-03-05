/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det.pkg16.sem5.pkg2b.pkg1;

import java.util.Scanner;

/**
 *
 * @author lopez
 */
public class DET16SEM52B1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
              Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        double suma = 0;
        int aprobados = 0;

        // Captura de datos
        for (int i =0; i < calificaciones.length; i++) {
            System.out.println("Ingrese calificacion " + (i+1)+ ": ");
           int nota = sc.nextInt();

            while (nota < 0 || nota> 100) {
                System.out.println("Calificación inválida. Intente nuevamente:");
                nota = sc.nextInt();
            }
            calificaciones[i] = nota;
        }

        // Mostrar calificaciones
        System.out.println("\n --- Calificaciones ingresadas ---");
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma += cal;
            if (cal >= 70){
                aprobados++;
            }
        }

        double promedio = suma / calificaciones.length;

        System.out.println("\n--- Resultados ---");
        System.out.println("Promedio: " + promedio);
        System.out.println("Alumnos aprobados: " + aprobados);
        
        if (promedio >= 70)
            System.out.println("Estatus: Grupo aprobado");
        else
            System.out.println("Estatus: Grupo reprobado");
    }
}

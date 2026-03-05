/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaclasificaciones;

import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class SistemaClasificaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        //  Corrección: iniciar en 0 y usar <
        for (int i = 0; i < calificaciones.length; i++) {

            System.out.println("Ingrese calificación " + (i + 1) + ": ");
            calificaciones[i] = sc.nextInt();

            // Corrección: usar OR (||)
            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar y sumar
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);

            //  Corrección: acumular correctamente
            suma += cal;
        }

        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length) {

            //  Corrección: >= 70
            if (calificaciones[j] >= 70) {
                aprobados++;
            }

            //  Corrección: incrementar contador
            j++;
        }

        // Corrección: división en double
        double promedio = (double) suma / calificaciones.length;

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);

        sc.close(); //  Buena práctica
    }
}
    
    

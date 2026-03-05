/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calificaciones;

import java.util.Scanner;

/**
 *
 * @author OLguin21
 */
public class Calificaciones {

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

            System.out.println("Ingrese calificación " +(i+1) + ": ");
            calificaciones[i] = sc.nextInt();

            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma += cal;
        }

        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length) {
            if (calificaciones[j] >= 7) {
                aprobados++;
            }
            j++;
        }

        double promedio = (double) suma / calificaciones.length;

        if (promedio >= 7){
            System.out.println("Grupo aprobado");
           }
        else{
            System.out.println("Grupo reprobado");
        }
        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
        
    
   }
}





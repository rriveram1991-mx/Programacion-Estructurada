/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica8;

import java.util.Scanner;


public class Practica8 {
     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        for (int i = 0; i < calificaciones.length; i++) { //Debe iniciar en 0

            System.out.println("Ingrese calificación : ");
            calificaciones[i] = sc.nextInt();

            while (calificaciones[i] < 0 || calificaciones[i] > 100) { //ERROR: && se cambia a ||
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (var cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma = cal+suma;
        }
    
        // Contar aprobados
        int j = 0;
        for (j=0; j<calificaciones.length ; j++){ //Se cambia while a FOR
            if (calificaciones[j] >= 70) {
                aprobados++;
            }
        }

        double promedio = suma / calificaciones.length;

        if (promedio >= 70){ 
            System.out.println("Grupo aprobado");
        }else{
            System.out.println("Grupo reprobado");
        }
        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
    }
}


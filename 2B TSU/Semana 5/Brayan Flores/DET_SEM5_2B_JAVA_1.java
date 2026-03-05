/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package enconttrar.problemas.pkg1n.sem5;

import java.util.Scanner;

public class SistemaCalificaciones {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
            for (int i = 0; i < calificaciones.length; i++){
                // i deve iniciar desde 0 =)
            System.out.println("Ingrese calificación " + i + ": ");
            calificaciones[i] = sc.nextInt();

            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                // la calificacion deve ser (&&) por || =)
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma += cal;
            //error al sumar calificaciones agregamos un + =)
        }

        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length) {
            if (calificaciones[j] > 70) {
                aprobados++;
            }
            j++;
            //cerrar while con j++ =)
        }

        double promedio = (double) suma / calificaciones.length;
        //la suma debe contarse como double =)

        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
    }
}

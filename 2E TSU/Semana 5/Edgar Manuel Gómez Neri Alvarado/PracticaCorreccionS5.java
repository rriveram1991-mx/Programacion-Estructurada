/* Requerimiento del Sistema

El sistema debe:

Permitir capturar 5 calificaciones.
Validar que cada calificación esté entre 0 y 100.
Mostrar todas las calificaciones ingresadas.
Calcular el promedio.
Mostrar cuántos alumnos aprobaron (>= 70).


CODIGO */

package PracticaCorreccionS5;
import java.util.Scanner;

public class PracticaCorreccionS5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        for (int i = 0; i < calificaciones.length; i++) {

            System.out.println("Ingrese calificacion " + (i+1) + ": ");
            calificaciones[i] = sc.nextInt();

            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.println("Calificacion invalida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int cal : calificaciones) {
            System.out.println("Calificacion: " + cal);
            suma += cal;
            if (cal >= 70) {
            aprobados ++;
            }
        }

        // Contar aprobados
        int j = 1;
        System.out.println(calificaciones.length);
        while (j > calificaciones.length) {
            j++;
            System.out.println(calificaciones[j]);
}
        
        double promedio = suma / calificaciones.length;

        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
    }
}
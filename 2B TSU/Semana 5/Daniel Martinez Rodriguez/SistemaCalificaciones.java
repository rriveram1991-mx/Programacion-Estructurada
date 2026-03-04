//Requerimiento del Sistema

//El sistema debe:
/* 
Permitir capturar 5 calificaciones.
Validar que cada calificación esté entre 0 y 100.
Mostrar todas las calificaciones ingresadas.
Calcular el promedio.
Mostrar cuántos alumnos aprobaron (>= 70).


CODIGO 
/* */
import java.util.Scanner;

public class SistemaCalificaciones {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        double suma = 0;
        int aprobados = 0;

        // Captura de datos
        for (int i = 0; i < calificaciones.length; i++) {

            System.out.println("Ingrese calificación " + (i +1) + ":");
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
            if (calificaciones[j] > 70) {
                aprobados++;
            }
            j++;
        }

        double promedio =   suma / calificaciones.length;

        if (promedio >= 70){
            System.out.println("Grupo aprobado");}
        else {
            System.out.println("Grupo reprobado");
        }

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
    }
}


    


package ejerciciosingricardo44;

import java.util.Scanner;

public class EjerciciosIngRicardo44 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        // MODIFICACIÓN: Se usa i = 0 y < length para recorrer correctamente los 5 espacios del arreglo
        for (int i = 0; i < calificaciones.length; i++) {

            System.out.println("Ingrese calificación " + (i + 1) + ": ");
            calificaciones[i] = sc.nextInt();

            // MODIFICACIÓN: Se cambió a || para validar que la nota esté estrictamente entre 0 y 100
            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            // MODIFICACIÓN: Se usa suma + cal para ir acumulando el total de todas las notas
            suma = suma + cal;
        }

        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length) {
            // MODIFICACIÓN: Se usa >= 70 para incluir a los alumnos que pasaron con la mínima
            if (calificaciones[j] >= 70) {
                aprobados++;
            }
            // MODIFICACIÓN: Se agregó j++ para que el ciclo avance y no se quede infinito
            j++;
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
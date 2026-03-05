import java.util.Scanner;

public class DET_9_SEM5_2B {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        for (int i = 0; i < calificaciones.length; i++) {

            System.out.println("Ingrese calificación " + (i + 1) + ": ");
            calificaciones[i] = sc.nextInt();

            // Corregí el operador lógico de && a || porque una calificación no puede ser 
            // menor a 0 y mayor a 100 al mismo tiempo; ahora la validación sí funciona.
            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            // Cambié la asignación por una suma acumulada (+=) para calcular el total real.
            suma += cal;
        }

        int j = 0;
        while (j < calificaciones.length) {
            // Ajusté la condición para incluir a los que tienen 70 exacto como aprobados.
            if (calificaciones[j] >= 70) {
                aprobados++;
            }
            // Agregué el incremento de j para evitar que el ciclo se quedara infinito.
            j++;
        }

        // Usé un cast a double para que el promedio sea exacto y no pierda decimales.
        double promedio = (double) suma / calificaciones.length;

        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);

        sc.close();
    }
}
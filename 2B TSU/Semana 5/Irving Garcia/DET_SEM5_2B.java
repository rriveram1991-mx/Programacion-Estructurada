import java.util.Scanner;

public class DET_SEM5_2B {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        for (int i = 1; i < calificaciones.length; i++) {

            System.out.println("Ingrese calificación " + i + ": ");
            calificaciones[i] = sc.nextInt();

            // La condición estaba al revés y causaba un ciclo infinito
            while (calificaciones[i] < 0 && calificaciones[i] > 100) {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            // Antes solo tenia = por ende nunca se hacia la suma
            suma += cal;
        }
        
        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length) {
            if (calificaciones[j] >= 70) {
                aprobados++;
            }
            // Se incrementa el contador para evitar un ciclo infinito
            j++;
        }

        // La división era entera y se perdían decimales
        double promedio = (double) suma / calificaciones.length;

        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
    }
}
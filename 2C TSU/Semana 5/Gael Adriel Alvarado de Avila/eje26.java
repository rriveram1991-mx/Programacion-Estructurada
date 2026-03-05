import java.util.Scanner;

public class eje26 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        for (int i = 0; i < calificaciones.length; i++) { 
        // antes estaba i = 1 y <= length, pero los arreglos empiezan en 0 y eso provocaba que el programa intentara acceder a una posición que no existe

            System.out.println("Ingrese calificación " + (i + 1) + ": "); 

            calificaciones[i] = sc.nextInt();

            while (calificaciones[i] < 0 || calificaciones[i] > 100) { 
            // antes estaba && pero la condición nunca se cumplía porque un número no puede ser menor que 0 y mayor que 100 al mismo tiempo

                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int cal : calificaciones) {

            System.out.println("Calificación: " + cal);

            suma += cal; 
            // antes estaba suma = cal y solo guardaba la última calificación en lugar de sumarlas
        }

        // Contar aprobados
        int j = 0;

        while (j < calificaciones.length) { 
        // antes estaba <= y podía provocar que se intentara acceder fuera del arreglo

            if (calificaciones[j] >= 70) { 
            // antes estaba > 70 pero el requisito dice que aprueba con 70 o más

                aprobados++;
            }

            j++; 
            // faltaba incrementar j y el ciclo se volvía infinito
        }

        double promedio = (double) suma / calificaciones.length;

        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
    }
}
import java.util.Scanner;
public class Practica15 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        for (int i = 0; i < calificaciones.length; i++) { // Error: el índice debe ser menor que la longitud del arreglo

            System.out.println("Ingrese calificación " + (i+1) + ": "); //Se le agrega 1 para el programa no empiece a contar desde 0.
            calificaciones[i] = sc.nextInt();

            while (calificaciones[i] < 0 || calificaciones[i] > 100) { 
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma += cal; //Error: No se estaba acumulando. 
        }

        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length) {
            if (calificaciones[j] >= 70) { //Error: La aprobación es 70 o más.
                aprobados++;
            }
            j ++; //Error: No se estaba incrementando.
        }

        double promedio = (double) suma / calificaciones.length; //Error: La división da como resultdo entero, deberia ser decimal. 

        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
        sc.close();
    }
}


import java.util.Scanner;

public class DET1_SEM5_2D {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        //se ajusto para que empiece desde 0
        for (int i = 0; i < calificaciones.length; i++) {

            System.out.println("Ingrese calificación " + (i + 1) + ": ");
            calificaciones[i] = sc.nextInt();
            //en el while se cambio "&&" por "||" porque las calificaciones las estaba contando con mas de 100
            // y menos de 0
            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int cal : calificaciones) {
            System.out.println("Calificación: " + cal);
            suma += cal; //se le agreso el "+" para que sume cada valor
        }

        // Contar aprobados
        // se corrigio a 0 para que no entre en bucle
        int j = 0;
        while (j < calificaciones.length) {
            if (calificaciones[j] >= 70) { // se puso >= porque la aprobatoria es de 70 en adelante
                aprobados++;
            }
            j++;//se puso para evitar un bucle
        }
        //calculo del promedio en decimales
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

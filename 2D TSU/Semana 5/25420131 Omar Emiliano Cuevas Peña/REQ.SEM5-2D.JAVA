import java.util.Scanner;

public class SistemaCalificaciones {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0;

        // Captura de datos
        // ""="" no es necesario y rompe el código, se puede colocar directamente el texto dentro del println
        for (int i = 0; i < calificaciones.length; i++) {
//no pueden empezar en 0
            System.out.println("Ingrese calificación " + (i+1) + ": ");
            calificaciones[i] = sc.nextInt();

            while (calificaciones[i] < 0 || calificaciones[i] > 100) {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
            suma += calificaciones[i];//suma fuera del while y for
        
        }
        // Mostrar calificaciones
        for (int cal : calificaciones) {
            //suma colocada despúes de imprimir el texto
        //suma inecesaria suma = cal;
            System.out.println("Calificación: " + cal);
            
        }
    

        // Contar aprobados
        //int j = 0; inecesario
        for (int i = 0; i < calificaciones.length; i++) {
            if (calificaciones[i] >= 70) {
                aprobados++;
            }
        }

        double promedio = suma / calificaciones.length;

        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);

        sc.close();
    }
}








import java.util.Scanner;

public class SistemaVentas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // Captura de ventas
        // Se asegura de que no se ingresen ventas negativas
        for (int i = 0; i < ventas.length; i++) {

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        // Calcular total y mayor
        for (double v : ventas) {
            // Sumar cada venta al total
            total += v;

            if (v > mayor) {
                // Actualizar el mayor si la venta actual es mayor
                mayor = v;
            }
        }

        double promedio = total / ventas.length;

        // Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;

        while (j < ventas.length) {

            if (ventas[j] >= promedio) {
                contador++;
            }
            j++;
        }

        if (contador > 0)
            System.out.println("Hay ventas mayores al promedio");

        System.out.println("Total vendido: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);

        sc.close();
    }
}
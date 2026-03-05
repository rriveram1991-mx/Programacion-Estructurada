import java.util.Scanner;

public class DET_9_SEM5_2B_1 {
     public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);

        double[] ventas = new double[5];
        double total = 0;
        double mayor = 0;

        // Corregí el límite del for a < ventas.length para evitar errores de desbordamiento de memoria.
        for (int i = 0; i < ventas.length; i++) {

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        for (double v : ventas) {
            // Cambié la lógica para que todas las ventas se sumen en la variable total.
            total += v;

            // Arreglé la comparación para que la variable 'mayor' guarde correctamente el valor más alto.
            if (v > mayor) {
                mayor = v;
            }
        }

        double promedio = total / ventas.length;

        int contador = 0;
        int j = 0;

        // Implementé el incremento de j dentro del while para que el contador de ventas avance.
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
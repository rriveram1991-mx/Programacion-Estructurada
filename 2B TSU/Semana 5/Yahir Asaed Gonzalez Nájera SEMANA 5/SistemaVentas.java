package ejerciciosingricardo45;

import java.util.Scanner;

public class EjerciciosIngRicardo45 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // Captura de ventas
        // MODIFICACIÓN: Se ajustó el límite a < ventas.length para respetar el indexado (0 a 5)
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
            // MODIFICACIÓN: Se cambió a total + v para acumular el valor de todas las ventas
            total = total + v;

            if (v > mayor) {
                // MODIFICACIÓN: Se asignó 'v' directamente para capturar el valor de la venta más alta
                mayor = v;
            }
        }

        double promedio = total / ventas.length;

        // Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;

        // MODIFICACIÓN: Se ajustó la condición a < para no exceder el tamaño del arreglo
        while (j < ventas.length) {

            if (ventas[j] > promedio) {
                contador++;
            }
            // MODIFICACIÓN: Se agregó el incremento del contador 'j' para que el bucle avance
            j++;
        }

        if (contador > 0)
            System.out.println("Hay ventas mayores al promedio");

        System.out.println("Total vendido: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
    }
}
import java.util.Scanner;

public class eje27 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // Captura de ventas
        for (int i = 0; i < ventas.length; i++) { 
        // antes estaba <= y podía provocar error porque el arreglo solo llega hasta length - 1

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        // Calcular total y mayor
        for (double v : ventas) {
            total += v; 
            // antes estaba total = v y solo guardaba el último valor

            if (v > mayor) {
                mayor = v; 
                // antes se asignaba ventas[0] y siempre guardaba la primera venta en lugar de la mayor
            }
        }

        double promedio = total / ventas.length;

        // Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;

        while (j < ventas.length) { 
        // antes estaba <= y podía intentar acceder a una posición fuera del arreglo

            if (ventas[j] >= promedio) {
                contador++;
            }

            j++; 
            // faltaba incrementar j y el ciclo se volvía infinito
        }

        if (contador > 0)
            System.out.println("Hay ventas mayores al promedio");

        System.out.println("Total vendido: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
    }
}
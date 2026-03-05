import java.util.Scanner;

public class DET_SEM5_2B_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // CAPTURA DE VENTAS
        // El arreglo empieza en índice 0 y termina en length - 1
        for (int i = 0; i < ventas.length; i++) {

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            // Validación correcta para evitar ventas negativas
            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        // CALCULAR TOTAL Y MAYOR
        for (double v : ventas) {

            // Antes solo tenia = por ende nunca se hacia la suma
            total += v;

            // Antes siempre se asignaba ventas[0] ahora se asigna el valor actual
            if (v > mayor) {
                mayor = v;
            }
        }

        // PROMEDIO
        double promedio = total / ventas.length;

        // CONTAR VENTAS >= PROMEDIO
        int contador = 0;
        int j = 0;

        // Antes j era <= a ventas.length lo que hacia que el indice estuviera fuera de rango ademas no se incrementaba j lo que hacia un ciclo infinito
        while (j < ventas.length) {

            if (ventas[j] >= promedio) {
                contador++;
            }
            j++;
        }

        // RESULTADOS
        if (contador > 0)
            System.out.println("Hay ventas mayores al promedio");

        System.out.println("Total vendido: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
    }
}
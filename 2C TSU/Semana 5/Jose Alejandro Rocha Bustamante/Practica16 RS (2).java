import java.util.Scanner;
public class Practica16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // Captura de ventas
        for (int i = 0; i < ventas.length; i++) { // Se retiro el = para evitar el error de una venta de mas.

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        // Calcular total y mayor
        for (double v : ventas) { 
            total += v; //Error: No se estaba acumulando el total.

            if (v > mayor) {
                mayor = v; //Error: No se estaba actualizando el mayor.
            }
        }

        double promedio = total / ventas.length;

        // Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;

        while (j < ventas.length) {  //Error: Debe ser menor que.

            if (ventas[j] >= promedio) {
                contador++;
            }
            j++; //Error: No se estaba incrementando el contador.
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

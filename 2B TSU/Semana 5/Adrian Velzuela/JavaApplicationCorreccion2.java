    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication.correccion.pkg2;
import java.util.Scanner;
/**
 *
 * @author adrianvalenzuelaramirez
 */
public class JavaApplicationCorreccion2 {

    /**
     */
public class SistemaVentas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // captura de ventas
        // corrección : se eliminó el '<=' por '<' para evitar error de índice fuera de rango.
        for (int i = 0; i < ventas.length; i++) {

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        // calcular total y mayor
        for (double v : ventas) {
            // correccion : Se cambió '=' por '+=' para acumular todas las ventas en el total.
            total += v;

            // corrección : se cambió 'ventas[0]' por 'v'. Se debe comparar contra el valor actual del ciclo.
            if (v > mayor) {
                mayor = v;
            }
        }

        double promedio = total / ventas.length;

        // contar ventas mayores al promedio
        int contador = 0;
        int j = 0;

        // corrección : se cambió '<=' por '<' para no salirse del límite del arreglo.
        while (j < ventas.length) {
            // corrección 5: se agregó j++ para avanzar el ciclo y evitar que se congele el programa.
            if (ventas[j] > promedio) { // El requerimiento dice "mayores al promedio"
                contador++;
            }
            j++;
        }

        System.out.println("\n--- Reporte de Ventas ---");
        if (contador > 0)
            System.out.println("Estado: Hay ventas superiores al promedio.");

        System.out.println("Total vendido: $" + total);
        System.out.println("Promedio: $" + promedio);
        System.out.println("Venta mayor: $" + mayor);
        System.out.println("Cantidad de ventas superiores al promedio: " + contador);
    }
}
    }
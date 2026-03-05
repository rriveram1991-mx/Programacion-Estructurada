/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det2sem52d;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class DET2SEM52D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // 1. Captura de ventas (Corregido el índice i < ventas.length)
        for (int i = 0; i < ventas.length; i++) {

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            // Validación: No permitir ventas negativas
            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        // 2. Calcular total y venta mayor
        for (double v : ventas) {
            total += v; // Corregido: acumulador +=

            if (v > mayor) {
                mayor = v; // Corregido: asignar el valor actual 'v'
            }
        }

        // 3. Calcular promedio
        double promedio = total / ventas.length;

        // 4. Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;

        // Corregido: j < ventas.length e incrementar j++
        while (j < ventas.length) {
            if (ventas[j] > promedio) {
                contador++;
            }
            j++;
        }

        // 5. Mostrar resultados
        System.out.println("\n--- Reporte de Ventas ---");
        if (contador > 0) {
            System.out.println("Hay ventas mayores al promedio.");
        }

        System.out.println("Total vendido: $" + total);
        System.out.println("Promedio: $" + promedio);
        System.out.println("Venta mayor: $" + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
    }
}

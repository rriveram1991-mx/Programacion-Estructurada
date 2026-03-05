/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det.pkg16.sem5.pkg2b.pkg2;

import java.util.Scanner;

/**
 *
 * @author lopez
 */
public class DET16SEM52B2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // Captura de ventas
        for (int i = 0; i < ventas.length; i++) {

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            double monto = sc.nextDouble();

            while (monto < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
              monto= sc.nextDouble();
            }
            ventas[i] = monto;
        }

        // Calcular total y mayor
        for (double v : ventas) {
            total += v;

            if (v > mayor) {
                mayor = v;
            }
        }

        double promedio = total / ventas.length;

        // Contar ventas mayores al promedio
        int contador = 0;
        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i] > promedio) {
                contador++;
            }
        }
         System.out.println("\n--- Resumen de Ventas ---");
        System.out.println("Total vendido: $" + total);
        System.out.println("Promedio: $" + promedio);
        System.out.println("Venta mayor: $" + mayor);
        System.out.println("Ventas que superaron el promedio: " + contador);

        if (contador > 0) {
            System.out.println("Estatus: ¡Buen desempeno de ventas!");
        }
        
    }
}
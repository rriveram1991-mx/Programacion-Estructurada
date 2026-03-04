/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejec2sem2;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Ejec2sem2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6]; // Req 1: 6 ventas
        double total = 0;
        double mayor = 0;

        // Captura de ventas
        for (int i = 0; i < ventas.length; i++) { // Corregido: i < 6

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            // Req 2: No permitir ventas negativas
            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        // Calcular total y mayor
        for (double v : ventas) {
            total += v; // Corregido: += para sumar todas

            if (v > mayor) {
                mayor = v; // Corregido: Guardar el valor actual de 'v'
            }
        }

        // Req 3: Calcular total y promedio
        double promedio = total / ventas.length;

        // Req 4: Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;

        while (j < ventas.length) { // Corregido: j < 6
            if (ventas[j] > promedio) { // Estrictamente mayores al promedio
                contador++;
            }
            j++; // CORRECCIÓN VITAL: Sin esto se traba el programa
        }

        System.out.println("\n--- Resultados ---");
        System.out.println("Total vendido: $" + total);
        System.out.println("Promedio: $" + promedio);
        System.out.println("Venta mayor: $" + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
        
        if (contador > 0)
            System.out.println("Hay ventas superiores al promedio.");
    }
}
    
    


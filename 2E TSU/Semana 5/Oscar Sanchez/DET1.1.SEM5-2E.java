/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication47;

/**
 *
 * @author Oscar Sanchez
 */
import java.util.Scanner;

public class SistemaVentas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // --- Captura de ventas ---
        // ERROR DE EJECUCIÓN: Le quité el '=' en la condición (i < ventas.length) porque
        // con el '<=' intentaba llegar al índice 6 y me tronaba el programa (ArrayIndexOutOfBounds).
        for (int i = 0; i < ventas.length; i++) {

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        // --- Calcular total y mayor ---
        for (double v : ventas) {
            // ERROR LÓGICO: Cambié 'total = v' por 'total += v'. Me di cuenta de que 
            // no estaba acumulando la suma de las ventas, solo estaba sobreescribiendo el valor.
            total += v;

            if (v > mayor) {
                // ERROR LÓGICO: Cuando encontraba una venta mayor, estaba asignando 
                // siempre ventas[0] por error. Lo cambié a 'v' para guardar la venta actual.
                mayor = v;
            }
        }

        double promedio = total / ventas.length;

        // --- Contar ventas mayores al promedio ---
        int contador = 0;
        int j = 0;

        // ERROR DE EJECUCIÓN: Otra vez se me pasaba el índice. Le quité el '=' para que 
        // quede j < ventas.length y no me salga el error de fuera de límites.
        while (j < ventas.length) {

            // ERROR LÓGICO: El requerimiento dice estrictamente "mayores al promedio", 
            // así que le quité el '=' (dejé solo '>') porque si era igual no debía contarlo.
            if (ventas[j] > promedio) {
                contador++;
            }
            
            // ERROR LÓGICO: Me faltaba poner j++ para que el contador del ciclo avanzara. 
            // Si no lo pongo, se me queda en un ciclo infinito y se traba el programa.
            j++;
        }

        if (contador > 0)
            System.out.println("Hay ventas mayores al promedio");

        System.out.println("Total vendido: $" + total);
        System.out.println("Promedio: $" + promedio);
        System.out.println("Venta mayor: $" + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
        
    }
}
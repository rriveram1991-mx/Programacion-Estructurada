/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s5_ventas;

import java.util.Scanner;

public class S5_Ventas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // El i <= ventas.length causaba error porque el índice 6 no existe
        for (int i = 0; i < ventas.length; i++) {
            
            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            
            
            // Agregar variable monto para evitar llenar el arreglo con datos negativos
            double monto = sc.nextDouble(); 

            while (monto < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                monto = sc.nextDouble();
            }
            
            // Se guarda en el arreglo ya cuando se valida
            ventas[i] = monto;
 
            // += es la forma correcta de ponerlo
            total += monto; 
            
            // Comparar el monto actual contra el más alto guardado hasta ese momento
            if (monto > mayor) {
                mayor = monto;
            }
        }

        // El promedio se saca después de tener el total completo
        double promedio = total / ventas.length;

        
        // Cambiar el while por un for-each
        int contador = 0;
        for (double v : ventas) {
            if (v > promedio) {
                contador++;
            }
        }

        // MOSTRAR RESULTADOS
        System.out.println("\n--- Resumen de Ventas ---");
        System.out.println("Total vendido: $" + total);
        System.out.println("Promedio: $" + promedio);
        System.out.println("Venta mayor registrada: $" + mayor);
        System.out.println("Ventas que superan el promedio: " + contador);

        if (contador > 0) {
            System.out.println("Estado: Hay ventas por encima de la media.");
        }
    }
    
}

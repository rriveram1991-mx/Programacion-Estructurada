/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dt1sem5p2;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DT1SEM5P2 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // Captura de ventas
        //quitar <=
        for (int i = 0; i < ventas.length; i++) {

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        // Calcular total y mayor
        //falta contador de total
        for (double v : ventas) {
            total += v;

            if (v > mayor) {
                //tiene que ser v por la venta mayor
                mayor = v;
            }
        }

        double promedio = total / ventas.length;

        // Contar ventas mayores al promedio
        //contador de j
        int contador = 0;
        int j = 0;

        while (j <= ventas.length) {

            if (ventas[j] >= promedio) {
                contador++;
            }
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

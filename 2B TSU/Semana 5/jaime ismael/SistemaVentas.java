/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication64;

//Requerimientos del Sistema
//
//El sistema debe:
//
//Registrar 6 ventas (montos en pesos).
//No permitir ventas negativas.
//Calcular:
//Total vendido
//Promedio de ventas
//Venta mayor
//Mostrar cuántas ventas fueron mayores al promedio.

import java.util.Scanner;

public class SistemaVentas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // Captura de ventas
        //al tener igual que probocaba que se intentara acceder a una casilla de el arreglo que no existe 
        //provocando un error fatal.
        for (int i = 0; i < ventas.length; i++) {

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        } 

        // Calcular total y mayor
        for (double v : ventas) {
            total = total + v;

            if (v > mayor) {
                //se tiene que guardar el valor de la variable v no el de el arreglo 
                mayor = v;
            }
        }

        double promedio = total / ventas.length;

        // Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;
// al ser igual que provocaba que intentara acceder a una septima casilla 
//asi que el programa truena 
        while (j < ventas.length) {
//f altaba incrementar la j para salir de el bucle infinito
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
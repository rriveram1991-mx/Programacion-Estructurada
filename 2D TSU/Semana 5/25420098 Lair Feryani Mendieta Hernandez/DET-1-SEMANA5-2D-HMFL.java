/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semana.pkg5.errores;

import java.util.Scanner;
/**
 *
 * @author Lair ☆
 */


public class SistemaVentas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // Captura de ventas
        for (int i = 0; i < ventas.length; i++) {//elimine el <= y solo deje un <

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0 ) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        // Calcular total y mayor
        for (double v : ventas) {
            total += v;

            if (v > mayor) {
                mayor = v;//cambie ventas por el v
            }
        }

        double promedio = (double) total / ventas.length; //coloque otro double en la ecuacion

        // Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;

        while (j < ventas.length) {//Elimine el = y solo deje el < para que continue con el codigo y no sea mlapractiva

            if (ventas[j] > promedio) {//elimine el = y solo deje el > para correjir la mala practica
                contador++;
            }
            j++;// agregue un j++ para que continue el codigo y no se apre antes de imprimir los comandos
        }

        if (contador > 0)
            System.out.println("Hay ventas mayores al promedio");

        System.out.println("Total vendido: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
    }
}
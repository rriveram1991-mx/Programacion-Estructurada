/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det2_3sem5_2e;

import java.util.Scanner;
/**
 *
 * @author gl873
 */
public class DET2_3SEM5_2E {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor;

        // Captura de ventas
        for (int i = 0; i < ventas.length; i++) {

            System.out.print("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.print("No se permiten ventas negativas. Intente otra vez: ");
                ventas[i] = sc.nextDouble();
            }
        }

        mayor = ventas[0];

        // Calcular total y venta mayor
        for (double v : ventas) {
            total += v;

            if (v > mayor) {
                mayor = v;
            }
        }

        double promedio = total / ventas.length;

        // Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;

        while (j < ventas.length) {
            if (ventas[j] > promedio) {
                contador++;
            }
            j++;
        }

        System.out.println("Total vendido: " + total);
        System.out.println("Promedio de ventas: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Ventas mayores al promedio: " + contador);

        sc.close();
    }
}
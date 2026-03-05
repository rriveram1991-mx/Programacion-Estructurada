/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det1.pkg2.sem5;

import java.util.Scanner;

/**
 *
 * @author emili
 */
public class DET12SEM5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;
        // Captura de ventas
        //se quita el igual
        for (int i = 0; i < ventas.length; i++) {
            System.out.println("Ingrese venta #" + (i+1) + ": ");
            ventas[i] = sc.nextDouble();
            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }
        // Calcular total y mayor
        for (double v : ventas) {
            //se corrige el sumador
            total += v;
            if (v > mayor) {
                //en vex de ventas en v
                mayor = v;
            }
        }
        double promedio = total / ventas.length;
        // Contar ventas mayores al promedio
        int contador = 0;
       int j = 0;
       //se quita el igual
        while (j <ventas.length) {
            if (ventas[j] >= promedio) {
                contador++;
            }
            //se agrega el contador
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

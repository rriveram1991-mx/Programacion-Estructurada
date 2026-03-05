/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication55;
 import java.util.Scanner;
/**
 *
 * @author artur
 */
public class JavaApplication55 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = -1; // inicializar en -1 para garantizar que cualquier venta sea mayor

        // Captura de ventas
        for (int i = 0; i < ventas.length; i++) {
            System.out.print("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.print("No se permiten ventas negativas. Intente de nuevo: ");
                ventas[i] = sc.nextDouble();
            }
        }

        // Calcular total y mayor
        for (double v : ventas) {
            total += v;
            if (v > mayor) {
                mayor = v;
            }
        }

        // Calcular promedio
        double promedio = total / ventas.length;

        // Contar ventas mayores o iguales al promedio
        int contador = 0;
        int j = 0;
        while (j < ventas.length) {
            if (ventas[j] >= promedio) {
                contador++;
            }
            j++;
        }

        // Mostrar resultados
        System.out.println("Total vendido: " + total);
        System.out.println("Promedio de ventas: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Cantidad de ventas mayores o iguales al promedio: " + contador);
    }
}


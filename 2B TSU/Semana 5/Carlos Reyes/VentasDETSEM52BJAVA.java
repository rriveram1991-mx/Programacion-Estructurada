/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ventasdet.sem5.pkg2b.java;

import java.util.Scanner;

/**
 *
 * @author juanc
 */
public class VentasDETSEM52BJAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        //Quitamos el <= por <
        for (int i = 0; i < ventas.length; i++) {

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        for (double v : ventas) {
            //Se cambió de = a +=
            total += v; 

            if (v > mayor) {
                //Se corrigió la asignación de valores de ventas a v
                mayor = v; 
            }
        }

        double promedio = total / ventas.length;

        // Se cuentan las ventas mayores al promedio
        int contador = 0;
        int j = 0;

        //Se quitó el = que provocaba errores de sintaxis
        while (j < ventas.length) { 

            if (ventas[j] >= promedio) {
                contador++;
            }
            j++; //Se incrementó el while para evitar bucles
        }

        if (contador > 0)
            System.out.println("Hay ventas mayores al promedio");

        System.out.println("Total vendido: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
    }
    }
    


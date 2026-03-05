DET_SEM5_2B_JAVA_2
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det_sem5_2b_java_2;

import java.util.Scanner;

/**
 *
 * @author Lex
 */
public class DET_SEM5_2B_JAVA_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // Captura de ventas
        for (int i = 0; i < ventas.length; i++) { //Quitamos el <= por solo < =)

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        // Calcular total y mayor
        for (double v : ventas) {
            total += v; //Corregimos sintaxis de = a +=  +)

            if (v > mayor) {
                mayor = v; //Corregimos la asignación de valores de ventas a v =)
            }
        }

        double promedio = total / ventas.length;

        // Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;

        while (j < ventas.length) { //quitamos el = que provoca errores de sintaxis =)

            if (ventas[j] >= promedio) {
                contador++;
            }
            j++; //Incrementamos el while para evitar bucles =)
        }

        if (contador > 0)
            System.out.println("Hay ventas mayores al promedio");

        System.out.println("Total vendido: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
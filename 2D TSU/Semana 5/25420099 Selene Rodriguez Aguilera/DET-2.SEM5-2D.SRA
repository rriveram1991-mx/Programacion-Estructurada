/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication66;

import java.util.Scanner;

/**
 *
 * @author crist
 */
public class JavaApplication66 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     

        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // Captura de ventas
        for (int i = 0; i < ventas.length; i++) { //Quite "=" ya que estoy intentado acceder a una posicion que no existe.

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        // Calcular total y mayor
        for (double v : ventas) {
            total += v;  // Aqui no estaba guardando el total

            if (v > mayor) {
                mayor = v;//Aqui la variable estaba mal no es "ventas" si no que es "v", aparte de que estaba calculando mal la venta.
            }
        }

        double promedio = total / ventas.length;

        // Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;

        while (j < ventas.length) { //le quite el "=" ya que ese igual no esta en el "while" asi por decirlo.

            if (ventas[j] > promedio) { //le quito el igual ya que son MAYORES no iguales.
                contador++;
            }
        }

        if (contador > 0)
            System.out.println("Hay ventas mayores al promedio");

        System.out.println("Total vendido: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
        //En conclusion aqui habia errores por decirlo de dedo ya que en algunas lineas venian "<=" en lugar de "<" habia errores en los cuales 
        //las ventas estaban mal ya que eran mayores no iguales ni menores, en el while no estaba bien ya que no incrementaba la variable "j"
        //tambien estaban las condiciones incorrectas para los "mayores"
}
}

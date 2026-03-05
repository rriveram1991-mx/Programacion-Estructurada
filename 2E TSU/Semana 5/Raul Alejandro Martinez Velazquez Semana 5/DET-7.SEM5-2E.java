/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaventas;
import java.util.Scanner;

public class SistemaVentas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // Captura de ventas
        //Error de indice en el <=
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
           //Error al calcular al total, ya que solamente se calculaba la ultima venta
            total += v;

            if (v > mayor) {
//Es mejor poner V para evitar errores de calculo
                mayor = v;
            }
        }

        double promedio = total / ventas.length;

        // Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;
//Debe ser < y no <= porque se crea un ciclo infinito
        while (j < ventas.length) {

            if (ventas[j] > promedio) {
                contador++;
            }
            //Ademas nunca se incremento J
            j++;
        }

        //Se elimina el if porque tecnicamente ya se esta mostrando en venta mayor

        System.out.println("Total vendido: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
    }
}
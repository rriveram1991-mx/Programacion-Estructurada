/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dets5act2;
import java.util.Scanner;
/**
 *
 * @author miguelgu
 */
public class DetS5Act2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        

        // Captura de ventas
        for (int i = 0; i < ventas.length; i++) //no se debe de poner el = 
        {

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        // Calcular total y mayor
        double mayor = ventas[0]; //si ponemos = 0 no seria correcto se toma el primero valor para al compararlo se vaya guardando el de mayor valor.
        for (double v : ventas) {
            total += v; //Aqui debe ser += ya que si no solo se guarda un valor.

            if (v > mayor) {
                mayor = v;
            }
        }

        double promedio = total / ventas.length;

        // Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;

        while (j < ventas.length) // no se debe de poner el = 
        {

            if (ventas[j] > promedio) //aqui debe ser > ya que nos pide mayor al promedio, no mayor o igual
            {
                contador++;
            }
            j++; //faltaba aumentar j, ya que si no se queda en 0 y seria un bucle infinito
        }

        if (contador > 0)
            System.out.println("Hay ventas mayores al promedio");

        System.out.println("Total vendido: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
    }
    
}

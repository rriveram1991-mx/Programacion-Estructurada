/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det.pkg1.sem5.ezco.pkg1;

import java.util.Scanner;

/**
 *
 * @author Zoé
 */
public class DET1SEM5EZCO1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          Scanner sc = new Scanner(System.in);
        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;
        // Captura de ventas
        for (int i = 0; i <ventas.length; i++) {//cambie <= por < ya que no puede ser mauyor e igual en el arreglo
            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();
            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }
        // Calcular total y mayor
        for (double v : ventas) {
            total = total+ v;
            if (v > mayor) {
                mayor = v;//no se estaba asignando la venta actual
            }
        }
        double promedio = total / ventas.length;
        // Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;
        while (j < ventas.length) {//no puede ser <=, tiene que ser <
            if (ventas[j] >= promedio) {
                contador++;
            }
            j=j+1; //j no estaba incrementando
        }
        if (contador > 0)
            System.out.println("Hay ventas mayores al promedio");
        System.out.println("Total vendido: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
    }
    
}

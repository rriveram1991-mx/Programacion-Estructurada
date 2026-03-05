/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaventas;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class SistemaVentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor;
        int contador = 0;

        //  Registrar 6 ventas (sin permitir negativas)
        for (int i = 0; i < ventas.length; i++) {

            System.out.print("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.print("No se permiten ventas negativas. Intente de nuevo: ");
                ventas[i] = sc.nextDouble();
            }
        }

        //  Inicializar mayor
        mayor = ventas[0];

        //  Calcular total y venta mayor
        for (double v : ventas) {
            total += v;

            if (v > mayor) {
                mayor = v;
            }
        }

        //  Calcular promedio
        double promedio = total / ventas.length;

        //  Contar ventas mayores al promedio
        for (double v : ventas) {
            if (v > promedio) {
                contador++;
            }
        }

        //  Mostrar resultados
        System.out.println("----- RESULTADOS -----");
        System.out.println("Total vendido: $" + total);
        System.out.println("Promedio de ventas: $" + promedio);
        System.out.println("Venta mayor: $" + mayor);
        System.out.println("Ventas mayores al promedio: " + contador);

        sc.close();
    }
}
    
    


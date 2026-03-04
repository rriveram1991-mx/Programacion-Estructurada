/* Requerimientos del Sistema

El sistema debe:

Registrar 6 ventas (montos en pesos).
No permitir ventas negativas.
Calcular:
Total vendido
Promedio de ventas
Venta mayor
Mostrar cuántas ventas fueron mayores al promedio. */
package PracticaCorreccionS5;
import java.util.Scanner;

public class PracticaCorreccionS5_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // Captura de ventas
        for (int i = 0; i < ventas.length; i++) {

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();
             if (ventas[i] > mayor) {
                mayor = ventas[i];
            }
            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }


        // Contar ventas mayores al promedio
        int contador = 0;
        
        // Calcular total y mayor
        for (double v : ventas) { 
            total += v;
        }
          double promedio = total / ventas.length;
                
          for (double v : ventas) { 
            if(v>promedio){
            contador++;
            }
        }
          
        if (contador > 0)
            System.out.println("Hay ventas mayores al promedio");

        System.out.println("Total vendido: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
    }
}
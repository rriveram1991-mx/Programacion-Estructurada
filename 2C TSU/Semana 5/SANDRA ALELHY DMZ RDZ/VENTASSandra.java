
package ventas.sandra;

import java.util.Scanner;

public class VENTASSandra {
//SANDRA DOMINGUEZ
    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // Captura de ventas
        for (int i = 0; i < ventas.length; i++)  //QUITE EL =
        {

            System.out.println("Ingrese venta #" + (i + 1) + ":  ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo: $");
                ventas[i] = sc.nextDouble();
            }
        }
        
        System.out.println("-------------------------------------------------");

        // Calcular total y mayor
        for (double v : ventas) {
            total += v;  //FALTA EL +, PARA QUE SE SUMEN.

            if (v > mayor) {
                mayor = v;  //
            }
        }

        double promedio = total / ventas.length;

        // Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;

        while (j <ventas.length) //QUITE EL =
        {

            if (ventas[j] >= promedio) 
            {
                contador++;
            }
            j++;
        }

        if (contador > 0) 
        {
            System.out.println("!Hay ventas mayores al promedio!");

        System.out.println("Total vendido: $" + total);
        System.out.println("Promedio de venta: " + promedio);
        System.out.println("Venta mayor: $" + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
        }  //faltaban las {}

    }
    
}

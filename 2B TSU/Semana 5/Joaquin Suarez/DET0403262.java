/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det040326.pkg2;

import java.util.Scanner;

/**
 *
 * @author ssjoa
 */
public class DET0403262 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
         Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;
        double mayot = 0;

        // Captura de ventas
        for (int i = 0; i < ventas.length; i++)
            /*de dejar el indicador en "<=" en realidad no podemos ingresar al arreglo desde el principio pues la condicion no se cumplira*/
        {

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) 
            {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        // Calcular total y mayor
        for (double v : ventas)
        {
            total += v;
            /*de haberlo dejado solo como un "+" no habriamos conseguido guardar las cantidades por indicar al programa que el nuevo valor es el mayor*/

            if (v > mayor) 
            {
                mayor = v;/*es aqui donde guardamos los valores "reales" de venta puesto que "ventas" no sigue con la consiga del orden, volviendo siempre al principio*/
            }
        }

        double promedio = total / ventas.length;

        // Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;

        while (j < ventas.length)
            /*se establece el limite como "<" asecas para asegurarnos de que los lugares del arreglo no empaten con la condicion*/
        {

            if (ventas[j] >= promedio)
            {
                contador++;
            }
            j++;/*incremento del arreglo para asegurar su uso*/
        }

        if (contador > 0)
            System.out.println("Hay ventas mayores al promedio");

        System.out.println("Total vendido: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
    }
        
        
        
        
        
        
        
        
    }
    
}

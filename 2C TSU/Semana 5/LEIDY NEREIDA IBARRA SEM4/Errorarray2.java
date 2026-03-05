/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package errorarray2;
import java.util.Scanner;
/**
 *
 * @author leidy
 */
public class Errorarray2 {

    /**
     * Requerimientos del Sistema

El sistema debe:

Registrar 6 ventas (montos en pesos).
No permitir ventas negativas.
Calcular:
Total vendido
Promedio de ventas
Venta mayor
Mostrar cuántas ventas fueron mayores al promedio.

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // Captura de ventas
        for (int i = 0; i < ventas.length; i++) {//lo inicializo en 0 para q vay amas en orden numerico

            System.out.println("Ingrese venta #" + i + ": ");
            ventas[i] = sc.nextDouble();
            total=total+ventas[i];//aqui agregue la suma total de mis ventas en un sumador
            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            
                       
            }
        }

        // Calcular total y mayor
        for (double v : ventas) {// aqui el nuevo valor q recorrere el array tomando valor 0 asi sucesivamdente es algo como "POR CADA EN ARRAY"
            if (v > mayor) {// aqui lo que pasa es  es q al comparar si v mi nuevo valor es mayor al valor que tengo ,ahora el valor mayor sera v
                //(practicamente v esta en el valor 0 de mi array  cuandi recorre el trazo ve el nuevo valor y luego compara y guarda si es valor mayor)
                mayor = v;//  aqui algo asi se invierte ,regresa aal ciclo 
        
            }
            
        }
                    
        
        System.out.println("LA VENTA MAS GRANDE:"+ mayor);
        double promedio = total / ventas.length;
         System.out.println("   LA VENTA PROMEDIO :"+promedio);
        // Contar ventas mayores al promedio
        int contador = 0;
        int i = 0;

        while (i < ventas.length) {
          if (ventas[i] > promedio) {
                contador++;
            }
          i++;// agrego un contador que sume el indice para q no se atasque  ya q en caso de no tener siempre sera menor a ventas y si le sumamos 1 ya no
        }

        if (contador > 0){
            System.out.println("Hay ventas mayores al promedio");
        }
        System.out.println("Total vendido: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
    
}
}
    

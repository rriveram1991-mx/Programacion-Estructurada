/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s5.ventas;

import java.util.Scanner;

/**
 *
 * @author UTT
 */
public class S5Ventas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;
        // Captura de ventas
        /*
        El arreglo "ventas" tiene 6 posiciones, pero los índices válidos van de 0 a 5.
        Al usar "<=", el ciclo intenta acceder a ventas[6], lo cual no existe y 
        provoca un error
        */
        /*
        Corrección:
        Se cambió "<=" por "<" para que el ciclo solo recorra los índices válidos del 
        arreglo (0 a 5) y no se salga del límite.
        */
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
            /*
            Aquí no se estaban sumando las ventas. Cada vez que el ciclo recorría un valor, 
            reemplazaba el contenido de "total" por el nuevo valor.
            */
            total += v; //Se agrego + antes del = para generar la suma correctamente
            if (v > mayor) {
                //Cuando encontraba una venta mayor, guardaba siempre el valor de la primera 
                //venta (ventas[0]) en lugar del valor actual que se estaba evaluando.
                mayor = v; //Corrección: Ahora se guarda directamente el valor actual que es mayor.
            }
        }
        double promedio = total / ventas.length;
        // Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;
        /*
        Problema:
        De nuevo se usa "<=", lo que permite que j llegue a 6.
        El arreglo solo tiene índices de 0 a 5, por lo que intentar acceder a ventas[6] provoca error.
        */
        while (j < ventas.length) { //Codigo corregido eliminando el =
            /*
            Problema:
            Habia un >= promedio 
            Esto contaba también las ventas que eran iguales al promedio.
            */
            if (ventas[j] > promedio) { //Eliminar el igual para que estrictamente solo se cumpla la condicion cuando sea mayor al promedio
                contador++;
            }
            /*
            Problema:
            Dentro del ciclo nunca se incrementa el valor de j.
            Esto provoca que j siempre sea el mismo valor y el ciclo se repita infinitamente.
            */
            j++; //Se agregó "j++" para que el índice avance en cada iteración y el ciclo pueda terminar.
        }
        System.out.println("Total vendido: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
        sc.close();
    }
}
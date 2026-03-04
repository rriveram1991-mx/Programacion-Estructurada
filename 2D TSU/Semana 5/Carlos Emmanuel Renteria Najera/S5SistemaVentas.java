/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s5.sistemaventas;

import java.util.Scanner;

/**
 *
 * @author Memer
 */
public class S5SistemaVentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor = 0;

        // Captura de ventas
        for (int i = 0; i < ventas.length; i++) { //1- lo comparaba con el largo del array, haciendo que sea mayor a lo que le array pueda almacenar, solo quite el =

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            if (ventas[i] < 0) { //2- aun que no estaba mal, a la hora de captar las ventas negativas, es claro que es una mala practica, y hace que nunca termine el while, solo lo cambie por un if
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        // Calcular total y mayor
        for (double v : ventas) { 
            total += v; //3- no sumaba solo asiganaba el ultimo valor de la lista a total, solo le agrege un + antes del = para que empezara a sumarlo

            if (v > mayor) {
                mayor = v; //4- le aginaba el primer valor de la lista, haciendo que cuando se cumpliera la condicion, tomara ese valor, solo remplace el ventas{o} con v, el cual es que maneja la listas en el foreach 
            }
        }

        double promedio = total / ventas.length;

        // Contar ventas mayores al promedio
        int contador = 0;

        for (double j : ventas) { //5-cambie por completo la estrucutra, y use un for each para remplazar el while, haciendo que el ciclo se complete y no truene la maquina

            if (j >= promedio) {
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

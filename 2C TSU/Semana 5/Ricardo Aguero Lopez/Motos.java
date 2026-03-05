/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package motos;

import java.util.Scanner;

/**
 *
 * @author aguer
 */
public class Motos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
          Scanner sc = new Scanner(System.in);

        double[] ventas = new double[6];
        double total = 0;
        double mayor =0;

        // Captura de ventas
        for (int i = 0; i < ventas.length; i++) {// error de logica no se le pone <= ya que querra tomar el espacio 6 osea uno de mas al indicado porque el arreglo siempre va de 0 a 5 en este caso se registrarian las 6 ventas 

            System.out.println("Ingrese venta #" + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();

            while (ventas[i] < 0) {
                System.out.println("No se permiten ventas negativas. Intente de nuevo:");
                ventas[i] = sc.nextDouble();
            }
        }

        // Calcular total y mayor
        for (double v : ventas) {
            total += v;// aqui se le agrega el mas para que vaya haciendo la sumatoria si no solo se quedaria el ultimo valor de v y no sumaria 

            if (v > mayor) {
                mayor = v;// aqui es mayor = v porque si lo dejamos como antes solo se quedaria con el valor del arreglo en la posicion 0 osea siempre seria el  mismo valor 
               
            }
        }

        double promedio = total / ventas.length;

        // Contar ventas mayores al promedio
        int contador = 0;
        int j = 0;

        while (j < ventas.length) {// tiene que se menor  no menor igual ya que al ser menor igual va a tomar un espacio mas de memoria si se puede decir asi 

            if (ventas[j] > promedio) {// como la instruccion indica que sean mayores al promedio se le quita el igual porque despues tambien los tomaria en cuenta 
                contador++;
            }
            j++;// faltaba incrementar de uno en uno 
        }

        if (contador > 0){
            System.out.println("Hay ventas mayores al promedio");}

        System.out.println("Total vendido: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Venta mayor: " + mayor);
        System.out.println("Cantidad mayores al promedio: " + contador);
    }

        
    }
    


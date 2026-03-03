/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req2sem52b;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class REQ2SEM52B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

        double[] precios = new double[4];
        double total = 0;

        for (int i = 0; i < precios.length; i++) {
            System.out.print("Ingresa el precio del objeto " + (i + 1) + ": ");
            precios[i] = sc.nextDouble();
        }

        for (int i = 0; i < precios.length; i++) {
            total += precios[i];
        }

        double descuento = total * 0.10;
        double totalFinal = total - descuento;

        System.out.println("Total sin descuento: " + total);
        System.out.println("Total con descuento: " + totalFinal);
    }

    }
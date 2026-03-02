/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req3.sem5.pkg2b;

import java.util.Scanner;

/**
 *
 * @author lopez
 */
public class REQ3SEM52B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner lr = new Scanner(System.in);
    String[] nombres = new String[5];
    for (int i = 0; i < nombres.length; i++) {
            System.out.print("Ingresa un nombre: ");
            nombres[i] = lr.nextLine();
        }
        System.out.println("\nNombres que empiezan con A:");
        for (String n : nombres) {
            if (n.startsWith("A") || n.startsWith("a")) {
                System.out.println(n);
            }
        }
    }
}

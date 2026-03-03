/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req1sem52b;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class REQ1SEM52B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

        int[] exp = new int[5];
        int mayor = 0;

        for (int i = 0; i < exp.length; i++) {
            System.out.print("Ingresa la experiencia del jugador " + (i + 1) + ": ");
            exp[i] = sc.nextInt();
        }

        for (int i = 0; i < exp.length; i++) {
            if (exp[i] > mayor) {
                mayor = exp[i];
            }
        }

        System.out.println("La mayor experiencia es: " + mayor);
    }
}
    
    
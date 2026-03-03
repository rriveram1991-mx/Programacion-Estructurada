/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req4sem52b;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class REQ4SEM52B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        ArrayList<Integer> danios = new ArrayList<>();

        int numero;

        System.out.println("Ingresa daños (-1 para terminar):");

        do {
            numero = sc.nextInt();
            if (numero != -1) {
                danios.add(numero);
            }
        } while (numero != -1);

        System.out.println("\nDaños mayores a 10:");

        for (int danio : danios) {
            if (danio > 10) {
                System.out.println(danio);
            }
        }
    }
}
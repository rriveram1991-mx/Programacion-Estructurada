/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req1.pkg1.sem5;

import java.util.Scanner;

/**
 *
 * @author lopez
 */
public class REQ11Sem5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner lr=new Scanner(System.in);
     int[] numero = new int[6];
     for (int i=0; i < numero.length; i++){
         System.out.println("Ingrese un numero: ");
         numero[i]= lr.nextInt();
     }
        System.out.println("Numeros ingresados: ");
        for(int i=0; i < numero.length; i++){
            System.out.println(numero[i]);    
        }
    }
    
}
    

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req2.sem5.pkg2b;

import java.util.Scanner;

/**
 *
 * @author lopez
 */
public class REQ2SEM52B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner lr= new Scanner(System.in);
    int[] calif= new int [7];
    int suma=0;
    for (int i= 0; i < calif.length; i++){
        System.out.println("Ingrese Calificacion:" );
    calif[i]= lr.nextInt();
    suma = suma + calif[i];
    }
        System.out.println("Calificaciones ingresadas");
        for(int i= 0; i< calif.length; i++){
            System.out.println(calif[i]);
        }
        double promedio = (double) suma / calif.length;
         System.out.println("El promedio es: " + promedio);
           }
    }

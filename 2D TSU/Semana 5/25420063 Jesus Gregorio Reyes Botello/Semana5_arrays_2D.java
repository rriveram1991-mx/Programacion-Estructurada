/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semana5_arrays_2d;

import java.util.Scanner;

/**
 *
 * @author jessr
 */
public class Semana5_arrays_2D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner (System.in);
        int [] cal = {8,9,4,6,7,10};
        int sum = 0;
        for (int i = 0; i < cal.length; i++){
        sum += cal[i];
       }
        double prom = (double) sum /cal.length;
        System.out.println("Promedio: " + prom);
    }
    
}

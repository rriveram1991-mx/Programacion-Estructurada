/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semana5_arrays__2d;

import java.util.Scanner;

/**
 *
 * @author jessr
 */
public class Semana5_arrays__2D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner (System.in);
        int[] n = {1,2,4,5,6,};
        for (int i = 0; i < n.length; i++){
        if (n[i] % 2  == 0){
            System.out.println("Numeros pares: " + n[i]);
        }
        }
    }
    
}

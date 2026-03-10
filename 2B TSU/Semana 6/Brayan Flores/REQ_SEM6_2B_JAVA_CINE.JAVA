REQ_SEM6_2B_JAVA_CINE
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asientos.de.cine;

import java.util.Scanner;

/**
 *
 * @author Brayan
 */
public class AsientosDeCine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
        int[][] asientos = {
        {1,2},
        {3,4}
        };
        
        System.out.println("Elije el haciento:");
        System.out.println("Segun las filas y columna:");
        System.out.println("   0  1");
        System.out.println("0 [1][2]");
        System.out.println("1 [3][4]");
        System.out.println("");
        System.out.println("El asiento en la fila 0, columna 1 es: "+ asientos[0][1]);
       
    }
}
    

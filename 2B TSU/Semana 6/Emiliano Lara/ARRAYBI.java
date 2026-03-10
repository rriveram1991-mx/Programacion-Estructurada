/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arraybi;

import java.util.Scanner;

/**
 *
 * @author emili
 */
public class ARRAYBI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner ch = new Scanner(System.in);
  
    boolean en = false; 

   //CINEEEE
   /* String[][] matriz = {
        {"1", "2", "3"},
        {"4", "5", "6"},
        {"7", "8", "9"}
    };
        System.out.println("1, 2, 3");
        System.out.println("4, 5, 6");
        System.out.println("7, 8, 9");
    System.out.println("Inserte el lugar que quiere (ej: 1):");
    String el = ch.nextLine();

    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            if (matriz[i][j].equalsIgnoreCase(el)) {
                System.out.println("Asiento " + el + " reservado con éxito.");
                matriz[i][j] = "XX"; 
                en = true;
                break;
            }
        }
        if (en)
            break;   
    }
    if (!en) {
        System.out.println("Ese asiento no existe o ya está ocupado.");
    }
}
}*/
   //ESTACIONAMIENTOOOO
 String[][] matriz = {
        {"A1", "A2", "A3"},
        {"A4", "A5", "A6"},
        {"A7", "A8", "A9"}
    };
        System.out.println("A1, A2, A3");
        System.out.println("A4, A5, A6");
        System.out.println("A7, A8, A9");
    System.out.println("Inserte el lugar de estacionamiento que quiere (ej: A1):");
    String el = ch.nextLine();

    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            if (matriz[i][j].equalsIgnoreCase(el)) {
                System.out.println("Lugar para estacionar " + el + " libre, pase a estacionarse");
                matriz[i][j] = "XX"; 
                en = true;
                break;
            }
        }
        if (en)
            break;   
    }
    if (!en) {
        System.out.println("Ese lugar no existe o ya está ocupado.");
    }
}
}




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req2.sem5.pkg2b.java;

import java.util.Scanner;

/**
 *
 * @author Lair ☆
 */
public class REQ2SEM52BJAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String [] nom = new String [3];
        for(int i = 0; i < nom.length; i++){
            System.out.println("ingrese nombre del trabajador "+ (i+1) +": ");
            nom[i] = leer.nextLine();
        }  
        for(int i = 0; i< nom.length;i++){
            System.out.println("trabajador "+ (i+1) +": " + nom[i]);
        
        }
        
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s5.foreach;

import java.util.Scanner;

/**
 *
 * @author Memer
 */
public class S5ForEach {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //declaro mis variables junto a mi Array
        
        Scanner lr = new Scanner(System.in);
        
        double[] depositos = new double[5];
        boolean r = true;
        
        //le pido que haga depositos, en caso de que no quiera seguir haciendo cierra el ciclo
        for (int i = 0; i <= depositos.length ; i++) {
           
            System.out.println("ingrese los depositos " + (i+1) + ": ");
            depositos[i] = lr.nextDouble();
            
            System.out.println("quieres contunuar introduciendo deposistos");
            r = lr.nextBoolean();
            
            if (!r) {
                break;
            }
            
        }
        
        //declaro otra variable y hago una suma
        
        double suma = 0;
        
        for (double total : depositos){
        
            suma += total;    
            
        }
        
        //indigo al usuario cuando fue el total depositado
        System.out.println("su total depositado es de: " + suma);
       
        
        
    }
    
}

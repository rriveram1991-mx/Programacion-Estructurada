/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s5.array;

import java.util.Scanner;

/**
 *
 * @author Memer
 */
public class S5Array {

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
        
        //aqui muestro los depositos que se realizaron
        
        for(double mostrar : depositos){
            //mustra los depositos que fueron diferentes a 0
            if (mostrar != 0) {
                System.out.println("tu depositos fueron:" + mostrar);    
            }
            
        
        }

    }
    
}

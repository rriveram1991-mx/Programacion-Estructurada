/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package array02032026;

import java.util.Scanner;

/**
 *
 * @author ssjoa
 */
public class Array02032026 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       Scanner leer = new Scanner(System.in);
       int [] archivero = new int [4];
       
       for (int x = 0; x < archivero.length; x++)
       {
           System.out.println("Dame el numero del expediente del archivo... "+(x+1)+ ":");
           archivero[x]=leer.nextInt();
           
       }
       
        for (int x = 0; x < archivero.length; x++)      
        {
           System.out.println("El expediente  "+archivero[x]+" esta en el archivo: "+(x+1));
           
       }

       
       
        
    }
}

        
    
    


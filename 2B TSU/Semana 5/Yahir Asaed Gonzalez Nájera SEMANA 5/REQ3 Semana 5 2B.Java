/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosingricardo43;

import java.util.Scanner;

/**
 *
 * @author yahir
 */
public class EjerciciosIngRicardo43 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        String colora;
        boolean encontrado=false;
        
                     System.out.println("Ingrese un color:");
             colora=leer.next();
             
        
        String[] colores = {"Rojo","Azul","Amarillo"};
         for (String color : colores) {
         encontrado = encontrado || color.equals(colora);
         }
         System.out.println(encontrado+ " Sí está ese color!");
         
    }
    
}

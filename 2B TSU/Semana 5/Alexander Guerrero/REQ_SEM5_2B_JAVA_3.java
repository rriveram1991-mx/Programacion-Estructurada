/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req_sem5_2b_java_3;

import java.util.Scanner;

/**
 *
 * @author Lex
 */
public class REQ_SEM5_2B_JAVA_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner leer = new Scanner(System.in);
        String[] nombres = new String[3];
        
        for (int i = 0; i < nombres.length; i++){
            System.out.println("Ingrese nombre de alumno: ");
            nombres[i] = leer.nextLine();
        }
        //usamos for.each
        for (String alumnos : nombres){
            System.out.println("Nuevo alumno: " +alumnos);
        }
    }
    
}

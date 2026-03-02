/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req_sem5_2b_java_2;

import java.util.Scanner;

/**
 *
 * @author Lex
 */
public class REQ_SEM5_2B_JAVA_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner leer = new Scanner(System.in);
        String[] users = new String[3];
        
        for (int i = 0; i < users.length; i++){
            System.out.println("Ingrese nombre de usuario: ");
            users[i] = leer.nextLine();
        }
        
        System.out.println("Usuarios ingresados: ");
        for(int i = 0; i<users.length; i++){
            System.out.println(users[i]);
        }
    }
    
}

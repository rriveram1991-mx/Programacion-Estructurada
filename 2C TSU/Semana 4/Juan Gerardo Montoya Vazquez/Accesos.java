/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package accesos;

import java.util.Scanner;

/**
 *
 * @author juang
 */
public class Accesos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
         int intentos=0;
        boolean acceso=false;
        
         String u="admin";
        String p="1234";
        
        String usuario;
        String pass;
        int opcion;
        
    
        
         while (intentos < 3 && !acceso) {
            System.out.print("Usuario: ");
            usuario = sc.nextLine();

            System.out.print("Contraseña: ");
            pass = sc.nextLine();
           
                        if (usuario.equals(u) && pass.equals(p)) {
                acceso = true;
                System.out.println("Acceso concedido.");
                System.out.println("\n1. salir");
                opcion=sc.nextInt();
                switch(opcion){
                    case 1:
                        System.out.println("salienso del sistema........");  
                        sc.close();
                    break;
                }
                
                return;
            } else {
                intentos++;
                System.out.println("Datos incorrectos. Intento " + intentos + " de 3.");
            }
        }

        if (!acceso) {
            System.out.println("Cuenta bloqueada. Máximo de intentos alcanzado.");
        }
         
         sc.close();
    }
    
}

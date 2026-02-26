/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemausuario;

import java.util.Scanner;

/**
 *
 * @author aguer
 */
public class SistemaUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
       String usuario="Admin123", contraseña= "12345", usuario1,contraseña1;
       int intentos=0,opc;
       while (intentos<3){
           System.out.println("Ingresa el nombre de usuario:");
           usuario1= leer.nextLine();
           System.out.println("Ingresa la contraseña");
           contraseña1= leer.nextLine();
           if(usuario.equals(usuario1) && contraseña.equals(contraseña1)){
               System.out.println("1. Salir");
               System.out.println("Ingresa la opcion que deseas realizar");
               opc= leer.nextInt();
               switch(opc){
                   
                   case 1:
                       
                       System.out.println("Saliendo del programa");
                       System.out.println("Intentos fallidos" + intentos);
                       
                      return;
                       
                       
                       
                   
               }
               
           }else { 
               System.out.println("Usuario o contraseña no validos");
               intentos++;
           }
           
       }
       if( intentos>=3){
           System.out.println("cuaneta bloqueda ");
           System.out.println("Intentos fallidos" + intentos);
           
       }
        
       
    }
    
}

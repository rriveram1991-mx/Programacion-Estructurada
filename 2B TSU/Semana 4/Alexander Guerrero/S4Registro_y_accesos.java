/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s4.registro_y_accesos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lex
 */
public class S4Registro_y_accesos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner leer = new Scanner(System.in);
        ArrayList<String> contador = new ArrayList<>();
        
        String usuario = "admin";
        String contraseña = "1234";
        int intentos = 3; // Definimos el maximo de intentos de login
        boolean log = false; // Servira para definir si el user ingreso correctamente los datos
        
        do { //Abrimos el ciclo de que debemos hacer (Do-While)
        System.out.println("Ingresa user: ");
        String user = leer.next();
        System.out.println("Contraseña: ");
        String pass = leer.next();
        
        if (user.equals(usuario) && pass.equals(contraseña)){
            log = true;   
        } else {
            contador.add(usuario);
            intentos--; //Aqui se restan los intentos (intentos = intentos -1)
            if (intentos>0){
                System.out.println("Datos incorrectos");
            }
        }
        
        }while (!log && intentos>0); //Aqui se repite el ciclo mientras no este logueado y aun tenga intentos
        
        if (log){
            System.out.println("Login exitoso");
            int opcion=0;
            do{
                System.out.println("\n==============MENU==============");
                System.out.println("\n1) Administrar perfil");
                System.out.println("2) Ver intentos fallidos previos");
                System.out.println("3) Cerrar sesión");
                System.out.println("\nSeleccione una opcion: ");
                opcion = leer.nextInt();
                switch(opcion) {
                    case 1:
                        System.out.println("Perfil: Administrador del Sistema");
                        break;
                    case 2:
                        System.out.println("Total de fallos: " + contador.size());
                        break;
                    case 3:
                        System.out.println("Cerrando sesión...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 3);
            
        } else {
            System.out.println("Datos erroneos. Ya bloqueaste tu cuenta animal");
            System.out.println("Intentos fallidos: " +contador);
        }
    
    }
    
}

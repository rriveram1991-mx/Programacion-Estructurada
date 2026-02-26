/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s4registroacceso;

import java.util.Scanner;

public class S4RegistroAcceso {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String userC = "admin";
        String passC = "1234";

        int intentos = 0, opcion;
        boolean acceso = false;

        while (intentos < 3 && !acceso) {
            System.out.print("Ingresa tu usuario: ");
            String user = sc.nextLine();

            System.out.print("Ingresa tu contraseña: ");
            String pass = sc.nextLine();

            if (user.equals(userC) && pass.equals(passC)) {
                acceso = true;
                System.out.println("Acceso concedido");
                System.out.println("Intentos fallidos: " + intentos);
                System.out.println("===== MENU =====");
                System.out.println("1. Salir");
                opcion = sc.nextInt();
                switch(opcion){
                    case 1:
                        System.out.println("Saliendo del sistema.");
                        sc.close();
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }
            } else {
                intentos++;
                System.out.println("Credenciales incorrectas. Intento " + intentos + " de 3.");
            }
        }

        if (!acceso) {
            System.out.println("Acceso bloqueado. Has superado el numero maximo de intentos.");
        }
    }
    
}

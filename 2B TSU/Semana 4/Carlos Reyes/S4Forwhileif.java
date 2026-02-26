/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s4.forwhileif;

import java.util.Scanner;

/**
 *
 * @author juanc
 */
public class S4Forwhileif {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
                // Usuario y contraseña preestablecidos
        String usuarioCorrecto = "admin";
        String contrasenaCorrecta = "1234";

        int intentos = 0;          // Contador de intentos fallidos
        boolean acceso = false;    // Controla si el usuario accede o no

        // While que permite máximo 3 intentos
        while (intentos < 3) {

            // Solicita usuario
            System.out.print("Usuario: ");
            String usuario = sc.nextLine();

            // Solicita contraseña
            System.out.print("Contraseña: ");
            String contrasena = sc.nextLine();

            // Valida credenciales usando if
            if (usuario.equals(usuarioCorrecto) && contrasena.equals(contrasenaCorrecta)) {
                System.out.println("\nAcceso correcto. Bienvenido.");
                acceso = true; // Marca acceso como verdadero
                break;         // Sale del while
            } else {
                intentos++; // Incrementa intentos fallidos
                System.out.println("Credenciales incorrectas. Intento " 
                                   + intentos + " de 3\n");
            }
        }

        // Si el acceso fue correcto
        if (acceso) {
            System.out.println("Menú del sistema:");

            // For que simula operaciones del sistema
            for (int i = 1; i <= 3; i++) {
                System.out.println("Operación " + i + " ejecutada");
            }

        } else {
            // Si falló 3 veces
            System.out.println("Cuenta bloqueada por demasiados intentos fallidos.");
            System.out.println("Total de intentos fallidos: " + intentos);
        }

        sc.close(); // Cierra el Scanner
    }
}
    
    


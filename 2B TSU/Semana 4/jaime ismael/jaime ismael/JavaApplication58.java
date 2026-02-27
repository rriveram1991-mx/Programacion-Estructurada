/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication58;

//Sistema de Registro y Acceso con Intentos Limitados
//Requerimiento
//Desarrollar un sistema que:
//
//Defina un usuario y contraseña preestablecidos.
//Permita máximo 3 intentos usando while.
//Valide credenciales con if.
//Si el acceso es correcto:
//Mostrar menú con opciones (usar for para simular operaciones).
//Si falla 3 veces:
//Mostrar mensaje de cuenta bloqueada.
//Contar número de intentos fallidos

import java.util.Scanner;

public class JavaApplication58 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        

        int intentos = 0;
        boolean acceso = false;

        System.out.println("--sistema de acceso--");

        // Permitir máximo 3 intentos en el while
        while (intentos < 3 && !acceso) {

            System.out.print("Usuario: ");
            String usuario = leer.nextLine();

            System.out.print("Contraseña: ");
            String contrasena = leer.nextLine();

            // Validar usuario y contra
            if (usuario.equals("admin") && 
                contrasena.equals("123")) {

                acceso = true;
                System.out.println("Acceso concedido");

            } else {
                intentos++;
                System.out.println("usuario o contrasena incorrectas");
                System.out.println("Intentos fallidos: " + intentos );
            }
        }

        // Si el acceso fue correcto
        if (acceso) {
//esto no jala nomas es un menu
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Ver perfil");
            System.out.println("2. Realizar operación");
            System.out.println("3. Cerrar sesión");

            
        } else {
            // Si falla 3 veces deja mensaje de bloqueo
            System.out.println("Cuenta bloqueada por 3 intentos fallidos.");
        }

        
    }
}

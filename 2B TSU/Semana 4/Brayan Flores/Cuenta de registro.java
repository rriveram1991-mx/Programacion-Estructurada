/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema.de.registros;

import java.util.Scanner;

public class Sistemaregistros {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String usuarioCorrecto = "brayan";
        String contrasenaCorrecta = "1234";
        int intentos = 0;
        int maxIntentos = 3;
        boolean acceso = false;

        while (intentos < maxIntentos) {
            System.out.print("Ingrese usuario: ");
            String usuario = sc.nextLine();

            System.out.print("Ingrese contraseña: ");
            String contrasena = sc.nextLine();

            if (usuario.equals(usuarioCorrecto) && contrasena.equals(contrasenaCorrecta)) {
                System.out.println("Acceso correcto");
                acceso = true;
                break;
            } else {
                intentos++;
                System.out.println("datos incorrectas. Intento " 
                                   + intentos + " de " + maxIntentos);
            }
        }

        if (acceso) {
            System.out.println("=====Menu=====");
            System.out.println("1. Ver datos");
            System.out.println("2. Actualizar datos");
            System.out.println("3. Cerrar sesion");

            for (int i = 1; i <= 3; i++) {
                System.out.println("Procesando opcion " + i + "...");
            }
        } else {
            System.out.println("Cuenta bloqueada por 3 intentos fallidos.");
            System.out.println("Numero total de intentos fallidos: " + intentos);
        }

    }
}
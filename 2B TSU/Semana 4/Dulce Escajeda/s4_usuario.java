/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s4_user;

import java.util.Scanner;

/**
 *
 * @author lopez
 */
public class S4_user {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner lr = new Scanner(System.in);
        String usuarioCorrecto = "admin";
        String passCorrecta = "1234";
        
        int intentosFallidos = 0;
        boolean accesoConcedido = false;

        // Definir usuario y contraseña preestablecidos
        while (intentosFallidos < 3 && !accesoConcedido) {
            System.out.println("\n--- LOGIN ---");
            System.out.print("Usuario: ");
            String user = lr.next();
            System.out.print("Contraseña: ");
            String pass = lr.next();

            if (user.equals(usuarioCorrecto) && pass.equals(passCorrecta)) {
                accesoConcedido = true;
            }
        }

        if (accesoConcedido) {
            int opcionMenu = 0;
            
            for (int i = 1; i <= 3; i++) {
                System.out.println("Iniciando componentes... " + i + "/3");
            }

            // El ciclo sigue mientras no se agoten los intentos Y no haya entrado
            while (opcionMenu != 3) {
                System.out.println("\n--- SISTEMA DE GESTIÓN ---");
                System.out.println("1. Ver reportes");
                System.out.println("2. Registrar datos");
                System.out.println("3. Cerrar sesión");
                System.out.print("Seleccione: ");
                opcionMenu = lr.nextInt();

                if (opcionMenu == 1) {
                    System.out.println(">> Mostrando reportes del sistema...");
                } else if (opcionMenu == 2) {
                    System.out.println(">> Datos registrados exitosamente.");
                } else if (opcionMenu == 3) {
                    System.out.println("Saliendo...");
                } else {
                    System.out.println("Opción no válida.");
                }
            }
        } else {
            // Requerimiento 5 y 6: Bloqueo
            System.out.println("\nCUENTA BLOQUEADA. Intentos fallidos: " + intentosFallidos);
        }
    }
}
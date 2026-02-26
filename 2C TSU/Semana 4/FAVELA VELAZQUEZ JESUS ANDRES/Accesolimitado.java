/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package accesolimitado;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Accesolimitado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. Credenciales preestablecidas
        String usuarioCorrecto = "daimondogs";
        String claveCorrecta = "venomsnake";

        // 2. Variables de control
        int intentosMaximos = 3;
        int intentosFallidos = 0;
        boolean accesoConcedido = false;

        System.out.println("=== SISTEMA DE SEGURIDAD===");

        // 3. Bucle de intentos limitado (Máximo 3)
        while (intentosFallidos < intentosMaximos && !accesoConcedido) {
            System.out.print("\nUsuario: ");
            String userEntry = sc.next();
            System.out.print("Contraseña: ");
            String passEntry = sc.next();

            // 4. Validar credenciales con IF
            // Usamos .equals() porque en Java los Strings son objetos
            if (userEntry.equals(usuarioCorrecto) && passEntry.equals(claveCorrecta)) {
                accesoConcedido = true;
                System.out.println("\n Acceso Exitoso. Bienvenido.");
            } else {
                intentosFallidos++;
                int restantes = intentosMaximos - intentosFallidos;
                System.out.println("Credenciales incorrectas.");
                
                if (restantes > 0) {
                    System.out.println("Te quedan " + restantes + " intentos.");
                }
            }
        }

        // 5. Lógica según el resultado del acceso
        if (accesoConcedido) {
            // Mostrar menú y simular operaciones con FOR
            System.out.println("\n--- MENÚ DE OPERACIONES ---");
            String[] opciones = {"Cargar Perfil", "Sincronizar Datos", "Limpiar Caché"};
            
            for (int i = 0; i < opciones.length; i++) {
                // El for recorre el arreglo y simula un proceso
                System.out.println("Ejecutando paso " + (i + 1) + ": " + opciones[i] + "...");
            }
            System.out.println("\nSistema listo para operar.");
            
        } else {
            // 6. Mensaje de cuenta bloqueada tras 3 fallos
            System.out.println("\n========================================");
            System.out.println("⚠️ CUENTA BLOQUEADA ⚠️");
            System.out.println("Número de intentos fallidos: " + intentosFallidos);
            System.out.println("Contacte al administrador del sistema.");
            System.out.println("========================================");
        }

        sc.close();
    }
    }
    


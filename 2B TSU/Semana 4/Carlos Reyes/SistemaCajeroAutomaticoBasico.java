/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema.cajero.automatico.basico;

import java.util.Scanner;

/**
 *
 * @author juanc
 */
public class SistemaCajeroAutomaticoBasico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double saldo = 1000;     // Saldo inicial del usuario
        int opcion;              // Guarda la opción del menú
        int operaciones = 0;     // Contador de operaciones válidas

        // Ciclo while para mostrar el menú de forma repetitiva
        while (true) {

            // Menú principal
            System.out.println("\n--- CAJERO AUTOMÁTICO ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            // Opción 1: Consultar saldo
            if (opcion == 1) {
                System.out.println("Saldo actual: $" + saldo);
                operaciones++; // Cuenta la operación

            // Opción 2: Depositar dinero
            } else if (opcion == 2) {
                System.out.print("Cantidad a depositar: ");
                double deposito = sc.nextDouble();

                // Validación para evitar cantidades negativas o cero
                if (deposito <= 0) {
                    System.out.println("Error: solo se permiten cantidades positivas.");
                } else {
                    saldo += deposito; // Suma el depósito al saldo
                    System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
                    operaciones++; // Cuenta la operación
                }

            // Opción 3: Retirar dinero
            } else if (opcion == 3) {
                System.out.print("Cantidad a retirar: ");
                double retiro = sc.nextDouble();

                // Validaciones del retiro
                if (retiro <= 0) {
                    System.out.println("Error: cantidad inválida.");
                } else if (retiro > saldo) {
                    System.out.println("Error: saldo insuficiente.");
                } else {
                    saldo -= retiro; // Resta el retiro del saldo
                    System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
                    operaciones++; // Cuenta la operación
                }

            // Opción 4: Salir del sistema
            } else if (opcion == 4) {
                System.out.println("\nSaliendo del sistema...");
                System.out.println("Total de operaciones realizadas: " + operaciones);
                break; // Termina el ciclo while

            // Opción inválida
            } else {
                System.out.println("Opción no válida.");
            }
        }

        sc.close(); // Cierra el Scanner
    }
}

    


    
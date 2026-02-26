/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cajeroauto;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class CajeroAuto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        // Variables iniciales
        double saldo = 1000.0; // Saldo inicial definido
        int contadorOperaciones = 0;
        int opcion = 0;

        System.out.println("--- BIENVENIDO AL SISTEMA BANCARIO ---");

        // Menú repetitivo usando while
        while (opcion != 4) {
            System.out.println("\nSaldo actual: $" + saldo);
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();

            if (opcion == 1) {
                // Consultar Saldo
                System.out.println("Su saldo es de: $" + saldo);
                contadorOperaciones++;

            } else if (opcion == 2) {
                // Depositar
                System.out.print("Ingrese la cantidad a depositar: ");
                double deposito = leer.nextDouble();

                // Validación: No cantidades negativas
                if (deposito > 0) {
                    saldo += deposito;
                    System.out.println("Depósito exitoso.");
                    contadorOperaciones++;
                } else {
                    System.out.println("Error: No se pueden depositar cantidades negativas o cero.");
                }

            } else if (opcion == 3) {
                // Retirar
                System.out.print("Ingrese la cantidad a retirar: ");
                double retiro = leer.nextDouble();

                // Validaciones con if
                if (retiro <= 0) {
                    System.out.println("Error: Ingrese una cantidad válida mayor a cero.");
                } else if (retiro > saldo) {
                    System.out.println("Error: Fondos insuficientes. Su saldo es de $" + saldo);
                } else {
                    saldo -= retiro;
                    System.out.println("Retiro exitoso.");
                    contadorOperaciones++;
                }

            } else if (opcion == 4) {
                System.out.println("Saliendo del sistema...");
            } else {
                System.out.println("Opción no válida, intente de nuevo.");
            }
        }

        // Mostrar total de operaciones al final
        System.out.println("\n--------------------------------------");
        System.out.println("Sesión finalizada.");
        System.out.println("Total de operaciones realizadas: " + contadorOperaciones);
        System.out.println("--------------------------------------");
        
        leer.close();
    }
}
    
    


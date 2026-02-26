/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author lopez
 */

    public static void main(String[] args) {
        // Requerimiento 1: Definir variables iniciales
        Scanner lr = new Scanner(System.in);
        double saldo = 1000; // Saldo inicial
        int opcion = 0;      // Variable para el menú
        int contador = 0;    // Requerimiento 5: Contador de operaciones
        double dep, ret;     // Variables auxiliares para montos

        // Requerimiento 2: Menú repetitivo usando while
        while (opcion != 4) {
            System.out.println("\n-----Cajero Automatico-----");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            System.out.print("Elija una opcion: ");
            opcion = lr.nextInt();

            // Requerimiento 4: Utilizar if para validar cada operación
            if (opcion == 1) {
                System.out.println("Tu saldo actual es: $" + saldo);
            } 
            else if (opcion == 2) {
                System.out.print("¿Cuanto desea depositar?: ");
                dep = lr.nextDouble();

                // Requerimiento 3: No permitir cantidades negativas
                if (dep > 0) {
                    saldo = saldo + dep;
                    contador++; // Incrementar contador (Requerimiento 5)
                    System.out.println("Deposito exitoso.");
                } else {
                    System.out.println("Error: No puede depositar cantidades negativas.");
                }
            } 
            else if (opcion == 3) {
                System.out.print("¿Cuanto desea retirar?: ");
                ret = lr.nextDouble();

                // Requerimiento 3: Validar que el retiro no sea mayor al saldo ni negativo
                if (ret > 0 && ret <= saldo) {
                    saldo = saldo - ret;
                    contador++; // Incrementar contador (Requerimiento 5)
                    System.out.println("Retiro exitoso.");
                } else if (ret > saldo) {
                    System.out.println("Error: Saldo insuficiente.");
                } else {
                    System.out.println("Error: Cantidad invalida.");
                }
            } 
            else if (opcion == 4) {
                System.out.println("Saliendo del sistema...");
            } 
            else {
                System.out.println("Opcion no valida, intente de nuevo.");
            }
        }

       
        System.out.println("\n******************************************");
        System.out.println("SESION FINALIZADA");
        System.out.println("Total de operaciones exitosas: " + contador);
        System.out.println("Saldo final: $" + saldo);
        System.out.println("******************************************");
    }

    
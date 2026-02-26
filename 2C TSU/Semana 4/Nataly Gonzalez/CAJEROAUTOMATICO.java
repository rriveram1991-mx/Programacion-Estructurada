/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cajero.automatico;
  import java.util.Scanner;
/**
 *
 * @author LABTICS
 */
public class CAJEROAUTOMATICO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        Scanner sc = new Scanner(System.in);
        double saldo = 1000.0; // Saldo inicial
        int operaciones = 0;

        while (true) {
            System.out.println("\n--- CAJERO AUTOMÁTICO ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.println("Su saldo actual es: $" + saldo);
                operaciones++;

            } else if (opcion == 2) {
                System.out.print("Ingrese el monto a depositar: ");
                double monto = sc.nextDouble();

                if (monto > 0) {
                    saldo += monto;
                    System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
                    operaciones++;
                } else {
                    System.out.println("No se permiten cantidades negativas o cero.");
                }

            } else if (opcion == 3) {
                System.out.print("Ingrese el monto a retirar: ");
                double monto = sc.nextDouble();

                if (monto <= 0) {
                    System.out.println("No se permiten cantidades negativas o cero.");
                } else if (monto > saldo) {
                    System.out.println("Fondos insuficientes.");
                } else {
                    saldo -= monto;
                    System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
                    operaciones++;
                }

            } else if (opcion == 4) {
                System.out.println("Saliendo del sistema...");
                break;

            } else {
                System.out.println("Opción inválida.");
            }
        }

        System.out.println("\nTotal de operaciones realizadas: " + operaciones);
        sc.close();
    }
}
    
    


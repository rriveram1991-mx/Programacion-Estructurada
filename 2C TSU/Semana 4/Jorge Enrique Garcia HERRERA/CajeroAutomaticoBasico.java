/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cajero.automatico.basico;
import java.util.Scanner;
/**
 *
 * @author jegh1
 */
public class CajeroAutomaticoBasico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }{
    
        Scanner sc = new Scanner(System.in);

        double saldo = 1000.0; // Saldo inicial
        int opcion = 0;
        int operaciones = 0;   // Contador de operaciones
        boolean salir = false;

        while (!salir) {

            System.out.println("\n=== CAJERO AUTOMÁTICO ===");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            System.out.print("Seleccione opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Saldo actual: $" + saldo);
                    operaciones++;
                    break;

                case 2:
                    System.out.print("Monto a depositar: ");
                    double deposito = sc.nextDouble();

                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("Depósito exitoso");
                        operaciones++;
                    } else {
                        System.out.println("Monto inválido");
                    }
                    break;

                case 3:
                    System.out.print("Monto a retirar: ");
                    double retiro = sc.nextDouble();

                    if (retiro <= 0) {
                        System.out.println("Monto inválido");
                    } else if (retiro > saldo) {
                        System.out.println("Fondos insuficientes");
                    } else {
                        saldo -= retiro;
                        System.out.println("Retiro exitoso");
                        operaciones++;
                    }
                    break;

                case 4:
                    salir = true;
                    System.out.println("Gracias por usar el cajero");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        }

        System.out.println("Total de operaciones realizadas: " + operaciones);

        sc.close();
    }
}


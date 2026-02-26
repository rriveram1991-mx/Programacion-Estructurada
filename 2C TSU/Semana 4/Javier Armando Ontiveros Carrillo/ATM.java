package atm;
import java.util.Scanner;

public class ATM {
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        double saldo = 1000.0;
        int operaciones = 0;
        int opcion;

        while (true) {
            System.out.println("--- Cajero Automático ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leer.nextInt();
            leer.nextLine();

            if (opcion == 1) {
                System.out.println("Su saldo actual es: $" + saldo);
                operaciones++;
            } else if (opcion == 2) {
                System.out.print("Ingrese la cantidad a depositar: $");
                double deposito = leer.nextDouble();
                leer.nextLine();

                if (deposito > 0) {
                    saldo += deposito;
                    System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
                    operaciones++;
                } else {
                    System.out.println("La cantidad a depositar debe ser mayor que cero.");
                }
            } else if (opcion == 3) {
                System.out.print("Ingrese la cantidad a retirar: $");
                double retiro = leer.nextDouble();
                leer.nextLine();

                if (retiro > 0) {
                    if (retiro <= saldo) {
                        saldo -= retiro;
                        System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
                        operaciones++;
                    } else {
                        System.out.println("No tiene suficiente saldo para realizar este retiro.");
                    }
                } else {
                    System.out.println("La cantidad a retirar debe ser mayor que cero.");
                }
            } else if (opcion == 4) {
                System.out.println("Gracias por utilizar el cajero automático.");
                break;
            } else {
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
            System.out.println();
        }

        System.out.println("Total de operaciones realizadas: " + operaciones);
    }
}

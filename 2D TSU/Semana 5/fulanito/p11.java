import java.util.Scanner;

public class p11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double saldo = 1000; // saldo inicial
        int operaciones = 0;
        int opcion;

        do {
            System.out.println("\n--- MENÚ CAJERO ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.println("Su saldo actual es: $" + saldo);
                operaciones++;
            } else if (opcion == 2) {
                System.out.print("Ingrese cantidad a depositar: ");
                double cantidad = sc.nextDouble();
                if (cantidad > 0) {
                    saldo += cantidad;
                    System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
                    operaciones++;
                } else {
                    System.out.println("No se permiten cantidades negativas.");
                }
            } else if (opcion == 3) {
                System.out.print("Ingrese cantidad a retirar: ");
                double cantidad = sc.nextDouble();
                if (cantidad > 0) {
                    if (cantidad <= saldo) {
                        saldo -= cantidad;
                        System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
                        operaciones++;
                    } else {
                        System.out.println("Error: el retiro excede el saldo disponible.");
                    }
                } else {
                    System.out.println("No se permiten cantidades negativas.");
                }
            } else if (opcion == 4) {
                System.out.println("Saliendo del sistema...");
            } else {
                System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);

        System.out.println("\nTotal de operaciones realizadas: " + operaciones);
       
    }
}

import java.util.Scanner;
public class Practica13 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int saldo = 1000,i = 0;
        
        while (true) {
            System.out.println("=== Bienvenido al cajero automático ===");
            System.out.println("=== Seleccione una opción ===");
            System.out.println("=== 1. Consultar saldo ===");
            System.out.println("=== 2. Depositar dinero ===");
            System.out.println("=== 3. Retirar dinero ===");
            System.out.println("=== 4. Salir ===");
            int opcion = leer.nextInt();
            i = i + 1;
            switch (opcion) {
                case 1:
                    System.out.println("=== Su saldo es: " + saldo + " ===");
                    break;
                case 2:
                    System.out.println("=== Ingrese el monto a depositar ===");
                    int monto = leer.nextInt();
                    saldo += monto;
                    System.out.println("=== Depósito exitoso ===");
                    break;
                case 3:
                    System.out.println("=== Ingrese el monto a retirar ===");
                    int montoRetiro = leer.nextInt();
                    if (montoRetiro > saldo) {
                        System.out.println("=== Saldo insuficiente ===");
                    } 
                    else {
                        saldo -= montoRetiro;
                        System.out.println("=== Retiro exitoso ===");
                    }
                    break;
                case 4:
                    System.out.println("=== Ha realizado " + i + " transacciones ===");
                    System.out.println("=== Saliendo del cajero automático ===");
                    return;
                default:
                    System.out.println("=== Opción inválida ===");
            }
        }
    }
}

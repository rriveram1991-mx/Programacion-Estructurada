package examen;

import java.util.Scanner;
public class SistemaVentas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        double totalVentas = 0;
        int contadorVentas = 0;
        while (opcion != 3); {   
            System.out.println("1. Registrar venta");
            System.out.println("2. Mostrar total vendido");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese monto de la venta: ");
                    double venta = sc.nextDouble();
                    if (venta <= 0) {   // ERROR 2
                        System.out.println("Venta invalida");
                    } else {
                        totalVentas += venta;   
                        contadorVentas++;
                        System.out.println("Venta registrada");
                    }
                    break;
                case 2:
                    System.out.println("Total vendido: " + totalVentas);
                    for (int i = 0; i <= contadorVentas; i++) {   
                        System.out.println("Procesando venta...");
                    }System.out.println("total de ventas " + contadorVentas);
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
        sc.close();
    }
}

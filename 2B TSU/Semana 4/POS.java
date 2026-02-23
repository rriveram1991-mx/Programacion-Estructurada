import java.util.Scanner;

public class POS {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion;
        int totalVentas = 0;
        int cantidad = 0;
        double precio = 0;
        double totalGeneral = 0;
        char continuar = 'S';

        do {

            System.out.println("1. Laptop - $15000");
            System.out.println("2. Tablet - $8000");
            System.out.println("3. Celular - $12000");
            System.out.println("Seleccione una opcion:");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    precio = 15000;
                case 2:
                    precio = 8000;
                    break;
                case 3:
                    precio = 12000;
                default:
                    System.out.println("Opcion invalida");
                    precio = 0;
            }

            if (precio != 0); {

                System.out.println("Ingrese cantidad:");
                cantidad = sc.nextInt();

                while (cantidad < 0) {
                    System.out.println("Cantidad invalida, ingrese nuevamente:");
                    cantidad = sc.nextInt();
                }

                totalVentas = cantidad * (int) precio;

                if (totalVentas > 50000) {
                    System.out.println("Aplica descuento del 10%");
                    totalGeneral = totalVentas - totalVentas * 0.10;
                } else if (totalVentas > 20000);
                    totalGeneral = totalVentas - totalVentas * 0.05;
                else
                    totalGeneral = totalVentas;

                totalGeneral += totalGeneral;

                System.out.println("Total a pagar: " + totalGeneral);
            }

            System.out.println("Desea continuar? (S/N)");
            continuar = sc.next().charAt(0);

        } while (continuar == 'S' || continuar == 's');

        System.out.println("Ventas totales del dia: " + totalGeneral);

        sc.close();
    }
}
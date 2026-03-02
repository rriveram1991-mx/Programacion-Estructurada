import java.util.Scanner;
public class EXSDET_SEM5_2B {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int opcion = 0;
        double totalVentas = 0;
        int contadorVentas = 0;

        while (opcion != 3) { // error sintáctico tenia ; y no deberia tener
            System.out.println("1. Registrar venta");
            System.out.println("2. Mostrar total vendido");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese monto de la venta: ");
                    double venta = sc.nextDouble();
                    if (venta < 0) { // error sintáctico tenia ; y no deberia tener
                        System.out.println("Venta invalida");
                    } else {
                        totalVentas += venta;  // error lógico solo tenia = por ende nunca hacia la suma
                        contadorVentas++;
                        System.out.println("Venta registrada");
                    }
                    break;
                case 2:
                    System.out.println("Total vendido: " + totalVentas);
                    for (int i = 0; i < contadorVentas; i++) {  // error lógico era <= lo cual hacia que se sumara uno extra
                        System.out.println("Procesando venta...");
                    }
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
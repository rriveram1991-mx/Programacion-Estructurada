import java.util.Scanner;

public class DET_SEM5_2B_4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Registro de pasajeros
        System.out.println("================ BIENVENIDO ================");
        System.out.println("¿Cuantos pasajeros son?");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("============================================");

        String[] nombre = new String[n];
        String[] destinos = new String[n];
        int viajesCortos = 0;
        int viajesLargos = 0;

        // Captura de datos
        for(int i = 0; i < nombre.length; i++) {
            System.out.println("Cual es su destino: ");
            destinos[i] = sc.nextLine();

            System.out.println("Cual es el nombre del pasajero: ");
            nombre[i] = sc.nextLine();
            while (nombre[i].isEmpty()) {
                if (nombre[i].isEmpty()) {
                    System.out.print("Eror ingrese su nombre nuevamente:");
                    nombre[i] = sc.nextLine();
                }
            }
            if (destinos[i].equalsIgnoreCase("centro") ||
                destinos[i].equalsIgnoreCase("gomez") ||
                destinos[i].equalsIgnoreCase("lerdo") ||
                destinos[i].equalsIgnoreCase("matamoros")) {
                    viajesCortos++;
            } else {
                viajesLargos++;
            }
        }
        // Pasajeros registrados
        System.out.println("============== REPORETE FINAL ==============");
        System.out.println("             Pasajeros abordo: " + n);
        System.out.println("          Total de viajes cortos: " + viajesCortos);
        System.out.println("          Total de viajes largos: " + viajesLargos);
        System.out.println("============================================");
        System.out.println("\nRegistro total de pasajeros");
        for (int i = 0; i < nombre.length; i++) {
            System.out.println("Nombre: " + nombre[i] + " Destino: " + destinos[i]);
        }
    }
}

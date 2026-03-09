import java.util.Scanner;

/**
 *
 * @author mirel
 */
public class Pasajeros {

    /**
     * @param args the command line arguments
     */
}
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Numero de pasajeros: ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        String[] nombres = new String[cantidad];
        String[] destinos = new String[cantidad];

        int cdmx = 0;
        int local = 0;

        for (int i = 0; i < cantidad; i++) {

            System.out.println("\nPasajero " + (i + 1));

            System.out.print("Nombre: ");
            nombres[i] = sc.nextLine();

            while (nombres[i].isEmpty()) {
                if (nombres[i].isEmpty()) {
                    System.out.print("Error. El nombre no puede estar vacio. Ingrese nuevamente: ");
                    nombres[i] = sc.nextLine();
                }
            }

            System.out.print("Destino (CDMX o Local): ");
            destinos[i] = sc.nextLine();

            if (destinos[i].equalsIgnoreCase("CDMX")) {
                cdmx++;
            } 
            else if (destinos[i].equalsIgnoreCase("Local")) {
                local++;
            }
        }

        // MOSTRAR LISTA (FOR-EACH)
        System.out.println("\nLista de pasajeros:");
        for (String nombre : nombres) {
            System.out.println("Pasajero: " + nombre);
        }

        for (String destino : destinos) {
            if (destino.equalsIgnoreCase("CDMX")) {
                System.out.println("Destino: CDMX - Viaje largo");
            } 
            else if (destino.equalsIgnoreCase("Local")) {
                System.out.println("Destino: Local - Viaje corto");
            }
        }

        System.out.println("\nResumen:");

        if (cdmx > local) {
            System.out.println("Destino con mas pasajeros: CDMX");
        } 
        else if (local > cdmx) {
            System.out.println("Destino con mas pasajeros: Local");
        } 
        else {
            System.out.println("Ambos destinos tienen la misma cantidad de pasajeros");
        }

        System.out.println("Total de pasajeros registrados: " + cantidad);
    }

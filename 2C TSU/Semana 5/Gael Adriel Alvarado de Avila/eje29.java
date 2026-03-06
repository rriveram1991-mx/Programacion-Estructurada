import java.util.Scanner;

public class eje29 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int pasajeros;

        System.out.println("Numero de pasajeros:");
        pasajeros = leer.nextInt();
        leer.nextLine();

        String[] nombres = new String[pasajeros];
        String[] destinos = new String[pasajeros];

        for (int i = 0; i < pasajeros; i++) {
            System.out.println("Nombre del pasajero:");
            nombres[i] = leer.nextLine();

            while (nombres[i].isEmpty()) {
                if (nombres[i].isEmpty()) {
                    System.out.println("Error: El nombre no puede estar vacio");
                }
                System.out.println("Ingrese nuevamente el nombre:");
                nombres[i] = leer.nextLine();
            }

            System.out.println("Destino (CDMX o Local):");
            destinos[i] = leer.nextLine();
        }

        int cdmx = 0;
        int local = 0;

        System.out.println("Lista completa de pasajeros:");

        for (String destino : destinos) {
            if (destino.equalsIgnoreCase("CDMX")) {
                cdmx++;
                System.out.println("Viaje largo");
            } else if (destino.equalsIgnoreCase("Local")) {
                local++;
                System.out.println("Viaje corto");
            }
        }

        System.out.println("Destino con mas pasajeros:");
        if (cdmx > local) {
            System.out.println("CDMX");
        } else if (local > cdmx) {
            System.out.println("Local");
        } else {
            System.out.println("Empate");
        }

        System.out.println("Total de pasajeros registrados: " + pasajeros);

    }
}
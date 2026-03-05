package pasajeros;
import java.util.Scanner;

public class Pasajeros {
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.print("¿Cuántos pasajeros se registrarán? ");
        int n = leer.nextInt();
        leer.nextLine(); 

        String[] nombres = new String[n];
        String[] destinos = new String[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nPasajero " + (i + 1));

            System.out.print("Nombre: ");
            nombres[i] = leer.nextLine();

            while (nombres[i].isEmpty()) {

                if (nombres[i].isEmpty()) {
                    System.out.println("Error: El nombre no puede estar vacío.");
                }

                System.out.print("Nombre: ");
                nombres[i] = leer.nextLine();
            }

            System.out.print("Destino: ");
            destinos[i] = leer.nextLine();
        }

        int contadorCDMX = 0;
        int contadorLocal = 0;
        int otros = 0;

        System.out.println("\n--- Lista de Pasajeros ---");

        for (String nombre : nombres) {
            System.out.println("Pasajero: " + nombre);
        }

        for (String destino : destinos) {

            if (destino.equalsIgnoreCase("CDMX")) {
                contadorCDMX++;
                System.out.println("Viaje largo");
            } else if (destino.equalsIgnoreCase("Local")) {
                contadorLocal++;
                System.out.println("Viaje corto");
            } else {
                otros++;
            }
        }

        String destinoMayor = "";

        if (contadorCDMX > contadorLocal && contadorCDMX > otros) {
            destinoMayor = "CDMX";
        } else if (contadorLocal > otros) {
            destinoMayor = "Local";
        } else {
            destinoMayor = "Otro destino";
        }

        System.out.println("\nPasajeros a CDMX: " + contadorCDMX);
        System.out.println("Pasajeros Locales: " + contadorLocal);
        System.out.println("Otros destinos: " + otros);
        System.out.println("Destino con más pasajeros: " + destinoMayor);
        System.out.println("Total de pasajeros registrados: " + n);

    }
}

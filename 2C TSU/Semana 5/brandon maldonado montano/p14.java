import java.util.Scanner;

public class p14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitar número de pasajeros
        System.out.print("¿Cuántos pasajeros se registrarán? ");
        int n = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        String[] nombres = new String[n];
        String[] destinos = new String[n];

        // Captura de datos con validación
        for (int i = 0; i < n; i++) {
            String nombre;
            while (true) {
                System.out.print("Nombre del pasajero " + (i+1) + ": ");
                nombre = sc.nextLine();
                if (!nombre.isEmpty()) {
                    break;
                } else {
                    System.out.println("Error: el nombre no puede estar vacío.");
                }
            }
            nombres[i] = nombre;

            System.out.print("Destino del pasajero " + (i+1) + ": ");
            destinos[i] = sc.nextLine();
        }

        // Mostrar lista completa
        System.out.println("\n--- Lista de Pasajeros ---");
        for (int i = 0; i < n; i++) {
            System.out.print(nombres[i] + " → " + destinos[i]);
            if (destinos[i].equalsIgnoreCase("CDMX")) {
                System.out.print(" → Viaje largo");
            } else if (destinos[i].equalsIgnoreCase("Local")) {
                System.out.print(" → Viaje corto");
            }
            System.out.println();
        }

        // Contar pasajeros por destino
        int maxPasajeros = 0;
        String destinoPopular = "";
        for (String destino : destinos) {
            int count = 0;
            for (String d : destinos) {
                if (d.equalsIgnoreCase(destino)) {
                    count++;
                }
            }
            if (count > maxPasajeros) {
                maxPasajeros = count;
                destinoPopular = destino;
            }
        }

        // Resultados finales
        System.out.println("Destino con más pasajeros: " + destinoPopular + " (" + maxPasajeros + ")");
        System.out.println("Total de pasajeros registrados: " + n);
    }
}

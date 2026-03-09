import java.util.Scanner;

public class Sistema2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ingresa la cantidad de pasajeros
        System.out.println("Ingresa la cantidad de pasajeros:");
        int cantidadPasajeros = sc.nextInt();
        sc.nextLine();

        String[] nombres = new String[cantidadPasajeros];
        String[] destinos = new String[cantidadPasajeros];

        // Usar for para capturar nombre y destino
        for (int i = 0; i < cantidadPasajeros; i++) {
            System.out.println("\n--- Pasajero " + (i + 1) + " ---");

            String nombre = "";
            // Validar con while que el nombre no esté vacío
            while (true) {
                System.out.println("Ingresa el nombre del pasajero:");
                nombre = sc.nextLine();

                // Si está vacío -> mostrar error usando if
                if (nombre.trim().isEmpty()) {
                    System.out.println("Error: El nombre no puede estar vacío. Intenta de nuevo.");
                } else {
                    break;
                }
            }
            nombres[i] = nombre;

            System.out.println("Ingresa el destino (ej. CDMX, Local, etc.):");
            destinos[i] = sc.nextLine();
        }

        System.out.println("\n=== LISTA COMPLETA DE PASAJEROS ===");

        String[] destinosUnicos = new String[cantidadPasajeros];
        int[] conteoDestinos = new int[cantidadPasajeros];
        int numDestinosUnicos = 0;

        int index = 0;
        // Usar for-each para mostrar la lista completa de pasajeros
        for (String nombre : nombres) {
            String destino = destinos[index];
            String tipoViaje = "";

            // Si el destino es "CDMX" -> mostrar "Viaje largo"
            // Si el destino es "Local" -> mostrar "Viaje corto"
            if (destino.equalsIgnoreCase("CDMX")) {
                tipoViaje = " (Viaje largo)";
            } else if (destino.equalsIgnoreCase("Local")) {
                tipoViaje = " (Viaje corto)";
            }

            System.out.println("- Nombre: " + nombre + " | Destino: " + destino + tipoViaje);

            // Contar cuántos pasajeros van a cada destino
            boolean encontrado = false;
            for (int k = 0; k < numDestinosUnicos; k++) {
                if (destinosUnicos[k].equalsIgnoreCase(destino)) {
                    conteoDestinos[k]++;
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                destinosUnicos[numDestinosUnicos] = destino;
                conteoDestinos[numDestinosUnicos] = 1;
                numDestinosUnicos++;
            }

            index++;
        }

        System.out.println("\n=== RESUMEN DE DESTINOS ===");
        String destinoMasPasajeros = "";
        int maxPasajeros = 0;

        for (int i = 0; i < numDestinosUnicos; i++) {
            System.out.println("Pasajeros a " + destinosUnicos[i] + ": " + conteoDestinos[i]);
            if (conteoDestinos[i] > maxPasajeros) {
                maxPasajeros = conteoDestinos[i];
                destinoMasPasajeros = destinosUnicos[i];
            }
        }

        // Al final mostrar: Destino con más pasajeros, Total de pasajeros registrados
        System.out.println("\nResultados finales:");
        System.out.println("Destino con más pasajeros: " + destinoMasPasajeros + " (" + maxPasajeros + " pasajeros)");
        System.out.println("Total de pasajeros registrados: " + cantidadPasajeros);

        sc.close();
    }
}

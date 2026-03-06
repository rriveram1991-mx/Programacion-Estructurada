package viajes2;

import java.util.Scanner;

public class GestionPasajeros {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // 1. Solicitar número de pasajeros
        System.out.print("Ingrese el número de pasajeros: ");
        int numPasajeros = teclado.nextInt();
        teclado.nextLine(); // Limpiar el buffer

        // 2. Crear los arrays
        String[] nombres = new String[numPasajeros];
        String[] destinos = new String[numPasajeros];

        // 3. Captura con for y validación con while/if
        for (int i = 0; i < numPasajeros; i++) {
            boolean nombreValido = false;
            
            while (!nombreValido) {
                System.out.print("Nombre del pasajero " + (i + 1) + ": ");
                nombres[i] = teclado.nextLine();

                if (nombres[i].trim().isEmpty()) {
                    System.out.println("Error: El nombre no puede estar vacío.");
                } else {
                    nombreValido = true;
                }
            }

            System.out.print("Destino (CDMX/Local): ");
            destinos[i] = teclado.nextLine();
        }

        // 4. Procesamiento con for-each
        System.out.println("\n--- Lista de Pasajeros ---");
        int contCDMX = 0;
        int contLocal = 0;

        int indice = 0;
        for (String nombre : nombres) {
            String destinoActual = destinos[indice];
            System.out.print("Pasajero: " + nombre + " | Destino: " + destinoActual);

            // Validación de tipo de viaje
            if (destinoActual.equalsIgnoreCase("CDMX")) {
                System.out.println(" -> Viaje largo");
                contCDMX++;
            } else if (destinoActual.equalsIgnoreCase("Local")) {
                System.out.println(" -> Viaje corto");
                contLocal++;
            } else {
                System.out.println(" -> Destino no clasificado");
            }
            indice++;
        }

        // 5. Resultados finales
        System.out.println("\n--- Resumen Final ---");
        System.out.println("Total de pasajeros registrados: " + numPasajeros);
        
        if (contCDMX > contLocal) {
            System.out.println("El destino con más pasajeros es: CDMX (" + contCDMX + ")");
        } else if (contLocal > contCDMX) {
            System.out.println("El destino con más pasajeros es: Local (" + contLocal + ")");
        } else {
            System.out.println("Empate entre destinos o no hay registros suficientes.");
        }
        
        teclado.close();
    }
}
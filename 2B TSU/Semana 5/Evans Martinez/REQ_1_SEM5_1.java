import java.util.Scanner;

public class REQ_1_SEM5_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar número de pasajeros
        System.out.print("¿Cuántos pasajeros se registrarán? ");
        int numPasajeros = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        
        // Crear los dos arrays
        String[] nombres = new String[numPasajeros];
        String[] destinos = new String[numPasajeros];
        
        // Captura de datos usando for
        for (int i = 0; i < numPasajeros; i++) {
            System.out.println("\n--- Pasajero " + (i + 1) + " ---");
            
            // Validar que el nombre no esté vacío
            String nombre = "";
            while (nombre.isEmpty()) {
                System.out.print("Nombre: ");
                nombre = scanner.nextLine().trim();
                
                if (nombre.isEmpty()) {
                    System.out.println("Error: El nombre no puede estar vacío.");
                }
            }
            nombres[i] = nombre;
            
            // Capturar destino
            System.out.print("Destino: ");
            destinos[i] = scanner.nextLine().trim();
        }
        
        // For-each para mostrar la lista completa de pasajeros
        System.out.println("\n========== LISTA DE PASAJEROS ==========");
        for (String nombre : nombres) {
            System.out.println("- " + nombre);
        }
        
        // Contar pasajeros por destino y analizar
        System.out.println("\n========== ANÁLISIS DE PASAJEROS ==========");
        int contarCDMX = 0;
        int contarLocal = 0;
        
        for (int i = 0; i < numPasajeros; i++) {
            System.out.println("\nPasajero: " + nombres[i] + " | Destino: " + destinos[i]);
            
            // Clasificar según destino
            if (destinos[i].equalsIgnoreCase("CDMX")) {
                System.out.println("*** Viaje largo ***");
                contarCDMX++;
            } else if (destinos[i].equalsIgnoreCase("Local")) {
                System.out.println("*** Viaje corto ***");
                contarLocal++;
            }
        }
        
        // Contar pasajeros por cada destino único
        System.out.println("\n========== CONTEO POR DESTINO ==========");
        for (int i = 0; i < numPasajeros; i++) {
            boolean yaContado = false;
            
            // Verificar si ya se contó este destino
            for (int j = 0; j < i; j++) {
                if (destinos[j].equalsIgnoreCase(destinos[i])) {
                    yaContado = true;
                    break;
                }
            }
            
            // Si no fue contado, contar todos los pasajeros con ese destino
            if (!yaContado) {
                int contar = 0;
                for (int j = 0; j < numPasajeros; j++) {
                    if (destinos[j].equalsIgnoreCase(destinos[i])) {
                        contar++;
                    }
                }
                System.out.println(destinos[i] + ": " + contar + " pasajero(s)");
            }
        }
        
        // Encontrar destino con más pasajeros
        String destinoMasPasajeros = "";
        int maxPasajeros = 0;
        
        for (int i = 0; i < numPasajeros; i++) {
            boolean yaContado = false;
            
            for (int j = 0; j < i; j++) {
                if (destinos[j].equalsIgnoreCase(destinos[i])) {
                    yaContado = true;
                    break;
                }
            }
            
            if (!yaContado) {
                int contar = 0;
                for (int j = 0; j < numPasajeros; j++) {
                    if (destinos[j].equalsIgnoreCase(destinos[i])) {
                        contar++;
                    }
                }
                
                if (contar > maxPasajeros) {
                    maxPasajeros = contar;
                    destinoMasPasajeros = destinos[i];
                }
            }
        }
        
        // Mostrar resultados finales
        System.out.println("\n========== RESULTADOS FINALES ==========");
        System.out.println("Total de pasajeros registrados: " + numPasajeros);
        System.out.println("Destino con más pasajeros: " + destinoMasPasajeros + " (" + maxPasajeros + " pasajeros)");
        
        scanner.close();
    }
}

import java.util.Scanner;

public class REQ2_SEM5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos pasajeros se registrarán? ");
        int numPasajeros = sc.nextInt();
        sc.nextLine(); 

        String[] nombres = new String[numPasajeros];
        String[] destinos = new String[numPasajeros];

        //captura de datos con for
        for (int i = 0; i < numPasajeros; i++) {
            System.out.println("\nRegistro del pasajero #" + (i + 1));
            
            //validar nombre con while
            System.out.print("Nombre del pasajero: ");
            String nombreAux = sc.nextLine();
            
            while (nombreAux.trim().isEmpty()) {

                if (nombreAux.trim().isEmpty()) {
                    System.out.println("Error: El nombre no puede estar vacío.");
                    System.out.print("Ingrese el nombre nuevamente: ");
                    nombreAux = sc.nextLine();
                }
            }
            nombres[i] = nombreAux;

            System.out.print("Destino (CDMX / Local / Otro): ");
            destinos[i] = sc.nextLine();
        }

        //procesamiento con for-each
        int contadorCDMX = 0;
        int contadorLocal = 0;
        int contadorOtros = 0;
        int index = 0;

        System.out.println("\n--- Lista Completa de Pasajeros ---");
        for (String d : destinos) {
            String pasajero = nombres[index];
            System.out.print("Pasajero: " + pasajero + " | Destino: " + d);

            //clasificación de viaje
            if (d.equalsIgnoreCase("CDMX")) {
                System.out.print(" -> [Viaje largo]");
                contadorCDMX++;
            } else if (d.equalsIgnoreCase("Local")) {
                System.out.print(" -> [Viaje corto]");
                contadorLocal++;
            } else {
                contadorOtros++;
            }
            System.out.println();
            index++;
        }

        //determinar destino con más pasajeros
        String destinoPopular;
        if (contadorCDMX >= contadorLocal && contadorCDMX >= contadorOtros) {
            destinoPopular = "CDMX";
        } else if (contadorLocal >= contadorCDMX && contadorLocal >= contadorOtros) {
            destinoPopular = "Local";
        } else {
            destinoPopular = "Otros destinos";
        }

        System.out.println("\n--- Resumen del Viaje ---");
        System.out.println("Total de pasajeros registrados: " + numPasajeros);
        System.out.println("Pasajeros a CDMX: " + contadorCDMX);
        System.out.println("Pasajeros Locales: " + contadorLocal);
        System.out.println("El destino con más pasajeros es: " + destinoPopular);

        sc.close();
    }
}

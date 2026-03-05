import java.util.Scanner;

/**
 * Institución: Universidad Tecnológica de Torreón.
 * Carrera: Ingeniería en Desarrollo de Software.
 * Alumno: [Juan Diego Arroyo Bucio.]
 * Materia: Programación Estructurada.
 */
public class REQ21SEM5JDAB {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de pasajeros a registrar: ");
        int n = read.nextInt();
        read.nextLine(); // Limpiando la tubería del 'Enter' fantasma

        // Creación de los arreglos dinámicos
        String[] nombres = new String[n];
        String[] destinos = new String[n];

        System.out.println("\n--- CAPTURA DE DATOS ---");
        // Captura de datos con ciclo FOR
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el nombre del pasajero #" + (i + 1) + ": ");
            nombres[i] = read.nextLine();

            // Validación con while e if (Requerimiento estricto)
            while (nombres[i].isEmpty()) {
                if (nombres[i].isEmpty()) {
                    System.out.println("Error: El nombre no puede estar vacío.");
                }
                System.out.print("Vuelva a ingresar el nombre: ");
                nombres[i] = read.nextLine();
            }

            System.out.print("Ingrese el destino de " + nombres[i] + " (Ej. CDMX, Local, etc.): ");
            destinos[i] = read.nextLine();
            System.out.println("---------------------------");
        }

        System.out.println("\n--- TABLERO DE VUELOS ---");

        // Contadores y variables para el análisis
        int cont = 0;
        int vuelosCDMX = 0;
        int vuelosLocal = 0;

        // Procesamiento con FOR-EACH
        for (String dest : destinos) {
            System.out.print("Pasajero: " + nombres[cont] + " | Destino: " + dest);

            // Comparación de textos ignorando mayúsculas/minúsculas
            if (dest.equalsIgnoreCase("CDMX")) {
                System.out.println(" -> Viaje largo");
                vuelosCDMX++;
            } else if (dest.equalsIgnoreCase("Local")) {
                System.out.println(" -> Viaje corto");
                vuelosLocal++;
            } else {
                System.out.println(" -> Viaje estándar");
            }
            cont++; // Avanzamos el índice para el siguiente nombre
        }

        // Determinar el destino con más pasajeros (Lógica básica entre los dos principales)
        String destinoGanador = "Ninguno (Empate o Sin registros válidos)";
        if (vuelosCDMX > vuelosLocal) {
            destinoGanador = "CDMX";
        } else if (vuelosLocal > vuelosCDMX) {
            destinoGanador = "Local";
        } else if (vuelosCDMX > 0 && vuelosCDMX == vuelosLocal) {
            destinoGanador = "Empate entre CDMX y Local";
        }

        System.out.println("\n--- REPORTE FINAL ---");
        System.out.println("Destino con más pasajeros: " + destinoGanador);
        System.out.println("Total de pasajeros registrados: " + n);

        read.close();
    }
}
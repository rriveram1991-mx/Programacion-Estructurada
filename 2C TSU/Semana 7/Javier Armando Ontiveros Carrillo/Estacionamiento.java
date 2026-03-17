package estacionamiento;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Estacionamiento {
    
    public static void main(String[] args) {
        String[] estacionamiento = new String[10];
        for (int i = 0; i < estacionamiento.length; i++) {
            estacionamiento[i] = "LIBRE";
        }

        Scanner leer = new Scanner(System.in);
        boolean salir = false;
        
        while (!salir) {
            mostrarMenu();
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    verEstacionamiento(estacionamiento);
                    break;
                case 2:
                    estacionarAuto(estacionamiento, leer);
                    break;
                case 3:
                    retirarAuto(estacionamiento, leer);
                    break;
                case 4:
                    contarEspaciosOcupados(estacionamiento);
                    break;
                case 5: 
                    guardarEstadoEnTXT(estacionamiento);
                    break;
                case 6:
                    salir = true;
                    System.out.println("Saliendo del sistema de estacionamiento. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número del menú.");
            }
        }

    }
    
    public static void mostrarMenu() {
        System.out.println("\n--- Sistema de Control de Estacionamiento ---");
        System.out.println("1. Ver estacionamiento");
        System.out.println("2. Estacionar auto");
        System.out.println("3. Retirar auto");
        System.out.println("4. Contar espacios ocupados");
        System.out.println("5. Guardar estado en TXT"); 
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    public static void verEstacionamiento(String[] estacionamiento) {
        System.out.println("\n--- Estado del Estacionamiento ---");
        for (int i = 0; i < estacionamiento.length; i++) {
            System.out.println("Espacio " + (i + 1) + ": " + estacionamiento[i]);
        }
    }
    
    public static void estacionarAuto(String[] estacionamiento, Scanner scanner) {
        System.out.print("\nIngrese el número de espacio donde desea estacionar (1-" + estacionamiento.length + "): ");
        int numeroEspacio = scanner.nextInt();

        if (numeroEspacio >= 1 && numeroEspacio <= estacionamiento.length) {
            int indice = numeroEspacio - 1;
            if (estacionamiento[indice].equals("LIBRE")) {
                estacionamiento[indice] = "OCUPADO";
                System.out.println("Auto estacionado exitosamente en el espacio " + numeroEspacio + ".");
            } else {
                System.out.println("Error: El espacio " + numeroEspacio + " ya está ocupado.");
            }
        } else {
            System.out.println("Error: Número de espacio inválido. Por favor, ingrese un número entre 1 y " + estacionamiento.length + ".");
        }
    }
    
    public static void retirarAuto(String[] estacionamiento, Scanner scanner) {
        System.out.print("\nIngrese el número de espacio del cual desea retirar el auto (1-" + estacionamiento.length + "): ");
        int numeroEspacio = scanner.nextInt();

        if (numeroEspacio >= 1 && numeroEspacio <= estacionamiento.length) {
            int indice = numeroEspacio - 1;
            if (estacionamiento[indice].equals("OCUPADO")) {
                estacionamiento[indice] = "LIBRE";
                System.out.println("Auto retirado exitosamente del espacio " + numeroEspacio + ".");
            } else {
                System.out.println("Error: El espacio " + numeroEspacio + " ya está libre.");
            }
        } else {
            System.out.println("Error: Número de espacio inválido. Por favor, ingrese un número entre 1 y " + estacionamiento.length + ".");
        }
    }
    
    public static void contarEspaciosOcupados(String[] estacionamiento) {
        int contadorOcupados = 0;
        for (String estado : estacionamiento) {
            if (estado.equals("OCUPADO")) {
                contadorOcupados++;
            }
        }
        System.out.println("\nTotal de espacios ocupados: " + contadorOcupados);
        System.out.println("Total de espacios libres: " + (estacionamiento.length - contadorOcupados));
    }
    
    public static void guardarEstadoEnTXT(String[] estacionamiento) {
        
        String nombreArchivo = "estado_estacionamiento.txt";
        
        try (FileWriter writer = new FileWriter(nombreArchivo)) {

            writer.write("--- Estado del Estacionamiento ---\n");
            
            for (int i = 0; i < estacionamiento.length; i++) {
                
                writer.write("Espacio " + (i + 1) + ": " + estacionamiento[i] + "\n");
            }
            
            System.out.println("Estado del estacionamiento guardado exitosamente en '" + nombreArchivo + "'.");

        } catch (IOException e) {
            
            System.err.println("Error al guardar el estado del estacionamiento en el archivo: " + e.getMessage());
        }
    }
}

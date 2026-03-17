import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class SistemaEstacionamineto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. Crear el estacionamiento (Array de tamaño 10)
        String[] espacios = new String[10];
        
        // Inicializar todos los espacios como "LIBRE"
        for (int i = 0; i < espacios.length; i++) {
            espacios[i] = "LIBRE";
        }

        int opcion = 0;

        // 2. Menú interactivo (while + switch)
        while (opcion != 5) {
            System.out.println("\n--- SISTEMA DE ESTACIONAMIENTO ---");
            System.out.println("1. Ver estacionamiento");
            System.out.println("2. Estacionar auto");
            System.out.println("3. Retirar auto");
            System.out.println("4. Contar espacios ocupados");
            System.out.println("5. Salir y Guardar Reporte");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    // 3. Ver estacionamiento
                    System.out.println("\nEstado actual:");
                    for (int i = 0; i < espacios.length; i++) {
                        System.out.println("Espacio " + (i + 1) + ": " + espacios[i]);
                    }
                    break;

                case 2:
                    // 4. Estacionar auto
                    System.out.print("Ingrese el número de espacio (1-10): ");
                    int eOcupar = sc.nextInt() - 1; // Restamos 1 por el índice del array

                    if (eOcupar >= 0 && eOcupar < 10) {
                        if (espacios[eOcupar].equals("LIBRE")) {
                            espacios[eOcupar] = "OCUPADO";
                            System.out.println("¡Auto estacionado con éxito!");
                        } else {
                            System.out.println("ERROR: El espacio ya está ocupado.");
                        }
                    } else {
                        System.out.println("Espacio inválido.");
                    }
                    break;

                case 3:
                    // 5. Retirar auto
                    System.out.print("Ingrese el número de espacio a liberar (1-10): ");
                    int eLiberar = sc.nextInt() - 1;

                    if (eLiberar >= 0 && eLiberar < 10) {
                        if (espacios[eLiberar].equals("OCUPADO")) {
                            espacios[eLiberar] = "LIBRE";
                            System.out.println("El espacio ha sido liberado.");
                        } else {
                            System.out.println("El espacio ya estaba libre.");
                        }
                    } else {
                        System.out.println("Espacio inválido.");
                    }
                    break;

                case 4:
                    // 6. Contar espacios ocupados (usando for-each)
                    int contador = 0;
                    for (String estado : espacios) {
                        if (estado.equals("OCUPADO")) {
                            contador++;
                        }
                    }
                    System.out.println("Total de autos estacionados: " + contador);
                    break;

                case 5:
                    // 7 y 8. Salir y Crear TXT
                    guardarReporte(espacios);
                    System.out.println("Saliendo del sistema... Reporte generado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }

    // Método para generar el archivo de texto
    public static void guardarReporte(String[] datos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("reporte_estacionamiento.txt"))) {
            writer.println("REPORTE FINAL DEL ESTACIONAMIENTO");
            writer.println("---------------------------------");
            for (int i = 0; i < datos.length; i++) {
                writer.println("Espacio " + (i + 1) + ": " + datos[i]);
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }
}
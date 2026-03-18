import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Institución: Universidad Tecnológica de Torreón.
 * Carrera: Ingeniería en Desarrollo de Software.
 * Alumno: [Juan Diego Arroyo Bucio.]
 * Materia: Programación Estructurada.
 */
public class RetoEstacionamiento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Crear el estacionamiento (Array de 10 espacios)
        String[] espacios = new String[10];

        // Inicializar todos los espacios como "LIBRE"
        for (int i = 0; i < espacios.length; i++) {
            espacios[i] = "LIBRE";
        }

        boolean salir = false;

        // 2. Menú interactivo con while
        while (!salir) {
            System.out.println("\n=== MENÚ ESTACIONAMIENTO ===");
            System.out.println("1. Ver estacionamiento");
            System.out.println("2. Estacionar auto");
            System.out.println("3. Retirar auto");
            System.out.println("4. Contar espacios ocupados");
            System.out.println("5. Salir y generar reporte TXT");
            System.out.print("Elige una opción: ");

            int opcion = sc.nextInt();

            // Switch para controlar las opciones
            switch (opcion) {

                case 1:
                    // 3. Ver estacionamiento (usando for clásico)
                    System.out.println("\n--- ESTADO ACTUAL ---");
                    for (int i = 0; i < espacios.length; i++) {
                        System.out.println("Espacio " + (i + 1) + ": " + espacios[i]);
                    }
                    break;

                case 2:
                    // 4. Estacionar auto
                    System.out.print("\n¿En qué número de espacio deseas estacionar (1-10)? ");
                    int espEstacionar = sc.nextInt() - 1; // Restamos 1 para coincidir con el índice del arreglo

                    // Validar límites del arreglo para evitar crasheos
                    if (espEstacionar >= 0 && espEstacionar < 10) {
                        // Comparar textos en Java usa .equals()
                        if (espacios[espEstacionar].equals("LIBRE")) {
                            espacios[espEstacionar] = "OCUPADO";
                            System.out.println("Éxito: Auto estacionado en el espacio " + (espEstacionar + 1));
                        } else {
                            System.out.println("Error: El espacio ya está OCUPADO.");
                        }
                    } else {
                        System.out.println("Error: Número de espacio inválido.");
                    }
                    break;

                case 3:
                    // 5. Retirar auto
                    System.out.print("\n¿Qué número de espacio deseas desocupar (1-10)? ");
                    int espRetirar = sc.nextInt() - 1;

                    if (espRetirar >= 0 && espRetirar < 10) {
                        if (espacios[espRetirar].equals("OCUPADO")) {
                            espacios[espRetirar] = "LIBRE";
                            System.out.println("Éxito: Auto retirado del espacio " + (espRetirar + 1));
                        } else {
                            System.out.println("Error: El espacio ya está LIBRE, no hay auto que retirar.");
                        }
                    } else {
                        System.out.println("Error: Número de espacio inválido.");
                    }
                    break;

                case 4:
                    // 6. Contar espacios ocupados (usando for-each)
                    int contadorOcupados = 0;
                    for (String estado : espacios) {
                        if (estado.equals("OCUPADO")) {
                            contadorOcupados++;
                        }
                    }
                    System.out.println("\nTotal de espacios ocupados: " + contadorOcupados);
                    break;

                case 5:
                    // 7 y 8. Salir del programa y crear TXT
                    salir = true;
                    System.out.println("\nGenerando reporte TXT y saliendo del sistema...");

                    try {

                        FileWriter writer = new FileWriter("reporte_estacionamiento.txt");
                        writer.write("=== REPORTE FINAL DEL ESTACIONAMIENTO ===\n");

                        for (int i = 0; i < espacios.length; i++) {
                            writer.write("Espacio " + (i + 1) + ": " + espacios[i] + "\n");
                        }

                        writer.close();
                        System.out.println("-> Reporte guardado exitosamente.");

                    } catch (IOException e) {
                        System.out.println("Error crítico al intentar crear el archivo TXT.");
                    }
                    break;

                default:
                    System.out.println("\nOpción no válida. Intenta de nuevo.");
            }
        }

        sc.close();
    }
}
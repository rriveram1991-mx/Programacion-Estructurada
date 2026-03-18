package sistema.de.estacionamiento;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author nohem
 */
public class SISTEMADEESTACIONAMIENTO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        
        // Crear el estacionamiento
        String[] espacios = new String[10];
        
        for (int i = 0; i < espacios.length; i++) {
            espacios[i] = "LIBRE";
        }
        espacios [4]="OCUPADO";
        espacios [9]="OCUPADO";
        espacios [1]="OCUPADO";

        int opcion = 0;

        //MENU CON WHILE Y SWITCH
        while (opcion != 5) {
            System.out.println("\n--- SISTEMA DE ESTACIONAMIENTO ---");
            System.out.println("1. Ver estacionamiento");
            System.out.println("2. Estacionar auto");
            System.out.println("3. Retirar auto");
            System.out.println("4. Contar espacios ocupados");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado actual:");
                    for (int i = 0; i < espacios.length; i++) {
                        System.out.println("Espacio " + (i + 1) + ": " + espacios[i]);
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el número de espacio (1-10): ");
                    int eIngreso = leer.nextInt() - 1; 

                    if (eIngreso >= 0 && eIngreso < 10) {
                        if (espacios[eIngreso].equals("LIBRE")) {
                            espacios[eIngreso] = "OCUPADO";
                            System.out.println("¡Auto estacionado con éxito!");
                        } else {
                            System.out.println("Error: El espacio ya está OCUPADO.");
                        }
                    } else {
                        System.out.println("Número de espacio inválido.");
                    }
                    break;

                case 3:
                    
                    System.out.print("Ingrese el número de espacio a liberar (1-10): ");
                    int eSalida = leer.nextInt() - 1;

                    if (eSalida >= 0 && eSalida < 10) {
                        if (espacios[eSalida].equals("OCUPADO")) {
                            espacios[eSalida] = "LIBRE";
                            System.out.println("Espacio liberado correctamente.");
                        } else {
                            System.out.println(" el espacio ya estaba LIBRE.");
                        }
                    } else {
                        System.out.println("Número de espacio inválido.");
                    }
                    break;

                case 4:
                    int contador = 0;
                    for (String estado : espacios) {
                        if (estado.equals("OCUPADO")) {
                            contador++;
                        }
                    }
                    System.out.println("Total de autos estacionados: " + contador);
                    break;

                case 5:
                    try {
                      
                        FileWriter fichero = new FileWriter("estacionamiento.txt");
                        PrintWriter escritor = new PrintWriter(fichero);

                        escritor.println("ESTADO DEL ESTACIONAMIENTO");
                        escritor.println("--------------------------");
                        for (int i = 0; i < espacios.length; i++) {
                            escritor.println("Espacio " + (i + 1) + ": " + espacios[i]);
                        }
                        escritor.close(); 
                        System.out.println("Archivo 'estacionamiento.txt' generado con éxito.");
                         System.out.println("Saliendo del sistema... ¡Buen día!");

                    } catch (Exception error) {
                        System.out.println("No se pudo crear el archivo: " + error.getMessage());
                    }
                   
                    break;

                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
        leer.close();
    }
}
    
    


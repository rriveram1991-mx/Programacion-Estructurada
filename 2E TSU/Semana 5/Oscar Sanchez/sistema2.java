/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication52;

import java.util.Scanner;

/** 
            
 *
 * @author edwin, oscar sanchez
 */
public class sistema2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Solicitar número de pasajeros
        System.out.print("¿Cuántos pasajeros se registrarán?: ");
        int numPasajeros = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // 2. Crear los dos arrays
        String[] nombres = new String[numPasajeros];
        String[] destinos = new String[numPasajeros];

        // 3. Captura con ciclo for
        for (int i = 0; i < numPasajeros; i++) {
            String nombreValido = "";
            
            // 4. Validar con while que el nombre no esté vacío
            // .isEmpty() devuelve true si el usuario solo dio "Enter" sin escribir nada
            while (nombreValido.isEmpty()) {
                System.out.print("\nIngrese el nombre del pasajero #" + (i + 1) + ": ");
                nombreValido = scanner.nextLine();

                // 5. Mostrar error con if si está vacío
                if (nombreValido.isEmpty()) {
                    System.out.println("Error: El nombre no puede estar vacío. Intente de nuevo.");
                }
            }
            nombres[i] = nombreValido;

            System.out.print("Ingrese el destino (CDMX / Local / Otro): ");
            destinos[i] = scanner.nextLine();
        }

        // Variables para el procesamiento
        int contadorCDMX = 0;
        int contadorLocal = 0;
        int contadorOtros = 0;

        System.out.println("\n--- Lista Completa de Pasajeros ---");

        // 6. Procesamiento con for-each
        int indice = 0;
        for (String nombrePasajero : nombres) {
            String destinoActual = destinos[indice];
            System.out.print("Pasajero: " + nombrePasajero + " | Destino: " + destinoActual);

            // 7. Lógica de destinos y distancias
            // Usamos .equalsIgnoreCase para que no importe si escriben "cdmx" o "CDMX"
            if (destinoActual.equalsIgnoreCase("CDMX")) {
                System.out.print(" -> [Viaje largo]");
                contadorCDMX++;
            } else if (destinoActual.equalsIgnoreCase("Local")) {
                System.out.print(" -> [Viaje corto]");
                contadorLocal++;
            } else {
                contadorOtros++;
            }

            System.out.println();
            indice++;
        }

        // 8. Determinar destino con más pasajeros
        String destinoPopular = "";
        if (contadorCDMX > contadorLocal && contadorCDMX > contadorOtros) {
            destinoPopular = "CDMX";
        } else if (contadorLocal > contadorCDMX && contadorLocal > contadorOtros) {
            destinoPopular = "Local";
        } else {
            destinoPopular = "Otros destinos (o empate)";
        }

        // 9. Mostrar resultados finales
        System.out.println("\n--- Resumen del Viaje ---");
        System.out.println("Total de pasajeros registrados: " + numPasajeros);
        System.out.println("Destino con más pasajeros: " + destinoPopular);
        
    }
}
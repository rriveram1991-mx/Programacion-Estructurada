/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pasajeros;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class REQ2SEM5Pasajeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- REQUERIMIENTO: Solicitar número de pasajeros ---
        System.out.print("Ingrese el número de pasajeros a registrar: ");
        int numPasajeros = sc.nextInt();
        sc.nextLine(); // Limpieza de buffer necesaria después de leer un entero

        // --- REQUERIMIENTO: Crear los dos arrays ---
        String[] nombres = new String[numPasajeros]; // Array para nombres de los pasajeros
        String[] destinos = new String[numPasajeros]; // Array para los destinos de cada uno

        // --- REQUERIMIENTO: Captura con for ---
        for (int i = 0; i < numPasajeros; i++) {
            System.out.println("\n--- Pasajero #" + (i + 1) + " ---");

            // --- REQUERIMIENTO: Validar con while que el nombre no esté vacío ---
            System.out.print("Nombre del pasajero: ");
            String nombreTemp = sc.nextLine();

            // .trim().isEmpty() verifica si la cadena está vacía o solo tiene espacios: fue investigado
            while (nombreTemp.trim().isEmpty()) {
                // REQUERIMIENTO: Mostrar error usando if
                if (nombreTemp.trim().isEmpty()) {
                    System.out.println("(!) Error: El nombre no puede estar vacío.");
                    System.out.print("Por favor, ingrese un nombre válido: ");
                    nombreTemp = sc.nextLine();
                }
            }
            nombres[i] = nombreTemp; // Guardamos el nombre válido en el array

            // Captura del destino (Convertimos a mayúsculas para facilitar comparaciones: tambien fue investigado)
            System.out.print("Destino (CDMX / Local / Otro): ");
            destinos[i] = sc.nextLine().toUpperCase();
        }

        // --- REQUERIMIENTO: Procesamiento y Contadores ---
        int contadorCDMX = 0;
        int contadorLocal = 0;
        int contadorOtros = 0;
        int indice = 0; // Auxiliar para acceder a los destinos dentro del for-each

        System.out.println("\n--- LISTA COMPLETA DE PASAJEROS ---");

        // --- REQUERIMIENTO: Usar for-each para mostrar la lista ---
        for (String nombre : nombres) {
            String destinoActual = destinos[indice]; // Obtenemos el destino del pasajero actual
            
            System.out.print("Pasajero: " + nombre + " | Destino: " + destinoActual);

            // --- REQUERIMIENTO: Validar destino y mostrar tipo de viaje ---
            // Usamos .equals() porque en Java los Strings no se comparan con ==
            if (destinoActual.equals("CDMX")) {
                System.out.print(" -> [Viaje largo]");
                contadorCDMX++; // Incrementamos contador de CDMX
            } else if (destinoActual.equals("LOCAL")) {
                System.out.print(" -> [Viaje corto]");
                contadorLocal++; // Incrementamos contador de Local
            } else {
                contadorOtros++; // Incrementamos si es cualquier otro destino
            }
            
            System.out.println(); // Salto de línea
            indice++; // Pasamos al siguiente índice del array de destinos
        }

        // --- REQUERIMIENTO: Análisis final ---
        System.out.println("\n--- ESTADÍSTICAS DEL VIAJE ---");
        System.out.println("Total de pasajeros registrados: " + numPasajeros);
        System.out.println("Pasajeros a CDMX: " + contadorCDMX);
        System.out.println("Pasajeros Locales: " + contadorLocal);
        System.out.println("Otros destinos: " + contadorOtros);

        // --- REQUERIMIENTO: Mostrar destino con más pasajeros ---
        System.out.print("Destino con más pasajeros: ");
        if (contadorCDMX > contadorLocal && contadorCDMX > contadorOtros) {
            System.out.println("CDMX");
        } else if (contadorLocal > contadorCDMX && contadorLocal > contadorOtros) {
            System.out.println("Local");
        } else if (contadorOtros > contadorCDMX && contadorOtros > contadorLocal) {
            System.out.println("Otros");
        } else {
            System.out.println("Hay un empate entre destinos.");
        }

        sc.close(); 
    }
}
    
    


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg1.sem5.pkg2b.pkg2;

import java.util.Scanner;

/**
 *
 * @author lopez
 */
public class REQ1SEM52B2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lr =new Scanner (System.in);
        // 1. Solicitar número de pasajeros
        System.out.print("Ingrese el número de pasajeros: ");
        int numPasajeros = lr.nextInt();
        lr.nextLine(); 

        //  dos arrays
        String[] nombres = new String[numPasajeros];
        String[] destinos = new String[numPasajeros];

        // 3. Captura con validación
        for (int i = 0; i < numPasajeros; i++) {
            System.out.println("\nPasajero " + (i + 1) + ":");
            
            // Validar que el nombre no esté vacío
            System.out.print("Nombre: ");
            String nombreIngresado = lr.nextLine();
            
            while (nombreIngresado.trim().isEmpty()) {
                if (nombreIngresado.trim().isEmpty()) { // error usando if
                    System.out.println("Error: El nombre no puede estar vacío.");
                    System.out.print("Ingrese el nombre nuevamente: ");
                    nombreIngresado = lr.nextLine();
                }
            }
            nombres[i] = nombreIngresado;

            System.out.print("Destino (CDMX / Local / Otro): ");
            destinos[i] = lr.nextLine();
        }

        // Procesamiento y conteo
        int cdmx = 0, local = 0, otros = 0;
        
        System.out.println("\n--- Lista Completa de Pasajeros ---");
        int indice = 0;
        
        // Usar for-each para mostrar la lista
        for (String destino : destinos) {
            String nombre = nombres[indice];
            String infoViaje = "";

            // Lógica de destinos
            if (destino.equalsIgnoreCase("CDMX")) {
                cdmx++;
                infoViaje = "- Viaje largo";
            } else if (destino.equalsIgnoreCase("Local")) {
                local++;
                infoViaje = "- Viaje corto";
            } else {
                otros++;
            }

            System.out.println("Pasajero: " + nombre + " | Destino: " + destino + " " + infoViaje);
            indice++;
        }

        // Determinar destino con más pasajeros
        String destinoPopular = "";
        if (cdmx > local && cdmx > otros) {
            destinoPopular = "CDMX";
        } else if (local > cdmx && local > otros) {
            destinoPopular = "Local";
        } else if (otros > cdmx && otros > local) {
            destinoPopular = "Otros destinos";
        } else {
            destinoPopular = "Empate entre destinos";
        }

        //  Mostrar resultados finales
        System.out.println("\n--- Resumen de Viaje ---");
        System.out.println("Total de pasajeros registrados: " + numPasajeros);
        System.out.println("Pasajeros a CDMX: " + cdmx);
        System.out.println("Pasajeros Locales: " + local);
        System.out.println("Destino con más pasajeros: " + destinoPopular);
    }
}
    
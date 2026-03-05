/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pasajeros;

import java.util.Scanner;

/**
 *
 * @author juang
 */
public class Pasajeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner sc = new Scanner(System.in);

        // Solicitar número de pasajeros
        System.out.print("Ingrese el número de pasajeros: ");
        int n = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        // Crear arrays
        String[] nombres = new String[n];
        String[] destinos = new String[n];

        // Variables para contar destinos
        int cdmx = 0;
        int local = 0;
        int otros = 0;

        // CAPTURA DE DATOS
        for (int i = 0; i < n; i++) {

            System.out.println("\nPasajero #" + (i + 1));

            // Capturar nombre
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            while (nombre.trim().isEmpty()) {
                if (nombre.trim().isEmpty()) {
                    System.out.println("Error: el nombre no puede estar vacío.");
                }
                System.out.print("Ingrese el nombre nuevamente: ");
                nombre = sc.nextLine();
            }

            nombres[i] = nombre;

            // Capturar destino
            System.out.print("Destino: ");
            System.out.println("(¿CDMX , Local o otro ?)");
            String destino = sc.nextLine();
            destinos[i] = destino;

            // Clasificación del destino
            if (destino.equalsIgnoreCase("CDMX")) {
                System.out.println("Viaje largo");
                cdmx++;
            } else if (destino.equalsIgnoreCase("Local")) {
                System.out.println("Viaje corto");
                local++;
            } else {
                otros++;
            }
        }

        // MOSTRAR LISTA COMPLETA
        System.out.println("\n--- Lista de Pasajeros ---");

        int i = 0;
        for (String nombre : nombres) {
            System.out.println("Pasajero: " + nombre + " - Destino: " + destinos[i]);
            i++;
        }

        // Determinar destino con más pasajeros
        String destinoMayor = "Otros";
        int max = otros;

        if (cdmx > max) {
            destinoMayor = "CDMX";
            max = cdmx;
        }

        if (local > max) {
            destinoMayor = "Local";
            max = local;
        }

        // RESULTADOS FINALES
        System.out.println("\n--- Resumen ---");
        System.out.println("Pasajeros a CDMX: " + cdmx);
        System.out.println("Pasajeros Locales: " + local);
        System.out.println("Otros destinos: " + otros);
        System.out.println("Destino con más pasajeros: " + destinoMayor);
        System.out.println("Total de pasajeros registrados: " + n);

        sc.close();
    }
}
   
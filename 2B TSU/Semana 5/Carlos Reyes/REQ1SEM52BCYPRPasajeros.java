/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg1.sem5.pkg2bcypr.pasajeros;

import java.util.Scanner;

/**
 *
 * @author juanc
 */
public class REQ1SEM52BCYPRPasajeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        // Solicitar número de pasajeros
        System.out.print("Ingrese número de pasajeros: ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        // Crear arrays
        String[] nombres = new String[cantidad];
        String[] destinos = new String[cantidad];

        int cdmx = 0;
        int local = 0;
        int otros = 0;
       
        // CAPTURA DE DATOS
        for (int i = 0; i < cantidad; i++) {

            System.out.println("\nPasajero " + (i + 1));

            // Captura del nombre
            System.out.print("Nombre: ");
            nombres[i] = sc.nextLine();

            // Validación de nombre vacío
            while (nombres[i].isEmpty()) {

                // Uso de if para mostrar error
                if (nombres[i].isEmpty()) {
                    System.out.println("Error: el nombre no puede estar vacío.");
                }

                System.out.print("Ingrese nuevamente el nombre: ");
                nombres[i] = sc.nextLine();
            }

            // Captura del destino
            System.out.print("Destino: (CDMX/LOCAL/OTROS) ");
            destinos[i] = sc.nextLine();

            // Clasificación del destino
            if (destinos[i].equalsIgnoreCase("CDMX")) {
                System.out.println("Viaje largo");
                cdmx++;
            } 
            else if (destinos[i].equalsIgnoreCase("Local")) {
                System.out.println("Viaje corto");
                local++;
            } 
            else {
                otros++;
            }
        }
        // MOSTRAR PASAJEROS
        System.out.println("\nLista de pasajeros:");

        // for-each para mostrar los nombres
        for (String nombre : nombres) {
            System.out.println("Pasajero: " + nombre);
        }

        // DETERMINAR DESTINO CON MÁS PASAJEROS
        String destinoMayor;

        if (cdmx > local && cdmx > otros) {
            destinoMayor = "CDMX";
        } else if (local > cdmx && local > otros) {
            destinoMayor = "Local";
        } else {
            destinoMayor = "Otros destinos";
        }

        // RESULTADOS
        System.out.println("\nEstadísticas:");
        System.out.println("Pasajeros a CDMX: " + cdmx);
        System.out.println("Pasajeros Locales: " + local);
        System.out.println("Otros destinos: " + otros);

        System.out.println("Destino con más pasajeros: " + destinoMayor);
        System.out.println("Total de pasajeros registrados: " + cantidad);

        sc.close();
    }
}
    
    


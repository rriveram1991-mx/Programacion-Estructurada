/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg2.sem5.pkg2d.sra;

import java.util.Scanner;

/**
 *
 * @author crist
 */
public class REQ2SEM52DSRA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     

        Scanner leer = new Scanner(System.in); 
        // Objeto para capturar datos del usuario

        System.out.print("Ingrese el número de pasajeros: ");
        int n = leer.nextInt(); 
        leer.nextLine(); 
        // Guarda cuántos pasajeros se registrarán y limpia el buffer

        String[] nombres = new String[n]; 
        // Array para guardar los nombres de los pasajeros

        String[] destinos = new String[n]; 
        // Array para guardar los destinos de los pasajeros

        // Ciclo for para capturar los datos de cada pasajero
        for (int i = 0; i < n; i++) {

            System.out.println("Pasajero #" + (i + 1));

            System.out.print("Nombre: ");
            nombres[i] = leer.nextLine();

            // Validación con while para evitar nombres vacíos
            while (nombres[i].isEmpty()) {

                if (nombres[i].isEmpty()) {
                    System.out.println("Error: el nombre no puede estar vacío.");
                    System.out.print("Ingrese nuevamente el nombre: ");
                    nombres[i] = leer.nextLine();
                }
            }

            System.out.print("Destino: ");
            destinos[i] = leer.nextLine(); 
            // Guarda el destino del pasajero
        }

        int cdmx = 0;
        int local = 0;
        int otros = 0;
        // Contadores para saber cuántos pasajeros van a cada destino

        System.out.println("\nLista de pasajeros:");

        // For para mostrar todos los pasajeros registrados
        for (String nombre : nombres) {
            System.out.println("Pasajero: " + nombre);
        }

        System.out.println("\nInformación de viajes:");

        // Este  For es para analizar los destinos
        for (int i = 0; i < destinos.length; i++) {

            if (destinos[i].equalsIgnoreCase("CDMX")) {
                System.out.println(nombres[i] + " → Viaje largo");
                cdmx++;

            } else if (destinos[i].equalsIgnoreCase("Local")) {
                System.out.println(nombres[i] + " → Viaje corto");
                local++;

            } else {
                otros++;
            }
        }

        // Este String determina el destino con más pasajeros
        String destinoMayor = "";

        if (cdmx > local && cdmx > otros) {
            destinoMayor = "CDMX";
        } else if (local > cdmx && local > otros) {
            destinoMayor = "Local";
        } else {
            destinoMayor = "Otros destinos";
        }

      
        System.out.println("\nResultados:");
        System.out.println("Pasajeros a CDMX: " + cdmx);
        System.out.println("Pasajeros Locales: " + local);
        System.out.println("Pasajeros a otros destinos: " + otros);
        System.out.println("Destino con más pasajeros: " + destinoMayor);
        System.out.println("Total de pasajeros registrados: " + n);
        //en cocnlusion el programa sirve para registrar pasajeros y sus destinos para organizar la información de los viajes utilice arrays y estructuras las
        //cuales son for while if para capturar la informacion la cual es del usuario.
    }
}
    
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req1.sem5.pkg2d.rcmc;

import java.util.Scanner;

/**
 *
 * @author STAR KRIS
 */
public class REQ1SEM52DRCMC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner leer = new Scanner(System.in);

        // Solicitar número de pasajeros
        System.out.print("Ingrese el número de pasajeros: ");
        int numPasajeros = leer.nextInt();
        leer.nextLine(); // limpiar buffer

        //cvrear los arrays para los pasajeros 
        String[] nombres = new String[numPasajeros];
        String[] destinos = new String[numPasajeros];

        // empezar a pedir los datos
        for (int i = 0; i < numPasajeros; i++) {
            String nombre = "";
            while (nombre.isEmpty()) {
                System.out.print("Ingrese el nombre del pasajero " + (i + 1) + ": ");
                nombre = leer.nextLine();
                if (nombre.isEmpty()) {
                    System.out.println("Error: el nombre no puede estar vacío.");
                }
            }
            nombres[i] = nombre;

            System.out.print("Ingrese el destino del pasajero " + (i + 1) + ": ");
            destinos[i] = leer.nextLine();
        }

        //  mostrar lista completa con for-each
        System.out.println("\nLista de pasajeros:");
        for (String nombre : nombres) {
            System.out.println("Pasajero: " + nombre);
        }

        // Contar pasajeros por destino para hacer contador
        int cdmxCount = 0;
        int localCount = 0;

        System.out.println("\nDestinos:");
        for (String destino : destinos) {
            System.out.println("Destino: " + destino);
            if (destino.equalsIgnoreCase("CDMX")) {
                System.out.println("→ Viaje largo");
                cdmxCount++;
            } else if (destino.equalsIgnoreCase("Local")) {
                System.out.println("→ Viaje corto");
                localCount++;
            }
        }

        //ver cual es el destino
        String destinoMayor;
        if (cdmxCount > localCount) {
            destinoMayor = "CDMX";
        } else if (localCount > cdmxCount) {
            destinoMayor = "Local";
        } else {
            destinoMayor = "Empate";
        }

        // Resultados finales
        System.out.println("\nResumen:");
        System.out.println("Destino con más pasajeros: " + destinoMayor);
        System.out.println("Total de pasajeros registrados: " + numPasajeros);

        leer.close();
    }
}

      
       
    

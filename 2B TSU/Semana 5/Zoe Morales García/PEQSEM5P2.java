/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.peqsem5p2;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class PEQSEM5P2 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese número de pasajeros: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] nombres = new String[n];
        String[] destinos = new String[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nPasajero " + (i + 1));
            System.out.print("Nombre: ");
            nombres[i] = sc.nextLine();
            while (nombres[i].isEmpty()) {
                if (nombres[i].isEmpty()) {
                    System.out.print("Error: el nombre no puede estar vacío. Ingrese nuevamente: ");
                    nombres[i] = sc.nextLine();
                }
            }
            System.out.print("Destino: ");
            destinos[i] = sc.nextLine();
        }

        int cdmx = 0;
        int local = 0;
        System.out.println("\n--- Lista de Pasajeros ---");

        int i = 0;
        for (String nombre : nombres) {
            String destino = destinos[i];
            System.out.println(nombre + " -> " + destino);
            if (destino.equalsIgnoreCase("CDMX")) {
                System.out.println("Viaje largo");
                cdmx++;
            }
            if (destino.equalsIgnoreCase("Local")) {
                System.out.println("Viaje corto");
                local++;
            }
            i++;
        }

        String destinoMayor = "CDMX";
        if (local > cdmx) {
            destinoMayor = "Local";
        }

        System.out.println("Pasajeros a CDMX: " + cdmx);
        System.out.println("Pasajeros Locales: " + local);
        System.out.println("Destino con más pasajeros: " + destinoMayor);
        System.out.println("Total de pasajeros registrados: " + n);
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg2.sem5.pkg2d.rdmf;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class REQ2SEM52DRDMF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        
        System.out.print("¿Cuántos pasajeros registrarás?: ");
        int n = sc.nextInt();
        
        String[] nombres = new String[n];
        String[] destinos = new String[n];
        
        for (int i = 0; i < n; i++) {
            sc.nextLine(); // Limpiar buffer
            
            // Validación de nombre
            String nombre;
            while (true) {
                System.out.print("Nombre del pasajero " + (i+1) + ": ");
                nombre = sc.nextLine();
                if (nombre.isEmpty()) {
                    System.out.println("Error: El nombre no puede estar vacío.");
                } else {
                    nombres[i] = nombre;
                    break;
                }
            }
            
            System.out.print("Destino: ");
            destinos[i] = sc.nextLine();
        }
        
        // Procesamiento
        int contCDMX = 0, contLocal = 0;
        System.out.println("\n--- Lista de Pasajeros ---");
        int i = 0;
        for (String nombre : nombres) {
            System.out.println(nombre + " -> " + destinos[i]);
            
            if (destinos[i].equalsIgnoreCase("CDMX")) {
                System.out.println("   (Viaje largo)");
                contCDMX++;
            } else if (destinos[i].equalsIgnoreCase("Local")) {
                System.out.println("   (Viaje corto)");
                contLocal++;
            }
            i++;
        }
        
        System.out.println("\nResumen:");
        System.out.println("Van a CDMX: " + contCDMX);
        System.out.println("Van a Local: " + contLocal);
        System.out.println("Total de pasajeros: " + n);
    }
}

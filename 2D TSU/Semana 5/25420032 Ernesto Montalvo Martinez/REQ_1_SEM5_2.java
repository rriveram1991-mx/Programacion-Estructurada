/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana5;

import java.util.Scanner;

/**
 *
 * @author Ernesto Montalvo
 */
public class REQ_1_SEM5_2 {
    
 public static void main(String[] args){

        Scanner leer = new Scanner(System.in);

        System.out.print("Número de pasajeros: ");
        int n = leer.nextInt();
        leer.nextLine();

        String[] nombres = new String[n];
        String[] destinos = new String[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nPasajero #" + (i + 1));

            System.out.print("Nombre: ");
            nombres[i] = leer.nextLine();

            while (nombres[i].equals("")) {
                if (nombres[i].equals("")) {
                    System.out.print("Error: el nombre no puede estar vacío. Intente nuevamente: ");
                    nombres[i] = leer.nextLine();
                }
            }

            System.out.print("Destino: ");
            destinos[i] = leer.nextLine();
        }

        int cdmx = 0;
        int local = 0;

        System.out.println("\nLista de pasajeros:");

        int i = 0;
        for (String nombre : nombres) {

            String destino = destinos[i];

            System.out.println("Nombre: " + nombre + " | Destino: " + destino);

            if (destino.equals("CDMX")) {
                System.out.println("Viaje largo");
                cdmx++;
            }

            if (destino.equals("Local")) {
                System.out.println("Viaje corto");
                local++;
            }

            i++;
        }

        String destinoMayor;

        if (cdmx > local) {
            destinoMayor = "CDMX";
        } else if (local > cdmx) {
            destinoMayor = "Local";
        } else {
            destinoMayor = "Empate";
        }

        System.out.println("\nResultados:");
        System.out.println("Pasajeros a CDMX: " + cdmx);
        System.out.println("Pasajeros Locales: " + local);
        System.out.println("Destino con más pasajeros: " + destinoMayor);
        System.out.println("Total de pasajeros registrados: " + nombres.length);

        leer.close();
    }
}
   

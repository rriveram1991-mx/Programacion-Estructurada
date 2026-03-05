/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pasajeros;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Pasajeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner (System.in);
   
        System.out.println("Ingresa el numero de pasajeros:");
         int pasajeros = sc.nextInt();
        
        String[] nombre = new String[pasajeros];
        String[] destino = new String[pasajeros];
        for (int i = 0 ; i < pasajeros ; i++){
            System.out.println("Nombre de pasajero" + (i + 1) + ":");
            nombre[i] = sc.nextLine();
            sc.nextLine();
            System.out.println("Ingrese el destino : ");
            destino[i] = sc.nextLine();
            
        while (nombre[i].trim().isEmpty()){
            if (nombre[i].trim().isEmpty()){
                System.out.println("El nombre no puedeestar vacio, ingrese de nuevo");
                }
            nombre[i]= sc.nextLine();
        }
     sc.nextLine();
  }
        int cdmx = 0;
        int local = 0;


        // Mostrar con for-each
        for (String nombres : nombre) {
            System.out.println("Pasajero: " + nombres);
        }

        System.out.println("\nAnálisis de destinos:");

        for (String destinos : destino) {

            if (destinos.equalsIgnoreCase("CDMX")) {
                System.out.println("Viaje largo");
                cdmx++;
            } 
            else if (destinos.equalsIgnoreCase("Local")) {
                System.out.println("Viaje corto");
                local++;
            }
        }
        if (cdmx > local) {
            System.out.println("Destino con mas pasajeros: CDMX");
        } 
        else if (local > cdmx) {
            System.out.println("Destino con mas pasajeros: Local");
        } 
        System.out.println("Total de pasajeros registrados: " + nombre.length);
 }
    
}
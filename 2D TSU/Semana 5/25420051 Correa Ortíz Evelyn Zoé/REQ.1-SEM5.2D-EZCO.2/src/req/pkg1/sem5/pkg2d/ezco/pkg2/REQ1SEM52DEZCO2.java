/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg1.sem5.pkg2d.ezco.pkg2;

import java.util.Scanner;

/**
 *
 * @author Zoé
 */
public class REQ1SEM52DEZCO2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el número de pasajeros:");
        int np = leer.nextInt();
        leer.nextLine(); // limpiamos el buffer
        String[] nombres = new String[np];
        String[] destinos = new String[np];
        int cdmx = 0; //aqui empiezan los contadores de destinos
        int local = 0;
        int otros = 0;
        for(int i = 0; i < np; i++){
            System.out.println("Ingrese nombre del pasajero " + (i+1) + ":");
            nombres[i] = leer.nextLine();
            while(nombres[i].isEmpty()){//el while lo uisamos para saber si no esta en blanco el nombre
                System.out.println("Por favor ingrese un nombre válido:");
                nombres[i] = leer.nextLine();
            }
            System.out.println("Ingrese el destino del pasajero " + (i+1) + ":");
            destinos[i] = leer.nextLine();
            if(destinos[i].equalsIgnoreCase("CDMX")){
                System.out.println("Viaje largo");
                cdmx++;  }
            else if(destinos[i].equalsIgnoreCase("Local")){
                System.out.println("Viaje corto");
                local++;  }
            else{
                otros++; }
        }
        // usamos el for each para mostrar lista de pasajeros
        System.out.println("\nLista de pasajeros registrados:");
        int i = 0;
        for(String nombre : nombres){
            System.out.println("Pasajero: " + nombre + " - Destino: " + destinos[i]);
            i++;
        }
        //aqui dterminamos el destino con más pasajeros
        String destinoMayor = "Otros";
        int max = otros;
        if(cdmx > max){
            max = cdmx;
            destinoMayor = "CDMX"; }
        if(local > max){
            max = local;
            destinoMayor = "Local";
        }
        // Resultados finales
        System.out.println("\nResultados finales:");
        System.out.println("Pasajeros a CDMX: " + cdmx);
        System.out.println("Pasajeros Locales: " + local);
        System.out.println("Otros destinos: " + otros);
        System.out.println("Destino con más pasajeros: " + destinoMayor);
        System.out.println("Total de pasajeros registrados: " + np);

    }
        
    }
    


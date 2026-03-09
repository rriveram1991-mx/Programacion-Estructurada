/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.req1.sem5.d.jgrb.pasajeros;

import java.util.Scanner;

/**
 *
 * @author jessr
 */
public class REQ1SEM52DJGRBPasajeros {

    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
        System.out.print("Ingrese el número de pasajeros: ");
        int num = leer.nextInt();
        leer.nextLine();
        String [] pasajeros = new String [num];
        String [] Destino = new String [num];
        
         int cdmx = 0;
        int local = 0;
        
        // Captura de datos
        for (int i = 0; i < num; i++){
                      
            String pass = "";
            //validar nombre
            while (pass.isEmpty()){
            System.out.println("Ingrese el pasajero" + (i+1) + ":");
            pass = leer.nextLine();
            if (pass.isEmpty()){
                System.out.println("Error el nombre no existe");
            } 
            }
            pasajeros[i] = pass;
            System.out.println("Ingrese el destino (CDMX O LOCAL)");
            Destino[i] = leer.nextLine();
            //Destino 
             if(Destino[i].equalsIgnoreCase("CDMX")){
           System.out.println("VIAJE LARGO");
           cdmx++;
           }else if(Destino[i].equalsIgnoreCase("LOCAL")){
           System.out.println("VIAJE CORTO");
           local++;
       }
        }
        int i = 0;
        //lista
        for (String pass : pasajeros) {
            System.out.println("Pasajero: " + pass + " - Destino: " + Destino[i]);
            i++;
        }
        //impresion de datos y comparacion de destinos
        String DestinoMayor;
        
                if (cdmx > local) {
            DestinoMayor = "CDMX";
            
        } else if (local > cdmx) {
            DestinoMayor = "Local";
        } else{
          DestinoMayor = "Empate";
        }
         System.out.println("Total de viajes con mayor pasajeros: " + DestinoMayor);
        System.out.println("Total de pasajeros registrados: " + num);
        
    }
}

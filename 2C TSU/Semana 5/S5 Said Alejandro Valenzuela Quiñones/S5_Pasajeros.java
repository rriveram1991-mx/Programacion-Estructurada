/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s5_pasajeros;

import java.util.Scanner;

public class S5_Pasajeros {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int Cvl = 0, Cvc = 0;
       
        System.out.println("Ingresa el numero de pasajeros: ");
        int pasajeros = sc.nextInt();
        sc.nextLine();
        
        String[] nombres = new String[pasajeros];
        String[] destinos = new String[pasajeros];
        
        for(int i = 0; i < pasajeros; i++){
            System.out.println("\n===== REGISTRO DE PASAJERO " + (i + 1) + " =====");
            System.out.print("Nombre del pasajero: ");
            String nombre = sc.nextLine();
            //sc.nextLine();
            
            while(nombre.trim().isEmpty()){
                System.out.println("El nombre no puede estar vacio");
                System.out.print("Ingresa un nombre valido: ");
                nombre = sc.nextLine();
                //sc.nextLine();
            }
            
            System.out.print("Destino (CDMX | Local): ");
            String destino = sc.nextLine();
            //sc.nextLine();
            
            while(destino.trim().isEmpty()){
                System.out.println("El destino no puede estar vacio");
                System.out.print("Ingresa un destino valido (CDMX, Local): ");
                destino = sc.nextLine();
                //sc.nextLine();
            }
            
            if(destino.equals("CDMX")){
                Cvl++;
            }
            else if(destino.equals("Local")){
                Cvc++;
            }
            
            nombres[i] = nombre;
            destinos[i] = destino;
        }
        
        // Mostrar pasajeros
        System.out.println("\n===== LISTA DE PASAJEROS =====");
        for(int i = 0; i < pasajeros; i++){
            if(destinos[i].equals("CDMX")){
                System.out.println("Viaje largo" + " | Nombre: " + nombres[i] + " | Destino: " + destinos[i]);
            }
            else if(destinos[i].equals("Local")){
                System.out.println("Viaje corto" + " | Nombre: " + nombres[i] + " | Destino: " + destinos[i]);
            }
            else{
                System.out.println("Nombre: " + nombres[i] + " | Destino: " + destinos[i]);
            }
        }
        
        System.out.println("Pasajeros viaje CDMX: " + Cvl);
        System.out.println("Pasajeros viaje local: " + Cvc);
        
        if(Cvl > Cvc){
            System.out.println("Destino con mas pasajeros es CDMX");
        }
        else{
            System.out.println("Destino con mas pasajeros es Local");
        }
        
        System.out.println("Total de pasajeros registrados: " + pasajeros);
    }
    
}

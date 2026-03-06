/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pasajeros;

import java.util.Scanner;

/**
 *
 * @author aguer
 */
public class Pasajeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Scanner leer = new Scanner (System.in);
        int pasajeros;
  
        System.out.println("Ingresa el numero de pasajeros");
        pasajeros=leer.nextInt();
        leer.nextLine();
        String [] nombres= new String [pasajeros];
        String []destinos= new String [pasajeros];
        for (int i=0; i<pasajeros; i++){
            System.out.println("Ingresa el nombre del pasajero "+ (i+1) );
            nombres[i]= leer.nextLine();
                while (nombres[i].trim().isEmpty()){
                System.out.println("Error: el nombre no puede estar vacio");
                System.out.println("Intenta nuevamente");
                nombres[i]= leer.nextLine();
                
                
            }
            
            System.out.println("Ingresa el destino:  CDMX / LOCAL");
            destinos[i]= leer.nextLine();
        
 
        }
        for(int i=0; i< nombres.length; i++){
            System.out.println("----------------------REGISTRO "+ (i+1)+" -------------------------");
            System.out.println("Nombre: "+ nombres[i]+" Destino: "+ destinos[i]);
            if(destinos[i].equals("CDMX")){
                    System.out.println("Viaje largo");
            }else {
                System.out.println("Viaje corto");
            }
            
            
        }
        int j=0;
        int cdmx=0, local=0;
        while (j< destinos.length){
            if(destinos[j].equals("CDMX")){
                cdmx++;
                
            }else {
                local++;
            }
            j++;
        }
        System.out.println("----------------------DESTINO CDMX------------------------");
        System.out.println("Total de pasajeros: "+cdmx);
        System.out.println("----------------------DESTINO LOCAL------------------------");
        System.out.println("Total de pasajeros: " +local);
        if(cdmx>local){
            System.out.println("CDMX es el destino con mas pasajeros");
        }else if(cdmx==local){
              System.out.println("Los dos destinos tienen la misma cantidad de pasajeros");
        }else{
            System.out.println("Local es el destino con mas pasajeros");
        }
        
        System.out.println("Total de pasajeros registrados: "+ pasajeros);
        
        
        
        
        
        
            
        
        
    }
    
}

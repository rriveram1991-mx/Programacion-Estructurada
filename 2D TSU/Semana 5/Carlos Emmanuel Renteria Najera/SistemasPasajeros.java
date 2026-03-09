/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaspasajeros;

import java.util.Scanner;

/**
 *
 * @author Memer
 */
public class SistemasPasajeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lr = new Scanner(System.in);
        
        
        //pido de cuanto va ser mi array
        System.out.println("numero de pasajeros");
        int psj = lr.nextInt();
        
        //declaro mis varaibles
        int viajecorto = 0;
        int viajelargo = 0;
        String nombres[] = new String [psj];
        String destinos[] = new String [psj];
        
        
        //pido nombre y destino
        for (int i = 0; i < nombres.length; i++) {
            lr.nextLine();
            System.out.println("nombre del pasajero " +  (1+i) + ": ");
            nombres[i] = lr.nextLine();
            
            
            //valido si mi nombre esta vacio
            while (nombres[i].isBlank()) { 
                System.out.println("nombre en blanco, vuelve a ponerlo");
                nombres[i] = lr.nextLine();
            }
          
            
            System.out.println("a donde vas a ir?");
            destinos[i] = lr.nextLine().toLowerCase();
            
           
        }
        
        //for each para los nombres
        for (String mostrar : nombres) {
            System.out.println(mostrar);
        }
        
        //for each para mis contadores
        for (String j : destinos) {
            
            if (j.equals("local")) {
                viajecorto++;
            }
            else{
                viajelargo++;
            }    
        }
        
        
        //if para mostrar el destino con mas pasajeros
        
        if (viajecorto > viajelargo) {
            System.out.println("viajes corto " + viajecorto);
        }
        else{
             System.out.println("viajes largo " + viajelargo);
        }
        System.out.println("total de pasajeros " + nombres.length);
    }
    
}

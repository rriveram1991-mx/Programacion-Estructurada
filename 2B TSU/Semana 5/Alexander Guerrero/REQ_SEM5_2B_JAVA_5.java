/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req_sem5_2b_java_5;

import java.util.Scanner;

/**
 *
 * @author Lex
 */
public class REQ_SEM5_2B_JAVA_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner leer = new Scanner(System.in);
        
        System.out.println("========SISTEMA DE VIAJES========");
        System.out.println("\nCuantos pasajeros desea registrar? : ");
        int n = leer.nextInt();
        leer.nextLine();
        
        String[] nombres = new String[n];
        String[] destino = new String[n];
        
        int largo = 0;
        int corto = 0;
        
        
        for (int i = 0; i < n; i++){
            System.out.println("\n Pasajero " + (i+1) + ": ");
            System.out.println("Nombre :");
            nombres[i] = leer.next();
            while(nombres[i].isEmpty()){
                System.out.println("Porfavor reingrese un nombre: ");
                nombres[i] = leer.next();
            }  
            System.out.println("Destino (CDMX/Local) :");
            destino[i] = leer.next();
            leer.nextLine(); 
        }
        
        for (int i = 0; i < n; i++){
            if ("cdmx".equalsIgnoreCase(destino[i])){
                System.out.println("Viaje largo");
                largo++;
            } else if ("local".equalsIgnoreCase(destino[i])){
                System.out.println("Viaje corto");
                corto++;
            }
        }
        
        String favorito = "";
        if (largo > corto){
            favorito = "CDMX (viaje largo)";
        } else if (corto > largo){
            favorito = "Local (viaje corto)";
        } else {
            favorito = "AMbos destinos igualmente seleccionados";
        }
        
        System.out.println("\n========RESULTADOS DEL SISTEMA=========");
        System.out.println("Total de pasajeros registrados: " +n);
        System.out.println("Viajes a la CDMX: " +largo);
        System.out.println("VIajes Locales: " +corto);
        System.out.println("Viaje mas elegido: " +favorito);
    }
    
}
    
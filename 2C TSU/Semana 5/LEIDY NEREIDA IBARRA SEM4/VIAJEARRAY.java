/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package viajearray;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author leidy
 */
public class VIAJEARRAY {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner read=new Scanner(System.in);
        System.out.println("____________________________________________________");
        System.out.println("CUANTOS PASAJEROS VIAJARAN HOY");
        int pas = read.nextInt();
        read.nextLine();
        System.out.println("_____________________________________________________");
                int [] pasajero= new int [pas];
                String [] name=new String[pas];
                String []destino=new String[pas];

                for (int i=0;i < name.length; i++){
                    String nombre = "";
            while (nombre.isEmpty()) {
                System.out.println("Ingrese el nombre del pasajero " + (i+1) + ":");
                nombre = read.nextLine();
                if (nombre.isEmpty()) {
                    System.out.println(" Error: el nombre no puede estar vacío.");
                }
            }
            nombre=name[i];
                   System.out.println("CUAL ES EL DESTINO");
                    destino[i]=read.nextLine();}
                
             
                      
 System.out.println("/////LISTA DE PASAJEROS/////");
                int cdmx=0, local=0;
                for(String n :name){
                    System.out.println("pasajero " + name.length );
                }
                    if(destino.equals("cdmx")){
                        System.out.println("VIAJE LARGO,ASEGURESE DE LLEVAR COJIN");       
                        cdmx++;
                    }
                    else {
                        System.out.println("VIAJE CORTO, DON´T WORRIE");
                            local++;
                            }
                
                String may;
                if (cdmx>local){
                      may="cdmx";
                }
                else{
                 may="local";
                }
                System.out.println("EL TOTAL DE PASAJEROS QUE VIAJAN A CDMX : " + cdmx);
                System.out.println("EL RESTO QUE FUE VIIJE LOCAL : " + local);
              
                System.out.println("EL DESTINO CON MAS PASAJEROS: " + may );
                System.out.println("TOTAL P: " + pas);
                
                
                
    
}
}
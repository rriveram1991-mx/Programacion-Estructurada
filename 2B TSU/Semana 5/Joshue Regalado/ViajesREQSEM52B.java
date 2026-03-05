/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package viajes.req.sem5.pkg2b;

import java.util.Scanner;

/**
 *
 * @author jasun
 */
public class ViajesREQSEM52B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int numpas, cdmx, local;
        cdmx=0;
        local=0;
        
        System.out.println("Ingrese el numero de pasajeros: ");
        numpas=sc.nextInt();
        
        String [] nombres = new String [numpas];
        String [] destinos = new String [numpas];
        
        for (int i = 0; i<nombres.length; i++) {
            System.out.println("\nIngrese el nombre del pasajero "+(i+1));
            nombres[i]=sc.next();
            while (nombres[i].isEmpty()){
                if (nombres[i].isEmpty()) {
                    System.out.println("Error al ingresar el nombre, ingreselo de nuevo");
                    nombres[i]=sc.next();
                }
            }
            
            System.out.println("Ingrese el destino al que viajara: CDMX o Local ");
            destinos[i]=sc.next();
            
            if (destinos[i].equalsIgnoreCase("cdmx")) {
                System.out.println("Viaje largo");
                cdmx++;
            } else if (destinos[i].equalsIgnoreCase("local")) {
                System.out.println("Viaje corto");
                local++;
            } else {
                System.out.println("Destino incorrecto");
            }
        }
            //Lista de pasajeros
            System.out.println("\nLista de pasajeros");
            for (String nombre:nombres) {
                System.out.println(nombre);
            }
            //DESTINOS
            System.out.println("\nPasajeros con destino a CDMX: "+cdmx);
            System.out.println("Pasajeros con destino local: "+local);
            
            //Mas pasajeros
            if (cdmx>local) {
                System.out.println("Destino con mas pasajeros: CDMX");
            } else if (local>cdmx) {
                System.out.println("Destino con mas pasajeros: Local");
            } else {
                System.out.println("Ambos tienen los mismos pasajeros");
            }
            System.out.println("\nTotal de pasajeros: "+numpas);
    }
}

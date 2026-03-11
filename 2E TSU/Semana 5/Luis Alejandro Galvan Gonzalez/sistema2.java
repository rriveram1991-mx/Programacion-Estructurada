package cuatri2.unidad3;

import java.util.Scanner;

public class sistema2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pasajeros;

        System.out.println("Ingresa el nuemro de pasajeros:");
        pasajeros = sc.nextInt();

        String[] nombres = new String[pasajeros];
        String[] destinos = new String[pasajeros];
        
        for(int i = 0; i < pasajeros; i++){
            System.out.println("Escribe el nombre del pasajero:");
            nombres[i] = sc.next().trim();
            while(nombres[i].isEmpty()){
                System.out.println("El nombre no puede estar vacio");
                System.out.println("Escribe un nombre");
                nombres[i] = sc.next().trim();
            } 
            System.out.println("Escribe el nombre del destino");
            System.out.println("CDMX\nLocal");
            destinos[i] = sc.next();

        }
        System.out.println("Lista de pasajeros");
        int y = 0;
        int largo = 0, corto = 0;
        for(String list : nombres){
            System.out.println(nombres[y]);
            if (destinos[y].equals("CDMX")) {
                System.out.println("Viaje largo");
                largo++;
            } else if (destinos[y].equals("Local")) {
                System.out.println("Viaje corto");
                corto++;
            }
            y++;
        }
        if (largo == corto) {
            System.out.println("Los dos tienen la misma cantidad de pasajeros");
        }
        else if (largo > corto) {
            System.out.println("CDMX tiene mas pasajeros");            
        } else {
            System.out.println("Local tiene mas pasajeros");
        }
        System.out.println("Pasajeros registrados: "+pasajeros);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosingricardo47;

import java.util.Scanner;

/**
 *
 * @author yahir
 */
public class EjerciciosIngRicardo47 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        int pasajeros;
        int ct1= 0;
        int ct2= 0;
        int ct3= 0;
        System.out.println("¿Cuántos pasajeros hay?");
        pasajeros=leer.nextInt();
        leer.nextLine();
        String[] nombres = new String[pasajeros];
        String[] destinos = new String[pasajeros];
         
        for(int i = 0; i < pasajeros; i++) {
            System.out.println("Ingrese el nombre del pasajero:");
            nombres[i]=leer.nextLine();
            System.out.println("Ingrese el destino del pasajero:");
            destinos[i]=leer.nextLine();
            
            ct2++;
            while (nombres[i].isEmpty() ) {
                System.out.println("El nombre está vacío!");
                System.out.println("Intenta de nuevo");
                nombres[i]=leer.nextLine();
            }
            switch (destinos[i]) {
                
                    case "CDMX":
                        ct1++;
                        break;
                    case "Local":
                        ct3++;
                        break;
                        }
            if (destinos[i].equals("CDMX")) {
                System.out.println("Viaje largo");
                }else  {
                System.out.println("Viaje Local");
            }
        }
            System.out.println("Lista de pasajeros:");
            for (String n: nombres) {
                System.out.println(n);
                }
            if (ct1 > ct3) {
                System.out.println("El lugar más visitado fue CDMX");
                }else {
                        System.out.println("El lugar más visitado fue uno local");
            }
                System.out.println("Total de pasajeros registrados:"+ct2);  
        }
            
        }

        
    
    


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica3;

import java.util.Scanner;


public class Practica3 {

  
    public static void main(String[] args) {
    Scanner minimi = new Scanner(System.in);
    int F,I,X=0,P=0,DL=0,DC=0;
        System.out.println("Cuantos pasajeros son?");
        F = minimi.nextInt();
    String [] DES = new String[F];
    String [] NOM = new String[F];
        System.out.println("RECUERDE QUE SU DESTINO SOLO PUEDE SER LOCAL O CDMX.");
    for (I=0;I<F;I++){
        X++;
        System.out.println("Ingrese nombre del pasajero "+X+":");
        NOM[I] = minimi.next();
        System.out.println("Ingrese destino del pasajero "+X+":");
        DES[I] = minimi.next();
        switch (DES[I]) {
            case "Local":
                System.out.println("Viaje corto.");
                DL++;
                break;
            case "CDMX":
                System.out.println("Viaje largo.");
                DC++;
                break;
            default:
                P=1;
                while (P==1){
                    System.out.println("Viaje invalido. Ingrese destino valido.");
                    DES[I] = minimi.next();
            switch (DES[I]) {
                case "Local" -> {
                    System.out.println("Viaje corto.");
                    DL++;
                    P=0;
                }
                case "CDMX" -> {
                    DC++;
                    System.out.println("Viaje largo.");
                    P=0;
                }
                default -> P=1;
            }
                }
                break;
        }
       
    }
     if (DL>DC){
            System.out.println("El destino con mas pasajeros es el destino corto.");
        }else if(DC>DL){
             System.out.println("El destino con mas pasajeros es el destino largo.");
        }else{
            System.out.println("Los dos destinos tienen la misma cantidad de pasajeros.");
        }
        System.out.println("Personas con destino corto: "+DC);
        System.out.println("Personas con destino largo: "+DL);
}
}

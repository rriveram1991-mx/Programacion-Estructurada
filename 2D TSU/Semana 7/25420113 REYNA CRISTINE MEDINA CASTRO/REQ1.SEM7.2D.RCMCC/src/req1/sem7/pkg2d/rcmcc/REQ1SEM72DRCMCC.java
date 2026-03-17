/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req1.sem7.pkg2d.rcmcc;

import java.util.Scanner;

/**
 *
 * @author STAR KRIS
 */
public class REQ1SEM72DRCMCC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
       String esp[]= new String[10];
        for (int i = 0; i < esp.length; i++) {
            esp[i] = "ESPACIO LIBRE, PUEDE USARLO";
            
        }
        int opc=0;
        while (opc != 5) {
        System.out.println("=======ESTACIONAMIENTO=======");
        System.out.println("======MENU DE OPCIONES=======");
        System.out.println("1.Ver el estacionamiento.....");
        System.out.println("2.Estacionar auto............");
        System.out.println("3.Liberar espacio............");
        System.out.println("4.Contrar espacios ocupados..");
        System.out.println("5.Salir del sistema..........");
        opc=leer.nextInt();
        
        switch (opc){
        case 1 -> {
            System.out.println("Espacios");
            for (int i = 0; i < esp.length; i++) {
                System.out.println("Espacio " + (i + 1) + ": " + esp[i]);
                break;
            }
               }
                        case 2 -> {
                        System.out.println("Escoja lugar en el estacionamiento del 1-10");
                        int lugar;
                        lugar=leer.nextInt()-1;
                        if (lugar >=0 && lugar<10 ){
                             if (esp[lugar].equals("LUGAR LIBRE")) {
                            esp[lugar] = "LUGAR EN USO";
                            System.out.println("AUTO ESTACIONADO CORRECTAMENTE");
                        } else {
                            System.out.println("ERROR: El espacio ya está OCUPADO.");
                        }
                    } else {
                        System.out.println("No existe ese lugar.");
                    }
                        }
                        case 3 -> {
                            System.out.print("ESpacio a retirar: ");
                    int eSalida = leer.nextInt() - 1;

                    if (eSalida >= 0 && eSalida < 10) {
                        if (esp[eSalida].equals("OCUPADO")) {
                            esp[eSalida] = "LIBRE";
                            System.out.println("¡Espacio liberado!");
                        } else {
                            System.out.println(" El espacio ya estaba LIBRE.");
                        }
                    } else {
                        System.out.println("Espacio no reconocdido.");}
                        }

                case 4 -> {
                                    int contador =0 ;
                    for (String estado : esp) {
                        if (estado.equals("OCUPADO")) {
                            contador++;
                        }
                    }
                    System.out.println("autos estacionados: " + contador);
               }
                case 5 -> {
                                 System.out.println("gracias x su preferencia");
        }
        default -> System.out.println("error");    
        }
        }
    }
}        
    
    


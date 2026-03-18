/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estacionamiento;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author emili
 */
public class Estacionamiento {

    
    public static void main(String[] args) {
   Scanner buf = new Scanner (System.in);      
   int tip;
   String[] espacios = new String[10];
        for (int i = 0; i < espacios.length; i++) {
            espacios[i] = "LIBRE";
        }
        boolean salir = false;
        int contador=0;
        while (!salir) {
        System.out.println("---MENÚ---");
        System.out.println("1. Ver estacionamiento");
        System.out.println("2. Estacionar auto");
        System.out.println("3. Retirar auto");
        System.out.println("4. Contar espacios ocupados");
        System.out.println("5. Salir");
        tip=buf.nextInt();
        switch (tip){
            case 1: 
                System.out.println("Estado actual:");
                    for (int i = 0; i < espacios.length; i++) {
                        System.out.println("Espacio " + (i + 1) + ": " + espacios[i]);
                    }
                    break;
            case 2:
                System.out.print("Ingrese el número de espacio (1-10): ");
                    int ent = buf.nextInt()-1;

                    if (ent >= 0 && ent < 10) {
                        if (espacios[ent].equals("LIBRE")) {
                            espacios[ent] = "OCUPADO";
                            System.out.println("Auto estacionado");
                        } else {
                            System.out.println("El espacio ya está ocupado.");
                        }
                    } else {
                        System.out.println("Número de espacio inválido.");
                    }
                    break;
            case 3:
                System.out.print("Ingrese el número de espacio a liberar (1-10): ");
                    int sal = buf.nextInt() - 1;

                    if (sal >= 0 && sal < 10) {
                        if (espacios[sal].equals("OCUPADO")) {
                            espacios[sal] = "LIBRE";
                            System.out.println("Espacio liberado.");
                        } else {
                            System.out.println("El espacio ya estaba libre.");
                        }
                    } else {
                        System.out.println("Número de espacio inválido.");
                    }
                    break;
            case 4:
                contador = 0;
                    for (String estado : espacios) {
                        if (estado.equals("OCUPADO")) {
                            contador++;
                        }
                    }
                    System.out.println("Total de espacios ocupados: " + contador);
                    break;
            case 5:
                salir = true;
                    System.out.println("Saliendo del sistema");
                    System.out.println("Archivo creado");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
        
        }
        try{
            FileWriter writer = new FileWriter("reportee_estacionamiento.txt");
             writer.write("Espacios ocupados: " + contador + "\n");
    for (int i = 0; i < espacios.length; i++) {
        writer.write("Espacio " + (i + 1) + ": " + espacios[i] + "\n");
    }
              writer.close();
            
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();  
        }
        }
    }
}
    


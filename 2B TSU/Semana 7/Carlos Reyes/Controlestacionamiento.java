/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlestacionamiento;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

/**
 *
 * @author juanc
 */
public class Controlestacionamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     String [] estacionamiento = new String [10];
     int opcion=0;
    
     for (int i = 0; i < estacionamiento.length; i++){
         estacionamiento [i] = "LIBRE";
     }
     
     while (opcion !=5){
         System.out.println("\n--- MENU ---");
         System.out.println("1. Ver estacionamiento");
         System.out.println("2. Estacionarse");
         System.out.println("3. Retirar auto");
         System.out.println("4. Contar ocupados");
         System.out.println("5. Salir");
         
         opcion = sc.nextInt();
         
         switch (opcion){
             case 1:
    for (int i = 0; i < estacionamiento.length; i++) {
        System.out.println("Espacio " + (i + 1) + ": " + estacionamiento[i]);
    }
    break;
    
    case 2:
    System.out.print("Ingresa número de espacio (1-10): ");
    int espacio = sc.nextInt() - 1;

    if (estacionamiento[espacio].equals("LIBRE")) {
        estacionamiento[espacio] = "OCUPADO";
        System.out.println("Auto estacionado");
    } else {
        System.out.println("Ese espacio ya está ocupado");
    }
    break;
    
    case 3:
    System.out.print("Ingresa número de espacio (1-10): ");
    int retirar = sc.nextInt() - 1;

    if (estacionamiento[retirar].equals("OCUPADO")) {
        estacionamiento[retirar] = "LIBRE";
        System.out.println("Auto retirado");
    } else {
        System.out.println("Ese espacio ya está libre");
    }
    break;
    
    case 4:
    int contador = 0;

    for (String espacioEstado : estacionamiento) {
        if (espacioEstado.equals("OCUPADO")) {
            contador++;
        }
    }

    System.out.println("Espacios ocupados: " + contador);
    break;
    
    case 5:
    System.out.println("Saliendo...");
    break;
    
    default:
    System.out.println("Opción inválida");
         }
     }
     
     try {
    FileWriter writer = new FileWriter("estacionamiento.txt");

    for (int i = 0; i < estacionamiento.length; i++) {
        writer.write("Espacio " + (i + 1) + ": " + estacionamiento[i] + "\n");
    }

    writer.close();
    System.out.println("Datos guardados en TXT");
} catch (IOException e) {
    System.out.println("Error al guardar archivo");
}
     
     
    }
    
}

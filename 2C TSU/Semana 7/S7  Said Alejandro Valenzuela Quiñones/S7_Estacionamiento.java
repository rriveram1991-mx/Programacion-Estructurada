/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s7_estacionamiento;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class S7_Estacionamiento {

    public static void main(String[] args) {
        // Variables y Scanner
        Scanner sc = new Scanner(System.in);
        int espacios[][] = new int[2][5];
        boolean salir = false;
        
        // While y Switch
        System.out.println("##### SISTEMA DE CONTROL DE ESTACIONAMIENTO #####");
        while(salir == false){
            System.out.println("\n1) Ver estacionamiento.");
            System.out.println("2) Estacionar auto.");
            System.out.println("3) Retirar auto.");
            System.out.println("4) Contar espacios ocupados.");
            System.out.println("5) Guardar estado del estacionamiento.");
            System.out.println("6) Salir");
            
            System.out.println("\nSelecciona una opcion:");
            int opcion = sc.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("\n===== VER ESTACIONAMIENTO =====");
                    System.out.print("  ");
                    for(int j = 0; j < 5; j++){
                        System.out.print(j + " ");
                    }
                    System.out.println();
                    
                    for(int i = 0; i < 2; i++){
                        System.out.print(i + " ");
                        for(int j = 0; j < 5; j++){
                            System.out.print(espacios[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;
                    
                case 2:
                    System.out.println("\n===== ESTACIONAR AUTO =====");
                    System.out.println("\n0 Disponible | 1 Ocupado");
                    
                    System.out.print("\n  ");
                    for(int j = 0; j < 5; j++){
                        System.out.print(j + " ");
                    }
                    System.out.println();
                    
                    for(int i = 0; i < 2; i++){
                        System.out.print(i + " ");
                        for(int j = 0; j < 5; j++){
                            System.out.print(espacios[i][j] + " ");
                        }
                        System.out.println();
                    }
                    
                    //
                    System.out.print("\nIngresa la fila (0-2): ");
                    int fila = sc.nextInt();
                    
                    System.out.print("Ingresa la columna (0-4): ");
                    int columna = sc.nextInt();
                    
                    if(fila >= 0 && fila < 2 && columna >= 0 && columna < 5){
                        if(espacios[fila][columna] == 0){
                            espacios[fila][columna] = 1;
                            System.out.println("\nLugar de estacionamiento reservado correctamente.");
                        }
                        else{
                            System.out.println("\nLugar de estacionamiento ocipado, ingresa otro.");
                        }
                    }
                    
                    else{
                        System.out.println("\nLugar de estacionamiento fuera de rango.");
                    }
            
                    break;
                    
                case 3:
                    System.out.println("\n===== RETIRAR AUTO =====");
                    System.out.println("\n0 Disponible | 1 Ocupado");
                    
                    System.out.print("\n  ");
                    for(int j = 0; j < 5; j++){
                        System.out.print(j + " ");
                    }
                    System.out.println();
                    
                    for(int i = 0; i < 2; i++){
                        System.out.print(i + " ");
                        for(int j = 0; j < 5; j++){
                            System.out.print(espacios[i][j] + " ");
                        }
                        System.out.println();
                    }
                    
                    //
                    System.out.print("\nIngresa la fila (0-2): ");
                    fila = sc.nextInt();
                    
                    System.out.print("Ingresa la columna (0-4): ");
                    columna = sc.nextInt();
                    
                    if(fila >= 0 && fila < 2 && columna >= 0 && columna < 5){
                        if(espacios[fila][columna] == 1){
                            espacios[fila][columna] = 0;
                            System.out.println("\nCarro retirado correctamente.");
                        }
                        else{
                            System.out.println("\nNo hay ningun carro estacionado.");
                        }
                    }
                    
                    else{
                        System.out.println("\nLugar de estacionamiento fuera de rango.");
                    }
                    break;
                    
                case 4:
                    System.out.println("\n===== CONTAR ESPACIOS OCUPADOS =====");
                    int contador1 = 0;
                    for(int[] f : espacios){
                        for(int estado : f){
                            if(estado == 1){
                                contador1++;
                            }
                        }
                    }

                    System.out.println("Espacios ocupados: " + contador1);
                    break;
                    
                case 5:
                    System.out.println("\n===== GUARDAR ESTADO DEL ESTACIONAMIENTO =====");

                    try{
                        FileWriter myWriter = new FileWriter("estacionamiento.txt");

                        contador1 = 0;

                        myWriter.write("ESTADO DEL ESTACIONAMIENTO\n\n");

                        for(int i = 0; i < espacios.length; i++){
                            myWriter.write("Fila " + i + ": "); // 👈 tip extra

                            for(int j = 0; j < espacios[i].length; j++){
                                myWriter.write(espacios[i][j] + " ");

                                if(espacios[i][j] == 1){
                                    contador1++;
                                }
                            }
                            myWriter.write("\n");
                        }

                        myWriter.write("\nEspacios ocupados: " + contador1);

                        myWriter.close();
                        System.out.println("Archivo guardado correctamente");

                    } catch(IOException e){
                        System.out.println("Ocurrió un error");
                        e.printStackTrace();
                    }

                    break;
                    
                case 6:
                    salir = true;
                    System.out.println("\nSaliendo del sistema....");
                    break;
                    
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }
    
}
    
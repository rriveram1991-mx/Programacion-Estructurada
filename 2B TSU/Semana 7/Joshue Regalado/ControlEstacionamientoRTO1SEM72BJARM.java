/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlestacionamiento.rto.pkg1.sem7.pkg2b.jarm;

import java.util.Scanner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author jasun
 */
public class ControlEstacionamientoRTO1SEM72BJARM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
       int [][] estacionamientos = new int [10][10];
       int opcion, fila, f, columna;
       int ocupados = 0;
       opcion=0;
        while (opcion != 5) {
        System.out.println("\nMENU ESTACIONAMIENTO");
        System.out.println("1.Ver estacionamiento");
        System.out.println("2.Estacionar auto");
        System.out.println("3.Retirar auto");
        System.out.println("4.Contar espacios ocupados");
        System.out.println("5.Salir");
        System.out.println("\nQue quiere realizar?");
        opcion=sc.nextInt();
        
           switch (opcion) {
               case 1:
                   f=1;
                   for (int i=0;i<estacionamientos.length;i++) {
                       System.out.println("Fila "+(f++)+" ");
                       for (int j=0;j<estacionamientos[i].length;j++) {
                           System.out.print("["+estacionamientos[i][j]+"]"+" ");
                       }
                       System.out.println();
                       }
                   System.out.println("0= Lugar libre");
                   System.out.println("1= Lugar ocupado");
                   break;
                   case 2:
                       System.out.println("Ingrese el numero de la fila (1-10: ");
                       fila=sc.nextInt()-1;
                       System.out.println("Ingrese en que estacionamiento desea estacionarse (1-10):");
                       columna=sc.nextInt() -1;
                       if (estacionamientos[fila][columna] == 0) {
                        estacionamientos[fila][columna] = 1;
                        System.out.println("Auto estacionado");
                        } else {
                        System.out.println("Error: el espacio ya está ocupado");
                        }
                   break;
                   case 3:
                    System.out.print("Ingrese el numero de la fila (1-10): ");
                    fila = sc.nextInt() -1;
                    System.out.print("Ingrese el numero del espacio (1-10): ");
                    columna = sc.nextInt() -1;

                    if (estacionamientos[fila][columna] == 1) {
                        estacionamientos[fila][columna] = 0;
                        System.out.println("Auto retirado");
                    } else {
                        System.out.println("Error: el espacio ya está libre");
                    }
                    break;
                   case 4:
                    ocupados=0;
                    for (int[] filaArr : estacionamientos) {
                        for (int esp : filaArr) {
                            if (esp == 1) ocupados++;
                        }
                    }
                    System.out.println("Espacios ocupados: " + ocupados);
                    break;
                   case 5:
                       System.out.println(" ");
                       break;
                   default:
                       System.out.println("Opcion invalida");
           }
       }
        System.out.println("Saliendo del sistema");
        
        try {
            File myObj = new File("Estacionamiento.txt");
            FileWriter writer = new FileWriter("Estacionamiento.txt");

            for (int i = 0; i < estacionamientos.length; i++) {

                for (int j = 0; j < estacionamientos[i].length; j++) {

                    writer.write(estacionamientos[i][j] + " ");
                }
                writer.write("\n");
            }

            writer.write("Lugares ocupados: " + ocupados + "\n");

            writer.close();

        } catch (IOException e) {

            System.out.println("Error");
            e.printStackTrace();
        }
        System.out.println("Archivo creado");

    }
    }

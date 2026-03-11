/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s6_asientoscine;

import java.util.Scanner;

public class S6_AsientosCine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matriz[][] = new int[7][7];

        int fila, columna;
        int opcion;

        while(true){

            System.out.println("Ingresa 1 para reservar asiento o 2 para terminar:");
            opcion = sc.nextInt();

            if(opcion == 2){
                System.out.println("Programa finalizado");
                break;
            }

            while(true){

                System.out.println("\n===== ASIENTOS CINE =====");
                System.out.println("0 Disponible | 1 Ocupado");

                System.out.print("   ");
                for(int j = 0; j < 7; j++){
                    System.out.print(j + " ");
                }
                System.out.println();

                for(int i = 0; i < 7; i++){
                    System.out.print(i + "  ");
                    for(int j = 0; j < 7; j++){
                        System.out.print(matriz[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.print("\nIngresa la fila (0-6): ");
                fila = sc.nextInt();

                System.out.print("Ingresa la columna (0-6): ");
                columna = sc.nextInt();

                if(fila >= 0 && fila < 7 && columna >= 0 && columna < 7){

                    if(matriz[fila][columna] == 0){
                        matriz[fila][columna] = 1;
                        System.out.println("Asiento reservado correctamente");
                        break;
                    }else{
                        System.out.println("Asiento ocupado, ingresa otro");
                    }

                }else{
                    System.out.println("Asiento fuera de rango");
                }
            }

            System.out.println("\nAsientos actualizados:");

            System.out.print("   ");
            for(int j = 0; j < 7; j++){
                System.out.print(j + " ");
            }
            System.out.println();

            for(int i = 0; i < 7; i++){
                System.out.print(i + "  ");
                for(int j = 0; j < 7; j++){
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
        }
    } 
}

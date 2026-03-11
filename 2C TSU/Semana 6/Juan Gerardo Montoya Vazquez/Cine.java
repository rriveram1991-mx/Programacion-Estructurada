/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cine;

import java.util.Scanner;

/**
 *
 * @author juang
 */
public class Cine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        int filas = 5;
        int columnas = 6;

        int[][] asientos = new int[filas][columnas];

        int fila, asiento;
        int opcion;

        do {

            System.out.println("\n--- CINE ---");
            System.out.println("1. Mostrar asientos");
            System.out.println("2. Reservar asiento");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch(opcion){

                case 1:

                    System.out.println("\nEstado de los asientos:");
                    for(int i=0;i<filas;i++){
                        for(int j=0;j<columnas;j++){
                            System.out.print(asientos[i][j] + " ");
                        }
                        System.out.println();
                    }

                break;

                case 2:

                    System.out.print("Ingrese fila (0-4): ");
                    fila = sc.nextInt();

                    System.out.print("Ingrese asiento (0-5): ");
                    asiento = sc.nextInt();

                    if(asientos[fila][asiento]==0){
                        asientos[fila][asiento]=1;
                        System.out.println("Asiento reservado.");
                    }else{
                        System.out.println("Asiento ocupado.");
                    }

                break;

            }

        }while(opcion!=3);

    }

}
    
    


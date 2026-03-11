/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estacionamiento;

import java.util.Scanner;

/**
 *
 * @author juang
 */
public class Estacionamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner sc = new Scanner(System.in);

        int filas = 4;
        int columnas = 5;

        int[][] lugares = new int[filas][columnas];

        int opcion, fila, lugar;

        do {

            System.out.println("\n--- ESTACIONAMIENTO ---");
            System.out.println("1. Mostrar lugares");
            System.out.println("2. Estacionar auto");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch(opcion){

                case 1:

                    System.out.println("\nEstado del estacionamiento:");
                    for(int i=0;i<filas;i++){
                        for(int j=0;j<columnas;j++){
                            System.out.print(lugares[i][j] + " ");
                        }
                        System.out.println();
                    }

                break;

                case 2:

                    System.out.print("Ingrese fila (0-3): ");
                    fila = sc.nextInt();

                    System.out.print("Ingrese lugar (0-4): ");
                    lugar = sc.nextInt();

                    if(lugares[fila][lugar]==0){
                        lugares[fila][lugar]=1;
                        System.out.println("Auto estacionado.");
                    }else{
                        System.out.println("Lugar ocupado.");
                    }

                break;

            }

        }while(opcion!=3);

    
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estacionamiento;

import java.util.Scanner;

/**
 *
 * @author aguer
 */
public class Estacionamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   Scanner leer = new Scanner(System.in);

        int[][] parking = new int[5][5];
        int fila, columna, opcion;

        while(true){

            System.out.println("===== ESTACIONAMIENTO =====");
            System.out.println("1. Estacionar auto");
            System.out.println("2. Retirar auto");
            System.out.println("3. Ver estacionamiento");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");

            opcion = leer.nextInt();

            if(opcion == 4){
                System.out.println("Programa finalizado");
                break;
            }

            switch(opcion){

                case 1:

                    System.out.print("Ingresa fila (0-4): ");
                    fila = leer.nextInt();

                    System.out.print("Ingresa columna (0-4): ");
                    columna = leer.nextInt();

                    if(fila>=0 && fila<5 && columna>=0 && columna<5){

                        if(parking[fila][columna]==0){
                            parking[fila][columna]=1;
                            System.out.println("Auto estacionado correctamente");
                        }else{
                            System.out.println("Lugar ocupado");
                        }

                    }else{
                        System.out.println("Lugar fuera de rango");
                    }

                break;

                case 2:

                    System.out.print("Ingresa fila del auto: ");
                    fila = leer.nextInt();

                    System.out.print("Ingresa columna del auto: ");
                    columna = leer.nextInt();

                    if(fila>=0 && fila<5 && columna>=0 && columna<5){

                        if(parking[fila][columna]==1){
                            parking[fila][columna]=0;
                            System.out.println("Auto retirado correctamente");
                        }else{
                            System.out.println("Ese lugar ya esta libre");
                        }

                    }else{
                        System.out.println("Lugar fuera de rango");
                    }

                break;

                case 3:

                    System.out.println("0 = Libre | 1 = Ocupado");

                    System.out.print("  ");
                    for(int j=0;j<5;j++){
                        System.out.print(j+" ");
                    }
                    System.out.println();

                    for(int i=0;i<5;i++){

                        System.out.print(i+" ");

                        for(int j=0;j<5;j++){
                            System.out.print(parking[i][j]+" ");
                        }

                        System.out.println();
                    }

                break;

                default:
                    System.out.println("Opcion invalida");
            }
        }
  
    }
    
}

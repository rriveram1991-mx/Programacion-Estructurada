/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cine;

import java.util.Scanner;

/**
 *
 * @author aguer
 */
public class Cine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
        Scanner leer = new Scanner(System.in);

        int[][] asientos = new int[7][7];
        int fila, columna, opcion, disponibles = 49;
        

        while(true){

            System.out.println("===== CINE =====");
            System.out.println("1. Reservar asiento");
            System.out.println("2. Cancelar reserva");
            System.out.println("3. Ver asientos");
            System.out.println("4. Asientos disponibles");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opcion: ");

            opcion = leer.nextInt();

            if(opcion == 5){
                System.out.println("Programa finalizado");
                break;
            }

            switch(opcion){

                case 1:

                    System.out.print("Ingresa fila (0-6): ");
                    fila = leer.nextInt();

                    System.out.print("Ingresa columna (0-6): ");
                    columna = leer.nextInt();

                    if(fila>=0 && fila<7 && columna>=0 && columna<7){

                        if(asientos[fila][columna]==0){
                            asientos[fila][columna]=1;
                            disponibles--;
                            System.out.println("Asiento reservado");
                        }else{
                            System.out.println("Asiento ocupado");
                        }

                    }else{
                        System.out.println("Fuera de rango");
                    }

                break;

                case 2:

                    System.out.print("Ingresa fila: ");
                    fila = leer.nextInt();

                    System.out.print("Ingresa columna: ");
                    columna = leer.nextInt();

                    if(fila>=0 && fila<7 && columna>=0 && columna<7){

                        if(asientos[fila][columna]==1){
                            asientos[fila][columna]=0;
                            disponibles++;
                            System.out.println("Reserva cancelada");
                        }else{
                            System.out.println("Ese asiento ya estaba libre");
                        }

                    }else{
                        System.out.println("Fuera de rango");
                    }

                break;

                case 3:

                    System.out.println("0 = Disponible | 1 = Ocupado");

                    System.out.print("   ");
                    for(int j=0;j<7;j++){
                        System.out.print(j+" ");
                    }
                    System.out.println();

                    for(int i=0;i<7;i++){

                        System.out.print(i+"  ");

                        for(int j=0;j<7;j++){
                            System.out.print(asientos[i][j]+" ");
                        }

                        System.out.println();
                    }

                break;

                case 4:

                    System.out.println("Asientos disponibles: " + disponibles);

                break;

                default:

                    System.out.println("Opcion invalida");
            }
        }
        
    }
    
}

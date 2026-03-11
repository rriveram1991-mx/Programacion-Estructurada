/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estacionamiento;

import java.util.Scanner;

public class Estacionamiento {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[][] estacionamiento = {
            {"Libre","Libre","Libre"},
            {"Libre","Libre","Libre"},
            {"Libre","Libre","Libre"}
        };

        int fila;
        int lugar;

        // VALIDACION FILA
        while(true){
            System.out.print("Fila (0-2): ");
            if(sc.hasNextInt()){
                fila = sc.nextInt();
                if(fila >=0 && fila < estacionamiento.length){
                    break;
                }else{
                    System.out.println("Fila invalida.");
                }
            }else{
                System.out.println("Debe ingresar numero.");
                sc.next();
            }
        }

        // VALIDACION LUGAR
        while(true){
            System.out.print("Lugar (0-2): ");
            if(sc.hasNextInt()){
                lugar = sc.nextInt();
                if(lugar >=0 && lugar < estacionamiento[0].length){
                    break;
                }else{
                    System.out.println("Lugar invalido.");
                }
            }else{
                System.out.println("Debe ingresar numero.");
                sc.next();
            }
        }

        estacionamiento[fila][lugar] = "Ocupado"; // Marca el lugar ocupado

        System.out.println("Estado del estacionamiento:");

        for(int i=0;i<estacionamiento.length;i++){ // Recorre filas
            for(int j=0;j<estacionamiento[i].length;j++){ // Recorre columnas
                System.out.print(estacionamiento[i][j] + " ");
            }
            System.out.println();
        }

    }
}

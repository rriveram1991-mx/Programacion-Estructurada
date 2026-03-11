/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cine;
import java.util.Scanner;

public class Cine {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Scanner para leer teclado

        String[][] cine = { // Matriz de asientos
            {"O","O","O","O"},
            {"O","O","O","O"},
            {"O","O","O","O"}
        };

        int fila; // Fila elegida
        int asiento; // Asiento elegido

        // VALIDACION DE FILA
        while(true){
            System.out.print("Fila (0-2): ");
            if(sc.hasNextInt()){ // Verifica entero
                fila = sc.nextInt();
                if(fila >=0 && fila < cine.length){ // Verifica rango
                    break;
                }else{
                    System.out.println("Fila fuera de rango.");
                }
            }else{
                System.out.println("Debe ingresar numero.");
                sc.next();
            }
        }

        // VALIDACION DE ASIENTO
        while(true){
            System.out.print("Asiento (0-3): ");
            if(sc.hasNextInt()){
                asiento = sc.nextInt();
                if(asiento >=0 && asiento < cine[0].length){
                    break;
                }else{
                    System.out.println("Asiento fuera de rango.");
                }
            }else{
                System.out.println("Debe ingresar numero.");
                sc.next();
            }
        }

        cine[fila][asiento] = "X"; // Marca asiento ocupado

        System.out.println("Mapa del cine:");

        for(int i=0;i<cine.length;i++){ // Recorre filas
            for(int j=0;j<cine[i].length;j++){ // Recorre columnas
                System.out.print(cine[i][j] + " "); // Imprime asiento
            }
            System.out.println();
        }

    }
}
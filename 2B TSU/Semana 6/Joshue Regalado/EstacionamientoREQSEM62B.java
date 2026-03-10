/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estacionamiento.req.sem6.pkg2b;

import java.util.Scanner;

/**
 *
 * @author jasun
 */
public class EstacionamientoREQSEM62B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
     String[][] lugares = {
            {"[ ]","[ ]","[ ]","[ ]"},
            {"[ ]","[ ]","[ ]","[ ]"},
            {"[ ]","[ ]","[ ]","[ ]"}
        };
        int fila, lugar, f;
        f=1;
        System.out.println("ESTACIONAMIENTO");
        
        for (int i = 0; i < lugares.length; i++) {
            System.out.print("Fila " + f++ + " ");
            for (int j = 0; j < lugares[i].length; j++) {
                System.out.print(lugares[i][j]);
            }
            System.out.println();
        }

        System.out.println("Ingrese la fila: ");
        fila = sc.nextInt();
        while (fila<1 || fila>3) {
            System.out.println("Fila no exite, ingrese otra: ");
            fila=sc.nextInt();
        }

        System.out.println("Ingrese el lugar: ");
        lugar = sc.nextInt();
        while (lugar<1 || lugar>4){
            System.out.println("Ese lugar no existe, ingreselo de nuevo");
            lugar=sc.nextInt();
        }

        lugares[fila-1][lugar-1] = "[X]";

        System.out.println("SE ESTACIONO EN:");
        f=1;
        for (int i = 0; i < lugares.length; i++) {
            System.out.print("Fila " + f++ + " ");
            for (int j = 0; j < lugares[i].length; j++) {
                System.out.print(lugares[i][j]);
            }
            System.out.println();
        }
    }
}
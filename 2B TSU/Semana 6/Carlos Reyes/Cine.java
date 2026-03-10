/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cine;

import java.util.Scanner;

/**
 *
 * @author juanc
 */
public class Cine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion, a, f, fila;
        a=1;
        f=1;
        int [][] asientos=new int[3][3];
        
        System.out.println("Sala de cine");
        System.out.println("Asientos disponibles:");
        
        for (int i=0; i<asientos.length; i++) {
            System.out.print("Fila "+f+++" ");
            for (int j=0; j<asientos[i].length; j++) {
                System.out.print("["+a+++"]");
                if (a==4) {
                    a=1;
                }
        }
            System.out.println();
        }
        System.out.println("Escoja la fila: ");
        fila=sc.nextInt();
        while (fila>3 || fila<1) {
            System.out.println("Fila no existente, ingrese del 1 al 3: ");
            fila=sc.nextInt();
        }
        System.out.println("Escoja el numero de asiento a ocupar: ");
        opcion=sc.nextInt();
        while (opcion>3 || opcion<1){
            System.out.println("Asiento no existente, ingrese uno del 1 al 3:");
            opcion=sc.nextInt();
        }
        asientos[fila - 1][opcion - 1]=1;
        
        f=1;
        System.out.println("Asientos actualizados");
         for (int i=0; i<asientos.length; i++) {
            System.out.print("Fila "+(f++)+" ");
            for (int j=0; j<asientos[i].length; j++) {
                if (asientos[i][j]==1) {
                    System.out.print("[x]");
                    a++;
                } else {
                System.out.print("["+a+++"]");
                }
                if (a==4) {
                    a=1;
                }
    }
             System.out.println();
    }
    }
    }
    


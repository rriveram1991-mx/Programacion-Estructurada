/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication60;

public class Cine {

    public static void main(String[] args) {

        int asientos[][] = {
            {1,1,1,1,1},
            {1,0,1,0,1},
            {1,1,0,1,1}
        };

        System.out.println("Mapa de asientos del cine");

        for(int i = 0; i < asientos.length; i++) {

            for(int j = 0; j < asientos[i].length; j++) {

                System.out.print(asientos[i][j] + " ");

            }

            System.out.println();

        }

    }

}

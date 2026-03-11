/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication61;

public class Estacionamiento {

    public static void main(String[] args) {

        int lugares[][] = {
            {1,0,1,1},
            {0,0,1,1},
            {1,1,1,0}
        };

        System.out.println("Estado del estacionamiento");

        for(int i = 0; i < lugares.length; i++) {

            for(int j = 0; j < lugares[i].length; j++) {

                System.out.print(lugares[i][j] + " ");

            }

            System.out.println();

        }

    }

}


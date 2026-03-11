/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad2;

/**
 *
 * @author Guillermo
 */
public class Estacionamiento {
    public static void main(String[] args) {
//V = Vacio
//O = Ocupados
        String[][] lugares = {
            {"V", "V", "O"},
            {"O", "V", "V"},
            {"V", "O", "V"}
        };

        System.out.println("Estacionamiento:");

        for (int i = 0; i < lugares.length; i++) {
            for (int j = 0; j < lugares[i].length; j++) {
                System.out.print(lugares[i][j] + " ");
            }
            System.out.println();
        }

    }
}


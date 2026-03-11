/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad2;

/**
 *
 * @author Guillermo
 */
public class asientos_de_cine {

    public static void main(String[] args) {
// L = Libre 
// O = Ocupados
        String[][] asientos = {
            {"L", "L", "L", "L"},
            {"L", "O", "L", "L"},
            {"L", "L", "O", "L"}
        };

        System.out.println("Asientos del cine:");

        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                System.out.print(asientos[i][j] + " ");
            }
            System.out.println();
        }

    }
}


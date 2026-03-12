/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cine;

import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author juang
 */
public class Cine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
           int[][] asientos = {
            {1, 0, 0},
            {0, 1, 1},
            {0, 1, 0}
        };

        int ocupados = 0;

        try {

            FileWriter writer = new FileWriter("reporte_cine.txt");

            for (int i = 0; i < asientos.length; i++) {

                for (int j = 0; j < asientos[i].length; j++) {

                    writer.write(asientos[i][j] + " ");

                    if (asientos[i][j] == 1) {
                        ocupados++;
                    }
                }

                writer.write("\n");
            }

            writer.write("Asientos ocupados: " + ocupados + "\n");

            writer.close();

        } catch (IOException e) {

            System.out.println("Error");

        }

    }
}
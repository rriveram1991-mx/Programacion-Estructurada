/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asientoscine.det1.sem6.pkg2b;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author jasun
 */
public class ASIENTOSCINEDET1SEM62B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         int[][] asientos = {
            {1,0,0},
            {1,1,0},
            {0,0,0}
        };

        int ocupados = 0;

        try {
            File myObj = new File("reporte_cine.txt");
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
            e.printStackTrace();
        }

    }
}
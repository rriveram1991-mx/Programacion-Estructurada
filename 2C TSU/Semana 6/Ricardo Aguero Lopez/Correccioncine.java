/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package correccioncine;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author aguer
 */
public class Correccioncine {

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

            FileWriter writer = new FileWriter("reporte_cine.txt");

            for (int i = 0; i < asientos.length; i++) {

                for (int j = 0; j < asientos[i].length; j++) { 
                //  Se cambió <= por < para evitar salir del tamaño del arreglo

                    writer.write(asientos[i][j] + " ");
                    System.out.print(asientos[i][j] + " "); //Se agregó esta linea para mostrar los asientos en pantalla

                    if (asientos[i][j] == 1) { 
                    //  Se cambió = por == para hacer comparación
                        ocupados++;
                    }

                }

                writer.write("\n"); 
              // Se agregó ; al final
                System.out.println();
            }

            writer.write("Asientos ocupados: " + ocupados + "\n");
            System.out.println("Asientos ocupados: " + ocupados); 
            //  Se agregó para mostrar el total en consola

            writer.close();

        } catch (IOException e) {

            System.out.println("Error");

        }
    }
    
}

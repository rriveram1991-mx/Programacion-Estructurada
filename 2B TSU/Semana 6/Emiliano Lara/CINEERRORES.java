/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cine.errores;
//falto io.file
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author emili
 */
public class CINEERRORES {

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
            FileWriter writer = new FileWriter("reportee_cine.txt");
            for (int i = 0; i < asientos.length; i++) {
//SE QUITA EL IGUAL PORQUE SI NO NO PODRIA ARRANCAR
                for (int j = 0; j < asientos[i].length; j++) {
                    writer.write(asientos[i][j] + " ");
                    //FALTA IGUAL PARA COMPARAR
                    if (asientos[i][j] == 1) {
                        ocupados++;
                    }
                }
//PUNTO Y COMA
                writer.write("\n");
            }
            writer.write("Asientos ocupados: " + ocupados + "\n");
            writer.close();
            //se confirma que se creo el archivo
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
            //falto cerrar el stack
        }
    }
}

    
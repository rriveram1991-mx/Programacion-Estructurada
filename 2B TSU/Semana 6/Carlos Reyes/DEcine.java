/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package decine;
import java.io.FileWriter;
import java.io.IOException;
//Hacia falta un import de java.io.File
import java.io.File;

/**
 *
 * @author juanc
 */
public class DEcine {

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
            //Faltaba crear el file 
            File mFile=new File ("reporte_cine.txt");
            if (mFile.createNewFile()){
                System.out.println("Se creo el archivo ");
            }
            else {
                System.out.println("Archivo ya creado ");
            }


            FileWriter writer = new FileWriter("reporte_cine.txt");

            for (int i = 0; i < asientos.length; i++) {
                //se quito el menor igual y se puso solo el menor
                for (int j = 0; j < asientos[i].length; j++) {

                    writer.write(asientos[i][j] + " ");
                    
                   //Faltaba un =
                    if (asientos[i][j] == 1) {
                        ocupados++;
                    }

                }
                //Se agregó el ; que faltaba
                writer.write("\n");

            }

            writer.write("Asientos ocupados: " + ocupados + "\n");

            writer.close();
            //faltaba el mensaje indicando que se guardó 
            System.out.println("Guardado ");

        } catch (IOException e) {

            System.out.println("Error");
            //Faltaba poner el e.printStackTrace
            e.printStackTrace();

        }

    }
    }
    


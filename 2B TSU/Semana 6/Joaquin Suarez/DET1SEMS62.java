/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det1sems62;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ssjoa
 */
public class DET1SEMS62 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        int[][] asientos = {
            {1,0,0},
            {1,1,0},
            {0,0,0}
        };

        int ocupados = 0;

        try {

            FileWriter writer = new FileWriter("reporte_cine.txt");

            for (int i = 0; i < asientos.length; i++) {

                for (int j = 0; j < asientos[i].length; j++)/*dejar el igual significaria no cumplir con los requisitos para que el bucle se inicie pues sale del rango*/
                {

                    writer.write(asientos[i][j] + " ");

                    if (asientos[i][j] == 1)/*un solo igual significa que tanto es igual a tanto, dos, significan que estas asignando un valor*/
                    {
                        ocupados++;
                    }

                }

                writer.write("\n");/*falta punto y coma*/
                

            }

            writer.write("Asientos ocupados: " + ocupados + "\n");

            writer.close();

        } catch (IOException e) {

            System.out.println("Error");

        }

    }
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
    


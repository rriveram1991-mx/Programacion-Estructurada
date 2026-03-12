/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det2sem6;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author miguelgu
 */
public class Det2Sem6 {

    public static void main(String[] args) {

        int[][] asientos = {
            {1,0,0},
            {1,1,0},
            {1,1,0}
        };

        int ocupados = 0;

        try {

            FileWriter writer = new FileWriter("reporte_cine.txt");

            for (int i = 0; i < asientos.length; i++) {

                for (int j = 0; j < asientos[i].length; j++) //Aqui no se debe de poner <= ya que si no intentara buscar otro numero fuera de rango
                {

                    writer.write(asientos[i][j] + " ");

                    if (asientos[i][j] == 1) //Aqui debe de ser == en vez de solo el = y error logico por eso mismo al hacer el conteo de asientos
                    {
                        ocupados++;
                    }

                }

                writer.write("\n"); //Aqui faltaba punto y coma

            }

            writer.write("Asientos ocupados: " + ocupados + "\n");

            writer.close();

        } catch (IOException e) {

            System.out.println("Error");

        }

    }
}

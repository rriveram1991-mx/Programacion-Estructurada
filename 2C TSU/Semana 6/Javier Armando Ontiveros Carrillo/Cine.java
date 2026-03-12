package cine;
import java.io.IOException;
import java.io.FileWriter;

public class Cine {
    
    public static void main(String[] args) {
        int[][] asientos = {
            {1, 0, 0},
            {1, 1, 0},
            {0, 0, 0}
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

import java.io.FileWriter;
import java.io.IOException;

public class Eje7Cine {

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

                // Aqui le quite el = porque si no el programa truena al final de la fila
                for (int j = 0; j < asientos[i].length; j++) {

                    writer.write(asientos[i][j] + " ");

                    // Aqui le puse == porque el "=" solo es para dar valores, no para comparar
                    if (asientos[i][j] == 1) {
                        ocupados++;
                    }

                }

                writer.write("\n"); // Le hacia falta el ";" para que el salto de linea jalara

            }

            // Tambien le puse el ";" aqui al writer para que guarde el total
            writer.write("Asientos ocupados: " + ocupados + "\n");

            writer.close();

            System.out.println("Reporte listo");

        } catch (IOException e) {

            System.out.println("Error");

        }
    }
}
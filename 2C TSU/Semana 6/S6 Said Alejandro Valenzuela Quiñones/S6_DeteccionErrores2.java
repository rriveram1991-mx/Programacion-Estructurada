package s6_deteccionerrores2;

import java.io.FileWriter;
import java.io.IOException;

public class S6_DeteccionErrores2 {

    public static void main(String[] args) {
        int[][] asientos = {
            {1, 0, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        int ocupados = 0;

        try (FileWriter writer = new FileWriter("reporte_cine.txt")) {

            for (int i = 0; i < asientos.length; i++) {
                // 1. El límite debe ser j < asientos[i].length ya que si es <= va a acceder a una posición que no exista
                for (int j = 0; j < asientos[i].length; j++) {
                    
                    writer.write(asientos[i][j] + " ");

                    // 2. La igualdad es con ==
                    if (asientos[i][j] == 1) {
                        ocupados++;
                    }
                }
                // 3. Faltaba ;
                writer.write("\n");
            }

            writer.write("Asientos ocupados: " + ocupados + "\n");
            System.out.println("Reporte generado con exito. Ocupados: " + ocupados);

        } catch (IOException e) {
            // 4. Agregar la información del error
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
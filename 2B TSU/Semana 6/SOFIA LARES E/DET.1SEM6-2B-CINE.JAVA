import java.io.FileWriter;
import java.io.IOException;

public class CineErrores {

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
                // Error 1 : Cambiado "<=" por "<"
                for (int j = 0; j < asientos[i].length; j++) {

                    // Error 2 corregido: Asegurar que escriba el texto del número
                    writer.write(asientos[i][j] + " ");

                    // Error 3 : Cambiado "=" por "=="
                    if (asientos[i][j] == 1) {
                        ocupados++;
                    }
                }
                // Error 4 : Agregado ";"
                writer.write("\n");
            }

            writer.write("Asientos ocupados: " + ocupados + "\n");
            writer.close();
            
            // Error 5 : Añadida confirmación
            System.out.println("Reporte de cine generado con éxito.");

        } catch (IOException e) {
            System.out.println("Error al escribir el reporte");
        }
    }
}
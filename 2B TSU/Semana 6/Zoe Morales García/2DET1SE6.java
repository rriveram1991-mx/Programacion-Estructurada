import java.io.FileWriter;
import java.io.IOException;

public class 2DET1SE6 {

    public static void main(String[] args) {

        int[][] asientos = {
            {1,0,0},
            {1,1,0},
            {0,0,0}
        };

        int ocupados = 0;

        //asegurar que el archivo se cierre solo
        try (FileWriter writer = new FileWriter("reporte_cine.txt")) {

            for (int i = 0; i < asientos.length; i++) {

                for (int j = 0; j < asientos[i].length; j++) {
                    //mayor igual, error sintaxis
                    writer.write(asientos[i][j] + " ");

                    if (asientos[i][j] == 1) {
                        //contador de asientos ocupados
                        ocupados++;
                    }
                }
                //agregar el punto y coma faltante
                writer.write("\n");
            }

            writer.write("Asientos ocupados: " + ocupados + "\n");
            System.out.println("Reporte generado con éxito.");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}

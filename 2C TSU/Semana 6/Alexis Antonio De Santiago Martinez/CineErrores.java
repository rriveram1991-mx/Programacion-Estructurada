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

                // ERROR 1: estaba <= asientos[i].length
                // Se cambió a < para evitar ArrayIndexOutOfBounds
                for (int j = 0; j < asientos[i].length; j++) {

                    writer.write(asientos[i][j] + " ");

                    // ERROR 4: el programa debía mostrar los asientos en consola
                    System.out.print(asientos[i][j] + " ");

                    // ERROR 2: estaba usando = en lugar de ==
                    if (asientos[i][j] == 1) {
                        ocupados++;
                    }

                }

                // ERROR 3: faltaba punto y coma
                writer.write("\n");
                System.out.println();

            }

            writer.write("Asientos ocupados: " + ocupados + "\n");

            writer.close();

            // ERROR 5: no había confirmación al usuario
            System.out.println("Reporte generado correctamente");

        } catch (IOException e) {

            System.out.println("Error");

        }

    }
}
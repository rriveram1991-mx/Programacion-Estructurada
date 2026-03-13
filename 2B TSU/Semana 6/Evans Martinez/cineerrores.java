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
                for (int j = 0; j < asientos[i].length; j++) {
                    
                    writer.write(asientos[i][j] + " ");
                    System.out.print(asientos[i][j] + " ");

                    if (asientos[i][j] == 1) {
                        ocupados++;
                    }
                }
                
                writer.write("\n");
                System.out.println();
            }

            writer.write("Asientos ocupados: " + ocupados + "\n");
            writer.close();

            System.out.println("Asientos ocupados: " + ocupados);

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
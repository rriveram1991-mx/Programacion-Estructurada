import java.io.FileWriter;
import java.io.IOException;

/**
 * Institución: Universidad Tecnológica de Torreón.
 * Carrera: Ingeniería en Desarrollo de Software.
 * Alumno: Juan Diego Arroyo Bucio.
 * Materia: Programación Estructurada.
 */
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

            System.out.println("=== MAPA DE ASIENTOS ===");

            for (int i = 0; i < asientos.length; i++) {

                // ERROR 1 CORREGIDO: Se quitó el '=' para evitar el desbordamiento (IndexOutOfBounds)
                for (int j = 0; j < asientos[i].length; j++) {

                    writer.write(asientos[i][j] + " ");

                    // ERROR 4 CORREGIDO: Se agregó el print para MOSTRAR los asientos en consola
                    System.out.print(asientos[i][j] + " ");

                    // ERROR 2 CORREGIDO: Se cambió '=' por '==' para hacer una comparación lógica
                    if (asientos[i][j] == 1) {
                        ocupados++;
                    }

                }

                // ERROR 3 CORREGIDO: Se agregó el punto y coma (;) faltante
                writer.write("\n");
                System.out.println(); // Complemento del Error 4 para dar el salto de línea visual

            }

            writer.write("Asientos ocupados: " + ocupados + "\n");

            // ERROR 5 CORREGIDO: Se agregó el print para MOSTRAR el total al usuario
            System.out.println("\nAsientos ocupados: " + ocupados);

            writer.close();

            System.out.println("-> Reporte guardado exitosamente en 'reporte_cine.txt'");

        } catch (IOException e) {

            System.out.println("Error al generar el archivo");

        }

    }
}
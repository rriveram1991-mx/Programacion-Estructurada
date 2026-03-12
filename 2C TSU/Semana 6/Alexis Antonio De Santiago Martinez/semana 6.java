import java.io.FileWriter;
import java.io.IOException;

public class p14 {
    public static void main(String[] args) {
        // Matriz de calificaciones: 3 alumnos x 3 materias
        int[][] calificaciones = {
            {8, 9, 7},
            {10, 9, 9},
            {6, 7, 8}
        };

        // Materias asociadas a cada alumno
        String[] materias = {"Programacion", "Redes", "Bases de Datos"};

        try {
            FileWriter writer = new FileWriter("calificaciones.txt");

            // Recorremos cada alumno
            for (int i = 0; i < calificaciones.length; i++) {
                int suma = 0;

                // Mostrar encabezado
                System.out.println("Alumno " + (i + 1));
                writer.write("Alumno " + (i + 1) + "\n");

                // Mostrar calificaciones
                System.out.print("Calificaciones: ");
                writer.write("Calificaciones: ");
                for (int j = 0; j < calificaciones[i].length; j++) {
                    System.out.print(calificaciones[i][j] + " ");
                    writer.write(calificaciones[i][j] + " ");
                    suma += calificaciones[i][j];
                }
                System.out.println();
                writer.write("\n");

                // Calcular promedio
                double promedio = (double) suma / calificaciones[i].length;

                // Mostrar materia
                System.out.println("Materia: " + materias[i]);
                writer.write("Materia: " + materias[i] + "\n");

                // Mostrar promedio
                System.out.println("Promedio: " + promedio);
                writer.write("Promedio: " + promedio + "\n");

                // Regla adicional: alumno destacado
                if (promedio >= 9) {
                    System.out.println("Alumno destacado");
                    writer.write("Alumno destacado\n");
                }

                System.out.println(); // Separador en consola
                writer.write("\n");   // Separador en archivo
            }

            writer.close();
            System.out.println("Resultados guardados en calificaciones.txt");

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}

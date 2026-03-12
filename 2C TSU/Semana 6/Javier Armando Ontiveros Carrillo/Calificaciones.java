package calificaciones;
import java.io.IOException;
import java.io.FileWriter;

public class Calificaciones {
    
    public static void main(String[] args) {
        
        int[][] calificaciones = {
            {8, 9, 7},
            {10, 9, 9},
            {6, 7, 8}
        };
        
        String[] materias = {"Programacion", "Redes", "Bases de Datos"};
        String[] nombresAlumnos = {"Alumno 1", "Alumno 2", "Alumno 3"};

        try (FileWriter writer = new FileWriter("calificaciones.txt")) {
            for (int i = 0; i < calificaciones.length; i++) {
                
                System.out.print(nombresAlumnos[i] + "\nCalificaciones: ");
                for (int j = 0; j < calificaciones[i].length; j++) {
                    System.out.print(calificaciones[i][j] + " ");
                }
                System.out.println();
                
                int suma = 0;
                for (int j = 0; j < calificaciones[i].length; j++) {
                    suma += calificaciones[i][j];
                }
                double promedio = (double) suma / calificaciones[i].length;
                
                writer.write(nombresAlumnos[i] + "\n");
                writer.write("Calificaciones: ");
                for (int j = 0; j < calificaciones[i].length; j++) {
                    writer.write(calificaciones[i][j] + " ");
                }
                writer.write("\n");
                writer.write("Materia: " + materias[i] + "\n");
                writer.write(String.format("Promedio: %.1f\n", promedio));
                
                if (promedio >= 9.0) {
                    writer.write("Alumno destacado\n");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SistemaCalificaciones 
{
    public static void main(String[] args) 
    {
        int[][] calificaciones = 
        {
            {8, 9, 7},
            {10, 9, 9},
            {6, 7, 8}
        };
        
        String[] materias = {"Programación", "Redes", "Bases de Datos"};

        try (PrintWriter writer = new PrintWriter(new FileWriter("calificaciones.txt"))) 
        {
            for (int i = 0; i < calificaciones.length; i++) {
                double suma = 0;
                System.out.println("Alumno " + (i + 1));
                writer.println("Alumno " + (i + 1));
                
                
                System.out.print("Calificaciones: ");
                writer.print("Calificaciones: ");
                for (int j = 0; j < calificaciones[i].length; j++) 
                {
                    System.out.print(calificaciones[i][j] + " ");
                    writer.print(calificaciones[i][j] + " ");
                    suma += calificaciones[i][j];
                }
                
                double promedio = suma / calificaciones[i].length;
                System.out.println("\nMateria: " + materias[i]);
                System.out.println("Promedio: " + promedio);
                
                writer.println("\nMateria: " + materias[i]);
                writer.println("Promedio: " + promedio);

               
                if (promedio >= 9) {
                    System.out.println("Alumno destacado");
                    writer.println("Alumno destacado");
                }
                
                System.out.println("--------------------");
                writer.println();
            }
            System.out.println("Datos guardados en calificaciones.txt exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
import java.io.FileWriter;
import java.io.IOException;

/**
 * Institución: Universidad Tecnológica de Torreón.
 * Alumno: Juan Diego Arroyo Bucio.
 * Materia: Programación Estructurada.
 */
public class SistemaCalificaciones {
    public static void main(String[] args) {

        // 1. Datos del sistema
        int[][] calificaciones = {
                {8, 9, 7},
                {10, 9, 9},
                {6, 7, 8}
        };

        // Arreglo paralelo para vincular la materia a cada fila (alumno)
        String[] materias = {"Programacion", "Redes", "Bases de Datos"};
        // 2. Bloque try-catch para el manejo del archivo
        try {
            FileWriter writer = new FileWriter("calificaciones.txt");

            System.out.println("=== RESULTADOS EN CONSOLA ===\n");
            // Recorrido de la matriz con for
            for (int i = 0; i < calificaciones.length; i++) {
                // Textos base del alumno
                String tituloAlumno = "Alumno " + (i + 1);
                System.out.println(tituloAlumno);
                writer.write(tituloAlumno + "\n");
                System.out.print("Calificaciones: ");
                writer.write("Calificaciones: ");

                double suma = 0;
                // Recorrido de las columnas (calificaciones individuales)
                for (int j = 0; j < calificaciones[i].length; j++) {
                    System.out.print(calificaciones[i][j] + " ");
                    writer.write(calificaciones[i][j] + " ");
                    suma += calificaciones[i][j];
                }
                System.out.println();
                writer.write("\n");
                // Cálculo del promedio
                double promedio = suma / calificaciones[i].length;
                // Redondeo a un decimal
                promedio = Math.round(promedio * 10.0) / 10.0;
                // Limpieza visual: si el promedio es entero (ej. 8.0), le quitamos el decimal
                String promFormateado = (promedio % 1 == 0) ? String.valueOf((int)promedio) : String.valueOf(promedio);
                // Iprimir materia y promedio
                String textoMateria = "Materia: " + materias[i];
                String textoPromedio = "Promedio: " + promFormateado;
                System.out.println(textoMateria);
                writer.write(textoMateria + "\n");
                System.out.println(textoPromedio);
                writer.write(textoPromedio + "\n");

                // Regla condicional del Alumno Destacado
                if (promedio >= 9) {
                    System.out.println("Alumno destacado");
                    writer.write("Alumno destacado\n");
                }

                // Saltos de línea para separar a cada alumno
                System.out.println();
                writer.write("\n\n");
            }
            // Cerrar el archivo es obligatorio para guardar los datos
            writer.close();
            System.out.println("------------------------------------------------");
            System.out.println("Archivo 'calificaciones.txt' generado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al intentar crear o escribir el archivo.");
            e.printStackTrace();
        }
    }
}
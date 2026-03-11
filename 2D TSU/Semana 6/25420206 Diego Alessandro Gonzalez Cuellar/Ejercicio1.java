package Semana6;

import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) {
        // Matriz de 3x3
        int[][] calificaciones = {
                { 8, 9, 7 },
                { 10, 9, 9 },
                { 6, 7, 8 },
                { 9, 9, 9 },
                { 10, 8, 7 }
        };

        // Alumnos y su materia
        String[] alumnos = { "Diego", "Emiliano", "Mario", "Ernesto", "Anthony" };
        String[] materias = { "Programacion", "Calculo,Probabilidad", "Sistemas" };

        String archivo = "archivo.txt";

        // Escrito del archivo
        try {
            FileWriter writer = new FileWriter(archivo);

            String encabezado = "";
            System.out.println(encabezado);
            writer.write(encabezado);

            for (int i = 0; i < calificaciones.length; i++) {
                String alumnoInfo = "Estudiante " + alumnos[i] + "\n";
                System.out.print(alumnoInfo);
                writer.write(alumnoInfo);

                double sumapromedio = 0;

                for (int j = 0; j < calificaciones[i].length; j++) {
                    int calificacionActual = calificaciones[i][j];
                    sumapromedio += calificacionActual;

                    // Mostramos al alumno y su materia
                    String infoMateria = "  " + materias[j] + ": " + calificacionActual + "\n";
                    System.out.print(infoMateria);
                    writer.write(infoMateria);
                }

                // Calculamos el promedio
                double promedio = sumapromedio / calificaciones[i].length;
                String infoPromedio = "  Promedio: " + String.format("%.2f", promedio) + " | ";

                // Evaluamos si el alumno aprueba según su promedio
                if (promedio >= 7.0) {
                    infoPromedio += "Estado: Aprobado\n";
                } else {
                    infoPromedio += "Estado: Reprobado\n";
                }

                System.out.print(infoPromedio);
                writer.write(infoPromedio);
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

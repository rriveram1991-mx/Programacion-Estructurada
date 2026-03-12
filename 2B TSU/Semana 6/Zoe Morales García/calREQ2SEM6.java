import java.io.FileWriter;
import java.io.IOException;

public class calREQ2SEM6 {
    public static void main(String[] args) {
        int[][] calificaciones = {
            {8, 9, 7},
            {10, 9, 9},
            {6, 7, 8}
        };

        String[] materias = {"Programacion", "Redes", "Bases de Datos"};

        try {
            FileWriter escritor = new FileWriter("calificaciones.txt");
            
            for (int i = 0; i < calificaciones.length; i++) {
                int suma = 0;
                StringBuilder notasTxt = new StringBuilder();
                
                for (int j = 0; j < calificaciones[i].length; j++) {
                    suma += calificaciones[i][j];
                    notasTxt.append(calificaciones[i][j]).append(" ");
                }

                double promedio = suma / 3.0;
                String bloque = "Alumno " + (i + 1) + "\n" +
                                "Calificaciones: " + notasTxt.toString().trim() + "\n" +
                                "Materia: " + materias[i] + "\n" +
                                "Promedio: " + String.format("%.1f", promedio) + "\n";

                if (promedio >= 9) {
                    bloque += "Alumno destacado\n";
                }

                System.out.println(bloque);
                escritor.write(bloque + "\n");
            }
            escritor.close();
            System.out.println("¡Archivo 'calificaciones.txt' generado!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


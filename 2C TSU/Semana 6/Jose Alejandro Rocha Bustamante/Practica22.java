
import java.io.FileWriter;
import java.io.IOException;
public class Practica22 {
    public static void main(String[]args){
       int[][] calificaciones = {
            {8, 9, 7},
            {10, 9, 9},
            {6, 7, 8}
        };
        String[] materias = {"Programacion", "Redes", "Bases de Datos"};
        try {
            FileWriter archivo = new FileWriter("calificaciones.txt");
            for (int i = 0; i < calificaciones.length; i++) {
                System.out.println("Alumno " + (i + 1));
                archivo.write("Alumno " + (i + 1) + "\n");
                System.out.print("Calificaciones: ");
                archivo.write("Calificaciones: ");
                double suma = 0;
                for (int j = 0; j < calificaciones[i].length; j++) {

                    System.out.print(calificaciones[i][j] + " ");
                    archivo.write(calificaciones[i][j] + " ");
                    suma = suma + calificaciones[i][j];
                }
                System.out.println();
                archivo.write("\n");

                System.out.println("Materia: " + materias[i]);
                archivo.write("Materia: " + materias[i] + "\n");

                double promedio = suma / calificaciones[i].length;
                
                System.out.println("Promedio: " + promedio);
                archivo.write("Promedio: " + promedio + "\n");
                if (promedio >= 9) {
                    System.out.println("Alumno destacado");
                    archivo.write("Alumno destacado\n");
                }
                System.out.println();
                archivo.write("\n");
            }

            archivo.close();
            System.out.println("Archivo guardado correctamente.");

        } 
        catch (IOException e) {
            System.out.println("Error al guardar el archivo.");
        }
       
    }
}

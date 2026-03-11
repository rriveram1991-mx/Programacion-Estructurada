import java.io.FileWriter;
import java.io.IOException;

public class CaliEStadistica{
        public static void main(String[] args){
            
            int[][] calificaciones = {
                {8,9,7},
                {10,9,9},
                {6,7,8}
            };
            
            String[] materias = {
                "Programacion",
                "Redes",
                "base de Datos"
            };
            
            try {
                
                FileWriter archivo = new FileWriter("calificaciones.txt");
                
                for (int i = 0; i < calificaciones.length; i++ ) {
                    
                    int suma = 0;
                    
                    System.out.println("Alumno " + (i + 1));
                    archivo.write("Calificaciones; ");
                    
                    for (int j = 0; j < calificaciones[i].length; j++){
                        System.out.print(calificaciones[i][j] + " ");
                        archivo.write(calificaciones[i][j] + " ");
                        suma += calificaciones[i][j];
                    }
                    
                    double promedio = (double) suma / calificaciones[i].length;
                    
                    System.out.println("\nMateria: " + materias[i]);
                    archivo.write("\nMateria: " + materias[i]);
                    
                    System.out.println("Promedio: " + promedio);
                    archivo.write("\nAlumno: " + promedio);
                    
                    if (promedio >= 9) { 
                        System.out.println("Alumno destacado");
                        archivo.write("\nAlumno destacado");
                    }
                    
                    System.out.println();
                    archivo.write("\n\n");
                }
                
                archivo.close();
                System.out.println("Datos guardados en calificaciones.text");
            }catch (IOException e){
                System.out.println("Error al escribir el archivo");
                e.printStackTrace();
            }
                   
        }
    
}
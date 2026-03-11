
package calif.estadistica;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CALIFESTADISTICA {
//SANDRA DOMINGUEZ
    
    public static void main(String[] args) {
        int[][] CALIFICACIONES = 
        {
            {8, 9, 7},  
            {10, 9, 9},
            {6, 7, 8}
        };

        
        String[] materias = {"PROGRAMACION", "REDES", "BASE DE DATOS"};

        try 
        {
            FileWriter mywriter = new FileWriter("CALIFICACIONES.txt");

          
            for (int i = 0; i <3; i++) 
            {
                System.out.println("-----------------------------------------");
                mywriter.write("ALUMNO " + (i + 1) + "\n");
                System.out.println("ALUMNO " + (i + 1));

               
                mywriter.write("CALIFICACIONES:\n");
                System.out.print("CALIFICACIONES: ");
                int suma = 0;
                for (int j = 0; j < 3; j++) 
                {
                    mywriter.write(CALIFICACIONES[i][j] + "");
                    System.out.print(CALIFICACIONES[i][j] + " ");
                    suma += CALIFICACIONES[i][j];
                }
                mywriter.write("\n");
                System.out.println();

                double promedio = (double) suma / 3;
                mywriter.write("PROMEDIO: " + promedio + "\n");
                System.out.println("PROMEDIO: " + promedio);

               
                mywriter.write("MATERIA: " + materias[i] + "\n");
                System.out.println("MATERIA: " + materias[i]);

               
                if (promedio >= 9) 
                {
                    mywriter.write("ALUMNO DESTACADO\n");
                    System.out.println("ALUMNO DESTACADO");
                   
                }
               
            }
             mywriter.close();

        } catch (IOException e) 
        {
           System.out.println("OCURRIO UN ERROR");
            e.printStackTrace(); 
        }
    }
}

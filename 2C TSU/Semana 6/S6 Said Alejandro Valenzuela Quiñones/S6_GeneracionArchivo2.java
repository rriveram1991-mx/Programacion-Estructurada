package s6_generacionarchivo2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class S6_GeneracionArchivo2 {

    public static void main(String[] args) {

        try {

            // Crear objeto File
            File myObj = new File("DatosAlumno.txt");

            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists");
            }

            // Crear FileWriter
            FileWriter myWriter = new FileWriter("DatosAlumno.txt");

            // Escribir líneas
            myWriter.write("Alumno: Said Alejandro Valenzuela Quiñones.\n");
            myWriter.write("Edad: 20 años.\n");
            myWriter.write("Especialidad: Desarrollo de Software Multiplataforma.\n");
            myWriter.write("Institución: Universidad Tecnológica de Torreón.\n");
            myWriter.write("Lenguaje Favorito: Java.\n");

            // Cerrar archivo
            myWriter.close();

            System.out.println("Successfully wrote to the file");

        } catch (IOException e) {

            System.out.println("An error occurred");
            e.printStackTrace();

        }

    }
}
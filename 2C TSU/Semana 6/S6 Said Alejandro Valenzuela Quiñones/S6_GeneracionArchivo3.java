package s6_generacionarchivo3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class S6_GeneracionArchivo3 {

    public static void main(String[] args) {

        try {

            // Crear objeto File
            File myObj = new File("BrawlStars.txt");

            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists");
            }

            // Crear FileWriter
            FileWriter myWriter = new FileWriter("BrawlStars.txt");

            // Escribir líneas
            myWriter.write("Brawler Favorito: Gray.\n");
            myWriter.write("Creación de la Cuenta: 2020.\n");
            myWriter.write("Copas: 99894.\n");
            myWriter.write("Victorias Supervivencia: 5047.\n");
            myWriter.write("Victorias 3c3: 29151.\n");
            myWriter.write("Brawlers: 100/100 conseguidos.\n");

            // Cerrar archivo
            myWriter.close();

            System.out.println("Successfully wrote to the file");

        } catch (IOException e) {

            System.out.println("An error occurred");
            e.printStackTrace();

        }

    }
}
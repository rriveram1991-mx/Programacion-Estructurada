/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg1.sem6.pkg2b.avr;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author adrianvalenzuelaramirez
 */
public class REQ1SEM62BAVR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 

    {

        try
        {

            File myObj = new File("filename.txt");

            if(myObj.createNewFile())
            {

                System.out.println("File created : " + myObj.getName());

            }
            else
            {

                System.out.println("File already exists.");

            }

            try (FileWriter myWriter = new FileWriter("filename.txt")) {
                myWriter.write("-----------------------------------------------------\n");
                myWriter.write("Nombre del alumno : Erick Tabares\n");
                myWriter.write("Edad : 20\n");
                myWriter.write("Escuela : Universidad Tencologica de Torreon ( UTT ).\n");
                myWriter.write("Lenguaje favorito : C#\n");
                myWriter.write("-----------------------------------------------------");
            }
            System.out.println("Successfully wrote to the file.");

        }catch(IOException e)
        {

            System.out.println("An error ocurred.");

        }

    }
}
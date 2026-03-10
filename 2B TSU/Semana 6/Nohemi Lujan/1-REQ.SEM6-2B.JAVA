package archivo;

 import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author nohem
 */
public class Archivo {
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   

    
        try {
            File myObj = new File("filename.txt");
            
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

            // Escribir texto en el archivo
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("Hola Nohemi!\n");
            myWriter.write("Edad: 18 años.\n");
            myWriter.write("Especialidad: DSM.\n");
            myWriter.write("Escuela: UTT.\n");
            myWriter.write("Lenguaje favorito: java.\n");
            myWriter.write("Mi color favorito es el azul y el gris.\n");
            myWriter.close();
            
            System.out.println("Successfully wrote to the file.");
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

    


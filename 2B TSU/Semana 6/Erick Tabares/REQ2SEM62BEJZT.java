import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class REQ2SEM62BEJZT 
{

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

            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("-----------------------------------------------------\n");
            myWriter.write("Nombre del alumno : Erick Tabares\n");
            myWriter.write("Edad : 20\n");
            myWriter.write("Escuela : Universidad Tencologica de Torreon ( UTT ).\n");
            myWriter.write("Lenguaje favorito : C#\n");
            myWriter.write("-----------------------------------------------------");

            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        }catch(IOException e)
        {

            System.out.println("An error ocurred.");
            e.printStackTrace();

        }

    }
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ARCHIVE
{
    public static void main(String[] args) 
    {
        try {
            
            File miArchivo = new File("MI_INFO.txt");

            
            if (miArchivo.createNewFile()) 
            {
                System.out.println("Archivo creado: " + miArchivo.getName());
            } 
            else 
            {
                System.out.println("El archivo ya existe.");
            }

          
            FileWriter escribir = new FileWriter("MI_INFO.txt");
            
            escribir.write("Nombre: Evans\n");
            escribir.write("Edad: 18\n"); 
            escribir.write("Especialidad: Sistemas y Programacion\n");
            escribir.write("Escuela: Universidad Tecnologica de Torreon\n");
            escribir.write("Lenguaje favorito: c++\n");
            
            
            escribir.write("Dato aleatorio: ¡Me gusta mucho el fútbol!\n");

            
            escribir.close();
            
            System.out.println("Datos guardados con éxito");

        } 
        catch (IOException e) 
        {
            System.out.println("Hubo un error al manejar el archivo.");
            e.printStackTrace();
        }
    }
}
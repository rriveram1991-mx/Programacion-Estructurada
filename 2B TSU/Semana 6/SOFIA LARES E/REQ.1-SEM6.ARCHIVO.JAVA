import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ARCHIVO 
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
            
            escribir.write("Nombre: Sofi\n");
            escribir.write("Edad: 19\n"); 
            escribir.write("Especialidad: Sistemas y Programacion\n");
            escribir.write("Escuela: Universidad Tecnologica de Torreon\n");
            escribir.write("Lenguaje favorito: Java\n");
            
            
            escribir.write("Dato aleatorio: ¡Me gusta mucho la musica de BTS!\n");

            
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

/* Luis Manuel Aguilera Montoya
Modificar el programa para que el archivo contenga y otro aleatorio:
Nombre del alumno
Edad
Especialidad
Escuela
Lenguaje favorito */

import java.io.File; // La clase File se usa para crear, leer o manipular archivos y carpetas en Java.
import java.io.FileWriter; // Sirve para escribir texto dentro de un archivo
import java.io.IOException; //Se usa para manejar errores relacionados con archivos (por ejemplo si no se puede crear o escribir el archivo).


public class REQ1_SEM6_2C_CrearArchivo1 
{
    public static void main(String[] args)
    {
        try
        {
            File miArchivo = new File("Ejemplo1.txt"); //•	File → tipo de objeto. | miArchivo → nombre de la variable. | new File("filename.txt") → crea un objeto archivo

            if (miArchivo.createNewFile()) //createNewFile() intenta crear el archivo físicamente. | Devuelve true o false.
            {
                System.out.println("File created: "+ miArchivo.getName()); // miArchivo.getName() obtiene el nombre del archivo.
            }
            else
            {
                System.out.println("File already exists."); // Si el archivo ya estaba creado, se ejecuta else.
            }

            FileWriter myWriter = new FileWriter("miArchivo.txt"); // myWriter será usado para escribir en el archivo. Si el archivo ya tenía contenido, se sobrescribe.
            myWriter.write("Luis Aguilera\n");
            myWriter.write("22 \n");
            myWriter.write("Desarrollo de software \n");
            myWriter.write("UTT \n");
            myWriter.write("Python \n");
            
            myWriter.close(); // Cierra el archivo después de escribir. Evita errores o pérdida de datos.

            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) // catch captura errores del try. IOException detecta errores relacionados con archivos.

        {
            System.out.println("An error ocurred"); 
            e.printStackTrace(); //Esto muestra información detallada del error.
        }
    }
}
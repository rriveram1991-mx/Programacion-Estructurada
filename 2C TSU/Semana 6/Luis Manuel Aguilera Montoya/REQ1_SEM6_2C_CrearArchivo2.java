/* Luis Manuel Aguilera Montoya
Modificar el programa para que el archivo uno aleatorio */

import java.io.File; // La clase File se usa para crear, leer o manipular archivos y carpetas en Java.
import java.io.FileWriter; // Sirve para escribir texto dentro de un archivo
import java.io.IOException; //Se usa para manejar errores relacionados con archivos (por ejemplo si no se puede crear o escribir el archivo).


public class REQ1_SEM6_2C_CrearArchivo2 
{
    public static void main(String[] args)
    {   
        String name = "Lucia", nationality = "Chile";
        int day = 20 , month = 4, year= 1999;
        
        try
        {
            File miArchivo2 = new File("Ejemplo2.txt"); //•	File → tipo de objeto. | miArchivo → nombre de la variable. | new File("filename.txt") → crea un objeto archivo

            if (miArchivo2.createNewFile()) //createNewFile() intenta crear el archivo físicamente. | Devuelve true o false.
            {
                System.out.println("Archivo creado: "+ miArchivo2.getName()); // miArchivo.getName() obtiene el nombre del archivo.
            }
            else
            {
                System.out.println("El archivo ya existe."); // Si el archivo ya estaba creado, se ejecuta else.
            }

            FileWriter myWriter = new FileWriter("miArchivo2.txt"); // myWriter será usado para escribir en el archivo. Si el archivo ya tenía contenido, se sobrescribe.
            myWriter.write("Nombre: " + name + "\n");
            myWriter.write("Nacionalidad: " + nationality + "\n");
            myWriter.write("Dia de nacimiento:" + day + "\n");
            myWriter.write("Mes de nacimiento: " + month + "\n");
            myWriter.write("Año de nacimiento: " + year + " \n");
            
            myWriter.close(); // Cierra el archivo después de escribir. Evita errores o pérdida de datos.

            System.out.println("Se escribio el archivo correctamente.");
        }
        catch (IOException e) // catch captura errores del try. IOException detecta errores relacionados con archivos.

        {
            System.out.println("Ocurrio un error!"); 
            e.printStackTrace(); //Esto muestra información detallada del error.
        }
    }
}
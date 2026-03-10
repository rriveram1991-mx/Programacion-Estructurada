import java.io.File;
 import java.io.FileWriter;
 import java.io.IOException;

public class Archivos {
public static void main(String[] args) {
    try {
        File miArchivo = new File("Daniel.txt");

        if (miArchivo.createNewFile()) {
            System.out.println("¡Archivo creado!: " + miArchivo.getName());
        } else {
            System.out.println("El archivo ya existe.");
        }

        FileWriter escritor = new FileWriter("Daniel.txt");
        escritor.write("Daniel Martinez Rodriguez \n");
        escritor.write("18 años de edad ");
        escritor.write("Desarrollo de Software ");
        escritor.write("Escuela : UTT");
        escritor.write("Lenguaje Favorito : Python ");
        escritor.close();
        System.out.println("Se escribió correctamente.");

    } catch (IOException e) {
        System.out.println("Ocurrió un error al manejar el archivo.");
        e.printStackTrace();
    }
}

    
}    


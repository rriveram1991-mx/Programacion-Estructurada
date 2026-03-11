import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Eje1archivo {
    public static void main(String[] args) {

        try {

            File archivo1 = new File("holapapa.txt");
            if (archivo1.createNewFile()) {
                System.out.println("Archivo creado: " + archivo1.getName());
            } else {
                System.out.println("El archivo ya existe");
            }

            FileWriter escribir1 = new FileWriter("holapapa.txt");
            escribir1.write("Nombre: Gael Adriel Alvarado de Avila\n");
            escribir1.write("Edad: 17 años\n");
            escribir1.write("Especialidad: programar\n");
            escribir1.write("Escuela: Universidad Tecnologica de Torreon\n");
            escribir1.write("Lenguaje favorito: Java\n");
            escribir1.close();


            File archivo2 = new File("holapapa2.txt");
            if (archivo2.createNewFile()) {
                System.out.println("Archivo creado: " + archivo2.getName());
            } else {
                System.out.println("El archivo ya existe");
            }

            FileWriter escribir2 = new FileWriter("holapapa2.txt");
           escribir2.write("Nombre: El chiquil\n");
           escribir2.write("Edad: 30 años\n");
           escribir2.write("Hobie: dormir\n");
           escribir2.write("Comida favorita: pizza\n");
           escribir2.close();

            System.out.println("Se escribio la informacion en los archivos");

        } catch (IOException e) {
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }
    }
}
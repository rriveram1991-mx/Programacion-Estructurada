import java.io.File;
 import java.io.FileWriter;
 import java.io.IOException;

public class Archiale {
public static void main(String[] args) {
    try {
        File miFile = new File("Marian.txt");
        if (miFile.createNewFile()) {
            System.out.println("Creado con exito"+ miFile.getName());}
            else {
                System.out.println("El archivo ya existe ");
            }

            FileWriter escritor = new FileWriter("Marian.txt");
            escritor.write("hola crayolaaaaaaaa");
            escritor.write("Te amo Mariaaaaan");
            escritor.close();
            System.out.println("Se escirbio correctamente ");

            
        } catch (IOException e) {
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }
    }
}    


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package archivos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author pecha
 */
public class Archivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {File myObj = new File("rauwalejandro.txt");
        if (myObj.createNewFile()) {
            System.out.println("Se ha creado el archivo: " + myObj.getName());
            } else {
  System.out.println("El archivo ya existe");
}
        FileWriter myWriter = new FileWriter("rauwalejandro.txt");
        myWriter.write("Raul Alejandro Martinez Velazquez\n");
        myWriter.write("18 años\n");
        myWriter.write("Desarrollo de Software Multiplataforma\n");
        myWriter.write("Universidad Tecnologica de Tierron\n");
        myWriter.write("Lenguaje favorito: Español JSKAKJAS\n");
        myWriter.write("PRUEBA 3\n");
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        }
    }
    


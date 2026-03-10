/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosingricardo48;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



/**
 *
 * @author yahir
 */
public class EjerciciosIngRicardo48 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File myObj = new File("trabajope.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
  System.out.println("File already exists.");
}
            FileWriter myWriter = new FileWriter("trabajope.txt");
            myWriter.write("Nombre del alumno: Yahir Asaed Gonzalez Nájera\n");
            myWriter.write("Edad: 18 años\n");
            myWriter.write("Especialidad: Desarrollo en Software Multiplataforma\n");
            myWriter.write("Escuela: Universidad Tecnológica de Torreón\n");
            myWriter.write("Lenguaje favorito: Pseint jajaja\n");
            myWriter.write("Dato aleatorio: Uso hacks en pokemon go porque me da hueva salir de mi casa");
            myWriter.close();
        }
        catch (IOException e) {
            System.out.println("Algo falló");
        }
            
        }
    
}

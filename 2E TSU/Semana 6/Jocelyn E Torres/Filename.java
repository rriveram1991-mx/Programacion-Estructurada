import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Filename {
  public static void main(String[] args) {
    try {
      File myObj = new File("filename.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }

      FileWriter myWriter = new FileWriter("filename.txt");
      myWriter.write("Hola Ricardo!\n");
      myWriter.write("Este archivo fue creado desde Java.\n");
      myWriter.write("Estamos practicando manejo de archivos.");
      myWriter.close();

      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}

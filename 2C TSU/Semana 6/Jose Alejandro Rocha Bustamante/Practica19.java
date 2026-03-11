import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Practica19 {
    public static void main(String[]args){
try{
    File doc = new File("Prueba.txt");
    if(doc.createNewFile()){
        System.out.println("File created: " + doc.getName());
    } 
    else {
        System.out.println("File already exitx");

    }
    FileWriter escribir = new FileWriter("Prueba.txt");
    escribir.write("Jose Alejandro Rocha Bustamante\n");
    escribir.write ("26 años \n");
    escribir.write("Tecnico en mantenimiento de computadoras \n");
    escribir.write("Universidad Tecnologica de Torreón \n");
    escribir.write("Lenguaje favorito java \n");
    escribir.close();
    System.out.println("Successfully wrote to the file.");

}
catch(IOException e){
    System.out.println("An error occurred.");
    e.printStackTrace();
    
    }
}
}
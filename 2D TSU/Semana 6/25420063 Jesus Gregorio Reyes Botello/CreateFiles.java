import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class CreateFiles{
public static void main(String[] args) {
try{
File myObj = new File("Aleatorio.txt");
if (myObj.createNewFile()){
System.out.println("File created: " + myObj.getName());
}else{
System.out.println("File already exists.");
}
FileWriter myWriter = new FileWriter("Aleatorio.txt");
myWriter.write("Black ops ||!\n");
myWriter.write("Pollo con Chipotle!\n");
myWriter.write("Son como niños 2!\n");
myWriter.write("Futbol!\n");
myWriter.write("Berserk!\n");
myWriter.close();
System.out.println("Successfully wrote to the file.");
} catch (IOException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
}
}
}
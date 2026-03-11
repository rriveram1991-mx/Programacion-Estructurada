import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class CreateFile{
public static void main(String[] args) {
try{
File myObj = new File("jess.txt");
if (myObj.createNewFile()){
System.out.println("File created: " + myObj.getName());
}else{
System.out.println("File already exists.");
}
FileWriter myWriter = new FileWriter("jess.txt");
myWriter.write("Jesus Gregorio Reyes Botello!\n");
myWriter.write("18!\n");
myWriter.write("Programacion!\n");
myWriter.write("UTT!\n");
myWriter.write("Java!\n");
myWriter.close();
System.out.println("Successfully wrote to the file.");
} catch (IOException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
}
}
}
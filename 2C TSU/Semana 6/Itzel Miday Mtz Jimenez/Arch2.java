
package arch2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Arch2 {
    public static void main(String[] args) {
       try{
           File ARCH2 = new File ("IMMJ.txt");
           if (ARCH2.createNewFile()){
               System.out.println("Archivo creado correctamente!");
           }else{
               System.out.println("El archivo ya existe.");
           }
           FileWriter E = new FileWriter("IMMJ.txt");
           E.write("holaaaaaa\n me llamo itzel\n me gustan los gatos\n" );
           E.write("tengo 4 gatos");
           E.close();
       }catch (IOException e){
           System.out.println("Error.");
           e.printStackTrace(); 
       }
    }
    
}

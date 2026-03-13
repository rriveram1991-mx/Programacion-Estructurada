
package arch;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Arch {
    public static void main(String[] args) {
      try{
           File ARCH = new File ("archjava.txt");
           if (ARCH.createNewFile()){
               System.out.println("Archivo creado.");
           }else{
               System.out.println("Este archivo ya existe.");
           }
           FileWriter E = new FileWriter("archjava.txt");
           E.write("Nombre: Itzel\n" );
             E.write("Edad: 17\n" );
               E.write("Especialidad: Desarrollo de Software Multiplataforma\n" );
                 E.write("Escuela: UTT\n" );
                   E.write("Lenguaje favorito: Java\n" );
           E.close();
       }catch (IOException e){
           System.out.println("Error.");
           e.printStackTrace(); 
       }
    }
    
}

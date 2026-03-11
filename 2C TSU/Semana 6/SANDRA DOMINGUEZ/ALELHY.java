
package alelhy;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ALELHY {
//SANDRA DOMINGUEZ
    
    public static void main(String[] args) {
         try 
        {
           File myObj = new File("ALELHY.txt"); 
           if (myObj.createNewFile()) 
           {
               System.out.println("ARCCHIVO CREADO: " + myObj.getName());
           }
           else 
           {
               System.out.println("EL ARCHIVO YA EXISTE");
           }
           FileWriter myWriter = new FileWriter("ALELHY.txt");
           
           myWriter.write("NOMBBRE: SANDRA ALELHY \n");
           myWriter.write("EDAD: 18\n");
           myWriter.write("COMIDA FAVORITA: TACOS\n");
           myWriter.write("GRUPO DE MUSICA FAVORITO: BLACKPINK\n");
           myWriter.write("HERMAN@S: 2 ");
           myWriter.close();
           System.out.println("TEXTO ESCRITO EN EL ARCHIVO");
        } catch (IOException e) 
        {
            System.out.println("OCURRIO UN ERROR");
            e.printStackTrace();
        }
      }
    }

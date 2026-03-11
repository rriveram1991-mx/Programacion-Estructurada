
package creacionarchivo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreacionArchivo {
//SANDRA DOMINGUEZ
    
    public static void main(String[] args) {
        try 
        {
           File myObj = new File("SADR.txt"); 
           if (myObj.createNewFile()) 
           {
               System.out.println("ARCCHIVO CREADO: " + myObj.getName());
           }
           else 
           {
               System.out.println("EL ARCHIVO YA EXISTE");
           }
           FileWriter myWriter = new FileWriter("SADR.txt");
           
           myWriter.write("NOMBBRE DEL ALUMNO: SANDRA ALELHY DMZ RDZ\n");
           myWriter.write("EDAD: 18\n");
           myWriter.write("ESPECIALIDAD: DESAROLLO DE SOFTWARE\n");
           myWriter.write("ESCUELA: UTT\n");
           myWriter.write("LENGUAJE FAVORITO: JAVA ");
           myWriter.close();
           System.out.println("TEXTO ESCRITO EN EL ARCHIVO");
        } catch (IOException e) 
        {
            System.out.println("OCURRIO UN ERROR");
            e.printStackTrace();
        }
       }
      }
    


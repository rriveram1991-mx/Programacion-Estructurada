import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class REQ1SEM62ERCC { 
    public static void main(String[] args) throws IOException {
    Scanner leer=new Scanner(System.in);
    File myobj=new File("datos1");
    System.out.println("ingresa nombre del alumno");
    String nombre=leer.nextLine();
    System.out.println("edad del alumno");
    int edad=leer.nextInt();
    System.out.println("carrera del alumno");
    leer.nextLine();
    String carrera=leer.nextLine();
    System.out.println("escuela del alumno");
    String escuela=leer.nextLine();
    System.out.println("lenguaje favorito del alumno");
    String lenguaje=leer.nextLine();
    System.out.println("color favorito del alumno");
    String color=leer.nextLine();
   try{ if (myobj.createNewFile()){
        System.out.println("archivo creado "+myobj.getName());
        } else {
        System.out.println("archivo existente "+myobj.getName());
    } 
    FileWriter escribir=new FileWriter("datos1");
    escribir.write("Nombre: " + nombre + "\n");
    escribir.write("Edad: " + edad + "\n");
    escribir.write("Carrera: " + carrera + "\n");
    escribir.write("Escuela: " + escuela + "\n");
    escribir.write("Lenguaje favorito: " + lenguaje + "\n");
    escribir.write("Color favorito: " + color + "\n");
    escribir.write("\n");
    escribir.close();
    System.out.println("Archivo escrito correctamente");
      } catch (IOException e) {
        System.out.println("Error al escribir el archivo");
    }
leer.close();
    }}

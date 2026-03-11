package cuatri2.unidad3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class sem6ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            
        try{
            String filename ;
            System.out.println("Escribe el nombre del archivo a crear: ");
            filename = sc.next();
            File myObj = new File(filename+".txt");
            
            
            System.out.println("Escribe el nombre del alumno");
            String nombre = sc.next();
            System.out.println("Ingrese la edad del alumno: ");
            int edad = sc.nextInt();
            System.out.println("Escribe la especialidad del alumno: ");
            String especialidad = sc.next();
            System.out.println("Ingresa la escuela en la que se encuentra el alumno: ");
            String escuela = sc.next();
            System.out.println("Ingresa tu lenguaje favorito: ");
            String lenguaje = sc.next();
            System.out.println("Ingresa tu genero");
            String genero = sc.next();

            if (myObj.createNewFile()) {
                System.out.println("Archivo creado : "+ myObj.getName());
            } else {
                System.out.println("El archivo"+myObj.getName() + "ya existe");
            }
            
            FileWriter myWriter = new FileWriter(filename+".txt");
            myWriter.write("-----DATOS-----\n");
            myWriter.write(("NOMBRE: "+nombre+"\n"));
            myWriter.write("EDAD: "+edad+"\n");
            myWriter.write("ESPECIALIDAD: "+especialidad+"\n");
            myWriter.write("ESCUELA: "+escuela+"\n");
            myWriter.write("LENGUAJE FAVORITO: "+lenguaje+"\n");
            myWriter.write("GENERO: "+genero+"\n");
            myWriter.close();
            System.out.println("Texto escrito en el archivo");
            
            } catch(IOException e){
            System.out.println("Ocurrio un error");
            e.printStackTrace();

        }
        
    }

}
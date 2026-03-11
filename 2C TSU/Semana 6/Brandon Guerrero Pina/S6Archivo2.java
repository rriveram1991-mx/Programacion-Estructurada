/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s6.archivo2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author UTT
 */
public class S6Archivo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  Scanner entrada = new Scanner(System.in);

    // Se utiliza un bloque try porque al trabajar con archivos pueden ocurrir errores
// Si ocurre algún problema el programa lo capturará en el bloque catch
try {

    // Se crea un objeto de la clase File llamado "archivo"
    // Este objeto representa un archivo llamado datos_personales.txt
    File archivo = new File("datos_personales.txt");

    // Se intenta crear el archivo físicamente en el sistema
    // createNewFile() devuelve true si el archivo se crea
    // devuelve false si el archivo ya existía
    if (archivo.createNewFile()) {

        // Si el archivo se creó correctamente se muestra un mensaje
        // getName() obtiene el nombre del archivo
        System.out.println("Archivo creado: " + archivo.getName());

    } else {

        // Si el archivo ya existía se muestra este mensaje
        System.out.println("El archivo ya existe.");
    }

    // A partir de aquí el programa pide información al usuario
    // utilizando el objeto Scanner llamado "entrada"

    // Solicita al usuario que escriba su nombre
    System.out.print("Ingrese su nombre: ");

    // nextLine() permite leer texto completo
    String nombre = entrada.nextLine();

    // Solicita la edad del usuario
    System.out.print("Ingrese su edad: ");

    // nextInt() permite leer números enteros
    int edad = entrada.nextInt();

    // nextLine() se usa para limpiar el buffer del teclado
    // Esto evita que se salten las siguientes entradas de texto
    entrada.nextLine();
    // Solicita la carrera del usuario
    System.out.print("Ingrese su carrera: ");
    String carrera = entrada.nextLine();
    // Solicita la película favorita
    System.out.print("Ingrese su película favorita: ");
    String pelicula = entrada.nextLine();
    // Solicita la canción favorita
    System.out.print("Ingrese su canción favorita: ");
    String cancion = entrada.nextLine();
    // Solicita la comida favorita
    System.out.print("Ingrese su comida favorita: ");
    String comida = entrada.nextLine();
    // Solicita la actividad favorita
    System.out.print("Ingrese su actividad favorita: ");
    String actividad = entrada.nextLine();
    // Solicita la materia favorita
    System.out.print("Ingrese su materia favorita: ");
    String materia = entrada.nextLine();
    // Solicita un aspecto que el usuario quiera mejorar de sí mismo
    System.out.print("Mencione un aspecto que le gustaría mejorar de usted: ");
    String mejorar = entrada.nextLine();
    // Solicita la opinión del usuario sobre la materia de programación estructurada
    System.out.print("Comparta su opinión acerca de la materia de Programación Estructurada: ");
    String opinion = entrada.nextLine();
    // Se crea un objeto FileWriter llamado "escribir
    // Este objeto permitirá escribir información dentro del archivo
    FileWriter escribir = new FileWriter("datos_personales.txt");
    // Se escribe un título dentro del archivo
    escribir.write("DATOS PERSONALES\n");
    // Se escribe una línea decorativa para separar el contenido
    escribir.write("-----------------------------\n");
    // Se escribe cada uno de los datos capturados del usuario
    escribir.write("Nombre: " + nombre + "\n");
    escribir.write("Edad: " + edad + "\n");
    escribir.write("Carrera: " + carrera + "\n");
    escribir.write("Pelicula favorita: " + pelicula + "\n");
    escribir.write("Cancion favorita: " + cancion + "\n");
    escribir.write("Comida favorita: " + comida + "\n");
    escribir.write("Actividad favorita: " + actividad + "\n");
    escribir.write("Materia favorita: " + materia + "\n");
    escribir.write("Aspecto que desea mejorar: " + mejorar + "\n");
    // Se agrega un apartado especial para la opinión sobre la materia
    escribir.write("\nOPINION SOBRE PROGRAMACIÓN ESTRUCTURADA\n");
    // Se escribe la opinión del usuario
    escribir.write(opinion + "\n");
    // Se cierra el archivo después de escribir
    // Esto es importante para guardar correctamente la información
    escribir.close();
    // Se muestra un mensaje indicando que los datos se guardaron correctamente
    System.out.println("Los datos se guardaron correctamente en el archivo.");
// Si ocurre algún error relacionado con archivos
// el programa entra en este bloque catch
} catch (IOException e)
{   // Se muestra un mensaje indicando que ocurrió un error
    System.out.println("Ocurrió un error.");
    // printStackTrace() muestra detalles técnicos del error
    // esto ayuda a identificar el problema
    e.printStackTrace();
    }
  }
}

    
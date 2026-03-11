import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class RegistroAlumno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        try (PrintWriter writer = new PrintWriter(new FileWriter("alumno.txt", true))) {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            sc.nextLine(); // Limpiar buffer
            System.out.print("Especialidad: ");
            String especialidad = sc.nextLine();
            System.out.print("Escuela: ");
            String escuela = sc.nextLine();
            System.out.print("Lenguaje favorito: ");
            String lenguaje = sc.nextLine();
            
            // Dato aleatorio (ejemplo: un folio de registro entre 1000 y 9999)
            int aleatorio = rand.nextInt(9000) + 1000;

            writer.println("Alumno: " + nombre + " | Edad: " + edad + 
                           " | Especialidad: " + especialidad + " | Escuela: " + escuela + 
                           " | Lenguaje: " + lenguaje + " | Folio Aleatorio: " + aleatorio);
            
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }
}

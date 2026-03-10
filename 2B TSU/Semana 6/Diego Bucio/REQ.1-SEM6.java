/**
 * Institución: Universidad Tecnológica de Torreón.
 * Carrera: Ingeniería en Desarrollo de Software.
 * Alumno: [Juan Diego Arroyo Bucio.]
 * Materia: Programación Estructurada.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // ==========================================
            // ARCHIVO 1: TUS DATOS REALES
            // ==========================================
            File archivoBucio = new File("Datos_Bucio.txt");

            // Verificamos si se crea o si ya existe
            if (archivoBucio.createNewFile()) {
                System.out.println("Archivo creado: " + archivoBucio.getName());
            } else {
                System.out.println("El archivo de Bucio ya existe. Se va a sobrescribir.");
            }

            // Escribimos línea por línea con el \n para dar enter
            FileWriter writerBucio = new FileWriter("Datos_Bucio.txt");
            writerBucio.write("Nombre del alumno: Juan Diego Arroyo Bucio\n");
            writerBucio.write("Edad: 18\n"); // Cámbiale a tu edad exacta w
            writerBucio.write("Especialidad: Ingeniería en Desarrollo de Software\n");
            writerBucio.write("Escuela: Universidad Tecnológica de Torreón (UTT)\n");
            writerBucio.write("Lenguaje favorito: C#\n");
            writerBucio.close(); // Siempre cerrar para guardar los cambios

            // ==========================================
            // ARCHIVO 2: EL ALEATORIO
            // ==========================================
            File archivoAleatorio = new File("Datos_Aleatorios.txt");
            archivoAleatorio.createNewFile();

            FileWriter writerAleatorio = new FileWriter("Datos_Aleatorios.txt");
            writerAleatorio.write("Nombre del alumno: Emiliano\n");
            writerAleatorio.write("Edad: 18\n");
            writerAleatorio.write("Especialidad: Técnico Superior Universitario\n");
            writerAleatorio.write("Escuela: UTT\n");
            writerAleatorio.write("Lenguaje favorito: Español, java, mujeres\n");
            writerAleatorio.close();

            System.out.println("Archivo aleatorio creado exitosamente.");
            System.out.println("¡Ambos archivos se generaron al cien!");

        } catch (IOException e) {
            // Por si Windows te bloquea los permisos o el disco está lleno
            System.out.println("Ocurrió un error fatal al intentar crear los archivos.");
            e.printStackTrace();
        }
    }
}
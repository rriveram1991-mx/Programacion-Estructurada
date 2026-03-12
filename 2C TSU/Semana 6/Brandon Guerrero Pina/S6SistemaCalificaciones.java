/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s6.sistemacalificaciones;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author brand
 */
public class S6SistemaCalificaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Se utiliza un bloque try para intentar ejecutar el código
        // Esto es necesario porque al trabajar con archivos pueden ocurrir errores
        try {
            
            // Se crea un objeto de tipo File llamado "archivo"
            // Este objeto representa el archivo calificaciones.txt dentro del sistema
            File archivo = new File("calificaciones.txt");
            
             // Verificar si el archivo ya existe en la carpeta
            if (archivo.exists()) {

                // Si el archivo ya existe, el programa muestra un mensaje
                // y no permite volver a crearlo ni sobrescribir su contenido
                System.out.println("El archivo ya existe. No se puede crear ni sobrescribir.");

            } else {
                // Si el archivo no existe, se crea un objeto FileWriter
                // Este objeto permitirá escribir información dentro del archivo
                FileWriter escribir = new FileWriter(archivo);

                // Se muestra un mensaje indicando que el archivo fue creado
                System.out.println("Archivo creado.");

                // Se escribe una línea inicial dentro del archivo
                escribir.write("Archivo de calificaciones creado correctamente\n");
                // Nombres de los alumnos
                // Se crea un arreglo que almacena los nombres de los alumnos
                String[] alumnos = {"Luis", "Jorge", "Lupita"};
                // Se crea un arreglo con los nombres de las materias
                String[] materias = {"Programacion","Redes","Bases de Datos"};
                // Se crea una matriz bidimensional que guarda las calificaciones
                // Cada fila representa un alumno
                // Cada columna representa una materia
                int[][] calificaciones = {
                {8,9,7},
                {10,9,9},
                {6,7,8}
                };
                // Este ciclo recorre cada alumno de la matriz
                for(int i = 0; i < calificaciones.length; i++) {

                // Se muestra en consola el nombre del alumno
                System.out.println("Alumno/a " + alumnos[i]);
                // Se escribe el nombre del alumno en el archivo
                escribir.write("Alumno " + alumnos[i] + "\n");

                // Se imprime en consola el texto "Calificaciones:"
                System.out.print("Calificaciones: ");
                escribir.write("Calificaciones: ");
                
                // Se crea una variable llamada suma para acumular las calificaciones
                int suma = 0;

                // Este segundo ciclo recorre cada materia del alumno
                for(int j = 0; j < calificaciones[i].length; j++) {

                    // Se imprime la calificacioon en la consola
                    System.out.print(calificaciones[i][j] + " ");
                    escribir.write(calificaciones[i][j] + " ");
                    // Se suma cada calificación para después calcular el promedio
                    suma += calificaciones[i][j];
                }

                // Se calcula el promedio del alumno
                // Se convierte la suma a decimal para obtener un resultado con decimales
                double promedio = (double)suma / calificaciones[i].length;

                // Se hace un salto de linea en la consola
                System.out.println();
                // Tambin se hace un salto de línea en el archivo
                escribir.write("/n");

                // Mostrar materia principal del alumno
                System.out.println("Materia: " + materias[i]);
                // Se escribe la materia dentro del archivo
                escribir.write("Materia: " + materias[i]);

                // Mostrar promedio
                // Se imprime el promedio del alumno mostrando solo un decimal
                System.out.printf("Promedio: %.1f\n", promedio);
                // Se guarda el promedio dentro del archivo
                escribir.write("Promedio: " + promedio + "\n");

                // Condición alumno destacado
                // Se verifica si el promedio del alumno es mayor o igual a 9
                if(promedio >= 9) {
                    // Si se cumple la condición se muestra el mensaje "Alumno destacado"
                    System.out.println("Alumno destacado");
                    // También se guarda este mensaje dentro del archivo
                    escribir.write("Alumno destacado");
                }
                // Se deja una lnea en blanco en la consola para separar alumnos
                System.out.println();
                //Se deja una linea en blanco dentro del archivo
                escribir.write("\n");
            }
            // Se muestra un mensaje indicando que los datos se guardaron correctamente
            System.out.println("Datos guardados en calificaciones.txt");
            
            // Se cierra el archivo para finalizar la escritura y guardar los cambios
            escribir.close();
            }
        } catch (IOException e) {
            // Este bloque catch captura cualquier error que ocurra
            // al crear o escribir en el archivo
            System.out.println("Ocurrió un error al guardar el archivo.");
            // Muestra información detallada del error para ayudar a identificar el problema
            e.printStackTrace();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemacalificaciones;

/**
 *
 * @author UTT
 */
import java.util.Scanner; // Permite leer datos del usuario
import java.io.FileWriter; // Permite escribir archivos
import java.io.IOException; // Permite manejar errores
import java.text.DecimalFormat; // Permite formatear decimales

public class REQ2_SEM6_AAFL_SistemaCalificaciones{

  public static void main(String[] args) { // Método principal donde inicia el programa

        Scanner sc = new Scanner(System.in); // Crear objeto Scanner para leer datos del usuario

        int alumnos = 3; // Variable que guarda el número de alumnos
        int materias = 3; // Variable que guarda el número de materias

        String[] nombres = new String[alumnos]; // Arreglo para guardar nombres de los alumnos
        String[] nombreMaterias = new String[materias]; // Arreglo para guardar nombres de las materias

        double[][] calificaciones = new double[alumnos][materias]; // Matriz que guardará las calificaciones de cada alumno

        DecimalFormat df = new DecimalFormat("#.00"); // Formato para mostrar números con solo 2 decimales

        // ===== PEDIR NOMBRE DE LAS MATERIAS =====
        for(int i=0;i<materias;i++){ // Ciclo que se repite según el número de materias

            while(true){ // Ciclo infinito que se repite hasta que el dato sea correcto

                System.out.print("Nombre de la materia " + (i+1) + ": "); // Solicita el nombre de la materia

                nombreMaterias[i] = sc.nextLine(); // Guarda el nombre de la materia en el arreglo

                if(nombreMaterias[i].matches("[a-zA-Z ]+")){ // Verifica que el texto solo tenga letras
                    break; // Si es correcto, sale del ciclo
                }else{
                    System.out.println("Error: solo letras."); // Mensaje de error si hay números o símbolos
                }

            }
        }

        // ===== PEDIR DATOS DE LOS ALUMNOS =====
        for(int i=0;i<alumnos;i++){ // Ciclo para recorrer cada alumno

            while(true){ // Repetir hasta que el nombre sea válido

                System.out.print("Nombre del alumno " + (i+1) + ": "); // Solicita nombre del alumno

                nombres[i] = sc.nextLine(); // Guarda el nombre en el arreglo

                if(nombres[i].matches("[a-zA-Z ]+")){ // Verifica que solo tenga letras
                    break; // Si es válido sale del ciclo
                }else{
                    System.out.println("Error: el nombre solo debe tener letras."); // Mensaje de error
                }

            }

            // ===== PEDIR CALIFICACIONES =====
            for(int j=0;j<materias;j++){ // Ciclo para recorrer las materias

                while(true){ // Repetir hasta que la calificación sea válida

                    System.out.print("Calificacion de " + nombreMaterias[j] + ": "); // Pide la calificación

                    if(sc.hasNextDouble()){ // Verifica si el usuario escribió un número decimal

                        double cal = sc.nextDouble(); // Guarda la calificación

                        if(cal >=0 && cal <=10){ // Verifica que la calificación esté entre 0 y 10

                            calificaciones[i][j] = cal; // Guarda la calificación en la matriz

                            sc.nextLine(); // Limpia el buffer del teclado

                            break; // Sale del ciclo si la calificación es válida

                        }else{
                            System.out.println("La calificacion debe estar entre 0 y 10."); // Error si está fuera del rango
                        }

                    }else{

                        System.out.println("Debe ingresar un numero."); // Error si el usuario escribe texto
                        sc.next(); // Limpia el dato incorrecto

                    }

                }

            }

            System.out.println(); // Imprime una línea en blanco para separar alumnos
        }

        // ===== CREAR ARCHIVO =====
        try{ // Bloque que intenta ejecutar código que puede producir error

            FileWriter archivo = new FileWriter("calificaciones.txt"); // Crea el archivo donde se guardarán los resultados

            // ===== RECORRER LOS ALUMNOS =====
            for(int i=0;i<alumnos;i++){ // Ciclo que recorre cada alumno

                double suma = 0; // Variable para sumar las calificaciones del alumno

                System.out.println("Alumno: " + nombres[i]); // Muestra el nombre del alumno
                archivo.write("Alumno: " + nombres[i] + "\n"); // Escribe el nombre en el archivo

                System.out.print("Calificaciones: "); // Muestra texto en consola
                archivo.write("Calificaciones: "); // Escribe el texto en el archivo

                for(int j=0;j<materias;j++){ // Recorre cada materia

                    double cal = calificaciones[i][j]; // Obtiene la calificación de la matriz

                    System.out.print(cal + " "); // Muestra la calificación en consola
                    archivo.write(cal + " "); // Guarda la calificación en el archivo

                    suma = suma + cal; // Suma la calificación al total
                }

                System.out.println(); // Salto de línea en consola
                archivo.write("\n"); // Salto de línea en archivo

                System.out.println("Materia: " + nombreMaterias[i]); // Muestra la materia principal del alumno
                archivo.write("Materia: " + nombreMaterias[i] + "\n"); // Guarda la materia en el archivo

                double promedio = suma / materias; // Calcula el promedio del alumno

                System.out.println("Promedio: " + df.format(promedio)); // Muestra promedio con 2 decimales
                archivo.write("Promedio: " + df.format(promedio) + "\n"); // Guarda promedio en el archivo

                if(promedio >= 9){ // Condicional para verificar si el alumno es destacado

                    System.out.println("Alumno destacado"); // Muestra mensaje en consola
                    archivo.write("Alumno destacado\n"); // Escribe mensaje en archivo

                }

                System.out.println(); // Línea vacía en consola
                archivo.write("\n"); // Línea vacía en archivo
            }

            archivo.close(); // Cierra el archivo después de escribir

            System.out.println("Archivo calificaciones.txt creado correctamente."); // Mensaje final

        }catch(IOException e){ // Captura errores si ocurre un problema con el archivo

            System.out.println("Error al escribir el archivo."); // Mensaje de error

        }

    }
}
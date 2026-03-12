/* Luis Manuel Aguilera Montoya
Desarrollar un sistema en Java que registre las calificaciones de 3 alumnos en 3 materias usando una matriz.
El programa debe guardar el resultado en un archivo llamado: calificaciones.txt

Datos del sistema:
Matriz de calificaciones: int[][] calificaciones = { {8,9,7}, {10,9,9}, {6,7,8} };
Cada fila representa un alumno y cada columna una materia.

El sistema debe:
Mostrar las calificaciones en consola.
Calcular el promedio de cada alumno.
Mostrar materia del alumno
Guardar los resultados en el archivo.
Requisitos técnicos

Debe usar:
* matriz [][], for, if, FileWriter, try-catch

Regla adicional: Si el promedio es mayor o igual a 9, escribir: Alumno destacado */


import java.io.File; // Se usa para crear, leer o manipular archivos y carpetas.
import java.io.FileWriter; // Se usa para escribir texto dentro de un archivo.
import java.io.IOException; //Se usa para manejar errores relacionados con archivos.

public class REQ2_SEM6_2C_SistemaCalificaciones
{
    public static void main(String[] args)
    {
        //Declarar arreglos
        int [][] calificaciones = {{8,9,7} , {10,9,9} , {6,7,8}}; //Cada conjunto es un alumno y con la calificacion de 3 materias
        double promedio[] = new double[calificaciones.length]; //El tamaño viene siendo 3
        String registro[] = new String[calificaciones.length];


        //For: Para crear arreglo Promedio[]
        for (int i = 0; i < registro.length; i++) //Para darle el promedio a cada alumno | i representa el alumno
        {
            double prom;
            int suma = 0; 

            for (int j = 0; j < registro.length; j++) //Para sumar las 3 calificaciones del alumno[i] | j representa la materia
            {
                suma += calificaciones[i][j]; 
            }

            prom = suma/(registro.length);
            promedio[i] = prom;
        }


        //For: Para crear arreglo Registro[]
        for (int i = 0; i < calificaciones.length; i++)
        {
            //Contenido del arreglo registro[]: Num alumno, calificaciones, promedio, posible alumno destacado. NOTA: (Los pude poner juntos pero preferi separados para que sea más legible)
            registro[i] = "\n----------------\nAlumno " + (i+1);
            registro[i] += "\n\nCalificaciones: \nProgramación = " + calificaciones[i][0] + "\nRedes = " + calificaciones[i][1] + "\nBase de datos = " + calificaciones[i][2];
            registro[i] += "\nPromedio = " + promedio[i]; 

            if (promedio[i] >= 9) //Si el promedio es mayor o igual a 9 añadir un renglon donde diga alumno destacado
                registro[i] += "\nAlumno Destacado!"; 

            System.out.println(registro[i]);
        }
        

        //CREACION DE CALIFICACIONES.TXT
        try
        {
            File miArchivo = new File("calificaciones.txt");

            if (miArchivo.createNewFile())
            {
                System.out.println("Archivo creado: " + miArchivo.getName());
            }
            else
            {
                System.out.println("El archivo ya existe...");
            }

            //Escritura del archivo
            FileWriter myWriter = new FileWriter("calificaciones.txt");
            for (String r : registro)   //ForEach: Para que me imprima cada posicion del arreglo registro[]
            {
                myWriter.write(r + "\n");    //Me escribe todo lo que tenga el arreglo
            }


            myWriter.close(); // Cierra el archivo después de escribir.
            System.out.println("\nSe escribio el archivo correctamente.");
        }
        catch (IOException e)
        {
            System.out.println("Ocurrio un error!"); 
            e.printStackTrace(); // Muestra información detallada del error.
        }
    }
}

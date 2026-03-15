/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cineerrores;

/**
 *
 * @author gl873
 */
import java.io.FileWriter; 
// Importa la clase para escribir datos en archivos

import java.io.IOException; 
// Importa la clase para manejar errores de entrada y salida

/**
 *
 * @author gl873
 */
public class DET1_SEM6_AAFL_CineErrores { 
// Declaracion de la clase principal

    public static void main(String[] args) { 
    // Metodo principal donde inicia el programa

        int[][] asientos = {
            {1,0,0},
            {1,1,0},
            {0,0,0}
        };
        // Arreglo bidimensional que representa los asientos del cine
        // 1 indica asiento ocupado y 0 asiento disponible

        int ocupados = 0;
        // Variable que contara cuantos asientos estan ocupados

        try {
        // Bloque que intenta ejecutar el codigo que puede generar errores

            FileWriter writer = new FileWriter("reporte_cine.txt");
            // Crea un archivo llamado reporte_cine.txt para guardar el reporte

            for (int i = 0; i < asientos.length; i++) {
            // Recorre cada fila del arreglo de asientos

                for (int j = 0; j < asientos[i].length; j++) {
                // Recorre cada columna dentro de la fila

                    writer.write(asientos[i][j] + " ");
                    // Escribe en el archivo el estado del asiento

                    if (asientos[i][j] == 1) {
                    // Verifica si el asiento esta ocupado

                        ocupados++;
                        // Incrementa el contador de asientos ocupados

                    }

                }

                writer.write("\n");
                // Salto de linea para separar las filas en el archivo

            }

            writer.write("Asientos ocupados: " + ocupados + "\n");
            // Escribe en el archivo el total de asientos ocupados

            writer.close();
            // Cierra el archivo para guardar correctamente la informacion
            System.out.println("Reporte del cine guardado correctamente");

        } catch (IOException e) {
        // Captura errores relacionados con archivos

            System.out.println("Error");
            // Muestra un mensaje si ocurre un error

        }

    }
}
//Codigo de Cine con errores señalados
/*
import java.io.FileWriter;
import java.io.IOException;

public class CineErrores ;

    public static void main(String[] args) {

        int[][] asientos = {
            {1,0,0},
            {1,1,0},
            {0,0,0}
        };

        int ocupados = 0;

        try {

            FileWriter writer = new FileWriter("reporte_cine.txt");

            for (int i = 0; i < asientos.length; i++) {

                for (int j = 0; j <= asientos[i].length; j++) {
                // ERROR 1: Se usa <= y provoca error de indice
                // Debe ser j < asientos[i].length

                    writer.write(asientos[i][j] + " ");

                    if (asientos[i][j] = 1) {
                    // ERROR 2: Se usa = que es asignacion
                    // Debe usarse == para comparar

                        ocupados++;

                    }

                }

                writer.write("\n")
                // ERROR 3: Falta punto y coma

            }

            writer.write("Asientos ocupados: " + ocupados + "\n");

            writer.close();

        } catch (IOException e) {

            System.out.println("Error");

        }

    }
}

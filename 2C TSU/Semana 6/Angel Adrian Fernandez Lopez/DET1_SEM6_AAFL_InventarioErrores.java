/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inventarioerrores;

/**
 *
 * @author gl873
 */
import java.io.FileWriter; 
// Importa la clase que permite escribir informacion en archivos

import java.io.IOException; 
// Importa la clase que permite manejar errores relacionados con archivos

/**
 *
 * @author gl873
 */
public class DET1_SEM6_AAFL_InventarioErrores { 
// Declaracion de la clase principal del programa

    public static void main(String[] args) { 
    // Metodo principal donde inicia la ejecucion del programa

        String[] productos = {"Mouse","Teclado","Monitor","USB","Laptop"};
        // Arreglo que guarda los nombres de los productos

        double[] precios = {200,350,3200,150,15000};
        // Arreglo que guarda los precios correspondientes a cada producto

        double total = 0;
        // Variable que almacenara la suma total del inventario

        try {
        // Bloque que intenta ejecutar el codigo que puede generar errores

            FileWriter writer = new FileWriter("inventario.txt");
            // Crea o abre un archivo llamado inventario.txt para escribir informacion

            for (int i = 0; i < productos.length; i++) {
            // Ciclo que recorre todos los elementos del arreglo productos

                writer.write("Producto: " + productos[i] + "\n");
                // Escribe en el archivo el nombre del producto

                writer.write("Precio: " + precios[i] + "\n");
                // Escribe en el archivo el precio del producto

                total += precios[i];
                // Suma el precio del producto al total del inventario

                if (precios[i] > 1000)
                // Verifica si el precio del producto es mayor a 1000

                    writer.write("Producto caro\n");
                    // Si el precio es mayor a 1000 escribe una advertencia en el archivo

                writer.write("\n");
                // Agrega una linea en blanco para separar productos

            }

            writer.close();
            // Cierra el archivo para guardar correctamente la informacion

            System.out.println("Inventario guardado");
            // Muestra un mensaje en consola indicando que el archivo se guardo

        } catch (IOException e) {
        // Captura errores relacionados con escritura o creacion del archivo

            System.out.println("Error al crear archivo");
            // Mensaje que aparece si ocurre un error

        }

    }
}
//Codigo con errores encontrados:
/*


import java.io.FileWriter;
import java.io.IOException;

public class InventarioErrores 

    public static void main(String[] args) {

        String[] productos = {"Mouse","Teclado","Monitor","USB","Laptop"};
        double[] precios = {200,350,3200,150,15000};

        double total = 0;

        try {

            FileWriter writer = new FileWriter("inventario.txt")
            // ERROR 1: Falta punto y coma

            for (int i = 0; i <= productos.length; i++) {
            // ERROR 2: Se usa <= y puede provocar que el indice salga del arreglo
            // Debe ser i < productos.length

                writer.write("Producto: " + productos[i] + "\n");
                writer.write("Precio: " + precios[i] + "\n");

                total =+ precios[i];
                // ERROR 3: Operador incorrecto
                // =+ no suma, solo asigna valor
                // Debe ser total += precios[i]

                if (precios[i] > 1000)
                    writer.write("Producto caro\n")
                    // ERROR 4: Falta punto y coma

                writer.write("\n");

            }

            writer.close;
            // ERROR 5: Falta llamar el metodo con parentesis

            System.out.println("Inventario guardado");

        } catch (IOException e) {

            System.out.println("Error al crear archivo");

        }

    }
}

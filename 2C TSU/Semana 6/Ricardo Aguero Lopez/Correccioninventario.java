/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package correccioninventario;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author aguer
 */
public class Correccioninventario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String[] productos = {"Mouse","Teclado","Monitor","USB","Laptop"};
        double[] precios = {200,350,3200,150,15000};

        double total = 0;

        try {

            FileWriter writer = new FileWriter("inventario.txt"); 
            // CORRECCIÓN 1: Se agregó ; al final de la línea

            for (int i = 0; i < productos.length; i++) { 
            //  Se cambió <= por < para evitar salir del tamaño del arreglo

                writer.write("Producto: " + productos[i] + "\n");
                writer.write("Precio: " + precios[i] + "\n");

                total += precios[i]; 
                //  Se cambió =+ por += para acumular correctamente el total

                if (precios[i] > 1000)
                    writer.write("Producto caro\n"); 
                    //  Se agregó ; al final de la instrucción

                writer.write("\n");

            }

            writer.close(); 
            //  Se agregaron () para llamar correctamente al método close

            System.out.println("Inventario guardado");

        } catch (IOException e) {

            System.out.println("Error al crear archivo");

        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication71;


}import java.io.FileWriter;
import java.io.IOException;

public class InventarioErrores {

    public static void main(String[] args) {

        String[] productos = {"Mouse", "Teclado", "Monitor", "USB", "Laptop"};
        double[] precios = {200, 350, 3200, 150, 15000};
        double total = 0;

        // se cierra el writer automaticamente
        try (FileWriter writer = new FileWriter("inventario.txt")) {

            for (int i = 0; i < productos.length; i++) { // en igual o menor que se sale de el arreglo

                writer.write("Producto: " + productos[i] + "\n");
                writer.write("Precio: " + precios[i] + "\n");

                total += precios[i]; //el sumador esta mal escrito
                if (precios[i] > 1000) {
                    writer.write("Producto caro\n");
                }

                writer.write("\n");
            }

            System.out.println("Inventario guardado. Total acumulado: " + total);

        } catch (IOException e) {
            System.out.println("Error al manejar el archivo: " + e.getMessage());
        }
    }
}
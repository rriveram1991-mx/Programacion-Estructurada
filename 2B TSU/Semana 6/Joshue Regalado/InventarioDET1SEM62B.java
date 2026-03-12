/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inventario.det.pkg1.sem6.pkg2b;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author jasun
 */
public class InventarioDET1SEM62B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         String[] productos = {"Mouse","Teclado","Monitor","USB","Laptop"};
         double[] precios = {200,350,3200,150,15000};

        double total = 0;

        try {
            File myObj = new File("inventario.txt");
            FileWriter writer = new FileWriter("inventario.txt");

            for (int i = 0; i < productos.length; i++) {

                writer.write("Producto: " + productos[i] + "\n");
                writer.write("Precio: " + precios[i] + "\n");

                total += precios[i];

                if (precios[i] > 1000)
                    writer.write("Producto caro\n");

                writer.write("\n");

            }
            writer.write("Total: $"+total); 
            writer.close();

            System.out.println("Inventario guardado");

        } catch (IOException e) {

            System.out.println("Error al crear archivo");
            e.printStackTrace();
        }

    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inventario;

import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author juang
 */
public class Inventario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        String[] productos = {"Mouse", "Teclado", "Monitor", "USB", "Laptop"};
        double[] precios = {250, 300, 4200, 250, 20000};

        double total = 0;

        try {

            FileWriter writer = new FileWriter("inventario.txt");

            for (int i = 0; i < productos.length; i++) {

                writer.write("Producto: " + productos[i] + "\n");
                writer.write("Precio: " + precios[i] + "\n");

                total += precios[i];

                if (precios[i] > 1000)
                    writer.write("Producto caro\n");

                writer.write("\n");
            }

            writer.close();

            System.out.println("Inventario guardado");
            System.out.println("Total del inventario: $" + total);

        } catch (IOException e) {
            System.out.println("Error al crear archivo");
        }
    }
    }
    

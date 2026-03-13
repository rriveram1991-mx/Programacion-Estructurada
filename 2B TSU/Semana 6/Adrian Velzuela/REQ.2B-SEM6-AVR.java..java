/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication44;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author adrianvalenzuelaramirez
 */
public class JavaApplication44 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String[] productos = {"mouse", "teclado", "monitor", "USB", "laptop"};
        double[] precios = {200, 350, 3200, 150, 15000};

        double total = 0;
        
            // 1: se agregó el punto y coma final
           try { FileWriter writer = new FileWriter("inventario.txt");

            // 2: se cambió '<=' por '<' para evitar error de índice
            for (int i = 0; i < productos.length; i++) {

                writer.write("producto: " + productos[i] + "\n");
                writer.write("precio: $" + precios[i] + "\n");

                // 3: se corrigió '=+' a '+=' para acumular el total
                total += precios[i];

                if (precios[i] > 1000) {
                    // 4: se agregó el punto y coma final
                    writer.write("estado: producto caro\n");
                }

                writer.write("\n");
            }

            writer.write("----------------------------\n");
            writer.write("total inventario: $" + total);

            // 5: se agregaron paréntesis para llamar al método close()
            writer.close();

            System.out.println("inventario guardado exitosamente.");
            System.out.println("monto total calculado: $" + total);

        } catch (IOException e) {
            System.out.println("error al crear archivo: " + e.getMessage());
        }
    }
}
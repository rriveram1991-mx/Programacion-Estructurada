/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s6.inventarioerror;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author LABTICS
 */
public class S6InventarioError {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String[] productos = {"Mouse","Teclado","Monitor","USB","Laptop"};
        double[] precios = {200,350,3200,150,15000};

        double total=0;
        try{
            // EROR 1:
            // Falta el punto y coma al final de la instrucciopn.
            // FileWriter writer = new FileWriter("inventario.txt")

            // CORRECCIÓN:
            FileWriter writer = new FileWriter("inventario.txt");

            /*
            ERROR 2:
            // La condición usa <= productos.length, lo que provocar
            // que no se haga correctamente el recorrido deel array
            // efor (int i = 0; i <= productos.length; i++)
            // CORRECCIÓN:
            */
            for (int i = 0; i < productos.length; i++) {

                writer.write("Producto: " + productos[i]+ "\n");
                writer.write("Precio: " + precios[i] +"\n");

                // ERROR 3:
                // El operador =+ no suma solo asigna el valor positivo.
                // total =+ precios[i];
                // CORRECCIoN:
                total += precios[i];

                // ERROR 4:
                // Falta punto y coma al final de la instrucción.
                // writer.write("Producto caro\n")
                // CORRECCIN:
                if (precios[i]> 1000)
                    writer.write("Producto caro");
                writer.write("\n");            }
            // ERROR5:
            // El mtodo close no tiene parentesis.
            // writer.close;
            // CORRECCIÓN:
            writer.close();
            System.out.println("Inventario guardado");
       } catch (IOException e) 
        {
            System.out.println("Error al crer archivo");
        }
    }
}
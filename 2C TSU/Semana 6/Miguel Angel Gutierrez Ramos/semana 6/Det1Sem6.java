/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det1sem6;
import java.io.FileWriter;
import java.io.IOException;
public class Det1Sem6 {

    public static void main(String[] args) {

        String[] productos = {"Mouse","Teclado","Monitor","USB","Laptop"};
        double[] precios = {200,350,3200,150,15000};

        double total = 0;

        try {

            FileWriter writer = new FileWriter("inventario.txt"); //faltaba ; aqui

            for (int i = 0; i < productos.length; i++)//Aqui no se debe de poner <=
            {

                writer.write("Producto: " + productos[i] + "\n");
                writer.write("Precio: " + precios[i] + "\n");

                total += precios[i]; //Aqui deberia ser += en vez de =+

                if (precios[i] > 1000)
                    writer.write("Producto caro\n"); //faltaba punto y coma aqui 

                writer.write("\n");

            }

            writer.close(); //Aqui debe de llevar parentesis.

            System.out.println("Inventario guardado");

        } catch (IOException e) {

            System.out.println("Error al crear archivo");

        }

    }
}

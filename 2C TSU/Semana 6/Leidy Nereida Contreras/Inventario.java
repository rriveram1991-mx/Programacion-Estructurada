/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inventario;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
/**
 *
 * @author leidy
 */

public class Inventario {

    public static void main(String[] args) {

        String[] productos = {"Mouse","Teclado","Monitor","USB","Laptop"};
        double[] precios = {200,350,3200,150,15000};

        double total = 0;
        File inv=new File("inventario.txt");//CREAR CARPETA
        try {
              if(inv.createNewFile()){
                  System.out.println("ESTE ARCHIVO HA SIDO CREADO");
              }
              else{
                  System.out.println("ARCHIVO GUARDADO");
              }
            FileWriter writer = new FileWriter("inventario.txt"); //falto ";" para cerrar esta linea de codigo.

            for (int i = 0; i <productos.length; i++) {// el indice dice menor o igual, debe ser solo menor para que cierre el leer
                //todos los datos.

                writer.write("Producto: " + productos[i] + "\n");
                writer.write("Precio: " + precios[i] + "\n");

                total +=precios[i];

                if (precios[i] > 1000)
                    writer.write("Producto caro\n");

                writer.write("\n");

            }

            writer.close();

            System.out.println("Inventario guardado");

        } catch (IOException e) {

            System.out.println("Error al crear archivo");

        }

    }
}
//LINEA DE CÓDIGO  41 FALTABA ";"
//LINEA DE CODIGO 35 FALTABA ";"
// FALTABA CREAR LA CARPETA ,OBJ         File inv=new File("inventario.txt");//CREAR CARPETA
//for (int i = 0; i <productos.length; i++) {// el indice dice menor o igual, debe ser solo menor para que cierre el leer,todos los datos
//agg la comparacion del createNewFile
//linea de codigo 35 en el sumador el + esta mal posicionado 
package s6_deteccionerrores1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class S6_DeteccionErrores1 {

    public static void main(String[] args) {
        
        String[] productos = {"Mouse", "Teclado", "Monitor", "USB", "Laptop"};
        double[] precios = {200, 350, 3200, 150, 15000};
        double total = 0;

        try {
            // 1. Crear el objeto File
            File myObj = new File("inventario.txt");
            if (myObj.createNewFile()) {
                System.out.println("Archivo creado: " + myObj.getName());
            } else {
                System.out.println("El archivo ya existe. Se sobrescribira.");
            }
            
            // 2. Inicializar el FileWriter
            // Para escribir en el archivo se tiene que usar myWriter, y falta el ;
            FileWriter myWriter = new FileWriter("inventario.txt");

            // 3. Escribir productos y calcular el total acumulado
            myWriter.write("--- LISTA DE INVENTARIO ---\n");
            
            for (int i = 0; i < productos.length; i++) {
                myWriter.write("Producto: " + productos[i] + "\n");
                myWriter.write("Precio: $" + precios[i] + "\n");

                total += precios[i]; 

                if (precios[i] > 1000) {
                    myWriter.write("Producto caro\n");
                }
                myWriter.write("---------------------------\n");
            }

            // 4. Escribir el total final fuera del bucle
            myWriter.write("\nTotal del inventario: $" + total + "\n");
            
            // 5. Cerrar el archivo fuera del bucle
            myWriter.close();
            
            System.out.println("Inventario guardado exitosamente.");

        } catch (IOException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }
    }   
}
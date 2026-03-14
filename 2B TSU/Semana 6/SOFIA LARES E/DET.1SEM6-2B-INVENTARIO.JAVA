import java.io.FileWriter;
import java.io.IOException;

public class InventarioErrores {

    public static void main(String[] args) {

        String[] productos = {"Mouse","Teclado","Monitor","USB","Laptop"};
        double[] precios = {200,350,3200,150,15000};

        double total = 0;

        try {
            // Error 1 : Agregado ";"
            FileWriter writer = new FileWriter("inventario.txt"); 

            // Error 2: Cambiado "<=" por "<"
            for (int i = 0; i < productos.length; i++) {

                writer.write("Producto: " + productos[i] + "\n");
                writer.write("Precio: " + precios[i] + "\n");

                // Error 3 : Cambiado "=+" por "+="
                total += precios[i];

                if (precios[i] > 1000) {
                    // Error 4 : Agregado ";"
                    writer.write("Producto caro\n");
                }

                writer.write("\n");
            }

            // Error 5: Agregado "()"
            writer.close();

            System.out.println("Inventario guardado. Total: " + total);

        } catch (IOException e) {
            System.out.println("Error al crear archivo");
        }
    }
}
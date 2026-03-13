import java.io.FileWriter;
import java.io.IOException;

public class InventarioErrores {
    public static void main(String[] args) {

        String[] productos = {"Mouse","Teclado","Monitor","USB","Laptop"};
        double[] precios = {200,350,3200,150,15000};

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

        } catch (IOException e) {
            System.out.println("Error al crear archivo");
        }
    }
}
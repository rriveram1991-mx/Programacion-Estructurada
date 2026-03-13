import java.io.FileWriter;
import java.io.IOException;

public class InventarioErrores {

    public static void main(String[] args) {

        String[] productos = {"Mouse","Teclado","Monitor","USB","Laptop"};
        double[] precios = {200,350,3200,150,15000};

        double total = 0;

        try {

            // ERROR 1: faltaba el punto y coma al final de la línea
            FileWriter writer = new FileWriter("inventario.txt");

            // ERROR 2: estaba <= productos.length lo que provoca ArrayIndexOutOfBounds
            // Se corrigió usando < productos.length
            for (int i = 0; i < productos.length; i++) {

                writer.write("Producto: " + productos[i] + "\n");
                writer.write("Precio: " + precios[i] + "\n");

                // ERROR 3: estaba escrito total =+ precios[i];
                // Esto no acumula correctamente. Se corrigió a +=
                total += precios[i];

                // ERROR 4: faltaba el punto y coma después de writer.write
                if (precios[i] > 1000)
                    writer.write("Producto caro\n");

                writer.write("\n");

            }

            // ERROR 5: estaba writer.close; sin paréntesis
            // Se corrigió llamando correctamente al método
            writer.close();

            System.out.println("Inventario guardado");
            System.out.println("Total inventario: " + total);

        } catch (IOException e) {

            System.out.println("Error al crear archivo");

        }

    }
}
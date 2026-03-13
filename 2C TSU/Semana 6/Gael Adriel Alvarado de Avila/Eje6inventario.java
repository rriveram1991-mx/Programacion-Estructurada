import java.io.FileWriter;
import java.io.IOException;

public class Eje6inventario {

    public static void main(String[] args) {

        String[] productos = {"Mouse","Teclado","Monitor","USB","Laptop"};
        double[] precios = {200,350,3200,150,15000};

        double total = 0;

        try {
            // Aqui agrege el ";"
            FileWriter writer = new FileWriter("inventario.txt");

            //  cambie el "<=" por "<" paraque funcione
            for (int i = 0; i < productos.length; i++) {

                writer.write("Producto: " + productos[i] + "\n");
                writer.write("Precio: " + precios[i] + "\n");

                // puse "+=" para que si sume los precios al total
                total += precios[i];

                if (precios[i] > 1000)
                    writer.write("Producto caro\n"); // Aqui tambien ya puse el";"

                writer.write("\n");

            }

            // Agregue esto para que el total si salga en el archivo txt
            writer.write("Total de todo: " + total);

            // Le hacian falta los "()" para que cierre bien el archivo
            writer.close();

            System.out.println("Inventario guardado");

        } catch (IOException e) {

            System.out.println("Error al crear archivo");

        }
    }
}
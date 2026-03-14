import java.io.FileWriter;
import java.io.IOException;

public class DET1SEM6 {

    public static void main(String[] args) {
        
        String[] productos = {"Mouse","Teclado","Monitor","USB","Laptop"};
        double[] precios = {200, 350, 3200, 150, 15000};
        double total = 0;
        try {

            FileWriter writer = new FileWriter("inventario.txt");
            //falta de punto y coma, error de sintaxis
          
            for (int i = 0; i < productos.length; i++) {
                //el mayor igual a, error de sintaxis

                writer.write("Producto: " + productos[i] + "\n");
                writer.write("Precio: " + precios[i] + "\n");

                total += precios[i];

                if (precios[i] > 1000){
                    writer.write("Producto caro\n");
                }
                //falta de llave, error de sintaxis

                writer.write("\n");

            }

            writer.close();
            //falta de parentesis, error de sintaxis
            System.out.println("Inventario guardado");
            System.out.println("Total: " + total);
            //mostar el total de los precios

        } catch (IOException e) {

            System.out.println("Error al crear archivo");

        }

    }
}

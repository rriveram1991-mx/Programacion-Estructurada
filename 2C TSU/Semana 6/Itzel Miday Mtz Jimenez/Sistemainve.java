
package sistemainve;
import java.io.FileWriter;
import java.io.IOException;
public class Sistemainve {
    public static void main(String[] args) {
        String[] productos = {"Mouse","Teclado","Monitor","USB","Laptop"};
        double[] precios = {200,350,3200,150,15000};

        double total = 0;

        try {

            FileWriter writer = new FileWriter("inventario.txt"); //Faltaba ";"
            for (int i = 0; i < productos.length; i++) { //Tiene que ser solo menor y no menor o igual

                writer.write("Producto: " + productos[i] + "\n");
                writer.write("Precio: " + precios[i] + "\n");

                total += precios[i]; //+ iba antes

                if (precios[i] > 1000)
                    writer.write("Producto caro\n");//Faltaba ";"

                writer.write("\n");
            }
            

            writer.close();//Faltaba ()
            
            System.out.println("Inventario guardado");
            System.out.println("Total: "+total);

        } catch (IOException e) {

            System.out.println("Error al crear archivo");

        }

    }
    
}

package error;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author nohem
 */
public class Error {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String[] productos = {"Mouse","Teclado","Monitor","USB","Laptop"};
        double[] precios = {200,350,3200,150,15000};

        double total = 0;
        
        try (FileWriter writer = new FileWriter("inventario.txt")) {

            for (int i = 0; i < productos.length; i++) {
                //se quita el = ya que despues causará eeror, intentrá acceder a un espacio que no existe

                writer.write("Producto: " + productos[i] + "\n");
                writer.write("Precio: " + precios[i] + "\n");

                total += precios[i];
                //para que funcione se usa +=, sino solo estaría asignando valor a la variable

                if (precios[i] > 1000){
                    writer.write("Producto caro\n");  //falta de corchetes y ;
                            }

                writer.write("\n");

            }

           //se quita el writer.close ya que al usar try, el archivo se cierra automaticamente
           
           writer.write("total del inventario:"+total+"\n");//el total se guarda para cumplir lo que requiere el sistema

            System.out.println("Inventario guardado.El total es de:"+total);

         }catch (IOException e) { //falta de corchete

            System.out.println("Error al crear archivo");
}}}

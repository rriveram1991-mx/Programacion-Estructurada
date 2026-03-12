
package inventario.sandra;
import java.io.FileWriter;
import java.io.IOException;

public class INVENTARIOSandra {
//SANDRA DOMINGUEZ
    
    public static void main(String[] args) {

        String[] productos = {"Mouse","Teclado","Monitor","USB","Laptop"};
        double[] precios = {200,350,3200,150,15000};

        double total = 0;

        try {

            FileWriter writer = new FileWriter("inventario.txt"); //ERROR1: FALTABA PUNTO Y COMA, PARA SABER DONDE TERMINA LA INSTRUCCIÓN.

            for (int i =0; i<productos.length; i++) //ERROR 2: TENIA UN =, NO SE DEBE USAR,POR QUE SE SALE DEL ARREGLO.
            {

                writer.write("Producto: " + productos[i] + "\n");
                writer.write("Precio: " + precios[i] + "\n");

                total += precios[i];  //ERROR 3: ESTABA ESCRITO AL REVES LO DE LA SUMA , TIENE QUE SER += PARA QUE FUNCIONE EL OPERADOR.

                if (precios[i] > 1000)
                    writer.write("Producto caro\n"); //ERROR 4: FALTABA PUNTO Y COMA, PARA CERRAR LA INSTRUCCIÓN.

                writer.write("\n");
            }
            System.out.println("TOTAL INVENTARIO:$"+total+"\n");
            writer.close();  //ERROR 5: EN EL writer.close; FALTABAN LOS PARENTESIS.

            System.out.println("Inventario guardado");

        } catch (IOException e)
        {
            System.out.println("Error al crear archivo");
        }
    }
}
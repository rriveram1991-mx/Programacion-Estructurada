import java.io.FileWriter;
import java.io.IOException;
//Falta un import
import java.io.File;
public class InventarioErrores {

    public static void main(String[] args) {

        String[] productos = {"Mouse","Teclado","Monitor","USB","Laptop"};
        double[] precios = {200,350,3200,150,15000};

        double total = 0;

        try {
            //Falta crear el File con el New File 
            File miFile =  new File ("Inventario.txt");

            if(miFile.createNewFile()){
                System.out.println("Se creo el archivo ");

            }
            else {
                 System.out.println("El archivo ya existe ");
            }
            
            //Falta punto y coma 

            FileWriter writer = new FileWriter("Inventario.txt");
         
            
//Habia menos igual en vez de igual 
            for (int i = 0; i <productos.length; i++) {

                writer.write("Producto: " + productos[i] + "\n");
                writer.write("Precio: " + precios[i] + "\n");

                total =+ precios[i];
                //Falta poner llaves 

                if (precios[i] > 1000){
                    //Falta punto y coma 
                    writer.write("Producto caro\n");
                }
                //Falto poner el total 
                writer.write("El total es de "+ total);

                writer.write("\n");
            }
            //Flataban parentesis para cerrarlos 
            writer.close();
            System.out.println("Inventario guardado");

        } catch (IOException e) {

            System.out.println("Error al crear archivo");
            //Falto poner el e stack
          e.printStackTrace();
        }

    }
}

    

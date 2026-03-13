/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det.pkg1.sem6;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author ssjoa
 */
public class DET1SEM6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        String[] productos = {"Mouse","Teclado","Monitor","USB","Laptop"};
        double[] precios = {200,350,3200,150,15000};

        double total = 0;

        try {
            FileWriter myWriter = new FileWriter("inventario.txt");/*falta punto y coma*/

            for (int i = 0; i < productos.length; i++)/*el igual arruina la sintaxis impidiendo que se cumplan los requerimientos para el bucle*/
            {

                myWriter.write("Producto: " + productos[i] + "\n");
                myWriter.write("Precio: " + precios[i] + "\n");

                total += precios[i];/*forma correcta de los operadores para dejar claro que el total es equivalente a los precios totales y no que total es igual a precios*/

                if (precios[i] > 1000)
              
                    myWriter.write("Producto caro\n");/*falta punto y coma*/

                myWriter.write("\n");
                
            }
                myWriter.write("Total" +  total + "\n");/*la variable total se ejecuta pero no se muestra*/

                myWriter.close();/*instruccion write mal señalizada*/


            System.out.println("Inventario guardado");

        } catch (IOException e) {

            System.out.println("Error al crear archivo");

        }

    }
}
        
        
        
        
        
        
        
        
        
        
        
    
    


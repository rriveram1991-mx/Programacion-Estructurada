/* Luis Manuel Aguilera Montoya

Sistema de inventario: YA CORREGIDO
El siguiente programa intenta crear un sistema que:
* Registre productos
* Guarde la información en un archivo
* Calcule el total del inventario 

ERRORES
1. Falta de punto y coma en FileWriter: En Java, cada instrucción debe terminar con ;.
2. Error de índice fuera de rango: En el ciclo for, como los arreglos en Java empiezan en 0, el último índice válido es length - 1.
3. Error en el operador de acumulación: Se escribio "total =+ precios[i]."" Esto no suma. El operador correcto es +=.
4. Falta de punto y coma en el bloque if: La línea writer.write("Producto caro\n") dentro del condicional le falta un ";".
5. Llamada incorrecta al método .close(): Para cerrar el archivo, debes usar paréntesis: writer.close();.
*/


import java.io.FileWriter;
import java.io.IOException;

public class DET1_SEM6_2C_SistemaInventario
{
    public static void main(String[] args)
    {

        String[] productos = {"Mouse", "Teclado", "Monitor", "USB", "Laptop"};
        double[] precios = {200, 350, 3200, 150, 15000};

        double total = 0;

        try
        {
            // Corrección 1: Añadido punto y coma
            FileWriter writer = new FileWriter("inventario.txt");

            // Corrección 2: Cambiado <= por < para evitar salir del rango del arreglo
            for (int i = 0; i < productos.length; i++)
            {

                writer.write("Producto: " + productos[i] + "\n");
                writer.write("Precio: " + precios[i] + "\n");

                // Corrección 3: Cambiado =+ por += para sumar correctamente
                total += precios[i];

                if (precios[i] > 1000)
                {
                    // Corrección 4: Añadido punto y coma
                    writer.write("Producto caro\n");
                }

                writer.write("\n");
            }

            // Escribimos el total al final del archivo para que el sistema esté completo
            writer.write("Total Inventario: " + total + "\n");

            // Corrección 5: Añadidos paréntesis para llamar al método close()
            writer.close();

            System.out.println("Inventario guardado. Total calculado: " + total);

        } catch (IOException e)
        {
            System.out.println("Error al crear archivo: " + e.getMessage());
        }
    }
}

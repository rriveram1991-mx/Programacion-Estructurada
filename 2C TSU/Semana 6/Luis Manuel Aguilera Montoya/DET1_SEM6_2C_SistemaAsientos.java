/* Luis Manuel Aguilera Montoya

Sistema de Asientos de Cine:  YA CORREGIDO
El siguiente programa intenta:
* Mostrar los asientos de un cine
* Contar los asientos ocupados
* Guardar el reporte en un archivo

ERRORES
1. Error de índice en el bucle interno: En la línea j <= asientos[i].length, el operador <= intentará acceder a una columna que no existe. Usar < asientos[i].length
2. Error de escritura de datos: El método writer.write(int) no escribe el número como texto (un "1" o un "0"). Para que se guarde el número visualmente, debemos convertirlo a String.
3. Error de comparación lógica: En el if (asientos[i][j] = 1), estás usando el operador de asignación (=) en lugar del operador de comparación (==).
4. Falta de punto y coma: La línea writer.write("\n") no tiene el ;
5. Error de lógica en el conteo de asientos: Si el programa fallara en el error #1 (índice fuera de rango), el conteo de asientos nunca terminaría de ejecutarse correctamente.*/


import java.io.FileWriter;
import java.io.IOException;

public class DET1_SEM6_2C_SistemaAsientos
{
    public static void main(String[] args)
    {

        int[][] asientos =
        {
            {1, 0, 0},
            {1, 1, 0},
            {0, 0, 0}
        };

        int ocupados = 0;

        try
        {
            FileWriter writer = new FileWriter("reporte_cine.txt");

            for (int i = 0; i < asientos.length; i++)
            {
                // Corrección 1: Se cambió <= por < para no salir del límite de columnas
                for (int j = 0; j < asientos[i].length; j++)
                {

                    // Corrección 2: Convertimos el número a String para que se escriba el dígito
                    writer.write(String.valueOf(asientos[i][j]) + " ");

                    // Corrección 3: Usamos == para comparar, no = para asignar
                    if (asientos[i][j] == 1)
                    {
                        ocupados++;
                    }
                }
                // Corrección 4: Añadido punto y coma faltante
                writer.write("\n");
            }

            writer.write("Asientos ocupados: " + ocupados + "\n");
            writer.close();
            System.out.println("Reporte generado con éxito. Asientos ocupados: " + ocupados);

        } catch (IOException e)
        {
            // Corrección 5: Es mejor imprimir el error real para saber qué falló
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}

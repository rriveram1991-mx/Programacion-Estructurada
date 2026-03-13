/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s6.cineerror;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author LABTICS
 */
public class S6CineError {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] asientos = {
            {1,0,0},
            {1,1,0},
            {0,0,0}
        };

        int ocupados = 0;

        try {

            FileWriter escribir = new FileWriter("reporte_cine.txt");
            
              // Mostrar encabezado de columnas
            System.out.print(" A B C\n");
            escribir.write(" A B C\n");

            for (int i = 0; i < asientos.length; i++){
                escribir.write((i + 1) + " ");
               
                // ERROR 1:
                // Se usa <= asientos[i].length, lo que provocará
                // ArrayIndexOutOfBoundsException porque el último índice válido es length - 1.
                // for (int j = 0; j <= asientos[i].length; j++)

                // CORRECCIÓN:
                for (int j = 0; j < asientos[i].length; j++) {

                    
                    System.out.print(asientos[i][j] + " ");
                    escribir.write(asientos[i][j] + " ");
                    // ERROR 2:
                    // Se usa = (asignación) en lugar de == (comparación).
                    // Esto provoca error de compilación porque el if necesita
                    // una expresión booleana.
                    // if (asientos[i][j] = 1)

                    // CORRECCIÓN:
                    if (asientos[i][j] == 1) {
                        ocupados++;
                    }
                }
        
                // ERROR 3:
                // Falta el punto y coma al final de la instrucción.
                // writer.write("\n")

                // CORRECCIÓN:
                
                System.out.println();
                escribir.write("\n");
            }

            // ERROR 4:
            // El programa guarda los asientos en el archivo pero no los muestra
            // en consola, aunque el objetivo es "mostrar los asientos del cine".
            // CORRECCIÓN posible: imprimir también en pantalla con System.out.print()

            // ERROR 5:
            // El total de asientos ocupados solo se guarda en el archivo
            // y no se muestra al usuario en consola.
            // CORRECCIÓN posible: usar System.out.println para mostrar el resultado.

            escribir.write("Asientos ocupados: " + ocupados + "\n");
            System.out.println("Asientos ocupados: " + ocupados);
            System.out.println("Se guardo correctamente el reportee");

            escribir.close();

        } catch (IOException e) {

            System.out.println("Error al crear el archivo");

        }

    }
}
 
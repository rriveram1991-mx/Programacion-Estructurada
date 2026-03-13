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

        int[][] asientos = {
            {1,0,0},
            {1,1,0},
            {0,0,0}
        };

        int ocupados = 0;

        
             //se cambia por un try-with-resources, se cierra solo
            try (FileWriter writer = new FileWriter("reporte_cine.txt")) {
                for (int i = 0; i < asientos.length; i++) {
                    
                    for (int j = 0; j < asientos[i].length; j++) {
                        //se quita el = para que no haya error en el codigo
                        writer.write(asientos[i][j] + " ");
                        
                        if (asientos[i][j] == 1) {
                            //se pone == para que se haga una comparación y no se asigne el valor en lugar de comparar para ver si se cumple la condicion
                            ocupados++;
                        }
                        
                    }
                    
                    writer.write("\n"); //falta de ;
                            
                            }
                //se agrega para que el usuario sepa que el reporte se guardó exitosamente en el archivo txt
                writer.write("Asientos ocupados: " + ocupados + "\n");
                System.out.println("reporte guardado. Total de asientos ocupados:"+ocupados);
            } catch (IOException e) {

            System.out.println("Error");

        }

    }
}
     

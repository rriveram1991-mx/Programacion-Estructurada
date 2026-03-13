package asientoscine;

import java.io.FileWriter;
import java.io.IOException;

public class ASIENTOScine {
    public static void main(String[] args) {
        
        int[][] asientos = {
            {1,0,0},
            {1,1,0},
            {0,0,0}
        };

        int ocupados = 0;

        try {

            FileWriter writer = new FileWriter("reporte_cine.txt");

            for (var asiento : asientos) { //Se cambia estructura
                for (int j = 0; j < asiento.length; j++) { //debe ser menor
                    writer.write(asiento[j] + " ");
                    if (asiento[j] == 1) { //Debe ser ==
                        ocupados++;
                    }
                }
                writer.write("\n");//Faltaba ";"
                        
                        }

            writer.write("Asientos ocupados: " + ocupados + "\n");

            writer.close();

        } catch (IOException e) {

            System.out.println("Error");

        }
    }
    
}
//se borra el ```</div>

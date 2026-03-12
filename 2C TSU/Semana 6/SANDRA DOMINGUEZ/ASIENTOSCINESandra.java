
package asientoscine.sandra;
import java.io.FileWriter;
import java.io.IOException;

public class ASIENTOSCINESandra {
//SANDRA DOMINGUEZ
    
    public static void main(String[] args) {

        int[][] asientos = {
            {1,0,0},
            {1,1,0},
            {0,0,0}
        };

        int ocupados = 0;

        try {

            FileWriter writer = new FileWriter("reporte_cine.txt");

            for (int i = 0; i < asientos.length; i++) {

                for (int j = 0; j <asientos[i].length; j++)  //ERROR 1: TENIA UN =, SI LO PONGO AFECTA EL ARREGLO.
                {
                    System.out.println(asientos[i][j] + " ");  //ERROR 4: FALTABA AGREGAR ESTA LINEA DEL System, PARA QUE IMPRIMA
                    writer.write(asientos[i][j] + " ");

                    if (asientos[i][j] == 1)  //ERROR 2: FALTABA =, DEBEN SER 2, PARA PODER COMPARAR. 
                    {
                        ocupados++;
                    }

                }

                writer.write("\n");  //ERROR 3: FALTABA PUNTO Y COMA, PARA CERRAR INSTRUCCIÓN

            }

            writer.write("Asientos ocupados: " + ocupados + "\n");

            writer.close();

        } catch (IOException e) 
        {

            System.out.println("Error");  

        }

    }
}
//ERROR 5: AL FINAL TENIA ESO, PERO NO DEBE DE IR  ```</div> 

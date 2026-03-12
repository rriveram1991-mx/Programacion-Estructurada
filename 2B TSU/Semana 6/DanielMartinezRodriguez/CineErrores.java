import java.io.FileWriter;
import java.io.IOException;
//Falta un import da java 
import java.io.File;

public class CineErrores {

    public static void main(String[] args) {

        int[][] asientos = {
            {1,0,0},
            {1,1,0},
            {0,0,0}
        };

        int ocupados = 0;

        try {
            //Falto crear el file 
            File mFile=new File ("reporte_cine.txt");
            if (mFile.createNewFile()){
                System.out.println("Se creo el archivo ");
            }
            else {
                System.out.println("Archivo ya creado ");
            }


            FileWriter writer = new FileWriter("reporte_cine.txt");

            for (int i = 0; i < asientos.length; i++) {
                //quitar el menor igual
                for (int j = 0; j < asientos[i].length; j++) {

                    writer.write(asientos[i][j] + " ");
                    //Faltaba poner el ==1 

                    if (asientos[i][j] == 1) {
                        ocupados++;
                    }

                }
                //Falta poner ;
                writer.write("\n");

            }

            writer.write("Asientos ocupados: " + ocupados + "\n");

            writer.close();
            //falto poner el mensaje de guardado 
            System.out.println("Guardado ");

        } catch (IOException e) {

            System.out.println("Error");
            //Falta el e stack
            e.printStackTrace();

        }

    }
}

    


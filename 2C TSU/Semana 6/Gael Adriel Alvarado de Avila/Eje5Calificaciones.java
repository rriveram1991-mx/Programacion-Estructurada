import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Eje5Calificaciones {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        String[] ALU = {"Alumno 1","Alumno 2","Alumno 3"};
        String[] MAT = {"Redes","Programacion","Sistemas"};

        double[][] CAL = new double[3][3];

        for(int i=0;i<3;i++){

            System.out.println("Registro de "+ALU[i]);

            for(int j=0;j<3;j++){

                System.out.print("Ingrese calificacion de "+MAT[j]+": ");
                CAL[i][j] = leer.nextDouble();

            }

            System.out.println();
        }

        System.out.println("===== REPORTE =====");

        for(int i=0;i<3;i++){

            double suma=0;

            System.out.println(ALU[i]);

            for(int j=0;j<3;j++){

                System.out.println(MAT[j]+": "+CAL[i][j]);
                suma = suma + CAL[i][j];

            }

            double promedio = suma/3;

            System.out.println("Promedio: "+promedio);

            if(promedio>=9){
                System.out.println("Alumno destacado");
            }

            System.out.println("------------------");

        }

        try{

            FileWriter E = new FileWriter("calificaciones.txt");

            for(int i=0;i<3;i++){

                double suma=0;

                E.write(ALU[i]+"\n");

                for(int j=0;j<3;j++){

                    E.write(MAT[j]+": "+CAL[i][j]+"\n");
                    suma = suma + CAL[i][j];

                }

                double promedio = suma/3;

                E.write("Promedio: "+promedio+"\n");

                if(promedio>=9){
                    E.write("Alumno destacado\n");
                }

                E.write("------------------\n");

            }

            E.close();
            System.out.println("Archivo guardado correctamente");

        }catch(IOException e){
            System.out.println("Error al escribir el archivo");
        }

    }
}
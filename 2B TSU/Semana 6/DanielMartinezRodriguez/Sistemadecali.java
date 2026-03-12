import java.util.Scanner;
import java.io.File;
 import java.io.FileWriter;
 import java.io.IOException;
public class Sistemadecali {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double [][] calificaciones = new double[3][3];
        double suma=0;
             double promedio =0;
             String [] materia =new String[3];

        for (int k = 0; k < materia.length; k++) {
            System.out.println("Ingrese el nombre de la materia " + (k + 1) + ":");
            materia[k] = scan.next();
        }


        for ( int i =0 ; i < 3 ; i++){
            suma = 0;
            System.out.println("Alumno "+ (i+1) );
            for (int j=0 ; j < calificaciones[i].length ; j++){
                System.out.println("Materia: " + materia[j]);
                System.out.println("Ingrese la calificación:");
                calificaciones[i][j] = scan.nextDouble();
                while (calificaciones[i][j] < 0 || calificaciones[i][j] > 10) {
                    System.out.println("Calificación inválida (0-10). Intente de nuevo:");
                    calificaciones[i][j] = scan.nextDouble();
                }
                suma += calificaciones[i][j];
            }
           promedio = suma / 3;
            System.out.println("El promedio es de "+ promedio);
            
            try {
                File mifFile = new File("Calificaciones.txt");
                if (mifFile.createNewFile()) {
                    System.out.println("Creado");}
                    else{
                        System.out.println("Cambiando archvio ");
                    }
                    FileWriter escritor = new FileWriter("Calificaciones.txt", true);
                    escritor.write("Alumno " + (i + 1) + ":\n");
                    for (int j = 0; j < 3; j++) {
                        escritor.write(" - " + materia[j] + ": " + calificaciones[i][j] + "\n");
                    }
                    escritor.write(" Promedio: " + promedio + "\n");
                    escritor.write("--------------------------\n");
                    escritor.close();
                } catch (IOException e) {
                    System.out.println("Error al escribir en el archivo");
                }
        }
        scan.close();
    }
}
    

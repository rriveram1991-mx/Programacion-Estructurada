import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Calificaciones {
    public static void main(String[] args) {
    
    
    int[][] calificaciones = {
    {8,9,7},
    {10,9,9},
    {6,7,8}
};

        double[] promedios = new double[3];
        for (int i = 0; i < 3; i++) {
            promedios[i] = (calificaciones[i][0] + calificaciones[i][1] + calificaciones[i][2]) / 3.0;
        }

    try {  
                File myObj = new File("calificaciones.txt");  
                if (myObj.createNewFile()) {  
                    System.out.println("Archivo creado: " + myObj.getName());  
                } else {  
                    System.out.println("El archivo ya existe.");  
                }  
            
            //Escribir en el archivo
                FileWriter myWriter = new FileWriter("calificaciones.txt");
                for (int i = 0; i < 3; i++) {
                myWriter.write("====================\n");
                myWriter.write("Alumno " + (i + 1) + "\n");
                myWriter.write("Calificaciones: " + calificaciones[i][0] + " " + calificaciones[i][1] + " " + calificaciones[i][2] + "\n");
                myWriter.write("Materia: Programacion\n");
                myWriter.write("Promedio: " + promedios[i] + "\n");
                                            
                    if(promedios[i] >= 9){
                        myWriter.write("Alumno destacador\n");
                    }else if(promedios[i] >= 7){
                        myWriter.write("Alumno aprobado\n");
                    }
                    else{
                        myWriter.write("Alumno reprobado\n");
                    }
                }

                myWriter.close();
                System.out.println("Archivo escrito exitosamente.");

            } catch (IOException e) {  
                System.out.println("Ocurrió un error.");  
                e.printStackTrace();  
            }  
        
    } 
}



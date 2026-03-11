import java.io.FileWriter;
import java.io.IOException;

public class calificaciones {
public static void main(String[] args){
    String[] nombres = {"Goyo", "Gabo", "Rodrigo"};
    String[] Materias = {"Programacion", "Redes", "Base de datos"};
    int[][] calificaciones = {
 {8,9,7},
 {10,9,9},
 {6,7,8}

};
try{
    //Creacion del archivo txt
     FileWriter archivo = new FileWriter("calificaciones.txt");
     //For para poder recorrer a los alumnos
     for (int i = 0; i < calificaciones.length; i++){
     int sum = 0;
     //Muestra a los alumnos
     System.out.println("Alumno " + nombres[i]);
     archivo.write("Alumno " + nombres[i] + "\n");

     System.out.print("Calificaciones: ");
     archivo.write("Calificaciones: ");
     //Recorre materias
     for (int j = 0; j < calificaciones[i].length; j++) {
    //Mostrar calificaciones en consola y en el txt
                    System.out.print(calificaciones[i][j] + " ");
                    archivo.write(calificaciones[i][j] + " ");
                // suma de las calificaciones
                    sum += calificaciones[i][j];
              
                }
                //operacion del promedio
                double prom = sum / calificaciones.length;
                //salto de linea
                 System.out.println();
                archivo.write("\n");
                //Mostrara las materias
                System.out.println("Materia: " + Materias[i]);
                archivo.write("Materia: " + Materias[i] + "\n");
                //Mostrar promedio
                System.out.println("Promedio: " + prom);
                archivo.write("Promedio: " + prom + "\n");
                 //Condicion que pide que si alumno tiene un promedio >= a 9 mostrar alumno destacado
                if (prom >= 9) {
                    System.out.println("Alumno destacado");
                    archivo.write("Alumno destacado\n");
                }
                //salto de liena
                System.out.println();
                archivo.write("\n");
     }     //fin del archivo
            archivo.close();
            System.out.println("Archivo guardado correctamente."); 
            //Manejo de errores    
     }catch (IOException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
}
}
}

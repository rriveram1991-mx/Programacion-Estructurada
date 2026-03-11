import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class REQ2SEM62ERCC {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int[][] calificaciones =new int[3][3];
        String[] materias=new String[3];
        String[] alumnos=new String[3];
        Double[] promedios=new Double[3];
     for (int i=0;i<3;i++){
         System.out.println("ingresa el nombre del alumno "+(i+1));
         alumnos[i]=leer.nextLine();
         System.out.println("ingresa el nombre de la materia");
         materias[i]=leer.nextLine();
            for (int j=0;j<3;j++){
                System.out.println("ingresa la calificacion de la unidad "+(j+1)+" de "+materias[i]);
                calificaciones[i][j]=leer.nextInt();
                leer.nextLine();
                while (calificaciones[i][j]<0 || calificaciones[i][j]>100){
                    System.out.println("calificacion no valida, ingresa nuevamente la calificacion");
                    calificaciones[i][j]=leer.nextInt();
                    leer.nextLine();
                } 
            }
            for  (int k=0;k<3;k++){
                promedios[i]=(double)(calificaciones[i][0]+calificaciones[i][1]+calificaciones[i][2])/3.0;
            }
     }
      for (int f=0;f<3;f++){
        System.out.println("------------------------------");
           System.out.println("alumno "+alumnos[f]);
              System.out.println("materia "+materias[f]);
              System.out.println("calificaciones "+calificaciones[f][0]+" "+calificaciones[f][1]+" "+calificaciones[f][2]);
              System.out.println("promedio "+promedios[f]);
              if (promedios[f]>=90){
                  System.out.println("alumno destacado");
              } else if (promedios[f]>=70){
                  System.out.println("alumno aprobado");
              } else {
                  System.out.println("alumno reprobado");
              } 

      }
       try {  File myobj = new File("calificaciones.txt");
       if (myobj.createNewFile()) {
                System.out.println("Archivo creado: " + myobj.getName());
            } else {
                System.out.println("Archivo ya existe: " + myobj.getName());
            }
            FileWriter escribir = new FileWriter("calificaciones.txt");
            for (int i = 0; i < 3; i++) {
                escribir.write("Alumno: " + alumnos[i] + "\n");
                escribir.write("Materia: " + materias[i] + "\n");
                escribir.write("Calificaciones: " + calificaciones[i][0] + ", " + calificaciones[i][1] + ", " + calificaciones[i][2] + "\n");
                escribir.write("Promedio: " + promedios[i] + "\n");
                if (promedios[i] >= 90) {
                    escribir.write("Alumno destacado\n\n");
                } else if (promedios[i] >= 70) {
                    escribir.write("Alumno aprobado\n\n");
                } else {
                    escribir.write("Alumno reprobado\n\n");
                }
            }
            escribir.close();
            System.out.println("Calificaciones guardadas en calificaciones.txt");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar las calificaciones: ");
        }
    leer.close();
    }
}

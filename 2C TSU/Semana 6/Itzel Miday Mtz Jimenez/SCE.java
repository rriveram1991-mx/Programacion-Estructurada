
package sce;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class SCE {
    public static void main(String[] args) {
      int X=0;
      double[] P = new double [3];
      int[][] CAL = {
 {8,9,7},
 {10,9,9},
 {6,7,8}
};
     X++;
      P[0]=(CAL[0][0]+ CAL[0][1]+CAL[0][2])/3;
        System.out.println("Promedio alumno "+X+": "+P[0]);
        X++;
         P[1]=(CAL[1][0]+ CAL[1][1]+CAL[1][2])/3;
         System.out.println("Promedio alumno "+X+": "+P[1]);
        X++;
         P[2]=(CAL[2][0]+ CAL[2][1]+CAL[2][2])/3;
         System.out.println("Promedio alumno "+X+": "+P[2]);
try{
    File CALI = new File ("Calificaciones.txt");
    if (CALI.createNewFile()){
               System.out.println("Archivo creado correctamente!");
           }else{
               System.out.println("El archivo ya existe.");
           }
           FileWriter E = new FileWriter("Calificaciones.txt");
           E.write("Alumno 1\n" );
           E.write("Promedio: "+P[0]+"\n");
           E.write("Calificaciones: "+CAL[0][0]+" "+CAL[0][1]+" "+CAL[0][2]+"\n");
           E.write("Materia: Programacion.\n");
            E.write("-------------------------------------------------------------------\n" );
           E.write("Alumno 2\n");
           E.write("Promedio: "+P[1]+"\n");
           E.write("Calificaciones: "+CAL[1][0]+" "+CAL[1][1]+" "+CAL[1][2]+"\n");
           E.write("Materia: Redes.\n");
           E.write("-------------------------------------------------------------------\n" );
           E.write("Alumno: 3\n" );
           E.write("Promedio: "+P[2]+"\n");
           E.write("Calificaciones: "+CAL[2][0]+" "+CAL[2][1]+" "+CAL[2][2]+"\n");
           E.write("Materia: Base de datos.");
           E.close();
       }catch (IOException e){
           System.out.println("Error.");
           e.printStackTrace(); 
       }
}


    }
    


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req2.sem5;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class REQ2SEM5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lee = new Scanner (System.in);
        String ma []=new String[3];
        double pro []=new double[3];
        String alu []={"Alumno 1","Alumno 2","Alumno 3"};
int[][] cal = {
 {8,9,7},
 {10,9,9},
 {6,7,8}
};

        System.out.println("Calificaciones del alumno 1: " + cal[0][0]+","+cal[0][1]+","+cal[0][2]);
         System.out.println("Calificaciones del alumno 2: " +cal[1][0]+","+cal[1][1]+","+cal[1][2]);
          System.out.println("Calificaciones del alumno 3: " +cal[2][0]+","+cal[2][1]+","+cal[2][2]);
        for(int i = 0; i < 3; i++) {
            System.out.println("Inserte la materia del alumno: "+(i+1));
            ma[i]= lee.next();
           pro[i] = (double)(cal[i][0] + cal[i][1] + cal[i][2]) / 3;
        }

try {
           File myObj=new File("ccalificacioness.txt");
           if (myObj.createNewFile()) {
               System.out.println("File created: " + myObj.getName());
           }else
           {
                 System.out.println("File already exists.");
           }
           for(int j = 0; j < 3; j++){
           FileWriter myWriter = new FileWriter("ccalificacioness.txt",true);
           myWriter.write(" "+alu[j]);
           myWriter.write("Calificaciones: "+ cal[j][0] + "," + cal[j][1] + "," + cal[j][2] + "\n");
           myWriter.write("Promedio: "+pro[j]+"\n");
           myWriter.write("Materia:"+ma[j]+"\n");
           if (pro[j]>=9){
           myWriter.write("Alumno destacado\n");}
           myWriter.close();
           System.out.println("Successfully wrote to the file.");
           System.out.println("El archivo se creará en: " + new File("ccalificacioness.txt").getAbsolutePath());}
           } catch (IOException e) {
               System.out.println("An error occurred.");
               e.printStackTrace();
                   }
}
}    
    
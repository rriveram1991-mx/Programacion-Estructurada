/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cinerror;
 import java.io.FileWriter;
import java.io.IOException;
import java.io.File; //falto importar el que permite la creacion de archivos/carpetas
/**
 *
 * @author leidy
 */
public class Cinerror {

    /**
     * @param args the command line arguments
     */
  
 


    public static void main(String[] args) {

        int[][] asientos = {
            {1,0,0},
            {1,1,0},
            {0,0,0}
        };

        int ocupados = 0;
             File arch = new File("reporte_cine.txt");//crear el archivo

        try {
if(arch.createNewFile()){ 
    System.out.println("ESTE ARCHIVO HA SIDO CREADO");
           // FileWriter writer = new FileWriter("reporte_cine.txt");
}
else{
    System.out.println("El archivo ya existe");
}
 FileWriter writer=new FileWriter("reporte_cine.txt");
            for (int i = 0; i < asientos.length; i++) {

                for (int j = 0; j < asientos[i].length; j++) {// no es necesario el menor o igual,es solo menor

                    writer.write(asientos[i][j] + " ");

                    if (asientos[i][j] ==1) {// se estaba haciendo una asgnacion no una comparación.
                        ocupados++;
                    }

                }
                

                writer.write("\n");

            }

            writer.write("Asientos ocupados: " + ocupados + "\n");

            writer.close();
}
         catch (IOException e) {

            System.out.println("Error");
            

        }

    }
}



//ERRORRES 
//1 LA IMPORTACION DE "IMPORT.JAVA.IO.FILE;" PERMOITE CREAR ARCHIVOS Y/O CARPETAS
//TAMBIEN FALTO CREAR LA CARPETA ,EL ARCHIVO" File arch = new File("reporte_cine.txt");//crear el archivo"
//TAMBIEN EN EL FOR DE INDICE J ,HAY UNA COMPARACION DE ≤ ESO NO ES NECESARIO POR Q EL CICLO NO CERRARA ,HABRA UN PUNTO E EL QUE AIOGUEN SIENDO IGUALES
//EN IF DE ASIENTOS[I][J] HAY UNA ASIGNACION CON UN VALOR ,POR QUE "=", es una asignacion y "==" una comparación.
//EN LA LINEA DE CODIGO 52 EL WRITE.WRITE NO ESTABA CERRADO ";"

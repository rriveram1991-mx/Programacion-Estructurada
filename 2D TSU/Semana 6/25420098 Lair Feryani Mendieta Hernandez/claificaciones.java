import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class claificaciones {

public static void main(String[] args) {
        
    int[][] calificaciones = {
 {8,9,7},
 {10,9,9},
 {6,7,8}
};

 double[] p = new double[3];
 for(int i=0;i<3;i++){
    p[i]=(calificaciones[i][0]+calificaciones[i][1]+calificaciones[i][2])/3;

 }
 try{
 File myObj = new File("filename.txt");
 if(myObj.createNewFile()){
    System.out.println("archivo creado: "+ myObj.getName());
 }else{
   System.out.println("el aerchivo ya existe");
 }
//escribo en el archivo
  FileWriter myWriter = new FileWriter ("calificaciones.txt");
  for (int i=0;i<3;i++){
  myWriter.write("calificaciones\n");
  myWriter.write("alumno "+(i+1)+"\n");
  myWriter.write("calificaciones: "+ calificaciones[i][0]+""+calificaciones[i][1]+""+calificaciones[i][2]);
  myWriter.write("programacion\n");
  myWriter.write("promedio: "+p[i]+"\n");
          if(p[i]>9){
            myWriter.write("alumno destacado");

          }else{

          }

  }
  myWriter.close();
  System.out.println("el archivo se creo bien");
 } catch (IOException e) {
    
 }
 }
}



import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class RTO1SEM72ERCC {
 public static void main(String[] args) {
     Scanner leer=new Scanner(System.in);
String[] estacionamientos={"LIBRE","LIBRE","LIBRE","LIBRE","LIBRE","LIBRE","LIBRE","LIBRE","LIBRE","LIBRE"};
boolean salir=false;
while (!salir){
   System.out.println("1.Ver estacionamiento\r\n" + //
              "2.Estacionar auto\r\n" + //
              "3.Retirar auto\r\n" + //
              "4.Contar espacios ocupados\r\n" + //
              "5.Salir");
    int opcion=leer.nextInt();
    switch (opcion){
        case 1: 
        for(int i=0;i<estacionamientos.length;i++){
              System.out.println("Espacio "+(i+1)+": "+estacionamientos[i]);
        } break;
        case 2: 
        System.out.println("Ingresa el numero del espacio donde deseas estacionar tu auto");
        int espacio=leer.nextInt();
        leer.nextLine();
        while(espacio<1 || espacio>10){
            System.out.println("Numero de espacio no valido, ingresa nuevamente el numero del espacio");
            espacio=leer.nextInt();
            leer.nextLine();
        }
       
            if(estacionamientos[espacio-1].equals("LIBRE")){
                estacionamientos[espacio-1]="OCUPADO";
                System.out.println("Auto estacionado en el espacio "+espacio);
                break;
            } else {
                System.out.println("Espacio "+espacio+" ocupado, ingresa otro numero de espacio");
                espacio=leer.nextInt();
                leer.nextLine();
            } break;
        case 3:
        System.out.println("Ingresa donde deseas retirar tu auto");
        int espacio2=leer.nextInt();
        leer.nextLine(); 
        while (espacio2<1 || espacio2>10){
            System.out.println("Numero de espacio no valido, ingresa nuevamente el numero del espacio");
            espacio2=leer.nextInt();
            leer.nextLine();
        }
            if(estacionamientos[espacio2-1].equals("OCUPADO")){
                estacionamientos[espacio2-1]="LIBRE";
                System.out.println("Auto retirado del espacio "+espacio2);
                break;
            } else {
                System.out.println("Espacio "+espacio2+" libre, ingresa otro numero de espacio");
                espacio2=leer.nextInt();
                leer.nextLine();
            } break;
        case 4: 
        int cont = 0;

        for(String est : estacionamientos){
            if(est.equals("OCUPADO")){
                cont++;
            }
             
        } System.out.println("Total de espacios ocupados: "+cont); break;
        case 5: salir=true;
        break;
     }
  } 
    try { File myobj = new File("estacionamiento.txt"); //creacion del archivo
       if (myobj.createNewFile()) { //verificacion de la creacion del archivo
                System.out.println("Archivo creado: " + myobj.getName());
            } else {
                System.out.println("Archivo ya existe: " + myobj.getName());
            }
            FileWriter escribir = new FileWriter("estacionamiento.txt"); //escritura de los datos en el archivo
            for(String num : estacionamientos){
                escribir.write("espacio: "+num+"\n");
            }
            escribir.close();
    } catch (IOException e) {
                System.out.println("Ocurrio un error al crear el archivo");
    }        
  leer.close();
    }
}

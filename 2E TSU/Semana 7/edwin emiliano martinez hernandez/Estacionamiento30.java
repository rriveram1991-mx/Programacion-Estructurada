/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estacionamiento3.pkg0;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author edwin
 */
public class Estacionamiento30 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Scanner xyz=new Scanner(System.in);
    String[] espacio=new String[10];
    for(int i=0; i<espacio.length;i++){
        espacio[i]="libre";
    }
   int opcion=0;
    while (opcion !=5){
        System.out.println("\n -----menu estacionamiento------");
        System.out.println("1.- ver estacionamiento");
        System.out.println("2.- estacionar auto");
        System.out.println("3.- retirar auto");
        System.out.println("4.- contar espacios ocupados");
        System.out.println("5.- salir");
        opcion=xyz.nextInt();
        switch(opcion) {
            case 1: for(int i=0; i<espacio.length;i++){
                System.out.println("espacio"+(i+1)+":"+espacio[i]);} 
         break;
         case 2 :System.out.println("ingrese espacios (1-10)");
                int lugar=xyz.nextInt();
             if (lugar>=1 && lugar<=10){
             if(espacio[lugar-1].equals("libre")){
             espacio[lugar-1]="ocupado";
                 System.out.println("estacionado correctamente");
             }else{
                 System.out.println("lugar ya ocupado");}
                 System.out.println("numero invalido");}
        break;
         case 3:
             System.out.println("ingresa el numero de espacio(1-10)");
        int retirar=xyz.nextInt();
        if(retirar>=1 && retirar<=10){
        if(espacio[retirar-1].equals("ocupado")){
        espacio[retirar-1]="libre";
            System.out.println("auto retirado correctamente");}
        else{
            System.out.println("el lugar ya esta libre");}
            System.out.println("numero invalido");}
        break;
         case 4: int contador=0;
        for(String espacios:espacio){
        if(espacios.equals("ocupado")){
        contador++;}}
        System.out.println("espacios ocupados:"+contador);
        break;
         case 5: try {
            FileWriter writer = new FileWriter("reporte_estacionamiento.txt");
            for (int i = 0; i < espacio.length; i++) {
            writer.write("Espacio " + (i + 1) + ": " + espacio[i] + "\n");
            }
            writer.close();
            System.out.println("Archivo TXT generado correctamente.");
            } catch (IOException e) {
            System.out.println("Error al crear el archivo.");
            }
            System.out.println("Saliendo del sistema...");
            break;
            default:
            System.out.println("Opcion invalida.");
}

        
      
       }
    }
    
}

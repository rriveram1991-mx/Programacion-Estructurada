/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package consultoriomedico;
import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * 
 */
public class Consultoriomedico {

    private static int pacientes;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner read=new Scanner(System.in);
        System.out.println("INGRESE EL TOTAL DE PACIENTES PARA HOY");
         int totalpac=read.nextInt();
    
       int [] pacientes = new int[totalpac];
        System.out.println("EL TOTAL DE PACIENTES ES " + pacientes.length);
               String [] names= new  String[totalpac];
               int [] edad= new int [totalpac];
               for ( int i=0; i<names.length;i++){
                   System.out.println("Ingrese el nombre del paciente " + (i +1 ));

                   names[i]=read.nextLine();
                   read.nextLine();
                   System.out.println("INGRESE LA EDAD DEL PACIENTE " + (i+1));
                   try{
                   edad[i]=read.nextInt();
                    if(edad[i]<1 || edad[i]>120){
                        System.out.println("EDAD INVALIDA");
                    }
                   else {
                           System.out.println("EDAD INGRESADA CORRECTAMENTE");
           
                           }
                   }catch(Exception e){
                            System.out.println("Solo se permiten Enteros");
                            i--;
                            }
               }
                   int menores=0 ,adultos=0,mayores=0;
                   
               for (int ed:edad){
                   if (ed<18){
                       menores++;
                        }
                   else if(ed<60){
                       adultos++;
                   }
                   else {
                       mayores++;
                   }
                   
               }
               System.out.println("EL TOTAL DE PACIOENTES EL DIA DE HOY :" + (totalpac));
               System.out.println("EL TOTAL DE PACIENTES MENORES DE EDAD EL DIA DE HOY:" + menores);
               System.out.println("EL TOTAL DE PACIENTES ADULTOS EL DIA DE HOY FUE:" + adultos);
               System.out.println("EL TOTAL DE PACIENTES MAYORES ,SIENDO ESTOS PRIORITARIO EL DIA DE HOY:" + mayores);
               
                    
                       }
}
   


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg1.sem5.pkg2d.ezco;

import java.util.Scanner;

/**
 *
 * @author Zoé
 */
public class REQ1SEM52DEZCO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         int menores=0;
         int adultos=0;
         int mayores=0;
        Scanner leer= new Scanner (System.in);
        System.out.println("Ingrese la cantidad de pacientes que se van a registrar:");
        int np = leer.nextInt();//leemos las personas en total 
        int[] edades=new int [np];//la cantidad de arreglos sera la cantidad de personas
        String[] nombres=new String[np];//aplica lo mismo
        for(int i=0;i<np; i++){//para el arreglo i tiene que mepezar en 0 y ser menor a np
             leer.nextLine();//limpiamos
            System.out.println("Ingrese el nombre del paciente "+(i+1) +":");
           nombres[i]=leer.nextLine(); 
            System.out.println("Ingrese la edad del paciente "+(i+1) +":");
            edades[i]=leer.nextInt();
            while (edades[i]<0 || edades[i]>120){//con while se repetira el mensaje hasta que se ponga una edad correcta
         if (edades[i] <0 || edades[i]>120){ 
            System.out.println("Por favor ingrese una edad valida");
            edades[i]=leer.nextInt();
         }
           }
      
         if (edades[i]<18){
             menores++;}//aqui empiezan los contadores segun sea la condicion
             else if(edades[i]<=59){
              adultos++; }               
             else if(edades[i]>=60){
             mayores++; }
         }
        System.out.println("Pacientes registrados:");
        int i=0;
        for (String nombre : nombres){
            System.out.println("Paciente:  " +nombre +" Edad : " +edades[i]);
            i=i+1;
        }
           System.out.println("Total de pacientes prioritarios: "+mayores);
       }
     }
   
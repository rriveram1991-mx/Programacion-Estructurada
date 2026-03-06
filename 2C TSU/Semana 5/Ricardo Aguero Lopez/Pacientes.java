/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pacientes;

import java.util.Scanner;

/**
 *
 * @author aguer
 */
public class Pacientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner leer= new Scanner (System.in);
        int reg;
         System.out.println("Ingresa cuantos pacientes deseas registrar ");
        reg=leer.nextInt();
        leer.nextLine();
        String [] nombres= new String [reg] ;
        int [] edades= new int [reg];
     
        
        
        for(int i=0; i < reg;i++){
            
            System.out.println("Ingresa el nombre del pacienete " +(i+1)+ ":");
            nombres[i]= leer.nextLine();
            
            System.out.println("Ingresa la edad del paciente "+(i+1)+ ":");
            edades[i]= leer.nextInt();
            leer.nextLine();
            while(edades[i] <0 || edades[i]>120){
                System.out.println("Edad invalida, Intenta de nuevo");
                edades[i]= leer.nextInt();
                
            }
            
            
            
        }
         
          
        for (int i=0; i<nombres.length;i++){
            System.out.println("-----------------Registro " +(i+1)+"----------------------");  
            System.out.println(" Nombre: "+ nombres[i]+ " Edad: "+ edades[i]);
            if(edades[i]>=60){
                System.out.println("Paciente Prioritario");
            }
            
             }
       int menores=0, mayores=0, prioritario=0;
       int j=0;
        while(j < edades.length ){
            if(edades[j]<18){
                 menores++;
              
                 
            }else if(edades[j]<=59){
                mayores++;
              
                
                
            }else {
                prioritario++;
               
            }
            j++;
            
        }
        System.out.println("---------------------------------------------------------");
          System.out.println("Cantidad de pacientes Menores/Adultos/Adultos Mayores/ Pacientes prioritarios");
        System.out.println("Menores de edad: "+ menores);
        System.out.println("Adultos: "+ mayores);
        System.out.println("Adultos mayores:" + prioritario);
        System.out.println("Pacientes prioritarios: "+prioritario);
            
     
 
    }
    
}

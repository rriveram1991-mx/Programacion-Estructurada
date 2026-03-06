/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospital;

import java.util.Scanner;

/**
 *
 * @author Brayan
 */
public class HOSPITAL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
        System.out.println("Cuantos pacientes desea registrar?");
        int pacientes = leer.nextInt();
        leer.nextLine();
        
        String[] nombres = new String [pacientes];
        int[] edades = new int [pacientes];
        
        for (int i = 0; i < pacientes; i++){
            System.out.println("Registro del paciente: "+(i+1));
            System.out.println("Nombre:");
            nombres[i] = leer.nextLine();
            
            int edadvalida = -1;
            while (edadvalida < 0 || edadvalida > 120){
                System.out.println("Edad: ");
                edadvalida = leer.nextInt();
                leer.nextLine();
                
                if (edadvalida < 0 || edadvalida > 120){
                    System.out.println("Edad invalida (edad valida es de 0 a 120 anos!");
                    
                }
                
            }
            edades [i] = edadvalida;
        }     
          int menores = 0, adultos = 0, adultosmayores = 0, prioritarios = 0; 
          System.out.println("[-------+--Resgistro de pacientes--+-------]");
          int indice = 0;
          for (int edad : edades){
          String nombreactual = nombres[indice];
              System.out.println("paciente: "+nombreactual +" edad: "+ edad);
              
              if (edad < 18){
              menores++;
              }else if (edad < 59){
                  adultos ++;
              }else{
              adultosmayores++;
              prioritarios++;
                  System.out.println("[Pacientes prioritarios]");
              }
              System.out.println();
              indice++;
          }
          System.out.println("menores de edad (18-): "            + menores);
          System.out.println("mayores de edad (18-59) : "        + adultos);
          System.out.println("Adultos mayores (60+) : "          + adultosmayores);
          System.out.println("Total de pacientes prioritarios: "+ prioritarios );
    }
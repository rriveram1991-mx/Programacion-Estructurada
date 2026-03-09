/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemahospital;

import java.util.Scanner;

/**
 *
 * @author Memer
 */
public class SistemaHospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lr = new Scanner (System.in);
        
        System.out.println("cuantos pacientes se registraran?");
        int pc = lr.nextInt();
        
        //declarar mis variables
        
        int menores = 0;
        int mayores = 0;
        int tercera = 0;
        int pcprio = 0;
        String nombres[] = new String [pc];
        int edades [] = new int [pc];
        
        
        //capturar nombre y edad
        for (int i = 0; i < edades.length; i++) {
            
             
            System.out.println("edad del paciente " + (i + 1) + " :" );
            edades[i] = lr.nextInt();
            
            
            //en caso de que la edad sea mas de 120 o negativo, lo invalida y le pregunta de nuevo
            if (edades[i] < 0 || edades[i] > 120) {
                System.out.println("edad invalida, ingrese una edad valida");
                edades[i] = lr.nextInt();
            }
            //ni siquiera yo se por que no jala sin esto, pero no le mueva, el Scanner es bien sensible 
            lr.nextLine();
            
            System.out.println("nombre del paciente " + (i + 1) + " :" );
            nombres[i] = lr.nextLine();
           
        }
        
        
        //for each para mostar los nombres de los pacientes registrados
        for (String mostrarPacientes : nombres) {
            System.out.println("PACIENTE:" + mostrarPacientes);
        }
        
        //for each para contar quien es menor, mayor y adulto mayor, ademas, de contar los pacientes prioritarios
        for (int edad : edades) {
            
            if (edad >= 0 && edad < 18) {
                
                menores++;
            }
            else if(edad >= 18 && edad < 60){
                mayores++;
            }
            else{
                tercera++;
                pcprio++;
            }
            
        }
        
        //muestro mis contares
        System.out.println("pacientes menores: " + menores);
        System.out.println("pacientes mayores: " + mayores);
        System.out.println("pacientes adultos mayores " + tercera);
        System.out.println("pacientes prioritario: " + pcprio);
        
    }
    
}

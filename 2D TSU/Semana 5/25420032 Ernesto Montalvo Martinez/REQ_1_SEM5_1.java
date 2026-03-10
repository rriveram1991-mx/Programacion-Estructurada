/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana5;

import java.util.Scanner;

/**
 *
 * @author Ernesto Montalvo
 */
public class REQ_1_SEM5_1 {
    public  static void main (String[]args){
    Scanner leer = new Scanner(System.in);
    
    System.out.print("Pacientes registrados: ");
    int n=leer.nextInt();
    leer.nextLine();
    
    String[] nombres = new String[n];
    int[] edades = new int[n];
    
     for (int i = 0; i < n; i++) {
            System.out.println("\nPaciente #" + (i + 1));

        System.out.println("Introduzca su nombre: ");
         nombres [i] = leer.nextLine();
        
        System.out.println("Introduzca su edad: ");
        edades [i] = leer.nextInt();
        

            while (edades[i] < 0 || edades[i] > 120) {
                if (edades[i] < 0 || edades[i] > 120) {
                    System.out.print("Ingrese una edad correcta: ");
                    edades[i] = leer.nextInt();
                }
            }

            leer.nextLine();
        }

        int menores = 0;
        int adultos = 0;
        int adultosMayores = 0;
        int prioritarios = 0;

          System.out.println("\nPacientes registrados");
int index=0;
        for (String nombre: nombres) {
        
int edad=edades[index];
            System.out.println("Nombre: " + nombre+ " Edad: "+edad);

            if (edad < 18) {
                menores++;
            } 
            else if (edad >= 18 && edad <= 59) {
                adultos++;
            } 
            else if (edad>=60){
                adultosMayores++;
                System.out.println("Paciente prioritario");
                prioritarios++;
            }
            index++;
        }
      
        
        System.out.println("Menores de edad: " + menores);
        System.out.println("Adultos (18-59): " + adultos);
        System.out.println("Adultos mayores (60 o más): " + adultosMayores);
        System.out.println("Total de pacientes prioritarios: " + prioritarios);

        leer.close();
    }
}

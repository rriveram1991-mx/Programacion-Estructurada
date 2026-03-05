/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req_sem5_2b_java_4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lex
 */
public class REQ_SEM5_2B_JAVA_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner leer = new Scanner(System.in);
        
        System.out.println("========BIENVENIDO========");
        System.out.println("\nCuantos pacientes desea registrar? : ");
        int n = leer.nextInt();
        
        //Creamos los array 
        String[] pacientes = new String[n];
        int[]edades = new int[n];
        
        //Inicialisamos variables
        int menores = 0;
        int adultos = 0;
        int mayores = 0;
        
        //pedimos los nombres en un ciclo
        for (int i = 0; i < n; i++){
            System.out.println("\n Paciente " + (i+1) + ": ");
            System.out.println("Nombre :");
            pacientes[i] = leer.next();
            System.out.println("Edad :");
            edades[i] = leer.nextInt();
            leer.nextLine(); //limpieza del buffer despues del numero
            
            while (edades[i] < 0 || edades[i] > 120){
                if (edades[i] < 0 || edades[i] > 120){
                    System.out.println("Edad invalida. Ingrese de nuevo: ");
                    edades[i] = leer.nextInt();
                }
            }
        }
        
        //Listado de los pacientes
        for (int i = 0; i < n; i++){
            if (edades[i] >= 60){
                mayores++;
                System.out.println("Paciente prioritario");
            } else if (edades[i] >= 18){
                adultos++;
            } else if (edades[i] < 18){
                menores++;
            }
            System.out.println("Paciente: " + pacientes[i] + " / Edad: " + edades[i]);
        }
        System.out.println("\n ======Registros del sistema======");
        System.out.println("Menores de edad: " + menores);
        System.out.println("Adultos: " + adultos);
        System.out.println("Mayores de edad: " + mayores);
        System.out.println("Pacientes prioritarios: " + mayores);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s5_pacientes;

import java.util.Scanner;

public class S5_Pacientes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Cme = 0, Ca = 0, Cam = 0, Cpp = 0;
        
        System.out.println("Ingresa la cantidad de pacientes:");
        int pacientes = sc.nextInt();
        sc.nextLine();
        
        String[] nombres = new String[pacientes];
        int[] edades = new int[pacientes];
        
        for (int i = 0; i < pacientes; i++){
            System.out.println("\n===== REGISTRO DEL PACIENTE " + (i + 1) + " =====");
            System.out.print("Nombre del paciente: ");
            nombres[i] = sc.nextLine();
            
            System.out.print("Edad del paciente: ");
            int edad = sc.nextInt();
            sc.nextLine();
                      
            while(edad < 0 || edad > 120){
                System.out.print("Edad invalida, intente nuevamente: ");
                edad = sc.nextInt();  
                sc.nextLine();
            }        
            
            // Contadores (edad)
            if(edad < 18){
                Cme++;
            }
            else if(edad <= 59){
                Ca++;
            }
            else{
                Cam++;
                Cpp++;
            }
            edades[i] = edad;            
        }
        
        // Mostrar pacientes
        System.out.println("\n===== PACIENTES REGISTRADOS =====");
        for (int i = 0; i < pacientes; i++){
            if(edades[i] >= 60){
                System.out.println("PACIENTE PRIORITARIO " + " Nombre: " + nombres[i] + " Edad: " + edades[i]);
            }
            else{
                System.out.println("Nombre: " + nombres[i] + " Edad: " + edades[i]);
            }
        }
        
            System.out.println("\nMenores de edad: " + Cme);
            System.out.println("Adultos: " + Ca);
            System.out.println("Adultos mayores: " + Cam);
            System.out.println("Pacientes prioritarios: " + Cpp);
    }
    
}

//public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    
//    System.out.println("Ingresa la cantidad de pacientes:");
//    int pacientes = sc.nextInt();
//    sc.nextLine(); // <-- LIMPIA EL BUFFER (consume el Enter sobrante)
//
//    String[] nombres = new String[pacientes];
//    int[] edades = new int[pacientes];
//    
//    for (int i = 0; i < pacientes; i++){
//        System.out.println("\n===== REGISTRO DEL PACIENTE " + (i + 1) + " =====");
//        
//        System.out.print("Nombre del paciente: ");
//        nombres[i] = sc.nextLine(); // Ahora sí se detendrá a esperar el nombre
//        
//        System.out.print("Edad del paciente: ");
//        int edad = sc.nextInt();
//        sc.nextLine(); // <-- LIMPIA EL BUFFER de nuevo para la siguiente vuelta del ciclo
//        
//        while(edad < 0 || edad > 120){
//            System.out.println("Edad invalida, intente nuevamente:");
//            edad = sc.nextInt();
//            sc.nextLine(); // También limpiar aquí si falla
//        }           
//        edades[i] = edad;           
//    }
//    
//    // Mostrar pacientes
//    System.out.println("\n===== PACIENTES REGISTRADOS =====");
//    for (int i = 0; i < pacientes; i++){
//        System.out.println("Nombre: " + nombres[i] + " | Edad: " + edades[i]);          
//    }
//}
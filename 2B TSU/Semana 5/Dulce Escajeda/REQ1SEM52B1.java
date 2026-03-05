/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg1.sem5.pkg2b.pkg1;

import java.util.Scanner;

/**
 *
 * @author lopez
 */
public class REQ1SEM52B1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner lr=new Scanner(System.in);
       // solicitar numero de pacientes
System.out.println("Ingrese numero de pacientes: ");
int pacientes = lr.nextInt(); 
lr.nextLine(); 
//arrays
String[] nombres = new String[pacientes];
int[] edades = new int[pacientes];
//captura de datos con for
for (int i = 0; i < pacientes; i++) {
    System.out.println("\nPaciente " + (i + 1) + ":");
    System.out.print("Ingrese Nombre: ");
    nombres[i] = lr.nextLine();

    System.out.print("Ingrese edad: ");
    int edading = lr.nextInt();


    while (edading < 0 || edading > 120) {
       if (edading < 0 || edading > 120) {
        System.out.println("Error: la edad debe estar entre 0 y 120.");
        System.out.print("Ingrese la edad nuevamente: ");
        edading = lr.nextInt();
      }
    }
    edades[i] = edading;
    lr.nextLine(); 
}
//analisis  
           int men=0,adul=0,may=0,prio=0;
           System.out.println("\n--- pacientes ---");
       int indice = 0;
        // Requisito: Usar for-each
        for (int edad : edades) {
            String nombre = nombres[indice];
            String tipo = "";

            if (edad < 18) {
                men++;
                tipo = "Menor de edad";
            } else if (edad <= 59) {
                adul++;
                tipo = "Adulto";
            } else {
                // Requisito: mayor o igual a 60 = Paciente prioritario
                may++;
                prio++;
                tipo = "Adulto mayor - Paciente prioritario";
            
            }

            System.out.println("Nombre: " + nombre + " | Edad: " + edad + " |" + tipo);
            indice++;
        }
        //resultado final
        System.out.println("\n--- Resumen Estadístico ---");
        System.out.println("Menores de edad: " + men);
        System.out.println("Adultos: " + adul);
        System.out.println("Adultos mayores: " + may);
        System.out.println("---------------------------");
        System.out.println("Total de pacientes prioritarios: " + prio);
    }
}

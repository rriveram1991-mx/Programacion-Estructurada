/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pacientes;

import java.util.Scanner;

/**
 *
 * @author mirel
 */
public class Pacientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        System.out.print("Cuantos pacientes se registraran? ");
        int cantidad = sc.nextInt();
        sc.nextLine(); 

        String[] nombres = new String[cantidad];
        int[] edades = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {

            System.out.println("\nPaciente " + (i + 1));

            System.out.print("Nombre: ");
            nombres[i] = sc.nextLine();

            System.out.print("Edad: ");
            edades[i] = sc.nextInt();

            while (edades[i] < 0 || edades[i] > 120) {
                if (edades[i] < 0 || edades[i] > 120) {
                    System.out.print("Edad invalida. Ingrese nuevamente: ");
                    edades[i] = sc.nextInt();
                }
            }

            sc.nextLine(); 
        }

        int menores = 0;
        int adultos = 0;
        int adultosMayores = 0;
        int prioritarios = 0;

        System.out.println("\nPacientes registrados:");

        for (String nombre : nombres) {
            System.out.println("Nombre: " + nombre);
        }

        for (int i = 0; i < edades.length; i++) {

            System.out.println("Edad: " + edades[i]);

            if (edades[i] < 18) {
                menores++;
            } 
            else if (edades[i] <= 59) {
                adultos++;
            } 
            else {
                adultosMayores++;
            }

            if (edades[i] >= 60) {
                System.out.println("Paciente prioritario");
                prioritarios++;
            }
        }

        // Resultados finales
        System.out.println("\nResumen:");
        System.out.println("Menores de edad: " + menores);
        System.out.println("Adultos: " + adultos);
        System.out.println("Adultos mayores: " + adultosMayores);
        System.out.println("Total de pacientes prioritarios: " + prioritarios);

        sc.close();
    }
}
    
    

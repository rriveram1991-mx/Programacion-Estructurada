/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pacientes;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Pacientes {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el numero de pacientes a regitrar: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        String[] nombres = new String[n];
        int[] edades = new int[n];

        // Ingreso de datos
        for (int i = 0; i < n; i++) {

            System.out.print("Nombre del paciente " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();

            System.out.print("Edad del paciente " + (i + 1) + ": ");
            edades[i] = sc.nextInt();

            // Validación de edad con while
            while (edades[i] < 0 && edades[i] > 120) {

                if (edades[i] < 0 && edades[i] > 120) {
                    System.out.println("Edad inválida. Ingrese nuevamente:");
                }

                edades[i] = sc.nextInt();
            }

            sc.nextLine();
        }

        int menores = 0;
        int adultos = 0;
        int adultosMayores = 0;
        int prioritarios = 0;

        System.out.println("Pacientes registrados:");

        // Mostrar con for-each
        for (String nombre : nombres) {
            System.out.println("Paciente: " + nombre);
        }
        for (int edad : edades) {

            if (edad < 18) {
                menores++;
            } 
            else if (edad >= 18 && edad <= 59) {
                adultos++;
            } 
            else {
                adultosMayores++;
                prioritarios++;
                System.out.println("Paciente prioritario");
            }
        }

        System.out.println("Menores de edad: " + menores);
        System.out.println("Adultos: " + adultos);
        System.out.println("Adultos mayores: " + adultosMayores);
        System.out.println("Total de pacientes prioritarios: " + prioritarios);

    }
  }
 
  
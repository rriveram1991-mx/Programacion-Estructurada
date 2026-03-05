/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pacientes;

import java.util.Scanner;

/**
 *
 * @author juang
 */
public class Pacientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos pacientes se registrarán?: ");
        int n = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        String[] nombres = new String[n];
        int[] edades = new int[n];

        // Captura de datos
        for (int i = 0; i < n; i++) {

            System.out.print("Nombre del paciente " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();

            System.out.print("Edad del paciente: ");
            edades[i] = sc.nextInt();

            while (edades[i] < 0 || edades[i] > 120) {
                if (edades[i] < 0 || edades[i] > 120) {
                    System.out.println("Edad inválida. Intente nuevamente.");
                }
                System.out.print("Ingrese la edad otra vez: ");
                edades[i] = sc.nextInt();
            }

            sc.nextLine(); // limpiar buffer
        }

        int menores = 0;
        int adultos = 0;
        int adultosMayores = 0;
        int prioritarios = 0;

        System.out.println("\nPacientes registrados:");

        // Mostrar pacientes (for-each)
        for (String nombre : nombres) {
            System.out.println("Paciente: " + nombre);
        }

        // Análisis de edades
        for (int i = 0; i < edades.length; i++) {

            if (edades[i] < 18) {
                menores++;
            } else if (edades[i] >= 18 && edades[i] <= 59) {
                adultos++;
            } else {
                adultosMayores++;
            }

            if (edades[i] >= 60) {
                System.out.println(nombres[i] + " es Paciente prioritario");
                prioritarios++;
            }
        }

        // Resultados
        System.out.println("\nResultados:");
        System.out.println("Menores de edad: " + menores);
        System.out.println("Adultos: " + adultos);
        System.out.println("Adultos mayores: " + adultosMayores);
        System.out.println("Total de pacientes prioritarios: " + prioritarios);

        sc.close();
    }
}
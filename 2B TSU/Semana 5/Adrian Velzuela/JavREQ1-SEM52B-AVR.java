/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication36;

import java.util.Scanner;

/**
 *
 * @author adrianvalenzuelaramirez
 */
public class JavaApplication36 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // solicitar cuántos pacientes se registrarán
        System.out.print("¿Cuántos pacientes desea registrar?: ");
        int n = sc.nextInt();

        // crear los dos arrays solicitados
        String[] nombres = new String[n];
        int[] edades = new int[n];

        // variables para el análisis
        int menores = 0;
        int adultos = 0;
        int adultosMayores = 0;
        int totalPrioritarios = 0;

        // captura de datos con ciclo for
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- registro del Paciente " + (i + 1) + " ---");
            System.out.print("nombre: ");
            nombres[i] = sc.next();

            System.out.print("edad: ");
            edades[i] = sc.nextInt();

            // validar con while que la edad sea lógica (0-120)
            while (edades[i] < 0 || edades[i] > 120) {
                // uso de if para mensaje de reintento según el requerimiento
                if (edades[i] < 0 || edades[i] > 120) {
                    System.out.println("edad inválida, debe estar entre 0 y 120 años.");
                    System.out.print("ingrese la edad nuevamente: ");
                    edades[i] = sc.nextInt();
                }
            }
        }

        // analisis del sistema y conteo de categorías
        System.out.println("\nlistado de pacientes registrados");
        
        // usamos un for normal primero para poder relacionar el nombre con la edad
        for (int i = 0; i < n; i++) {
            String prioridad = "";
            
            // logica de categorías y prioridad
            if (edades[i] < 18) {
                menores++;
            } else if (edades[i] >= 18 && edades[i] <= 59) {
                adultos++;
            } else {
                // es adulto mayor de 60
                adultosMayores++;
                prioridad = " (paciente prioritario)"; // condición de prioridad
                totalPrioritarios++;
            }

            System.out.println("paciente: " + nombres[i] + " | edad: " + edades[i] + prioridad);
        }

        //estadísticas finales
        System.out.println("\n estadisticas del sistema ");
        System.out.println("menores de edad: " + menores);
        System.out.println("adultos: " + adultos);
        System.out.println("adultos mayores: " + adultosMayores);
        System.out.println("--------------------------------");
        System.out.println("total de pacientes prioritarios: " + totalPrioritarios);

        sc.close();
    }
}
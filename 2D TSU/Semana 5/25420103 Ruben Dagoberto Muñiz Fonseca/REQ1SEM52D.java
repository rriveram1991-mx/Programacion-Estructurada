/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg1.sem5.pkg2d;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class REQ1SEM52D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("¿Cuántos pacientes registrarás?: ");
        int n = sc.nextInt();
        
        String[] nombres = new String[n];
        int[] edades = new int[n];
        
        // Captura de datos
        for (int i = 0; i < n; i++) {
            sc.nextLine(); // Limpiar buffer
            System.out.print("Nombre del paciente " + (i+1) + ": ");
            nombres[i] = sc.nextLine();
            
            // Validación de edad
            do {
                System.out.print("Edad: ");
                edades[i] = sc.nextInt();
                if (edades[i] < 0 || edades[i] > 120) {
                    System.out.println("Error: Edad no válida (0-120). Intenta de nuevo.");
                }
            } while (edades[i] < 0 || edades[i] > 120);
        }
        
        // Análisis
        int menores = 0, adultos = 0, mayores = 0;
        
        System.out.println("\n--- Lista de Pacientes ---");
        // Usamos un contador auxiliar para el for-each
        int i = 0;
        for (String nombre : nombres) {
            System.out.println(nombre + " (" + edades[i] + " años)");
            
            if (edades[i] < 18) menores++;
            else if (edades[i] < 60) adultos++;
            else {
                mayores++;
                System.out.println(" -> ¡Paciente prioritario!");
            }
            i++;
        }
        
        System.out.println("\nResumen: " + mayores + " pacientes prioritarios.");
    }
}
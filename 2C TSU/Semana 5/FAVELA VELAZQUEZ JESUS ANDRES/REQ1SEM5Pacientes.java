/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pacientes;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class REQ1SEM5Pacientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);

        // --- REQUERIMIENTO: Solicitar cuántos pacientes ---
        System.out.print("¿Cuántos pacientes se registrarán? ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // Limpiamos el buffer del scanner después de leer un entero

        // --- REQUERIMIENTO: Crear los dos arrays ---
        String[] nombres = new String[cantidad]; // Array para almacenar los nombres
        int[] edades = new int[cantidad];        // Array para almacenar las edades

        // --- REQUERIMIENTO: Captura de datos con for ---
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nRegistro del paciente #" + (i + 1));
            
            System.out.print("Nombre: ");
            nombres[i] = sc.nextLine(); // Guardamos el nombre en la posición i

            // --- REQUERIMIENTO: Validar con while ---
            System.out.print("Edad: ");
            int edadTemp = sc.nextInt();
            sc.nextLine(); // Limpiamos buffer

            // Validamos que no sea negativa ni mayor a 120
            while (edadTemp < 0 || edadTemp > 120) {
                // REQUERIMIENTO: Usar if para pedirla nuevamente si es inválida
                if (edadTemp < 0 || edadTemp > 120) {
                    System.out.println("(!) Edad inválida. Debe estar entre 0 y 120.");
                    System.out.print("Ingrese la edad nuevamente: ");
                    edadTemp = sc.nextInt();
                    sc.nextLine(); // Limpiamos buffer
                }
            }
            edades[i] = edadTemp; // Una vez válida, la guardamos en el array
        }

        // --- REQUERIMIENTO: Análisis del sistema ---
        int menores = 0;
        int adultos = 0;
        int adultosMayores = 0;
        int totalPrioritarios = 0;

        System.out.println("\n--- LISTA DE PACIENTES REGISTRADOS ---");

        // Usamos un contador manual para el for-each ya que el array de nombres y edades son distintos
        int indice = 0;
        
        // --- REQUERIMIENTO: Usar for-each para mostrar pacientes ---
        for (String nombre : nombres) {
            int edadActual = edades[indice]; // Obtenemos la edad correspondiente al nombre actual
            
            System.out.print("Paciente: " + nombre + " | Edad: " + edadActual);

            // --- REQUERIMIENTO: Contar categorías y detectar prioritarios ---
            if (edadActual < 18) {
                menores++; // Es menor de edad
            } else if (edadActual >= 18 && edadActual <= 59) {
                adultos++; // Es adulto
            } else {
                adultosMayores++; // Es adulto mayor (60 o más)
                // REQUERIMIENTO: Si es >= 60 mostrar "Paciente prioritario"
                System.out.print(" -> [PACIENTE PRIORITARIO]");
                totalPrioritarios++; // Aumentamos contador de prioritarios
            }
            
            System.out.println(); // Salto de línea para el siguiente registro
            indice++; // Incrementamos el índice para la siguiente vuelta
        }

        // --- REQUERIMIENTO: Mostrar resultados finales ---
        System.out.println("\n--- RESUMEN DE ANÁLISIS ---");
        System.out.println("Menores de edad (<18): " + menores);
        System.out.println("Adultos (18-59): " + adultos);
        System.out.println("Adultos mayores (>=60): " + adultosMayores);
        System.out.println("TOTAL DE PACIENTES PRIORITARIOS: " + totalPrioritarios);

        sc.close(); 
    }
}
    
    


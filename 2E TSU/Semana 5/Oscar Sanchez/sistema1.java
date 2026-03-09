/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.sem5.pkg2e.java;

import java.util.Scanner;

/**
 *
 * @author edwin, oscar sanchez
 */
public class sistema1 {
    public static void main(String[] args) {
        // Inicializamos el Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // 1. Solicitar cuántos pacientes se registrarán
        System.out.print("¿Cuántos pacientes se registrarán?: ");
        int cantidadPacientes = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea que queda después de nextInt()

        // 2. Crear dos arrays para almacenar nombres y edades
        String[] nombres = new String[cantidadPacientes];
        int[] edades = new int[cantidadPacientes];

        // 3. Captura de datos usando un ciclo for
        for (int i = 0; i < cantidadPacientes; i++) {
            System.out.print("\nIngrese el nombre del paciente #" + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();

            int edad = -1; // Inicializamos con un valor inválido para forzar la entrada al while

            // 4. Validar con while que la edad no sea negativa ni mayor a 120
            while (edad < 0 || edad > 120) {
                System.out.print("Ingrese la edad de " + nombres[i] + ": ");
                edad = scanner.nextInt();

                // 5. Si la edad es inválida, usar if para notificarlo y se pedirá nuevamente por el while
                if (edad < 0 || edad > 120) {
                    System.out.println("Error: La edad es inválida. Debe estar entre 0 y 120 años.");
                }
            }
            // Guardamos la edad validada en su array correspondiente
            edades[i] = edad;
            scanner.nextLine(); // Consumir el salto de línea
        }

        // Variables para el análisis y conteo
        int menores = 0;
        int adultos = 0;
        int adultosMayores = 0;

        System.out.println("\n--- Lista de Pacientes Registrados ---");

        // 6. Análisis del sistema: Usar for-each para mostrar pacientes
        // Nota: Como for-each recorre los elementos y no los índices, usamos un contador extra 'indice'
        // para acceder a la edad correspondiente en el array paralelo de edades.
        int indice = 0;
        for (String nombrePaciente : nombres) {
            int edadPaciente = edades[indice];
            
            System.out.print("Paciente: " + nombrePaciente + " | Edad: " + edadPaciente);

            // 7. Condiciones y conteo de categorías
            if (edadPaciente < 18) {
                menores++; // Contar menores de edad
            } else if (edadPaciente >= 18 && edadPaciente <= 59) {
                adultos++; // Contar adultos
            } else if (edadPaciente >= 60) {
                adultosMayores++; // Contar adultos mayores
                // 8. Condición especial para mayores de 60
                System.out.print(" -> *** Paciente prioritario ***");
            }
            
            System.out.println(); // Salto de línea para el siguiente paciente
            indice++;
        }

        // 9. Mostrar resultados finales
        System.out.println("\n--- Resumen del Análisis ---");
        System.out.println("Menores de edad (<18): " + menores);
        System.out.println("Adultos (18-59): " + adultos);
        System.out.println("Adultos mayores (60 o más): " + adultosMayores);
        
        // El total de pacientes prioritarios es exactamente igual a la cantidad de adultos mayores
        System.out.println("Total de pacientes prioritarios: " + adultosMayores);

    }
}

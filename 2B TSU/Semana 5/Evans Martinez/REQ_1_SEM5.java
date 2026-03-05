import java.util.Scanner;

public class REQ_1_SEM5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar cuántos pacientes se registrarán
        System.out.print("¿Cuántos pacientes se registrarán? ");
        int numPacientes = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        
        // Crear los dos arrays
        String[] nombres = new String[numPacientes];
        int[] edades = new int[numPacientes];
        
        // Captura de datos usando for
        for (int i = 0; i < numPacientes; i++) {
            System.out.println("\n--- Paciente " + (i + 1) + " ---");
            
            // Capturar nombre
            System.out.print("Nombre: ");
            nombres[i] = scanner.nextLine();
            
            // Capturar y validar edad
            int edad = -1;
            while (edad < 0 || edad > 120) {
                System.out.print("Edad: ");
                edad = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                
                if (edad < 0 || edad > 120) {
                    System.out.println("Edad inválida. La edad debe estar entre 0 y 120.");
                }
            }
            edades[i] = edad;
        }
        
        // Análisis del sistema: mostrar todos los pacientes
        System.out.println("\n========== PACIENTES REGISTRADOS ==========");
        for (String nombre : nombres) {
            System.out.println("- " + nombre);
        }
        
        // Contadores
        int menoresDeEdad = 0;      // < 18
        int adultos = 0;            // 18 - 59
        int adultosMyores = 0;      // >= 60
        int pacientesPrioritarios = 0;
        
        // Análisis detallado de pacientes
        System.out.println("\n========== ANÁLISIS DE PACIENTES ==========");
        for (int i = 0; i < numPacientes; i++) {
            System.out.println("\nPaciente: " + nombres[i] + " | Edad: " + edades[i]);
            
            // Clasificar por edad
            if (edades[i] < 18) {
                menoresDeEdad++;
            } else if (edades[i] >= 18 && edades[i] < 60) {
                adultos++;
            } else if (edades[i] >= 60) {
                adultosMyores++;
                System.out.println("*** Paciente prioritario ***");
                pacientesPrioritarios++;
            }
        }
        
        // Mostrar resultados finales
        System.out.println("\n========== ESTADÍSTICAS FINALES ==========");
        System.out.println("Total de pacientes: " + numPacientes);
        System.out.println("Menores de edad (<18): " + menoresDeEdad);
        System.out.println("Adultos (18-59): " + adultos);
        System.out.println("Adultos mayores (60+): " + adultosMyores);
        System.out.println("\nTotal de pacientes prioritarios: " + pacientesPrioritarios);
        
        scanner.close();
    }
}

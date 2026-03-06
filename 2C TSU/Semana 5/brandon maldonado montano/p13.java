import java.util.Scanner;

public class p13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitar número de pacientes
        System.out.print("¿Cuántos pacientes se registrarán? ");
        int n = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        String[] nombres = new String[n];
        int[] edades = new int[n];

        // Captura de datos con validación
        for (int i = 0; i < n; i++) {
            System.out.print("Nombre del paciente " + (i+1) + ": ");
            nombres[i] = sc.nextLine();

            int edad;
            while (true) {
                System.out.print("Edad del paciente " + (i+1) + ": ");
                edad = sc.nextInt();
                sc.nextLine(); // limpiar buffer
                if (edad >= 0 && edad <= 120) {
                    break;
                } else {
                    System.out.println("Edad inválida. Debe estar entre 0 y 120.");
                }
            }
            edades[i] = edad;
        }

        // Análisis del sistema
        int menores = 0, adultos = 0, mayores = 0, prioritarios = 0;

        for (int edad : edades) {
            if (edad < 18) {
                menores++;
            } else if (edad < 60) {
                adultos++;
            } else {
                mayores++;
                prioritarios++;
            }
        }

        // Mostrar pacientes
        System.out.println("\n--- Lista de Pacientes ---");
        for (int i = 0; i < n; i++) {
            System.out.print(nombres[i] + " - " + edades[i] + " años");
            if (edades[i] >= 60) {
                System.out.print(" → Paciente prioritario");
            }
            System.out.println();
        }

        // Resultados finales
        System.out.println("\nMenores de edad: " + menores);
        System.out.println("Adultos: " + adultos);
        System.out.println("Adultos mayores: " + mayores);
        System.out.println("Total de pacientes prioritarios: " + prioritarios);
    }
}

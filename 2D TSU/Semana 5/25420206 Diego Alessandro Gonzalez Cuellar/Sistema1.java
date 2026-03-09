import java.util.Scanner;

//Sistema 1
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ingresamos los pacientes
        System.out.println("Ingrese los Pacientes regristrados");
        int PacientesCantidad = sc.nextInt();
        sc.nextLine();

        // Agregamos los array para la endad de nombres y edades
        String[] nombres = new String[PacientesCantidad];
        String[] edades = new String[PacientesCantidad];

        // Ingresamos los nombres y edades
        for (int i = 0; i < PacientesCantidad; i++) {
            System.out.print("Ingrese el nombre del paciente " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();
            int edad = -1;

            while (edad < 0 || edad > 120) {
                System.out.print("Ingrese la edad de " + nombres[i] + ": ");
                edad = sc.nextInt();
                sc.nextLine();
                if (edad < 0 || edad > 120) {
                    System.out.println("Error: La edad debe estar entre 0 y 120. Intente nuevamente.");
                }
            }
            edades[i] = edad;
        }

        // Imprimimos los nombres y edades ya en una lista por orden y decimos si son
        // menores o adultos
        int menores = 0;
        int adultos = 0;
        int adultosMayores = 0;
        int pacientesPrioritarios = 0;
        System.out.println("\n--- Lista de Pacientes Registrados ---");
        int index = 0;
        for (int edad : edades) {
            String nombre = nombres[index];
            System.out.print("Paciente: " + nombre + " - Edad: " + edad);
            if (edad < 18) {
                menores++;
            } else if (edad >= 18 && edad <= 59) {
                adultos++;
            } else {
                adultosMayores++;
                System.out.print(" -> Paciente prioritario");
                pacientesPrioritarios++;
            }
            System.out.println();
            index++;
        }

        // Resumen de los datos ya guardados
        System.out.println("\n--- Resumen de Edades ---");
        System.out.println("Menores de edad (<18): " + menores);
        System.out.println("Adultos (18-59): " + adultos);
        System.out.println("Adultos mayores (60 o más): " + adultosMayores);

        System.out.println("\nTotal de pacientes prioritarios: " + pacientesPrioritarios);
        sc.close();
    }
}

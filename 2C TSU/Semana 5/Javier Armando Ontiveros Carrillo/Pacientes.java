package pacientes;
import java.util.Scanner;

public class Pacientes {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.print("¿Cuántos pacientes se registrarán? ");
        int n = leer.nextInt();
        leer.nextLine();

        String[] nombres = new String[n];
        int[] edades = new int[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nPaciente " + (i + 1));

            System.out.print("Nombre: ");
            nombres[i] = leer.nextLine();

            System.out.print("Edad: ");
            edades[i] = leer.nextInt();
            leer.nextLine();

            while (edades[i] < 0 || edades[i] > 120) {

                if (edades[i] < 0 || edades[i] > 120) {
                    System.out.println("Edad inválida. Intente nuevamente.");
                }

                System.out.print("Edad: ");
                edades[i] = leer.nextInt();
            }

        }

        int menores = 0;
        int adultos = 0;
        int adultosMayores = 0;
        int prioritarios = 0;

        System.out.println("\n--- Lista de Pacientes ---");

        for (String nombre : nombres) {
            System.out.println("Paciente: " + nombre);
        }

        for (int edad : edades) {

            if (edad < 18) {
                menores++;
            } else if (edad <= 59) {
                adultos++;
            } else {
                adultosMayores++;
                prioritarios++;
                System.out.println("Paciente prioritario");
            }
        }

        System.out.println("\nMenores de edad: " + menores);
        System.out.println("Adultos: " + adultos);
        System.out.println("Adultos mayores: " + adultosMayores);
        System.out.println("Total de pacientes prioritarios: " + prioritarios);

    }
    
}
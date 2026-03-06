import java.util.Scanner;

public class eje28 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int pacientes;

        System.out.println("Cuantos pacientes registrara:");
        pacientes = leer.nextInt();

        String[] nombres = new String[pacientes]; 
        int[] edades = new int[pacientes];

        for (int i = 0; i < pacientes; i++) {
            System.out.println("Nombre del paciente:");
            nombres[i] = leer.next();

            System.out.println("Edad del paciente:");
            edades[i] = leer.nextInt();
            
            while (edades[i] < 0 || edades[i] > 120) {
                if (edades[i] < 0 || edades[i] > 120) {
                    System.out.println("Edad invalida");
                }
                System.out.println("Ingrese nuevamente las edades:");
                edades[i] = leer.nextInt();                
            }
        }

        int menores = 0;
        int adultos = 0;
        int mayores = 0;
        int prioritarios = 0;

        System.out.println("Pacientes registrados:");

        for (int edad : edades) {
            if (edad < 18) {
                menores++;
            } else if (edad >= 18 && edad <= 59) {
                adultos++;
            } else {
                mayores++;
                prioritarios++;
                System.out.println("Paciente prioritario");
            }
        }

        System.out.println("Menores de edad: " + menores);
        System.out.println("Adultos: " + adultos);
        System.out.println("Adultos mayores: " + mayores);
        System.out.println("Total de pacientes prioritarios: " + prioritarios);

    }
}
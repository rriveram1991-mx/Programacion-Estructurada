
package pacientes;

import java.util.Scanner;

public class Pacientes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Cuantos pacientes se registraran? ");
        int cantidad = sc.nextInt();
        sc.nextLine(); 

        String[] nombres = new String[cantidad];
        int[] edades = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {

            System.out.println("\nPaciente " + (i + 1));

            System.out.print("Nombre: ");
            nombres[i] = sc.nextLine();

            System.out.print("Edad: ");
            edades[i] = sc.nextInt();

            while (edades[i] < 0 || edades[i] > 120) {
                if (edades[i] < 0 || edades[i] > 120) {
                    System.out.print("Edad invalida. Ingrese nuevamente: ");
                    edades[i] = sc.nextInt();
                }
            }

            sc.nextLine(); 
        }

        int menores = 0;
        int adultos = 0;
        int adultosMayores = 0;
        int prioritarios = 0;

        System.out.println("\nPacientes registrados:");

        for (String nombre : nombres) {
            System.out.println("Nombre: " + nombre);
        }

        for (int i = 0; i < edades.length; i++) {

            System.out.println("Edad: " + edades[i]);

            if (edades[i] < 18) {
                menores++;
            } 
            else if (edades[i] <= 59) {
                adultos++;
            } 
            else {
                adultosMayores++;
            }

            if (edades[i] >= 60) {
                System.out.println("Paciente prioritario");
                prioritarios++;
            }
        }

        System.out.println("\nResumen:");
        System.out.println("Menores de edad: " + menores);
        System.out.println("Adultos: " + adultos);
        System.out.println("Adultos mayores: " + adultosMayores);
        System.out.println("Total de pacientes prioritarios: " + prioritarios);

        sc.close();
    }
}
    
    
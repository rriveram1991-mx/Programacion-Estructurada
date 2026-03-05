import java.util.Scanner;

/**
 * Institución: Universidad Tecnológica de Torreón.
 * Carrera: Ingeniería en Desarrollo de Software.
 * Alumno: [Juan Diego Arroyo Bucio.]
 * Materia: Programación Estructurada.
 */
public class REQ1SEM5JDAB {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        System.out.println("Ingrese pacientes a registrar: ");
        int n = read.nextInt();
        String [] nombres = new String[n];
        int [] edades = new int[n];

        for (int i = 0; i < n ; i++) {
            System.out.println("Ingrese su nombre: ");
            nombres[i] = read.next();
            System.out.println("Ingrese su edad: ");
            edades[i] = read.nextInt();
            while (edades[i] < 0 || edades[i] > 120 ) {
                System.out.println("Error, ingrese una edad valida:");
                edades[i] = read.nextInt();

            }
        }
        int menores = 0;
        int adultos = 0;
        int prioritarios = 0;
        int cont = 0;
        for (int edad : edades){
            System.out.println("Paciente: " + nombres[cont] + " Edad: " + edad );
            if (edad < 18) {
                menores += 1 ;
            } else if (edad >= 18 && edad <= 59) {
                adultos += 1;

            } else if (edad >= 60) {
                prioritarios += 1;
                System.out.println("Paciente prioritario! ");
            }
            cont ++;
        }
        System.out.println("Total de menores: " + menores);
        System.out.println("Total de adultos: " + adultos);
        System.out.println("Total de prioritarios: " + prioritarios);


    }
}
import java.util.Scanner;
public class Practica17 {

    public static void main(String[]args){
        Scanner leer = new Scanner(System.in);
        int pacientes = 0;
        int edad = 0;
        int e = 0;
        int r = 0;
        int m = 0;
        System.out.println("== Registro de Pacientes ==");
        System.out.println("Ingrese la cantidad de pacientes a registrar: ");
        pacientes = leer.nextInt();
        for (int i = 1; i <= pacientes; i++) {
            System.out.println("Ingrese la edad del paciente #" + i + ": ");
            edad = leer.nextInt();

            while (edad < 0 && edad > 120) {
                System.out.println("== Edad no válida ==");
                edad = leer.nextInt();
            }
               
                if (edad < 18) {
                    System.out.println("Paciente #" + i + " es menor de edad.");
                    e++;
                } else if (edad >= 18 && edad <= 59) {
                    System.out.println("Paciente #" + i + " es adulto.");
                    r++;
                } else {
                    System.out.println("Paciente #" + i + " es adulto mayor.");
                    System.out.println("Paciente priorizado");
                    m++;
                }
        }
        System.out.println("Total de pacientes menores de edad: "+e);
        System.out.println("Total de pacientes adultos: " + r);
        System.out.println("Total de pacientes adultos mayores: " + m);
     leer.close();
    }
}

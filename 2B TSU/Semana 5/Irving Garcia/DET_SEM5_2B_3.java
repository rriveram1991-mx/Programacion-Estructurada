import java.util.Scanner;

public class DET_SEM5_2B_3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("¿Cuantos pacientes desea registrar?");
        int n = sc.nextInt();
        sc.nextLine();

        String[] nom = new String[n];
        int[] num = new int[n];

        int menores = 0;
        int adultos = 0;
        int adultos_mayores = 0;
        
        // Registro de pacientes
        for(int i = 0; i < nom.length; i++) {
            System.out.println("Cual es el nombre del paciente: ");
            nom[i] = sc.nextLine();

            System.out.println("Cual es su edad: ");
            num[i] = sc.nextInt();
            while (num[i] < 0 || num[i] > 120) {
                if (num[i] < 0 || num[i] > 120) {
                    System.out.print("Edad invalida ingresela nuevamente:");
                    num[i] = sc.nextInt();
                }
            }
            // filtrar edad
            if (num[i] < 18) {
                menores++;
            }else if (num[i] < 60) {
                adultos++;
            }else {
                adultos_mayores++;
            }
            sc.nextLine();
        }
        // Pacientes registrados
        System.out.println("\nPaciente registrado");
        for (int i = 0; i < nom.length; i++) {
            System.out.println("Nombre: " + nom[i] + " Edad: " + num[i]);
        }
        System.out.println("Total de pacientes prioritarios: " + adultos_mayores);
        System.out.println("Total de pacientes menores de edad: " + menores);
        System.out.println("Total de pacientes mayores de edad: " + adultos);
    }
}

import java.util.Scanner;

public class RegistroPacientes 
{
    public static void main(String[] args)
 {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos pacientes? ");
        int cant = sc.nextInt();
        sc.nextLine();

        String[] nombres = new String[cant];
        int[] edades = new int[cant];

        for (int i = 0; i < cant; i++) 
{
            System.out.print("Nombre: ");
            nombres[i] = sc.nextLine();

            System.out.print("Edad: ");
            int e = sc.nextInt();


            while (e < 0 || e > 120)

            {
                if (e < 0 || e > 120) 
                {
                    System.out.print("Error. Reingresa edad: ");
                }
                e = sc.nextInt();
            }
            edades[i] = e;
            sc.nextLine();
        }

        int menores = 0, adultos = 0, mayores = 0, prioridad = 0;
        int i = 0;

        for (int e : edades)
 {
            System.out.print("Paciente: " + nombres[i] + " [" + e + "]");
            if (e < 18) 
            {
                menores++;
            } else if (e < 60) 
            {
                adultos++;
            } else {
                mayores++;
                prioridad++;
                System.out.print(" -> Prioritario");
            }
            System.out.println();
            i++;
        }

        System.out.println("\nMenores: " + menores);
        System.out.println("Adultos: " + adultos);
        System.out.println("Mayores: " + mayores);
        System.out.println("Total Prioridad: " + prioridad);
    }
}
import java.util.Scanner;

public class DeteccionErrores 
{

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        //cambiar valor a double
        double suma = 0;
        int aprobados = 0;

        // Captura de datos
        //no deberia empezar en 0 y no debio llevar =
        for (int i = 0; i < calificaciones.length; i++) 
        {

            System.out.println("Ingrese calificación " + i + ": ");
            calificaciones[i] = sc.nextInt();

            while (calificaciones[i] < 0 || calificaciones[i] > 100) 
            {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        for (int cal : calificaciones) 
        {
            System.out.println("Calificación: " + cal);
            //agregar el operador suma
            suma += cal;
        }

        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length) 
        {
            if (calificaciones[j] > 70) 
            {
                aprobados++;
            }
           //que incremente el valor de j, y no avanza.
            j++;
        }

        double promedio = suma / calificaciones.length;

        if (promedio >= 70)
            System.out.println("Grupo aprobado");
        else
            System.out.println("Grupo reprobado");

        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
    }
}


package capturarcalificacion.sandra;

import java.util.Scanner;

public class CapturarCalificacionSandra {
//SANDRA DOMINGUEZ
    
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        int[] calificaciones = new int[5];
        int suma = 0;
        int aprobados = 0, reprobados=0;

        // Captura de datos
       
        for (int i = 0; i < calificaciones.length; i++)  //ERROR: TENIA 1 Y DEBEN EMPEZAR CON 0, EL = EN CALIFICACIONES TAMPOCO DEBE DE ESTAR.
        {

            System.out.println("Ingrese calificación " + (i+1) + ": ");
            calificaciones[i] = sc.nextInt();

            while (calificaciones[i] <0 || calificaciones[i] >100) //ERROR TENIA && DEBE SER ||
            {
                System.out.println("Calificación inválida. Intente nuevamente:");
                calificaciones[i] = sc.nextInt();
            }
        }

        // Mostrar calificaciones
        System.out.println("-----------CALIFICACIONES INGRESADAS---------------");
        for (int cal : calificaciones)
        {
            System.out.println("Calificación: " + cal);
            suma += cal; //faltaba un +
        }

        // Contar aprobados
        int j = 0;
        while (j < calificaciones.length) 
        {
            if (calificaciones[j] >= 70)  //FALTABA EL =
            {
                aprobados++; 
            }
            else  //FALTABA UN ELSE PARA QUE SE IMPRIMA LO DE REPROBADOS.
            {
               reprobados++;
            }j++;//AGREGUE LA J++
        }

        double promedio = suma / (double) calificaciones.length;
        
        System.out.println("-------------------------------------------------");
        if (promedio >= 70)
        {
            System.out.println("Grupo aprobado");  //ERROR: NO TENIAN {}
        }
        else
        {
            System.out.println("Grupo reprobado");
        }
        
        System.out.println("--------------------------------------------------");
        System.out.println("Promedio: " + promedio);
        System.out.println("Aprobados: " + aprobados);
        System.out.println("Reprobados:" +reprobados);

        
    }
    
}

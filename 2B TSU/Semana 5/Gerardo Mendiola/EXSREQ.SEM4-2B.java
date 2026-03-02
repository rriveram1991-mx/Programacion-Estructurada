package examen.pkg2;

import java.util.Scanner;

public class Examen2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("--- MENU ---");
            System.out.println("1. Calcular promedio de calificaciones");
            System.out.println("2. Salir");
            System.out.print("Elige una opcion: ");
            int opcion = sc.nextInt();
            
            switch (opcion) {
                case 1: { 
                    System.out.print("¿Cuantas calificaciones deseas ingresar? ");
                int n = sc.nextInt();
                double suma = 0;
                
                for (int i = 1; i <= n; i++) {
                    System.out.print("Ingresa la calificacion " + i + ": ");
                    double calificacion = sc.nextDouble();
                    
                    if (calificacion >= 0 && calificacion <= 100) {
                        suma += calificacion; }
                    else {
                        System.out.println("Calificacion invalida. Debe estar entre 0 y 100.");
                        i--;
                    }
        }
                double promedio = suma / n;
                System.out.println("El promedio es: " + promedio);
                break;
            }
            case 2:
            continuar = false;
            System.out.println("Saliendo del programa...");
        break;
        default:
        System.out.println("Opcion invalida. Intenta de nuevo.");
    }
}
    sc.close();
    }
}
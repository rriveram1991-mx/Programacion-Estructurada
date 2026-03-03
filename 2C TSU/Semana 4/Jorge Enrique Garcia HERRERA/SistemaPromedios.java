/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemapromedios;
import java.util.Scanner;
/**
 *
 * @author jegh1
 */
public class SistemaPromedios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        while (opcion != 2) {

            System.out.println("\n=== SISTEMA DE PROMEDIOS ===");
            System.out.println("1. Calcular promedio");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();

            
            switch (opcion) {

                case 1:

                    System.out.print("¿Cuantas calificaciones desea ingresar?: ");
                    int cantidad = sc.nextInt();

                    if (cantidad <= 0) {
                        System.out.println("Cantidad invalida");
                        break;
                    }

                    double suma = 0;

                    
                    for (int i = 1; i <= cantidad; i++) {

                        System.out.print("Ingrese calificacion #" + i + ": ");
                        double calificacion = sc.nextDouble();

                        // IF → Validar rango 0–100
                        if (calificacion >= 0 && calificacion <= 100) {
                            suma += calificacion;
                        } else {
                            System.out.println("Calificacion invalida (0–100)");
                            i--; // Repite esa posición
                        }
                    }

                    double promedio = suma / cantidad;

                    System.out.println("Promedio final: " + promedio);

                    if (promedio >= 70) {
                        System.out.println("Alumno aprobado");
                    } else {
                        System.out.println("Alumno reprobado");
                    }

                    break;

                case 2:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        }

        sc.close();
    }
}


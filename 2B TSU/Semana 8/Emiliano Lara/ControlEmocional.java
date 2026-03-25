/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlemocional;

import java.util.Scanner;

/**
 *
 * @author emili
 */
public class ControlEmocional {
    public static void main(String[] args) {
Scanner der = new Scanner(System.in);
int diasmax = 7;
        int numActividades = 3;
        int dia = 0;
        int[] edo = new int[diasmax];
        int[][] actividades = new int[diasmax][numActividades];
        boolean continuar = true;
        while (continuar) {
            System.out.println("--- Menú ---");
            System.out.println("1. Registrar edo. de animo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendacion");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");          
            int acc = der.nextInt();
            switch (acc) {
                case 1:
                    if (dia < diasmax) {
                        System.out.println("Dia " + (dia + 1) + " - Inserte su estado de ánimo:");
                        System.out.println("1. Muy mal 2. Mal  3. Neutral 4. Bien 5. Excelente");
                        edo[dia] = der.nextInt();
                        System.out.println("Estado registrado.");
                    } else {
                        System.out.println("Ya completaste la semana.");
                    }
                    break;
                case 2:
                    if (dia < diasmax) {
                        System.out.println("Registro de actividades (1 = Si, 0 = No):");
                        System.out.print("¿Medito?: ");
                        actividades[dia][0] = der.nextInt();
                        System.out.print("¿Hizo ejercicio?: ");
                        actividades[dia][1] = der.nextInt();
                        System.out.print("¿Leyo un libro?: ");
                        actividades[dia][2] = der.nextInt();
                        dia++;
                        System.out.println("Actividades guardadas.");
                    } else {
                        System.out.println("Semana completa.");
                    }
                    break;
                case 3:
                    double suma = 0;
                    for (int i = 0; i < dia; i++) {
                        suma += edo[i];
                    }
                    double promedio = (dia > 0) ? suma / dia : 0;                   
                    int totalActividades = 0;
                    // Uso de for each para contar actividades realizadas
                    for (int[] fila : actividades) {
                        for (int act : fila) {
                            if (act == 1) totalActividades++;
                        }
                    }
                    System.out.println("--- RESUMEN ---");
                    System.out.printf("Promedio de ánimo: ", promedio);
                    System.out.println("Total de actividades saludables: " + totalActividades);   
                    if (promedio < 3) System.out.println("Bienestar: BAJO");
                    else if (promedio <= 4) System.out.println("Bienestar: MEDIO");
                    else System.out.println("Bienestar: ALTO");
                    break;
                case 4:
                    double prom = 0;
                    for(int i=0; i<dia; i++) prom += edo[i];
                    prom = (dia > 0) ? prom / dia: 0;
                    if (prom < 3) {
                        System.out.println("Recomendación: Prioriza el descanso y prueba 10 min de meditación.");
                    } else if (prom >= 3 && prom < 4) {
                        System.out.println("Recomendación: ¡Vas por buen camino! Intenta hacer algo de ejercicio.");
                    } else {
                        System.out.println("¡Felicidades! Mantén ese ritmo, tu bienestar es excelente.");
                    }
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
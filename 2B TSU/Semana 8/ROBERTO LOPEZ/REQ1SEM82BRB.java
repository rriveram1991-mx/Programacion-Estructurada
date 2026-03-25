/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.pkg1.sem8.pkg2b.rb;

import java.util.Scanner;



/**
 *
 * @author lopez
 */
public class REQ1SEM82BRB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner lr =new Scanner(System.in);
        final int DIAS = 7;
        final int MAX_ACTIVIDADES = 3; 
        int[] estadosAnimo = new int[DIAS];
       
        int[][] actividades = new int[DIAS][MAX_ACTIVIDADES];
        String[] nombresActividades = {"Meditacion", "Ejercicio", "Hidratacion"};
        
        int opcion;
        int diaActual = 0;

        System.out.println("=== Bienvenido a MindBalance ===");

        do {
            System.out.println("\n--- Menu de Control ---");
            System.out.println("1. Registrar estado de animo (Dia " + (diaActual + 1) + ")");
            System.out.println("2. Registrar actividades saludables");
            System.out.println("3. Ver resumen semanal");
            System.out.println("4. Ver recomendacion");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = lr.nextInt();

            switch (opcion) {
                case 1:
                    if (diaActual < DIAS) {
                        System.out.print("Ingresa tu ánimo (1:Muy mal - 5:Excelente): ");
                        int nota = lr.nextInt();
                        if (nota >= 1 && nota <= 5) {
                            estadosAnimo[diaActual] = nota;
                            System.out.println("Estado guardado.");
                        } else {
                            System.out.println("Valor invalido. Intenta de nuevo.");
                        }
                    } else {
                        System.out.println("Semana completada.");
                    }
                    break;

                case 2:
                    System.out.println("Registrando actividades para el dia " + (diaActual + 1));
                    for (int i = 0; i < MAX_ACTIVIDADES; i++) {
                        System.out.print("¿Realizaste " + nombresActividades[i] + "? (1:Si / 0:No): ");
                        actividades[diaActual][i] = lr.nextInt();
                    }
                    if (diaActual < DIAS) diaActual++; 
                    break;

                case 3:
                    double suma = 0;
                    for (int i = 0; i < diaActual; i++) {
                        suma += estadosAnimo[i];
                    }
                    double promedio = (diaActual > 0) ? suma / diaActual : 0;

                    int totalActividades = 0;
                    
                    for (int[] fila : actividades) {
                        for (int act : fila) {
                            if (act == 1) totalActividades++;
                        }
                    }

                    System.out.println("\n--- RESUMEN ---");
                    System.out.printf("Promedio de animo: %.2f\n", promedio);
                    System.out.println("Total de actividades saludables: " + totalActividades);
                    
                    if (promedio < 3) System.out.println("Bienestar: BAJO");
                    else if (promedio <= 4) System.out.println("Bienestar: MEDIO");
                    else System.out.println("Bienestar: ALTO");
                    break;

                case 4:
                  
                    double promRec = 0;
                    for (int i = 0; i < diaActual; i++) promRec += estadosAnimo[i];
                    promRec = (diaActual > 0) ? promRec / diaActual : 0;

                    if (promRec < 3) {
                        System.out.println("Recomendacion: Prioriza el descanso y realiza una meditacion guiada.");
                    } else if (promRec >= 3 && promRec < 4) {
                        System.out.println("Recomendacion: Vas por buen camino. Intenta añadir 20 min de ejercicio.");
                    } else if (promRec >= 4) {
                        System.out.println("¡Felicidades! Manten esa energía y sigue con tus habitos actuales.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo... ¡Cuida tu salud mental!");
                    break;

                default:
                    System.out.println("Opción no valida.");
            }
        } while (opcion != 5);
        
        lr.close();
    }
}
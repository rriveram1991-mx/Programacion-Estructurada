/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication77;

import java.util.Scanner;

/**
 *
 * @author Jaime Ismael
 */
public class JavaApplication77 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        Scanner leer = new Scanner(System.in);
        
       
        int[] estadosAnimo = new int[7];
   
        boolean[][] actividades = new boolean[7][3];
        String[] nombresActividades = {"Ejercicio", "Meditacion", "Buen Sueno"};
        
        int opcion = 0;
        int diaActual = 0;

        while (opcion != 5) {
       
            System.out.println("1. Registrar estado de animo (Día " + (diaActual + 1) + ")");
             System.out.println("2. Registrar actividades saludables");
            System.out.println("3. Ver resumen semanal");
            System.out.println("4. Ver recomendaci");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    if (diaActual < 7) {
                        System.out.println("Siente: 1.Muy mal, 2.Mal, 3.Neutral, 4.Bien, 5.Excelente");
                        System.out.print("Ingrese valor (1-5): ");
                        estadosAnimo[diaActual] = leer.nextInt();
                        
                    } else {
                        
                    }
                    break;

                case 2:
                    System.out.println("Registro de actividades para el día " + (diaActual + 1));
                    for (int x = 0; x < 3; x++) {
                        System.out.print("¿Realizo " + nombresActividades[x] + " 0: si /// 1: no");
                        int hizo = leer.nextInt();
                        actividades[diaActual][x] = (hizo == 1);
                    }
                    if (diaActual < 6) diaActual++; 
                    break;

                case 3:
                    double suma = 0;
              
                    for (int i = 0; i <= diaActual; i++) {
                        suma += estadosAnimo[i];
                    }
                    double promedio = suma / (diaActual + 1);
                    
                    int totalActividades = 0;
                    
                    for (boolean[] fila : actividades) {
                        for (boolean completada : fila) {
                            if (completada) totalActividades++;
                        }
                    }

                    System.out.println("Resumen de Bienestar ");
                    System.out.println("Promedio de animo: % " +  promedio);
                    System.out.println("Total de actividades saludables: " + totalActividades);
                    
                    if (promedio < 3) System.out.println("Nivel de Bienestar bajo");
                    else if (promedio <= 4) System.out.println("Nivel de Bienestar medio");
                    else System.out.println("Nivel de Bienestar alto");
                    break;

                case 4:
                    double promRec = 0;
                    for (int i = 0; i <= diaActual; i++) promRec += estadosAnimo[i];
                    promRec /= (diaActual + 1);

                    
                    if (promRec < 3) {
                        System.out.println("Sugerencia: Prioriza el descanso profundo y realiza 10 min de meditación.");
                    } else if (promRec >= 3 && promRec < 4) {
                        System.out.println("Sugerencia: Mantén el ritmo, intenta realizar actividad física ligera.");
                    } else {
                        System.out.println("¡Excelente trabajo! Sigue manteniendo esos hábitos saludables.");
                    }
                    break;

                case 5:
                   
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        } 
        
        leer.close();
    }
}      
        
        
        
    
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mindbalance;
import java.util.Scanner;
/**
 *
 * @author pecha
 */
public class Mindbalance {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner (System.in);
        //Variables
        final int DIAS = 7;
        final int ACTIVIDADES = 3;
        int[][] actividades = new int[DIAS][ACTIVIDADES];
        int [] estadoAnimo = new int[DIAS];
        //
        int diaActual = 0;
        int opcion;
        //
        do {
            System.out.println("\n===== MIND BALANCE ======");
            System.out.println("1. Registrar estado de animo");
            System.out.println("2. Registrar sctividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendacion");
            System.out.println("5. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                    case 1 -> {
                        if (diaActual < DIAS) {
                            System.out.println("Dia " + (diaActual + 1));
                            System.out.println("1: Muy mal");
                            System.out.println("2: Mal");
                            System.out.println("3: Neutral");
                            System.out.println("4: Bien");
                            System.out.println("5: Excelente");
                            
                            int valor;
                            do {
                                System.out.println("Ingresa su estado: ");
                                valor = sc.nextInt();
                            } while (valor < 1 || valor > 5);
                            estadoAnimo[diaActual] = valor;
                            System.out.println("Estado Guardado");
                        } else {
                            System.out.println("Ya registraste los 7 dias corazon");
                        }
                    }
                    case 2 -> {
                    if (diaActual < DIAS) {
                        System.out.println("Registrar actividades del día " + (diaActual + 1));

                        System.out.println("¿Hiciste ejercicio? (1=Sí, 0=No)");
                        actividades[diaActual][0] = sc.nextInt();

                        System.out.println("¿Meditaste? (1=Sí, 0=No)");
                        actividades[diaActual][1] = sc.nextInt();

                        System.out.println("¿Dormiste bien? (1=Sí, 0=No)");
                        actividades[diaActual][2] = sc.nextInt();

                        diaActual++; // avanza al siguiente día
                    } else {
                        System.out.println("Semana completa");
                    }
                }

                case 3 -> {
                    // PROMEDIO
                    int suma = 0;
                    int diasRegistrados = 0;

                    for (int i = 0; i < DIAS; i++) {
                        if (estadoAnimo[i] != 0) {
                            suma += estadoAnimo[i];
                            diasRegistrados++;
                        }
                    }

                    if (diasRegistrados == 0) {
                        System.out.println("No hay datos aún");
                        break;
                    }

                    double promedio = (double) suma / diasRegistrados;
                    System.out.println("Promedio: " + promedio);

                    // CONTAR ACTIVIDADES 
                    int totalActividades = 0;

                    for (int[] dia : actividades) {
                        for (int act : dia) {
                            if (act == 1) totalActividades++;
                        }
                    }

                    System.out.println("Actividades realizadas: " + totalActividades);
                    
                    // NIVEL BIENESTAR
                    if (promedio < 3) {
                        System.out.println("Bienestar: BAJO");
                    } else if (promedio < 4) {
                        System.out.println("Bienestar: MEDIO");
                    } else {
                        System.out.println("Bienestar: ALTO");
                    }
                }

                case 4 -> {
                    int suma = 0;
                    int diasRegistrados = 0;
                    for (int i = 0; i < DIAS; i++) {
                        if (estadoAnimo[i] != 0) {
                            suma += estadoAnimo[i];
                            diasRegistrados++;
                        }
                    }
                    if (diasRegistrados == 0) {
                        System.out.println("No hay datos aún");
                        break;
                    }

                    double promedio = (double) suma / diasRegistrados;

                    if (promedio < 3) {
                        System.out.println("Recomendación: Descansa y medita ");
                    } else if (promedio < 4) {
                        System.out.println("Recomendación: Haz ejercicio ");
                    } else {
                        System.out.println("¡Excelente! Sigue así");
                    }
                }
                case 5 -> System.out.println("Goodbye, que tengas un buen dia");
                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 5);   
    }
}

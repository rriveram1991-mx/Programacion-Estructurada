package saludhabitos;
import java.util.Scanner;
public class SistemaBienestar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxDias = 7;
        int[] estadosAnimo = new int[maxDias];
        int[][] actividades = new int[maxDias][3]; 
        int diaActual = 0;
        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE BIENESTAR MENTAL ---");
            System.out.println("1. Registrar estado de ánimo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendación");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    if (diaActual < maxDias) {
                        System.out.println("Día " + (diaActual + 1));
                        System.out.println("1: Muy mal, 2: Mal, 3: Neutral, 4: Bien, 5: Excelente");
                        System.out.print("Ingrese su estado (1-5): ");
                        estadosAnimo[diaActual] = sc.nextInt();
                        System.out.println("¡Estado registrado!");
                    } else {
                        System.out.println("Ya se han registrado los 7 días.");
                    }
                    break;
                case 2:
                    if (diaActual < maxDias) {
                        System.out.println("Registro de actividades para el Día " + (diaActual + 1));
                        System.out.print("¿Hizo ejercicio? (1: Sí, 0: No): ");
                        actividades[diaActual][0] = sc.nextInt();
                        System.out.print("¿Meditó? (1: Sí, 0: No): ");
                        actividades[diaActual][1] = sc.nextInt();
                        System.out.print("¿Durmió bien? (1: Sí, 0: No): ");
                        actividades[diaActual][2] = sc.nextInt();
                        
                        diaActual++; // Avanzamos al siguiente día tras completar registros
                        System.out.println("¡Actividades guardadas!");
                    } else {
                        System.out.println("Límite de días alcanzado.");
                    }
                    break;
                case 3:
                    double sumaAnimo = 0;
                    int diasContados = 0;
                    for (int i = 0; i < diaActual; i++) {
                        sumaAnimo += estadosAnimo[i];
                        diasContados++;
                    }
                    double promedio = (diasContados > 0) ? sumaAnimo / diasContados : 0;
                    int totalActividades = 0;
                    for (int[] filaDia : actividades) {
                        for (int act : filaDia) {
                            if (act == 1) totalActividades++;
                        }}
                    System.out.println("\n--- RESUMEN DE BIENESTAR ---");
                    System.out.println("Promedio de ánimo: " + promedio);
                    System.out.println("Total de actividades saludables: " + totalActividades);
                    if (promedio < 3) {
                        System.out.println("Bienestar: BAJO");
                    } else if (promedio >= 3 && promedio < 4.5) {
                        System.out.println("Bienestar: MEDIO");
                    } else {
                        System.out.println("Bienestar: ALTO");
                    }
                    break;
                case 4:
                    double promRec = 0;
                    for (int i = 0; i < diaActual; i++) promRec += estadosAnimo[i];
                    promRec = (diaActual > 0) ? promRec / diaActual : 0;
                    System.out.println("\n--- RECOMENDACIÓN ---");
                    if (promRec < 3) {
                        System.out.println("Sugerencia: Se recomienda descanso y meditación.");
                    } else if (promRec >= 3 && promRec < 4) {
                        System.out.println("Sugerencia: ¡Vas por buen camino! Intenta añadir más ejercicio.");
                    } else if (promRec >= 4) {
                        System.out.println("Sugerencia: ¡Felicidades! Mantén ese excelente ritmo.");
                    } else {
                        System.out.println("No hay suficientes datos para una recomendación.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }
}
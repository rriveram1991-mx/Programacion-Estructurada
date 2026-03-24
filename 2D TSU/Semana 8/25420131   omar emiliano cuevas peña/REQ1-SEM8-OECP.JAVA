import java.util.Scanner;

public class ControlEmociones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] emociones = new int[7];
        int[][] actividades = new int[7][6];
        String[] nomAct = {"Ejercicio", "Amigos", "Leer", "Cocinar", "Meditar", "Otra"};
        boolean[] esSaludable = {true, true, true, true, true, false};
        int dia = 0, opc = 0;

        while (opc != 5) {
            System.out.println("\n=== MindBalance ===");
            System.out.println("Día actual: " + (dia + 1) + "/7");
            System.out.println("1. Registrar estado de ánimo");
            System.out.println("2. Registrar actividad");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendación");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    if (dia >= 7) { System.out.println("Ya completaste los 7 días.");
                    break; }
                    System.out.println("\n1-Muy mal   2-Mal  3-Neutral   4-Bien   5-Excelente ");
                    System.out.print("¿Cómo te sientes hoy? ");
                    int e = sc.nextInt();
                    if (e < 1 || e > 5) { System.out.println("Opción inválida."); break; }
                    emociones[dia] = e;
                    System.out.println(" Emoción registrada.");
                    break;

        case 2:
            if (dia >= 7) { System.out.println("Ya completaste los 7 días."); break; }
            System.out.println("\nActividades:");
            for (int i = 0; i < nomAct.length; i++)
            System.out.println((i + 1) + ". " + nomAct[i]);
            System.out.print("¿Qué actividad hiciste? ");
            int a = sc.nextInt();
            if (a < 1 || a > 6) { System.out.println("Opción inválida."); break; }
            actividades[dia][a - 1]++;
            dia++;
            System.out.println(" Actividad registrada. Avanzando al día " + (dia + 1));
            break;

                case 3:
                    if (dia == 0) { System.out.println("No hay datos aún."); break; }

                    // Promedio con for
                    int suma = 0;
                    for (int i = 0; i < dia; i++) suma += emociones[i];
                    double promedio = (double) suma / dia;

                    // Actividades saludables con for-each
                    int saludables = 0;
                    for (int[] d : actividades)
                        for (int j = 0; j < d.length; j++)
                            if (esSaludable[j] && d[j] > 0) saludables++;

                    // Peor día 
                    int peorDia = 0;
                    for (int i = 1; i < dia; i++)
                        if (emociones[i] < emociones[peorDia]) peorDia = i;

                    String nivel = promedio < 3 ? " Bajo" : promedio < 4 ? " Medio" : " Alto";

                    System.out.println("\n===== RESUMEN =====");
                    System.out.printf("Promedio de ánimo: %.2f / 5.00%n", promedio);
                    System.out.println("Actividades saludables: " + saludables);
                    System.out.println("Nivel de bienestar: " + nivel);
                    System.out.println("Peor día de la semana: Día " + (peorDia + 1) + " (" + emociones[peorDia] + "/5)");
                    break;

                case 4:
                    if (dia == 0) { System.out.println("No hay datos aún."); break; }

                    int s = 0;
                    for (int i = 0; i < dia; i++) s += emociones[i];
                    double p = (double) s / dia;

                    System.out.println("\n===== RECOMENDACIÓN =====");
                    System.out.printf("Tu promedio: %.2f%n", p);

                    if (p < 3) {
                        System.out.println(" Bienestar Bajo");
                        System.out.println(" Descansa bien y prueba meditar 10 minutos al día.");
                        System.out.println(" Habla con alguien de confianza.");
                    } else if (p < 4) {
                        System.out.println(" Bienestar Medio");
                        System.out.println(" ¡Vas bien! Agrega ejercicio a tu rutina.");
                        System.out.println(" Mantén tus hábitos saludables.");
                    } else {
                        System.out.println(" Bienestar Alto");
                        System.out.println(" ¡Excelente semana! Sigue así.");
                        System.out.println(" Comparte tu energía positiva con los demás. ");
                    }
                    break;

                case 5:
                    System.out.println("¡Hasta luego! Cuídate ");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }
}

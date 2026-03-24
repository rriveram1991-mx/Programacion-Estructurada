import java.util.Scanner;

public class REQ1_SEM8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] animo = new int[7];
        String[][] actividades = new String[7][3]; 
        int diaActual = 0;

        boolean salir = false;
        while (!salir && diaActual < 7) {
            System.out.println("\n--- MONITOR DE BIENESTAR (Día " + (diaActual + 1) + ") ---");
            System.out.println("1. Registrar estado de ánimo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendación");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Estado (1-Muy mal, 2-Mal, 3-Neutral, 4-Bien, 5-Excelente): ");
                    int valor = sc.nextInt();
                    if (valor >= 1 && valor <= 5) animo[diaActual] = valor;
                    else System.out.println("Valor no válido.");
                    break;

                case 2:
                    System.out.println("Ingresa 3 actividades (ej. Ejercicio, Meditación, Lectura):");
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Actividad " + (i + 1) + ": ");
                        actividades[diaActual][i] = sc.nextLine();
                    }
                    break;

                case 3:
                    double suma = 0;
                    int conteoActividades = 0;
                    for (int i = 0; i <= diaActual; i++) suma += animo[i];
                    double promedio = suma / (diaActual + 1);

                    for (String[] fila : actividades) {
                        for (String act : fila) {
                            if (act != null && !act.isEmpty()) conteoActividades++;
                        }
                    }

                    System.out.println("\n--- RESUMEN ---");
                    System.out.println("Promedio de ánimo: " + String.format("%.2f", promedio));
                    System.out.println("Total de actividades realizadas: " + conteoActividades);
                    
                    if (promedio < 3) System.out.println("Nivel de bienestar: BAJO");
                    else if (promedio <= 4) System.out.println("Nivel de bienestar: MEDIO");
                    else System.out.println("Nivel de bienestar: ALTO");
                    break;

                case 4:
                    double promRec = 0;
                    for (int i = 0; i <= diaActual; i++) promRec += animo[i];
                    promRec /= (diaActual + 1);

                    if (promRec < 3) System.out.println("Sugerencia: Necesitas descanso y meditación.");
                    else if (promRec <= 4) System.out.println("Sugerencia: ¡Vas bien! Intenta hacer un poco de ejercicio.");
                    else System.out.println("Sugerencia: ¡Excelente trabajo! Sigue manteniendo este ritmo.");
                    break;

                case 5:
                    diaActual++;
                    if (diaActual == 7) salir = true;
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
        System.out.println("¡Gracias por cuidar tu salud mental!");
    }
}

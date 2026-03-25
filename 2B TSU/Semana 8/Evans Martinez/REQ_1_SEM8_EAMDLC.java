import java.util.Scanner;

public class REQ_1_SEM8_EAMDLC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] estadoAnimo = new int[7];
        boolean[] diaRegistrado = new boolean[7];

        String[][] actividades = new String[7][5];
        int[] actividadesCount = new int[7];

        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MindBalance - Control de Bienestar Mental ===");
            System.out.println("1. Registrar estado de ánimo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendación");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = leerEntero(scanner);

            switch (opcion) {
                case 1:
                    registrarEstadoAnimo(scanner, estadoAnimo, diaRegistrado);
                    break;
                case 2:
                    registrarActividades(scanner, actividades, actividadesCount);
                    break;
                case 3:
                    mostrarResumen(estadoAnimo, diaRegistrado, actividadesCount);
                    break;
                case 4:
                    mostrarRecomendacion(estadoAnimo, diaRegistrado);
                    break;
                case 5:
                    salir = true;
                    System.out.println("Gracias por usar MindBalance. ¡Cuídate!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        scanner.close();
    }

    private static int leerEntero(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Ingrese un número entero: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void registrarEstadoAnimo(Scanner scanner, int[] estadoAnimo, boolean[] diaRegistrado) {
        System.out.print("Ingrese el día (1-7) para registrar el ánimo: ");
        int dia = leerEntero(scanner);
        if (dia < 1 || dia > 7) {
            System.out.println("Día inválido. Debe ser entre 1 y 7.");
            return;
        }

        System.out.println("Valores de estado de ánimo:");
        System.out.println("1 - Muy mal 😞");
        System.out.println("2 - Mal 😕");
        System.out.println("3 - Neutral 😐");
        System.out.println("4 - Bien 🙂");
        System.out.println("5 - Excelente 😄");
        System.out.print("Ingrese el valor del ánimo (1-5): ");

        int valor = leerEntero(scanner);
        if (valor < 1 || valor > 5) {
            System.out.println("Valor inválido. Debe ser entre 1 y 5.");
            return;
        }

        estadoAnimo[dia - 1] = valor;
        diaRegistrado[dia - 1] = true;
        System.out.println("Estado de ánimo del día " + dia + " registrado correctamente.");
    }

    private static void registrarActividades(Scanner scanner, String[][] actividades, int[] actividadesCount) {
        System.out.print("Ingrese el día (1-7) para registrar actividades: ");
        int dia = leerEntero(scanner);
        if (dia < 1 || dia > 7) {
            System.out.println("Día inválido. Debe ser entre 1 y 7.");
            return;
        }

        int idx = dia - 1;
        System.out.print("¿Cuántas actividades saludables deseas registrar hoy? (0-5): ");
        int cantidad = leerEntero(scanner);
        if (cantidad < 0 || cantidad > 5) {
            System.out.println("Cantidad inválida. Debe ser entre 0 y 5.");
            return;
        }

        scanner.nextLine();
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Actividad " + (i + 1) + ": ");
            String act = scanner.nextLine().trim();
            if (act.isEmpty()) {
                System.out.println("Actividad vacía no registrada. Intente de nuevo.");
                i--;
                continue;
            }
            actividades[idx][i] = act;
        }
        actividadesCount[idx] = cantidad;
        System.out.println("Actividades para el día " + dia + " registradas exitosamente.");
    }

    private static void mostrarResumen(int[] estadoAnimo, boolean[] diaRegistrado, int[] actividadesCount) {
        int diasRegistrados = 0;
        int suma = 0;
        int peorEstado = Integer.MAX_VALUE;
        int peorDia = -1;

        for (int i = 0; i < 7; i++) {
            if (diaRegistrado[i]) {
                diasRegistrados++;
                int valor = estadoAnimo[i];
                suma += valor;
                if (valor < peorEstado) {
                    peorEstado = valor;
                    peorDia = i + 1;
                }
            }
        }

        if (diasRegistrados == 0) {
            System.out.println("Aún no hay estados de ánimo registrados.");
            return;
        }

        double promedio = (double) suma / diasRegistrados;
        System.out.printf("Promedio de estado de ánimo: %.2f\n", promedio);

        int totalActividades = 0;
        for (int i = 0; i < 7; i++) {
            System.out.println("Día " + (i + 1) + ": " + actividadesCount[i] + " actividad(es) saludables.");
            totalActividades += actividadesCount[i];
        }
        System.out.println("Total de actividades saludables en la semana: " + totalActividades);

        String nivel;
        if (promedio < 3) {
            nivel = "Bajo";
        } else if (promedio < 4) {
            nivel = "Medio";
        } else {
            nivel = "Alto";
        }
        System.out.println("Nivel de bienestar: " + nivel);

        if (peorDia != -1) {
            System.out.println("Peor día registrado: " + peorDia + " con ánimo " + peorEstado);
            mostrarMotivacion(peorDia, peorEstado);
        }
    }

    private static void mostrarRecomendacion(int[] estadoAnimo, boolean[] diaRegistrado) {
        int suma = 0;
        int dias = 0;
        for (int i = 0; i < 7; i++) {
            if (diaRegistrado[i]) {
                suma += estadoAnimo[i];
                dias++;
            }
        }
        if (dias == 0) {
            System.out.println("Registre primero al menos un estado de ánimo para obtener recomendación.");
            return;
        }

        double promedio = (double) suma / dias;
        System.out.printf("Promedio actual: %.2f\n", promedio);

        if (promedio < 3) {
            System.out.println("Recomendación: Descanso y meditación. Cuida tu sueño y reduce el estrés.");
        } else if (promedio < 4) {
            System.out.println("Recomendación: Haz ejercicio y mantén una rutina saludable.");
        } else {
            System.out.println("¡Felicidades! Mantén tu hábito positivo y sigue así.");
        }
    }

    private static void mostrarMotivacion(int dia, int estado) {
        System.out.print("Motivación: ");
        if (estado <= 2) {
            System.out.println("Hoy te fue difícil, pero cada pequeño paso cuenta. ¡Mañana será mejor!");
        } else if (estado == 3) {
            System.out.println("Estás en equilibrio. Sigue con hábitos saludables para elevar tu ánimo.");
        } else {
            System.out.println("¡Genial! Sigue manteniendo tu bienestar y compartiendo actitud positiva.");
        }
    }
}
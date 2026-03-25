* @author nohem
 */
public class ControlDeBienestarMental {

    /**
     * @param args the command line arguments
     */
   

      

    static final int MAX_DIAS = 7;
    static final int NUM_ACTIVIDADES = 5;
    static final String[] NOMBRES_ACTIVIDADES = {"Ejercicio", "Meditacion", "Lectura", "Sueno adecuado", "Alimentacion sana"};

    static int[] estadosAnimo = new int[MAX_DIAS];
    static boolean[][] actividades = new boolean[MAX_DIAS][NUM_ACTIVIDADES];
    static int diasRegistrados = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== MindBalance - Bienestar Mental ===\n");
        int opcion;
        do {
            System.out.println("1. Registrar estado de animo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendacion");
            System.out.println("5. Salir");
            opcion = leerEnteroRango("Opcion: ", 1, 5);
            System.out.println();
            switch (opcion) {
                case 1 -> registrarEstadoAnimo();
                case 2 -> registrarActividades();
                case 3 -> mostrarResumen();
                case 4 -> mostrarRecomendacion();
                case 5 -> System.out.println("Hasta luego!");
            }
        } while (opcion != 5);
        sc.close();
    }

    static void registrarEstadoAnimo() {
        if (diasRegistrados >= MAX_DIAS) {
            System.out.println("Ya registraste los 7 dias.\n");
            return;
        }
        System.out.println("1-Muy mal  2-Mal  3-Neutral  4-Bien  5-Excelente");
        int valor = leerEnteroRango("Estado de animo dia " + (diasRegistrados + 1) + " [1-5]: ", 1, 5);
        estadosAnimo[diasRegistrados] = valor;
        diasRegistrados++;
        System.out.println("Guardado!\n");
    }

    static void registrarActividades() {
        if (diasRegistrados == 0) {
            System.out.println("Primero registra tu estado de animo.\n");
            return;
        }
        int dia = diasRegistrados - 1;
        System.out.println("Actividades del dia " + (dia + 1) + " (1=Si, 0=No):");
        for (int col = 0; col < NUM_ACTIVIDADES; col++) {
            int resp = leerEnteroRango(NOMBRES_ACTIVIDADES[col] + ": ", 0, 1);
            actividades[dia][col] = (resp == 1);
        }
        System.out.println("Actividades guardadas!\n");
    }

    static void mostrarResumen() {
        if (diasRegistrados == 0) {
            System.out.println("No hay datos registrados.\n");
            return;
        }
        int suma = 0;
        for (int i = 0; i < diasRegistrados; i++) {
            suma += estadosAnimo[i];
        }
        double promedio = (double) suma / diasRegistrados;

        System.out.println("=== RESUMEN ===");
        for (int i = 0; i < diasRegistrados; i++) {
            System.out.println("Dia " + (i + 1) + ": " + estadosAnimo[i] + " - " + etiquetaAnimo(estadosAnimo[i]));
        }
        System.out.printf("Promedio: %.2f%n", promedio);

        if (promedio < 3) System.out.println("Bienestar: BAJO");
        else if (promedio < 4) System.out.println("Bienestar: MEDIO");
        else System.out.println("Bienestar: ALTO");

        int peorDia = 0;
        for (int i = 1; i < diasRegistrados; i++) {
            if (estadosAnimo[i] < estadosAnimo[peorDia]) peorDia = i;
        }
        System.out.println("Peor dia: Dia " + (peorDia + 1));

        int totalActividades = 0;
        for (boolean[] diaAct : actividades) {
            for (boolean realizada : diaAct) {
                if (realizada) totalActividades++;
            }
        }
        System.out.println("Actividades realizadas: " + totalActividades + "\n");
    }

    static void mostrarRecomendacion() {
        if (diasRegistrados == 0) {
            System.out.println("No hay datos suficientes.\n");
            return;
        }
        int suma = 0;
        for (int i = 0; i < diasRegistrados; i++) suma += estadosAnimo[i];
        double promedio = (double) suma / diasRegistrados;

        System.out.println("=== RECOMENDACION ===");
        if (promedio < 3) {
            System.out.println("Tu bienestar es BAJO.");
            System.out.println("Recomendacion: Descansa bien y practica meditacion.");
        } else if (promedio < 4) {
            System.out.println("Tu bienestar es MEDIO.");
            System.out.println("Recomendacion: Haz ejercicio regularmente.");
        } else {
            System.out.println("Tu bienestar es ALTO. Felicitaciones!");
            System.out.println("Sigue manteniendo tus buenos habitos.");
        }
        System.out.println();
    }

    static int leerEnteroRango(String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = Integer.parseInt(sc.nextLine().trim());
                if (valor >= min && valor <= max) return valor;
                System.out.println("Ingresa un numero entre " + min + " y " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Solo numeros.");
            }
        }
    }

    static String etiquetaAnimo(int valor) {
        return switch (valor) {
            case 1 -> "Muy mal";
            case 2 -> "Mal";
            case 3 -> "Neutral";
            case 4 -> "Bien";
            case 5 -> "Excelente";
            default -> "?";
        };
    }
}
    

import java.util.Scanner;

public class Eje2Midbalancemental {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        int[] animo = new int[7]; 

        String[][] actividades = new String[7][3]; 
        int opcion = 0;
        int diaActual = 0;

        while (opcion != 5) {
            System.out.println("\n--- MindBalance: Control de Bienestar ---");
            System.out.println("1. Registrar estado de animo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendacion");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    if (diaActual < 7) {
                        System.out.println("Como te sientes hoy? (1: Muy mal, 5: Excelente): ");
                        int valor = sc.nextInt();
                        if (valor >= 1 && valor <= 5) {
                            animo[diaActual] = valor;
                            System.out.println("Animo guardado para el dia " + (diaActual + 1));
                        } else {
                            System.out.println("Ese numero no vale, pon del 1 al 5");
                        }
                    } else {
                        System.out.println("Ya llenaste la semana, bro");
                    }
                    break;

                case 2:
                    if (diaActual < 7) {
                        sc.nextLine(); // 
                        System.out.println("Dime 3 actividades saludables de hoy:");
                        for (int i = 0; i < 3; i++) {
                            System.out.print("Actividad " + (i + 1) + ": ");
                            actividades[diaActual][i] = sc.nextLine();
                        }
                        diaActual++; 
                    } else {
                        System.out.println("Semana completa");
                    }
                    break;

                case 3:

                    double suma = 0;
                    for (int i = 0; i < diaActual; i++) {
                        suma += animo[i];
                    }
                    double promedio = (diaActual > 0) ? suma / diaActual : 0;
                    
                    int totalActividades = 0;
                    for (String[] fila : actividades) {
                        for (String act : fila) {
                            if (act != null) totalActividades++;
                        }
                    }

                    System.out.println("--- RESUMEN ---");
                    System.out.println("Promedio de animo: " + promedio);
                    System.out.println("Total de actividades: " + totalActividades);
                    
                    if (promedio < 3) System.out.println("Bienestar: Bajo");
                    else if (promedio <= 4) System.out.println("Bienestar: Medio");
                    else System.out.println("Bienestar: Alto");
                    break;

                case 4:

                    double promRec = 0;
                    for (int i = 0; i < diaActual; i++) promRec += animo[i];
                    promRec = (diaActual > 0) ? promRec / diaActual : 0;

                    if (promRec < 3) {
                        System.out.println("Recomendacion: Descansa y medita un poco, te hace falta.");
                    } else if (promRec >= 3 && promRec < 4) {
                        System.out.println("Recomendacion: Vas bien, intenta hacer algo de ejercicio.");
                    } else if (promRec >= 4) {
                        System.out.println("Felicidades! Sigue asi, vas con todo.");
                    }
                    break;

                case 5:
                    System.out.println("Ahi nos vemos, cuidate");
                    break;
            }
        }
    }
}
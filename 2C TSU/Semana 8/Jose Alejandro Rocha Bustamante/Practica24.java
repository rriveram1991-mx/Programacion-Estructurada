import java.util.Scanner;
public class Practica24 {
    public static void main(String[]args){
        Scanner leer = new Scanner(System.in);
        int [] Estadodeanimo = new int[7];
        int [][] actividades = new int[7][3];

        int dia = 0;
        int opcion = 0;

        while (opcion != 5){
            System.out.println("=== Menú ===");
            System.out.println("=== 1. Registrar estado de ánimo ===");
            System.out.println("=== 2. Registrar actividades ===");
            System.out.println("=== 3. Ver reporte de ánimo ===");
            System.out.println("=== 4. Ver reporte de actividades ===");
            System.out.println("=== 5. Salir ===");
            opcion = leer.nextInt();
            switch (opcion){
                case 1:
                    if (dia < 7){
                        System.out.println(" === Ingrese su estado de animo (del 1 al 5) ===");
                        Estadodeanimo[dia] = leer.nextInt();
                        dia++;
                    }
                    else{
                        System.out.println("=== Se ha alcanzado 7 dias registrados ===");
                    }
                    break;
                    case 2:System.out.println("=== Dia a registrar (0-6): ===");
                    int dia2 = leer.nextInt();

                    if (dia2 >= 0 && dia2 < 7) {
                        for (int i = 0; i < 3; i++) {
                            System.out.println("=== Actividad " + (i + 1) + " (=== ¿Se realizo actividad? ===");
                            System.out.println("=== 1. Si ===");
                            System.out.println("=== 0. No ===");
                            actividades[dia2][i] = leer.nextInt();
                        }
                    }
                    break;

                case 3:
                    int suma = 0;
                    int contador = 0;

                    for (int i = 0; i < dia; i++) {
                        suma += Estadodeanimo[i];
                    }

                    double promedio = (dia > 0) ? (double) suma / dia : 0;

                    // contar actividades
                    for (int[] fila : actividades) {
                        for (int act : fila) {
                            if (act == 1) {
                                contador++;
                            }
                        }
                    }

                    System.out.println("=== Promedio de animo: " + promedio + " ===");
                    System.out.println("=== Total actividades: " + contador + " ===");

                    if (promedio < 3) {
                        System.out.println("=== Estado de animo: Bajo ===");
                    } else if (promedio < 4) {
                        System.out.println("=== Estado de animo: Medio ===");
                    } else {
                        System.out.println("=== Estado de animo: Alto ===");
                    }

                    break;

                case 4:
                    int suma2 = 0;

                    for (int i = 0; i < dia; i++) {
                        suma2 += Estadodeanimo[i];
                    }

                    double promedio2 = (dia > 0) ? (double) suma2 / dia : 0;

                    if (promedio2 < 3) {
                        System.out.println("=== Recomendacion: Descansa y medita ===");
                    } else if (promedio2 < 4) {
                        System.out.println("=== Recomendacion: Haz ejercicio ===");
                    } else {
                        System.out.println("=== Excelente! Sigue asi ===");
                    }

                    break;

                case 5:
                    System.out.println("=== Saliendo... ===");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        }

            }
        }

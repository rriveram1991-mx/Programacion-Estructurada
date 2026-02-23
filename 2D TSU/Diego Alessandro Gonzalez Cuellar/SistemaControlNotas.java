import java.util.Scanner;
import java.util.ArrayList;

public class SistemaControlNotas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        double total = 0;
        int cantidad = 0;
        boolean salir = false;
        ArrayList<Double> notas = new ArrayList<>();

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (!salir) {

            System.out.println("\n1. Capturar notas");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Reiniciar datos");
            System.out.println("5. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("Cuantas notas desea capturar: ");
                    int n = sc.nextInt();

                    for (int i = 0; i < n; i++) {

                        System.out.print("Ingrese nota #" + (i + 1) + ": ");
                        double nota = sc.nextDouble();

                        if (nota >= 0 && nota <= 10) {
                            total += nota;
                            cantidad++;
                            notas.add(nota);
                        } else {
                            System.out.println("Nota invalida");
                        }
                    }

                    break;

                case 2:

                    if (cantidad == 0) {
                        System.out.println("No se captura la nota por que es 0");
                        break;
                    }

                    double promedio = total / cantidad;
                    System.out.printf("Promedio: %.2f%n", promedio);

                    if (promedio >= 9) {
                        System.out.println("Excelente");
                    } else if (promedio >= 8) {
                        System.out.println("Bueno");
                    } else if (promedio >= 7) {
                        System.out.println("Regular");
                    } else if (promedio >= 6) {
                         System.out.println("Suficiente");
                    } else {
                        System.out.println("Reprobado");
                    }
                    
                    break;

                case 3:

                    int aprobados = 0;
                    int reprobados = 0;

                    int i = 0;
                    while (i < cantidad) {
                        if (notas.get(i) >= 6.0)
                            aprobados++;
                        else
                            reprobados++;
                        i++;
                    }

                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados);
                    break;

                case 4:
                    notas.clear();
                    total = 0;
                    cantidad = 0;
                    System.out.println("Datos reiniciados");
                    break;

                case 5:
                    salir = true;
                    System.out.println("Saliendo del sistema");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }

        }

        sc.close();
    }
}
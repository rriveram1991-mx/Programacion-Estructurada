import java.util.Scanner;

public class SistemaControlNotas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
        int cantidad = 0;
        boolean salir = false;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        // aquí lo corregí porque antes decía (salir = false)
        // y eso estaba mal, debe ser !salir
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

                    // aquí cambié <= por < porque estaba pidiendo una nota extra
                    for (int i = 0; i < n; i++) {

                        System.out.print("Ingrese nota #" + (i + 1) + ": ");
                        int nota = sc.nextInt();

                        // aquí quité el punto y coma después del if
                        // porque hacía que el else marcara error
                        if (nota >= 0 && nota <= 10) {
                            total += nota;
                            cantidad++;
                        } else {
                            System.out.println("Nota invalida");
                        }
                    }

                    // aquí agregué break porque se estaba pasando al case 2 solo
                    break;

                case 2:

                    // agregué esta validación porque podía dividir entre 0
                    if (cantidad == 0) {
                        System.out.println("No hay notas registradas.");
                    } else {

                        // aquí hice casting a double porque estaba dividiendo enteros
                        double promedio = (double) total / cantidad;

                        System.out.println("Promedio: " + promedio);

                        if (promedio >= 9) {
                            System.out.println("Excelente");
                        } else if (promedio >= 8) {
                            System.out.println("Bueno");
                        } 
                        // aquí también quité un punto y coma que tenía el else if
                        else if (promedio >= 7) {
                            System.out.println("Regular");
                        } else {
                            System.out.println("Reprobado");
                        }
                    }

                    break;

                case 3:

                    if (cantidad == 0) {
                        System.out.println("No hay notas registradas.");
                    } else {

                        int aprobados = 0;
                        int reprobados = 0;

                        int i = 0;

                        // aquí quité el punto y coma del while
                        while (i < cantidad) {

                            double promedio = (double) total / cantidad;

                            if (promedio >= 7) {
                                aprobados++;
                            } else {
                                reprobados++;
                            }

                            i++;
                        }

                        System.out.println("Aprobados: " + aprobados);
                        System.out.println("Reprobados: " + reprobados);
                    }

                    break;

                case 4:

                    total = 0;
                    cantidad = 0;
                    System.out.println("Datos reiniciados");

                    // también faltaba break aquí
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
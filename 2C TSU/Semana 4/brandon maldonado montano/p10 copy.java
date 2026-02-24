import java.util.Scanner;

public class p10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
        int cantidad = 0;
        boolean salir = false;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        // ERROR LÓGICO: usar asignación en la condición del while
        // while (salir = false) -> debe ser while (!salir)
        while (salir = false) {

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

                    // ERROR LÓGICO: for (int i = 0; i <= n; i++) -> debe ser i < n
                    for (int i = 0; i <= n; i++) {

                        // ERROR LÓGICO: etiqueta de nota comienza en 0
                        System.out.print("Ingrese nota #" + i + ": ");
                        int nota = sc.nextInt();

                        // ERROR LÓGICO: semicolon acaba la condición if
                        // if (nota >= 0 && nota <= 10);
                        if (nota >= 0 && nota <= 10);
                            total += nota;
                            cantidad++;
                        else // ERROR LOGICO :falta de corchetes
                            System.out.println("Nota invalida");
                    }

                case 2:

                    // ERROR LÓGICO: no hay break; caería al caso 3, 4, 5
                    double promedio = total / cantidad;
                    System.out.println("Promedio: " + promedio);

                    // ERROR LÓGICO: else if con punto y coma
                    // else if (promedio >= 7);
                    if (promedio >= 9)
                        System.out.println("Excelente");
                    else if (promedio >= 8)
                        System.out.println("Bueno");
                    else if (promedio >= 7);
                        System.out.println("Regular");
                    else
                        System.out.println("Reprobado");

                    break;

                case 3:

                    // ERROR LÓGICO: se intenta contar aprobados/reprobados sin almacenar notas
                    int aprobados = 0;
                    int reprobados = 0;

                    int i = 0;
                    // ERROR LÓGICO: while (i < cantidad); tiene punto y coma, se ejecuta solo una vez o se comporta mal
                    while (i < cantidad); {
                        if (total / cantidad >= 7)
                            aprobados++;
                        else
                            reprobados++;
                        i++;
                    }

                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados);
                    break;

                case 4:

                    total = 0;
                    cantidad = 0;
                    System.out.println("Datos reiniciados");

                case 5:

                    salir = true;
                    System.out.println("Saliendo del sistema");

                default:
                    System.out.println("Opcion no valida");
            }

        }

        sc.close();
    }
}
//Paola Geraldine Diaz Altamira 
import java.util.Scanner;

public class SistemaControlNotas {

  import java.util.Scanner; //ya aparecio

public class SistemaControlNotas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int total = 0;
        int cantidad = 0;
        boolean salir = false;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (salir = false) { // Está asignando false en lugar de comparar.
        // El ciclo nunca se ejecuta.

            System.out.println("\n1. Capturar notas");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Reiniciar datos");
            System.out.println("5. Salir");
            System.out.print("Seleccione opcion: ");

            opcion = sc.nextInt();  // No se valida si el usuario ingresa letras 

            switch (opcion) {

                case 1:

                    System.out.print("Cuantas notas desea capturar: ");
                    int n = sc.nextInt();

                    for (int i = 0; i <= n; i++) {  // Debería ser i < n, aquí captura una nota extra

                        System.out.print("Ingrese nota #" + i + ": ");
                        int nota = sc.nextInt();

                        if (nota >= 0 && nota <= 10); // El punto y coma termina el if

                            total += nota;
                            cantidad++;
                        else // Este else queda sin if válido por el ; anterior
                            System.out.println("Nota invalida");
                    }

                // Falta break; aquí
                case 2:

                    double promedio = total / cantidad; // División entera, debería convertirse a double
                    // Si cantidad es 0 → división entre cero

                    System.out.println("Promedio: " + promedio);

                    if (promedio >= 9)
                        System.out.println("Excelente");
                    else if (promedio >= 8)
                        System.out.println("Bueno");
                    else if (promedio >= 7);  // Punto y coma rompe la condición

                        System.out.println("Regular"); // Se ejecuta siempre
                    else 
                        System.out.println("Reprobado");

                    break;

                case 3:

                    int aprobados = 0;
                    int reprobados = 0;
                    int i = 0;

                    while (i < cantidad);   // El punto y coma crea un ciclo vacío

                    { 
                        if (total / cantidad >= 7) // Está evaluando el promedio general,
                        // no cada nota individual

                            aprobados++;
                        else
                            reprobados++;

                        i++;  // No está recorriendo notas reales porque no existen almacenadas
                    }

                    System.out.println("Aprobados: " + aprobados);
                    System.out.println("Reprobados: " + reprobados);

                    break;

                case 4:

                    total = 0;
                    cantidad = 0;

                    System.out.println("Datos reiniciados");

		// Falta break; 
                case 5:

                    salir = true;
                    System.out.println("Saliendo del sistema");

                // igual falta break; entonces ejecuta default

                default:
                    System.out.println("Opcion no valida");
                    //Error lógico puede mostrar este mensaje aunque sí fue válida la opción
            }
        }

        sc.close();
    }
}


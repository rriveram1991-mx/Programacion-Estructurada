import java.util.Scanner;

public class SistemaControlNotas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion; 
        int total = 0;
        int cantidad = 0;
        boolean salir = false;

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
                case 1 -> {
                    System.out.print("Cuantas notas desea capturar: ");
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Ingrese nota #" + (i + 1) + ": ");
                        int nota = sc.nextInt();
                        if (nota >= 0 && nota <= 10) {
                            total +=nota;
                            cantidad++;
                        } else {
                            System.out.println("Nota invalida");
                        }
                    }
                }
                case 2 -> {
                   
                    if (cantidad == 0) {
                        System.out.println("No se han capturado notas");
                        break;
                    }
                    double promedio =(double) total / cantidad;
                    System.out.println("Promedio: " + promedio);
                   
                    if (promedio >= 9 && promedio <= 10){
                        System.out.println("Excelente");
                    }
                    else if (promedio >= 8 && promedio < 9){
                        System.out.println("Bueno");
                    }
                    else if (promedio >= 7 && promedio < 8){
                        System.out.println("Regular");
                    }
                    else{
                        System.out.println("Reprobado");
                    }
                }
        case 3 -> {
            if (cantidad == 0) {
                System.out.println("No se han capturado notas");
                break;
            }

            int aprobados = 0;
            int reprobados = 0;

            double promedio3 = (double) total / cantidad;

            if (promedio3 >= 7) {
                aprobados = cantidad;
            } else {
                reprobados = cantidad;
            }

            System.out.println("Aprobados: " + aprobados);
            System.out.println("Reprobados: " + reprobados);
        }
                case 4 -> {
                    if (cantidad == 0) {
                        System.out.println("No se han capturado notas");
                        break;
                    }
                    total = 0;
                    cantidad = 0;
                    System.out.println("Datos reiniciados");
                }
                case 5 -> {
                    salir = true;
                    System.out.println("Saliendo del sistema");
                }
                default -> System.out.println("Opcion no valida");
            }

        }

        sc.close();
    }
}

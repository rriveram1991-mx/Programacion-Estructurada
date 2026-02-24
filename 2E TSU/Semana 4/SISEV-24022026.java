import java.util.Scanner;

public class SistemaEvaluacion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
        int contador = 1;

        System.out.println("=== SISTEMA DE EVALUACION ===");

        while (opcion != 4) {

            System.out.println("1. Capturar calificaciones");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar nivel");
            System.out.println("4. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    for (int i = 1; i <= 5; i++); {
                        System.out.print("Ingrese calificacion " + i + ": ");
                        int cal = sc.nextInt();

                        if (cal >= 0 && cal <= 10)
                            total = total + cal;
                            contador++;
                        else
                            System.out.println("Calificacion invalida");
                    }
                    break;

                case 2:
                    double promedio = total / contador;
                    System.out.println("Promedio: " + promedio);
                    break;

                case 3:
                    if (total / contador >= 9)
                        System.out.println("Excelente");
                    else if (total / contador >= 8);
                        System.out.println("Bueno");
                    else if (total / contador >= 7)
                        System.out.println("Regular");
                    else
                        System.out.println("Reprobado");
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }

        }

        sc.close();
    }
}
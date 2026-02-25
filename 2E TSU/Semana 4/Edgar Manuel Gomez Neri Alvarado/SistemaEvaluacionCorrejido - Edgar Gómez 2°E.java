import java.util.Scanner;

public class SistemaEvaluacion2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
        int contador = 0;
        double promedio = 0;

        System.out.println("=== SISTEMA DE EVALUACION ===");

        while (opcion != 4) {

            System.out.println("1. Capturar calificaciones");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar nivel");
            System.out.println("4. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> { for (int i = 1; i <= 5; i++) {
                        System.out.print("Ingrese calificacion " + i + ": ");
                        int cal = sc.nextInt();

                        if (cal >= 0 && cal <= 10){
                            total = total + cal;
                            contador++;
                        } else {
                            System.out.println("Calificacion invalida");
                        }}
                    if (total == 0 || contador == 0){
                    } else {
                        System.out.println("Cantidad de datos:"+contador);
                        promedio = (double) total / contador;
                    }
                    break;
            }
                case 2 -> {
                    if (contador == 0){
                        System.out.println("Error, valores no definidos.");
                    } else {
                        System.out.println("Cantidad de datos:"+contador);
                        promedio = (double) total / contador;
                        System.out.println("Promedio: " + promedio);
                    }
                    break;
            }

                case 3 -> {
                    if(promedio > 0){
                        // ---------------------------------------
                        if (promedio >= 9)
                            System.out.println("Excelente");
                        else if (promedio >= 8)
                            System.out.println("Bueno");
                        else if (promedio >= 7)
                            System.out.println("Regular");
                        else
                            System.out.println("Reprobado");
                        // ---------------------------------------     
                    } else {
                        System.out.println("Error, valores no definidos.");
                    }
                    break;
            }

                case 4 -> System.out.println("Saliendo...");

                default -> System.out.println("Opcion incorrecta");
            }
        }
        sc.close();
    }
}


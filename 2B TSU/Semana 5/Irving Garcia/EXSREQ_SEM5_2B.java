import java.util.Scanner;

public class EXSREQ_SEM5_2B {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 3) {

            System.out.println("===== SUPER MARIO ESCOLAR =====");
            System.out.println("       1. Iniciar nivel");
            System.out.println("       2. Instrucciones");
            System.out.println("       3. Salir del juego");
            System.out.println("===============================");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    int cantcal;
                    int cal;
                    double prom = 0;
                    System.out.println("=========================================");
                    System.out.print("  ¿Cuántas calificaciones quiere registrar?: ");
                    cantcal = sc.nextInt();
                    System.out.println("=========================================");

                    for (int i = 1; i <= cantcal; i++) {
                        System.out.print("Ingrese la calificación #" + i + ": ");
                        cal = sc.nextInt();

                        if (cal >= 0 && cal <= 100) {
                            prom = prom + cal;
                        } else {
                            System.out.println("=========================================");
                            System.out.println("  Calificación fuera del rango (0-100)");
                            i--;
                            System.out.println("=========================================");
                        }
                    }

                    prom = prom / cantcal;
                    System.out.println("         Su promedio es de: " + prom);
                    System.out.println("=========================================");
                    break;

                case 2:
                    System.out.println("=========================================");
                    System.out.println("              INSTRUCCIONES");
                    System.out.println(" Ingresa calificaciones válidas (0 a 100)");
                    System.out.println("    El sistema calculará tu promedio");
                    System.out.println("=========================================");
                    break;

                case 3:
                    System.out.println("=========================================");
                    System.out.println("Gracias por jugar Super Mario Escolar");
                    System.out.println("=========================================");
                    break;

                default:
                    System.out.println("Opción no reconocida");
                    break;
            }
        }
        sc.close();
    }
}
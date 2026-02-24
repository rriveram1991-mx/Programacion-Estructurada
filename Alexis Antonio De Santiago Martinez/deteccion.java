import java.util.Scanner;

public class deteccion {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
        int cantidad = 0;
        boolean salir = false;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (salir == false) {//no estaba bien indicado el false, hacia falta un segundo simbolo =

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

                    for (int i = 1; i <= n; i++) {//la variable int i tenia que estar igualada a 1

                        System.out.print("Ingrese nota #" + i + ": ");
                        int nota = sc.nextInt();

                        if (nota >= 0 && nota <= 10){ //habia un ; donde no habia, y no tenia llave de inicio
                            total += nota;
                            cantidad++;   }//hacia falta la llave de cierre
                          else 
                             System.out.println("Nota invalida");
                                }
                                break; //hacia falta un break para terminar con el caso 1
                case 2:

                    double promedio = (double)total / cantidad; //hacia falta indicar (double)
                    System.out.println("Promedio: " + promedio);

                    if (promedio >= 9)
                        System.out.println("Excelente");
                    else if (promedio >= 8)
                        System.out.println("Bueno");
                    else if (promedio >= 7)
                        System.out.println("Regular");
                    else if (promedio>= 6)
                        System.out.println("Reprobado");

                    break;//necesitaba un break

                case 3:

                    int aprobados = 0;
                    int reprobados = 0;

                    int i = 0;
                    while (i < cantidad) {
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
                    break; //necesitaba break;
                case 5:

                    salir = true;
                    System.out.println("Saliendo del sistema");
                    break; //necesitaba break;

                default:
                    System.out.println("Opcion no valida");
            }

        }

        sc.close();
    }
}



































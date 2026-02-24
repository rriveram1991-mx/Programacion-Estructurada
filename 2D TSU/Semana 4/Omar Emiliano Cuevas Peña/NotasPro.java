import java.util.Scanner;
//clase diferente al nombre del archivo
public class NotasPro {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //permite almacenar hasta 10 notas, pero no se valida el ingreso de mas de 100 notass
        int[] notas = new int[10];
        int opcion = 0;
        int total = 0;
        int cantidad = 0;
        boolean salir = false;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");
        //error logico (asignacion en lugar de comparacion)
        while (salir == false) {

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

                

                    for (int i = 1; i <= n; i++) {
                    
                    //error logico (no se valida el ingreso de mas de 10 notas, lo que puede causar un error de indice fuera de rango)
                    if (cantidad >= notas.length) {
                    System.out.println("Limite maximo de notas alcanzado.");
                    break;
                    }

                        System.out.print("Ingrese nota #" + i + ": ");
                        int nota = sc.nextInt();
                        
                        //punto y coma rompen el sistema del if 
                        if (nota >= 0 && nota <= 10) {
                            //error logico (no se almacena la nota en el arreglo)
                            notas[cantidad] = nota;
                            total += nota;
                            cantidad++;
                        } else {
                            System.out.println("Nota invalida");
                        }
                    }
                    //no hay break    
                    break;
                case 2:
                //mala practica (division entera en lugar de decimal)
                //se puede dividir entre 0
                double promedio = 0;
                if (cantidad == 0) {
                System.out.println("No hay notas registradas.");
                    } else {
                        promedio = (double) total / cantidad;
                    System.out.println("Promedio: " + promedio);
                    }
                    //error de compilacion (punto y coma despues del else if)
                    if (promedio >= 9)
                        System.out.println("Excelente");
                    else if (promedio >= 8)
                        System.out.println("Bueno");
                    //punto y coma rompen el sistema del else if
                    else if (promedio >= 7)
                        System.out.println("Regular");
                    else
                        System.out.println("Reprobado");

                    break;

                case 3:

                    int aprobados = 0;
                    int reprobados = 0;
//error logico (uso while en lugar de for y de mala forma)
                    int i = 0;
                    //for en lugar de while y sin punto y coma
                    while (i < cantidad) {
                        //error logico (division total/cantidad en lugar de evaluar cada nota individualmente)
                        if (notas[i] >= 7)
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
                    //no hay break
                    break;

                case 5:

                    salir = true;
                    System.out.println("Saliendo del sistema");
                    //no hay break
                    break;
                //se ejecuta el default aunque la opcion sea valida por falta de break en el case 1,4 y 5
                default:
                    System.out.println("Opcion no valida");
            }

        }

        sc.close();
    }
}
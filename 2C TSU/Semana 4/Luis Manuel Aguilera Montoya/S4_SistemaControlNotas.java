//Luis Manuel Aguilera Montoya

import java.util.Scanner;

public class S4_SistemaControlNotas {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Declarar variables
        int opcion = 0, total = 0, cantidad = 0, aprobados = 0, reprobados = 0;
        boolean salir = false;

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        //Menu de opciones usando while
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

                    for (int i = 1; i <= n; i++) //Se ejecuta el ciclo, el número de veces a repetirse es igual al número de notas
                    {
                        System.out.print("Ingrese nota #" + i + ": ");
                        int nota = sc.nextInt();

                        if (nota >= 0 && nota <= 10)    //Mientras que notas este en el rango de 0 - 10 se ejecutará
                        {
                            total += nota;
                            cantidad++;

                            if (nota >= 7)              //Si la nota es superior o igual a 7 apruebas esa materia, si no repruebas
                                aprobados++;            //Aumentar en 1 la cantidad de examenes aprobados
                            else
                                reprobados++;           //Aumentar en 1 la cantidad de examenes reprobados
                        }     
                        else
                            System.out.println("Nota invalida");
                    }

                    break;

                case 2:
                    double promedio = total / cantidad;             //Se obtiene el promedio
                    System.out.println("Promedio: " + promedio);

                    if (promedio >= 9)                              //Te dice en una palabra como te fue en tu calificación promedio
                        System.out.println("Excelente");        
                    else if (promedio >= 8)
                        System.out.println("Bueno");
                    else if (promedio >= 7)
                        System.out.println("Regular");
                    else
                        System.out.println("Reprobado");

                    break;

                case 3:                                                     //Se muestran las cantidades de materias aprobadas y reprobadas del alumno
                    System.out.println("Aprobados: " + aprobados);      
                    System.out.println("Reprobados: " + reprobados);
                    break;

                case 4:                                                     //Se reinician los valores de las variables
                    total = 0;
                    cantidad = 0;
                    aprobados = 0;
                    reprobados = 0;
                    System.out.println("Datos reiniciados");
                    break;
                case 5:                                                     //Se sale del sistema y se acaba el programa
                    salir = true;
                    System.out.println("Saliendo del sistema");
                    break;

                default:
                    System.out.println("Opcion no válida");             //Se escribe un default por si no ocurre ningun case
                    break;
            }
        }
        sc.close();
    }
}
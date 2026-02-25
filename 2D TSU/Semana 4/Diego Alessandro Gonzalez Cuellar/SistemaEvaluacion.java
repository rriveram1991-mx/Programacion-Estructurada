import java.util.Scanner;

public class SistemaEvaluacion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
        // [ERROR LOGICO] contador iniciaba en 1 en vez de 0, afectaba el calculo del promedio
        // [ARREGLO] se cambio a 0 para que el conteo sea correcto
        int contador = 0;

        System.out.println("=== SISTEMA DE EVALUACION ===");

        while (opcion != 4) {

            System.out.println("1. Capturar calificaciones");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar nivel");
            System.out.println("4. Salir");

            System.out.print("Seleccione opcion: ");

            // [MALA PRACTICA] no se validaba si la entrada era un numero entero
            // [ARREGLO] si el usuario escribe texto se muestra un mensaje y regresa al menu sin crashear
            if (!sc.hasNextInt()) {
                System.out.println("Escriba un numero entero por favor");
                sc.next();
                continue;
            }

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    // [ERROR DE COMPILACION] el for tenia un ; al final que lo dejaba vacio
                    // [ARREGLO] se quito el ; para que el bloque se ejecutara correctamente
                    for (int i = 1; i <= 5; i++) {
                        System.out.print("Ingrese calificacion " + i + ": ");

                        // [MALA PRACTICA] no se validaba si la entrada era un numero entero
                        // [ARREGLO] si escribe texto se avisa y se repite la misma posicion con i--
                        if (!sc.hasNextInt()) {
                            System.out.println("Escriba un numero entero por favor");
                            sc.next();
                            i--;
                            continue;
                        }

                        int cal = sc.nextInt();

                        // [ERROR DE COMPILACION] if sin llaves, contador++ se ejecutaba siempre
                        // aunque la calificacion fuera invalida, y el else quedaba huerfano
                        // [ARREGLO] se agregaron llaves para que solo cuente notas validas
                        if (cal >= 0 && cal <= 10) {
                            total = total + cal;
                            contador++;
                        } else {
                            System.out.println("Calificacion invalida");
                        }
                    }
                    break;

                case 2:
                    // [ERROR LOGICO] no se protegia contra division entre 0
                    // [ARREGLO] si no hay calificaciones se muestra un mensaje de error
                    // [ERROR LOGICO] total/contador eran dos int, el resultado se truncaba antes del double
                    // [ARREGLO] se usa (double) para obtener promedio decimal correcto
                    if (contador == 0) {
                        System.out.println("Error, no se puede dividir entre 0");
                    } else {
                        double promedio = (double) total / contador;
                        System.out.printf("Promedio: %.2f%n", promedio);
                    }
                    break;

                case 3:
                    // [ERROR LOGICO] no se protegia contra division entre 0
                    // [ARREGLO] misma proteccion que en el case 2
                    // [ERROR LOGICO] total/contador truncaba el resultado a entero en las comparaciones
                    // [ARREGLO] se calcula promedio decimal una sola vez y se usa en todas las comparaciones
                    // [ERROR LOGICO] else if (total/contador >= 8); tenia ; al final, rama vacia
                    // [ARREGLO] se quito el ; y se usa la variable promedio para comparar correctamente
                    if (contador == 0) {
                        System.out.println("Error, no se puede dividir entre 0");
                    } else {
                        double promedio = (double) total / contador;

                        if (promedio >= 9)
                            System.out.println("Excelente");
                        else if (promedio >= 8)
                            System.out.println("Bueno");
                        else if (promedio >= 7)
                            System.out.println("Regular");
                        else
                            System.out.println("Reprobado");
                    }
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
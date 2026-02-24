import java.util.Scanner;

public class SistemaEvaluacion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
        //mala practica (contador se inicializa en 1, lo que hace que el promedio sea incorrecto si el usuario selecciona la opción 2 sin haber seleccionado la opción 1 antes)
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
    //la opcion 1 funciona raro aveces porque
    //Si el usuario selecciona la opción 1 más de una vez, total y contador siguen acumulando valores de la sesión anterior,
            total = 0;
            contador = 1;
                    //error logico (punto y coma despues del for, lo que hace que el bloque del for no se ejecute correctamente)
                    for (int i = 1; i <= 5; i++) {
                        System.out.print("Ingrese calificacion " + i + ": ");
                        int cal = sc.nextInt();
                        
                        //falta de llaves para el bloque del if, lo que hace que el sistema no valide correctamente las calificaciones ingresadas
                        if (cal >= 0 && cal <= 10) {
                            total = total + cal;
                            contador++;
                        } else {
                            System.out.println("Calificacion invalida");
                        }
                    }
                    break;

                case 2:
                    //si el usuario selecciona la opción 2 sin haber seleccionado la opción 1 antes, el contador sera 1, lo que hace que el promedio sea incorrecto (total dividido entre 0)
                    if (contador == 1) {
                        System.out.println("No se han capturado calificaciones");
                    } else {
                        double promedio = (double) total / (contador - 1);
                        System.out.println("Promedio: " + promedio);
                    }
                    //el error logico es que se esta dividiendo el total entre el contador, pero el contador se inicializa en 1, lo que hace que el promedio sea incorrecto
                    break;

                case 3:
                    //el error logico es que se esta utilizando el promedio calculado en la opcion 2, pero si el usuario no ha seleccionado la opcion 2 antes, el promedio sera 0, lo que hace que el nivel mostrado sea incorrecto
                    //tambien se calcula el promedio nuevamente en lugar de utilizar una variable para almacenarlo, lo que hace que el sistema sea ineficiente
                    if (contador == 1) {//si el usuario selecciona la opción 3 sin haber seleccionado la opción 1 antes, el contador sera 1, lo que hace que el promedio sea incorrecto (total dividido entre 0)
                        System.out.println("No se han capturado calificaciones");
                    } else {
                        //mala practica lo ideal serial calcular el promedio una sola vez y almacenarlo en una variable, en lugar de calcularlo cada vez que se selecciona la opción 3, lo que hace que el sistema sea ineficiente
                    double promedio = (double) total / (contador - 1);
                    if (promedio >= 9)
                        System.out.println("Excelente");
                    else if (promedio >= 8)//punto y coma despues del else if, lo que hace que el bloque del else if no se ejecute correctamente
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
    


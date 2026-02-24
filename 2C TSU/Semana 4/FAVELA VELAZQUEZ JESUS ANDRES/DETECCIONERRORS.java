/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package deteccionerrors;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class DETECCIONERRORS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Scanner sc = new Scanner (System.in);
    int opcion = 0;
    // ERROR 1 [Mala Práctica]: 'total' era int. 
    // CORRECCIÓN: Se cambia a double para permitir decimales en el promedio y evitar truncamiento.
    double total = 0; 
    int cantidad = 0;
    boolean salir = false;

    System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

    // ERROR 2 [Lógico]: 'while (salir = false)' era una asignación.
    // CORRECCIÓN: Se usa '!salir' para evaluar el valor booleano. Antes el ciclo nunca iniciaba.
    while (!salir) {

        System.out.println("\n1. Capturar notas\n2. Mostrar promedio\n3. Mostrar estadisticas\n4. Reiniciar datos\n5. Salir");
        System.out.print("Seleccione opcion: ");
        opcion = sc.nextInt();

        switch (opcion) {

            case 1:
                System.out.print("Cuantas notas desea capturar: ");
                int n = sc.nextInt();

                // ERROR 3 [Lógico]: 'i <= n' causaba una iteración extra.
                // CORRECCIÓN: Se usa 'i < n' para capturar exactamente la cantidad solicitada.
                for (int i = 0; i < n; i++) {

                    // ERROR 4 [Mala Práctica]: 'Ingrese nota # + i' mostraba "Nota #0".
                    // CORRECCIÓN: Se usa '(i + 1)' para que sea legible para el usuario final.
                    System.out.print("Ingrese nota #" + (i + 1) + ": ");
                    int nota = sc.nextInt();

                    // ERROR 5 [Compilación]: Había un ';' después del if.
                    // CORRECCIÓN: Se elimina el ';' para que el bloque de código dependa de la condición.
                    // ERROR 6 [Mala Práctica]: Falta de llaves { }.
                    // CORRECCIÓN: Se agregan llaves para que tanto 'total' como 'cantidad' estén condicionados.
                    if (nota >= 0 && nota <= 10) {
                        total += nota;
                        cantidad++;
                    // ERROR 7 [Compilación]: 'else' estaba huérfano por el ';' del Error 5.
                    // CORRECCIÓN: Se vincula correctamente al bloque if.
                    } else {
                        System.out.println("Nota invalida");
                    }
                }
                // ERROR 8 [Lógico]: Falta de 'break'.
                // CORRECCIÓN: Se agrega break para evitar que el flujo pase al case 2 sin ser seleccionado.
                break;

            case 2:
                // ERROR 9 [Lógico]: No había validación de 'cantidad > 0'.
                // CORRECCIÓN: Se añade 'if' para evitar error de ejecución por división entre cero.
                if (cantidad > 0) {
                    // ERROR 10 [Lógico]: 'total / cantidad' perdía decimales por ser enteros.
                    // CORRECCIÓN: Al ser 'total' double, la división ahora es precisa.
                    double promedio = total / cantidad; 
                    System.out.println("Promedio: " + promedio);

                    if (promedio >= 9) {
                        System.out.println("Excelente");
                    } else if (promedio >= 8) {
                        System.out.println("Bueno");
                    // ERROR 11 [Sintaxis]: Había un ';' después del else if.
                    // CORRECCIÓN: Se elimina para que no ejecute el siguiente bloque por error.
                    } else if (promedio >= 7) {
                        System.out.println("Regular");
                    // ERROR 12 [Compilación]: El 'else' final no era reconocido.
                    // CORRECCIÓN: Se limpia la sintaxis eliminando los ';' previos.
                    } else {
                        System.out.println("Reprobado");
                    }
                } else {
                    System.out.println("No hay datos suficientes.");
                }
                // ERROR 13 [Lógico]: Falta de 'break' en el case 2 original.
                // CORRECCIÓN: Se añade para finalizar la ejecución del caso correctamente.
                break;

            case 3:
                // ERROR 14 [Lógico]: 'while (i < cantidad);' era un bucle infinito por el ';'.
                // CORRECCIÓN: Se elimina el bucle y el punto y coma.
                // ERROR 15 [Compilación]: 'int i' estaba duplicado dentro del mismo ámbito.
                // CORRECCIÓN: Se utiliza la variable 'cantidad' ya existente para las estadísticas.
                // ERROR 16 [Lógico]: La lógica de 'total / cantidad' dentro de un bucle era errónea.
                // CORRECCIÓN: Se sustituye por un reporte directo de los datos acumulados.
                System.out.println("Total de notas validas: " + cantidad);
                System.out.println("Suma total: " + total);
                break;

            case 4:
                total = 0;
                cantidad = 0;
                System.out.println("Datos reiniciados");
                // ERROR 17 [Lógico]: Falta de 'break' en el reinicio.
                // CORRECCIÓN: Se agrega para evitar que se ejecute el case 5 y se cierre el programa.
                break;

            case 5:
                salir = true;
                System.out.println("Saliendo del sistema");
                // ERROR 18 [Mala Práctica]: El case 5 no tenía break.
                // CORRECCIÓN: Se añade por estándar de programación estructurada.
                break;

            default:
                // ERROR 19 [Lógico]: No se manejaban opciones fuera del rango 1-5.
                // CORRECCIÓN: Se añade 'default' para dar retroalimentación al usuario.
                System.out.println("Opcion no valida");
                break;
        }
    }
    // ERROR 20 [Compilación]: Había una llave '}' antes de cerrar el scanner.
    // CORRECCIÓN: Se reestructura el cierre de llaves para incluir 'sc.close()' dentro del main.
    sc.close();
}
    }
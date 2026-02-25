import java.util.Scanner;

public class SistemaEvaluacion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        int total = 0;
        int contador = 1;  // <<<----------------------------->>> [Error lógico, debe empezar en 0]

        System.out.println("=== SISTEMA DE EVALUACION ===");

        while (opcion != 4) {

            System.out.println("1. Capturar calificaciones");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar nivel");
            System.out.println("4. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt(); // <<<----------------------------->>> [Mala practica, No se valida entrada no numérica]

            switch (opcion) {

                case 1: // <<<----------------------------->>> [Error lógico, No se reinician total ni contador.]
                    for (int i = 1; i <= 5; i++); { 
                               // <<<----------------------------->>> [Error de compilación, ";" Mal colocado]
                        System.out.print("Ingrese calificacion " + i + ": "); // <<<----------------------------->>> [Error de compilación, Debido al error anterior, "i" queda fuera de alcance dentro del bloque:]
                        int cal = sc.nextInt();  // <<<----------------------------->>> [Mala practica, No se valida entrada no numérica]

                        if (cal >= 0 && cal <= 10) // <<<----------------------------->>> [Error lógico, faltan llaves en el if]
                            total = total + cal;
                            contador++; // <<<----------------------------->>> [Error lógico, contador se ejecuta siempre, incluso si la calificación es inválida.]
                            else // <<<----------------------------->>> [Error de compilación, por el if, el else ya no pertenece al ciclo]
                            System.out.println("Calificacion invalida");
                    }
                    break;

                case 2:
                    double promedio = total / contador; // <<<----------------------------->>> [Error lógico, se pierden valores por la división entera]
                     // <<<----------------------------->>> [Error lógico, posible división entre 0]
                    System.out.println("Promedio: " + promedio);
                    break;

                case 3:
                    if (total / contador >= 9)  
                       // ^<<----------------------------->>> [Mala practica, Repetición innecesaria del cálculo]
                       // ^<<----------------------------->>> [Error lógico, se pierden valores por la división entera]
                        
                        System.out.println("Excelente");
                    else if (total / contador >= 8); // <<<----------------------------->>> [Error de compilación, ";" Mal colocado]
                       // ^<<----------------------------->>> [Mala practica, Repetición innecesaria del cálculo]
                       // ^<<----------------------------->>> [Error lógico, se pierden valores por la división entera]
                        System.out.println("Bueno"); // <<<----------------------------->>> [Error de compilación, ";" Mal colocado]
                    else if (total / contador >= 7) // <<<----------------------------->>> [Error de compilación, por el error anterior, queda fuera del bloque]
                       // ^<<----------------------------->>> [Mala practica, Repetición innecesaria del cálculo]
                       // ^<<----------------------------->>> [Error lógico, se pierden valores por la división entera]
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
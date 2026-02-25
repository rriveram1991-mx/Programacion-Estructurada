/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema.control.de.notas;
import java.util.Scanner;
/**
 *
 * @author jegh1
 */
public class SISTEMACONTROLDENOTAS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        boolean salir = false; //  Se usará correctamente en el while

        int total = 0;
        int cantidad = 0;

        int aprobados = 0;  //  Se agregaron contadores reales
        int reprobados = 0; //  Antes se calculaban incorrectamente

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        //  CORREGIDO: antes era (salir = false) → asignación
        while (!salir) {

            System.out.println("\n1. Capturar notas");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Reiniciar datos");
            System.out.println("5. Salir");

            System.out.print("Seleccione opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                // ===== CAPTURAR NOTAS =====
                case 1:

                    System.out.print("¿Cuantas notas desea capturar?: ");
                    int n = sc.nextInt();

                    //  CORREGIDO: validar cantidad positiva
                    if (n <= 0) {
                        System.out.println("Cantidad invalida");
                        break;
                    }

                    //  CORREGIDO: antes iniciaba en 0 y usaba <= n (pedía una de más)
                    for (int i = 1; i <= n; i++) {

                        System.out.print("Ingrese nota #" + i + ": ");
                        int nota = sc.nextInt();

                        //  CORREGIDO: antes había un ";" que anulaba el if
                        if (nota >= 0 && nota <= 10) {

                            total += nota;
                            cantidad++; // ✔ Antes se ejecutaba siempre

                            //  CORREGIDO: ahora sí se cuentan correctamente
                            if (nota >= 7)
                                aprobados++;
                            else
                                reprobados++;

                        } else {
                            System.out.println("Nota invalida (debe ser 0–10)");
                            i--; //  Nuevo: repite esa posición
                        }
                    }
                    break; //  CORREGIDO: faltaba break

                // ===== MOSTRAR PROMEDIO =====
                case 2:

                    // CORREGIDO: evita división entre cero
                    if (cantidad == 0) {
                        System.out.println("No hay notas registradas");
                        break;
                    }

                    // CORREGIDO: antes era división entera
                    double promedio = (double) total / cantidad;

                    System.out.println("Promedio: " + promedio);

                    if (promedio >= 9)
                        System.out.println("Excelente");
                    else if (promedio >= 8)
                        System.out.println("Bueno");
                    //  CORREGIDO: antes tenía ";" y siempre imprimía "Regular"
                    else if (promedio >= 7)
                        System.out.println("Regular");
                    else
                        System.out.println("Reprobado");

                    break;

                // ===== ESTADISTICAS =====
                case 3:

                    //  CORREGIDO: antes usaba un while con ";" (bucle vacío)
                    if (cantidad == 0) {
                        System.out.println("No hay datos");
                        break;
                    }

                    System.out.println("Total de notas: " + cantidad);
                    System.out.println("Aprobados: " + aprobados);   // ✔ Ahora reales
                    System.out.println("Reprobados: " + reprobados); // ✔ Ahora reales

                    break;

                // ===== REINICIAR =====
                case 4:

                    total = 0;
                    cantidad = 0;
                    aprobados = 0;
                    reprobados = 0;

                    System.out.println("Datos reiniciados");

                    break; //  CORREGIDO: faltaba break y caía al case 5

                // ===== SALIR =====
                case 5:

                    salir = true; //  Ahora sí permite salir del while
                    System.out.println("Saliendo del sistema...");
                    break; //  CORREGIDO: evita ejecutar default

                // ===== OPCION INVALIDA =====
                default:
                    System.out.println("Opcion no valida");
            }
        }

        sc.close(); //  Buena práctica: cerrar Scanner
    }
}

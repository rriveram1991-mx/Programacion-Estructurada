/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad2;

/**
 *
 * @author Guillermo
 */
import java.util.Scanner; 
public class S4_Deteccion_errores { 
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Guillermo Botello Regalado
//ERRORES DE COMPILACIÓN

//while (salir = false) → uso incorrecto de asignación en condición.

//if (nota >= 0 && nota <= 10); → punto y coma que rompe la estructura.

//else sin bloque válido debido al ; anterior.

//else if (promedio >= 7); → punto y coma rompe la estructura.

//while (i < cantidad); → punto y coma genera ciclo vacío.

//else mal asociado en estadísticas por el ;.

//División sin validación cuando cantidad == 0 (puede provocar error en ejecución).

//Variables declaradas dentro de case sin bloques {} (puede dar error según versión del compilador).

//Falta break en case 1.

//Falta break en case 4.

//Falta break en case 5.

//default se ejecuta incluso después de case 5.

//Variable i redeclarada innecesariamente en estadísticas.

//Uso incorrecto de división entera en promedio.

//Posible división entre cero.

//Incremento de cantidad aunque nota sea inválida (por error del ;).

//El ciclo for inicia en 0 mostrando "nota #0".

//<= n provoca una captura extra.

//Lógica de aprobados usa total / cantidad en vez de cada nota.

//No se almacenan notas individualmente (imposible calcular estadísticas reales).

//ERRORES LÓGICOS

//El while (salir = false) provoca bucle infinito o mal comportamiento.

//Las estadísticas no cuentan aprobados reales.

//El promedio puede mostrar valores incorrectos por división entera.

//El sistema permite mostrar promedio sin notas.

//El menú puede ejecutar múltiples casos por falta de break.

//Reiniciar datos no evita que continúe ejecutando otros casos.

//Se muestra “Regular” siempre por el ; en else if.

//Estadísticas usan promedio en lugar de analizar cada nota.

//No valida entradas negativas correctamente.

//Mensaje “Opcion no valida” se ejecuta aunque se elija salir.

        int opcion = 0; 
        // Se mantiene igual.

        int total = 0; 
        // Se mantiene para acumular la suma de notas.

        int cantidad = 0; 
        // Se mantiene para contar cuántas notas válidas hay.

        int aprobados = 0; 
        // Se agrega contador real de aprobados.

        int reprobados = 0; 
        // Se agrega contador real de reprobados.

        boolean salir = false; 
        // Se mantiene, pero se usará correctamente en el while por que la condicion estaba mal del while.

        System.out.println("=== SISTEMA DE CONTROL DE NOTAS ===");

        while (!salir) { 
        // Antes era (salir = false) y eso daba error en al quere comparar para salr y se breackeaba el codigo

            System.out.println("1. Capturar notas");
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
                    // Antes iniciaba en 0 y estaba mal aplicado <=.

                        System.out.print("Ingrese nota #" + i + ": ");
                        int nota = sc.nextInt();

                        if (nota >= 0 && nota <= 10) { 
                        //Se eliminó el ; que rompía el if

                            total += nota; 
                            // Se acumula correctamente.

                            cantidad++; 
                            // Solo aumenta si la nota es válida.

                            if (nota >= 7)
                                aprobados++; 
                            else
                                reprobados++; 
                            //Ahora sí se cuentan correctamente, estaba mal hecho el sumador .

                        } else {
                            System.out.println("Nota invalida");
                            i--; 
                            // Repite el mensaje  si l anota es invalida antes no lo hacia 
                        }
                    }

                    break; 
                   //Antes faltaba break y ejecutaba más casos no terminaba nunca.

                case 2:

                    if (cantidad > 0) { 
                    //Evita división entre cero.

                        double promedio = (double) total / cantidad; 
                        // Se fuerza división decimal.
                        // Antes hacía división entera.

                        System.out.println("Promedio: " + promedio);

                        if (promedio >= 9)
                            System.out.println("Excelente");
                        else if (promedio >= 8)
                            System.out.println("Bueno");
                        else if (promedio >= 7) 
                            System.out.println("Regular"); 
                        // Se eliminó el ; que hacía que se cerra el codigo.
                        else
                            System.out.println("Reprobado");

                    } else {
                        System.out.println("No hay notas registradas.");
                    }

                    break;

                case 3:

                    if (cantidad > 0) {
                        System.out.println("Total de notas: " + cantidad);
                        System.out.println("Aprobados: " + aprobados);
                        System.out.println("Reprobados: " + reprobados);
                        System.out.println("Suma total: " + total);
                    } else {
                        System.out.println("No hay datos.");
                    }

                    break;

                case 4:

                    total = 0; 
                    cantidad = 0; 
                    aprobados = 0; 
                    reprobados = 0; 
                    //Ahora reinicia todos los contadores para que no sumen datos demas.

                    System.out.println("Datos reiniciados");

                    break;

                case 5:

                    salir = true; 
                    //Permite salir correctamente por que antes arriba al tener false generaba conflicto 

                    System.out.println("Saliendo del sistema");

                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        }

        sc.close(); 
    }
}

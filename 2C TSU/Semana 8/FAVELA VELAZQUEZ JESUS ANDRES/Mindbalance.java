/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mindbalance;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Mindbalance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        Scanner entrada = new Scanner(System.in); // Instanciamos el Scanner para leer la consola    
        int[] animo = new int[7]; // Array unidimensional para guardar el ánimo de los 7 días (inicia en 0)
        boolean[][] actividades = new boolean[7][3]; // Array bidimensional: 7 filas (días) x 3 columnas (actividades)
        
        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"}; // Array extra para mostrar los nombres de los días
        String[] nomActividades = {"Hacer ejercicio", "Comer sano", "Dormir 8 horas"}; // Nombres de las actividades a evaluar
        
        int opcion = 0; // Variable para controlar el menú principal
        
        do { // Iniciamos el ciclo do-while que mantendrá el menú activo hasta elegir Salir
            // Mostramos el menú en consola
            System.out.println("\n--- MINDBALANCE - CONTROL DE BIENESTAR ---"); 
            System.out.println("1. Registrar estado de animo diario"); 
            System.out.println("2. Registrar actividades saludables"); 
            System.out.println("3. Ver resumen de bienestar"); 
            System.out.println("4. Ver recomendaciones automaticas"); 
            System.out.println("5. Salir"); 
            System.out.print("Elige una opcion: "); 
            
            // Validación: comprobamos si el usuario ingresó un número entero
            if (entrada.hasNextInt()) { 
                opcion = entrada.nextInt(); // Si es número, lo guardamos en 'opcion'
            } else { 
                System.out.println("Error: Ingresa un numero valido."); // Mensaje de error si pone letras
                entrada.next(); // Limpiamos el buffer del teclado para evitar un bucle infinito
                continue; // Saltamos a la siguiente iteración del do-while
            }
            
            // Evaluamos la opción elegida usando la estructura switch
            switch (opcion) { 
                case 1: // Caso 1: Registrar ánimo
                    System.out.println("\n--- REGISTRO DE ANIMO ---"); 
                    // Ciclo for para recorrer los 7 días
                    for (int i = 0; i < 7; i++) { 
                        int valorAnimo = 0; // Variable temporal para guardar el valor del día
                        boolean animoValido = false; // Bandera para el bucle de validación
                        
                        while (!animoValido) { // Mientras no se ingrese un dato válido (1 al 5)
                            System.out.print("¿Cómo te sentiste el " + dias[i] + "? (1=Muy mal, 2=Mal, 3=Neutral, 4=Bien, 5=Excelente): "); 
                            if (entrada.hasNextInt()) { // Verificamos que sea un número
                                valorAnimo = entrada.nextInt(); // Leemos el número
                                if (valorAnimo >= 1 && valorAnimo <= 5) { // Validamos que esté en el rango permitido
                                    animo[i] = valorAnimo; // Guardamos el valor en el array principal
                                    animoValido = true; // Cambiamos la bandera para salir del while
                                } else { 
                                    System.out.println("Error: El valor debe estar entre 1 y 5."); // Aviso de fuera de rango
                                }
                            } else { 
                                System.out.println("Error: Ingresa un número entero."); // Aviso si metió texto
                                entrada.next(); // Limpiamos el buffer
                            }
                        }
                    }
                    break; // Fin del Caso 1
                    
                case 2: // Caso 2: Registrar actividades en la matriz
                    System.out.println("\n--- REGISTRO DE ACTIVIDADES ---"); 
                    // Recorremos las filas (los 7 días)
                    for (int fila = 0; fila < 7; fila++) { 
                        System.out.println("Para el " + dias[fila] + ":"); 
                        // Recorremos las columnas (las 3 actividades)
                        for (int col = 0; col < 3; col++) { 
                            int respuesta = -1; // Inicializamos variable para la respuesta (1 o 0)
                            
                            while (respuesta != 1 && respuesta != 0) { // Validamos que solo responda 1 o 0
                                System.out.print("¿Hiciste la actividad '" + nomActividades[col] + "'? (1 = Sí / 0 = No): "); 
                                if (entrada.hasNextInt()) { // Comprobamos que sea número
                                    respuesta = entrada.nextInt(); // Guardamos el número
                                    if (respuesta == 1) { 
                                        actividades[fila][col] = true; // Si es 1, guardamos true en la matriz
                                    } else if (respuesta == 0) { 
                                        actividades[fila][col] = false; // Si es 0, guardamos false
                                    } else { 
                                        System.out.println("Por favor, ingresa solo 1 o 0."); // Aviso de opción incorrecta
                                    }
                                } else { 
                                    System.out.println("Error: Caracter no válido."); // Aviso si mete letras
                                    entrada.next(); // Limpiamos buffer
                                }
                            }
                        }
                    }
                    break; // Fin del Caso 2
                    
                case 3: // Caso 3: Resumen y cálculos
                    System.out.println("\n--- RESUMEN DE TU BIENESTAR ---"); 
                    
                    double sumaAnimo = 0; // Variable para sumar todos los estados de ánimo
                    int peorDiaIndex = 0; // Guardará la posición del día con el puntaje más bajo
                    int peorPuntaje = 5; // Inicializamos con el máximo posible para ir bajando
                    boolean datosIngresados = false; // Para verificar si ya se llenó el array de ánimo
                    
                    // Ciclo for para calcular el promedio y detectar el peor día
                    for (int i = 0; i < 7; i++) { 
                        if (animo[i] != 0) { // Si es diferente de 0, significa que sí registraron datos
                            datosIngresados = true; // Confirmamos que hay datos
                        }
                        sumaAnimo = sumaAnimo + animo[i]; // Acumulamos la suma de los valores
                        
                        // Reto: Detectar el peor día
                        if (animo[i] < peorPuntaje && animo[i] != 0) { // Buscamos el valor más pequeño
                            peorPuntaje = animo[i]; // Actualizamos el récord del puntaje más bajo
                            peorDiaIndex = i; // Guardamos en qué día ocurrió
                        }
                    }
                    
                    if (!datosIngresados) { // Si todo el array es 0...
                        System.out.println("Aun no has registrado tu estado de animo."); // Pedimos registrar primero
                        break; // Salimos del case 3 prematuramente
                    }
                    
                    double promedio = sumaAnimo / 7; // Calculamos el promedio dividiendo entre 7
                    System.out.println("Tu promedio de estado de animo es: " + promedio); // Mostramos el resultado
                    
                    // Contar actividades usando for-each
                    int contadorActividades = 0; // Acumulador de actividades realizadas
                    // El primer for-each extrae cada fila (arreglo unidimensional) de la matriz
                    for (boolean[] diaActual : actividades) { 
                        // El segundo for-each recorre cada valor booleano dentro de esa fila
                        for (boolean hizoActividad : diaActual) { 
                            if (hizoActividad) { // Si el valor es true
                                contadorActividades++; // Sumamos 1 al contador
                            }
                        }
                    }
                    
                    System.out.println("Total de actividades saludables realizadas en la semana: " + contadorActividades + " de 21 posibles."); // Mostramos total
                    
                    // Determinar nivel de bienestar
                    System.out.print("Nivel de bienestar general: "); 
                    if (promedio >= 4) { // Si el promedio es mayor o igual a 4
                        System.out.println("ALTO"); // Nivel alto
                    } else if (promedio >= 3) { // Si el promedio está entre 3 y 3.99
                        System.out.println("MEDIO"); // Nivel medio
                    } else { // Si es menor a 3
                        System.out.println("BAJO"); // Nivel bajo
                    }
                    
                    // Mostrar el peor día (Reto adicional)
                    System.out.println("El dia mas pesado para ti fue el: " + dias[peorDiaIndex] + " (Puntaje: " + peorPuntaje + ")"); 
                    
                    // Mensaje motivacional personalizado
                    System.out.println("\nMensaje del sistema:"); 
                    System.out.println("Recuerda que los malos días construyen buenos habitos. ¡Levanta la cara!"); 
                    
                    break; // Fin del Caso 3
                    
                case 4: // Caso 4: Recomendaciones automáticas
                    System.out.println("\n--- RECOMENDACIÓN ---"); 
                    // Necesitamos volver a calcular el promedio rápido para las recomendaciones
                    double suma = 0; // Acumulador temporal
                    for (int i = 0; i < 7; i++) suma += animo[i]; // Sumamos usando un for comprimido
                    double promRecomendacion = suma / 7; // Obtenemos promedio
                    
                    if (promRecomendacion == 0) { // Validación por si no hay datos
                        System.out.println("No hay datos suficientes para darte una recomendacion."); 
                    } else if (promRecomendacion < 3) { // Regla: menor a 3
                       System.out.println("Recomendacion de Ayrton Senna (1988): \n" +
                       "\"Quienquiera que seas, cualquiera que sea la posicion \n" +
                       "que tengas en la vida, la mas alta o la mas baja, \n" +
                       "siempre apunta a lo mas alto y hazlo con mucha determinacion y mucha fe en Dios. \n" +
                       "Que algun dia llegaras y de alguna manera llegaras\".");
                    } else if (promRecomendacion >= 3 && promRecomendacion < 4) { // Regla: entre 3 y 4
                        System.out.println("Recomendacion: Vas a buen ritmo. Para llegar al siguiente nivel, intenta agregar un poco más de ejercicio a tu rutina."); 
                    } else { // Regla: mayor o igual a 4
                        // Aquí va el guiño de F1 solicitado
                        System.out.println("¡Excelente trabajo! Tienes tu bienestar en excelentes condiciones NEVER GIVE UP.==CHECO PEREZ 2020 VICTORIA SHAKIR RACING POINT=="); 
                    }
                    break; // Fin del Caso 4
                    
                case 5: // Caso 5: Salida del sistema
                    System.out.println("Saliendo de MindBalance. ¡Nos vemos en la siguiente sesión de código!"); 
                    break; // Fin del Caso 5
                    
                default: // Caso por defecto si ingresa un número que no está en el menú (ej. 8)
                    System.out.println("Opción no válida. Intenta con un número del 1 al 5."); 
                    break; // Fin del default
            }
            
        } while (opcion != 5); // El ciclo se repite mientras no elija la opción 5
        
        entrada.close(); // Cerramos el Scanner para liberar los recursos de memoria
    }
}
    
   


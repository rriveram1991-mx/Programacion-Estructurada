/* Luis Manuel Aguilera Montoya
MindBalance – Control de Bienestar Mental

Desarrollar un sistema en Java que permita a un usuario registrar, analizar y mejorar su estado de bienestar mental mediante hábitos saludables diarios.
Valor	Estado
1	Muy mal
2	Mal
3	Neutral
4	Bien
5	Excelente

Registro de actividades saludables (CON ARRAY BIDIMENSIONAL)
El sistema deberá almacenar las actividades saludables utilizando un array bidimensional, donde:

Las filas representen los días (máximo 7 días)
Las columnas representen las actividades
*/

import java.util.Scanner;

public class REQ1_SEM8_2C_MindBalance
{
    public static void main(String[] args)
    {
        // --- Declaración de variables al inicio ---
        Scanner entrada = new Scanner(System.in);

        int[] estadosAnimo = new int[7];
        // 7 días (filas) y 3 actividades específicas (columnas): Meditación, Ejercicio, Lectura
        boolean[][] actividades = new boolean[7][3];
        String[] nombresActividades = {"Meditación", "Ejercicio", "Escuchar música"};
        
        int opcion = 0, diaActualAnimo = 0, diaActualActividades = 0, sumaAnimo = 0, totalActividades = 0, peorDia = 0; 
        double promedioAnimo = 0;
        int valorMinimo = 6; // Para calcular el peor día

        // --- Ciclo Principal ---
        while (opcion != 5) {
            System.out.println("\n### MINDBALANCE: CONTROL DE BIENESTAR ###");
            System.out.println("1. Registrar estado de ánimo (Día " + (diaActualAnimo + 1) + ")");
            System.out.println("2. Registrar actividades (Día " + (diaActualActividades + 1) + ")");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendación");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = entrada.nextInt();

            switch (opcion)
            {
                case 1:
                    if (diaActualAnimo < 7)
                        {
                        System.out.println("¿Cómo te sientes hoy? 1) Muy mal, 2) Mal, 3) Neutral, 4) Bien, 5) Excelente)");
                        int nota = entrada.nextInt();
                        if (nota > 0 && nota < 6)
                        {
                            estadosAnimo[diaActualAnimo] = nota;
                            diaActualAnimo++;
                            System.out.println("Estado registrado!");
                        } else
                        {
                            System.out.println("Dato incorrecto. Intente de nuevo...");
                        }
                    } else
                    {
                        System.out.println("Semana completa...");
                    }
                    break;

                case 2:
                    if (diaActualActividades < 7)
                    {
                        System.out.println("Registra tus actividades: 0) No , 1) Sí:");
                        for (int j = 0; j < 3; j++)
                        {
                            System.out.print("¿Realizaste " + nombresActividades[j] + "? ");
                            int realizo = entrada.nextInt();
                            actividades[diaActualActividades][j] = (realizo == 1);
                        }
                        diaActualActividades++;
                    } else
                    {
                        System.out.println("Actividades de la semana completas.");
                    }
                    break;

                case 3:
                    // Cálculo de Resumen
                    sumaAnimo = 0;
                    totalActividades = 0;
                    valorMinimo = 6;
                    peorDia = -1;

                    // Uso de for para promedio y detección de peor día
                    for (int i = 0; i < diaActualAnimo; i++)
                        {
                        sumaAnimo += estadosAnimo[i];
                        if (estadosAnimo[i] < valorMinimo)
                        {
                            valorMinimo = estadosAnimo[i];
                            peorDia = i + 1;
                        }
                    }
                    

                    // Lógica de cálculo
                    if (diaActualAnimo > 0)
                    {
                        promedioAnimo = (double) sumaAnimo / diaActualAnimo;
                    } else 
                    {
                    promedioAnimo = 0;
                    }

                    // Uso de for-each para contar actividades en el array bidimensional
                    for (boolean[] fila : actividades)
                    {
                        for (boolean realizada : fila)
                        {
                            if (realizada) totalActividades++;
                        }
                    }

                    System.out.println("\n--- RESUMEN SEMANAL ---");
                    System.out.printf("Promedio de ánimo: %.2f\n", promedioAnimo);
                    System.out.println("Total de actividades saludables: " + totalActividades);
                    
                    if (promedioAnimo < 3)
                        System.out.println("Nivel de Bienestar: BAJO");
                    else if (promedioAnimo <= 4)
                        System.out.println("Nivel de Bienestar: MEDIO");
                    else
                        System.out.println("Nivel de Bienestar: ALTO");

                    if (peorDia != -1)
                    {
                        System.out.println("El día con ánimo más bajo fue el día: " + peorDia);
                    }
                    break;

                case 4:
                    System.out.println("\n--- RECOMENDACIÓN ---");
                    if (promedioAnimo == 0)
                        System.out.println("Registra datos primero.");
                    else if (promedioAnimo < 3)
                        System.out.println("Te recomendamos priorizar el descanso y realizar 10 minutos de meditación.");
                    else if (promedioAnimo < 4)
                        System.out.println("Vas por buen camino. Intenta realizar algo de ejercicio para elevar tu energía.");
                    else
                        System.out.println("¡Excelente trabajo! Sigue manteniendo esos hábitos positivos.");

                    System.out.println("Mensaje motivacional: 'Cada pequeño paso cuenta para una mente sana'.");
                    break;

                case 5:
                    System.out.println("Saliendo... ¡Cuida tu salud mental!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
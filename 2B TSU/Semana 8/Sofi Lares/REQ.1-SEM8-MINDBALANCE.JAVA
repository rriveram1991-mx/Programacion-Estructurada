import java.util.Scanner;

public class MindBalance
{
    public static void main(String[] args) 
    {
        Scanner leer = new Scanner(System.in);
        
        
        int[] estadosAnimo = new int[7];
        int[][] actividades = new int[7][3];
        String[] nombresActividades = {"Ejercicio", "Meditación", "Lectura"};
        
        int opcion = 0;
        int diaActual = 0;
        while (opcion != 5)
         {
            System.out.println("\n----------BIENESTAR MENTAL------------");
            System.out.println("1. Registrar estado de ánimo (Día " + (diaActual + 1) + ")");
            System.out.println("2. Registrar actividades saludables");
            System.out.println("3. Ver resumen de bienestar");
            System.out.println("4. Ver recomendaciones");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();

            switch (opcion) 
            {
                case 1:
                    if (diaActual < 7) 
                    {
                        System.out.println("¿Cómo te sientes hoy? (1: Muy mal, 2: Mal, 3: Neutral, 4: Bien, 5: Excelente)");
                        int sentir = leer.nextInt();
                        if (sentir >= 1 && sentir <= 5) 
                        {
                            estadosAnimo[diaActual] = sentir;
                            System.out.println("Estado registrado correctamente.");
                        } 
                        else 
                        {
                            System.out.println("Valor inválido. Intenta de nuevo.");
                        }
                    } 
                    else 
                    {
                        System.out.println("Ya se completó el registro de la semana.");
                    }
                    break;

                case 2:
                    System.out.println("Registro de actividades para el día " + (diaActual + 1) + ":");
                    for (int j = 0; j < actividades[0].length; j++) 
                    {
                        System.out.print("¿Realizaste " + nombresActividades[j] + "? (1: Sí, 0: No): ");
                        actividades[diaActual][j] = leer.nextInt();
                    }
                    if (diaActual < 7) diaActual++; 
                    break;

                case 3:
                    double sumaAnimo = 0;
                    int totalActividades = 0;
                    int diasRegistrados = 0;

                   
                    for (int i = 0; i < 7; i++) 
                    {
                        if (estadosAnimo[i] != 0) 
                        {
                            sumaAnimo += estadosAnimo[i];
                            diasRegistrados++;
                        }
                    }

                    
                    for (int[] fila : actividades) 
                    {
                        for (int act : fila) 
                        {
                            if (act == 1) totalActividades++;
                        }
                    }

                    double promedio = (diasRegistrados > 0) ? sumaAnimo / diasRegistrados : 0;
                    System.out.println("\n--- RESUMEN SEMANAL ---");
                    System.out.printf("Promedio de ánimo: %.2f\n", promedio);
                    System.out.println("Total de actividades saludables: " + totalActividades);

                    if (promedio < 3) 
                    {
                        System.out.println("Nivel de bienestar: BAJO");
                    }
                    else if (promedio < 4) 
                    {
                        System.out.println("Nivel de bienestar: MEDIO");
                    }
                    else 
                    {
                        System.out.println("Nivel de bienestar: ALTO");
                    }
                    break;

                case 4:
                    
                    double promRec = 0;
                    int cont = 0;
                    for(int val : estadosAnimo) {
                        if(val != 0) { promRec += val; cont++; }
                    }
                    double finalProm = (cont > 0) ? promRec / cont : 0;

                    if (finalProm < 3) 
                    {
                        System.out.println("Tip: Te recomendamos priorizar el descanso y realizar una meditación guiada.");
                    } 
                    else if (finalProm >= 3 && finalProm < 4) 
                    {
                        System.out.println("Tip: ¡Vas por buen camino! Intenta añadir 20 min de ejercicio para elevar tu energía.");
                    } 
                    else if (finalProm >= 4) 
                    {
                        System.out.println("¡Excelente trabajo! Mantén esa actitud y sigue cuidando de ti.");
                    }
                    break;

                case 5:
                    System.out.println("¡Cuídate mucho! Hasta pronto.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } 
        
        leer.close();
    }
}
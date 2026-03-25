package semana;
import java.util.Scanner;
import java.util.Arrays;

public class Semana {
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        int[] estadosAnimo = new int[7];
        
        int[][] actividades = new int[7][3];
        
        int opcion = 0;
        
        do {
            System.out.println("\n--- Mi Balance ---");
            System.out.println("1. Registrar estado de ánimo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendación");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el número de día (1 al 7): ");
                    int diaA = leer.nextInt();
                    
                    if (diaA >= 1 && diaA <= 7) {
                        System.out.println("Estado: 1:Muy mal, 2:Mal, 3:Neutral, 4:Bien, 5:Excelente");
                        estadosAnimo[diaA - 1] = leer.nextInt();
                    } else {
                        System.out.println("Día no válido.");
                    }
                    break;

                case 2:
                    System.out.print("¿Para qué día (1 al 7) registrarás actividades?: ");
                    int diaAct = leer.nextInt();
                    if (diaAct >= 1 && diaAct <= 7) {
                        System.out.print("¿Hizo ejercicio? (1=Sí, 0=No): ");
                        actividades[diaAct - 1][0] = leer.nextInt();
                        System.out.print("¿Meditó? (1=Sí, 0=No): ");
                        actividades[diaAct - 1][1] = leer.nextInt();
                        System.out.print("¿Hizo un hobby? (1=Sí, 0=No): ");
                        actividades[diaAct - 1][2] = leer.nextInt();
                    } else {
                        System.out.println("Día no válido.");
                    }
                    break;

                case 3:
                    
                    double suma = 0;
                    int conteoDias = 0;
                    int peorDiaValor = 6; 
                    
                    for (int i = 0; i < 7; i++) {
                        if (estadosAnimo[i] != 0) {
                            suma = suma + estadosAnimo[i];
                            conteoDias++;
                            
                            if (estadosAnimo[i] < peorDiaValor) {
                                peorDiaValor = estadosAnimo[i];
                            }
                        }
                    }

                    if (conteoDias > 0) {
                        double promedio = suma / conteoDias;
                        System.out.println("\n--- RESUMEN ---");
                        System.out.println("Promedio de ánimo: " + promedio);
                        
                        if (promedio < 3) {
                            System.out.println("Bienestar: Bajo");
                        } else if (promedio >= 3 && promedio < 4) {
                            System.out.println("Bienestar: Medio");
                        } else {
                            System.out.println("Bienestar: Alto");
                        }
                        
                        int totalAct = 0;
                        for (int[] fila : actividades) {
                            for (int valor : fila) {
                                if (valor == 1) {
                                    totalAct++;
                                }
                            }
                        }
                        System.out.println("Actividades realizadas: " + totalAct);
                        System.out.println("Tu peor ánimo fue de nivel: " + peorDiaValor);
                    } else {
                        System.out.println("No hay datos registrados.");
                    }
                    break;

                case 4:
                    
                    double sumaR = 0;
                    int diasR = 0;
                    for (int i = 0; i < 7; i++) {
                        if (estadosAnimo[i] != 0) {
                            sumaR += estadosAnimo[i];
                            diasR++;
                        }
                    }

                    if (diasR > 0) {
                        double promR = sumaR / diasR;
                        if (promR < 3) {
                            System.out.println("Recomendación: Descanso y meditación.");
                        } else if (promR >= 3 && promR < 4) {
                            System.out.println("Recomendación: Hacer ejercicio.");
                        } else {
                            System.out.println("¡Felicidades por tu bienestar!");
                        }
                        
                        System.out.println("Mensaje: ¡Sigue esforzándote cada día!");
                    } else {
                        System.out.println("Registra datos primero.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
        
    }
    
}
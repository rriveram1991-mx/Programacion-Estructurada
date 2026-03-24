import java.util.Scanner;

public class MindBalance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        final int DIAS = 7;
        final int ACTIVIDADES = 3; // 0 - Meditación  1 - Ejercicio  2 - Lectura
        
        int[] estadosAnimo = new int[DIAS];

        int[][] registroActividades = new int[DIAS][ACTIVIDADES];
        
        String[] nombresActividades = {"Meditación", "Ejercicio", "Lectura"};
        int diaActualAnimo = 0;
        int diaActualActividades = 0;
        boolean salir = false;

        System.out.println("============= BIENVENIDO A MINDBALANCE  =============");

        while (!salir) {
            System.out.println("\n =============    MENÚ PRINCIPAL:    =============");
            System.out.println("1. Registrar estado de ánimo");
            System.out.println("2. Registrar actividades saludables");
            System.out.println("3. Ver resumen de bienestar");
            System.out.println("4. Ver recomendaciones automáticas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    if (diaActualAnimo < DIAS) {
                        System.out.println("\nValor del Estado: \n1:Muy mal., \n2:Mal., \n3:Neutral., \n4:Bien., \n5:Excelente.");
                        System.out.print("Día " + (diaActualAnimo + 1) + " - Ingrese su estado: ");
                        estadosAnimo[diaActualAnimo] = sc.nextInt();
                        diaActualAnimo++;
                    } else {
                        System.out.println("Ya se han registrado los 7 días de la semana.");
                    }
                    break;

                case 2:
                    if (diaActualActividades < DIAS) {
                        System.out.println("\nRegistro de Actividades - Dia " + (diaActualActividades + 1));
                        for (int j = 0; j < ACTIVIDADES; j++) {
                            System.out.print("¿Realizó " + nombresActividades[j] + "? (1:Sí, 0:No): ");
                            registroActividades[diaActualActividades][j] = sc.nextInt();
                        }
                        diaActualActividades++;
                    } else {
                        System.out.println("Registro de actividades completo para la semana.");
                    }
                    break;

                case 3:
                    System.out.println("\n============= RESUMEN DE BIENESTAR =============");
                    
                    double suma = 0;
                    for (int i = 0; i < diaActualAnimo; i++) {
                        suma += estadosAnimo[i];
                    }
                    double promedio = (diaActualAnimo > 0) ? suma / diaActualAnimo : 0;
                    
                    // Conteo de actividades con FOR-EACH (usando el array bidimensional)
                    int totalActividades = 0;
                    for (int[] filaDia : registroActividades) {
                        for (int realizado : filaDia) {
                            if (realizado == 1) totalActividades++;
                        }
                    }

                    System.out.printf("Promedio de estado de ánimo: %"+ promedio);
                    System.out.println("Total de actividades saludables realizadas por el usuario: " + totalActividades);
                    
                    // Nivel de bienestar
                    if (promedio < 3) System.out.println("Nivel de Bienestar: Bajo.");
                    else if (promedio < 4.5) System.out.println("Nivel de Bienestar: Medio.");
                    else System.out.println("Nivel de Bienestar: Alto.");
                    break;

                case 4:
                    System.out.println("\n============= RECOMENDACIÓN =============");
                    double promR = 0;
                    for (int i = 0; i < diaActualAnimo; i++) promR += estadosAnimo[i];
                    promR = (diaActualAnimo > 0) ? promR / diaActualAnimo : 0;

                    if (promR < 3) {
                        System.out.println("> Se recomienda priorizar el descanso y la meditación guiada.");
                    } else if (promR >= 3 && promR < 4) {
                        System.out.println("> Vas por buen camino. Intenta realizar un poco de ejercicio físico. :)");
                    } else if (promR >= 4) {
                        System.out.println("> Mantienes un excelente equilibrio mental. ¡Sigue así!");
                    }
                    break;

                case 5:
                    salir = true;
                    System.out.println("> Gracias por usar MindBalance."); 
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
}
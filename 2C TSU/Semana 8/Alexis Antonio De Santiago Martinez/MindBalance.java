import java.util.Scanner;

public class MindBalance {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] estadoAnimo = new int[7]; // 7 días
        int[][] actividades = new int[7][3]; // 3 actividades por día

        int diaActual = 0;
        int opcion;

        do {
            System.out.println("\n--- MIND BALANCE ---");
            System.out.println("1. Registrar estado de ánimo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendación");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    if (diaActual < 7) {
                        System.out.print("Ingresa tu estado de ánimo (1-5): ");
                        int estado = sc.nextInt();

                        if (estado >= 1 && estado <= 5) {
                            estadoAnimo[diaActual] = estado;
                            System.out.println("Estado registrado.");
                        } else {
                            System.out.println("Valor inválido.");
                        }
                    } else {
                        System.out.println("Ya registraste los 7 días.");
                    }
                    break;

                case 2:
                    if (diaActual < 7) {
                        System.out.println("Actividades del día (1=Sí, 0=No)");
                        for (int i = 0; i < actividades[diaActual].length; i++) {
                            System.out.print("Actividad " + (i + 1) + ": ");
                            int act = sc.nextInt();

                            if (act == 0 || act == 1) {
                                actividades[diaActual][i] = act;
                            } else {
                                System.out.println("Valor inválido, se guarda como 0.");
                                actividades[diaActual][i] = 0;
                            }
                        }
                        diaActual++; // avanzamos al siguiente día
                    } else {
                        System.out.println("Ya registraste los 7 días.");
                    }
                    break;

                case 3:
                    int suma = 0;
                    int contadorDias = 0;

                    for (int i = 0; i < estadoAnimo.length; i++) {
                        if (estadoAnimo[i] != 0) {
                            suma += estadoAnimo[i];
                            contadorDias++;
                        }
                    }

                    if (contadorDias > 0) {
                        double promedio = (double) suma / contadorDias;
                        System.out.println("Promedio de ánimo: " + promedio);

                        int totalActividades = 0;

                        for (int[] fila : actividades) {
                            for (int act : fila) {
                                totalActividades += act;
                            }
                        }

                        System.out.println("Total de actividades saludables: " + totalActividades);

                        if (promedio < 3) {
                            System.out.println("Bienestar: Bajo");
                        } else if (promedio < 4) {
                            System.out.println("Bienestar: Medio");
                        } else {
                            System.out.println("Bienestar: Alto");
                        }

                        // Reto: peor día
                        int peorDia = 0;
                        int peorValor = estadoAnimo[0];

                        for (int i = 1; i < contadorDias; i++) {
                            if (estadoAnimo[i] < peorValor) {
                                peorValor = estadoAnimo[i];
                                peorDia = i;
                            }
                        }

                        System.out.println("Peor día registrado: Día " + (peorDia + 1));

                    } else {
                        System.out.println("No hay datos aún.");
                    }
                    break;

                case 4:
                    int sumaRec = 0;
                    int contRec = 0;

                    for (int val : estadoAnimo) {
                        if (val != 0) {
                            sumaRec += val;
                            contRec++;
                        }
                    }

                    if (contRec > 0) {
                        double promedio = (double) sumaRec / contRec;

                        if (promedio < 3) {
                            System.out.println("Recomendación: Descansa y prueba meditación.");
                        } else if (promedio < 4) {
                            System.out.println("Recomendación: Realiza ejercicio físico.");
                        } else {
                            System.out.println("¡Excelente! Sigue así.");
                        }
                    } else {
                        System.out.println("No hay datos para recomendar.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}
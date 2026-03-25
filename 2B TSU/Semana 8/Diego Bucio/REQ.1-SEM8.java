/**
 * Institución: Universidad Tecnológica de Torreón.
 * Carrera: Ingeniería en Desarrollo de Software.
 * Alumno: [Juan Diego Arroyo Bucio.]
 * Materia: Programación Estructurada.
 */
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 1. Arrays principales
    int[] animo = new int[7]; // Para los 7 días de la semana (0 = sin registro)

    // Array bidimensional para actividades: 7 filas (días) x 3 columnas (actividades)
    // Usaremos 1 para "Realizada" y 0 para "No realizada"
    int[][] actividades = new int[7][3];

    String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
    String[] nombresAct = {"Ejercicio físico", "Meditación/Relajación", "Lectura/Hobby"};

    boolean salir = false;

    System.out.println("=== BIENVENIDO A MINDBALANCE ===");

    // 3. Menú interactivo con while y switch
    while (!salir) {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Registrar estado de ánimo");
        System.out.println("2. Registrar actividades saludables");
        System.out.println("3. Ver resumen de bienestar");
        System.out.println("4. Ver recomendación automática");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");

        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("\n--- REGISTRO DE ESTADO DE ÁNIMO ---");
                int diaAnimo = pedirDia(sc, diasSemana);

                System.out.println("\n¿Cómo te sentiste el " + diasSemana[diaAnimo] + "?");
                System.out.println("1 = Muy mal 😞 | 2 = Mal 😕 | 3 = Neutral 😐 | 4 = Bien 🙂 | 5 = Excelente 😄");
                System.out.print("Ingresa un valor (1-5): ");
                int valorAnimo = sc.nextInt();

                // Reto Adicional: Validación de datos
                while (valorAnimo < 1 || valorAnimo > 5) {
                    System.out.print("Error. Ingresa un valor válido del 1 al 5: ");
                    valorAnimo = sc.nextInt();
                }

                animo[diaAnimo] = valorAnimo;
                System.out.println("¡Estado de ánimo registrado exitosamente!");
                break;

            case 2:
                System.out.println("\n--- REGISTRO DE ACTIVIDADES SALUDABLES ---");
                int diaAct = pedirDia(sc, diasSemana);

                System.out.println("\nResponde con 1 (Sí) o 0 (No) para el " + diasSemana[diaAct] + ":");
                for (int j = 0; j < 3; j++) {
                    System.out.print("¿Realizaste '" + nombresAct[j] + "'? (1/0): ");
                    int hizoActividad = sc.nextInt();

                    while (hizoActividad != 0 && hizoActividad != 1) {
                        System.out.print("Error. Solo ingresa 1 para Sí o 0 para No: ");
                        hizoActividad = sc.nextInt();
                    }
                    actividades[diaAct][j] = hizoActividad;
                }
                System.out.println("¡Actividades guardadas!");
                break;

            case 3:
                System.out.println("\n--- RESUMEN DE BIENESTAR ---");

                double sumaAnimo = 0;
                int diasRegistrados = 0;
                int peorAnimo = 6; // Iniciamos alto para buscar el menor
                int indicePeorDia = -1;

                // 4a. Calcular promedio con un ciclo FOR clásico
                for (int i = 0; i < animo.length; i++) {
                    if (animo[i] > 0) { // Solo contar días registrados
                        sumaAnimo += animo[i];
                        diasRegistrados++;

                        // Reto Adicional: Detectar el peor día
                        if (animo[i] < peorAnimo) {
                            peorAnimo = animo[i];
                            indicePeorDia = i;
                        }
                    }
                }

                if (diasRegistrados == 0) {
                    System.out.println("Aún no tienes registros para analizar, bro. ¡Registra algo primero!");
                    break;
                }

                double promedio = sumaAnimo / diasRegistrados;
                promedio = Math.round(promedio * 10.0) / 10.0; // Redondear a 1 decimal

                // 4b. Contar actividades usando FOR-EACH (Doble por ser matriz 2D)
                int totalActividades = 0;
                for (int[] dia : actividades) {
                    for (int act : dia) {
                        totalActividades += act; // Si es 1 suma, si es 0 no suma
                    }
                }

                System.out.println("Promedio de estado de ánimo: " + promedio + " / 5.0");
                System.out.println("Total de actividades saludables realizadas: " + totalActividades);

                if (indicePeorDia != -1) {
                    System.out.println("Día más complicado de la semana: " + diasSemana[indicePeorDia] + " (Nivel " + peorAnimo + ")");
                }

                // 4c. Indicar nivel de bienestar
                System.out.print("Nivel de Bienestar General: ");
                if (promedio < 3) System.out.println("BAJO ⚠️");
                else if (promedio < 4) System.out.println("MEDIO ⚖️");
                else System.out.println("ALTO 🌟");

                break;

            case 4:
                System.out.println("\n--- RECOMENDACIÓN AUTOMÁTICA ---");

                double sumaReq = 0;
                int contReq = 0;
                for (int valor : animo) {
                    if (valor > 0) {
                        sumaReq += valor;
                        contReq++;
                    }
                }

                if (contReq == 0) {
                    System.out.println("Faltan datos para darte una recomendación. Ve a la opción 1.");
                    break;
                }

                double promReq = sumaReq / contReq;

                // 5. Recomendaciones automáticas usando IF
                if (promReq < 3) {
                    System.out.println("💡 Recomendación: Tu promedio es bajo. Te sugiero tomar un descanso, desconectarte un rato y probar una sesión de meditación. Un día a la vez, bro.");
                } else if (promReq >= 3 && promReq < 4) {
                    System.out.println("💡 Recomendación: Tu nivel es estable, pero puede mejorar. Te recomiendo hacer ejercicio hoy para liberar endorfinas y subir esa energía.");
                } else if (promReq >= 4) {
                    System.out.println("💡 Recomendación: ¡Excelente trabajo! Tienes un bienestar alto. Sigue manteniendo esos buenos hábitos. ¡Felicidades!");
                }

                // Reto Adicional: Mensaje motivacional
                System.out.println("\n🔥 Recuerda: La salud mental es un maratón, no un sprint. ¡Sigue así!");
                break;

            case 5:
                salir = true;
                System.out.println("\nSaliendo de MindBalance... ¡Cuídate mucho, Bucio!");
                break;

            default:
                System.out.println("\nError: Opción no válida. Intenta de nuevo.");
        }
    }

    sc.close();
}

// Método auxiliar para no repetir código al pedir el día
private static int pedirDia(Scanner sc, String[] dias) {
    System.out.println("¿Para qué día de la semana vas a registrar?");
    for (int i = 0; i < dias.length; i++) {
        System.out.println((i + 1) + ". " + dias[i]);
    }
    System.out.print("Elige el día (1-7): ");
    int dia = sc.nextInt();

    // Validación
    while (dia < 1 || dia > 7) {
        System.out.print("Error. Elige un número del 1 al 7: ");
        dia = sc.nextInt();
    }
    return dia - 1; // Restamos 1 para coincidir con el índice del arreglo (0-6)
}

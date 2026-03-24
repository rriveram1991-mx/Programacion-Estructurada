import java.util.Scanner;

public class MidBalance {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int[] animo = new int[7];
        String[][] actividades = new String[7][3];
        int opcion;
        double promedio = 0;

        do {
            System.out.println("---Menú----");
            System.out.println("1. Registrar Estado de ánimo");
            System.out.println("2. Registrar actividades");
            System.out.println("3. Ver resumen");
            System.out.println("4. Ver recomendación");
            System.out.println("5. Salir");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    int dia;
                    do {
                        System.out.println("Ingresa el día (1-7):");
                        dia = leer.nextInt();
                    } while (dia < 1 || dia > 7);

                    int valor;
                    do {
                        System.out.println("Estado de ánimo (1-Muy mal, 2-Mal, 3-Neutral, 4-Bien, 5-Excelente):");
                        valor = leer.nextInt();
                    } while (valor < 1 || valor > 5);

                    animo[dia - 1] = valor;
                    break;

                case 2:
                    int diaAct;
                    do {
                        System.out.println("Día:");
                        diaAct = leer.nextInt();
                    } while (diaAct < 1 || diaAct > 7);

                    leer.nextLine();

                    for (int i = 0; i < 3; i++) {
                        System.out.println("Actividad " + (i + 1) + ":");
                        actividades[diaAct - 1][i] = leer.nextLine();
                    }
                    break;

                case 3:
                    int suma = 0;
                    for (int i = 0; i < animo.length; i++) {
                        suma += animo[i];
                    }
                    promedio = (double) suma / animo.length;
                    System.out.println("Promedio: " + promedio);

                    int contador = 0;
                    for (String[] fila : actividades) {
                        for (String act : fila) {
                            if (act != null) {
                                contador++;
                            }
                        }
                    }
                    System.out.println("Actividades totales: " + contador);

                    if (promedio < 3) {
                        System.out.println("Bienestar Bajo");
                    } else if (promedio < 4) {
                        System.out.println("Bienestar Medio");
                    } else {
                        System.out.println("Bienestar Alto");
                    }

                    int peorDia = 0;
                    int peorValor = animo[0];
                    for (int i = 1; i < animo.length; i++) {
                        if (animo[i] < peorValor) {
                            peorValor = animo[i];
                            peorDia = i;
                        }
                    }
                    System.out.println("Peor día de la semana: Día " + (peorDia + 1));

                    if (promedio < 3) {
                        System.out.println("Mensaje: Cada día es una nueva oportunidad para mejorar");
                    } else if (promedio < 4) {
                        System.out.println("Mensaje: Vas progresando, no te rindas");
                    } else {
                        System.out.println("Mensaje: Sigue así, mantienes un gran equilibrio");
                    }

                    break;

                case 4:
                    if (promedio < 3) {
                        System.out.println("Descansa y medita");
                    } else if (promedio < 4) {
                        System.out.println("Haz ejercicio");
                    } else {
                        System.out.println("Excelente trabajo");
                    }
                    break;

                case 5:
                    System.out.println("See you later");
                    break;
            }

        } while (opcion != 5);
    }
}
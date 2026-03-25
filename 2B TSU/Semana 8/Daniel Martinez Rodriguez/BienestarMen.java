import java.util.Scanner;

public class BienestarMen {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String usuario;
        int opcion = 0;
        double sumaAnimo = 0;
        int contadorAnimo = 0;
        String[][] actividades = new String[7][2];
        double promedioanimado = 0;

        System.out.println("Bienvenido al programa de bienestar mental");
        System.out.println("===========================================");
        System.out.println("Ingresa tu nombre 🥵");
        usuario = scan.nextLine();

        while (opcion != 5) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Registrar su estado de animo diario");
            System.out.println("2. Registrar una actividad saludable");
            System.out.println("3. Mostrar resumen y promedio de animo");
            System.out.println("4. Recomendaciones");
            System.out.println("5. Salir");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Hola " + usuario + " ¿Como te sientes hoy? (1-5)");
                    System.out.println("1.Muy mal 😞 2.Mal 🙁 3.Regular 🙂 4.Bien 😊 5.Excelente 🥵");
                    int animo = scan.nextInt();
                    if (animo >= 1 && animo <= 5) {
                        sumaAnimo += animo;
                        contadorAnimo++;
                        promedioanimado = sumaAnimo / contadorAnimo;
                        System.out.println("Estado de ánimo registrado.");
                    } else {
                        System.out.println("Puntuación no válida.");
                    }
                    break;
                case 2:
                    System.out.println("¿Para qué día de la semana quieres registrar? (1-7)");
                    int dia = scan.nextInt() - 1;
                    scan.nextLine();
                    if (dia >= 0 && dia < 7) {
                        System.out.println("Registra la actividad 1:");
                        actividades[dia][0] = scan.nextLine();
                        System.out.println("Registra la actividad 2:");
                        actividades[dia][1] = scan.nextLine();
                    } else {
                        System.out.println("Dia fuera de rango ");
                    }
                    break;
                case 3:
                    System.out.println("Resumen de bienestar:");
                    if (contadorAnimo > 0) {
                        System.out.println("Promedio de ánimo: " + promedioanimado + " / 5.0");

                    }
                    for (int i = 0; i < 7; i++) {
                        // aqui le decimos que si nos pone nada pues no sirve
                        if (actividades[i][0] != null) {
                            System.out.println("Día " + (i + 1) + ": " + actividades[i][0] + ", " + actividades[i][1]);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Recomendaciones: ");
                    if (promedioanimado < 3) {
                        System.out.println("Se recomienda descanso y meditacion ");

                    } else if (promedioanimado >= 3 && promedioanimado <= 4) {
                        System.out.println("Te recomendamos que hagas ejercicio");
                    } else if (promedioanimado > 4) {
                        System.out.println("Felicidadeeeees vas muy bien 🥵");
                    }

                    break;
                case 5:
                    System.out.println("Hasta luego " + usuario + "! 🧐🍷");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        {
        }
        scan.close();
    }
}

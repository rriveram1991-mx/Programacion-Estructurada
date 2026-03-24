/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package det1sem82eblmc;
import java.util.Scanner;

/**
 *
 * @author brand
 */
public class DET1SEM82EBLMC {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] estadoAnimo = new int[7];
        String[][] habitos = new String[7][3];

        int opcionMenu;
        double promedioAnimo = 0;

        do {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Registrar ánimo diario");
            System.out.println("2. Registrar hábitos saludables");
            System.out.println("3. Mostrar resumen");
            System.out.println("4. Ver recomendación");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcionMenu = sc.nextInt();

            switch (opcionMenu) {

                case 1:
                    int diaRegistro;
                    do {
                        System.out.print("Ingresa el día (1-7): ");
                        diaRegistro = sc.nextInt();
                    } while (diaRegistro < 1 || diaRegistro > 7);

                    int nivel;
                    do {
                        System.out.println("Nivel de ánimo:");
                        System.out.println("1=Muy mal | 2=Mal | 3=Neutral | 4=Bien | 5=Excelente");
                        nivel = sc.nextInt();
                    } while (nivel < 1 || nivel > 5);

                    estadoAnimo[diaRegistro - 1] = nivel;
                    System.out.println("Registro guardado ");
                    break;

                case 2:
                    int diaHabito;
                    do {
                        System.out.print("Para que día deseas registrar actividades? (1-7): ");
                        diaHabito = sc.nextInt();
                    } while (diaHabito < 1 || diaHabito > 7);

                    sc.nextLine();

                    for (int i = 0; i < habitos[diaHabito - 1].length; i++) {
                        System.out.print("Actividad saludable #" + (i + 1) + ": ");
                        habitos[diaHabito - 1][i] = sc.nextLine();
                    }
                    break;

                case 3:
                    int total = 0;

                    for (int i = 0; i < estadoAnimo.length; i++) {
                        total += estadoAnimo[i];
                    }

                    promedioAnimo = (double) total / estadoAnimo.length;
                    System.out.println("Promedio de ánimo: " + promedioAnimo);

                    int totalActividades = 0;

                    for (String[] dia : habitos) {
                        for (String actividad : dia) {
                            if (actividad != null && !actividad.isEmpty()) {
                                totalActividades++;
                            }
                        }
                    }

                    System.out.println("Total de actividades realizadas: " + totalActividades);

                    if (promedioAnimo < 3) {
                        System.out.println("Nivel de bienestar: BAJO");
                    } else if (promedioAnimo < 4) {
                        System.out.println("Nivel de bienestar: MEDIO");
                    } else {
                        System.out.println("Nivel de bienestar: ALTO");
                    }

                    int indicePeorDia = 0;
                    int valorPeor = estadoAnimo[0];

                    for (int i = 1; i < estadoAnimo.length; i++) {
                        if (estadoAnimo[i] < valorPeor) {
                            valorPeor = estadoAnimo[i];
                            indicePeorDia = i;
                        }
                    }

                    System.out.println("Día más difícil: Día " + (indicePeorDia + 1));

                    if (promedioAnimo < 3) {
                        System.out.println("Motivación: Tómate un respiro, tu bienestar es importante.");
                    } else if (promedioAnimo < 4) {
                        System.out.println("Motivación: Vas mejorando, sigue constante.");
                    } else {
                        System.out.println("Motivación: ¡Excelente! Sigue con esos hábitos.");
                    }

                    break;

                case 4:
                    if (promedioAnimo < 3) {
                        System.out.println("Recomendación: Descansa y prueba meditación 🧘");
                    } else if (promedioAnimo < 4) {
                        System.out.println("Recomendación: Realiza ejercicio físico 💪");
                    } else {
                        System.out.println("Recomendación: ¡Vas increíble! 🎉");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
            }

        } while (opcionMenu != 5);

    }
}
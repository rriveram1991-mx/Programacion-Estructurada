/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package yugioh;
import java.util.Scanner;
/**
 *
 * @author pecha
 */
public class Yugioh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          //Herramientas
        Scanner leer = new Scanner(System.in);
        final int N = 3;
        String[][] nombre = new String [2][N];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
         int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];
        int [] vivos = {N, N};
        /////
    
        System.out.println("    DUUDUDUDUDUELOOOOOO    ");
      for (int j = 0; j < 2; j++) {
            System.out.println("\nJugador " + (j + 1));
            for (int i = 0; i < N; i++) {

                System.out.print("Nombre: ");
                nombre[j][i] = leer.nextLine();

                vida[j][i] = leerEntero(leer, "Vida: ");
                ataque[j][i] = leerEntero(leer, "Ataque: ");
                magia[j][i] = leerEntero(leer, "Magia: ");
                energia[j][i] = leerEntero(leer, "Energia: ");

                vivo[j][i] = true;
                curaciones[j][i] = 0;
            }
        }
      //Juego
        System.out.println("   otia tio, la batalla ha empezao");
          while (vivos[0] > 0 && vivos[1] > 0) {

            turno(leer, nombre, vida, ataque, magia, energia, vivo, curaciones, vivos, 0, 1);
            if (vivos[1] == 0) break;

            turno(leer, nombre, vida, ataque, magia, energia, vivo, curaciones, vivos, 1, 0);
        }

        System.out.println("\n===== FIN =====");
        if (vivos[0] == 0) System.out.println("El jugador dos es el mejor dududuelista");
        else System.out.println("El jugador uno es el mejor dududuelista");
    }
//Reconocimiento de 0
          static int leerEntero(Scanner sc, String msg) {
                int n = -1;
                while (n < 0) {
                System.out.print(msg);
                try {
                n = sc.nextInt();
                if (n < 0) System.out.println("No puede ser negativo.");
                } catch (Exception e) {
                System.out.println("Entrada inválida.");
                }
                sc.nextLine();
            }
            return n;
    }
          // Turnos
    static void turno(Scanner sc, String[][] nombre, int[][] vida, int[][] ataque,
                     int[][] magia, int[][] energia, boolean[][] vivo,
                     int[][] curaciones, int[] vivos, int j, int enemigo) {
        System.out.println("\n--- Turno Jugador " + (j + 1) + " ---");
        //
        int atacante = elegir(sc, nombre[j], vida[j], vivo[j]);
        int objetivo = elegir(sc, nombre[enemigo], vida[enemigo], vivo[enemigo]);
        if (atacante == -1 || objetivo == -1) return;
        //
        System.out.println("1. Ataque físico");
        System.out.println("2. Ataque mágico");
        System.out.println("3. Curarse");
        System.out.print("Elige acción: ");
       int opcion = sc.nextInt();
        sc.nextLine();
if (!vivo[j][atacante]) {
    System.out.println("No puedes curar a un muerto tonoto");
    return;
}
        switch (opcion) {
            case 1 ->{
               System.out.println(nombre[j][atacante] + " ATAQUE FISICO EPICOO");
hacerDanio(nombre, vida, ataque[j][atacante], j, atacante, enemigo, objetivo, vivos, vivo);
            }
        case 2 ->{
                    if (energia[j][atacante] >= 10) {
                    energia[j][atacante] -= 10;
                    hacerDanio(nombre, vida, magia[j][atacante], j, atacante, enemigo, objetivo, vivos, vivo);
                } else {
                    System.out.println("Tu energia se ha agotado");
               }
        }
                case 3 -> {
                    if (curaciones[j][atacante] < 2) {
                    vida[j][atacante] += 20;
                    curaciones[j][atacante]++;
                    System.out.println(nombre[j][atacante] + " se cura +20 HP");
                    System.out.println("Vida actual: " + vida[j][atacante]);
                } else {
                    System.out.println("FULL VIDA, no se pude curar mas");
                }
                }

                default ->  System.out.println("Opción inválida");
        }
    }
          static void hacerDanio(String[][] nombre, int[][] vida, int danio,
                          int jA, int cA, int jD, int cD,
                          int[] vivos, boolean[][] vivo) {

        int prob = (int) (Math.random() * 100);

        if (prob < 20) {
            danio *= 2;
            System.out.println("CRITICO!");
        }

        vida[jD][cD] -= danio;

        System.out.println(nombre[jA][cA] + " ataca a " + nombre[jD][cD]);
        System.out.println("Daño: " + danio);

        if (vida[jD][cD] <= 0) {
            vida[jD][cD] = 0;
            vivo[jD][cD] = false;
            vivos[jD]--;
            System.out.println(nombre[jD][cD] + " ha sido eliminadoooo");
        } else {
            System.out.println("Vida restante: " + vida[jD][cD]);
        }
    }

    static int elegir(Scanner sc, String[] nombre, int[] vida, boolean[] vivo) {

        int[] indices = new int[nombre.length];
        int c = 0;

        for (int i = 0; i < nombre.length; i++) {
            if (vivo[i]) {
                System.out.println((c + 1) + ". " + nombre[i] + " (HP: " + vida[i] + ")");
                indices[c++] = i;
            }
        }

        int op = -1;
        while (op < 1 || op > c) {
            System.out.print("Elige: ");
            try {
                op = sc.nextInt();
            } catch (Exception e) {}
            sc.nextLine();
        }

        return indices[op - 1];
    }
}
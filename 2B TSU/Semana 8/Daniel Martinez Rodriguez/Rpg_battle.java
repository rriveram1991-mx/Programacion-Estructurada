import java.util.Scanner;

public class Rpg_battle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] personajes = new String[2][3];
        String[] players = new String[2];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];

        System.out.println("Ingrese el nombre del jugador 1");
        players[0] = scan.nextLine();
        System.out.println("Ingrese el nombre del jugador 2");
        players[1] = scan.nextLine();

        for (int i = 0; i < personajes.length; i++) {
            for (int j = 0; j < personajes[i].length; j++) {
                System.out.println("Ingrese el nombre del personaje " + (j + 1) + " Turno del jugador: " + players[i]);
                personajes[i][j] = scan.nextLine();
                System.out.println("Ingrese la vida del personaje " + personajes[i][j]);
                vida[i][j] = scan.nextInt();
                System.out.println("Ingrese el ataque del personaje " + personajes[i][j]);
                ataque[i][j] = scan.nextInt();
                System.out.println("Ingrese la magia del personaje " + personajes[i][j]);
                magia[i][j] = scan.nextInt();
                System.out.println("Ingrese la energia del personaje " + personajes[i][j]);
                energia[i][j] = scan.nextInt();
                System.out.println("Ingrese la curacion del personaje " + personajes[i][j]);
                curaciones[i][j] = scan.nextInt();
                scan.nextLine();
                vivo[i][j] = true;
            }
        }

        for (int i = 0; i < personajes.length; i++) {
            for (int j = 0; j < personajes[i].length; j++) {
                System.out.println("Personaje: " + personajes[i][j]);
                System.out.println("Vida: " + vida[i][j]);
                System.out.println("Ataque: " + ataque[i][j]);
                System.out.println("Magia: " + magia[i][j]);
                System.out.println("Energia: " + energia[i][j]);
                System.out.println("Curacion: " + curaciones[i][j]);
                System.out.println("Vivo: " + vivo[i][j]);
                System.out.println("=========");

            }
        }

        System.out.println("\n¡COMIENZA LA BATALLA POR TURNOS!");
        int turno = 0; // 0 para Jugador 1, 1 para Jugador 2
        boolean batallaActiva = true;

        while (batallaActiva) {
            int oponente = (turno == 0) ? 1 : 0;
            System.out.println("\n--- TURNO DE " + players[turno].toUpperCase() + " ---");

            // Mostrar personajes vivos del jugador actual
            System.out.println("Tus personajes:");
            for (int j = 0; j < 3; j++) {
                if (vivo[turno][j])
                    System.out.println(j + ". " + personajes[turno][j] + " (HP: " + vida[turno][j] + ")");
            }

            System.out.println("Selecciona tu personaje para actuar:");
            int pSel = scan.nextInt();
            if (pSel < 0 || pSel > 2 || !vivo[turno][pSel]) {
                System.out.println("Selección inválida o personaje caído.");
                continue;
            }

            System.out.println("¿Qué quieres hacer? 1:Ataque 2:Magia 3:Curación 4:Recuperar energia");
            int accion = scan.nextInt();

            if (accion == 1 || accion == 2) {
                System.out.println("Selecciona al enemigo a atacar:");
                for (int j = 0; j < 3; j++) {
                    if (vivo[oponente][j])
                        System.out.println(j + ". " + personajes[oponente][j] + " (HP: " + vida[oponente][j] + ")");
                }
                int eSel = scan.nextInt();
                if (eSel >= 0 && eSel <= 2 && vivo[oponente][eSel]) {
                    int daño = (accion == 1) ? ataque[turno][pSel] : magia[turno][pSel];
                    int prob = (int) (Math.random() * 100);
                    if (prob < 20) {
                        daño *= 2;
                        System.out.println("¡Golpe crítico!");
                    }
                    vida[oponente][eSel] -= daño;
                    energia[turno][pSel] -= 10;
                    if (energia[turno][pSel] < 0) {
                        energia[turno][pSel] = 0;
                        System.out.println("no tienes energia para atacar ");

                        System.out.println(
                                personajes[turno][pSel] + " infligió " + daño + " a " + personajes[oponente][eSel]);
                        if (vida[oponente][eSel] <= 0) {
                            vida[oponente][eSel] = 0;
                            vivo[oponente][eSel] = false;
                            System.out.println("¡" + personajes[oponente][eSel] + " ha caído!");
                        }
                    } else {
                        System.out.println("Objetivo inválido. Pierdes el turno.");
                    }
                } else if (accion == 3) {
                    vida[turno][pSel] += curaciones[turno][pSel];
                    System.out.println(personajes[turno][pSel] + " se curó. Vida actual: " + vida[turno][pSel]);
                } else {
                    System.out.println("Acción no válida.");
                }
            } else if (accion == 4) {
                energia[turno][pSel] += 10;
                System.out.println("Recuperaste 10 de energia");
                System.out.println("Tu energia es: " + energia[turno][pSel]);

                // Verificar si el oponente perdió todos sus personajes
                boolean algunVivo = false;
                for (boolean v : vivo[oponente]) {
                    if (v)
                        algunVivo = true;
                }

                if (!algunVivo) {
                    System.out.println("\n¡EL JUGADOR " + players[turno] + " HA GANADO LA BATALLA!");
                    batallaActiva = false;

                } else {
                    turno = oponente; // Cambiar turno
                }
            }
            scan.close();
        }
    }
}

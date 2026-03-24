import java.util.Scanner;

public class Eje1batallaRPG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] nombres = new String[2][3];
        int[][] vida = new int[2][3];
        int[][] ataque = new int[2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];

        for (int i = 0; i < 2; i++) {
            System.out.println("--- REGISTRO EQUIPO " + (i + 1) + " ---");
            for (int j = 0; j < 3; j++) {
                System.out.print("Nombre del héroe " + (j + 1) + ": ");
                nombres[i][j] = sc.next();
                vida[i][j] = 100;    
                ataque[i][j] = 15;   
                magia[i][j] = 30;    
                energia[i][j] = 20;  
                vivo[i][j] = true;   
                curaciones[i][j] = 0; 
            }
        }

        int turno = 0; 


        while (equipoTieneVivos(vivo, 0) && equipoTieneVivos(vivo, 1)) {
            int rival = (turno == 0) ? 1 : 0;
            System.out.println("\n--- TURNO DEL JUGADOR " + (turno + 1) + " ---");

            int hPropio;
            do {
                System.out.print("Elige tu héroe (1, 2 o 3): ");
                hPropio = sc.nextInt() - 1; 
            } while (hPropio < 0 || hPropio > 2 || !vivo[turno][hPropio]);


            System.out.println("1.Ataque físico | 2.Magia | 3.Curarse");
            int accion = sc.nextInt();

            
            if (accion == 1 || accion == 2) {

                System.out.print("¿A quién atacas del Equipo " + (rival + 1) + "? (1, 2 o 3): ");
                int hRival = sc.nextInt() - 1;

                if (vivo[rival][hRival]) {
                    int danio = 0;
                    
                    
                    if (accion == 1) {
                        danio = ataque[turno][hPropio];
                        System.out.println(nombres[turno][hPropio] + " lanza un espadazo.");
                    } 
                    
                    else if (accion == 2) {
                        if (energia[turno][hPropio] >= 10) {
                            danio = magia[turno][hPropio];
                            energia[turno][hPropio] -= 10;
                            System.out.println(nombres[turno][hPropio] + " lanza un hechizo.");
                        } else {
                            System.out.println("¡Sin energía! El ataque falló.");
                        }
                    }

                    
                    int prob = (int)(Math.random() * 100);
                    if (prob < 20 && danio > 0) {
                        danio *= 2;
                        System.out.println("¡GOLPE CRÍTICO!");
                    }

                
                    vida[rival][hRival] -= danio;
                    System.out.println("Hiciste " + danio + " de daño. Vida restante de " + nombres[rival][hRival] + ": " + Math.max(0, vida[rival][hRival]));

                    
                    if (vida[rival][hRival] <= 0) {
                        vida[rival][hRival] = 0;
                        vivo[rival][hRival] = false;
                        System.out.println("¡" + nombres[rival][hRival] + " ha caído!");
                    }
                } else {
                    System.out.println("Ese héroe ya está muerto, perdiste el turno por distraído.");
                }
            } 

            else if (accion == 3) {
                if (curaciones[turno][hPropio] < 2) {
                    vida[turno][hPropio] += 20;
                    curaciones[turno][hPropio]++;
                    System.out.println(nombres[turno][hPropio] + " se curó. Vida actual: " + vida[turno][hPropio]);
                } else {
                    System.out.println("Ya no puedes curarte más.");
                }
            }

            turno = (turno == 0) ? 1 : 0;
        }

        if (equipoTieneVivos(vivo, 0)) {
            System.out.println("\n¡GANA EL JUGADOR 1!");
        } else {
            System.out.println("\n¡GANA EL JUGADOR 2!");
        }
    }

    public static boolean equipoTieneVivos(boolean[][] vivo, int equipo) {
        return vivo[equipo][0] || vivo[equipo][1] || vivo[equipo][2];
    }
}
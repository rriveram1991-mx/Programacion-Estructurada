
import java.util.Scanner;

void main() {

    Scanner lr = new Scanner(System.in);
    String[][] nombres = new String[2][3];
    int[][] vida = new int[2][3];
    int[][] ataque = new int[2][3];
    int[][] magia = new int[2][3];
    int[][] energia = new int[2][3];
    boolean[][] vivo = new boolean[2][3];
    int[][] curaciones = new int[2][3];

    int op = 0;




    while(op != 4) {
        menuinicial();
        op = lr.nextInt();
        lr.nextLine();

        switch (op) {
            case 1:
                AsingarEquipo(nombres,vida,ataque,magia,energia,vivo,  0 ,lr);
                break;
            case 2:
                AsingarEquipo(nombres,vida,ataque,magia,energia,vivo, 1 ,lr);
                break;
            case 3:
                System.out.println("Estadisticas de los compañeros de los jugadores");

                System.out.println("Nombres: ");
                verNombres(nombres);
                System.out.println("Vida: ");
                verEquipos(vida);
                System.out.println("Ataque: ");
                verEquipos(ataque);
                System.out.println("Magia: ");
                verEquipos(magia);
                System.out.println("Mana: ");
                verEquipos(energia);
                System.out.println("Estado:");
                verEstado(vivo);
                System.out.println("Curas");
                verEquipos(curaciones);
                break;
            case 4:
                boolean JS = true;
                while(JS) {

                    SistemaBA(0, 1, nombres, vida, ataque, magia, energia, vivo, curaciones, lr);
                    if(equipoDerrotado(vida, 1)) {
                        System.out.println("¡JUGADOR 1 GANA!");
                        JS = false;
                        break;
                    }
                    SistemaBA(1, 0 , nombres, vida, ataque,magia,energia,vivo,curaciones, lr);
                    if(equipoDerrotado(vida, 0)) {
                        System.out.println("¡JUGADOR 2 GANA!");
                        JS = false;
                        break;
                    }

                }
                break;
        }
    }

}

boolean equipoDerrotado(int[][] vida, int numEquipo) {
    for (int v : vida[numEquipo]) {
        if (v > 0) return false;
    }
    return true;
}

void menuinicial(){
    System.out.println("\n===========================");
    System.out.println("Menu");
    System.out.println("===========================");
    System.out.println("1) Asignar Equipos para jugador 1");
    System.out.println("2) Asignar Equipos para jugador 2");
    System.out.println("3) Mostrar Equipos");
    System.out.println("4) Empezar Batalla");
}

void verNombres(String[][] stat){

    for(String i[] : stat){
        for (String j : i){
            System.out.print(j + " ");
        }
        System.out.println();
    }

}

void verEquipos(int[][] stat){

    for(int i[] : stat){
        for (int j : i){
            System.out.print(j + " ");
        }
        System.out.println();
    }

}

void verEstado(boolean[][] stat){

    for(boolean i[] : stat){
        for (boolean j : i){
            System.out.print(j + " ");
        }
        System.out.println();
    }

}

void AsingarEquipo(String[][] equipo, int[][] vida, int[][] ataque, int[][] magia, int[][] mana, boolean[][] estado,  int numEqup, Scanner lr) {

    int columna = -1;
    for (int j = 0; j < 3; j++) {
        if (equipo[numEqup][j] == null || vida[numEqup][j] == 0 || ataque[numEqup][j] == 0 || magia[numEqup][j] == 0 || mana[numEqup][j] == 0 || !estado[numEqup][j]) {
            columna = j;
            break;
        }
    }

    if (columna != -1) {
        System.out.println("Nombre de tu compañero: ");
        equipo[numEqup][columna] = lr.nextLine();
        System.out.println("vida de tu compañero: ");
        vida[numEqup][columna] = lr.nextInt();
        System.out.println("ataque de tu compañero: ");
        ataque[numEqup][columna] = lr.nextInt();
        System.out.println("ataque magico de tu compañero: ");
        magia[numEqup][columna] = lr.nextInt();
        System.out.println("mana inicial de tu compañero: ");
        mana[numEqup][columna] = lr.nextInt();
        estado[numEqup][columna] = true;
    } else {
        System.out.println("Equipo lleno");
    }
}


    void SistemaBA ( int numJug, int numEn, String[][] equipo, int[][] vida, int[][] ataque, int[][] magia, int[][] mana, boolean[][] estado, int[][] cura, Scanner lr) {
        int c;

        System.out.println("Turno del jugador " + (numJug + 1));

        do{
            System.out.println("Elige a tu heroe (1-3)");
            c = lr.nextInt() - 1;

            if(vida[numJug][c] <= 0){

                System.out.println("Heroe derrotado...");
            }

            if (!estado[numEn][c]) {
                System.out.println("equipo derrotado?");

                break;
            }

        }while(vida[numJug][c] <= 0);

        if (estado[numEn][c]) {

            System.out.println("1. Ataque físico");
            System.out.println("2. Ataque mágico");
            System.out.println("3. Curarse");

            int opcion = lr.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("el jugador " + equipo[numJug][c] + " ataca a" + equipo[numEn][c]);
                    System.out.println("haciendo un daño de: " + ataque[numJug][c]);
                    vida[numEn][c] -= ataque[numJug][c];

                    System.out.println("vida restante del enemigo: " + vida[numEn][c]);
                    break;
                case 2:

                    System.out.println("el jugador " + equipo[numJug][c] + " ataca magicamente a" + equipo[numEn][c]);
                    if (mana[numJug][c] >= 10) {
                        System.out.println("haciendo un daño de: " + ataque[numJug][c]);

                        vida[numEn][c] -= magia[numJug][c];
                        mana[numJug][c] -= 10;
                        System.out.println("vida restante del enemigo: " + vida[numEn][c]);
                    } else {
                        System.out.println("No tienes suficiente energía");
                    }
                    break;
                case 3:
                    System.out.println("intentas curarte...");
                    if (cura[numJug][c] < 2) {
                        vida[numJug][c] += 20;
                        System.out.println("te has curado 20 hp, vida total: " + vida[numJug][c]);
                        cura[numJug][c]++;
                    } else {
                        System.out.println("Ya no puedes curarte más");
                    }
                    break;
                case 4:
                    System.out.println("Estadisticas de los compañeros de los jugadores");

                    System.out.println("Nombres: ");
                    verNombres(equipo);
                    System.out.println("Vida: ");
                    verEquipos(vida);
                    System.out.println("Ataque: ");
                    verEquipos(ataque);
                    System.out.println("Magia: ");
                    verEquipos(magia);
                    System.out.println("Mana: ");
                    verEquipos(mana);
                    System.out.println("Estado:");
                    verEstado(estado);
                    System.out.println("Curas");
                    verEquipos(cura);
                    break;

            }
        }
        if (vida[numEn][c] <- 0){
            estado[numEn][c] = false;
        }
    }


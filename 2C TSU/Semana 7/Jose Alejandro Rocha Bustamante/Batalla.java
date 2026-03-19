import java.util.Scanner;
public class Batalla {
    public static void main(String[]args){
        Scanner leer = new Scanner(System.in);
        String[][] jugador1 = new String[3][3];
        String[][] jugador2 = new String[3][3];
        boolean[] vivo1 = {true, true, true};
        boolean[] vivo2 = {true, true, true};

        for(int i = 0; i <3; i++){
        System.out.println("== Ingrese el nombre del Pokemon ==");
        jugador1[i][0] = leer.nextLine();
        System.out.println("== Ingrese la cantidad de vida ==");
        jugador1[i][1] = leer.nextLine();
        System.out.println("== Ingrese la cantidad de daño de ataque ==");
        jugador1[i][1] = leer.nextLine();
        }
        for(int i = 0; i <3; i++){
        System.out.println("== Ingrese el nombre del Pokemon ==");
        jugador2[i][0] = leer.nextLine();
        System.out.println("== Ingrese la cantidad de vida ==");
        jugador2[i][1] = leer.nextLine();
        System.out.println("== Ingrese la cantidad de daño de ataque ==");
        jugador2[i][1] = leer.nextLine();
        }
        while(true){
            if (!vivo1[0]&&!vivo1[1]&&!vivo1[2]){
          System.out.println("== El rival 2 ha ganado == ");
            }
            if (!vivo2[0]&&!vivo2[1]&&!vivo2[2]){
                System.out.println("== El rival 1 ha ganado == ");
            }
            System.out.println("== Los Pokemon de rival 1 son: ==");
            for(int i = 0; i<3;i++){
                if(vivo1[i]){
                    System.out.println(i+jugador1[i][0]);
                }
            }
            System.out.println("== Elije un Pokemon ==");
            int p1 = leer.nextInt();
            if(!vivo1[p1]) continue;

            System.out.println("== Los Pokemon de rival 2 son: ==");
            for(int i = 0; i<3;i++){
                if(vivo2[i]){
                    System.out.println(i+jugador1[i][0]);
                }
            }
            System.out.println("== Elije un Pokemon ==");
            int p2 = leer.nextInt();
            if(!vivo2[p2]) continue;
          
          int v1 = Integer.parseInt(jugador1[p1][1]);
          int a1 = Integer.parseInt(jugador1[p1][2]);

          int v2 = Integer.parseInt(jugador1[p2][1]);
          int a2 = Integer.parseInt(jugador1[p2][2]);
            
          System.out.println("== La batalla ha empezado: "+jugador1[p1][0]+"vs"+jugador2[p2][0]);
          while (v1>0 && v2>0) {
            v2 -= a1;
          System.out.println("== Es turno de  "+jugador1[p1][0] +" !Ataca¡");
          System.out.println("== "+jugador2[p2][0]+" ha recivido daño ahora tiene "+v2+"de vida");
          if(v2 <= 0){
            System.out.println("== "+jugador2[p2][0]+" fue derrotado ==");
            vivo2[p2]=false;
          }
            v1-=a2;
             System.out.println("== Es turno de  "+jugador2[p2][0] +" !Ataca¡");
          System.out.println("== "+jugador1[p1][0]+" ha recivido daño ahora tiene "+v1+"de vida");
          if(v1 <= 0){
            System.out.println("== "+jugador1[p1][0]+" fue derrotado ==");
            vivo1[p1]=false;
          }
        }
        System.out.println("== La batalla ha terminado ==");
        leer.close();
        }
        } 
}
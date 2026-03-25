package jjug;
import java.util.Scanner;
public class Jjug {
    public static void main(String[] args) {
        Scanner micho = new Scanner (System.in);
String[][] NOM = new String[2][3];
int[][] VID = new int[2][3];
int[][] ATK = new int[2][3];
int[][] MG = new int[2][3];
int[][] STAM = new int[2][3];
boolean[][] LI = new boolean[2][3];
int[][] CURA = new int[2][3];
int I=0,X=0;
boolean IDP=false,NL;
        System.out.println("Jugador 1");
for (I=0;I<3;I++){
    X++;
    System.out.print("Nombre del heroe "+X+": ");
    NOM[0][I] = micho.next();
     System.out.print("Vida del heroe: ");
    VID[0][I] = micho.nextInt();
     System.out.print("Ataque: ");
    ATK[0][I] = micho.nextInt();
     System.out.print("Magia: ");
    MG[0][I] = micho.nextInt();
     System.out.print("Energia: ");
    STAM[0][I] = micho.nextInt();
    LI[0][I] = true;
    CURA[0][I] = 0;
}
X=0;
        System.out.println("-------------------------------------------------------------------------");
 System.out.println("Jugador 2");
for (I=0;I<3;I++){
    X++;
    System.out.print("Nombre del heroe "+X+": ");
    NOM[1][I] = micho.next();
     System.out.print("Vida del heroe: ");
    VID[1][I] = micho.nextInt();
     System.out.print("Ataque: ");
    ATK[1][I] = micho.nextInt();
     System.out.print("Magia: ");
    MG[1][I] = micho.nextInt();
     System.out.print("Energia: ");
    STAM[1][I] = micho.nextInt();
      LI[1][I] = true;
       CURA[1][I] = 0;
}
int H1 = 1;
int H2 = 1;
boolean JP = true;
while (JP) {
    System.out.println("--- JUGADOR 1 ---");
    H1 = 1; 
    while (H1 == 1) {
        System.out.print("Elige tu heroe: ");
        String nombre = micho.next();
        for (int i = 0; i < 3; i++) {
            if (nombre.equalsIgnoreCase(NOM[0][i]) && LI[0][i]) {
                H1 = i;
                IDP=true;
                break;
            }
        }
        if (H1 == 11) System.out.println("Héroe no válido o muerto. Intenta de nuevo.");
    }
    System.out.println("--- JUGADOR 2 ---");
    H2 = 1;
    while (H2 == 1) {
        System.out.print("Elige tu heroe : ");
        String nombre = micho.next();
        for (int i = 0; i < 3; i++) {
            if (nombre.equalsIgnoreCase(NOM[1][i]) && LI[1][i]) {
                H2 = i;
                IDP=true;
                break;
            }
        }
        if (H2 == 1) System.out.println("Heroe no valido o muerto. Intenta de nuevo.");
    }
    while (IDP){
        System.out.println("""
                           ------------------------------------------------------------------------
                          1. Ataque fisico
                          2. Ataque magico
                          3. Curarse
                          4. Cambiar heroe
                           -------------------------------------------------------------------------
                           """);
        String OP = micho.next();
        NL=true;
         int TR=0;
        while (NL){
            int RE = (TR == 0) ? 1 : 0;
        switch (OP){
            case "1":
            System.out.println(NOM[TR][H1] + " ataca a " + NOM[RE][H2]);
                VID[RE][H2] -= ATK[TR][H1];
                if (VID[RE][H2] <= 0) {
                    VID[RE][H2] = 0; LI[RE][H2] = false;
                    System.out.println("¡" + NOM[RE][H2] + " ha muerto!");
                }
               
        NL = false;
            break;
             case "2":
              if (STAM[TR][H1] >= 10) {
                    VID[RE][H2] -= MG[TR][H1];
                    STAM[TR][H1] -= 10;
                    if (VID[RE][H2] <= 0) {
                        VID[RE][H2] = 0; LI[RE][H2] = false;
                        System.out.println("¡" + NOM[RE][H2] + " ha muerto!");
                    }
                    NL = false;
                } else {
                    System.out.println("No tienes energia suficiente!.");
                    NL=false;
                }
            break;
            case "3":
              if (CURA[TR][H1] < 2) {
                    VID[TR][H1] += 20;
                    CURA[TR][H1]++;
                    System.out.println(NOM[TR][H1] + " se ha curado. Vida: " + VID[TR][H1]);
                    NL = false;
                } else {
                    System.out.println("Ya no tiene curaciones.");
                }
            break;
            case "4":
              IDP = false; 
        NL = false;  
            break;
           default:
                   System.out.println("Elija una opcion valida.");

            break;
        }
        if (!LI[RE][0] && !LI[RE][1] && !LI[RE][2]) {
        System.out.println("----------------------------------------------");
        System.out.println("¡EL JUGADOR " + (TR + 1) + " HA GANADO!");
        System.out.println("----------------------------------------------");
        JP = false; 
    } else {
        TR = (TR == 0) ? 1 : 0;
    }
        }
        
    }
}
    }
}

    

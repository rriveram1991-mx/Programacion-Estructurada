 * @author nohem
 */
public class BatallaRpg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        String [][] nom=new String [2][3];
        int [][] vida=new int [2][3];
        int [][] ataque = new int [2][3];
        int[][] magia = new int[2][3];
        int[][] energia = new int[2][3];
        boolean[][] vivo = new boolean[2][3];
        int[][] curaciones = new int[2][3];
        int opcion=0;
       
        
        
        
        for (int j=0; j<2; j++){
            System.out.println("\n--- Registro Jugador " + (j + 1) + " ---");
            for (int i=0; i<3; i++){
                vivo[j][i] = true;
                curaciones[j][i] = 0;
                
                 System.out.println("nombre de el heroe"+ (i+1)+":");
                 nom[j][i]=leer.next();
                 
                 System.out.println("¿cuanta vida tiene?");
                 vida[j][i]=leer.nextInt();
                 
                 System.out.println("ataque:");
                 ataque[j][i]=leer.nextInt();
                 
                 System.out.println("magia:");
                 magia[j][i]=leer.nextInt();
                 
                 System.out.println("energia:");
                 energia[j][i]=leer.nextInt();
                 

            }
        }
       
          int derrj1=0;
          int derrj2=0;
          int jact=0;
        while (derrj1<3 && derrj2<3){
            System.out.println("\n--- TURNO JUGADOR " + (jact + 1) + " ---");
            
            System.out.println("Elige tu héroe (1, 2 o 3):");
            int h = leer.nextInt() - 1;
            while (h < 0 || h > 2 || !vivo[jact][h]) {
            System.out.println("heroe no disponible. Elige otro:");
            h = leer.nextInt() - 1;
                }
            
            System.out.println("\n1. Ataque fisico");
            System.out.println("2. Ataque magico");
            System.out.println("3. Curarse");
            System.out.println("4. Cambiar heroe ");

            System.out.print("Seleccione opcion: ");
            opcion = leer.nextInt();
            
            int enemigo; 
            if (jact == 0) {
            enemigo = 1;
            }else{
                enemigo=0;
            }
            
            int victima=0;
            
            
            if (opcion == 1 || opcion == 2) {
                System.out.println("¿A qué héroe enemigo quieres atacar? (1, 2 o 3):");
                victima = leer.nextInt() - 1;
                
                while (victima < 0 || victima > 2 || !vivo[enemigo][victima]) {
                    System.out.println("Ese enemigo ya está muerto. Elige otro:");
                    victima = leer.nextInt() - 1;
                }
            }
            switch (opcion){
                case 1:
                    int dañof=ataque[jact][h];
                    
                    int prob= (int)(Math.random()*100);
                    if (prob < 20) {
                        dañof *= 2;
                        System.out.println("¡GOLPE CRÍTICO!");
                    }
                    vida[enemigo][victima] -= dañof;
                    System.out.println(nom[jact][h] + " hace " + dañof + " de daño a " + nom[enemigo][victima]);
                    break;
                    
                case 2:
                    if (energia[jact][h] >= 10) {
                        int dañom = magia[jact][h];
                        vida[enemigo][victima] -= dañom;
                        energia[jact][h] -= 10;
                        System.out.println(nom[jact][h] + " usa magia y quita " + dañom + " HP.");
                    } else {
                        System.out.println("¡No tienes energía suficiente (Mínimo 10)!");
                    }
                    break;
                    
                case 3:
                    if (curaciones[jact][h] < 2) {
                        vida[jact][h] += 20;
                        curaciones[jact][h]++;
                        System.out.println(nom[jact][h] + " se curó 20 HP. Curaciones: " + curaciones[jact][h] + "/2");
                    } else {
                        System.out.println("Ya no puedes curarte más veces.");
                    }
                    break;
                case 4:
                    System.out.println("Cambiando de héroe...");
                    break;
        }
            if (vida[enemigo][victima] <= 0) {
                vida[enemigo][victima] = 0;
                if (vivo[enemigo][victima]) {
                vivo[enemigo][victima] = false;
                System.out.println("¡" + nom[enemigo][victima] + " ha sido derrotado!");
                
                if (enemigo == 0) {
                    derrj1++;
                } else {
                    derrj2++;
                }
            } }
            
            if (opcion != 4) {
                if (jact == 0) {
                    jact = 1;
                } else {
                    jact = 0;
    } } }
            System.out.println("\n=== FIN DEL JUEGO ===");
        if (derrj1 == 3){
            System.out.println("¡GANA EL JUGADOR 2!");
        
            }else{ System.out.println("¡GANA EL JUGADOR 1!");
            
            }
        }
}
      

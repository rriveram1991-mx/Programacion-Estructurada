 public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        String [][] nom=new String [2][3];
        int [][] vida=new int [2][3];
        int [][] ataque = new int [2][3];
        
        for (int j=0; j<2; j++){
            System.out.println("\n--- Registro Jugador " + (j + 1) + " ---");
            for (int i=0; i<3; i++){
                 System.out.println("nombre de la criatura"+ (i+1)+":");
                 nom[j][i]=leer.next();
                 
                 System.out.println("¿cuanta vida tiene?");
                 vida[j][i]=leer.nextInt();
                 
                 System.out.println("ataque:");
                 ataque[j][i]=leer.nextInt();

            }
            
        }
        
        int derrj1=0;
        int derrj2=0;
        
        System.out.println("---BATALLA---");
        
        while (derrj1<3 && derrj2<3){
            System.out.println("\njugador 1, elige una criatura para la batalla(1,2o3):");
            int c1=leer.nextInt()-1;
            
            while (c1<0 || c1>2 || vida[0][c1]<=0){
                System.out.println("eleccion invalida o criatura sin vida, elija otra");
                c1=leer.nextInt() -1;
            }
            System.out.println("jugador 2, elige tu criatura para la batalla(1,2,o3)");
            int c2=leer.nextInt()-1;
            
            while (c2<0 || c2>2 || vida [1][c2]<=0){
                System.out.println("eleccion invalida o criatura sin vida, elija otra");
                c2=leer.nextInt() -1;
              
            }
            
            System.out.println("\n--- ENFRENTAMIENTO: " + nom[0][c1] + " VS " + nom[1][c2] + " ---");
            while (vida[0][c1] > 0 && vida[1][c2] > 0) {
                
                System.out.println("\n¡" + nom[0][c1] + " ataca!");
                vida[1][c2] -= ataque[0][c1];
                System.out.println(nom[1][c2] + " pierde " + ataque[0][c1] + " de vida.");
                
                if (vida[1][c2] <= 0) {
                    System.out.println("¡" + nom[1][c2] + " ha sido derrotado!");
                    derrj2++;
                    break;
                    
            }
                System.out.println("Vida restante de " + nom[1][c2] + ": " + vida[1][c2]);
                System.out.println("\n¡" + nom[1][c2] + " contraataca!");
                vida[0][c1] -= ataque[1][c2];
                System.out.println(nom[0][c1] + " pierde " + ataque[1][c2] + " de vida.");
                
                if (vida[0][c1] <= 0) {
                    System.out.println("¡" + nom[0][c1] + " ha sido derrotado!");
                    derrj1++;
                    break;
                }
                System.out.println("Vida restante de " + nom[0][c1] + ": " + vida[0][c1]);
        }   }
               System.out.println("\n===============================");
        if (derrj1 == 3) {
            System.out.println("¡EL JUGADOR 2 HA GANADO EL TORNEO!");
        } else {
            System.out.println("¡EL JUGADOR 1 HA GANADO EL TORNEO!");
        }
        System.out.println("===============================");     
    
        
  
        
    }
    
}

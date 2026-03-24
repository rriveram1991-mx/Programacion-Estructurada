package batalla_rpg;
import java.util.Scanner;
import java.util.Random;
public class batalla_rpg{
    
    public static boolean equipoDerrotado(double[][] statsJugador) {
    for (int i = 0; i < 3; i++) {
        if (statsJugador[i][7] > 0) {
            return false;
        }
    }
    return true; // Si terminó el ciclo y nadie tiene vida, están derrotados
}
    
       public static double calcularArea(double base, double altura) {
        double area = base * altura;
        return area; // Enviamos el resultado de vuelta
    }    
    
    public static void main(String[] args) {
                Scanner output = new Scanner(System.in);
                Random rand = new Random();
                
      // ---------------------------------------------------------------------------------------------------------------------
      
      
      
          String[][] Datos = {
              // Nombre        ID               Tipo
              {"Guerrero","0","Tanque",},
              {"Mago","1","Especial"},
              {"Principe","2","CombateEspecial",},
              {"Caballero","3","Combate",},
              {"Valkiria","4","Salpicadura",},
              {"MagoSanador","5","Soporte",}};
          
                    String[] StatsNames = {"ID","vidaMax","ataque","magia","energia","Escudo","EscudoM","Vida","ConVida","Buff","Debuff","energiaMax"};
                    String[] CharNamesJ1 = new String[3];
                    String[] CharNamesJ2 = new String[3];
                    
          double[][] Stats = {
            // ID  vidaMax   ataque      magia      energia     Escudo       EscudoM
              {0,     55,        10,             5,             8,             .40,             .05},
              {1,     32,        7,               18,           8,             .05,               .50},
              {2,     40,        14,             14,           12,           .20,              .20},
              {3,     48,        18,              8,            10,           .30,              .10},
              {4,     35,        6,               10,           8,             .25,              .25},
              {5,     28,        7,               14,           10,           .10,               .40}
          };
          
          
          double[][] StatsJ1 = new double[3][12];
          double[][] StatsJ2 = new double[3][12];
            // ID     VidaMax   ataque     magia     energia   Escudo    EscudoM    Vida    ConVida   Buff    Debuff   energiaMax
            //  0            1          2              3              4            5                6            7           8         9        10             11
    String Introduccion = """
        ==========================  Combate RPG   ===========================
                                  
        """;
      System.out.println(Introduccion);
      
        System.out.println("Jugador 1 .- Elija sus luchadores\n");
      
        
       for (int x = 0; x < 3; x++) {
                 for (int i = 0; i < Datos.length; i++){  
          System.out.println((i+1)+". "+Datos[i][0]+" - "+Datos[i][2]);
      }
          System.out.println("\n Luchador N."+(x+1)+" =");
          int n0 = output.nextInt();
          output.nextLine();
       int n1 = n0-1;

           System.out.println("\nPersonaje: "+Datos[n1][0]+". Rol: "+Datos[n1][2]+".");
       for (int i = 0; i < Stats.length; i++) {
           
           StatsJ1[x][i] = Stats[n1][i]; 
           StatsJ1[x][7] = Stats[n1][1];  // Vida Actual (7) = Vida Máxima (columna 1 de Stats)
           StatsJ1[x][8] = 1;             // ConVida = 1 (True)
           StatsJ1[x][11] = Stats[n1][4]; 
           StatsJ1[x][9] = 0;             // Buff inicial = 0
           StatsJ1[x][10] = 0;            // Debuff inicial = 0
        
            System.out.print(StatsNames[(i+1)]+": "+Stats[(n1)][(i+1)] + " \n"); // imprime los datos del personaje selecto
}   
           System.out.println("\n");
       }

       
               System.out.println("Jugador 2 .- Elija sus luchadores\n");
      
        
       for (int x = 0; x < 3; x++) {
                 for (int i = 0; i < Datos.length; i++){  
          System.out.println((i+1)+". "+Datos[i][0]+" - "+Datos[i][2]);
      }
          System.out.println("\n Luchador N."+(x+1)+" =");
          int n0 = output.nextInt();
       int n1 = n0-1;

           System.out.println("\nPersonaje: "+Datos[n1][0]+". Rol: "+Datos[n1][2]+".");
       for (int i = 0; i < Stats.length; i++) {
            
           StatsJ2[x][i] = Stats[n1][i]; 
           StatsJ2[x][7] = Stats[n1][1];  // Vida Actual (7) = Vida Máxima (columna 1 de Stats)
           StatsJ2[x][11] = Stats[n1][4]; 
           StatsJ2[x][8] = 1;             // ConVida = 1 (True)
           StatsJ2[x][9] = 0;             // Buff inicial = 0
           StatsJ2[x][10] = 0;            // Debuff inicial = 0
        
            System.out.print(StatsNames[(i+1)]+": "+Stats[(n1)][(i+1)] + " \n"); // imprime los datos del personaje selecto
}   
           System.out.println("\n");
       }
       
       
       /* 
        for (int i = 0; i < StatsJ2.length; i++) { // Recorre filas
    for (int j = 0; j < StatsJ2[i].length; j++) { // Recorre columnas de esa fila
        System.out.print(StatsJ2[i][j] + " ");
    }
    System.out.println(); // Salto de línea al terminar cada fila
}
       */

String CombateIntro = """
        =======================  ¡¡Que Comience la Batalla!!   ========================
                      "Jugador 1                                                                                          Jugador 2"
        """;
  for (int i = 0; i < StatsJ2.length; i++) { // Recorre filas
    for (int j = 0; j < StatsJ2[i].length; j++) { // Recorre columnas de esa fila
        System.out.print(StatsJ2[i][j] + " ");
    }
    System.out.println(); // Salto de línea al terminar cada fila
}
  
        System.out.println("Equipo Jugador 1.");
        for (int x = 0; x < 3; x++) {
            int idBuscado = (int) StatsJ1[x][0]; 
            String nombreEncontrado = "";
            for (int i = 0; i < Datos.length; i++) {
                if (Integer.parseInt(Datos[i][1]) == idBuscado) {
                    nombreEncontrado = Datos[i][0];
                    System.out.println((x+1)+"."+ nombreEncontrado);
                    CharNamesJ1[i] = nombreEncontrado;
                    break;
                }
            }
        }      
        System.out.println("Elija su combatiente: (1-3)");
        int Active_1 = 0;
        boolean pass = false;
        while (pass == false) {
            Active_1 = output.nextInt();
            
            if (Active_1 > 3 || Active_1 < 1) {
            } else {pass = true;}
        }
        
        System.out.println("Equipo Jugador 2.");
        for (int x = 0; x < 3; x++) {
            int idBuscado = (int) StatsJ2[x][0]; 
            String nombreEncontrado = "";
            for (int i = 0; i < Datos.length; i++) {
                if (Integer.parseInt(Datos[i][1]) == idBuscado) {
                    nombreEncontrado = Datos[i][0];
                    System.out.println((x+1)+"."+ nombreEncontrado);
                    CharNamesJ2[i] = nombreEncontrado;
                    break;
                }
            }
        }  
        output.nextLine();
        System.out.println("Elija su combatiente: (1-3)");
        int Active_2 = 0;
        boolean pass2 = false;
        while (pass2 == false) {
        Active_2 = output.nextInt();
        output.nextLine();
        if (Active_2 > 3 || Active_2 < 1) {
        } else {pass2 = true;}
        }
        
        boolean EndBattle = false;
        while (EndBattle == false){ //  ================= PELEA =================
            int Turno = 1;
            boolean FinDelTurno = false;

            System.out.println("\n============= Turno "+Turno+". Jugador 1. =============");
            System.out.println("");
 
            
            System.out.println("\n=================  Tu Equipo  =================");
            System.out.println("Personaje Actual.");
            System.out.println("> "+CharNamesJ1[Active_1]+" HP:"+StatsJ1[Active_1][7]+"/"+StatsJ1[Active_1][1]+" Energia: "+StatsJ1[Active_1][11]+"/"+StatsJ1[Active_1][4]);
            System.out.println("Equipo.");
            for (int i = 0; i < CharNamesJ1.length; i++) {
                if (i != Active_1) {
                System.out.println("> "+CharNamesJ1[i] + " HP:"+StatsJ1[i][7]+"/"+StatsJ1[i][1]+" Energia: "+StatsJ1[i][11]+"/"+StatsJ1[i][4]);
            }}
            
            System.out.println("\n=================      Rival     =================");
                        System.out.println("Personaje Actual.");
            System.out.println("> "+CharNamesJ2[Active_2]+" HP:"+StatsJ2[Active_2][7]+"/"+StatsJ2[Active_2][1]+" Energia: "+StatsJ2[Active_2][11]+"/"+StatsJ2[Active_2][4]);
            System.out.println("Equipo.");
            for (int i = 0; i < CharNamesJ2.length; i++) {
                if (i != Active_2) {
                System.out.println("> "+CharNamesJ2[i] + " HP:"+StatsJ2[i][7]+"/"+StatsJ2[i][1]+" Energia: "+StatsJ2[i][11]+"/"+StatsJ2[i][4]);
            }}
            
            double Action1;
            int IntAction1;
           
            
            while (FinDelTurno == false) {
                            if (StatsJ2[Active_2][7] == 0){
                System.out.println("\n - Este personaje ha sido derrotado.");
                IntAction1 = 4;
                
            } else {
                            System.out.println("");
            System.out.println("1. Atacar | 2. Especial | 3.Habilidad | 4. Cambiar Personaje");
            
             output.nextLine();
             Action1 = output.nextDouble();
             IntAction1 = (int) Action1; 
                            }
            
             
            double Def = StatsJ2[Active_2][5];
            double DefM = StatsJ2[Active_2][6];
            double Healt = StatsJ2[Active_2][7]; // Stats Enemigas
            
            double Damage = StatsJ1[Active_1][2];
            double Eng = StatsJ1[Active_1][11];
            double Change = 1; // Multiplicador de daño
            double FinalDamage = 0;

                    switch (IntAction1) {
             case 1 -> { FinDelTurno = false;
                 StatsJ1[Active_1][11] -= 1;
                 if (Eng > 0){
                     if (rand.nextInt(100) < 15) {// 15% de Fallo 
                  System.out.println("El enemigo esquiva el ataque");
              Change = 0;
              } else { 
              if (rand.nextInt(100) < 15) {// 15% de critico 
                  Change = 1.5;
                  System.err.println("Ataque critico!");} else { 
                  System.out.println("El enemigo ha recibido el ataque.");} }
              if (Change > 0){
             FinalDamage = ((Damage * Change)-(Damage * Def));} else {
              FinalDamage = Damage-(Damage * Def);}
             StatsJ2[Active_2][7] -= FinalDamage;
             System.out.println(FinalDamage+" De daño realizado.");
             System.out.println("> "+CharNamesJ2[Active_2]+" HP:"+StatsJ2[Active_2][7]+"/"+StatsJ2[Active_2][1]); 
                 }else {
                     System.out.println("¡El Ataque fallo, tu personaje esta exausto!");  }}         
            
             case 2 -> { FinDelTurno = false;
                 
                 if (Eng > 0){ 
                     StatsJ1[Active_1][11] -= 1;
                     if (rand.nextInt(100) < 18) {// 18% de Fallo 
                  System.out.println("El enemigo esquiva el ataque");
              Change = 0;
              } else { 
              if (rand.nextInt(100) < 18) {// 18% de critico 
                  Change = 1.5;
                  System.err.println("Ataque Certero!");} else { 
                  System.out.println("El enemigo ha recibido el ataque especial.");} }
              if (Change > 0){
             FinalDamage = ((Damage * Change)-(Damage * DefM));} else {
             FinalDamage = Damage-(Damage * DefM);}
             StatsJ2[Active_2][7] -= FinalDamage;
             System.out.println(FinalDamage+" De daño realizado.");
             System.out.println("> "+CharNamesJ2[Active_2]+" HP:"+StatsJ2[Active_2][7]+"/"+StatsJ2[Active_2][1]); 
                 }else {
                     System.out.println("¡El Ataque fallo, tu personaje esta exausto!");}}
                 
             case 3 -> { FinDelTurno = false;
                 System.out.println("\n==============      Habilidades     ==============");
                 for (int i = 0; i  < CharNamesJ1.length; i++ ) {
                     System.out.println(CharNamesJ1[i]+"  --  Energia: "+StatsJ1[i][11]+"/"+StatsJ1[i][4]);
                 switch (CharNamesJ1[i]) {
                     case "Guerrero" -> System.out.println("""
                                                                     1. Defensa Total  -- Costo de Energia: 4
                                                                         - Los siguentes 2 ataques realizaran 0 de daño
                                                                     """);
                     case "Mago" -> System.out.println("""
                                                                     1. Tormenta  -- Costo de Energia: 6
                                                                         - Realiza 12 de daño a todos los enemigos.
                                                                     2. Bendicion -- Costo de Energia: 2
                                                                         - El proximo ataque Fisico sera critico.
                                                                     """);
                     case "Principe" -> System.out.println("""
                                                                     1. Rayo Celestial  -- Costo de Energia: 6
                                                                         - Realiza 10 de daño Especial y 10 de daño Fisico al enemigos.
                                                                     2. Bendicion -- Costo de Energia: 2
                                                                         - El proximo ataque Fisico sera critico.
                                                                     """);
                     case "Caballero" -> System.out.println("""
                                                                     1. Superviviente -- Costo de Energia: 1
                                                                         - Aumenta sus defensas en un 5% permanentemente. (solo se puede usar estando enfrente hasta un maximo de 4 veces)
                                                                     2. Encantamiento -- Costo de Energia: 6
                                                                         - - Realiza un ataque Especial y Fisico al enemigos.
                                                                     """);
                     case "Valkiria" -> System.out.println("""
                                                                     1. Cura -- Costo de Energia: 5
                                                                         - Regenera 5 puntos de HP a todos los aliados.
                                                                     2. Bendicion -- Costo de Energia: 2
                                                                         - El proximo ataque Fisico sera critico.
                                                                     """);
                     case "MagoSanador" -> System.out.println("""
                                                                     1. Cura Sagrada -- Costo de Energia: 7
                                                                         - Regenera 10 puntos de HP a todos los aliados.
                                                                     2. Bendicion Especial -- Costo de Energia: 4
                                                                         - El proximo ataque Especial sera critico x2.
                                                                     """);
                     default -> {
                     }
                 }
}
                 
                 
             
             
             
             
             }
                
             case 4 -> { FinDelTurno = false;
                 System.out.println("\n==============      Cambiar de personaje     ==============");
                         for (int x = 0; x < 3; x++) {
            int idBuscado = (int) StatsJ1[x][0]; 
            String nombreEncontrado = "";
            for (int i = 0; i < Datos.length; i++) {
                if (Integer.parseInt(Datos[i][1]) == idBuscado) {
                    nombreEncontrado = Datos[i][0];
                    System.out.println((x+1)+"."+ nombreEncontrado);
                    CharNamesJ1[i] = nombreEncontrado;
                    break;
                }
            }
        }
                         output.nextLine();
                         System.out.println("Elija su combatiente: (1-3)");
                         boolean pass3 = false;
                         while (pass3 == false) {
                             Active_1 = output.nextInt();
                             output.nextLine();
                               
                             if (Active_1 > 3 || Active_1 < 1) {
                                 if (StatsJ2[Active_1][7] == 0){
                System.out.println("\n - Este personaje ha sido derrotado.");
                  } else { pass3 = true;
                             } }

                             
                             
                        
        }
             }             
             default -> System.out.println("Accion desconocida");
             
        }}
            
            if (equipoDerrotado(StatsJ2)) {
    System.out.println("¡EL JUGADOR 1 HA GANADO LA BATALLA!");
    EndBattle = true;
    break;
}
            
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                        System.out.println("\n============= Turno "+Turno+". Jugador 2. =============");
            System.out.println("");
 
            
            System.out.println("\n=================  Tu Equipo  =================");
            System.out.println("Personaje Actual.");
            System.out.println("> "+CharNamesJ2[Active_2]+" HP:"+StatsJ2[Active_2][7]+"/"+StatsJ2[Active_2][1]+" Energia: "+StatsJ2[Active_2][11]+"/"+StatsJ2[Active_2][4]);
            System.out.println("Equipo.");
            for (int i = 0; i < CharNamesJ2.length; i++) {
                if (i != Active_2) {
                System.out.println("> "+CharNamesJ2[i] + " HP:"+StatsJ2[i][7]+"/"+StatsJ2[i][1]+" Energia: "+StatsJ2[i][11]+"/"+StatsJ2[i][4]);
            }}
            
            System.out.println("\n=================      Rival     =================");
                        System.out.println("Personaje Actual.");
            System.out.println("> "+CharNamesJ1[Active_1]+" HP:"+StatsJ1[Active_1][7]+"/"+StatsJ1[Active_1][1]+" Energia: "+StatsJ1[Active_1][11]+"/"+StatsJ1[Active_1][4]);
            System.out.println("Equipo.");
            for (int i = 0; i < CharNamesJ1.length; i++) {
                if (i != Active_1) {
                System.out.println("> "+CharNamesJ1[i] + " HP:"+StatsJ1[i][7]+"/"+StatsJ1[i][1]+" Energia: "+StatsJ1[i][11]+"/"+StatsJ1[i][4]);
            }}
            
             
            
           
            
            double Action2;
            int IntAction2;
           
            
            while (FinDelTurno == false) {
                            if (StatsJ2[Active_2][7] == 0){
                System.out.println("\n - Este personaje ha sido derrotado.");
                IntAction2 = 4;
                
            } else {
                            System.out.println("");
            System.out.println("1. Atacar | 2. Especial | 3.Habilidad | 4. Cambiar Personaje");
            
             output.nextLine();
             Action2 = output.nextDouble();
             IntAction2 = (int) Action2; 
                            }
             
            double Def = StatsJ1[Active_1][5];
            double DefM = StatsJ1[Active_1][6];
            double Healt = StatsJ1[Active_1][7]; // Stats Enemigas
            
            double Damage = StatsJ2[Active_2][2];
            double Eng = StatsJ2[Active_2][11];
            double Change = 1; // Multiplicador de daño
            double FinalDamage = 0;

                    switch (IntAction2) {
             case 1 -> { FinDelTurno = false;
                 StatsJ2[Active_2][11] -= 1;
                 if (Eng > 0){
                     if (rand.nextInt(100) < 15) {// 15% de Fallo 
                  System.out.println("El enemigo esquiva el ataque");
              Change = 0;
              } else { 
              if (rand.nextInt(100) < 15) {// 15% de critico 
                  Change = 1.5;
                  System.err.println("Ataque critico!");} else { 
                  System.out.println("El enemigo ha recibido el ataque.");} }
              if (Change > 0){
             FinalDamage = ((Damage * Change)-(Damage * Def));} else {
              FinalDamage = Damage-(Damage * Def);}
             StatsJ1[Active_1][7] -= FinalDamage;
             System.out.println(FinalDamage+" De daño realizado.");
             System.out.println("> "+CharNamesJ1[Active_1]+" HP:"+StatsJ1[Active_1][7]+"/"+StatsJ1[Active_1][1]); 
                 }else {
                     System.out.println("¡El Ataque fallo, tu personaje esta exausto!");  }}         
            
             case 2 -> { FinDelTurno = false;
                 
                 if (Eng > 0){ 
                     StatsJ2[Active_2][11] -= 1;
                     if (rand.nextInt(100) < 18) {// 18% de Fallo 
                  System.out.println("El enemigo esquiva el ataque");
              Change = 0;
              } else { 
              if (rand.nextInt(100) < 18) {// 18% de critico 
                  Change = 1.5;
                  System.err.println("Ataque Certero!");} else { 
                  System.out.println("El enemigo ha recibido el ataque especial.");} }
              if (Change > 0){
             FinalDamage = ((Damage * Change)-(Damage * DefM));} else {
             FinalDamage = Damage-(Damage * DefM);}
             StatsJ1[Active_1][7] -= FinalDamage;
             System.out.println(FinalDamage+" De daño realizado.");
             System.out.println("> "+CharNamesJ1[Active_1]+" HP:"+StatsJ1[Active_1][7]+"/"+StatsJ1[Active_1][1]); 
                 }else {
                     System.out.println("¡El Ataque fallo, tu personaje esta exausto!");}}
                 
             case 3 -> { FinDelTurno = false;
                 System.out.println("\n==============      Habilidades     ==============");
                 for (int i = 0; i  < CharNamesJ2.length; i++ ) {
                     System.out.println(CharNamesJ2[i]+"  --  Energia: "+StatsJ2[i][11]+"/"+StatsJ2[i][4]);
                 switch (CharNamesJ2[i]) {
                     case "Guerrero" -> System.out.println("""
                                                                     1. Defensa Total  -- Costo de Energia: 4
                                                                         - Los siguentes 2 ataques realizaran 0 de daño
                                                                     """);
                     case "Mago" -> System.out.println("""
                                                                     1. Tormenta  -- Costo de Energia: 6
                                                                         - Realiza 12 de daño a todos los enemigos.
                                                                     2. Bendicion -- Costo de Energia: 2
                                                                         - El proximo ataque Fisico sera critico.
                                                                     """);
                     case "Principe" -> System.out.println("""
                                                                     1. Rayo Celestial  -- Costo de Energia: 6
                                                                         - Realiza 10 de daño Especial y 10 de daño Fisico al enemigos.
                                                                     2. Bendicion -- Costo de Energia: 2
                                                                         - El proximo ataque Fisico sera critico.
                                                                     """);
                     case "Caballero" -> System.out.println("""
                                                                     1. Superviviente -- Costo de Energia: 1
                                                                         - Aumenta sus defensas en un 5% permanentemente. (solo se puede usar estando enfrente hasta un maximo de 4 veces)
                                                                     2. Encantamiento -- Costo de Energia: 6
                                                                         - - Realiza un ataque Especial y Fisico al enemigos.
                                                                     """);
                     case "Valkiria" -> System.out.println("""
                                                                     1. Cura -- Costo de Energia: 5
                                                                         - Regenera 5 puntos de HP a todos los aliados.
                                                                     2. Bendicion -- Costo de Energia: 2
                                                                         - El proximo ataque Fisico sera critico.
                                                                     """);
                     case "MagoSanador" -> System.out.println("""
                                                                     1. Cura Sagrada -- Costo de Energia: 7
                                                                         - Regenera 10 puntos de HP a todos los aliados.
                                                                     2. Bendicion Especial -- Costo de Energia: 4
                                                                         - El proximo ataque Especial sera critico x2.
                                                                     """);
                     default -> {
                     }
                 }
}
                 
                 
             
             
             
             
             }
                
             case 4 -> { FinDelTurno = false;
                 System.out.println("\n==============      Cambiar de personaje     ==============");
                         for (int x = 0; x < 3; x++) {
            int idBuscado = (int) StatsJ2[x][0]; 
            String nombreEncontrado = "";
            for (int i = 0; i < Datos.length; i++) {
                if (Integer.parseInt(Datos[i][1]) == idBuscado) {
                    nombreEncontrado = Datos[i][0];
                    System.out.println((x+1)+"."+ nombreEncontrado);
                    CharNamesJ2[i] = nombreEncontrado;
                    break;
                }
            }
        }
                         output.nextLine();
                         System.out.println("Elija su combatiente: (1-3)");
                         boolean pass3 = false;
                         while (pass3 == false) {
                             Active_1 = output.nextInt();
                             output.nextLine();
                               
                             if (Active_1 > 3 || Active_1 < 1) {
                                 if (StatsJ2[Active_1][7] == 0){
                System.out.println("\n - Este personaje ha sido derrotado.");
                  } else { pass3 = true;
                             } }

                             
                             
                        
        }
             }             
             default -> System.out.println("Accion desconocida");
             
        }}
        
            if (equipoDerrotado(StatsJ1)) {
    System.out.println("¡EL JUGADOR 2 HA GANADO LA BATALLA!");
    EndBattle = true;
    break;
}
            
            
        } // Battle While
}}

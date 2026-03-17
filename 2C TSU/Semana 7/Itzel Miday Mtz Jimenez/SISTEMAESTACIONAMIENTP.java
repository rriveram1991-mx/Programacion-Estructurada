
package sistemaestacionamientp;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class SISTEMAESTACIONAMIENTP {
    public static void main(String[] args) {
        Scanner mika = new Scanner (System.in);
         int[][] MATR = {
            {0,1,2,3,4,5},
            {1,0,0,0,0,0},
            {2,0,0,0,0,0}
        };
        int EO=0,FI=0,CO=0;
         String MM,OU;
         boolean OP=true,ER=true;
         System.out.println("BIENVENIDO AL SISTEMA.");
         while (OP){
             System.out.println("""
                                ---------------------------------------------------------------------------
                                                                    MENU
                                                         1. Ver estacionamiento
                                                           2. Estacionar auto
                                                            3. Retirar auto
                                                        4. Contar espacios ocupados
                                                                5. Salir
                                 ---------------------------------------------------------------------------
                                """); 
             OU = mika.next();
             switch (OU){
                 case "1":
                     System.out.println("""
                                        ESTACIONAMIENTO.
                                        0 = LIBRE.
                                        1 = OCUPADO.
                                        RECUERDE: LA PRIMERA FILA Y COLUMNA SON EL ESPACIO EN EL QUE SE ENCUENTRA EL LUGAR. NO REPRESENTA ESPACIO EN EL ESTACIONAMIENTO.
                                        """);
                     for (int I=0;I<MATR.length;I++){
                         for (int X=0;X<MATR[I].length;X++){
                             System.out.print(MATR[I][X]+"");
                         }
                         System.out.println();
                     }
                     break;
                 case "2": 
                     System.out.println("Estacione su auto.");
                     System.out.println("Ingrese fila: ");
                     FI = mika.nextInt();
                     System.out.println("Ingrese columna: ");
                     CO = mika.nextInt();
                     if (FI>=0 && FI<MATR.length && CO >= 0 && CO<MATR[0].length){
                    
                     if (MATR[FI][CO] == 0){
                         MATR[FI][CO]=1;
                         System.out.println("Espacio ocupado con exito!");
                         EO++;
                     }else{
                         System.out.println("La posicion ya esta ocupada.");
                         ER=false;
                     }
                     }else{
                         System.out.println("Posicion invalida.");
                         ER=false;
                     }
                     while (!ER){
                         System.out.println("Ingrese una nueva posicion."); 
                         System.out.println("Fila: ");
                         FI = mika.nextInt();
                         System.out.println("Columna: ");
                         CO = mika.nextInt();
                         if (MATR[FI][CO] == 0){
                         MATR[FI][CO]=1;
                         System.out.println("Espacio ocupado con exito!");
                         EO++;
                      ER=true;
                     }else{
                             System.out.println("Posicion invalida.");
                             ER=false;
                         }
                     }
                     break;
                 case "3":
                     System.out.println("Retire su auto.");
                     System.out.println("Ingrese fila: ");
                     FI = mika.nextInt();
                     System.out.println("Ingrese columna: ");
                     CO = mika.nextInt();
                      if (FI>=0 && FI<MATR.length && CO >= 0 && CO<MATR[0].length){
                     if (MATR[FI][CO] == 1){
                         MATR[FI][CO]=0;
                         System.out.println("Posicion liberada con exito!");
                         EO--;
                     }else{
                         System.out.println("La posicion ya esta libre.");
                         ER=false;
                     }
                     }else{
                         System.out.println("Posicion invalida.");
                         ER=false;
                     }
                      break;
                 case "4": 
                     System.out.println("Espacios ocupados: "+EO);
                     break;
                 case "5":
                     OP=false;
                     break;
                 default:
                     System.out.println("Opcion invalida.");
             }
         }
          try{
           FileWriter E = new FileWriter("TICKET.txt");
            for (int I=0;I<MATR.length;I++){
                         for (int X=0;X<MATR[I].length;X++){
                             E.write(MATR[I][X]+"");
                         }
                         E.write("\n");
            }
           E.write("Total de espacios ocupados: "+EO);
           E.close();
       }catch (IOException e){
           System.out.println("Error al generar ticket.");
           e.printStackTrace(); 
       }
    }
    
}

package cuatri2.unidad3;

import java.util.Scanner;

public class sem6ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] estacionamiento = new int[7][5];
        int[][] asientos = new int[16][22];
        String libre = "Libre",ocupado = "Ocupado",a;
        System.out.println("Elige donde estacionarte:");
        System.out.println("Asientos");

        System.out.println("FILA "  + " COLUMNA " );
        for(int y = 0; y < estacionamiento.length; y++){
            for(int x = 0;x < estacionamiento[y].length; x++ ){
                
                if (estacionamiento[y][x] == 0) {
                     a = libre;
                } else {
                    a = ocupado;
                }
               
                System.out.println(" "+ ( y+1  ) + "       " + (    x+1)+" ----- " + a);
            }
            
        }
        System.out.println("Elige la fila:");
        int fi = sc.nextInt();
        System.out.println("Elige la columna");
        int col = sc.nextInt();
        
        fi --;
        col --;
        int wi = 0;
        while (wi == 0) {
            if (fi < 0 || fi >= estacionamiento.length || col < 0 || col >= estacionamiento[0].length) {
                System.out.println("Valor no valido");
                System.out.println("Elige la fila:");
                fi = sc.nextInt();
                System.out.println("Elige la columna");
                col = sc.nextInt();
                fi --;
                col --;
            } else if(estacionamiento[fi][col] == 1){
                System.out.println("El lugar "+(fi+1)+ ""+(col+1)+" ya esta ocupado");
                System.out.println("Elige la fila:");
                fi = sc.nextInt();
                System.out.println("Elige la columna");
                col = sc.nextInt();
                fi --;
                col --;
            } else {
                estacionamiento[fi][col] = 1;
                System.out.println("Lugar "+(fi+1)+ ""+(col+1)+" elegido correctamente");
                wi = 1;
            }
            
        }
        if (fi < 0 || fi >= estacionamiento.length || col < 0 || col >= estacionamiento[0].length) {
           System.out.println("Valor no valido"); 
        } else if(estacionamiento[fi][col] == 1){
            System.out.println("El lugar "+(fi+1)+ ""+(col+1)+" ya esta ocupado");

        } else {
            estacionamiento[fi][col] = 1;
            System.out.println("Lugar "+(fi+1)+ ""+(col+1)+" elegido correctamente");
        }

        System.out.println("Asientos de cine");
         for(int y = 0; y < asientos.length; y++){
            for(int x = 0;x < asientos[y].length; x++ ){
                
                if (asientos[y][x] == 0) {
                     a = libre;
                } else {
                    a = ocupado;
                }
               
                System.out.println(" "+ ( y+1  ) + "       " + (    x+1)+" ----- " + a);
            } 
        }

        System.out.println("Elige la fila:");
        fi = sc.nextInt();
        System.out.println("Elige la columna");
        col = sc.nextInt();
        
        fi --;
        col --;
        wi = 0;

        while (wi == 0) {
            if (fi < 0 || fi >= asientos.length || col < 0 || col >= asientos[0].length) {
                System.out.println("Valor no valido");
                System.out.println("Elige la fila:");
                fi = sc.nextInt();
                System.out.println("Elige la columna");
                col = sc.nextInt();
                fi --;
                col --;
            } else if(asientos[fi][col] == 1){
                System.out.println("El lugar "+(fi+1)+ ""+(col+1)+" ya esta ocupado");
                System.out.println("Elige la fila:");
                fi = sc.nextInt();
                System.out.println("Elige la columna");
                col = sc.nextInt();
                fi --;
                col --;
            } else {
                asientos[fi][col] = 1;
                System.out.println("Lugar "+(fi+1)+ ""+(col+1)+" elegido correctamente");
                wi = 1;
            }
        }

    }


}


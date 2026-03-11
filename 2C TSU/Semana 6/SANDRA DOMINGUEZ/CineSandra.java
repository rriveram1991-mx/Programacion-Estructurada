
package cine.sandra;

public class CineSandra {
//SANDRA DOMINGUEZ
    
    public static void main(String[] args) {
        //TENGO QUE DECLARAR EL ARRAY
        int [][] Cine=new int [9][14];
        
        //INICIALIZAR LOS VALORES
        for (int FILA=0; FILA<9; FILA++)
        {
            for (int COL=0; COL<14; COL++)
                    {
                        Cine[FILA][COL]=0;  //TODOS LOS ASIENTOS ESTAN DISPONIBLES
                    }
        }
        //LUEGO MODIFICAR LOS VALORES
        Cine[0][0]=1;  //ASIENTOS OCUPADO
        Cine[0][1]=1;
        Cine[0][2]=1;
        Cine[5][8]=2;  //ASIENTOS SELECCIONADO
        Cine[8][13]=2;
        Cine[8][12]=2;
        
        //MOSTRAR LA MATRIZ
        for (int FILA=0; FILA<9; FILA++)
        {
             for (int COL=0; COL<14; COL++)
             {
                 System.out.print("" + Cine[FILA][COL]);
             }
             System.out.println();
        }
    }
    
}

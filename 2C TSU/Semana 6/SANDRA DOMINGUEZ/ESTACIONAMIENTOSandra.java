
package estacionamiento.sandra;

public class ESTACIONAMIENTOSandra {
//SANDRA DOMINGUEZ
    
    public static void main(String[] args) {
        int [][] CARRO=new int [5][10];
        
        //INICIALIZAR LOS VALORES
        for (int FILA=0; FILA<5; FILA++)
        {
            for (int COL=0; COL<10; COL++)
                    {
                        CARRO[FILA][COL]=0;  //LUGARES QUE ESTAN DISPONIBLES
                    }
        }
        //LUEGO MODIFICAR LOS VALORES
        CARRO[0][0]=1;  //LUGAR OCUPADO
        CARRO[2][8]=1;
        CARRO[4][9]=1;
       
        
        //MOSTRAR LA MATRIZ
        for (int FILA=0; FILA<5; FILA++)
        {
             for (int COL=0; COL<10; COL++)
             {
                 System.out.print("" + CARRO[FILA][COL]);
             }
             System.out.println();
        }
    }
    
}

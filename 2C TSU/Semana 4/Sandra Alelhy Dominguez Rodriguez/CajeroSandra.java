
package cajero.sandra;

import java.util.Scanner;  //IMPORTAR

public class CajeroSandra {
//SANDRA DMZ
    
    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);  //PARA PODER LEER.
        
        //DEFINIR VARIABLES.
        double SaldoI, Dep, Ret;
        boolean M=true;
        int opc, ContOp=0;
        
        System.out.println("INGRESE SALDO INICIAL:"); //PEDIR INGRESAR SALDO
        SaldoI=leer.nextDouble();
        
        while (M)  //REPETIR HASTA QUE DEESEN SALIR
        {
            System.out.println("-----MENU:------"); //MOSTRAR EL MENU
            System.out.println("1- CONSULTAR SALDO");
            System.out.println("2- DEPOSITAR");
            System.out.println("3- RETIRAR");
            System.out.println("4- SALIR");
            
            leer.nextLine();
            System.out.println("INGRESE UNA OPCION DEL MENU:");
            opc=leer.nextInt();
            
            if (opc==1)  //USAR EL IF, DEPENDIENDO LA OPCION SELECCIONADA.
            {
                System.out.println("SU SALDO ACTUAL ES:$ "+SaldoI);
                ContOp++;
            }
            else if (opc==2)
                    {
                        System.out.println(" INGRESE CANTIDAD A DEPOSITAR: ");
                        Dep=leer.nextDouble();
            if (Dep>=0)
            {
                SaldoI+=Dep;
                System.out.println("DEPOSITO EXITOSO. SALDO ACTUAL:$ " +SaldoI);
                ContOp++;
            }
            else
            {
                System.out.println("NO SE PERMITEN CANTIDADES NEGATIVAS");
            }
                    }

           else if (opc==3)
            {
                System.out.println("INGRESE CANTIDAD QUE DESEA RETIRAR: ");
                Ret=leer.nextDouble();
           if (0<=Ret && Ret<=SaldoI)
           {
              SaldoI=Ret;
                System.out.println("RETIRO EXITOSO. SALDO ACTUAL:$ "+SaldoI);
            }
            else 
            {
                System.out.println("EL RETIRO NO PUEDE SER MAYOR DEL SALDO ");
                ContOp++;
            }
            
           }
            else if (opc==4)
                    {
                        System.out.println("TOTAL OPERACIONES REALIZADAS:"+ContOp);
                        System.out.println("SALIR- GRACIAS POR USAR EL CAJERO AUTOMATICO");
                        M=false;
                    }
            else
            {
                System.out.println("OPCION NO VALIDA");  //EN CASO DE QUE PONGA OTRA OPCION QUE NO SE MUESTRA NO ES VALIDA.
            }
        }
    }
    
}

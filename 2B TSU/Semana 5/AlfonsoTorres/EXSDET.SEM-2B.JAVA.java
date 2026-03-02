/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exs.pkg4.pkg2b.alftorres.pt1;

import java.util.Scanner;

/**
 *
 * @author fonso
 */
public class EXS42BALFTORRESPT1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic hereimport java.util.Scanner;

   
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        double totalVentas = 0;
        int contadorVentas = 0;
        while (opcion != 3) //ERROR 1, SINTAXIS. No debe de haber un ";" 
        {   
            System.out.println("1. Registrar venta");
            System.out.println("2. Mostrar total vendido");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese monto de la venta: ");
                    double venta = sc.nextDouble();
                    if (venta <= 0) //ERROR 2. SINTAXIS. No debe de haber un ";". 
                        //ERROR 3. LOGICO. Si no hay un "=", el programa registraba la venta como valida.
                    {   
                        System.out.println("Venta invalida");
                    } else {
                        totalVentas += venta; //ERROR 5. LOGICO. El programa no sumaba los montos, usando la ultima, por ello se utiliza "+=", Para sumarse.  
                        contadorVentas++;
                        System.out.println("Venta registrada");
                    }
                    break;
                case 2:
                    System.out.println("Total vendido: " + totalVentas);
                    for (int i = 1; i <= contadorVentas; i++) //ERROR 4. LOGICO. Leía desde 0,imprimiendo una venta inexistente.
                    {   
                        System.out.println("Procesando venta..."+i);
                        
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
        sc.close();
    }
}

    
    


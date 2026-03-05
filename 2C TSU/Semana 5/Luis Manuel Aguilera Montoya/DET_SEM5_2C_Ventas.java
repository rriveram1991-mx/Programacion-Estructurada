/* Luis Manuel Aguilera Montoya

El sistema debe:
Registrar 6 ventas (montos en pesos).
No permitir ventas negativas.
Calcular:
Total vendido
Promedio de ventas
Venta mayor
Mostrar cuántas ventas fueron mayores al promedio. */

import java.util.Scanner;

public class DET_SEM5_2C_Ventas
{
 public static void main(String[] args)
 {
    //Declarar variables
    Scanner entrada = new Scanner(System.in);
    double ventas[] = new double[6]; //Declarar array, el "6" nos dice el tamaño del arreglo
    double total = 0, promedio = 0;
    double venta_mayor = 0;
    int ventas_mayores = 0;

    System.out.println("----- SISTEMA DE VENTAS ------");
    System.out.println("Ingrese las 6 ventas (en pesos): ");

     //Ciclo for para agregarle las ventas al arreglo
        for (int i = 0; i < ventas.length;) //Elimine el i++ de dentro de la condición del for para que solo aumente cuanto el dato ingresado sea correcto 
        {
            double ven = entrada.nextDouble();      //La ventea la guarde primero en una variable para que pueda comparar en el if si es correcta o no
            if (ven >= 0)             //Si "ven" cumple con las condiciones se agrega al arreglo
            {
            ventas[i] = ven;
            total += ventas[i];
            i++;                            
            }
            else                                    //Si "ven" no cumple con las condiciones se manda un mensaje y no cuenta para el arreglo
            {
                System.out.println("Monto inválido. Ingrese de nuevo...");
            }
        }

        promedio = total / ventas.length;    //prom = suma/(tamaño del arreglo de ventas | 5)

        //Venta mayor y mayores al promedio
        for (double v : ventas)
        {
            if (v > venta_mayor) venta_mayor = v; //En cada ciclo compara si la venta fue mayor a la venta_mayor, si lo fue entonces v remplazará a la venta_mayor
            if (v > promedio) ventas_mayores++;
        }

        System.out.println("\nTotal: $" + total);
        System.out.println("Promedio: $" + promedio);
        System.out.println("Cantidad de ventas mayores al promedio: " + ventas_mayores);
        System.out.println("La venta mayor fue de $" + venta_mayor);
 }   
}

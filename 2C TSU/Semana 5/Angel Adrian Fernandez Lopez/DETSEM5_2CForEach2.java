/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;
import java.util.Locale;
// Importa Scanner para leer datos
// Importa Locale para permitir punto decimal correctamente

public class DETSEM5_2CForEach2 {

    public static void main(String[] args) {

        Scanner Leer = new Scanner(System.in);
        Leer.useLocale(Locale.US);
        // Configura el Scanner para que use punto como decimal

        double[] gastos = new double[8];
        // Arreglo para almacenar 8 gastos

        double suma = 0;
        // Variable acumuladora para la suma total

        // ------------------------------
        // ENTRADA DE DATOS CON VALIDACION
        // ------------------------------

        for(int i = 0; i < gastos.length; i++){
        // Recorre las 8 posiciones del arreglo

            boolean valido = false;
            // Bandera para controlar que el dato sea correcto

            while(!valido){
            // Se repite hasta que el usuario ingrese un numero valido

                try{
                    System.out.print("Ingrese gasto " + (i+1) + ": ");

                    double entrada = Leer.nextDouble();
                    // Lee el numero ingresado

                    if(entrada < 0){
                        // Validacion adicional: no permitir gastos negativos
                        System.out.println("Error: El gasto no puede ser negativo");
                    }
                    else{
                        gastos[i] = entrada;
                        // Guarda el gasto en el arreglo

                        valido = true;
                        // Sale del while si el dato es correcto
                    }

                }
                catch(Exception e){
                    // Si el usuario escribe letras u otro valor invalido

                    System.out.println("Error: Solo se permiten numeros");
                    Leer.next();
                    // Limpia el dato incorrecto del buffer
                }
            }
        }

        // ------------------------------
        // CALCULAR SUMA TOTAL
        // ------------------------------

        for(double g : gastos){
        // Recorre el arreglo usando for-each

            suma += g;
            // Suma cada gasto al acumulador
        }

        double promedio = suma / gastos.length;
        // Calcula el promedio

        int altos = 0;
        // Contador de gastos mayores al promedio

        System.out.println("\nGastos mayores al promedio:");

        // ------------------------------
        // MOSTRAR GASTOS MAYORES AL PROMEDIO
        // ------------------------------

        for(double g : gastos){
        // Recorre nuevamente el arreglo

            if(g > promedio){
                System.out.printf("%.2f\n", g);
                // Imprime el gasto con 2 decimales
                altos++;
                // Incrementa contador
            }
        }

        // ------------------------------
        // RESULTADOS FINALES
        // ------------------------------

        System.out.printf("\nTotal gastado: %.2f\n", suma);
        System.out.printf("Promedio: %.2f\n", promedio);
        System.out.println("Cantidad de gastos altos: " + altos);

        
    }
}
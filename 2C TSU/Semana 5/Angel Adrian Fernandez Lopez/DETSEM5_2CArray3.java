/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner; 
// Importa la clase Scanner para leer datos desde el teclado

public class DETSEM5_2CArray3 {

    public static void main(String[] args) {

        Scanner Leer = new Scanner(System.in); 
        // Crea el objeto Scanner para capturar entrada del usuario

        double[] temps = new double[7]; 
        // Arreglo para guardar 7 temperaturas (una por cada dia)

        double suma = 0; 
        // Variable acumuladora para calcular el promedio

        // ------------------------------
        // INGRESO DE TEMPERATURAS CON VALIDACION
        // ------------------------------

        for(int i = 0; i < temps.length; i++){
        // Recorre el arreglo desde 0 hasta 6

            boolean valido = false; 
            // Bandera que controla si el dato ingresado es correcto

            while(!valido){
            // Se repite hasta que el usuario ingrese un valor valido

                try{
                    System.out.print("Ingrese temperatura en Celsius del dia " 
                                     + (i+1) + " (-50 a 60): ");

                    String entrada = Leer.nextLine(); 
                    // Lee lo que el usuario escribe como texto

                    entrada = entrada.replace(",", "."); 
                    // Si el usuario escribe coma, la reemplaza por punto

                    double temp = Double.parseDouble(entrada); 
                    // Convierte el texto a numero decimal

                    if(temp < -50 || temp > 60){
                    // Valida que la temperatura este dentro del rango real

                        System.out.println("Error: Temperatura fuera de rango real");
                    } 
                    else{
                        temps[i] = temp; 
                        // Guarda la temperatura en el arreglo

                        valido = true; 
                        // Sale del while porque el dato es correcto
                    }

                }catch(Exception e){
                    // Si el usuario escribe letras u otro valor invalido

                    System.out.println("Error: Solo se permiten numeros");
                }
            }
        }

        // ------------------------------
        // CALCULO DEL PROMEDIO
        // ------------------------------

        for(double t : temps){
        // Recorre el arreglo usando for-each

            suma += t; 
            // Suma cada temperatura al acumulador
        }

        double promedio = suma / temps.length; 
        // Divide la suma entre la cantidad de dias

        System.out.printf("\nPromedio semanal: %.2f C\n", promedio);
        // Muestra el promedio con 2 decimales

        // ------------------------------
        // DETECTAR OLA DE CALOR
        // (3 dias seguidos mayores a 35 C)
        // ------------------------------

        int consecutivos = 0; 
        // Contador de dias consecutivos arriba de 35

        boolean ola = false; 
        // Bandera que indica si hubo ola de calor

        for(double t : temps){
        // Recorre cada temperatura

            if(t > 35){
                consecutivos++; 
                // Si supera 35, aumenta el contador

                if(consecutivos == 3){
                    ola = true; 
                    // Si hay 3 seguidos, activa la bandera
                }
            } 
            else{
                consecutivos = 0; 
                // Si un dia no cumple, reinicia el contador
            }
        }

        if(ola){
            System.out.println("Hubo ola de calor esta semana");
        } 
        else{
            System.out.println("No hubo ola de calor");
        }

        // ------------------------------
        // DETECTAR INCREMENTO BRUSCO
        // (Cambio mayor a 20 grados entre dias consecutivos)
        // ------------------------------

        boolean incrementoBrusco = false; 
        // Bandera para detectar cambios extremos

        for(int i = 1; i < temps.length; i++){
        // Empieza en 1 para poder comparar con el dia anterior

            double diferencia = Math.abs(temps[i] - temps[i-1]); 
            // Calcula la diferencia absoluta entre dias consecutivos

            if(diferencia > 20){
            // Si la diferencia es mayor a 20 grados

                incrementoBrusco = true;

                System.out.println("Incremento brusco entre dia " 
                                   + i + " y dia " + (i+1) +
                                   " (Diferencia: " + diferencia + " C)");
            }
        }

        if(!incrementoBrusco){
            System.out.println("No hubo incrementos bruscos significativos");
        }

    }
}
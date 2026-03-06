/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req2pasajeros;

import java.util.Scanner;

/**
 *
 * @author ssjoa
 */
/*El sistema debe solicitar:
Número de pasajeros.
Crear dos arrays:
String[] nombres
String[] destinos
Captura:
Usar for para capturar nombre y destino.
Validar con while que el nombre no esté vacío.
Si está vacío → mostrar error usando if.
Procesamiento:
Usar for-each para mostrar la lista completa de pasajeros.
Contar cuántos pasajeros van a cada destino.
Si el destino es "CDMX" → mostrar "Viaje largo".
Si el destino es "Local" → mostrar "Viaje corto".
Al final mostrar:
Destino con más pasajeros.
Total de pasajeros registrados.*/
public class REQ2Pasajeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
     Scanner leer = new Scanner(System.in);
     String nombres [] = new String [1376];/*dato curioso, este es el total de personas que pueden viajar en el tren Mexico-Toluca y el limite de los datos*/
     String destinos;
     int largo = 0;
     int corto =0;
     int pasajeros = 0;/*contadores*/
     
     for (int n = 0; n < nombres.length; n++) /*ciclo de conteo para la sucecion y captura de datos*/
     {
         System.out.println("Ingrese el nombre del pasajero "+ (n+1));
         nombres[n] = leer.nextLine();
          while(nombres[n].equals(""))/*interupccion del ciclo en caso de dejar en blanco el "nombre" */
         {
             if(nombres[n].equals(""))/*accion a tomar para compensar la falta de nombre*/
             {
             System.out.println("nombre invalido, por favor intente de nuevo");
             nombres[n]=leer.nextLine();
             }
         }
         
         System.out.println("Ingrese el destino del pasajero [CDMX/local]");
         destinos= leer.nextLine();
         if(destinos.equals("CDMX"))/*arreglo para clasificar y sumar el total de los viajes o, caso contrario, asegurarnos de que la opcion de viaje sea valida*/
         {
         System.out.println("Viaje largo");
         largo++;
         }else if(destinos.equals("local"))
         {
         System.out.println("Viaje corto");
         corto++;
         }else
         {
         System.out.println("Destino invalido");
         }
         pasajeros++;
         
        
         
         System.out.println("Desea agregar mas pasajeros? [Si/No]");/*boton de salida para interrumpir la captura de datos e imprimir los datos*/
         String salida = leer.nextLine();
         if(salida.equalsIgnoreCase("no"))
         {
             break;/*interupccion del ciclo para marcar su salida*/
         }
    }
     
     for(String pasajero : nombres)/* for each que indica la lista de pasajeros*/
     {
         if (pasajero==null)/*esta accion es para asegurarnos de que los resultados se impriman, independientemente de si llenamos los espacios del arreglo o no*/
         {
             break;/*interrupcion del arreglo*/
         }
         System.out.println("---------------------");
         System.out.println("Pasajero "+pasajero);
     }
     
     
     
      if(corto > largo)/*arreglos para expresar los resultados segun el total de destinos que se selecciono*/
         {
             System.out.println("El destino con mas pasajeros fue: Local" + ";" + " con: " +corto+" pasajeros");
             System.out.println("Total de pasajeros: "+pasajeros);
             
             
         }else if(corto < largo)
         {
             System.out.println("El destino con mas pasajeros fue: CDMX" + ";"+  " con: " +largo+" pasajeros");
             System.out.println("Total de pasajeros: "+pasajeros);
         }
         
     
        
        
        
        
        
        
    }
    
}

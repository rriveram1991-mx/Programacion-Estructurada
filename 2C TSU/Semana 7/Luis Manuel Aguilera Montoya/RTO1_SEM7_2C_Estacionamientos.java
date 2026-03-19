/* Luis Manuel Aguilera Montoya
RETO: Sistema de Control de Estacionamiento

Objetivo
Crear un programa en Java que simule un pequeño sistema de estacionamiento donde se registren autos, se consulten espacios y se calcule el total de autos.
Debes crear un programa que cumpla con lo siguiente:

* Crear el estacionamiento
Usar un array de tamaño 10 para representar los espacios.
Cada espacio puede tener:
"LIBRE"
"OCUPADO"

* Menú interactivo
1. Ver estacionamiento
2. Estacionar auto
3. Retirar auto
4. Contar espacios ocupados
5. Salir del programa */


import java.util.Scanner;
import java.io.File; // Crear, leer o manipular archivos y carpetas.
import java.io.FileWriter; // Escribir texto dentro de un archivo.
import java.io.IOException; // Manejar errores relacionados con archivos.


public class RTO1_SEM7_2C_Estacionamientos
{
    public static void main(String[] args)
    {

        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        String [][] estacionamiento = new String[10][10];


        //LLENAR VALORES DEL ARREGLO ESTACIONAMIENTO. Por default todos estarán libres.
        for (int i = 0; i < estacionamiento.length; i++)
        {
            for (int j = 0; j < estacionamiento.length; j++)
            {
                estacionamiento[i][j] = "[ LIBRE ]"; 
            }   
        }

        
        do 
        {
            System.out.println("\n##### === SISTEMA DE ESTACIONAMIENTO --- #####");
            System.out.println("1. Ver estacionamiento \n2. Estacionar auto \n3. Retirar auto \n4. Contar espacios ocupados \n5. Salir ");
            System.out.println("\nIngrese la opción: ");
            opcion = entrada.nextInt();

            switch (opcion)
            {
                case 1: //VER ESTACIONAMIENTO
                    {
                        for (int i = 0; i < estacionamiento.length; i++)
                        {
                            for (int j = 0; j < estacionamiento.length; j++)
                            {
                               System.out.print(estacionamiento[i][j]);   //Solo .print para que no pase renglon 
                            }   
                            System.out.println(); // Salto de línea para la siguiente fila
                        }
                    }
                break;

                case 2: //ESTACIONAR CARRO
                {
                    int f, c; //Coordenadas del lugar
                    System.out.println("Ingrese la coordenada del estacionamiento a escoger (Fila y Columna):");
                    f=entrada.nextInt(); //fila
                    c=entrada.nextInt(); //columna

                    if ((f >= 0 && f <=10) && (c >= 0 && c <=10)) //Modificar a OCUPADO el lugar de estacionamiento
                    {
                        if (estacionamiento[f-1][c-1].equals("[ LIBRE ]")) //f-1 y c-1 porque el arreglo cuenta desde 0,0 y las coordenas empiezan con 1,1
                            estacionamiento[f-1][c-1] = "[OCUPADO]";
                        else
                            System.out.println("El lugar ya esta ocupado...");
                    }
                    else
                    {
                        System.out.println("Coordenada inválida...");
                    }
                }
                break;

                case 3: //RETIRAR CARRO
                    {
                        int f, c; //Coordenadas del lugar
                        System.out.println("Ingrese la coordenada del estacionamiento a escoger (Fila y Columna):");
                        f=entrada.nextInt();
                        c=entrada.nextInt();

                        if ((f >= 0 && f <=10) && (c >= 0 && c <=10)) //Modificar a LIBRE el lugar de estacionamiento
                        {
                            if (estacionamiento[f-1][c-1].equals("[OCUPADO]")) //f-1 y c-1 porque el arreglo cuenta desde 0,0 y las coordenas empiezan con 1,1
                                estacionamiento[f-1][c-1] = "[ LIBRE ]";
                            else
                            System.out.println("El lugar esta libre, no hay ningún carro...");
                        }
                        else
                        {
                            System.out.println("Coordenada inválida...");
                        }
                    }
                    break;

                case 4: //CONTAR LUGARES OCUPADOS
                    {
                        int n_ocupados = 0;

                        for (String[] fila : estacionamiento) //El primer for-each obtiene cada fila
                        {
                            for (String valor : fila) //El segundo for-each recorre la fila actual para obtener los valores
                            {
                                if (valor.equals("[OCUPADO]"))
                                {
                                    n_ocupados += 1;
                                }
                            }    
                        }
                        System.out.println("El número de lugares ocupados son: " + n_ocupados);
                    }
                    break;
                
                case 5:
                    {
                        opcion = 5; //Para salir del bucle
                        System.out.println("Hasta luego!");
                    }
                    break;
                    
                default:
                    System.out.println("Opción inválida. Intente de nuevo...");
                    break;
            }
        } while (opcion != 5);
    

        //CREACION DEL ARCHIVO .TXT
        try
        {
            File miArchivo = new File("estacionamiento.txt");

            if (miArchivo.createNewFile())
            {
                System.out.println("Archivo creado: " + miArchivo.getName());
            }
            else
            {
                System.out.println("El archivo ya existe...");
            }

            //Escritura del archivo
            FileWriter myWriter = new FileWriter("estacionamiento.txt");

            myWriter.write("             ##### ------ SISTEMA DE CONTROL DE ESTACIONAMIENTO ----- #####\n\n");
            for (String [] fila : estacionamiento)   //ForEach: Para que me imprima cada posicion del arreglo registro[]
            {
                for (String valor : fila) //El segundo for-each recorre la fila actual para obtener los valores
                {
                   myWriter.write(valor); //Escribe el valor
                }   
                myWriter.write("\n");; //Pasar renglon
            }
            myWriter.close(); // Cierra el archivo después de escribir.
            System.out.println("\nSe sobrescribio el archivo correctamente.");
        }
        catch (IOException e)
        {
            System.out.println("Ocurrio un error!"); 
            e.printStackTrace(); // Muestra información detallada del error.
        }
    }
}

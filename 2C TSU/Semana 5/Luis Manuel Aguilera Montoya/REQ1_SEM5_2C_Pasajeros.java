/* Luis Manuel Aguilera Montoya
El sistema debe solicitar:
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
Total de pasajeros registrados. */

import java.util.Scanner;
public class REQ1_SEM5_2C_Pasajeros
{
    public static void main(String[] args)
    {
        //Declarar variables
        Scanner entrada = new Scanner(System.in);
        int n_p = 0, n_d1 = 0, n_d2 = 0;
        String d1 = "CDMX", d2 = "Local";

        System.out.println("----- SISTEMA DE REGISTRO DE PASAJEROS -----");
        System.out.println("Ingrese el número de pasajeros a registrar: ");
        n_p = entrada.nextInt();
        entrada.nextLine();             //(Eliminar bufer)

        //Declarar arreglos
        String nombres[] = new String[n_p];
        String destinos[] = new String[n_p];
        String registro[] = new String[n_p]; //Un arreglo para que guarde todos los datos de los pasajeros


        for (int i = 0; i < nombres.length;) //Usar el tamaño de cualquier arreglo, ya que tienen el mismo tamaño. Ademas elimine el i++ para que no me aumente automaticamente
        {
            
            //While: Usado para validar si el dato del nombre es correcto
            while (true)    //Le puse true para que siempre se repita, igual cuando el usuario ingrese un nombre valido el break rompera el ciclo
            {
                System.out.println("\n" + (i+1) + ". Ingrese el nombre:"); 
                nombres[i] = entrada.nextLine();                            //Ingresar valores en el arreglo nombres

                if (nombres[i].equals(""))
                {
                    System.out.println("ERROR. Ingrese el nombre nuevamente...");
                }
                else
                {
                    break;
                }
            }

            //DoWhile: Para que siempre este correcto el destino
            do
            {
                System.out.println("Ingrese su destino (CDMX o Local):");
                destinos[i] = entrada.nextLine();

                if(destinos[i].equals(d1) || destinos[i].equals(d2))
                    break;
                else
                    System.out.println("Destino inválido. Intente de nuevo...");
                    
            } while (true); //Para que se repita almenos una vez e infinitamente, igual cuando el dato sea correcto el break rompera el ciclo

            i++;            //Aumento de i
        }

        //For: Usado para contar los viajes a cada destino y crear los valores del arreglo registro
        for (int i = 0; i < destinos.length; i++)
        {
            if (destinos[i].equals(d1))
            {
                n_d1++;
                registro[i] = nombres[i] + " - " + destinos[i] + " - " + "'Viaje largo'";
            }
            if (destinos[i].equals(d2))
            {
                n_d2++;
                registro[i] = nombres[i] + " - " + destinos[i] + " - " + "'Viaje corto'";
            }
        }

        System.out.println("\nREGISTRO DE PASAJEROS:");

        //FOR: Para mostrar todo el registro de pasajeros, incluyendo su nombre, destino y tipo de viaje
        for (String r : registro)
        {
            System.out.println(r);
        }

        //If: Para identificar que destino fue el más visitado
        System.out.println("\nTotal de pasajeros registrados: " + n_p);
        if (n_d1 > n_d2) System.out.println("El destino con más pasajeros fue 'CDMX'"); 
        if (n_d2 > n_d1) System.out.println("El destino con más pasajeros fue 'Local'"); 
        if (n_d1 == n_d2) System.out.println("Ambos destinos tuvieron los mismos pasajeros"); 
    }
}

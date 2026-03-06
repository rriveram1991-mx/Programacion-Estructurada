/* Luis Manuel Aguilera Montoya
El sistema debe solicitar:
Cuántos pacientes se registrarán.
Crear dos arrays:
String[] nombres
int[] edades
Captura de datos:
Usar un for para capturar nombre y edad.
Validar con while que la edad no sea negativa ni mayor a 120.
Si la edad es inválida, pedirla nuevamente usando if.
Análisis del sistema:
Usar for-each para mostrar todos los pacientes registrados.
Contar:
Cuántos son menores de edad (<18)
Cuántos son adultos (18–59)
Cuántos son adultos mayores (60 o más)
Condiciones:
Si un paciente es mayor o igual a 60 → mostrar "Paciente prioritario".
Al final mostrar:
Total de pacientes prioritarios. */


import java.util.Scanner;
public class REQ1_SEM5_2C_Pacientes
{
    public static void main(String[] args)
    {
        //Declarar variables
        Scanner entrada = new Scanner(System.in);
        int n_p = 0, c_menor = 0, c_adultos = 0, c_mayores = 0;

        System.out.println("----- SISTEMA DE REGISTRO DE PACIENTES -----");
        System.out.println("Ingrese el número de pacientes a registrar: ");
        n_p = entrada.nextInt();

        //Declarar arreglos
        String nombres[] = new String[n_p]; //n_p es el tamaño del arreglo, donde anteriormente el usuario lo ingreso
        int edades[] = new int[n_p];

        //For: Usado para agregar los valores a los arreglos edad y nombre
        for (int i = 0; i < edades.length;) //Usar el tamaño de cualquier arreglo, ya que tienen el mismo tamaño. Ademas elimine el i++ para que no me aumente automaticamente
        {
            int ed;                         //Creacion de una variable local que me sirve para condicionar el while
            ed = -1;                        //Se iguala a -1 para que cada vez que reinicie el ciclo tome un valor que me permita entrar en el while
            entrada.nextLine();             //(Eliminar bufer)

            System.out.println("\n" + (i+1) + ". Ingrese el nombre:"); 
            nombres[i] = entrada.nextLine();                            //Ingresar valores en el arreglo nombres

            //While: Usado para validar si el dato de la edad es correcto
            while (ed < 0 || ed > 120)                                  
            {
                System.out.println("Ingrese la edad:");
                ed = entrada.nextInt();                                 //Ingresar posible valor del arreglo edades
                edades[i] = ed;                                         //El valor que tomara el arreglo en la posición i será el mismo que el valor de "ed"
                if (ed >= 0 && ed < 120)                                //Si el valor de la edad es válido aumenta en 1 la "i" y rompe el ciclo
                    {
                        i++;
                        break;
                    }                                                   //Si el valor de la edad es inválido, no aumentará la "i" y se repetira el bucle while hasta ingresar una edad válida
                System.out.println("Edad inválida. Intente de nuevo... ");
            }
        }

        //For: Usado para contar el tipo de panciente y agregar el tipo de paciente al arreglo nombres
        for (int i = 0; i < edades.length; i++)
        {
            //Else-If: Usado para que el programa realice cierta cosa segun el rango de edad de cada valor del arreglo edades
            if (edades[i] < 18)
            {
                nombres[i] += " - Menor de edad" ; //Al valor del arreglo nombre se le agrega que tipo de paciente es
                c_menor++;
            }
            else if (edades[i] >= 18 && edades[i] <= 59)
            {
                nombres[i] += " - Adulto" ;
                c_adultos++;
            }
            else
            {
                nombres[i] += " - Adulto mayor | PACIENTE PRIORITARIO" ;
                c_mayores++;
            }
        }
        
        System.out.println("\nREGISTRO DE PACIENTES:");

        //ForEach: Usado para mostrar el registro de todos los pacientes
        for (String n : nombres)
        {
            System.out.println(n);    
        }

        System.out.println("\nTotal de pacientes menores de edad: " + c_menor);
        System.out.println("Total de pacientes adultos: " + c_adultos);
        System.out.println("Total de pacientes adultos mayores o prioritarios: " + c_mayores);
    }
}

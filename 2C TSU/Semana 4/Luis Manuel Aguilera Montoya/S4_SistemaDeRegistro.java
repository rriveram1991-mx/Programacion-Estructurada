/* Luis Manuel Aguilera Montoya
Desarrollar un sistema que:

Defina un usuario y contraseña preestablecidos.
Permita máximo 3 intentos usando while. Valide credenciales con if.
Si el acceso es correcto:
Mostrar menú con opciones (usar for para simular operaciones).
Si falla 3 veces:
Mostrar mensaje de cuenta bloqueada. Contar número de intentos fallidos */

import java.util.Scanner;
public class S4_SistemaDeRegistro
{
    public static void main(String[] args)
    {
        //Declarar e inicializar variables
        Scanner entrada = new Scanner(System.in);
        String user, password, userCorrect = "admin", passwordCorrect = "1234";
        int i = 1;

        while (i <= 3)  //Ciclo while, 3 oportunidades
        {
            System.out.println("Ingrese el usuario: ");
            user = entrada.nextLine();
            System.out.println("Ingrese la contraseña: ");
            password = entrada.nextLine();

            if (user.equals(userCorrect) && password.equals(passwordCorrect))   //If si los datos son correctos ejecuta un menu simulado
            {
                for (int j = 0; j < 3; j++) //Menu de simulación
                {
                System.out.println("\n--- Menu de opciones ---");
                System.out.println("1. Consultar saldo");
                System.out.println("2. Depositar");
                System.out.println("3. Retirar");
                System.out.println("4. Salir");
                }
                break;                  //Termina el ciclo while
            }

            System.out.println("Datos incorrectos! (Intentos fallidos: " + i + ")");  //Si es incorrecto aparace esto
            i++;
        }
        if (i > 3)                                  
            System.out.println("\n¡CUENTA BLOQUEDA!");
    }
}

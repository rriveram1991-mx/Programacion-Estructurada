import java.util.Scanner;
public class Acceso {
       public static void main(String[] args) 
    {
        Scanner leer = new Scanner(System.in);
        String usaario="Admin" , contraseña="1234" , user , contraseñaingresada;
        int intentos=0;
        for(int i=1;i<=3;i++ )
            {
            System.out.println("Teclea el nobre del usuario");
            user=leer.nextLine();
            if(usaario.equals(user))
            {
                System.out.println("Usuario Correcto");
                System.out.println("Ingresa la contraseña");
                contraseñaingresada=leer.nextLine();
                if(contraseña.equals(contraseñaingresada))
                {
                    System.out.println("Bienvenido accediste a la cuenta de Administrador");
                    i=3;
                }
                else{
                    System.out.println("contraseña incorrecta");
                    intentos++;
                }
            }
            else{
                System.out.println("usuario incorrecto");
                intentos++;
            }
        }
        System.out.println("Intentos Fallidos "+intentos);
        leer.close();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registroacceso;

import java.util.Scanner;

/**
 *
 * @author UTT
 */
public class RegistroAcceso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// Se crea un objeto Scanner para poder leer datos ingresados por el usuario desde el teclado
        // Se muestra en pantalla el título del sistema
        System.out.println("Sistema de Registro y Acceso con Intentos Limitados");
        // Se define el usuario correcto 
        String usuarioValido = "UTT";
        // Se define la contraseña correcta
        String contraseñaValido = "teclaguna";
        // Se declara e inicializa el contador de intentos fallidos en 0
        int intentos = 0;
        // Variable booleana que indica si el acceso fue concedido o no (inicia en falso)
        boolean accesoConcedido = false;
        /* Ciclo while que se ejecuta mientras:
        1. Los intentos sean menores a 3
        2. El acceso aún no haya sido concedido
        */
        while (intentos < 3 && !accesoConcedido){
            // Se muestra mensaje de inicio de sesión
            System.out.println("Sistema de Acceso");
            // Se solicita al usuario que ingrese su nombre de usuario
            System.out.println("Ingreso de usuario: ");
            String usuario = sc.nextLine();

            // Se solicita la contraseña
            System.out.println("Ingrese la contraseña:");
            String contraseña = sc.nextLine();
             // Se comparan las credenciales ingresadas con las credenciales válidas
             // .equals() se usa para comparar el contenido de los Strings
            if (usuario.equals(usuarioValido) && contraseña.equals(contraseñaValido)){
                // Si ambas coinciden, se cambia la variable a true para indicar acceso correcto
                accesoConcedido = true;

                // Se muestra mensaje de bienvenida
                System.out.println("Bienvenido");
            }
            else{
                // Si las credenciales son incorrectas, se incrementa el contador de intentos
                intentos++;
                // Se informa al usuario que las credenciales son incorrectas
                System.out.println("Credenciales incorrectos");
                        // Se muestra el numero de intento actual de un máximo de 3
                System.out.println("Intento "+ intentos+" de 3");
            }
            
            
        }
        // Después de salir del while se evalua si el acceso fue concedido
        if(accesoConcedido){
            // Si el usuario inició sesión correctamente, se muestra el menú
            System.out.println("Menu con opciones////");
             // Ciclo for que simula operaciones con respecto a intentos realizados
             // Se ejecuta desde 1 hasta el número de intentos realizados
            for (int i = 1; i<= intentos; i++){ //Se usa el for para comparar las operaciones realizadas con los intentos de inicio de sesion para establecer cuantos procesos se realizaron
             // Muestra el número de operación simulada
                System.out.println("Operacion numero: "+i+" realizada");
            }
                // Se indica que la sesion ha terminado
            System.out.println("Sesion finalizada");
           
        }
        else {  // Si nunca se concedió el acceso (3 intentos fallidos
            System.out.println("Cuenta bloqueda!!!!! Por demasiados intentos");
                // Se muestra mensaje de advertencia
            System.out.println("Contacte con el encargado del departamento de Sistemas");
        }
        // Finalmente se muestra el total de intentos fallidos realizados
        System.out.println("Total de intentos fallados: "+ intentos);
       
        
        
        
    }
    
}

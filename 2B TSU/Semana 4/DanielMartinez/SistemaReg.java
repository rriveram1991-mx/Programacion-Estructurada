import java.util.Scanner;
public class SistemaReg {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        String usuario ;
        String passwd ;
        int intentos=0;
         

       System.out.println("Bienvenido al porgrama ");     
        
while (intentos <=3) {
    System.out.println("Ingrese su usario ");
    usuario = scan.nextLine();
    System.out.println("Ingrese su contraseña ");
    passwd=scan.nextLine();

    if (passwd.equals("dvd2007") && usuario.equals("polar")) {
        System.out.println("Bienvenido que desea hacer ");
        System.out.println("1- Comer  2-Beber  3-Jugar ");
        break;
    } else {
        intentos++;
        System.out.println("Credenciales incorrectas. Intento: " + intentos);
    }
    if (intentos>3){
        System.out.println("Cuenta bloqueada");
        return;
    }
}
scan.close();
    }
}
    

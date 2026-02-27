
package registroyaccesosandra;

import java.util.Scanner;  //IMPORTAR

public class REGISTROyACCESOsandra {
//SANDRA DMZ
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);  //IMPORTAR PARA PODER LEER.

        //DEFINIR VARIABLES.
        String Usu= "Sandra"; 
        String Contr= "1234";
        int IntF= 0;
        int IntM= 3;

        while (IntF < IntM) {   //REPETIR , HASTA QUE EL USUARIO DESSE SALIR
            System.out.println("INGRESE USUARIO:");
            String usu = leer.nextLine();
            System.out.println("INGRESE CONTRASEÑA:");
            String contr = leer.nextLine();

            if (usu.equals(Usu) && contr.equals(Contr)) {
                System.out.println("ACCESO CORRECTO");

                
                for (int i = 0; i < 3; i++) {
                    System.out.println("--- MENU OPCIONES ---");  //MOSTRAR EL MENU 
                    System.out.println("1- CAMBIAR CONTRASEÑA");
                    System.out.println("2- CAMBIAR USUARIO");
                    System.out.println("3- SALIR");
                    System.out.print("SELECCIONE UNA OPCION: ");
                    String opc = leer.nextLine();

                    if (opc.equals("1")) {
                        System.out.print("INGRESE NUEVA CONTRASEÑA: ");
                        Contr= leer.nextLine();
                        System.out.println("CONTRASEÑA CAMBIADA");
                    } else if (opc.equals("2")) {
                        System.out.print("INGRESE NUEVO USUARIO: ");
                        Usu= leer.nextLine();
                        System.out.println("USUARIO CAMBIADO");
                    } else if (opc.equals("3")) {
                        System.out.println("SALIENDO DEL SISTEMA...");
                        break; 
                    } else {
                        System.out.println("OPCION NO VALIDA");
                    }
                }
                break; 
            } else {
                IntF++;
                System.out.println("CREDENCIALES INCORRECTAS. Intento " + IntF);
            }
        }

        if (IntF == IntM) {
            System.out.println("CUENTA BLOQUEADA. TOTAL INTENTOS FALLIDOS: " + IntF);
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject27;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Mavenproject27 {

    public static void main(String[] args) {
        //Sistema de Registro y Acceso con Intentos Limitados
        Scanner leer = new Scanner(System.in);
        String user = "admin";
        String pass = "1234";
        int intentos = 0;
        while (intentos < 3) {
            System.out.print("Usuario: ");
            String userIngresado = leer.next(); 
            System.out.print("Password: ");
            String passIngresada = leer.next(); 

            if (userIngresado.equals(user) && passIngresada.equals(pass)) {
                System.out.println("ACCESO CORRECTO");
                System.out.println("1) Abrir documentos | 2) Editar perfil | 3) Cerrar sesion");
                System.out.print("Elige una opcion: ");
                int opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Documentos abiertos.");
                        break; 
                    case 2:
                        System.out.println("Editando perfil.");
                        break; 
                    case 3:
                        System.out.println("Cerrando sesion.");
                        break; 
                    default:
                        System.out.println("Opcion no valida.");
                        break;
                }
                return; 
            } else {
                intentos++;
                System.out.println("Datos incorrectos.");
            }
        } 
        System.out.println("CUENTA BLOQUEADA. Intentos fallidos: " + intentos);
        leer.close();
    }
}

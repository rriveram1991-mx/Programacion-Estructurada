/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package videojuego;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Videojuego {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Leer datos del usuario

        String juego; // Nombre del juego
        String consola; // Consola
        int anio; // Año
        double calificacion; // Calificación

        // VALIDACION DEL NOMBRE DEL JUEGO
        while(true){
            System.out.print("Nombre del videojuego: ");
            juego = sc.nextLine();
            if(juego.length() > 1){ // Debe tener más de 1 caracter
                break;
            }else{
                System.out.println("Nombre demasiado corto.");
            }
        }

        // VALIDACION DE CONSOLA
        while(true){
            System.out.print("Consola: ");
            consola = sc.nextLine();
            if(consola.matches("[a-zA-Z0-9 ]+")){ // Letras y números
                break;
            }else{
                System.out.println("Dato invalido.");
            }
        }

        // VALIDACION DE AÑO
        while(true){
            System.out.print("Año de lanzamiento: ");
            if(sc.hasNextInt()){
                anio = sc.nextInt();
                if(anio > 1970 && anio < 2100){ // Rango lógico
                    break;
                }else{
                    System.out.println("Año fuera de rango.");
                }
            }else{
                System.out.println("Debe ser numero entero.");
                sc.next();
            }
        }

        // VALIDACION DE CALIFICACION
        while(true){
            System.out.print("Calificacion (0-10): ");
            if(sc.hasNextDouble()){
                calificacion = sc.nextDouble();
                if(calificacion >= 0 && calificacion <= 10){
                    break;
                }else{
                    System.out.println("Debe estar entre 0 y 10.");
                }
            }else{
                System.out.println("Debe ser numero decimal.");
                sc.next();
            }
        }

        try{

            FileWriter archivo = new FileWriter("videojuego.txt");

            archivo.write("Juego: " + juego + "\n");
            archivo.write("Consola: " + consola + "\n");
            archivo.write("Año: " + anio + "\n");
            archivo.write("Calificacion: " + calificacion + "\n");

            archivo.close();

            System.out.println("Archivo guardado.");

        }catch(IOException e){
            System.out.println("Error al escribir archivo.");
        }

    }
}

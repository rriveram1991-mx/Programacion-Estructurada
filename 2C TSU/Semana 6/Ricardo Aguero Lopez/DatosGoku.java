/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datosgoku;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author aguer
 */
public class DatosGoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {

            File archivo = new File("DatosGoku.txt");

            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe");
            }

            FileWriter escribir = new FileWriter("DatosGoku.txt");

            escribir.write("Personaje: Goku\n");
            escribir.write("Serie: Dragon Ball\n");
            escribir.write("Raza: Saiyajin\n");
            escribir.write("Tecnica favorita: Kamehameha\n");
            escribir.write("Transformacion: Super Saiyajin\n");
            escribir.write("Mejor amigo: Krillin\n");

            escribir.close();

            System.out.println("Datos escritos correctamente");

        } catch (IOException e) {

            System.out.println("Ocurrio un error");
            e.printStackTrace();

        }

    }
    
}

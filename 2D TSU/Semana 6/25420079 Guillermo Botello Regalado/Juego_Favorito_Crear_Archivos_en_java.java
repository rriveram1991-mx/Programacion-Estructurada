/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad2;

/**
 *
 * @author Guillermo
 */
    import java.io.FileWriter;
import java.io.IOException;

public class Juego_Favorito_Crear_Archivos_en_java {

    public static void main(String[] args) {

        try {

            FileWriter archivo = new FileWriter("videojuego.txt");

            archivo.write("Juego favorito: Valorant\n");
            archivo.write("Genero: Shooter tactico\n");
            archivo.write("Desarrollador: Riot Games\n");
            archivo.write("Año de lanzamiento: 2020\n");
            archivo.write("Plataforma: PC\n");

            archivo.close();

            System.out.println("Archivo creado correctamente.");

        } catch (IOException e) {

            System.out.println("Ocurrio un error al crear el archivo.");

        }

    }
}

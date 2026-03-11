/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req1.sem6.pkg2d.ezco;

import java.io.File;//permite crear y manejar aerchivos
import java.io.FileWriter;//permite escribir texto  dentro de un archivo
import java.io.IOException;//maneja errores relacionados con archivos

public class REQ1SEM62DEZCO {

    public static void main(String[] args) {

        try {//se usa para intentar ejecutar codigo que podria generar un error
            File archivo = new File("filename.txt");
      //creamos un objeto llamado archivo que representa el archivo llamado
        //filename.txt
        
            if (archivo.createNewFile()) {//intenta crear el archivo,
                //si se creo devuelve true, y false si el archivo ya existe
                System.out.println("File created: " + archivo.getName());
            } else {
                System.out.println("File already exists");
            }
            FileWriter myWriter = new FileWriter("filename.txt");//se crea un
               //objeto llamdo FileWriter para poder escribir dentro de un archivo
            myWriter.write("Nombre alumno: Correa Ortíz Evelyn Zoé");
            myWriter.write("Edad: 19 años");
            myWriter.write("Especialidad: Desarrollo Software Multiplataforma");
            myWriter.write("Escuela: Universidad Tecnologica de Torreón (UTT)");
            myWriter.write("Lenguaje Favorito: No tengo");

            myWriter.close();//se cierra el archivo, es importando cerrarlo
            //para poder guardar correctamente los cambios
            System.out.println("Successfully wrote to the file");

        } catch (IOException e) {//el catch captura cualquier error relqacionado
                                  //con archivos
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
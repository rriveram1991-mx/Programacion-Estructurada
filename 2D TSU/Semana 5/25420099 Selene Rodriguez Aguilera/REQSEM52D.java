/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package req.sem5.pkg2d;

/**
 *
 * @author crist
 */
public class REQSEM52D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Aqui creo el aray de tipo String que por supuesto guarda variables de palabras ya que es "string"
         String[] palabras = {"sol", "computadora", "mesa", "programacion", "luz", "teclado"};

        int contador = 0; //Este es el contador que nos indica o contara cuantas palabras tendran mas de 5 letras
   // Aqui nos indica que en cada repeticion la variable "palabra" tomara posicion del array.
        for (String palabra : palabras) {
          //"length" devuelve la cantidad de letras que tiene la palabra osea que si la palabra tiene mas de cinco letras
            if (palabra.length() > 5) {
                contador++; //Esto nos ayuda a que el contador aumente en 1.
                System.out.println("Palabra larga: " + palabra);
            }   

        }

        System.out.println("Cantidad de palabras largas: " + contador);
    }
}
    

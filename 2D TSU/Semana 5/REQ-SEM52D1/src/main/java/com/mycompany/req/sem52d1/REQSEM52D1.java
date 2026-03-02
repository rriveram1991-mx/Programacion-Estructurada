/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.req.sem52d1;

/**
 *
 * @author Zoé
 */
public class REQSEM52D1 {

    public static void main(String[] args) {
        String[] palabras = new String[5];
        palabras[0] = "sol";
        palabras[1] = "estrella";
        palabras[2] = "luna";
        palabras[3] = "cielo";
        palabras[4] = "mar";
        int contador = 0;
        for (String palabra : palabras) {
            if (palabra.length() > 4) {
                contador = contador + 1;
            }
        }
        System.out.println("Cantidad de palabras con más de 4 letras: " +contador);
    }
 }


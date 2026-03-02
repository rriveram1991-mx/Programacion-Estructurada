/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.req.sem5.d;

/**
 *
 * @author Zoé
 */
public class REQSEM52D {

    public static void main(String[] args) {
      double[] calificaciones = new double[4];
      calificaciones[0] = 8.5;
      calificaciones[1] = 9.0;
      calificaciones[2] = 7.5;
      calificaciones[3] = 10.0;
       double suma=0;
       for (double calificacion : calificaciones){
           suma=suma+calificacion;
       }
        double promedio = suma / calificaciones.length;

        System.out.println("el promedio de las calificaciones es: "+promedio);
    }
}

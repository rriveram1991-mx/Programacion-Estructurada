/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arrays.pkgfor.each.pkg1.req.sem5.pkg2b;

/**
 *
 * @author jasun
 */
public class ARRAYSFOREACH1REQSEM52B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ARRAY para guardar los nombres de los compañeros
        String[] alumnos = {"Emiliano", "Joshue", "Erick", "Sofia", "Ismael", "Joaquin", "Adrian", "Alexandra", "Diego", "Evans", "Tadeo", "Roberto", "Zoe", "Carlos", "Brayan", "Irving", "Gerardo", "Yahir", "Daniel", "Poncho", "Dulce", "Alexander"};
        
        //Se realiza e imprimi la lista de alumnos, con los datos guardados en el array
        System.out.println("Lista de alumnos:");
        for (String alumno : alumnos) {
            System.out.println(alumno);
        }
    }
    
}

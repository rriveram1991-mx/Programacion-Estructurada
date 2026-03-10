/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arays;

/**
 *
 * @author ASUS
 */
public class ARAYs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Definimos una matriz de tipo String para almacenar los datos solicitados
        // Cada fila representa a un alumno y cada columna un atributo diferente
        String[][] alumnos = {
            { "Andrés", "24", "Desarrollo de Software Multiplataforma", "UTT", "Java" },
            { "Juan", "20", "Redes", "UTT", "Python" } // Agregamos un registro aleatorio adicional
        };

        // --- Acceso y visualización de los datos del primer alumno ---
        
        System.out.println("--- DATOS DEL ALUMNO 1 ---");
        // matriz[0][0] accede a la primera fila, primera columna (Nombre)
        System.out.println("Nombre: " + alumnos[0][0]); 
        
        // matriz[0][1] accede a la primera fila, segunda columna (Edad)
        System.out.println("Edad: " + alumnos[0][1]);
        
        // matriz[0][2] accede a la primera fila, tercera columna (Especialidad)
        System.out.println("Especialidad: " + alumnos[0][2]);
        // matriz[0][3] accede a la primera fila, cuarta columna (Escuela)
        System.out.println("Escuela: " + alumnos[0][3]);
        
        // matriz[0][4] accede a la primera fila, quinta columna (Lenguaje favorito)
        System.out.println("Lenguaje favorito: " + alumnos[0][4]);

        System.out.println("\n--- DATOS DEL REGISTRO ALEATORIO ---");
        // Cambiamos el índice de la fila a [1] para ver el segundo registro
        System.out.println("Nombre: " + alumnos[1][0]);
        System.out.println("Lenguaje favorito: " + alumnos[1][4]);
        
        
    }
}
    
    


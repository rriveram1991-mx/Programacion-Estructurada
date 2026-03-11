/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datosalumno;
import java.io.FileWriter; // Permite escribir archivos
import java.io.IOException; // Permite manejar errores de archivo
import java.util.Scanner; // Permite leer datos del usuario

public class DatosAlumno {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Crear objeto Scanner para leer teclado

        String nombre; // Variable para guardar el nombre
        int edad; // Variable para guardar la edad
        String especialidad; // Variable para especialidad
        String escuela; // Variable para escuela
        String lenguaje; // Variable para lenguaje favorito

        // ===== VALIDACION DEL NOMBRE =====
        while(true){ // Ciclo para repetir hasta que el dato sea correcto
            System.out.print("Nombre del alumno: ");
            if(sc.hasNextLine()){ // Verifica que se pueda leer texto
                nombre = sc.nextLine(); // Guardar el texto
                if(nombre.matches("[a-zA-Z ]+")){ // Verifica que solo tenga letras
                    break; // Sale del ciclo si es válido
                }else{
                    System.out.println("Error: el nombre solo debe tener letras.");
                }
            }
        }

        // ===== VALIDACION DE EDAD =====
        while(true){
            System.out.print("Edad (numero entero): ");
            if(sc.hasNextInt()){ // Verifica que el dato sea entero
                edad = sc.nextInt(); // Guarda el entero
                sc.nextLine(); // Limpia el buffer
                if(edad > 0){ // Verifica que sea positivo
                    break;
                }else{
                    System.out.println("La edad debe ser mayor que 0.");
                }
            }else{
                System.out.println("Error: debes ingresar un numero entero.");
                sc.next(); // Descarta el valor incorrecto
            }
        }

        // ===== VALIDACION DE ESPECIALIDAD =====
        while(true){
            System.out.print("Especialidad: ");
            especialidad = sc.nextLine();
            if(especialidad.matches("[a-zA-Z ]+")){ // Solo letras
                break;
            }else{
                System.out.println("Error: solo letras.");
            }
        }

        // ===== VALIDACION DE ESCUELA =====
        while(true){
            System.out.print("Escuela: ");
            escuela = sc.nextLine();
            if(escuela.length() > 2){ // Verifica que tenga al menos 3 caracteres
                break;
            }else{
                System.out.println("Nombre de escuela demasiado corto.");
            }
        }

        // ===== VALIDACION DE LENGUAJE =====
        while(true){
            System.out.print("Lenguaje favorito: ");
            lenguaje = sc.nextLine();
            if(lenguaje.matches("[a-zA-Z+# ]+")){ // Permite letras y símbolos comunes
                break;
            }else{
                System.out.println("Error en el nombre del lenguaje.");
            }
        }

        try{

            FileWriter archivo = new FileWriter("datos_alumno.txt"); // Crear archivo

            archivo.write("Nombre: " + nombre + "\n"); // Escribir nombre
            archivo.write("Edad: " + edad + "\n"); // Escribir edad
            archivo.write("Especialidad: " + especialidad + "\n"); // Escribir especialidad
            archivo.write("Escuela: " + escuela + "\n"); // Escribir escuela
            archivo.write("Lenguaje favorito: " + lenguaje + "\n"); // Escribir lenguaje

            archivo.close(); // Cerrar archivo

            System.out.println("Archivo guardado correctamente.");

        }catch(IOException e){ // Si ocurre un error
            System.out.println("Error al escribir el archivo.");
        }
    }
}
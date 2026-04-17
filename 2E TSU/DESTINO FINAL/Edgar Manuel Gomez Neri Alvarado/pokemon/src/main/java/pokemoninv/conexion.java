package pokemoninv;

import java.util.Scanner; // Linea creada para el Uso del Scanner en "Lectura de datos"
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;



public class conexion {


    public static Connection getConnection() {
        Connection conexion = null;
        String BaseDatos = "pokemon";
        String url = "jdbc:mysql://localhost:3306/" + BaseDatos;
        String usuario = "root";
        String password = "12345678"; // Asegúrate que tu pass en Workbench sea "12345678"


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            System.out.println("Tabla 1" + e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
        Scanner output = new Scanner(System.in);

        // Usamos un solo bloque try para manejar la conexión
        try (Connection conx = pokemoninv.conexion.getConnection()) {

            if (conx == null) {
                System.out.println("Fallo en la conexión.");
                return;
            }
            System.out.println("¡Éxito! Conexión establecida.");

            boolean close = false;
            while (!close) { // !close en lugar de (close = false)
                System.out.println("\n--- MENU POKEMON ---");
                System.out.println("1.- Añadir Pokemon");
                System.out.println("2.- Añadir Objeto");
                System.out.println("3.- Eliminar Pokemon (Por ID)");
                System.out.println("4.- Lista Pokemon y Objetos");
                System.out.println("5.- Salir");
                System.out.print("Selecciona una acción: ");
                int accion = output.nextInt();

                switch (accion) {
                    case 1: // Añadir pokemon ---------------------------------------
                        System.out.print("Nombre del Pokemon: ");
                        String pNombre = output.next();
                        System.out.print("Tipo: ");
                        String pTipo = output.next();

                        String sqlP = "INSERT INTO pokemons (nombre, tipo) VALUES (?, ?)"; // Añade los valores a la tabla SQL
                        try (PreparedStatement psP = conx.prepareStatement(sqlP)) {
                            psP.setString(1, pNombre); // valores a añadir
                            psP.setString(2, pTipo); // valores a añadir
                            psP.executeUpdate(); // actualiza la tabla SQL
                            System.out.println("¡Pokemon registrado!");
                        }
                        break;

                    case 2: // Agregar objeto (BAG) ----------------------------------
                        System.out.print("Nombre del item: ");
                        String nombreItem = output.next();
                        System.out.print("Cantidad: ");
                        int cantidad = output.nextInt();

                        String sqlB = "INSERT INTO bag (item, cant) VALUES (?, ?)"; // Añade los valores a la tabla SQL
                        try (PreparedStatement psB = conx.prepareStatement(sqlB)) {
                            psB.setString(1, nombreItem); // valores a añadir
                            psB.setInt(2, cantidad); // valores a añadir
                            psB.executeUpdate(); // actualiza la tabla SQL
                            System.out.println("¡Item guardado en la mochila!");
                        }
                        break;

                    case 3: // Eliminar pokemons por ID -------------------------------------
                        System.out.print("ID del Pokemon a eliminar: ");
                        int idEliminar = output.nextInt();
                        String sqlDel = "DELETE FROM pokemons WHERE id = ?"; // Quita los valores a la tabla SQL
                        try (PreparedStatement psDel = conx.prepareStatement(sqlDel)) {
                            psDel.setInt(1, idEliminar); // valor a borrar
                            int filas = psDel.executeUpdate(); // actualiza la tabla SQL
                            System.out.println(filas > 0 ? "Eliminado con éxito." : "ID no encontrado.");
                        }
                        break;

                    case 4: // Lista de objetos y pokemon ------------------------------------------
                        // Consultamos en el momento para tener datos actualizados
                        try (Statement st = conx.createStatement()) {

                            System.out.println("\n--- Pokemons ---");
                            ResultSet rsP = st.executeQuery("SELECT id, nombre, tipo FROM pokemons"); // revisa la tabla Pokemons
                            while (rsP.next()) {
                                System.out.println("ID: " + rsP.getInt("id") + " | " + rsP.getString("nombre") + " [" + rsP.getString("tipo") + "]");
                            }

                            System.out.println("\n--- Mochila ---");
                            ResultSet rsB = st.executeQuery("SELECT id, item, cant FROM bag"); // revisa la tabla bag
                            while (rsB.next()) {
                                System.out.println("ID: " + rsB.getInt("id") + " | Item: " + rsB.getString("item") + " (x" + rsB.getInt("cant") + ")");
                            }
                        }
                        break;

                    case 5:
                        close = true; // Termina el bucle
                        break;

                    default:
                        System.out.println("Opción no válida."); // Opciones diferentes a las disponibles
                }
            }
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }
    }
}
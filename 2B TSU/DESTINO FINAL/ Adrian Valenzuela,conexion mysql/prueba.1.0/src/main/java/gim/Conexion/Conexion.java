package gim.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConnection() {
        Connection cox = null;
        var baseDatos = "pokemon";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        try {
            cox = DriverManager.getConnection(url, "root", "adrianvalenzuela01");
            System.out.println("¡Conexión exitosa!");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return cox;
    }
}

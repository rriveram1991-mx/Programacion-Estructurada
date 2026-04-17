package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/cafeteriasandra";
    private static final String USER = "root";
    private static final String PASS = "Chocolate16";

    public static Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexion establecida con cafeteriasandra.");
        } catch (SQLException e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }
        return conexion;
    }
}

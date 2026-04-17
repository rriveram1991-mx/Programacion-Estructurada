package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexxxion {

    private static final String URL = "jdbc:mysql://localhost:3306/titanfall_db";
    private static final String USER = "root";
    private static final String PASSWORD = "123456789";

    public static Connection conectar() {
        Connection conexxxion = null;

        try {
            conexxxion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion exitosa a MySQL.");
        } catch (SQLException e) {
            System.out.println("Error al conectar con MySQL.");
            System.out.println("Mensaje: " + e.getMessage());
        }

        return conexxxion;
    }
}
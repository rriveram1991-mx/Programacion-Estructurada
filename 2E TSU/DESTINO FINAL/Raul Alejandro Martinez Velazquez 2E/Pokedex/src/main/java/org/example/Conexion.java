package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pokedex",
                    "root",
                    "1234"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
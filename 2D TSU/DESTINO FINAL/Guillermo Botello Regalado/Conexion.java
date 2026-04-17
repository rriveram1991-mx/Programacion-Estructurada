

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
        public static Connection conectar() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/pokedex",
                        "root",
                        "Mario23."
                );
            } catch (Exception e) {
                System.out.println("Error: " + e);
                return null;
            }
        }
    }


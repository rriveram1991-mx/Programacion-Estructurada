package pokemon.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pokedb",
                    "root",
                    "1245"
            );
        } catch (Exception e) {
            System.out.println("Error conexión: " + e.getMessage());
        }
        return con;
    }
}
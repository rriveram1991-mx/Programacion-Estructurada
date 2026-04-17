package crud_2B;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
        public static Connection getConnection() {
            Connection cnx = null;
            String url = "jdbc:mysql://127.0.0.1:3306/pokedex1";
            String usr = "root";
            String psd = "root";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                cnx = DriverManager.getConnection(url, usr, psd);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error en conexión: " + e.getMessage());
            }
            return (Connection) cnx;
        }
    }


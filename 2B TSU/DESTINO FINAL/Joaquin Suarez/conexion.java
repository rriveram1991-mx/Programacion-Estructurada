package crud_2B;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    public static Connection getConnection() {
        Connection cnx = null;
        String url = "jdbc:mysql://localhost:3306/pokedex";
        String usr = "root";
        String psd = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx = DriverManager.getConnection(url, usr, psd);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en conexión: " + e.getMessage());
        }
        return cnx;
    }
}


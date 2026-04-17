package crud_2B;


import java.sql.Connection; // La librería usa Connection con 'nn'
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion { // El nombre

    public static Connection getConnection() { // El retorno
        Connection cnx = null;
        String url = "jdbc:mysql://localhost:3306/sistema_po";
        String usr = "root";
        String psd = "jptam050101";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx = DriverManager.getConnection(url, usr, psd);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en conexión: " + e.getMessage());
        }
        return cnx;
    }
}

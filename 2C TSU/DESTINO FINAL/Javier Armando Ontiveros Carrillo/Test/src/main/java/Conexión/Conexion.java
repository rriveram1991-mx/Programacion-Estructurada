package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConnection() {
        Connection cmysql = null;
        var basemsql = "pokedex";
        var urlmysql = "jdbc:mysql://localhost:3306/" + basemsql;
        var usrmysql = "root";
        var passmysql = "12345678";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cmysql = DriverManager.getConnection(urlmysql, usrmysql, passmysql);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error al conectar con Mysql" + e.getMessage());
        }
        return cmysql;
    }

    public static void main(String[] args) {
        var cmysql = Conexion.getConnection();
        if (cmysql != null)
            System.out.println("conexion exitosa" + cmysql);
        else
            System.out.println("no se pudo conectsr con Mysql");
    }

}










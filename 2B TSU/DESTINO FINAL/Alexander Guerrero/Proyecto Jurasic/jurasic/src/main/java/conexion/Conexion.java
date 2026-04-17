package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConnection(){
        Connection cox = null;
        var bd = "jurasic";
        var url = "jdbc:mysql://localhost:3306/" + bd;
        var usr = "root";
        var psd = "1234";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cox = DriverManager.getConnection(url, usr, psd);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error al conectar con l abase de datos" + e.getMessage());
        }
        return cox;
    }

    public static void main(String[] args) {
        var cox = Conexion.getConnection();
        if (cox != null)
            System.out.println("Conexion exitosa" + cox);
        else
            System.out.println("Conexion no exitosa");
    }
}

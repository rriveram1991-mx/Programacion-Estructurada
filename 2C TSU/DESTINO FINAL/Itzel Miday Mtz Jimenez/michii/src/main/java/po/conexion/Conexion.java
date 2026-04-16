package po.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    public static Connection getConnection(){
        Connection cmysql = null;
        var basemysql = "po";
        var urlmysql = "jdbc:mysql://localhost:3306/"+basemysql;
        var usrmysql = "root";
        var passmysql = "tamal777";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cmysql = DriverManager.getConnection(urlmysql,usrmysql,passmysql);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("ERROR AL CONECTAR " + e.getMessage());
        }
        return cmysql;
    }
    public static void main (String [] args){
        Connection cmysql = Conexion.getConnection();
        if (cmysql != null){
            System.out.println("Conexion establecida");
        }
    }
}

package crud;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection getConnection(){
        Connection con=null;
        var basedatos="bob esponja";
        var url= "jdbc:mysql://localhost:3306/"+basedatos;
        var user= "root";
        var pass="zoe123";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
        }catch (SQLException|ClassNotFoundException e){
            System.out.println("Error"+e.getMessage());
        }
        return con;
    }

    public static void main(String[] args) {
        var con= Conexion.getConnection();
        if (con!=null){
            System.out.println("Conexion exitosa"+con);
        }
        else {
            System.out.println("Error al conectar");
        }
    }
}

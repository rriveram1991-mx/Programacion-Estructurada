package miraculous.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class conexion {


    public static Connection getConnection() {
        Connection con = null;
        var based = "miraculous";
        var url = "jdbc:mysql://localhost:3306/" + based;
        var user ="root";
        var pasword ="toor";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pasword);
        }catch (SQLException | ClassNotFoundException e){
            System.out.println("error al conectarse a la base de datos" + e.getMessage());}
        return con;


        }
        public static void main(String[] args){
        var con =conexion.getConnection();
        if(con !=null)
            System.out.println("Conexion exitosa" +con);
        else System.out.println("error al conectarse");}
    }


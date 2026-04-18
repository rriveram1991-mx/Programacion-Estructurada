package gimnasio.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    public static Connection getConection(){
        Connection cxn=null;
        var BaseDatos= "gym";
        var url = "jdbc:mysql://localhost:3306/" + BaseDatos;
        var mysqlusr = "root";
        var mysqlpwd = "toor";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cxn= DriverManager.getConnection(url, mysqlusr, mysqlpwd);

        }catch (ClassNotFoundException | SQLException e){

            System.out.println("Error al conectar con la base de datos "+ e.getMessage());
        }
        return cxn;

    }
    public static void main(String[] args){
        var cxn = conexion.getConection();
        if(cxn !=null)
            System.out.println("Conexion Exitosa con MySQL"+cxn);
        else
            System.out.println("Conexion no exitosa");
    }
}

package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion
{

    public static Connection getConnection()
    {
        Connection cox = null;
        var bd = "kad" ;
        var url = "jdbc:mysql://localhost:3306/" +bd ;
        var usr = "root" ;
        var psd = "Zate3256$";

        try
        {
            cox = DriverManager.getConnection( url , usr , psd ) ;
            Class.forName("com.mysql.cj.jdbc.Driver" ) ;


        }
        catch (SQLException | ClassNotFoundException e)
        {

            System.out.println ( "Error al conectar con la base de datos " + e.getMessage() ) ;

        }
        return cox ;

    }

    public static void main(String[] args)
    {

        var cox = Conexion.getConnection() ;
        if ( cox != null )
        {

            System.out.println( "Conexion exitosa" + cox ) ;

        }
        else
        {

            System.out.println( "Conexion no exitosa" ) ;

        }

    }

}

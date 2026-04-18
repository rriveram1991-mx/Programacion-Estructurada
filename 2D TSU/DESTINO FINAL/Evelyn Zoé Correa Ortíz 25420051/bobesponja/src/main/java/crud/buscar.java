package crud;
import java.sql.Connection;
import crud.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Scanner;

public class buscar {

    public static void buscarpersonajes () {
        Connection conexion = crud.Conexion.getConnection();

        try {
            Statement bsq = conexion.createStatement();

            ResultSet bsqCount = bsq.executeQuery("SELECT COUNT(*) AS total FROM personajes");
            if (bsqCount.next()) {
                int total = bsqCount.getInt("total");
                System.out.println("total personajes: " + total);
                System.out.println();
            }

            ResultSet bsqT = bsq.executeQuery("SELECT * FROM personajes");
            System.out.println("Informacion de personaje");

            while (bsqT.next()) {
                System.out.println("personaje #: " + bsqT.getInt("idpersonajes"));
                System.out.println("Nombre: " + bsqT.getString("nombre"));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        buscarpersonajes();
    }
}
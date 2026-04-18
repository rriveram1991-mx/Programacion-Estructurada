package personajes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.SQLException;
import miraculous.conexion.conexion;


public class insertar {




        public static void insertar() {

            Scanner sc = new Scanner(System.in);

            System.out.print("Nombre del perspnaje ");
            String Nombre = sc.nextLine();

            System.out.print("poder ");
            String poderes = sc.nextLine();

            System.out.print("animal ");
            String animalrepresentativo  = sc.nextLine();



            try (Connection con =conexion.getConnection()){
                String sql = "INSERT INTO personajes (nombre, poderes, animalrepresentativo) VALUES (?,?,?)";
                PreparedStatement pst=con.prepareStatement(sql);

                pst.setString(1, Nombre);
                pst.setString(2, poderes);
                pst.setString(3, animalrepresentativo);
                pst.executeUpdate();;
}
        catch (SQLException e){
            System.out.println("error al insertar personaje");
        }}
public static void main(String[] args){insertar();}}
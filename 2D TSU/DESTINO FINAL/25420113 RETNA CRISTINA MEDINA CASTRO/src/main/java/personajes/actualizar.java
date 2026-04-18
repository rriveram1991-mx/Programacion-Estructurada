package personajes;
import miraculous.conexion.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class actualizar {
    public static void actualizar() {

        Scanner sc = new Scanner(System.in);

        System.out.print("ID del peresonaje a actualizar: ");
        int id = sc.nextInt();

        System.out.print("Nuevo poder");
        String poderes = sc.nextLine();

        Connection con = conexion.getConnection();

        try {
            String sql = "UPDATE personajes SET poderes = ? WHERE idpersonajes = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, poderes);
            pst.setInt(2, id);

            int filas = pst.executeUpdate();

            if (filas > 0) {
                System.out.println("poder actualizado correctamente");
            } else {
                System.out.println("No se encontró el ID");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



package CRUD.DINO;

import conexion.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class tabladinosaurios {
    public static void registrarDino() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre del Dino: ");
        String nombre = sc.next();
        System.out.println("Ingresa el ataque: ");
        int ataque = sc.nextInt();
        System.out.println("Ingresa la vida: ");
        int vida = sc.nextInt();
        System.out.println("Ingresa el periodo: ");
        String periodo = sc.next();

        Connection cox = Conexion.getConnection();
        try{
            String sql = "INSERT INTO dinosaurios (Nombre, Ataque, Vida, Periodo) VALUES (?, ?, ?, ?)";
            PreparedStatement insert = cox.prepareStatement(sql);
            insert.setString(1, nombre);
            insert.setInt(2, ataque);
            insert.setInt(3, vida);
            insert.setString(4, periodo);
            insert.executeUpdate();
            System.out.println("Dinosaurio registrado exitosamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void actualizarDino() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del dinosaurio que quieres modificar: ");
        String nombreBuscar = sc.next();
        System.out.print("Nuevo valor de Ataque: ");
        int nuevoAtaque = sc.nextInt();
        System.out.print("Nuevo valor de Vida: ");
        int nuevaVida = sc.nextInt();
        System.out.print("Nuevo Periodo: ");
        String nuevoPeriodo = sc.next();

        Connection cox = Conexion.getConnection();
        try {
            String sql = "UPDATE dinosaurios SET Ataque = ?, Vida = ?, Periodo = ? WHERE Nombre = ?";
            PreparedStatement update = cox.prepareStatement(sql);

            update.setInt(1, nuevoAtaque);
            update.setInt(2, nuevaVida);
            update.setString(3, nuevoPeriodo);
            update.setString(4, nombreBuscar);

            int filas = update.executeUpdate();
            if (filas > 0) {
                System.out.println("¡Dinosaurio actualizado con éxito!");
            } else {
                System.out.println("No se encontró el dinosaurio: " + nombreBuscar);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

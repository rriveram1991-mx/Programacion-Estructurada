package CRUD.MOCHILA;

import conexion.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class tablamochila {
    public static void registrarArma() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre del Arma: ");
        String nombre = sc.next();
        System.out.println("Ingresa cantidad de cartuchos disponibles: ");
        int cartuchos = sc.nextInt();
        System.out.println("Ingresa tipo de arma (Distancia): ");
        String tipo = sc.next();
        System.out.println("Ingresa el daño del arma: ");
        int daño = sc.nextInt();

        Connection cox = Conexion.getConnection();
        try{
            String sql = "INSERT INTO mochila (Nombre, Cartuchos, Tipo, Daño) VALUES (?, ?, ?, ?)";
            PreparedStatement insert = cox.prepareStatement(sql);
            insert.setString(1, nombre);
            insert.setInt(2, cartuchos);
            insert.setString(3, tipo);
            insert.setInt(4, daño);
            insert.executeUpdate();
            System.out.println("Arma registrada exitosamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void actualizarMochila() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre del arma/item a modificar: ");
        String nombreBuscar = sc.next();
        System.out.print("Nueva cantidad de cartuchos: ");
        int nuevosCartuchos = sc.nextInt();
        System.out.print("Nuevo tipo de arma: ");
        String nuevoTipo = sc.next();
        System.out.print("Nuevo daño: ");
        int nuevoDano = sc.nextInt();

        Connection cox = Conexion.getConnection();
        try {
            String sql = "UPDATE mochila SET Cartuchos = ?, Tipo = ?, Daño = ? WHERE Nombre = ?";
            PreparedStatement update = cox.prepareStatement(sql);
            update.setInt(1, nuevosCartuchos);
            update.setString(2, nuevoTipo);
            update.setInt(3, nuevoDano);
            update.setString(4, nombreBuscar); // El nombre es el filtro (WHERE)

            int filas = update.executeUpdate();
            if (filas > 0) {
                System.out.println("¡Item de la mochila actualizado correctamente!");
            } else {
                System.out.println("No se encontró el item: " + nombreBuscar);
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar mochila: " + e.getMessage());
        }
    }

}


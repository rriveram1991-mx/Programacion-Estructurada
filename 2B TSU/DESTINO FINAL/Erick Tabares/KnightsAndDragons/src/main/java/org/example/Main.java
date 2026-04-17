package org.example;

import conexion.Conexion;
import java.sql.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Connection cox = Conexion.getConnection();
        if (cox == null) return;

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n--- Knights And Dragons ---");
            System.out.println("1.  Add Entity");
            System.out.println("2. Add Item");
            System.out.println("3. Show Team & Backpack");
            System.out.println("4. Update Entity");
            System.out.println("5. Update Backpack");
            System.out.println("6. Delete Entity");
            System.out.println("7. Exit");
            System.out.print("Choose: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: insertarent(cox, sc); break;
                case 2: insertarback(cox, sc); break;
                case 3: leerTodo(cox); break;
                case 4: actualizarenty(cox, sc); break;
                case 5: actualizarback(cox, sc); break;
                case 6: eliminar(cox, sc); break;
            }
        }
    }

    public static void insertarent(Connection con, Scanner sc) {
        System.out.print("Name: "); String n = sc.nextLine();
        System.out.print("Element: "); String e = sc.nextLine();
        System.out.print("HP: "); double v = sc.nextDouble();
        System.out.print("Damage: "); double d = sc.nextDouble();

        String sql = "INSERT INTO entities (Name, Element, HP, Damage ) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, n);
            ps.setString(2, e);
            ps.setDouble(3, v);
            ps.setDouble(4, d);
            ps.executeUpdate();
            System.out.println("¡Entity saved!");
        } catch (SQLException err) { System.out.println("Error: " + err.getMessage()); }
    }

    public static void insertarback(Connection con, Scanner sc) {
        System.out.print("Name: "); String n = sc.nextLine();
        System.out.print("Tipe: "); String e = sc.nextLine();
        System.out.print("Effect: "); String v = sc.nextLine();
        System.out.print("Capacity: "); int d = sc.nextInt();

        String sql = "INSERT INTO backpack (Name, Tipe, Effect, Capacity ) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, n);
            ps.setString(2, e);
            ps.setString(3, v);
            ps.setInt(4, d);
            ps.executeUpdate();
            System.out.println("¡Potion saved!");
        } catch (SQLException err) { System.out.println("Error: " + err.getMessage()); }
    }


    public static void leerTodo(Connection con) {
        try (Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM entities");
            System.out.println("\n-- Team --");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("idEntities") + " | " + rs.getString("Name"));
            }

            ResultSet rs2 = st.executeQuery("SELECT * FROM backpack");
            System.out.println("\n-- Backpack --");
            while (rs2.next()) {
                System.out.println("Potion: " + rs2.getString("IDBackPack") + " | Balls: " + rs2.getString("poke balls"));
            }
        } catch (SQLException err) { System.out.println("Error: " + err.getMessage()); }
    }





    public static void actualizarenty(Connection con, Scanner sc) {
        System.out.print("IDEntity: ");
        int id = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        System.out.print("New HP: ");
        Double nvHP = sc.nextDouble();
        sc.nextLine(); // limpiar buffer

        System.out.print("New Name: ");
        String nvName = sc.nextLine();

        System.out.print("New Damage: ");
        Double nvDamage = sc.nextDouble();
        sc.nextLine(); // limpiar buffer

        System.out.print("New Element: ");
        String nvElement = sc.nextLine();

        String sql = "UPDATE entities SET HP = ?, Name = ?, Damage = ?, Element = ? WHERE idEntities = ?";



        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, nvHP);
            ps.setString(2, nvName);
            ps.setDouble(3, nvDamage);
            ps.setString(4, nvElement);
            ps.setInt(5, id);

            ps.executeUpdate();
            System.out.println("Updated!");
        } catch (SQLException err) {
            System.out.println("Error: " + err.getMessage());
        }
    }

    public static void actualizarback(Connection con, Scanner sc) {
        System.out.print("IDItem: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("New Name: ");
        String nvName = sc.nextLine();
        sc.nextLine();

        System.out.print("New Tipe: ");
        String nvTipe = sc.nextLine();
        sc.nextLine();

        System.out.print("New Effect: ");
        String nveff = sc.nextLine();
        sc.nextLine();

        System.out.print("New Capacity: ");
        int nvCpty = sc.nextInt();


        String sql = "UPDATE backpack SET Name = ?, Tipe = ?, Effect = ?, Capacity = ? WHERE idBackPack = ?";



        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nvName);
            ps.setString(2, nvTipe);
            ps.setString(3, nveff);
            ps.setInt(4, nvCpty);
            ps.setInt(5, id);

            ps.executeUpdate();
            System.out.println("Updated!");
        } catch (SQLException err) {
            System.out.println("Error: " + err.getMessage());
        }
    }



    public static void eliminar(Connection con, Scanner sc) {
        System.out.print("ID to Delete: "); int id = sc.nextInt();
        String sql = "DELETE FROM entities WHERE identities = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("¡Deleted!");
        } catch (SQLException err) { System.out.println("Error: " + err.getMessage()); }
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.*;

/**
 *
 * @author Gilbert
 */
public class Controller {

    static DatabaseHandler conn = new DatabaseHandler();
//ini di comment dulu karena belum buat insert, update delete dsb.
    //sudah ditest semuanya lancar :)

    public static ArrayList<User> getAllCustomers() {
        ArrayList<User> users = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM customer";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setID(rs.getInt("id_cust"));
                user.setNama(rs.getString("nama"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setTelepon(rs.getString("noTelp"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (users);
    }

    //cek untuk login customer
    public static boolean CekCustomer(String email, String pass) {
        conn.connect();
        String query = "SELECT * FROM customer WHERE email='" + email + "'";
        boolean cek = false;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if(rs.getString("email").equals(email) && rs.getString("password").equals(pass)){
                    cek = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            cek = false;
        }
        return (cek);
    }
    
    //cek untuk login vendor
    public static boolean CekVendor(String email, String pass) {
        conn.connect();
        String query = "SELECT * FROM vendor WHERE email='" + email + "'";
        boolean cek = false;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if(rs.getString("email").equals(email) && rs.getString("password").equals(pass)){
                    cek = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            cek = false;
        }
        return (cek);
    }
    
    //cek untuk login customer
    public static boolean CekAdmin(String email, String pass) {
        conn.connect();
        String query = "SELECT * FROM admin WHERE email='" + email + "'";
        boolean cek = false;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if(rs.getString("email").equals(email) && rs.getString("password").equals(pass)){
                    cek = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            cek = false;
        }
        return (cek);
    }
//
//    // SELECT WHERE
//    public Customer getCustomer(String name, String email) {
//        conn.connect();
//        String query = "SELECT * FROM customers WHERE name='" + name + "'&&email='" + email + "'";
//        Customer customer = new Customer();
//        try {
//            Statement stmt = conn.con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                customer.setId(rs.getString("id"));
//                customer.setName(rs.getString("name"));
//                customer.setEmail(rs.getString("email"));
//                customer.setPassword(rs.getString("password"));
//                customer.setHp(rs.getString("hp"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return (customer);
//    }
//    
    // INSERT Customer

    public static boolean insertNewCust(User user) {
        conn.connect();
        String query = "INSERT INTO customer (nama,email,password,noTelp) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, user.getNama());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getTelepon());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // INSERT Vendor
    public static boolean insertNewVendor(User user) {
        conn.connect();
        String query = "INSERT INTO vendor (nama,email,password,noTelp) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, user.getNama());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getTelepon());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // INSERT Admin
    public static boolean insertNewAdmin(User user) {
        conn.connect();
        String query = "INSERT INTO admin (nama,email,password,noTelp) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(2, user.getNama());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getTelepon());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

//
//    // UPDATE
//    public boolean updateUser(Customer customer) {
//        conn.connect();
//        String query = "UPDATE customers SET name='" + customer.getName() + "', "
//                + "email='" + customer.getEmail() + "', "
//                + "password='" + customer.getPassword() + "' "
//                + " WHERE ID='" + customer.getId() + "'";
//        try {
//            Statement stmt = conn.con.createStatement();
//            stmt.executeUpdate(query);
//            return (true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return (false);
//        }
//    }
//
//    // DELETE
//    public boolean deleteUser(String name) {
//        conn.connect();
//
//        String query = "DELETE FROM customers WHERE Name='" + name + "'";
//        try {
//            Statement stmt = conn.con.createStatement();
//            stmt.executeUpdate(query);
//            return (true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return (false);
//        }
//    }
}

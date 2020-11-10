/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Model.enums.TipeUserEnums.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.*;

/**
 *
 * @author hilbert
 */
public class Controller {

    static DatabaseHandler conn = new DatabaseHandler();
//ini di comment dulu karena belum buat insert, update delete dsb.
    //sudah ditest semuanya lancar :)

//    // SELECT ALL from table users
//    public ArrayList<Customer> getAllCustomers() {
//        ArrayList<Customer> listCustomer = new ArrayList<>();
//        conn.connect();
//        String query = "SELECT * FROM customers";
//        try {
//            Statement stmt = conn.con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                Customer customer = new Customer();
//                customer.setId(rs.getString("id"));
//                customer.setName(rs.getString("name"));
//                customer.setEmail(rs.getString("email"));
//                customer.setPassword(rs.getString("password"));
//                customer.setHp(rs.getString("hp"));
//                listCustomer.add(customer);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return (listCustomer);
//    }
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

    //Get User Login Data
    public static User getUser(String email, String pass) {
        User user = null;
        conn.connect();
        String query1 = "SELECT * FROM customer WHERE email='" + email + "'";
        String query2 = "SELECT * FROM vendor WHERE email='" + email + "'";
        String query3 = "SELECT * FROM admin WHERE email='" + email + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs1 = stmt.executeQuery(query1);
            ResultSet rs2 = stmt.executeQuery(query2);
            ResultSet rs3 = stmt.executeQuery(query3);
            while (rs1.next() || rs2.next() || rs3.next()) {
                String pass1 = rs1.getString("password");
                String pass2 = rs2.getString("password");
                String pass3 = rs3.getString("password");
                if (pass.equals(pass1)) {
                    user = new Customer();
                    user.setTipeUser(CUSTOMER);
                    user.setID(rs1.getInt("id_cust"));
                    user.setNama(rs1.getString("nama"));
                    user.setEmail(rs1.getString("email"));
                    user.setPassword(rs1.getString("password"));
                    user.setTelepon(rs1.getString("noTelp"));
                } else if (pass.equals(pass2)) {
                    user = new Customer();
                    user.setTipeUser(VENDOR);
                    user.setID(rs2.getInt("id_vendor"));
                    user.setNama(rs2.getString("nama"));
                    user.setEmail(rs2.getString("email"));
                    user.setPassword(rs2.getString("password"));
                    user.setTelepon(rs2.getString("noTelp"));
                } else if (pass.equals(pass3)) {
                    user = new Customer();
                    user.setTipeUser(ADMIN);
                    user.setID(rs3.getInt("id_admin"));
                    user.setNama(rs3.getString("nama"));
                    user.setEmail(rs3.getString("email"));
                    user.setPassword(rs3.getString("password"));
                    user.setTelepon(rs3.getString("noTelp"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (user);
    }

    public static boolean cekPassword(String email, String password) {
        conn.connect();
        String query = "SELECT * FROM customer WHERE email='" + email + "'";
        boolean isMatch = false;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    isMatch = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isMatch;
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

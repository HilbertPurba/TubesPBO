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

/**
 *
 * @author hilbert
 */
public class Controller {
    
    private DatabaseHandler conn = new DatabaseHandler();
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
//    // INSERT
//    public boolean insertNewUser(Customer customer) {
//        conn.connect();
//        String query = "INSERT INTO customers VALUES(?,?,?,?,?)";
//        try {
//            PreparedStatement stmt = conn.con.prepareStatement(query);
//            stmt.setString(1, customer.getId());
//            stmt.setString(2, customer.getName());
//            stmt.setString(3, customer.getEmail());
//            stmt.setString(4, customer.getPassword());
//            stmt.setString(5, customer.getHp());
//            stmt.executeUpdate();
//            return (true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return (false);
//        }
//    }
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


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
 * @author Hilbert
 * @author Zefanya
 */
public class Controller {

    static DatabaseHandler conn = new DatabaseHandler();

    //Get All Produk
    public static ArrayList<Produk> getAllProduk() {
        ArrayList<Produk> listProd = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM produk";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Produk prod = new Produk();
                prod.setIdProduk(rs.getInt("id_prod"));
                prod.setNamaProduk(rs.getString("nama_prod"));
                prod.setMerk(rs.getString("merk_prod"));
                prod.setHarga(rs.getInt("harga"));
                prod.setStok(rs.getInt("stok"));
                listProd.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listProd);
    }
    
    //Get Produk dari Toko tertentu
    public static ArrayList<Produk> getProdukToko(int id) {
        ArrayList<Produk> listProd = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM produk WHERE id='" + id + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Produk prod = new Produk();
                prod.setIdProduk(rs.getInt("id_prod"));
                prod.setNamaProduk(rs.getString("nama_prod"));
                prod.setMerk(rs.getString("merk_prod"));
                prod.setHarga(rs.getInt("harga"));
                prod.setStok(rs.getInt("stok"));
                listProd.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listProd);
    }
    
    //mencocokan untuk pasword login
    public static boolean cekPassword(String email, String password) {
        ArrayList<User> users = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM pengguna WHERE email='" + email + "'";
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
    
    //Get User Login Data
    public static User getUser(String email) {
        User user = new User();
        conn.connect();
        String query = "SELECT * FROM pengguna WHERE email='" + email + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int tipeUser = rs.getInt("tipeUser");
                user.setTipeUser(tipeUser);
                user.setID(rs.getInt("id"));
                user.setNama(rs.getString("nama"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setTelepon(rs.getString("noTelp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (user);
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
    public static boolean insertNewCustomer(User user) {
        conn.connect();
        String query = "INSERT INTO pengguna (nama,email,password,noTelp,tipeUser) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, user.getNama());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getTelepon());
            stmt.setInt(5, 0);
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
        String query = "INSERT INTO pengguna (nama,email,password,noTelp,tipeUser) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, user.getNama());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getTelepon());
            stmt.setInt(5, 1);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    // INSERT produk
    public static boolean insertNewProduk(Produk produk) {
        int id = UserManager.getInstance().getUser().getID();
        conn.connect();
        String query = "INSERT INTO produk (id,nama_prod,merk_prod,harga,stok) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setString(2, produk.getNamaProduk());
            stmt.setString(3, produk.getMerk());
            stmt.setInt(4, produk.getHarga());
            stmt.setInt(5, produk.getStok());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

//
    public static boolean updateProfilCustomer(UserManager updateUser) {
        conn.connect();
        String query = "UPDATE pengguna SET email='" + updateUser.getInstance().getUser().getEmail() + "',"
                + "noTelp='" + updateUser.getInstance().getUser().getTelepon()+ "'"
                + "WHERE nama='" + updateUser.getInstance().getUser().getNama() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
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

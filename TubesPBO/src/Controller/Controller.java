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
import java.util.List;

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
    
     //Get User yang punya Toko
    public static ArrayList<User> getUserToko(int id){
        ArrayList<User> listUser = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM pengguna WHERE tipeUser=1";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setID(rs.getInt("id"));
                user.setNama(rs.getString("nama"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setTelepon(rs.getString("noTelp"));
                user.setTipeUser(rs.getInt("tipeUser"));
                listUser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listUser);
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

    public static int countId(Keranjang keranjang) {
        conn.connect();
        String query = "SELECT count(*) FROM keranjang WHERE id=" + keranjang.getId_user();
        int count = 0;
        try {
            PreparedStatement stmtId = conn.con.prepareStatement(query);
            ResultSet rs = stmtId.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    public static boolean insertNewKeranjang(Keranjang keranjang) {
        if(countId(keranjang) == 0) {
            String query = "INSERT INTO keranjang (id, jumlah_total, harga_total) VALUES (?,?,?)";
            try {
                PreparedStatement stmt = conn.con.prepareStatement(query);
                stmt.setInt(1, keranjang.getId_user());
                stmt.setInt(2, keranjang.getJumlah_total());
                stmt.setInt(3, keranjang.getHarga_total());
                stmt.executeUpdate();
                return (true);
            } catch (SQLException e) {
                e.printStackTrace();
                return (false);
            }
        } else {
            String query = "UPDATE keranjang SET jumlah_total=jumlah_total+" + keranjang.getJumlah_total()
                    + ", harga_total=harga_total+" + keranjang.getHarga_total()
                    + " WHERE id=" + keranjang.getId_user();
            try {
                PreparedStatement stmt = conn.con.prepareStatement(query);
                stmt.executeUpdate();
                return (true);
            } catch (SQLException e) {
                e.printStackTrace();
                return (false);
            }
        }
    }
    
    public static int getIdKeranjang() {
        int id_keranjang = 0;
        conn.connect();
        String query = "SELECT id_keranjang FROM keranjang WHERE id=" + KeranjangManager.getInstance().getKeranjang().getId_user();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id_keranjang = rs.getInt("id_keranjang");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id_keranjang;
    }
    
    public static boolean insertConnectorKeranjang(Keranjang keranjang) {
        int id_produk = KeranjangManager.getInstance().getKeranjang().testConnector();
        conn.connect();
        String query = "INSERT INTO connectorprodukkeranjang (id_keranjang, id_prod, jumlah_produk) VALUES (?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
                stmt.setInt(1, getIdKeranjang());
                stmt.setInt(2, id_produk);
                stmt.setInt(3, keranjang.getJumlah_total());
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
    
    public static int getProdukKeranjang() {
        int id_keranjang = 0;
        conn.connect();
        String query = "SELECT id_keranjang FROM keranjang WHERE id=" + UserManager.getInstance().getUser().getID();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id_keranjang = rs.getInt("id_keranjang");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id_keranjang;
    }
    
    public static List<ProdukBeli> getProdukBeli() {
        List<ProdukBeli> listProdukBeli = new ArrayList<>();
        String query = "SELECT connectorprodukkeranjang.id_keranjang, produk.nama_prod, produk.merk_prod, "
                + "connectorprodukkeranjang.jumlah_produk, "
                + "connectorprodukkeranjang.jumlah_produk*produk.harga AS totalharga1produk "
                + "from produk "
                + "JOIN connectorprodukkeranjang on produk.id_prod = connectorprodukkeranjang.id_prod "
                + "WHERE connectorprodukkeranjang.id_keranjang=" + getProdukKeranjang();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ProdukBeli produkBeli = new ProdukBeli();
                produkBeli.setId_keranjang(rs.getInt("id_keranjang"));
                produkBeli.setNama(rs.getString("nama_prod"));
                produkBeli.setMerk(rs.getString("merk_prod"));
                produkBeli.setJumlahBeli(rs.getInt("jumlah_produk"));
                produkBeli.setHarga(rs.getInt("totalharga1produk"));
                listProdukBeli.add(produkBeli);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProdukBeli;
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

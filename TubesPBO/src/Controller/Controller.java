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

    //Get All Keranjangs
    public static List<Keranjang> getAllKeranjang() {
        List<Keranjang> listKeranjang = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM keranjang WHERE id='" +UserManager.getInstance().getUser().getID()+"'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Keranjang bag = new Keranjang();
                bag.setIdKeranjang(rs.getInt("id_keranjang"));
                bag.setId_user(rs.getInt("id"));
                bag.setId_prod(rs.getInt("id_prod"));
                bag.setNama_prod(rs.getString("nama_prod"));
                bag.setJumlah_total(rs.getInt("jumlah_total"));
                bag.setHarga_total(rs.getInt("harga_total"));
                listKeranjang.add(bag);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listKeranjang);
    }

    //Get User yang punya Toko
    public static ArrayList<User> getUserToko(int id) {
        ArrayList<User> listUser = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM pengguna WHERE tipeUser=1";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User() {};
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
        User user = new User() {};
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
        conn.connect();
        int id = UserManager.getInstance().getUser().getID();
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

    public static boolean insertNewKeranjang(Keranjang keranjang) {
        conn.connect();
        if (cekIdProd(keranjang.getId_prod()) == false) {
            String query = "INSERT INTO keranjang (id, id_prod, nama_prod, jumlah_total, harga_total) VALUES (?,?,?,?,?)";
            try {
                PreparedStatement stmt = conn.con.prepareStatement(query);
                stmt.setInt(1, keranjang.getId_user());
                stmt.setInt(2, keranjang.getId_prod());
                stmt.setString(3, keranjang.getNama_prod());
                stmt.setInt(4, keranjang.getJumlah_total());
                stmt.setInt(5, keranjang.getHarga_total());
                stmt.executeUpdate();
                return (true);
            } catch (SQLException e) {
                e.printStackTrace();
                return (false);
            }

        } else {
            String query = "UPDATE keranjang SET jumlah_total=jumlah_total+" + keranjang.getJumlah_total()
                    + ", harga_total=harga_total+" + keranjang.getHarga_total()
                    + " WHERE id='" + keranjang.getId_user() + "'";
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

    public static boolean cekIdProd(int id_prod) {
        conn.connect();
        String query = "SELECT * FROM keranjang WHERE id_prod='" + id_prod + "'";
        boolean isMatch = false;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getInt("id_prod") == id_prod) {
                    isMatch = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isMatch;
    }
//    public static int getIdKeranjang() {
//        int id_keranjang = 0;
//        conn.connect();
//        String query = "SELECT id_prod FROM keranjang WHERE id=" + UserManager.getInstance().getUser().getID();
//        try {
//            Statement stmt = conn.con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                id_keranjang = rs.getInt("id_keranjang");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return id_keranjang;
//    }

  
    // Update Profil
    public static boolean updateProfilCustomer(UserManager updateUser) {
        String query = "UPDATE pengguna SET email='" + updateUser.getInstance().getUser().getEmail() + "',"
                + "noTelp='" + updateUser.getInstance().getUser().getTelepon() + "'"
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

    public static int countTransaksi(Transaksi transaksi) {
        conn.connect();
        String query = "SELECT count(*) FROM transaksi WHERE nama='" + transaksi.getNamaLengkap() + "'";
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

    public static boolean insertNewTransaksi(Transaksi newTransaksi) {
        conn.connect();
        if(countTransaksi(newTransaksi) == 0) {
            String query = "INSERT INTO transaksi (nama, noTelp, alamat, jenis_pembayaran, "
                    + "jenis_pengiriman, kode_promo, total_harga, status_kirim) VALUES (?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement stmt = conn.con.prepareStatement(query);
                stmt.setString(1, newTransaksi.getNamaLengkap());
                stmt.setString(2, newTransaksi.getNoTelepon());
                stmt.setString(3, newTransaksi.getAlamat());
                stmt.setString(4, newTransaksi.getJenisPembayaran());
                stmt.setString(5, newTransaksi.getJenisPengiriman());
                stmt.setString(6, newTransaksi.getKodePromo());
                stmt.setInt(7, newTransaksi.getTotalHarga());
                stmt.setString(8, "Dikemas");
                stmt.executeUpdate();
                return (true);
            } catch (SQLException e) {
                e.printStackTrace();
                return (false);
            }
        } else {
            String query = "UPDATE transaksi SET total_harga=total_harga + " + newTransaksi.getTotalHarga()
                    + " WHERE nama='" + newTransaksi.getNamaLengkap() + "'";
            try {
                PreparedStatement stmt = conn.con.prepareStatement(query);
                stmt = conn.con.prepareStatement(query);
                stmt.executeUpdate();
                return (true);
            } catch (SQLException e) {
                e.printStackTrace();
                return (false);
            }
        }
    }
    
    public static int getIdTransaksi() {
        int id_transaksi = 0;
        conn.connect();
        String query = "SELECT id_transaksi FROM transaksi WHERE nama='" + TransaksiManager.getInstance().getTransaksi().getNamaLengkap()+ "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id_transaksi = rs.getInt("id_transaksi");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id_transaksi;
    }
    
    public static int getJumlahProduk() {
        int jumlah_produk = 0;
        conn.connect();
        String query = "SELECT jumlah_produk "
                + "from connectorprodukkeranjang "
                + "WHERE id_keranjang=" + getProdukKeranjang();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                jumlah_produk = rs.getInt("jumlah_produk");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jumlah_produk; 
    }
    
//    public static boolean insertConnectorTransaksi(Transaksi transaksi) {
//        conn.connect();
//        int id_produk = TransaksiManager.getInstance().getTransaksi().getIdProduk();
//        String query = "INSERT INTO connectorproduktransaksi (id_transaksi, id_prod, jumlah_produk, total_harga) VALUES (?,?,?,?)";
//
//        try {
//            PreparedStatement stmt = conn.con.prepareStatement(query);
//            stmt.setString(1, newTransaksi.getNamaLengkap());
//            stmt.setString(2, newTransaksi.getNoTelepon());
//            stmt.setString(3, newTransaksi.getAlamat());
//            stmt.setString(4, newTransaksi.getJenisPembayaran());
//            stmt.setString(5, newTransaksi.getJenisPengiriman());
//            stmt.setString(6, newTransaksi.getKodePromo());
//            stmt.setInt(7, newTransaksi.getTotalHarga());
//            stmt.setString(8, "Dikemas");
//            stmt.executeUpdate();
//            return (true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return (false);
//        }
//    }
//
//    public static int getIdTransaksi() {
//        int id_transaksi = 0;
//        conn.connect();
//        String query = "SELECT id_transaksi FROM transaksi WHERE nama='" + TransaksiManager.getInstance().getTransaksi().getNamaLengkap() + "'";
//        try {
//            Statement stmt = conn.con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                id_transaksi = rs.getInt("id_transaksi");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return id_transaksi;
//    }

//    public static int getJumlahProduk() {
//        int jumlah_produk = 0;
//        conn.connect();
//        String query = "SELECT jumlah_produk "
//                + "from connectorprodukkeranjang "
//                + "WHERE id_keranjang=" + getProdukKeranjang();
//        try {
//            Statement stmt = conn.con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                jumlah_produk = rs.getInt("jumlah_produk");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return jumlah_produk;
//    }

//    public static boolean insertConnectorTransaksi(Transaksi transaksi) {
//        conn.connect();
//        int id_produk = TransaksiManager.getInstance().getTransaksi().getIdProduk();
//        String query = "INSERT INTO connectorproduktransaksi (id_transaksi, id_prod, jumlah_produk, total_harga) VALUES (?,?,?,?)";
//        try {
//            PreparedStatement stmt = conn.con.prepareStatement(query);
//            stmt.setInt(1, getIdTransaksi());
//            stmt.setInt(2, id_produk);
//            stmt.setInt(3, getJumlahProduk());
//            stmt.setInt(4, transaksi.getTotalHarga());
//            stmt.executeUpdate();
//            return (true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return (false);
//        }
//    }

    public static boolean updateKeranjang() {
        return true;
    }

    public static boolean updateStok() {
        return true;
    }
    
    //DELETE Transaction
    public boolean deleteTransaction(String id_transaksi){
        conn.connect();
        
        String query = "DELETE FROM transaksi WHERE id_transaksi = '" + id_transaksi + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e){
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

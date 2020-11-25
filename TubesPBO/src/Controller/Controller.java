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
        } finally {
            conn.disconnect();
        }
        return isMatch;
    }
    
        //---KUMPULAN GET---
    //Get User Login Data
    public static User getUser(String email) {
        User user = new User() {
        };
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
        } finally {
            conn.disconnect();
        }
        return (user);
    }

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
        } finally {
            conn.disconnect();
        }
        return (listProd);
    }

    //Get All Keranjangs
    public static List<Keranjang> getAllKeranjang() {
        List<Keranjang> listKeranjang = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM keranjang WHERE id=" + UserManager.getInstance().getUser().getID();
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
        } finally {
            conn.disconnect();
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
                User user = new User() {
                };
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
        } finally {
            conn.disconnect();
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
        } finally {
            conn.disconnect();
        }
        return (listProd);
    }

    // Get Produk Keranjang
    public static int getProdukKeranjang() {
        conn.connect();
        int id_keranjang = 0;
        String query = "SELECT id_keranjang FROM keranjang WHERE id=" + UserManager.getInstance().getUser().getID();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                id_keranjang = rs.getInt("id_keranjang");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return id_keranjang;
    }

    // Get Jumlah Produk
    public static int getJumlahProduk() {
        conn.connect();
        String query = "SELECT jumlah_total "
                + "from keranjang "
                + "WHERE id=" + UserManager.getInstance().getUser().getID() + " "
                + "AND id_prod=" + TransaksiManager.getInstance().getTransaksi().getId_produk();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt("jumlah_total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return -1;
    }

    // Get ID Transaksi
    public static int getIdTransaksi() {
        conn.connect();
        String query = "SELECT id_transaksi from transaksi WHERE total_harga=" + TransaksiManager.getInstance().getTransaksi().getTotalHarga();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt("id_transaksi");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return -1;
    }
    

    
        //---KUMPULAN INSERT---
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
        } finally {
            conn.disconnect();
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
        } finally {
            conn.disconnect();
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
        } finally {
            conn.disconnect();
        }
    }

    // INSERT Keranjang
    public static boolean insertNewKeranjang(Keranjang keranjang) {
        conn.connect();
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
        } finally {
            conn.disconnect();
        }
    }
    
    // Insert New Transaksi
    public static boolean insertNewTransaksi(Transaksi transaksi) {
        conn.connect();
        String query = "INSERT INTO transaksi (id_prod, nama, noTelp, alamat, jenis_pembayaran, "
                + "jenis_pengiriman, kode_promo, jumlah_produk, total_harga, status_kirim) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, transaksi.getId_produk());
            stmt.setString(2, transaksi.getNamaLengkap());
            stmt.setString(3, transaksi.getNoTelepon());
            stmt.setString(4, transaksi.getAlamat());
            stmt.setString(5, transaksi.getJenisPembayaran());
            stmt.setString(6, transaksi.getJenisPengiriman());
            stmt.setString(7, transaksi.getKodePromo());
            stmt.setInt(8, transaksi.getJumlah_produk());
            stmt.setInt(9, transaksi.getTotalHarga());
            stmt.setString(10, "Dikemas");
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        } finally {
            conn.disconnect();
        }
    }

    // Insert Connector Transaksi
    public static boolean insertConnectorTransaksi(Transaksi transaksi) {
        conn.connect();
        String query = "INSERT INTO connectorproduktransaksi (id_transaksi, id_prod, jumlah_produk, total_harga) VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, getIdTransaksi());
            stmt.setInt(2, transaksi.getId_produk());
            stmt.setInt(3, getJumlahProduk());
            stmt.setInt(4, transaksi.getTotalHarga());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        } finally {
            conn.disconnect();
        }
    }
    
    
    
    // Cek ID Produk
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
        } finally {
            conn.disconnect();
        }
        return isMatch;
    }

    
        // ---KUMPULAN UPDATE---
    // Update Profil
    public static boolean updateProfilCustomer(UserManager updateUser) {
        conn.connect();
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
        } finally {
            conn.disconnect();
        }
    }
    
    // Update Stock Produk
    public static boolean updateStok() {

        conn.connect();
        String query = "UPDATE produk SET stok=(stok - " + TransaksiManager.getInstance().getTransaksi().getJumlah_produk() + ") "
                + "WHERE id_prod=" + TransaksiManager.getInstance().getTransaksi().getId_produk();
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        } finally {
            conn.disconnect();
        }
    }


        // ---KUMPULAN DELETE---
    // Delete Keranjang
    public static boolean deleteKeranjang() {
        conn.connect();
        String query = "DELETE FROM keranjang WHERE id=" + UserManager.getInstance().getUser().getID() + " "
                + " AND id_prod=" + TransaksiManager.getInstance().getTransaksi().getId_produk();
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        } finally {
            conn.disconnect();
        }
    }

    //DELETE Transaction
    public boolean deleteTransaction(String id_transaksi) {
        conn.connect();
        String query = "DELETE FROM transaksi WHERE id_transaksi = '" + id_transaksi + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        } finally {
            conn.disconnect();
        }
    }
}

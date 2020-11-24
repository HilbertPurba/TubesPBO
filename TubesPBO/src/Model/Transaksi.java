/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Controller;
import Controller.DatabaseHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class Transaksi {

    private int idTransaksi;
    private int id_prod;
    private String namaLengkap;
    private String noTelepon;
    private String alamat;
    private String jenisPembayaran;
    private String jenisPengiriman;
    private String kodePromo;
    private int jumlah_produk;
    private int totalHarga;
    private String status;

    static DatabaseHandler conn = new DatabaseHandler();

    public Transaksi() {
    }

    public Transaksi(int idTransaksi, int id_prod, String namaLengkap, String noTelepon, String alamat, String jenisPembayaran, String jenisPengiriman, String kodePromo, int jumlah_produk, int totalHarga, String status) {
        this.idTransaksi = idTransaksi;
        this.id_prod = id_prod;
        this.namaLengkap = namaLengkap;
        this.noTelepon = noTelepon;
        this.alamat = alamat;
        this.jenisPembayaran = jenisPembayaran;
        this.jenisPengiriman = jenisPengiriman;
        this.kodePromo = kodePromo;
        this.jumlah_produk = jumlah_produk;
        this.totalHarga = totalHarga;
        this.status = status;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public void setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
    }

    public String getJenisPengiriman() {
        return jenisPengiriman;
    }

    public void setJenisPengiriman(String jenisPengiriman) {
        this.jenisPengiriman = jenisPengiriman;
    }

    public String getKodePromo() {
        return kodePromo;
    }

    public void setKodePromo(String kodePromo) {
        this.kodePromo = kodePromo;
    }

    public int getJumlah_produk() {
        return jumlah_produk;
    }

    public void setJumlah_produk(int jumlah_produk) {
        this.jumlah_produk = jumlah_produk;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdProduk() {
        int id_produk = 0;
        List<Produk> listProd = Controller.getAllProduk();
        for (int i = 0; i < listProd.size(); i++) {
            if (listProd.get(i).getIdProduk() == TransaksiManager.getInstance().getTransaksi().getIdProduk()) {
                id_produk = listProd.get(i).getIdProduk();
            }
        }
        return id_produk;
    }

    //Get semua transaksi
    public static ArrayList<Transaksi> getAllTransaksi() {
        ArrayList<Transaksi> listTransaksi = new ArrayList<>();
        conn.connect();
        String query = "select transaksi.id_transaksi, transaksi.id_prod,produk.nama_prod,transaksi.nama,transaksi.noTelp, transaksi.alamat, "
                + "transaksi.jenis_pengiriman, transaksi.jenis_pembayaran, transaksi.kode_promo, transaksi.jumlah_produk,transaksi.total_harga"
                + ",transaksi.status_kirim\n"
                + "FROM transaksi\n"
                + "JOIN produk ON transaksi.id_prod = produk.id_prod \n"
                + "JOIN pengguna ON produk.id = pengguna.id ";
//        String query = "SELECT * FROM transaksi";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setIdTransaksi(rs.getInt("transaksi.id_transaksi"));
                transaksi.setId_prod(rs.getInt("transaksi.id_prod"));
                transaksi.setNamaLengkap(rs.getString("transaksi.nama"));
                transaksi.setNoTelepon(rs.getString("transaksi.noTelp"));
                transaksi.setAlamat(rs.getString("transaksi.alamat"));
                transaksi.setJenisPengiriman(rs.getString("transaksi.jenis_pengiriman"));
                transaksi.setJenisPembayaran(rs.getString("transaksi.jenis_pembayaran"));
                transaksi.setKodePromo(rs.getString("transaksi.kode_promo"));
                transaksi.setJumlah_produk(rs.getInt("transaksi.jumlah_produk"));
                transaksi.setTotalHarga(rs.getInt("transaksi.total_harga"));
                transaksi.setStatus(rs.getString("transaksi.status_kirim"));
                listTransaksi.add(transaksi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listTransaksi);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.DatabaseHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Gilbert
 */
public class ListTransaksiToko {

    private int id_transaksi;
    private int id_produk;
    private String nama_prod;
    private String namaPengguna;
    private int jumlah_beli;
    private int total_harga;
    private String status;

    static DatabaseHandler conn = new DatabaseHandler();

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public String getNama_prod() {
        return nama_prod;
    }

    public void setNama_prod(String nama_prod) {
        this.nama_prod = nama_prod;
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public void setNamaPengguna(String namaPengguna) {
        this.namaPengguna = namaPengguna;
    }

    public int getJumlah_beli() {
        return jumlah_beli;
    }

    public void setJumlah_beli(int jumlah_beli) {
        this.jumlah_beli = jumlah_beli;
    }

    public int getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(int total_harga) {
        this.total_harga = total_harga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static ArrayList<ListTransaksiToko> getAllTransaksiToko(String nama_toko) {
        ArrayList<ListTransaksiToko> listTransaksi = new ArrayList<>();
        conn.connect();
        String query = "select transaksi.id_transaksi, transaksi.id_prod,produk.nama_prod,transaksi.nama,transaksi.jumlah_produk,transaksi.total_harga"
                + ",transaksi.status\n"
                + "FROM transaksi\n"
                + "JOIN produk ON transaksi.id_prod = produk.id_prod \n"
                + "JOIN pengguna ON produk.id = pengguna.id WHERE pengguna.nama ='" + nama_toko + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ListTransaksiToko newList = new ListTransaksiToko();
                newList.setId_transaksi(rs.getInt("transaksi.id_transaksi"));
                newList.setId_produk(rs.getInt("transaksi.id_prod"));
                newList.setNamaPengguna(rs.getString("transaksi.nama"));
                newList.setNama_prod(rs.getString("produk.nama_prod"));
                newList.setJumlah_beli(rs.getInt("transaksi.jumlah_produk"));
                newList.setTotal_harga(rs.getInt("transaksi.total_harga"));
                newList.setStatus(rs.getString("transaksi.status"));
                listTransaksi.add(newList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (listTransaksi);
    }
}

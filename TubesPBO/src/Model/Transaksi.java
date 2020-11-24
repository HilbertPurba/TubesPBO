/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Controller;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class Transaksi {
    private String idTransaksi;
    private Customer customer;
    private String namaLengkap;
    private String noTelepon;
    private String alamat;
    private String jenisPembayaran;
    private String jenisPengiriman;
    private String kodePromo;
    private int totalHarga;
    
    public Transaksi() {
    }
    
    public Transaksi(String idTransaksi, Customer customer, String namaLengkap, String noTelepon, String alamat, String jenisPembayaran, String jenisPengiriman, String kodePromo, int totalHarga) {
        this.idTransaksi = idTransaksi;
        this.customer = customer;
        this.namaLengkap = namaLengkap;
        this.noTelepon = noTelepon;
        this.alamat = alamat;
        this.jenisPembayaran = jenisPembayaran;
        this.jenisPengiriman = jenisPengiriman;
        this.kodePromo = kodePromo;
        this.totalHarga = totalHarga;
    }
    
    public int getIdProduk() {
        int id_produk = 0;
        List<Produk> listProd = Controller.getAllProduk();
        for(int i = 0; i < listProd.size(); i++) {
            if(listProd.get(i).getIdProduk() == TransaksiManager.getInstance().getTransaksi().getIdProduk()) {
                id_produk = listProd.get(i).getIdProduk();
            }
        }
        return id_produk;
    }
    
    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }
}

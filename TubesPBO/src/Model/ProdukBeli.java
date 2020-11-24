/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hilbert
 */
public class ProdukBeli {

    private String nama;
    private String merk;
    private int harga;
    private int jumlahBeli;
    private int id_keranjang;
    private int id_produk;

    public ProdukBeli() {
    }

    public ProdukBeli(String nama, String merk, int harga, int jumlahBeli, int id_keranjang, int id_produk) {
        this.nama = nama;
        this.merk = merk;
        this.harga = harga;
        this.jumlahBeli = jumlahBeli;
        this.id_keranjang = id_keranjang;
        this.id_produk = id_produk;
    }

    public int countTotalHarga(ProdukBeli newProdukBeli) {
        return newProdukBeli.getHarga() * newProdukBeli.getJumlahBeli();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getJumlahBeli() {
        return jumlahBeli;
    }

    public void setJumlahBeli(int jumlahBeli) {
        this.jumlahBeli = jumlahBeli;
    }

    public int getId_keranjang() {
        return id_keranjang;
    }

    public void setId_keranjang(int id_keranjang) {
        this.id_keranjang = id_keranjang;
    }

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }
}

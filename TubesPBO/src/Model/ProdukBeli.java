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
 * @author hilbert
 */
public class ProdukBeli {

    private String nama;
    private String merk;
    private int harga;
    private int jumlahBeli;
    private int id_keranjang;
    
    public int countTotalHarga(ProdukBeli newProdukBeli) {
        return newProdukBeli.getHarga() * newProdukBeli.getJumlahBeli();
    }

    public int getId_keranjang() {
        return id_keranjang;
    }

    public void setId_keranjang(int id_keranjang) {
        this.id_keranjang = id_keranjang;
    }

    public ProdukBeli(String nama, String merk, int harga, int jumlahBeli, int id_keranjang) {
        this.nama = nama;
        this.merk = merk;
        this.harga = harga;
        this.jumlahBeli = jumlahBeli;
        this.id_keranjang = id_keranjang;
    }

    public ProdukBeli() {
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

    @Override
    public String toString() {
        List<ProdukBeli> listProdukBeli = Controller.getProdukBeli();
        String data = "";
        for(int i = 0; i < listProdukBeli.size(); i++) {
            data += "ProdukBeli{" + "nama=" + listProdukBeli.get(i).getNama() + ", merk=" + listProdukBeli.get(i).getMerk() + ", harga=" + listProdukBeli.get(i).getHarga() + ", jumlahBeli=" + listProdukBeli.get(i).getJumlahBeli() + ", id_keranjang=" + listProdukBeli.get(i).getId_keranjang()+ '}';
        }
        return data;
    }
}

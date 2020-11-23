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
public class Keranjang {
    private int idKeranjang;
    private int id_user;
    private int jumlah_total;
    private int harga_total;

    public Keranjang() {
    }
    
    public int testConnector() {
        int id_produk = -1;
        List<Produk> listProd = Controller.getAllProduk();
        for(int i = 0; i < listProd.size(); i++) {
            if(listProd.get(i).getNamaProduk().equals(ProdukBeliManager.getInstance().getProdukBeli().getNama())) {
                id_produk = listProd.get(i).getIdProduk();
            }
        }
        return id_produk;
    }

    public Keranjang(int idKeranjang, int id_user, int jumlah_total, int harga_total) {
        this.idKeranjang = idKeranjang;
        this.id_user = id_user;
        this.jumlah_total = jumlah_total;
        this.harga_total = harga_total;
    }

    public int getIdKeranjang() {
        return idKeranjang;
    }

    public void setIdKeranjang(int idKeranjang) {
        this.idKeranjang = idKeranjang;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getJumlah_total() {
        return jumlah_total;
    }

    public void setJumlah_total(int jumlah_total) {
        this.jumlah_total = jumlah_total;
    }

    public int getHarga_total() {
        return harga_total;
    }

    public void setHarga_total(int harga_total) {
        this.harga_total = harga_total;
    }
  
}
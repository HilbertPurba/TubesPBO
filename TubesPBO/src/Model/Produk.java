/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Controller;
import java.util.ArrayList;

/**
 *
 * @author hilbert
 */
public class Produk {

    private int idProduk;
    private String namaProduk;
    private String merk;
    private int harga;
    private int stok;

    public Produk(int idProduk, String namaProduk, String merk, int harga, int stok) {
        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.merk = merk;
        this.harga = harga;
        this.stok = stok;
    }

    public Produk() {
    }

    public int getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(int idProduk) {
        this.idProduk = idProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
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

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public String toString() {
        ArrayList<Produk> listProd = Controller.getProdukToko(UserManager.getInstance().getUser().getID());
        String data = "<html><body><table border=\"1\"><tr><th>Nama Produk</th><th>Stok</th></tr>";
        for (int i = 0; i < listProd.size(); i++) {
            data += "<tr><td>"+listProd.get(i).getNamaProduk() + "</td>"+"<td>"+listProd.get(i).getStok() + "</td></tr>";
        }
        data += "</table></body></html>";
        return data;
    }
}

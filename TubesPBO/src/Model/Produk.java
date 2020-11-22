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
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
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
        String data = ""
                + "<html>"
                    + "<body>"
                        + "<table style='border-collapse: collapse;width: 500px;border: 0px solid black'>"
                            + "<tr style='border: 1px solid black;'>"
                                + "<th style='text-align: center; border:1px solid black;'>Nama Produk</th>"
                                + "<th style='text-align: center'>Stok</th>"
                            + "</tr>";
        for (int i = 0; i < listProd.size(); i++) {
            data += "<tr style='border: 1px solid black;'><td style='text-align: center; border: 1px solid black; '>"+listProd.get(i).getNamaProduk() + "</td>"+"<td style='text-align: center'>"+listProd.get(i).getStok() + "</td></tr>";
        }
        data += "</table></body></html>";
        return data;
    }
}

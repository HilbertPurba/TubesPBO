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
    private int id_prod;
    private String nama_prod;
    private int jumlah_total;
    private int harga_total;

    public Keranjang() {
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

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getNama_prod() {
        return nama_prod;
    }

    public void setNama_prod(String nama_prod) {
        this.nama_prod = nama_prod;
    }

    @Override
    public String toString() {
        String data = "";
        List<Keranjang> listkeranjang = Controller.getAllKeranjang();
        for (Keranjang keranjang : listkeranjang) {
            data += "Keranjang{" + "idKeranjang=" + keranjang.getIdKeranjang()
                    + ", id_user=" + keranjang.getId_user() + ", id_prod="
                    + keranjang.getId_prod() + ", nama_prod=" + keranjang.getNama_prod()
                    + ", jumlah_total=" + keranjang.getJumlah_total() + ", harga_total=" + keranjang.getHarga_total() + '}';

        }
        return data;
    }
}

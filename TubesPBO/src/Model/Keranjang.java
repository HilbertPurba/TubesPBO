/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author hilbert
 */
public class Keranjang {
    private int idKeranjang;
    private int id_user;
    private int id_toko;
    private String namaToko;
    private List<Produk> listProdukBeli;

    public Keranjang(int idKeranjang, int id_user, int id_toko, String namaToko, List<Produk> listProdukBeli) {
        this.idKeranjang = idKeranjang;
        this.id_user = id_user;
        this.id_toko = id_toko;
        this.namaToko = namaToko;
        this.listProdukBeli = listProdukBeli;
    }

    public Keranjang() {
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

    public int getId_toko() {
        return id_toko;
    }

    public void setId_toko(int id_toko) {
        this.id_toko = id_toko;
    }

    public String getNamaToko() {
        return namaToko;
    }

    public void setNamaToko(String namaToko) {
        this.namaToko = namaToko;
    }

    public List<Produk> getListProdukBeli() {
        return listProdukBeli;
    }

    public void setListProdukBeli(List<Produk> listProdukBeli) {
        this.listProdukBeli = listProdukBeli;
    }

    
}
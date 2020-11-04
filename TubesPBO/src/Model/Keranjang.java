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
    private String idKeranjang;
    private String namaToko;
    private List<Produk> listProdukBeli;

    public Keranjang(String idKeranjang, String namaToko, List<Produk> listProdukBeli) {
        this.idKeranjang = idKeranjang;
        this.namaToko = namaToko;
        this.listProdukBeli = listProdukBeli;
    }

    public String getIdKeranjang() {
        return idKeranjang;
    }

    public void setIdKeranjang(String idKeranjang) {
        this.idKeranjang = idKeranjang;
    }

    public String getNamaTOko() {
        return namaToko;
    }

    public void setNamaTOko(String namaTOko) {
        this.namaToko = namaTOko;
    }

    public List<Produk> getListProdukBeli() {
        return listProdukBeli;
    }

    public void setListProdukBeli(List<Produk> listProdukBeli) {
        this.listProdukBeli = listProdukBeli;
    }
}
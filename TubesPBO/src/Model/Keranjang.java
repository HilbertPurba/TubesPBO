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
    private String namaTOko;
    private List<Produk> listProdukBeli;

    public Keranjang(String idKeranjang, String namaTOko, List<Produk> listProdukBeli) {
        this.idKeranjang = idKeranjang;
        this.namaTOko = namaTOko;
        this.listProdukBeli = listProdukBeli;
    }

    public String getIdKeranjang() {
        return idKeranjang;
    }

    public void setIdKeranjang(String idKeranjang) {
        this.idKeranjang = idKeranjang;
    }

    public String getNamaTOko() {
        return namaTOko;
    }

    public void setNamaTOko(String namaTOko) {
        this.namaTOko = namaTOko;
    }

    public List<Produk> getListProdukBeli() {
        return listProdukBeli;
    }

    public void setListProdukBeli(List<Produk> listProdukBeli) {
        this.listProdukBeli = listProdukBeli;
    }
}
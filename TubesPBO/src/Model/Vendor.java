/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import Model.enums.TipeUserEnums;
/**
 *
 * @author Lenovo
 */
public class Vendor extends User {

    private List<Produk> listProduk;

    public Vendor(int ID, TipeUserEnums TipeUser, String nama, String email, String password, String telepon) {
        super(ID, TipeUser, nama, email, password, telepon);
    }


    public Vendor(String nama, String email, String password, String telepon) {
        super(nama, email, password, telepon);
    }

    public Vendor() {
    }

    public Vendor(List<Produk> listProduk, int ID, TipeUserEnums TipeUser, String nama, String email, String password, String telepon) {
        super(ID, TipeUser, nama, email, password, telepon);
        this.listProduk = listProduk;
    }

    public List<Produk> getListProduk() {
        return listProduk;
    }

    public void setListProduk(List<Produk> listProduk) {
        this.listProduk = listProduk;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Vendor extends User {

    private List<Produk> listProduk;

    public Vendor(int ID, String nama, String email, String password, String telepon, int TipeUser) {
        super(ID, nama, email, password, telepon, TipeUser);
    }

    public Vendor(String nama, String email, String password, String telepon, int TipeUser) {
        super(nama, email, password, telepon, TipeUser);
    }

    public Vendor() {
    }

    public Vendor(List<Produk> listProduk, String nama, String email, String password, String telepon, int TipeUser) {
        super(nama, email, password, telepon, TipeUser);
        this.listProduk = listProduk;
    }

    public List<Produk> getListProduk() {
        return listProduk;
    }

    public void setListProduk(List<Produk> listProduk) {
        this.listProduk = listProduk;
    }
//    //tes insert ke list
//    public void printProduct(){
//        for(Produk produk: listProduk){
//            JOptionPane.showMessageDialog(null, produk.getNamaProduk()+"\n"+produk.getHarga());
//        }
//    }
}

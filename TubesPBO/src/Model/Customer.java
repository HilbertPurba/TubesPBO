/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.enums.TipeUser;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hilbert
 */
public class Customer extends User {

    Keranjang keranjang;
    private List<Customer> listCustomer = new LinkedList<>();

    public Customer(Keranjang keranjang, int ID, String nama, String email, TipeUser tipeUser, String password, String telepon) {
        super(ID, nama, email, tipeUser, password, telepon);
        this.keranjang = keranjang;
    }

    public Customer(Keranjang keranjang, String nama, String email, TipeUser tipeUser, String password, String telepon) {
        super(nama, email, tipeUser, password, telepon);
        this.keranjang = keranjang;
    }

    public Customer() {
    }

    public Keranjang getKeranjang() {
        return keranjang;
    }

    public void setKeranjang(Keranjang keranjang) {
        this.keranjang = keranjang;
    }

    public List<Customer> getListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(List<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }

}

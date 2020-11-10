/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.enums.TipeUserEnums;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hilbert
 */
public class Customer extends User {

    Keranjang keranjang;
    private List<Customer> listCustomer = new LinkedList<>();

    public Customer(Keranjang keranjang, int ID, TipeUserEnums TipeUser, String nama, String email, String password, String telepon) {
        super(ID, TipeUser, nama, email, password, telepon);
        this.keranjang = keranjang;
    }

    public Customer(String nama, String email, String password, String telepon) {
        super(nama, email, password, telepon);
    }

    public Customer(int ID, TipeUserEnums TipeUser, String nama, String email, String password, String telepon) {
        super(ID, TipeUser, nama, email, password, telepon);
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

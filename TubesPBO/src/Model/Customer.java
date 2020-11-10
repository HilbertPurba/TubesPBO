/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hilbert
 */
public class Customer extends User {

    Keranjang keranjang;
    private List<Customer> listCustomer = new LinkedList<>();

    public Customer() {
    }

    public Customer(Keranjang keranjang, int ID, String nama, String email, String password, String telepon) {
        super(ID, nama, email, password, telepon);
        this.keranjang = keranjang;
    }


    public Customer(Keranjang keranjang, String nama, String email, String password, String telepon) {
        super(nama, email, password, telepon);
        this.keranjang = keranjang;
    }


}

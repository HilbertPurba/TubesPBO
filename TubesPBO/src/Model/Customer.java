/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hilbert
 */
public class Customer extends User{
    Keranjang keranjang;

    public Customer(Keranjang keranjang, String ID, String nama, String email, String password, String telepon) {
        super(ID, nama, email, password, telepon);
        this.keranjang = keranjang;
    }

    public Keranjang getKeranjang() {
        return keranjang;
    }

    public void setKeranjang(Keranjang keranjang) {
        this.keranjang = keranjang;
    }
}

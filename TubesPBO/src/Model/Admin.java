/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;


/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class Admin extends User{
    
    List<Transaksi> listTransaksi;

    public Admin(int ID, String nama, String email, String password, String telepon, int TipeUser) {
        super(ID, nama, email, password, telepon, TipeUser);
    }

    public Admin(String nama, String email, String password, String telepon, int TipeUser) {
        super(nama, email, password, telepon,TipeUser);
    }

    public Admin() {
    }

}

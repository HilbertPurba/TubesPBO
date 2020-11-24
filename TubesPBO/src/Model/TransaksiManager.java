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
public class TransaksiManager {
    private static TransaksiManager instance;
    private Transaksi transaksi;
    
    public static TransaksiManager getInstance() {
        if(instance == null) {
            instance = new TransaksiManager();
        }
        return instance;
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }
}

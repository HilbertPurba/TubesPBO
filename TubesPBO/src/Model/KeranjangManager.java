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
public class KeranjangManager {
    private static KeranjangManager instance;
    private Keranjang keranjang;
    
    public static KeranjangManager getInstance() {
        if(instance == null) {
            instance = new KeranjangManager();
        }
        return instance;
    }

    public Keranjang getKeranjang() {
        return keranjang;
    }

    public void setKeranjang(Keranjang keranjang) {
        this.keranjang = keranjang;
    }
}

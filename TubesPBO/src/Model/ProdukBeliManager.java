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
public class ProdukBeliManager {
    private static ProdukBeliManager instance;
    private ProdukBeli produkBeli;
    
    public static ProdukBeliManager getInstance() {
        if(instance == null) {
            instance = new ProdukBeliManager();
        }
        return instance;
    }

    public ProdukBeli getProdukBeli() {
        return produkBeli;
    }

    public void setProdukBeli(ProdukBeli produkBeli) {
        this.produkBeli = produkBeli;
    }
}

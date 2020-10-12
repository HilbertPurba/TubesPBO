/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.List;
/**
 *
 * @author Lenovo
 */
public class Vendor extends User {
    private String idToko;
    private String namaToko;
    private String alamatToko;
    private String kota;
    private String kecamatan;
    private String kodePos;
    private List<Produk> listProduk;

    public Vendor(String idToko, String namaToko, String alamatToko, String kota, String kecamatan, String kodePos, List<Produk> listProduk, String idUser, String namaDepan, String namaBelakang, String email, String password, String jk, String telepon) {
        super(idUser, namaDepan, namaBelakang, email, password, jk, telepon);
        this.idToko = idToko;
        this.namaToko = namaToko;
        this.alamatToko = alamatToko;
        this.kota = kota;
        this.kecamatan = kecamatan;
        this.kodePos = kodePos;
        this.listProduk = listProduk;
    }

    public String getIdToko() {
        return idToko;
    }

    public void setIdToko(String idToko) {
        this.idToko = idToko;
    }

    public String getNamaToko() {
        return namaToko;
    }

    public void setNamaToko(String namaToko) {
        this.namaToko = namaToko;
    }

    public String getAlamatToko() {
        return alamatToko;
    }

    public void setAlamatToko(String alamatToko) {
        this.alamatToko = alamatToko;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public List<Produk> getListProduk() {
        return listProduk;
    }

    public void setListProduk(List<Produk> listProduk) {
        this.listProduk = listProduk;
    }
}

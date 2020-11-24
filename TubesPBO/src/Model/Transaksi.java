/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class Transaksi {
    private int idTransaksi;
    private int id_produk;
    private String namaLengkap;
    private String noTelepon;
    private String alamat;
    private String jenisPembayaran;
    private String jenisPengiriman;
    private String kodePromo;
    private int jumlah_produk;
    private int totalHarga;
    
    public Transaksi() {
    }

    public Transaksi(int idTransaksi, int id_produk, String namaLengkap, String noTelepon, String alamat, String jenisPembayaran, String jenisPengiriman, String kodePromo, int jumlah_produk, int totalHarga) {
        this.idTransaksi = idTransaksi;
        this.id_produk = id_produk;
        this.namaLengkap = namaLengkap;
        this.noTelepon = noTelepon;
        this.alamat = alamat;
        this.jenisPembayaran = jenisPembayaran;
        this.jenisPengiriman = jenisPengiriman;
        this.kodePromo = kodePromo;
        this.jumlah_produk = jumlah_produk;
        this.totalHarga = totalHarga;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public void setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
    }

    public String getJenisPengiriman() {
        return jenisPengiriman;
    }

    public void setJenisPengiriman(String jenisPengiriman) {
        this.jenisPengiriman = jenisPengiriman;
    }

    public String getKodePromo() {
        return kodePromo;
    }

    public void setKodePromo(String kodePromo) {
        this.kodePromo = kodePromo;
    }

    public int getJumlah_produk() {
        return jumlah_produk;
    }

    public void setJumlah_produk(int jumlah_produk) {
        this.jumlah_produk = jumlah_produk;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class PanelVendorHistory extends JPanel {
    private JPanel header, content;
    private JLabel title, namaL, namaProdukL, alamatL, jenisPembayaranL, jenisPengirimanL, kodePromoL, totalHargaL, statusKirimL, total_produkL;
    private JLabel[] idTr, idProd, nama, alamat, noTelp, jenisPembayaran, jenisPengiriman, kodePromo, totalHarga, statusKirim, total_produk;
    private GridBagConstraints gbc;
    
    public PanelVendorHistory(){
        setLayout(new BorderLayout());
        header = new JPanel();
        header.setBackground(Color.WHITE);
                
        title = new JLabel("HISTORY");
        title.setFont(new Font("Calibri", Font.BOLD, 60));
        title.setForeground(new Color(2,91,149));
        header.add(title);
        
        content = new JPanel(new GridBagLayout());
        
//        namaL = new JLabel("Nama Customer        ");
//        namaL.setFont(new Font("Segoe UI", Font.BOLD, 12));
//        namaProdukL = new JLabel("Nama Produk          ");
//        namaProdukL.setFont(new Font("Segoe UI", Font.BOLD, 12));
//        alamatL = new JLabel("Alamat       ");
//        alamatL.setFont(new Font("Segoe UI", Font.BOLD, 12));
//        jenisPembayaranL = new JLabel("Pembayaran       ");
//        jenisPembayaranL.setFont(new Font("Segoe UI", Font.BOLD, 12));
//        jenisPengirimanL = new JLabel("Pengiriman       ");
//        jenisPengirimanL.setFont(new Font("Segoe UI", Font.BOLD, 12));
//        kodePromoL = new JLabel("Kode Promo       ");
//        kodePromoL.setFont(new Font("Segoe UI", Font.BOLD, 12));
//        total_produkL = new JLabel("Jumlah      ");
//        total_produkL.setFont(new Font("Segoe UI", Font.BOLD, 12));
//        totalHargaL = new JLabel("Total Harga       ");
//        totalHargaL.setFont(new Font("Segoe UI", Font.BOLD, 12));
//        statusKirimL = new JLabel("Status Kirim       ");
//        statusKirimL.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        //isi
        
        //counter
        
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridy = 2;
        
        //looping isi
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        content.add(namaL, gbc);
        
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        content.add(namaProdukL, gbc);
                
        gbc.gridx = 3;
        gbc.gridy = 0;
        content.add(alamatL, gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 0;
        content.add(jenisPembayaranL, gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 0;
        content.add(jenisPengirimanL, gbc);
        
        gbc.gridx = 6;
        gbc.gridy = 0;
        content.add(kodePromoL, gbc);
        
        gbc.gridx = 7;
        gbc.gridy = 0;
        content.add(total_produkL, gbc);
        
        gbc.gridx = 8;
        gbc.gridy = 0;
        content.add(totalHargaL, gbc);
        
        gbc.gridx = 9;
        gbc.gridy = 0;
        content.add(statusKirimL, gbc);
        
        add(header, BorderLayout.PAGE_START);
        add(content, BorderLayout.CENTER);
    }
}

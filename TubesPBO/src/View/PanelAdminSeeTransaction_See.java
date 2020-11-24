/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.UserManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class PanelAdminSeeTransaction_See extends JFrame {
    private JPanel header, panel;
    private GridBagConstraints gbc;
    private JLabel judul;
    private ImageIcon iconOk;
    private JButton btn_ok;
    private JLabel namaUserL, namaProdukL, alamatL, jenisPembayaranL, jenisPengirimanL, kodePromoL, totalHargaL, statusKirimL, jumlah_produkL;
    private JLabel namaUser[], namaProduk[], alamat[], jenisPembayaran[], jenisPengiriman[], kodePromo[], totalHarga[], statusKirim[], jumlah_produk[];
//    private List<Transaksi> listTransaksi;
    private int jumlahProduk = 0;
    
    private Image resizeImage(String url) {
        Image dimg = null;

        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        return dimg;
    }
    
    public PanelAdminSeeTransaction_See(String namaToko){
        setLayout(new BorderLayout());
        header = new JPanel();
        header.setBackground(Color.white);
        
        judul = new JLabel("Riwayat Transaksi dari " + namaToko);
        judul.setFont(new Font("Segoe UI", Font.BOLD, 30));
        judul.setForeground(Color.red);
        header.add(judul);
        
        iconOk = new ImageIcon(resizeImage("assets/ok.png"));
        btn_ok = new JButton(iconOk);
        btn_ok.setBorderPainted(false);
        btn_ok.setFocusPainted(false);
        btn_ok.setContentAreaFilled(false);
        btn_ok.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_ok.addMouseListener(
            new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent me){
                    dispose();
                }
            }
        );
        
        panel = new JPanel(new GridBagLayout());
//        listTransaksi = Controller.getListTransaksi();
        
        namaUserL = new JLabel("Nama User      ");
        namaUserL.setFont(new Font("Segoe UI", Font.BOLD, 12));
        namaProdukL = new JLabel("Nama Produk        ");
        namaProdukL.setFont(new Font("Segoe UI", Font.BOLD, 12));
        alamatL = new JLabel("Alamat      ");
        alamatL.setFont(new Font("Segoe UI", Font.BOLD, 12));
        jenisPembayaranL = new JLabel("Pembayaran       ");
        jenisPembayaranL.setFont(new Font("Segoe UI", Font.BOLD, 12));
        jenisPengirimanL = new JLabel("Pengiriman       ");
        jenisPengirimanL.setFont(new Font("Segoe UI", Font.BOLD, 12));
        kodePromoL = new JLabel("Kode Promo       ");
        kodePromoL.setFont(new Font("Segoe UI", Font.BOLD, 12));
        jumlah_produkL = new JLabel("Jumlah       ");
        jumlah_produkL.setFont(new Font("Segoe UI", Font.BOLD, 12));
        totalHargaL = new JLabel("Total Harga       ");
        totalHargaL.setFont(new Font("Segoe UI", Font.BOLD, 12));
        statusKirimL = new JLabel("Status Kirim       ");
        statusKirimL.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        //isi
//        namaUser = new JLabel[listTransaksi.size()];
//        namaProduk = new JLabel[listTransaksi.size()];
//        alamat = new JLabel[listTransaksi.size()];
//        jenisPembayaran = new JLabel[listTransaksi.size()];
//        jenisPengiriman = new JLabel[listTransaksi.size()];
//        kodePromo = new JLabel[listTransaksi.size()];
//        jumlah_produk = new JLabel[listTransaksi.size()];
//        totalHarga = new JLabel[listTransaksi.size()];
//        statusKirim = new JLabel[listTransaksi.size()];
        
        //counter
        int counter = 0;
        
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15,0,0,0);

        gbc.gridy = 1;
        
        //looping isi
//        for(int i=0;i<listTransaksi.size(); i++){
//            namaUser[counter] = new JLabel(listTransaksi.get(i).getNama());
//            namaUser[counter].setFont(new Font("Segoe UI", Font.PLAIN, 11));
//            namaProduk[counter] = new JLabel(listTransaksi.get(i).getNamaProduk());
//            namaProduk[counter].setFont(new Font("Segoe UI", Font.PLAIN, 11));
//            alamat[counter] = new JLabel();
//            alamat[counter].setFont(new Font("Segoe UI", Font.PLAIN, 11));
//            jenisPembayaran[counter] = new JLabel(listTransaksi.get(i).getJenisPembayaran());
//            jenisPembayaran[counter].setFont(new Font("Segoe UI", Font.PLAIN, 11));
//            jenisPengiriman[counter] = new JLabel(listTransaksi.get(i).getJenisPengiriman());
//            jenisPengiriman[counter].setFont(new Font("Segoe UI", Font.PLAIN, 11));
//            kodePromo[counter] = new JLabel(listTransaksi.get(i).getKodePromo());
//            kodePromo[counter].setFont(new Font("Segoe UI", Font.PLAIN, 11));
//            jumlah_produk[counter] = new JLabel(listTransaksi.get(i).getJumlahProduk());
//            jumlah_produk[counter].setFont(new Font("Segoe UI", Font.PLAIN, 11));
//            totalHarga[counter] = new JLabel(listTransaksi.get(i).getTotalHarga());
//            totalHarga[counter].setFont(new Font("Segoe UI", Font.PLAIN, 11));
//            statusKirim[counter] = new JLabel(listTransaksi.get(i).getStatusKirim());
//            statusKirim[counter].setFont(new Font("Segoe UI", Font.PLAIN, 11));
//            
//            gbc.gridx = 0;
//            panel.add(namaUser[counter], gbc);
//            
//            gbc.gridx = 1;
//            panel.add(namaProduk[counter], gbc);
//            
//            gbc.gridx = 2;
//            panel.add(alamat[counter], gbc);
//            
//            gbc.gridx = 3;
//            panel.add(jenisPembayaran[counter], gbc);
//            
//            gbc.gridx = 4;
//            panel.add(jenisPengiriman[counter], gbc);
//            
//            gbc.gridx = 5;
//            panel.add(kodePromo[counter], gbc);
//            
//            gbc.gridx = 6;
//            panel.add(totalHarga[counter], gbc);
//            
//            gbc.gridx = 7;
//            panel.add(statusKirim[counter], gbc);
//            
//            gbc.gridy++;
//            counter++;
//        }
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(namaUserL, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(namaProdukL, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(alamatL, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(jenisPembayaranL, gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 1;
        panel.add(jenisPengirimanL, gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 1;
        panel.add(kodePromoL, gbc);
        
        gbc.gridx = 6;
        gbc.gridy = 1;
        panel.add(totalHargaL, gbc);
        
        gbc.gridx = 7;
        gbc.gridy = 1;
        panel.add(statusKirimL, gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 0;
        panel.add(btn_ok, gbc);
        
        add(header,BorderLayout.PAGE_START);
        add(panel, BorderLayout.CENTER);
        
        setTitle("Lihat Riwayat Transaksi " + UserManager.getInstance().getUser().getNama());
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

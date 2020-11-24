/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Transaksi;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class PanelAdminCancelTransaction extends JPanel implements ActionListener {
    private JPanel header, panel;
    private JLabel title,judul, namaL, namaProdukL, alamatL, jenisPembayaranL, jenisPengirimanL, kodePromoL, totalHargaL, statusKirimL;
    private GridBagConstraints gbc;
    private ImageIcon iconSee, iconSee1;
//    private JButton btn_see[];
   private JLabel idTr[], namaProd[], nama[], idProd[], totalHarga[], jumlahProduk[], status[];
    private List<Transaksi> listTransaksi = Transaksi.getAllTransaksi();
    private JButton btn_see;
    private Image resizeImage(String url) {
        Image dimg = null;

        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(60, 20, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        return dimg;
    }
    
    public PanelAdminCancelTransaction(){
        setLayout(new BorderLayout());
        header = new JPanel();
        header.setBackground(Color.WHITE);
                
        title = new JLabel("CANCEL TRANSAKSI");
        title.setFont(new Font("Calibri", Font.BOLD, 60));
        title.setForeground(Color.red);
        header.add(title);
        
        panel = new JPanel(new GridBagLayout());
        //        listTransaksi = Controller.getListTransaksi();
        
        judul = new JLabel("Daftar Transaksi: ");
        judul.setFont(new Font("Segoe UI", Font.BOLD, 20));
        judul.setForeground(Color.red);
        
//        namaL = new JLabel("Nama Customer        ");
//        namaL.setFont(new Font("Segoe UI", Font.BOLD, 12));
//        namaProdukL = new JLabel("Nama Produk          ");
//        namaProdukL.setFont(new Font("Segoe UI", Font.BOLD, 12));
//        alamatL = new JLabel("Alamat       ");
//        alamatL.setFont(new Font("Segoe UI", Font.BOLD, 12));
//        jenisPembayaranL = new JLabel("Jenis Pembayaran       ");
//        jenisPembayaranL.setFont(new Font("Segoe UI", Font.BOLD, 12));
//        jenisPengirimanL = new JLabel("Jenis Pengiriman       ");
//        jenisPengirimanL.setFont(new Font("Segoe UI", Font.BOLD, 12));
//        kodePromoL = new JLabel("Kode Promo       ");
//        kodePromoL.setFont(new Font("Segoe UI", Font.BOLD, 12));
//        totalHargaL = new JLabel("Total Harga       ");
//        totalHargaL.setFont(new Font("Segoe UI", Font.BOLD, 12));
//        statusKirimL = new JLabel("Status Kirim       ");
//        statusKirimL.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        iconSee = new ImageIcon(resizeImage("assets/see.png"));
        
//        for (int i=0;i< listProd.size();i++){
//        
//        }
                
        //isi
//        namaUser = new JLabel[listTransaksi.size()];
//        namaProduk = new JLabel[listTransaksi.size()];
//        alamat = new JLabel[listTransaksi.size()];
//        jenisPembayaran = new JLabel[listTransaksi.size()];
//        jenisPengiriman = new JLabel[listTransaksi.size()];
//        kodePromo = new JLabel[listTransaksi.size()];
//        totalHarga = new JLabel[listTransaksi.size()];
//        statusKirim = new JLabel[listTransaksi.size()];
        
        //counter
        int counter = 0;
        
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridy = 2;
        
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
        gbc.gridy = 0;
        panel.add(judul, gbc);
        
        //delete soon
        gbc.gridx = 0;
        gbc.gridy = 2;
        btn_see = new JButton(iconSee);
        btn_see.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_see.setBorderPainted(false);
        btn_see.setFocusPainted(false);
        btn_see.setContentAreaFilled(false);
        btn_see.addActionListener(this);
        panel.add(btn_see, gbc);
        
//        gbc.gridx = 1;
//        gbc.gridy = 1;
//        content.add(namaL, gbc);
//        
//        gbc.gridx = 2;
//        gbc.gridy = 1;
//        content.add(namaProdukL, gbc);
//        
//        gbc.gridx = 3;
//        gbc.gridy = 1;
//        content.add(alamatL, gbc);
//        
//        gbc.gridx = 4;
//        gbc.gridy = 1;
//        content.add(jenisPembayaranL, gbc);
//        
//        gbc.gridx = 5;
//        gbc.gridy = 1;
//        content.add(jenisPengirimanL, gbc);
//        
//        gbc.gridx = 6;
//        gbc.gridy = 1;
//        content.add(kodePromoL, gbc);
//        
//        gbc.gridx = 7;
//        gbc.gridy = 1;
//        content.add(totalHargaL, gbc);
//        
//        gbc.gridx = 8;
//        gbc.gridy = 1;
//        content.add(statusKirimL, gbc);
        
        add(header, BorderLayout.PAGE_START);
        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int option = JOptionPane.showConfirmDialog(null, "Yakin ingin Cancel Transaksi", "Update", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.OK_OPTION){
            System.out.println("halo");
        } 
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.ListTransaksiToko;
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
import java.util.ArrayList;
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
    private JLabel idTr[], namaProd[], nama[], totalHarga[], jumlahProduk[], status[];
    private JLabel idTrL, namaProdukL, namaL, totalHargaL, jumlahProdukL, statusL;

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

    public PanelAdminSeeTransaction_See(String namaToko) {
        ArrayList<ListTransaksiToko> newList = ListTransaksiToko.getAllTransaksiToko(namaToko);
        setLayout(new BorderLayout());
        header = new JPanel();
        header.setBackground(Color.white);

        judul = new JLabel("Riwayat Transaksi dari " + namaToko);
        judul.setFont(new Font("Segoe UI", Font.BOLD, 30));
        judul.setForeground(Color.red);
        header.add(judul);

        iconOk = new ImageIcon(resizeImage("assets/cancel.png"));
        btn_ok = new JButton(iconOk);
        btn_ok.setBorderPainted(false);
        btn_ok.setFocusPainted(false);
        btn_ok.setContentAreaFilled(false);
        btn_ok.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_ok.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    dispose();
                }
            }
        );

        panel = new JPanel(new GridBagLayout());        

        idTrL = new JLabel("ID Transaksi       ");
        idTrL.setFont(new Font("Segoe UI", Font.BOLD, 16));
        namaProdukL = new JLabel("Nama Produk             ");
        namaProdukL.setFont(new Font("Segoe UI", Font.BOLD, 16));
        namaL = new JLabel("Nama User      ");
        namaL.setFont(new Font("Segoe UI", Font.BOLD, 16));
        totalHargaL = new JLabel("Total Harga        ");
        totalHargaL.setFont(new Font("Segoe UI", Font.BOLD, 16));
        jumlahProdukL = new JLabel("Jumlah       ");
        jumlahProdukL.setFont(new Font("Segoe UI", Font.BOLD, 16));
        statusL = new JLabel("Status    ");
        statusL.setFont(new Font("Segoe UI", Font.BOLD, 16));
        
        //isi
        idTr = new JLabel[newList.size()];
        nama = new JLabel[newList.size()];
        namaProd = new JLabel[newList.size()];
        totalHarga = new JLabel[newList.size()];
        jumlahProduk = new JLabel[newList.size()];
        status = new JLabel[newList.size()];
        
        //counter
        int counter = 0;

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 0, 0);

        gbc.gridy = 2;

        for (int i = 0; i < newList.size(); i++) {
            idTr[counter] = new JLabel("" + newList.get(i).getId_transaksi());
            idTr[counter].setFont(new Font("Segoe UI", Font.PLAIN, 14));
            namaProd[counter] = new JLabel(newList.get(i).getNama_prod());
            namaProd[counter].setFont(new Font("Segoe UI", Font.PLAIN, 14));
            nama[counter] = new JLabel(newList.get(i).getNamaPengguna());
            nama[counter].setFont(new Font("Segoe UI", Font.PLAIN, 14));
            jumlahProduk[counter] = new JLabel("" + newList.get(i).getJumlah_beli());
            jumlahProduk[counter].setFont(new Font("Segoe UI", Font.PLAIN, 14));
            totalHarga[counter] = new JLabel("" + newList.get(i).getTotal_harga());
            totalHarga[counter].setFont(new Font("Segoe UI", Font.PLAIN, 14));
            status[counter] = new JLabel(newList.get(i).getStatus());
            status[counter].setFont(new Font("Segoe UI", Font.PLAIN, 14));
            
            gbc.gridx = 0;
            panel.add(idTr[counter], gbc);
            
            gbc.gridx = 1;
            panel.add(namaProd[counter], gbc);
            
            gbc.gridx = 2;
            panel.add(nama[counter], gbc);
            
            gbc.gridx = 3;
            panel.add(totalHarga[counter], gbc);
            
            gbc.gridx = 4;
            panel.add(jumlahProduk[counter], gbc);
            
            gbc.gridx = 5;
            panel.add(status[counter], gbc);
            
            gbc.gridy++;
            counter++;
        }
        
 
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(idTrL, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(namaProdukL, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(namaL, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(totalHargaL, gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        panel.add(jumlahProdukL, gbc);

        gbc.gridx = 5;
        gbc.gridy = 1;
        panel.add(statusL, gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 0;
        panel.add(btn_ok, gbc);

        add(header, BorderLayout.PAGE_START);
        add(panel, BorderLayout.CENTER);

        setTitle("Lihat Riwayat Transaksi " + UserManager.getInstance().getUser().getNama());
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }
}

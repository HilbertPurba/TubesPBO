/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.*;
import Model.*;
import Controller.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javafx.scene.input.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.imageio.ImageIO;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */

public class PanelVendorTambahProduk extends JPanel implements ActionListener   {
    private JPanel header, content;
    private JLabel title, namaL, merkL, hargaL, stokL;
    private JTextField nama, merk, stok, harga;
    private ImageIcon iconOK;
    private JButton btn_submit;
    private GridBagConstraints gbc;
    
    private Image resizeImage(String url) {
        Image dimg = null;

        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        return dimg;
    }

    public PanelVendorTambahProduk() {
        setLayout(new BorderLayout());
        header = new JPanel();
        header.setBackground(java.awt.Color.white);
        
        title = new JLabel("TAMBAH PRODUK");
        title.setFont(new Font("Calibri", Font.BOLD, 60));
        title.setForeground(java.awt.Color.BLACK);
        title.setForeground(new Color(2,91,149));
        header.add(title);
        
        content = new JPanel(new GridBagLayout());
//        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        namaL = new JLabel("Nama Produk : ");
        namaL.setFont(new Font("Calibri", Font.BOLD, 35));
        namaL.setForeground(new Color(2,91,149));
        nama = new JTextField(12);
        nama.setFont(new Font("Calibri", Font.PLAIN, 27));
        
        merkL = new JLabel("Merk                : ");
        merkL.setFont(new Font("Calibri", Font.BOLD, 35));
        merkL.setForeground(new Color(2,91,149));
        merk = new JTextField(12);
        merk.setFont(new Font("Calibri", Font.PLAIN, 27));
        
        hargaL = new JLabel("Harga               :");
        hargaL.setFont(new Font("Calibri", Font.BOLD, 35));
        hargaL.setForeground(new Color(2,91,149));
        harga = new JTextField(12);
        harga.setFont(new Font("Calibri", Font.PLAIN, 27));
        
        stokL = new JLabel("Stok Awal       :");
        stokL.setFont(new Font("Calibri", Font.BOLD, 35));
        stokL.setForeground(new Color(2,91,149));
        stok = new JTextField(12);
        stok.setFont(new Font("Calibri", Font.PLAIN, 27));
        
        //Button
        iconOK = new ImageIcon(resizeImage("assets/ok.png"));
        btn_submit = new JButton(iconOK);
        btn_submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_submit.setIcon(iconOK);
        btn_submit.setBorderPainted(false);
        btn_submit.setFocusPainted(false);
        btn_submit.setContentAreaFilled(false);
        btn_submit.addActionListener(this);
        
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        content.add(namaL, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        content.add(nama, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        content.add(merkL, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        content.add(merk, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        content.add(hargaL, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        content.add(harga, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        content.add(stokL, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        content.add(stok, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        content.add(btn_submit, gbc);
        
        add(header, BorderLayout.PAGE_START);
        add(content, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = this.nama.getText();
        String merk = this.merk.getText();
        int harga = Integer.parseInt(this.harga.getText());
        int stok = Integer.parseInt(this.stok.getText());
        int a = JOptionPane.showOptionDialog(null, "Sudah Benar?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (a == JOptionPane.YES_OPTION) {
            if (nama.length() == 0 || merk.length() == 0 || harga == 0 || stok == 0) {
                JOptionPane.showMessageDialog(null, "Input semua data!", "Alert", JOptionPane.WARNING_MESSAGE);
            } else {
                Produk newProduk = new Produk();
                List<Produk> listProduk = new ArrayList<>();
                newProduk.setNamaProduk(nama);
                newProduk.setMerk(merk);
                newProduk.setHarga(harga);
                newProduk.setStok(stok);
                listProduk.add(newProduk);
                if (Controller.insertNewProduk(newProduk)) {
                    JOptionPane.showMessageDialog(null, "Data Produk telah tersimpan!");
//                    tambahProduk.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Insert Data Gagal!", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
//        DashboardVendor dashboardVendor = new DashboardVendor();
//        dashboardVendor.getFrame().dispose();
//        new DashboardVendor();
    }
}

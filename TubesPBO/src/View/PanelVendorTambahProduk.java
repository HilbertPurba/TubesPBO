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
        title.setFont(new Font("Calibri", Font.BOLD, 72));
        title.setForeground(java.awt.Color.BLACK);
        title.setForeground(new Color(2,91,149));
        header.add(title);
        
        content = new JPanel(new GridBagLayout());
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        namaL = new JLabel("Nama Produk ");
        namaL.setFont(new Font("Calibri", Font.BOLD, 42));
        namaL.setForeground(new Color(2,91,149));
        namaL.setBounds(150, 130, 300, 40);
        nama = new JTextField();
        nama.setBounds(465, 130, 350, 40);
        nama.setBorder(null);
        
        merkL = new JLabel("Merek Produk ");
        merkL.setFont(new Font("Calibri", Font.BOLD, 42));
        merkL.setForeground(new Color(2,91,149));
        merkL.setBounds(150, 190, 300, 40);
        merk = new JTextField();
        merk.setBounds(465, 190, 350, 40);
        merk.setBorder(null);
        
        hargaL = new JLabel("Harga Produk ");
        hargaL.setFont(new Font("Calibri", Font.BOLD, 42));
        hargaL.setForeground(new Color(2,91,149));
        hargaL.setBounds(150, 250, 300, 40);
        harga = new JTextField();
        harga.setBounds(465, 250, 350, 40);
        harga.setBorder(null);
        
        stokL = new JLabel("Stok Awal ");
        stokL.setFont(new Font("Calibri", Font.BOLD, 42));
        stokL.setForeground(new Color(2,91,149));
        stokL.setBounds(150, 310, 300, 40);
        stok = new JTextField();
        stok.setBounds(465, 310, 350, 40);
        stok.setBorder(null);
        
        //Button
        iconOK = new ImageIcon(resizeImage("assets/ok.png"));
        btn_submit = new JButton(iconOK);
        btn_submit.setBounds(445,380,100,100);
        btn_submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_submit.setIcon(iconOK);
        btn_submit.setBorderPainted(false);
        btn_submit.setFocusPainted(false);
        btn_submit.setContentAreaFilled(false);
        btn_submit.addActionListener(this);

        add(namaL);
        add(nama);
        add(merkL);
        add(merk);
        add(hargaL);
        add(harga);
        add(stokL);
        add(stok);
        add(btn_submit);
        add(header, BorderLayout.PAGE_START);
        add(content);
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
                Vendor newVendor = new Vendor();
                newProduk.setNamaProduk(nama);
                newProduk.setMerk(merk);
                newProduk.setHarga(harga);
                newProduk.setStok(stok);
                listProduk.add(newProduk);
                newVendor.setListProduk(listProduk);
                if (Controller.insertNewProduk(newProduk)) {
                    JOptionPane.showMessageDialog(null, "Data Produk telah tersimpan!");
//                    tambahProduk.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Insert Data Gagal!", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
}

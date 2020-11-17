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
import java.util.List;

/**
 *
 * @author Gilbert
 */

public class PanelVendorTambahProduk implements ActionListener {

    JFrame tambahProduk = new JFrame("Menu Tambah Produk");
    JLabel namaLabel, merkLabel, hargaLabel, stokLabel;
    JTextField nama, merk, stok, harga;
    JPanel Panel;
    JButton submitButton;

    public PanelVendorTambahProduk() {
        tambahProduk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tambahProduk.setSize(300, 300);

        Panel = new JPanel();
        Panel.setLayout(null);

        JLabel judul1 = new JLabel("Masukan Produk Baru");
        judul1.setBounds(40, 40, 400, 40);

        namaLabel = new JLabel("Nama Produk             :");
        merkLabel = new JLabel("Merek Produk            :");
        hargaLabel = new JLabel("Harga Produk          :");
        stokLabel = new JLabel("Stok Awal              :");

        namaLabel.setBounds(40, 130, 150, 40);
        nama = new JTextField();
        nama.setBounds(190, 130, 350, 40);
        nama.setBorder(null);

        merkLabel.setBounds(40, 190, 150, 40);
        merk = new JTextField();
        merk.setBounds(190, 190, 350, 40);
        merk.setBorder(null);

        hargaLabel.setBounds(40, 250, 150, 40);
        harga = new JTextField();
        harga.setBounds(190, 250, 350, 40);
        harga.setBorder(null);

        stokLabel.setBounds(40, 310, 150, 40);
        stok = new JTextField();
        stok.setBounds(190, 310, 350, 40);
        stok.setBorder(null);

        submitButton = new JButton("Submit");
        submitButton.setBounds(280, 360, 150, 50);
        submitButton.addActionListener(this);

        Panel.add(judul1);
        Panel.add(namaLabel);
        Panel.add(merkLabel);
        Panel.add(hargaLabel);
        Panel.add(stokLabel);
        Panel.add(nama);
        Panel.add(merk);
        Panel.add(harga);
        Panel.add(stok);
        Panel.add(submitButton);

        tambahProduk.add(Panel);
        tambahProduk.getContentPane().setBackground(Color.WHITE);
        tambahProduk.setExtendedState(JFrame.MAXIMIZED_BOTH);
        tambahProduk.setLocationRelativeTo(null);
        tambahProduk.setVisible(true);
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
                    tambahProduk.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Insert Data Gagal!", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
}
=======
public class PanelVendorTambahProduk extends JPanel {

//    JFrame registrasiFrame = new JFrame("Insert Product Screen");
//    JLabel namaLabel, merkLabel, hargaLabel, stokLabel;
//    JTextField nama, merk, stok,harga;
//    JPanel Panel;
//    JButton submitButton;

    public PanelVendorTambahProduk() {
    }
}

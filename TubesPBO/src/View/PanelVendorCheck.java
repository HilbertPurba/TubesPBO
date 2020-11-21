/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JPanel;
import Controller.Controller;
import Model.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Lenovo
 */
public class PanelVendorCheck extends JPanel {

    JFrame CekStok = new JFrame("Cek Stok");
    JLabel judul, isi;

    public PanelVendorCheck() {
        Produk produk = new Produk();
        CekStok.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        judul = new JLabel("Daftar Produk:");
        judul.setBounds(10, 10, 200, 40);

        isi = new JLabel();
        isi.setBounds(10, 30, 690, 720);
        isi.setText(produk.toString());

        CekStok.add(judul);
        CekStok.add(isi);
        CekStok.setSize(700, 770);
        CekStok.getContentPane().setBackground(Color.WHITE);
        CekStok.setLocationRelativeTo(null);
        CekStok.setLayout(null);
        CekStok.setVisible(true);
    }
}

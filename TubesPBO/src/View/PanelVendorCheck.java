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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
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

    private JPanel header,content;
    private JLabel headerTitle, contentTitle, namaL, stokL;
    private JLabel[] nama, stok;
    private JLabel isi;
    private GridBagConstraints gbc;
    private ArrayList<Produk> listProd = Controller.getProdukToko(UserManager.getInstance().getUser().getID());
    private int jumlahProduk =0;

    public PanelVendorCheck() {
        setLayout(new BorderLayout());
        header = new JPanel();
        header.setBackground(Color.white);
        
        headerTitle = new JLabel("CHECK STOCK - MEGACOMP");
        headerTitle.setFont(new Font("Calibri", Font.BOLD, 60));
        headerTitle.setForeground(new Color(2,91,149));
        header.add(headerTitle);
        
        content = new JPanel(new GridBagLayout());
        
        contentTitle = new JLabel("Daftar Produk : ");
        contentTitle.setFont(new Font("Segoe UI", Font.BOLD, 35));
        contentTitle.setForeground(new Color(2,91,149));
//        contentTitle.setBounds(350, 130, 450, 40);
        
//        content = new JPanel();
//        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        for (int i = 0;i < listProd.size(); i++){
            jumlahProduk++;
            if (jumlahProduk == 6) {
                break;
            }
        }

        namaL = new JLabel("Nama Produk");
        namaL.setFont(new Font("Segoe UI", Font.BOLD, 25));
        stokL = new JLabel("Stok");
        stokL.setFont(new Font("Segoe UI", Font.BOLD, 25));
//        nama = new JLabel(UserManager.getInstance().getProduk().getNamaProduk());
        nama = new JLabel[jumlahProduk];
//        nama.setFont(new Font("Segoe UI", Font.BOLD, 25));
//        stok = new JLabel(String.valueOf(UserManager.getInstance().getProduk().getStok()));
        stok = new JLabel[jumlahProduk];
//        stok.setFont(new Font("Segoe UI", Font.BOLD, 25));

        int counter = 0;
        
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridy = 2;

        for (int i =0;i<jumlahProduk;i++){
            nama[counter] = new JLabel (listProd.get(i).getNamaProduk());
            nama[counter].setFont(new Font("Segoe UI", Font.PLAIN, 25));
            stok[counter] = new JLabel (String.valueOf(listProd.get(i).getStok()));
            stok[counter].setFont(new Font("Segoe UI", Font.PLAIN, 25));

            gbc.gridx = 0;
            content.add(nama[counter], gbc);
            

            gbc.gridx = 1;
            content.add(stok[counter], gbc);
            gbc.gridy++;

            counter++;
        }
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        content.add(contentTitle,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        content.add(namaL, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        content.add(stokL, gbc);
        

//        Produk produk = new Produk();
//
//        isi = new JLabel();
//        isi.setFont(new Font("Segoe UI", Font.PLAIN, 25));
//        isi.setBounds(150, 50, 800, 520);
//        isi.setText(produk.toString());
        
//        add(contentTitle);
//        add(isi);
        
        add(header, BorderLayout.PAGE_START);
        add(content, BorderLayout.CENTER);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author hilbert
 */
public class PanelCustomerHome extends JPanel {

    //CardLayout component
    private JPanel header, content;
    private JLabel title, desc;
    private JLabel[] namaProd, merkProd, hargaProd, stokProd;
    private JComboBox[] banyakProduk;
    private ArrayList<Produk> listProd = Controller.getAllProduk();
    private int jumlahProduk = 0;

    public PanelCustomerHome() {
        setLayout(new BorderLayout());
        header = new JPanel();
        header.setBackground(java.awt.Color.white);

//        + UserManager.getInstance().getUser().getNama()
        title = new JLabel("SELAMAT DATANG, ");
        title.setFont(new Font("Calibri", Font.BOLD, 36));
        title.setForeground(java.awt.Color.BLACK);
        header.add(title);

        content = new JPanel();
        desc = new JLabel("Pilih Produk: ");

        for (int i = 0; i < listProd.size(); i++) {
            jumlahProduk++;
        }
        namaProd = new JLabel[jumlahProduk];
        merkProd = new JLabel[jumlahProduk];
        hargaProd = new JLabel[jumlahProduk];
        stokProd = new JLabel[jumlahProduk];

        int x1 = 150, x2 = 320, x3 = 250, x4 = 340;
        int y1 = 80, y2 = 84, y3 = 80, y4 = 84;
        int counter = 0;
        for (int i = 0; i < listProd.size(); i++) {
            namaProd[counter] = new JLabel(listProd.get(i).getNamaProduk());
            merkProd[counter] = new JLabel(listProd.get(i).getMerk());
            hargaProd[counter] = new JLabel("Rp. " + listProd.get(i).getHarga());
            stokProd[counter] = new JLabel("Jumlah Produk = " + listProd.get(i).getStok());
            namaProd[counter].setBounds(x1, y1, 150, 25);
            merkProd[counter].setBounds(x2, y2, 150, 25);
            hargaProd[counter].setBounds(x3, y3, 80, 20);
            stokProd[counter].setBounds(x4, y4, 150, 25);
            content.add(namaProd[counter]);
            content.add(merkProd[counter]);
            content.add(hargaProd[counter]);
            content.add(stokProd[counter]);
            y1 += 40;
            y2 += 40;
            y3 += 40;
            y4 += 40;
            if (y1 > 250) {
                y1 = 80;
                y2 = 84;
                y3 = 80;
                y4 = 84;
                x1 += 260;
                x2 += 260;
                x3 += 260;
                x4 += 260;
            }
            counter++;
        }
        desc.setBounds(150,40,250,25);
        content.add(desc);

        add(header, BorderLayout.PAGE_START);
        add(content, BorderLayout.CENTER);
    }
}

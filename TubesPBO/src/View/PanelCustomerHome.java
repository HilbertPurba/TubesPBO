/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class PanelCustomerHome extends JPanel implements ActionListener {

    //CardLayout component
    private JPanel header, content;
    private JLabel title, desc;
    private JLabel namaL, merkL, hargaL, stokL;
    private JLabel[] namaProd, merkProd, hargaProd, stokProd;
    private ImageIcon iconAdd;
    private JButton[] btn_add;
    private JComboBox[] banyakProduk;
    private ArrayList<Produk> listProd = Controller.getAllProduk();
    private int jumlahProduk = 0;

    private Image resizeImage(String url) {
        Image dimg = null;

        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(90, 25, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        return dimg;
    }

    public PanelCustomerHome() {
        setLayout(new BorderLayout());
        header = new JPanel();
        header.setBackground(java.awt.Color.white);
        title = new JLabel("SELAMAT DATANG, " + UserManager.getInstance().getUser().getNama().toUpperCase());
        title.setFont(new Font("Calibri", Font.BOLD, 60));
        title.setForeground(new Color(253, 170, 0));
        header.add(title);

        content = new JPanel();
        desc = new JLabel("Pilih Produk: ");
        desc.setFont(new Font("Calibri", Font.BOLD, 56));
        desc.setBounds(100, 100, 550, 75);
        desc.setForeground(new Color(253,170,0));
        add(desc);

        iconAdd = new ImageIcon(resizeImage("assets/add.png"));

        for (int i = 0; i < listProd.size(); i++) {
            jumlahProduk++;
            if (jumlahProduk == 5){
                break;
            }
        }
        namaProd = new JLabel[jumlahProduk];
        merkProd = new JLabel[jumlahProduk];
        hargaProd = new JLabel[jumlahProduk];
        stokProd = new JLabel[jumlahProduk];
        btn_add = new JButton[jumlahProduk];
        int x1 = 70, x2 = 350, x3 = 520, x4 = 700, x5 = 800;
        int y1 = 225, y2 = 225, y3 = 225, y4 = 225, y5 = 225;
        for (int i = 0; i < jumlahProduk; i++) {
            namaProd[i] = new JLabel(listProd.get(i).getNamaProduk());
            namaProd[i].setFont(new Font("Segoe UI", Font.PLAIN, 14));
            merkProd[i] = new JLabel(listProd.get(i).getMerk());
            merkProd[i].setFont(new Font("Segoe UI", Font.PLAIN, 14));
            hargaProd[i] = new JLabel("Rp. " + listProd.get(i).getHarga());
            hargaProd[i].setFont(new Font("Segoe UI", Font.PLAIN, 14));
            stokProd[i] = new JLabel("" + listProd.get(i).getStok());
            stokProd[i].setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btn_add[i] = new JButton(iconAdd);

            namaProd[i].setBounds(x1, y1, 300, 25);
            merkProd[i].setBounds(x2, y2, 150, 25);
            hargaProd[i].setBounds(x3, y3, 120, 20);
            stokProd[i].setBounds(x4, y4, 150, 25);
            btn_add[i].setBounds(x5, y5, 90, 25);

            add(namaProd[i]);
            add(merkProd[i]);
            add(hargaProd[i]);
            add(stokProd[i]);
            add(btn_add[i]);

            y1 += 60;
            y2 += 60;
            y3 += 60;
            y4 += 60;
            y5 += 60;
            btn_add[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn_add[i].setBorderPainted(false);
            btn_add[i].setFocusPainted(false);
            btn_add[i].setContentAreaFilled(false);
            btn_add[i].addActionListener(this);
        }

        namaL = new JLabel("Nama Produk");
        namaL.setFont(new Font("Calibri", Font.BOLD, 25));
        namaL.setForeground(new Color(253, 170, 0));
        namaL.setBounds(70, 175, 300, 40);

        merkL = new JLabel("Merk ");
        merkL.setFont(new Font("Calibri", Font.BOLD, 25));
        merkL.setForeground(new Color(253, 170, 0));
        merkL.setBounds(350, 175, 300, 40);

        hargaL = new JLabel("Harga ");
        hargaL.setFont(new Font("Calibri", Font.BOLD, 25));
        hargaL.setForeground(new Color(253, 170, 0));
        hargaL.setBounds(520, 175, 300, 40);

        stokL = new JLabel("Stok ");
        stokL.setFont(new Font("Calibri", Font.BOLD, 25));
        stokL.setForeground(new Color(253, 170, 0));
        stokL.setBounds(675, 175, 300, 40);

        add(namaL);
        add(merkL);
        add(hargaL);
        add(stokL);

        add(header, BorderLayout.PAGE_START);
        add(content, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Keranjang keranjang = new Keranjang();
        ProdukBeli newProdukBeli = new ProdukBeli();
        for (int i = 0; i < jumlahProduk; i++) {
            if (ae.getSource() == btn_add[i]) {
                int jumlahBeli = Integer.parseInt(JOptionPane.showInputDialog(null, "Masukkan jumlah pembelian " + namaProd[i].getText() + ": "));
                if (jumlahBeli > Integer.parseInt(stokProd[i].getText())) {
                    JOptionPane.showMessageDialog(null, "Pembelian melebihi batas");
                } else if (Integer.parseInt(stokProd[i].getText()) == 0) {
                    JOptionPane.showMessageDialog(null, "Stok Habis");
                } else {
                    newProdukBeli.setHarga(Integer.parseInt(hargaProd[i].getText().substring(4)));
                    newProdukBeli.setNama(namaProd[i].getText());
                    newProdukBeli.setJumlahBeli(jumlahBeli);
                    ProdukBeliManager.getInstance().setProdukBeli(newProdukBeli);
                }
            }
        }
        keranjang.setId_user(UserManager.getInstance().getUser().getID());
        keranjang.setId_prod(ProdukBeliManager.getInstance().getProdukBeli().getIdProduk());
        keranjang.setNama_prod(ProdukBeliManager.getInstance().getProdukBeli().getNama());
        keranjang.setHarga_total(ProdukBeliManager.getInstance().getProdukBeli().countTotalHarga(newProdukBeli));
        keranjang.setJumlah_total(ProdukBeliManager.getInstance().getProdukBeli().getJumlahBeli());
        KeranjangManager.getInstance().setKeranjang(keranjang);
        if (Controller.insertNewKeranjang(keranjang)) {
            JOptionPane.showMessageDialog(null, "Insert keranjang berhasil");
        } else {
            JOptionPane.showMessageDialog(null, "Insert Keranjang gagal");
        }
    }
}

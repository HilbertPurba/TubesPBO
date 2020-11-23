/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.ProdukBeli;
import Model.UserManager;
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
import javax.swing.JPanel;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class PanelCustomerKeranjang extends JPanel implements ActionListener {

    private JPanel header, content;
    private JLabel namaL, merkL, jumlahL, hargaL;
    private JLabel title, desc, namaProd[], merkProd[], jumlahBeliProd[], hargaProd[];
    private JButton btn_checkout[];
    private GridBagConstraints gbc;
    private ImageIcon iconCheckout, iconCheckout1;
    private List<ProdukBeli> listProd;
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

    public PanelCustomerKeranjang() {
        setLayout(new BorderLayout());
        header = new JPanel();
        header.setBackground(java.awt.Color.white);

        title = new JLabel("KERANJANG");
        title.setFont(new Font("Calibri", Font.BOLD, 60));
        title.setForeground(new Color(253,170,0));
        header.add(title);

        content = new JPanel(new GridBagLayout());
        listProd = Controller.getProdukBeli();
        
        desc = new JLabel("Keranjang Kamu: ");
        desc.setFont(new Font("Segoe UI", Font.BOLD, 35));
        desc.setForeground(new Color(253,170,0));
        
        iconCheckout = new ImageIcon(resizeImage("assets/checkout.png"));

        namaL = new JLabel("Nama Produk");
        namaL.setFont(new Font("Segoe UI", Font.BOLD, 25));
        merkL = new JLabel("Merk       ");
        merkL.setFont(new Font("Segoe UI", Font.BOLD, 25));
        jumlahL = new JLabel("Jumlah       ");
        jumlahL.setFont(new Font("Segoe UI", Font.BOLD, 25));
        hargaL = new JLabel("Harga Produk");
        hargaL.setFont(new Font("Segoe UI", Font.BOLD, 25));
        
        namaProd = new JLabel[listProd.size()];
        merkProd = new JLabel[listProd.size()];
        jumlahBeliProd = new JLabel[listProd.size()];
        hargaProd = new JLabel[listProd.size()];
        btn_checkout = new JButton[listProd.size()];
        
        int counter = 0;
        
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridy = 2;
        
        for (int i = 0; i < listProd.size(); i++) {
            namaProd[counter] = new JLabel(listProd.get(i).getNama());
            namaProd[counter].setFont(new Font("Segoe UI", Font.PLAIN, 18));
            merkProd[counter] = new JLabel(listProd.get(i).getMerk());
            merkProd[counter].setFont(new Font("Segoe UI", Font.PLAIN, 18));
            jumlahBeliProd[counter] = new JLabel(String.valueOf(listProd.get(i).getJumlahBeli()));
            jumlahBeliProd[counter].setFont(new Font("Segoe UI", Font.PLAIN, 18));
            hargaProd[counter] = new JLabel("Rp. " + String.valueOf(listProd.get(i).getHarga()));
            hargaProd[counter].setFont(new Font("Segoe UI", Font.PLAIN, 18));
            
            btn_checkout[counter] = new JButton(iconCheckout);
            btn_checkout[counter].setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn_checkout[counter].setBorderPainted(false);
            btn_checkout[counter].setFocusPainted(false);
            btn_checkout[counter].setContentAreaFilled(false);
            btn_checkout[counter].addActionListener(this);
            
            gbc.gridx = 0;
            content.add(namaProd[counter], gbc);
            
            gbc.gridx = 1;
            content.add(merkProd[counter], gbc);
            
            gbc.gridx = 2;
            content.add(jumlahBeliProd[counter], gbc);
            
            gbc.gridx = 3;
            content.add(hargaProd[counter], gbc);
            
            gbc.gridx = 4;
            content.add(btn_checkout[counter], gbc);
            
            gbc.gridy++;
            counter++;
        }
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        content.add(desc, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        content.add(namaL, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipady = 9;
        content.add(merkL, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        content.add(jumlahL, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 1;
        content.add(hargaL, gbc);
        

        
        

        add(header, BorderLayout.PAGE_START);
        add(content, BorderLayout.CENTER);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }

    
}

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
    private JLabel headerTitle, contentTitle, isi;

    public PanelVendorCheck() {
        setLayout(new BorderLayout());
        header = new JPanel();
        header.setBackground(Color.white);
        
        headerTitle = new JLabel("CHECK STOCK - MEGACOMP");
        headerTitle.setFont(new Font("Calibri", Font.BOLD, 72));
        headerTitle.setForeground(new Color(2,91,149));
        header.add(headerTitle);
        
        contentTitle = new JLabel("Daftar Produk : ");
        contentTitle.setFont(new Font("Segoe UI", Font.BOLD, 42));
        contentTitle.setForeground(new Color(2,91,149));
        contentTitle.setBounds(350, 130, 450, 40);
        
        content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        
        Produk produk = new Produk();

        isi = new JLabel();
        isi.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        isi.setBounds(150, 0, 800, 520);
        isi.setText(produk.toString());
        
        add(contentTitle);
        add(isi);
        
        add(header, BorderLayout.PAGE_START);
        add(content);
    }
}

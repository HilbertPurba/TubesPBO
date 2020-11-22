/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Model.*;
import Controller.*;
import java.awt.CardLayout;
import java.awt.Color;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class DashboardVendor {
    //CardLayout Component
    private CardLayout cl;
    private PanelVendorCheck panelCheck;
    private PanelVendorTambahProduk panelTambahProduk;
    private PanelVendorHistory panelHistory;
    private PanelVendorAccount panelAccount;
    
    //Frame Component
    private JFrame frame;
    
    //Panel Component
    private JPanel clPanel, panelNav;
    private JButton  btn_check,btn_addProduct,btn_history, btn_account;
    private ImageIcon iconCheckStock,iconAddProduct, iconHistory,  iconAccount;
    private ImageIcon iconCheckStock1,iconAddProduct1, iconHistory1,  iconAccount1;
    private ImageIcon iconCheckStock2,iconAddProduct2, iconHistory2,  iconAccount2;
    
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
    
    public DashboardVendor() {
        panelNav = new JPanel();
        panelNav.setBackground(Color.white);
        
        // Check Stock
        iconCheckStock = new ImageIcon(resizeImage("assets/check.png"));
        iconCheckStock1 = new ImageIcon(resizeImage("assets/check1.png"));
        iconCheckStock2 = new ImageIcon(resizeImage("assets/check2.png"));
        btn_check = new JButton(iconCheckStock);
        btn_check.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_check.setIcon(iconCheckStock1);
        btn_check.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        btn_check.setIcon(iconCheckStock2);
                        cl.show(clPanel, "panelCheck");
                        frame.setTitle("Menu Check Stock");
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btn_check.setIcon(iconCheckStock);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btn_check.setIcon(iconCheckStock1);
                    }
                }
        );
        btn_check.setBorderPainted(false);
        btn_check.setFocusPainted(false);
        btn_check.setContentAreaFilled(false);
        panelNav.add(btn_check);
        
        // Add Product
        iconAddProduct2 = new ImageIcon(resizeImage("assets/addProduct2.png"));
        iconAddProduct1 = new ImageIcon(resizeImage("assets/addProduct1.png"));
        iconAddProduct = new ImageIcon(resizeImage("assets/addProduct.png"));
        btn_addProduct = new JButton(iconAddProduct);
        btn_addProduct.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_addProduct.setIcon(iconAddProduct1);
        btn_addProduct.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        btn_addProduct.setIcon(iconAddProduct2);
                        cl.show(clPanel, "panelTambahProduk");
                        frame.setTitle("Menu Tambah Produk");
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btn_addProduct.setIcon(iconAddProduct);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btn_addProduct.setIcon(iconAddProduct1);
                    }
                }
        );
        btn_addProduct.setBorderPainted(false);
        btn_addProduct.setFocusPainted(false);
        btn_addProduct.setContentAreaFilled(false);
        panelNav.add(btn_addProduct);
        
        // Check Riwayat Transaksi
        iconHistory = new ImageIcon(resizeImage("assets/history.png"));
        iconHistory1 = new ImageIcon(resizeImage("assets/history1.png"));
        iconHistory2 = new ImageIcon(resizeImage("assets/history2.png"));
        btn_history = new JButton(iconHistory);
        btn_history.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_history.setIcon(iconHistory1);
        btn_history.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        btn_history.setIcon(iconHistory2);
                        cl.show(clPanel, "panelHistory");
                        frame.setTitle("Menu History Transaksi");
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btn_history.setIcon(iconHistory);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btn_history.setIcon(iconHistory1);
                    }
                }
        );
        btn_history.setBorderPainted(false);
        btn_history.setFocusPainted(false);
        btn_history.setContentAreaFilled(false);
        panelNav.add(btn_history);
        
        // Account
        iconAccount = new ImageIcon(resizeImage("assets/account.png"));
        iconAccount1 = new ImageIcon(resizeImage("assets/account1.png"));
        iconAccount2 = new ImageIcon(resizeImage("assets/account2.png"));
        btn_account = new JButton(iconAccount);
        btn_account.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_account.setIcon(iconAccount1);
        btn_account.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        btn_account.setIcon(iconAccount2);
                        cl.show(clPanel, "panelAccount");
                        frame.setTitle("Menu Account");
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btn_account.setIcon(iconAccount);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btn_account.setIcon(iconAccount1);
                    }
                }
        );
        btn_account.setBorderPainted(false);
        btn_account.setFocusPainted(false);
        btn_account.setContentAreaFilled(false);
        panelNav.add(btn_account);
        
        cl = new CardLayout();
        clPanel = new JPanel();
        clPanel.setLayout(cl);
        
        panelCheck = new PanelVendorCheck();
        panelTambahProduk = new PanelVendorTambahProduk();
        panelHistory = new PanelVendorHistory();
        panelAccount = new PanelVendorAccount();
        
        clPanel.add(panelCheck, "panelCheck");        
        clPanel.add(panelTambahProduk, "panelTambahProduk");
        clPanel.add(panelHistory, "panelHistory");
        clPanel.add(panelAccount, "panelAccount");

        frame = new JFrame("Menu Utama");
        frame.add(clPanel);
        frame.add(panelNav, BorderLayout.PAGE_END);
        frame.setSize(1000,1000);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

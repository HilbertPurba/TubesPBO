/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Cursor;
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

/**
 *
 * @author Lenovo
 */
public class MenuVendor {
    private JFrame frame;
    private JPanel panelTop, panelNav, panelContent, panelBottom;
    private JButton btn_addProduct, btn_check, btn_history, btn_account;
    private ImageIcon iconAddProduct, iconHistory, iconCheckStock, iconAccount;
    private ImageIcon iconAddProduct1, iconHistory1, iconCheckStock1, iconAccount1;
    private JLabel title;
    
    public Image resizeImage(String url) {
        Image dimg = null;

        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        return dimg;
    }
    
    public MenuVendor() {
        // Panel Set Up
        frame = new JFrame("Menu Vendor");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        frame.setResizable(true);
//        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelTop = new JPanel();
        panelTop.setSize(JFrame.MAXIMIZED_BOTH, 80);
        frame.add(panelTop, BorderLayout.NORTH);
        
        title = new JLabel("Selamat Datang, Vendor!");
        title.setSize(400, 80);
        panelTop.add(title);
        
        panelBottom = new JPanel();
        panelBottom.setSize(400, 80);
        panelBottom.setBackground(java.awt.Color.white);
        frame.add(panelBottom, BorderLayout.SOUTH);
        
        // Add Product
        iconAddProduct1 = new ImageIcon(resizeImage("assets/addProduct1.png"));
        iconAddProduct = new ImageIcon(resizeImage("assets/addProduct.png"));
        btn_addProduct = new JButton(iconAddProduct);
        btn_addProduct.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_addProduct.setIcon(iconAddProduct1);
        btn_addProduct.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        
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
        panelBottom.add(btn_addProduct);
        
        // Check Riwayat Transaksi
        iconHistory = new ImageIcon(resizeImage("assets/history.png"));
        iconHistory1 = new ImageIcon(resizeImage("assets/history1.png"));
        btn_history = new JButton(iconHistory);
        btn_history.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_history.setIcon(iconHistory1);
        btn_history.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        
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
        panelBottom.add(btn_history);
        
        // Check Stock
        iconCheckStock = new ImageIcon(resizeImage("assets/check.png"));
        iconCheckStock1 = new ImageIcon(resizeImage("assets/check1.png"));
        btn_check = new JButton(iconCheckStock);
        btn_check.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_check.setIcon(iconCheckStock1);
        btn_check.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        
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
        panelBottom.add(btn_check);
        
        // Account
        iconAccount = new ImageIcon(resizeImage("assets/account.png"));
        iconAccount1 = new ImageIcon(resizeImage("assets/account1.png"));
        btn_account = new JButton(iconAccount);
        btn_account.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_account.setIcon(iconAccount1);
        btn_account.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        
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
        panelBottom.add(btn_account);
        
        frame.setVisible(true);
    }
}

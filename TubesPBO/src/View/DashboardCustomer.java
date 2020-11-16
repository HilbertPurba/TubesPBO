/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
import javax.swing.JPanel;

/**
 *
 * @author hilbert
 */
public class DashboardCustomer {
    //CardLayout component
    private CardLayout cl;
    private PanelCustomer panelCustomer;
    private PanelKeranjang panelKeranjang;
    private PanelAccount panelAccount;
    
    //Frame component
    private JFrame frame;
    
    //Panel compoenent
    private JPanel clPanel, panelNav;
    private JButton btn_home, btn_keranjang, btn_account;
    private ImageIcon iconHome, iconKeranjang, iconAkun;
    private ImageIcon iconHome1, iconKeranjang1, iconAkun1;
    private ImageIcon iconHome2, iconKeranjang2, iconAkun2;
    
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
    
    
    
    public DashboardCustomer() {
        panelNav = new JPanel();
        panelNav.setBackground(java.awt.Color.white);
        
        // Home
        iconHome = new ImageIcon(resizeImage("assets/home.png"));
        iconHome1 = new ImageIcon(resizeImage("assets/home1.png"));
        iconHome2 = new ImageIcon(resizeImage("assets/home2.png"));
        btn_home = new JButton(iconHome);
        btn_home.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_home.setIcon(iconHome1);
        btn_home.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        btn_home.setIcon(iconHome2);
                        cl.show(clPanel, "panelCustomer");
                        frame.setTitle("Main Menu");
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btn_home.setIcon(iconHome);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btn_home.setIcon(iconHome1);
                    }
                }
        );
        btn_home.setBorderPainted(false);
        btn_home.setFocusPainted(false);
        btn_home.setContentAreaFilled(false);
        panelNav.add(btn_home);
        
        // Keranjang
        iconKeranjang = new ImageIcon(resizeImage("assets/keranjang.png"));
        iconKeranjang1 = new ImageIcon(resizeImage("assets/keranjang1.png"));
        iconKeranjang2 = new ImageIcon(resizeImage("assets/keranjang2.png"));
        btn_keranjang = new JButton(iconKeranjang);
        btn_keranjang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_keranjang.setIcon(iconKeranjang1);
        btn_keranjang.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        btn_keranjang.setIcon(iconKeranjang2);
                        cl.show(clPanel, "panelKeranjang");
                        frame.setTitle("Menu Keranjang");
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btn_keranjang.setIcon(iconKeranjang);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btn_keranjang.setIcon(iconKeranjang1);
                    }
                }
        );
        btn_keranjang.setBorderPainted(false);
        btn_keranjang.setFocusPainted(false);
        btn_keranjang.setContentAreaFilled(false);
        panelNav.add(btn_keranjang);
        
        // Account
        iconAkun = new ImageIcon(resizeImage("assets/account.png"));
        iconAkun1 = new ImageIcon(resizeImage("assets/account1.png"));
        iconAkun2 = new ImageIcon(resizeImage("assets/account2.png"));
        btn_account = new JButton(iconAkun);
        btn_account.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_account.setIcon(iconAkun1);
        btn_account.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        btn_account.setIcon(iconAkun2);
                        cl.show(clPanel, "panelAccount");
                        frame.setTitle("Menu Account");
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btn_account.setIcon(iconAkun);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btn_account.setIcon(iconAkun1);
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
        
        panelCustomer = new PanelCustomer();
        panelKeranjang = new PanelKeranjang();
        panelAccount = new PanelAccount();
        
        clPanel.add(panelCustomer, "panelCustomer");
        clPanel.add(panelKeranjang, "panelKeranjang");
        clPanel.add(panelAccount, "panelAccount");
        
        frame = new JFrame("Menu Utama");
        frame.add(clPanel);
        frame.add(panelNav, BorderLayout.PAGE_END);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
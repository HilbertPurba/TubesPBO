/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javafx.scene.paint.Color;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hilbert
 */
public class MenuCustomer {
    private JFrame frame;
    private JPanel panelTop, panelNav, panelContent, panelBottom;
    private JButton btn_home, btn_keranjang, btn_account;
    private ImageIcon iconHome, iconKeranjang, iconAkun;
    private ImageIcon iconHome1, iconKeranjang1, iconAkun1;
    private ImageIcon iconHome2;

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
    
    
    
    public MenuCustomer() {
        // Panel Set up
        frame = new JFrame("Menu Customer");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelTop = new JPanel();
        panelTop.setSize(JFrame.MAXIMIZED_BOTH, 100);
        panelTop.setBackground(java.awt.Color.white);
        frame.add(panelTop, BorderLayout.NORTH);
        
        title = new JLabel("CUSTOMER MENU");
        title.setSize(400, 80);
        title.setFont(new Font("Calibri", Font.BOLD, 36));
        title.setForeground(java.awt.Color.BLACK);
        panelTop.add(title);
        
       
        panelBottom = new JPanel();
        panelBottom.setSize(400, 80);
        panelBottom.setBackground(java.awt.Color.white);
        frame.add(panelBottom, BorderLayout.SOUTH);
        
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
//                        btn_home.setIcon(iconHome2);
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
        panelBottom.add(btn_home);
        
        // Keranjang
        iconKeranjang = new ImageIcon(resizeImage("assets/keranjang.png"));
        iconKeranjang1 = new ImageIcon(resizeImage("assets/keranjang1.png"));
        btn_keranjang = new JButton(iconKeranjang);
        btn_keranjang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_keranjang.setIcon(iconKeranjang1);
        btn_keranjang.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        
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
        panelBottom.add(btn_keranjang);
        
        // Account
        iconAkun = new ImageIcon(resizeImage("assets/account.png"));
        iconAkun1 = new ImageIcon(resizeImage("assets/account1.png"));
        btn_account = new JButton(iconAkun);
        btn_account.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_account.setIcon(iconAkun1);
        btn_account.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        
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
        panelBottom.add(btn_account);
        
        frame.setVisible(true);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Image;
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
 * @author hilbert
 */
public class PanelMenuUser {
    private JFrame frame;
    private JPanel panelTop, panelNav, panelContent, panelBottom;
    private JButton home, keranjang, history, akun;
    private ImageIcon iconHome, iconKeranjang, iconHistory, iconAkun;
    private JLabel title;
    
    public Image resizeImage(String url) {
        Image dimg = null;

        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        return dimg;
    }
    
    public PanelMenuUser() {
        // Panel Set up
        frame = new JFrame("Menu User");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelTop = new JPanel();
        panelTop.setSize(JFrame.MAXIMIZED_BOTH, 80);
        frame.add(panelTop, BorderLayout.NORTH);
        
        title = new JLabel("Selamat Datang, User!");
        title.setSize(400, 80);
        panelTop.add(title);
        
        panelBottom = new JPanel();
        panelBottom.setSize(400, 80);
        frame.add(panelBottom, BorderLayout.SOUTH);
        
        //
        iconHome = new ImageIcon(resizeImage("assets/home.png"));
        home = new JButton(iconHome);
        home.setSize(80, 80);
        home.setBorderPainted(false);
        home.setFocusPainted(false);
        home.setContentAreaFilled(false);
        panelBottom.add(home);
        
        iconKeranjang = new ImageIcon(resizeImage("assets/keranjang.png"));
        keranjang = new JButton(iconKeranjang);
        keranjang.setSize(80, 80);
        keranjang.setBorderPainted(false);
        keranjang.setFocusPainted(false);
        keranjang.setContentAreaFilled(false);
        panelBottom.add(keranjang);
        
        iconAkun = new ImageIcon(resizeImage("assets/account.png"));
        akun = new JButton(iconAkun);
        akun.setSize(80, 80);
        akun.setBorderPainted(false);
        akun.setFocusPainted(false);
        akun.setContentAreaFilled(false);
        panelBottom.add(akun);
    }
}

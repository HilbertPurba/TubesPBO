/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
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
import javax.swing.WindowConstants;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class PanelRegister {
    private JFrame jfr_register;
    private JLabel judul;
    private JButton btn_cust, btn_idk, btn_vendor, btn_back;
    private ImageIcon iconCust, idk, iconVendor, iconBack;
    private ImageIcon iconCust1, idk1, iconVendor1, iconBack1;
    
    private Image resizeImage(String url) {
        Image dimg = null;

        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        return dimg;
    }
    private Image resizeImage2(String url) {
        Image dimg = null;

        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        return dimg;
    }
    
    public PanelRegister(){
        jfr_register = new JFrame("GHz Online Shop");
        
        jfr_register.getContentPane().setBackground(Color.white );
        jfr_register.setResizable(true);
        jfr_register.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfr_register.setSize(1000,1000);
        jfr_register.setLocationRelativeTo(null);

        
        judul = new JLabel("Register Sebagai ..");
        judul.setBounds(200,0,1000,300);
        judul.setFont(new Font("Calibri", Font.BOLD, 80));
        judul.setForeground(Color.orange);
        
        //Customer
        iconCust = new ImageIcon(resizeImage("assets/customer.png"));
        iconCust1 = new ImageIcon(resizeImage("assets/customer1.png"));
        
        btn_cust = new JButton(iconCust);
        btn_cust.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_cust.setIcon(iconCust);
        btn_cust.setBounds(120, 250, 350, 350);
        btn_cust.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        new PanelRegisterCustomer();
                        jfr_register.setVisible(false);
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btn_cust.setIcon(iconCust1);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btn_cust.setIcon(iconCust);
                    }
                }
        );
        btn_cust.setBorderPainted(false);
        btn_cust.setFocusPainted(false);
        btn_cust.setContentAreaFilled(false);
        
        //Cannot Replace
        btn_idk = new JButton(idk);
        btn_idk.setIcon(idk);
        btn_idk.setVisible(false);
        
        //Vendor
        iconVendor = new ImageIcon(resizeImage("assets/vendor.png"));
        iconVendor1 = new ImageIcon(resizeImage("assets/vendor1.png"));
        
        btn_vendor = new JButton(iconVendor);
        btn_vendor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_vendor.setIcon(iconVendor);
        btn_vendor.setBounds(500, 250, 350, 350);
        btn_vendor.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        new PanelRegisterVendor();
                        jfr_register.setVisible(false);
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btn_vendor.setIcon(iconVendor1);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btn_vendor.setIcon(iconVendor);
                    }
                }
        );
        btn_vendor.setBorderPainted(false);
        btn_vendor.setFocusPainted(false);
        btn_vendor.setContentAreaFilled(false);
        
        //Back
        iconBack = new ImageIcon(resizeImage2("assets/back.png"));
        iconBack1 = new ImageIcon(resizeImage2("assets/back1.png"));
        
        btn_back = new JButton(iconBack);
        btn_back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_back.setIcon(iconBack);
        btn_back.setBounds(325, 500, 300, 300);
        btn_back.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        new Start();
                        jfr_register.setVisible(false);
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btn_back.setIcon(iconBack1);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btn_back.setIcon(iconBack);
                    }
                }
        );
        btn_back.setBorderPainted(false);
        btn_back.setFocusPainted(false);
        btn_back.setContentAreaFilled(false);
        
        jfr_register.setVisible(true);
        jfr_register.add(judul);
        jfr_register.add(btn_cust);
        jfr_register.add(btn_vendor);
        jfr_register.add(btn_back);
        jfr_register.add(btn_idk);
    }
}

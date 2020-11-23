/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class Start extends JPanel {
    private JFrame jfr_start;
    private JPanel content;
    private JLabel namaAppL;
    private JButton idk, btn_register, btn_login, btn_exit;
    private ImageIcon iconExit, iconRegister, iconLogin;
    private ImageIcon iconExit1, iconRegister1, iconLogin1;
    private GridBagConstraints gbc;
    
    
    private Image resizeImage(String url) {
        Image dimg = null;

        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(400, 150, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        return dimg;
    }
    
    public Start(){
        jfr_start = new JFrame("GHz Online Shop");
        jfr_start.getContentPane().setBackground(Color.white );
        jfr_start.setResizable(true);
        jfr_start.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfr_start.setSize(1000,700);
        jfr_start.setLocationRelativeTo(null);
        jfr_start.setLayout(new BorderLayout());
        
        content = new JPanel(new GridBagLayout());          
        
        namaAppL = new JLabel("Welcome to GHz Online Shop");
        namaAppL.setFont(new Font("Calibri", Font.BOLD, 55));
        namaAppL.setForeground(Color.orange);
        
        // Exit
        iconExit = new ImageIcon(resizeImage("assets/exit.png"));
        iconExit1 = new ImageIcon(resizeImage("assets/exit1.png"));
        
        btn_exit = new JButton(iconExit);
        btn_exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_exit.setIcon(iconExit);
        btn_exit.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        System.exit(0);
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btn_exit.setIcon(iconExit1);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btn_exit.setIcon(iconExit);
                    }
                }
        );
        btn_exit.setBorderPainted(false);
        btn_exit.setFocusPainted(false);
        btn_exit.setContentAreaFilled(false);
        
        // Cannot Replace
        idk = new JButton(iconExit);
        idk.setIcon(iconExit);
        idk.setVisible(false);
        
        // Register
        iconRegister = new ImageIcon(resizeImage("assets/register.png"));
        iconRegister1 = new ImageIcon(resizeImage("assets/register1.png"));
        
        btn_register = new JButton(iconRegister);
        btn_register.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_register.setIcon(iconRegister);
        btn_register.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        new PanelRegister();
                        jfr_start.setVisible(false);
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btn_register.setIcon(iconRegister1);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btn_register.setIcon(iconRegister);
                    }
                }
        );
        btn_register.setBorderPainted(false);
        btn_register.setFocusPainted(false);
        btn_register.setContentAreaFilled(false);
        
        // Login
        iconLogin = new ImageIcon(resizeImage("assets/login.png"));
        iconLogin1 = new ImageIcon(resizeImage("assets/login1.png"));
        
        btn_login = new JButton(iconLogin);
        btn_login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_login.setIcon(iconLogin);
        btn_login.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        new PanelLogin();
                        jfr_start.setVisible(false);
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btn_login.setIcon(iconLogin1);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btn_login.setIcon(iconLogin);
                    }
                }
        );
        btn_login.setBorderPainted(false);
        btn_login.setFocusPainted(false);
        btn_login.setContentAreaFilled(false);
        
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        content.add(namaAppL, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        content.add(btn_register, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        content.add(btn_login, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        content.add(btn_exit, gbc);
        
        jfr_start.add(idk);
        jfr_start.add(content, BorderLayout.CENTER);
        jfr_start.setVisible(true);
    }
}
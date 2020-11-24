/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.*;
import Model.KeranjangManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Model.UserManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class PanelLogin implements ActionListener {

    private JFrame jfr_login;
    private JLabel emailL, passL;
    private JTextField email;
    private JPasswordField pass;
    private JButton btn_login, btn_back;
    private JPanel panel;
    private GridBagConstraints gbc;    
    private ImageIcon iconLogin, iconLogin1, iconBack, iconBack1, logo;
    
    private Image resizeImage(String url) {
        Image dimg = null;

        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(165, 65, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        return dimg;
    }

    public PanelLogin() {
        jfr_login = new JFrame("GHz - Login");
        jfr_login.getContentPane().setBackground(Color.WHITE);
        jfr_login.setResizable(true);
        jfr_login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfr_login.setSize(1000,700);
        jfr_login.setLocationRelativeTo(null);
        jfr_login.setLayout(new BorderLayout());
        //Logo
        logo = new ImageIcon("assets/logo.png");
        jfr_login.setIconImage(logo.getImage());
        
        panel = new JPanel(new GridBagLayout());
        
        JLabel judulL = new JLabel("LOGIN");
        judulL.setFont(new Font("Trebuchet MS", Font.BOLD, 100));
        judulL.setForeground(new Color(253,170,0));

        emailL = new JLabel("Email");
        emailL.setFont(new Font("Calibri", Font.CENTER_BASELINE, 32));
        
        email = new JTextField(15);
        email.setFont(new Font("Calibri", Font.PLAIN, 25));
        email.setBorder(null);

        passL = new JLabel("Password      ");
        passL.setFont(new Font("Calibri", Font.CENTER_BASELINE, 32));
        
        pass = new JPasswordField(15);
        pass.setFont(new Font("Calibri", Font.PLAIN, 25));
        pass.setBorder(null);

        // Button Submit
        iconLogin = new ImageIcon(resizeImage("assets/login.png"));
        iconLogin1 = new ImageIcon(resizeImage("assets/login1.png"));
        
        btn_login = new JButton (iconLogin);
        btn_login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_login.setIcon(iconLogin);        
        btn_login.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        jfr_login.setVisible(false);
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
        btn_login.addActionListener(this);
        
        // Button Cancel
        iconBack = new ImageIcon(resizeImage("assets/backo.png"));
        iconBack1 = new ImageIcon(resizeImage("assets/backo1.png"));
        
        btn_back = new JButton (iconBack);
        btn_back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_back.setIcon(iconBack);        
        btn_back.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        jfr_login.dispose();
                        new Start();
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
        
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(judulL, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(emailL, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(email, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passL, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(pass, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(btn_back, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(btn_login, gbc);
        
        jfr_login.add(panel, BorderLayout.CENTER);
        jfr_login.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String emailLogin = email.getText();
        String passLogin = new String(pass.getPassword());
        if (emailLogin.equals("") && passLogin.equals("")) {
            JOptionPane.showMessageDialog(null, "Insert email and password!", "Alert", JOptionPane.WARNING_MESSAGE);
        } else if (emailLogin.equals("")) {
            JOptionPane.showMessageDialog(null, "Insert email!", "Alert", JOptionPane.WARNING_MESSAGE);
        } else if (passLogin.equals("")) {
            JOptionPane.showMessageDialog(null, "Insert password!", "Alert", JOptionPane.WARNING_MESSAGE);
        } else if (Controller.cekPassword(emailLogin, passLogin)) {
            UserManager.getInstance().setUser(Controller.getUser(emailLogin));
            if (UserManager.getInstance().getUser().getTipeUser() == 0) {
                jfr_login.dispose();
               new DashboardCustomer();
            } else if (UserManager.getInstance().getUser().getTipeUser() == 1) {
                jfr_login.dispose();
                new DashboardVendor();
            } else if (UserManager.getInstance().getUser().getTipeUser() == 2) {
                jfr_login.dispose();
                new DashboardAdmin();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Masukkan Email dan Password yang benar!", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }
}

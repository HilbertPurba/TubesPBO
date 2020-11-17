/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.*;
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
 */
public class PanelLogin implements ActionListener {

    JFrame jfr_login;
    JLabel emailL, passL;
//    JToggleButton eyeButton;
    JTextField email;
    JPasswordField pass;
    JButton btn_login;
    JPanel Panel;
    
    private ImageIcon iconLogin, iconLogin1;
    
    private Image resizeImage(String url) {
        Image dimg = null;

        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(150, 60, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        return dimg;
    }

    public PanelLogin() {
        jfr_login = new JFrame("GHz - Login");
        jfr_login.getContentPane().setBackground(Color.WHITE);
        jfr_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfr_login.setResizable(true);
        jfr_login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfr_login.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        Panel = new JPanel();
        Panel.setLayout(null);
        
        JLabel judulL = new JLabel("LOGIN");
        judulL.setBounds(900, 0, 1000, 300);
        judulL.setFont(new Font("Trebuchet MS", Font.BOLD, 80));
        judulL.setForeground(new Color(253,170,0));

        emailL = new JLabel("Email              : ");
        emailL.setBounds(720, 230, 150, 40);
        emailL.setFont(new Font("Calibri", Font.BOLD, 20));
        email = new JTextField();
        email.setBounds(880, 230, 350, 40);
        email.setBorder(null);

        passL = new JLabel("Password       : ");
        passL.setBounds(720, 290, 150, 40);
        passL.setFont(new Font("Calibri", Font.BOLD, 20));
        pass = new JPasswordField(100);
        pass.setBounds(880, 290, 350, 40);
        pass.setBorder(null);

        // Button Submit
        iconLogin = new ImageIcon(resizeImage("assets/login.png"));
        iconLogin1 = new ImageIcon(resizeImage("assets/login1.png"));
        
        btn_login = new JButton (iconLogin);
        btn_login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_login.setIcon(iconLogin);
        btn_login.setBounds(950, 380, 150, 60);
        
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
        
        jfr_login.add(judulL);
        jfr_login.add(emailL);
        jfr_login.add(email);
        jfr_login.add(passL);
        jfr_login.add(pass);
        jfr_login.add(btn_login);
        jfr_login.add(Panel);
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
                jfr_login.dispose();;
                new DashboardVendor();
            } else {
                jfr_login.dispose();
                new MenuAdmin();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Insert email and password correctly!", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }
}

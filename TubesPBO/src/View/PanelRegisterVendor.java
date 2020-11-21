/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.*;
import Model.*;
import Controller.*;
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
public class PanelRegisterVendor implements ActionListener {
    
    JFrame jfr_registrasi = new JFrame("GHz - Register Vendor");
    JLabel namaL, emailL, teleponL, passL;
    JTextField name, email, telepon;
    JTextArea alamat;
    JPasswordField pass;
    JPanel Panel;
    JButton btn_submit;
    
    private ImageIcon iconRegister, iconRegister1;
    
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
    
    public PanelRegisterVendor() {
        jfr_registrasi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfr_registrasi.getContentPane().setBackground(Color.white );
        jfr_registrasi.setResizable(true);
        jfr_registrasi.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfr_registrasi.setSize(1000,1000);
        jfr_registrasi.setLocationRelativeTo(null);

        Panel = new JPanel();
        Panel.setLayout(null);

        JLabel judulL = new JLabel("Register as Vendor : ");
        judulL.setBounds(230, 0, 1000, 300);
        judulL.setFont(new Font("Calibri", Font.BOLD, 60));
        judulL.setForeground(new Color(22,105,122));

        namaL = new JLabel("Nama Toko         :");
        emailL = new JLabel("Email                   :");
        teleponL = new JLabel("Phone                 :");
        passL = new JLabel("Password            :");

        namaL.setBounds(225, 230, 150, 40);
        namaL.setFont(new Font("Calibri", Font.BOLD, 20));
        name = new JTextField();
        name.setBounds(400, 230, 350, 40);
        name.setBorder(null);

        emailL.setBounds(225, 290, 150, 40);
        emailL.setFont(new Font("Calibri", Font.BOLD, 20));
        email = new JTextField();
        email.setBounds(400, 290, 350, 40);
        email.setBorder(null);

        teleponL.setBounds(225, 350, 150, 40);
        teleponL.setFont(new Font("Calibri", Font.BOLD, 20));
        telepon = new JTextField();
        telepon.setBounds(400, 350, 350, 40);
        telepon.setBorder(null);
        
        passL.setBounds(225, 410, 150, 40);
        passL.setFont(new Font("Calibri", Font.BOLD, 20));
        pass = new JPasswordField(100);
        pass.setBounds(400, 410, 350, 40);
        pass.setBorder(null);
        
        // Button Submit
        iconRegister = new ImageIcon(resizeImage("assets/registerV1.png"));
        iconRegister1 = new ImageIcon(resizeImage("assets/registerV2.png"));
        
        btn_submit = new JButton (iconRegister);
        btn_submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_submit.setIcon(iconRegister);
        btn_submit.setBounds(600, 480, 150, 60);
        
        btn_submit.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        jfr_registrasi.setVisible(false);
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btn_submit.setIcon(iconRegister1);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btn_submit.setIcon(iconRegister);
                    }
                }
        );
        btn_submit.setBorderPainted(false);
        btn_submit.setFocusPainted(false);
        btn_submit.setContentAreaFilled(false);
        btn_submit.addActionListener(this);

        Panel.add(judulL);
        Panel.add(namaL);
        Panel.add(teleponL);
        Panel.add(emailL);
        Panel.add(passL);
        Panel.add(name);
        Panel.add(email);
        Panel.add(telepon);
        Panel.add(pass);
        Panel.add(btn_submit);


        jfr_registrasi.add(Panel);
        jfr_registrasi.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = this.name.getText();
        String email = this.email.getText();
        String noTelepon = this.telepon.getText();
        String password = new String(pass.getPassword());
        int a = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (a == JOptionPane.YES_OPTION) {
            if (nama.length() == 0 || email.length() == 0 || noTelepon.length() == 0 || password.length() == 0) {
                JOptionPane.showMessageDialog(null, "Input all the data!", "Alert", JOptionPane.WARNING_MESSAGE);
            } else {
                User newUser = new User();
                newUser.setNama(nama);
                newUser.setPassword(password);
                newUser.setEmail(email);
                newUser.setTelepon(noTelepon);
                if (Controller.insertNewVendor(newUser)) {
                    JOptionPane.showMessageDialog(null, "Registration Complete!\nPlease Login!");
                    jfr_registrasi.dispose();
                    new PanelLogin();
                } else {
                    JOptionPane.showMessageDialog(null, "Data can't be inserted!", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
}

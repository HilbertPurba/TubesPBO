/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
public class PanelRegisterCustomer implements ActionListener {
    JFrame jfr_registrasi = new JFrame("Register Customer");
    JLabel namaL, emailL, teleponL, passL;
    JTextField name, email, telepon;
    JTextArea alamat;
    JPasswordField pass;
    JPanel Panel;
    JButton btn_submit, btn_back;
    private ImageIcon logo;
    private ImageIcon iconRegister, iconRegister1;
    private ImageIcon iconBack, iconBack1;
    
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
    
    public PanelRegisterCustomer() {
        // Set Frame
        jfr_registrasi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfr_registrasi.getContentPane().setBackground(Color.white );
        jfr_registrasi.setResizable(true);
        jfr_registrasi.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfr_registrasi.setSize(1000,700);
        jfr_registrasi.setLocationRelativeTo(null);
        
        //Logo
        logo = new ImageIcon("assets/logo.png");
        jfr_registrasi.setIconImage(logo.getImage());

        Panel = new JPanel();
        Panel.setLayout(null);

        // Judul Content
        JLabel judulL = new JLabel("Register as Customer : ");
        judulL.setBounds(225, 0, 1000, 300);
        judulL.setFont(new Font("Calibri", Font.BOLD, 50));
        judulL.setForeground(new Color(253,170,0));

        // Isi
        namaL = new JLabel("Name ");
        namaL.setBounds(225, 230, 150, 40);
        namaL.setFont(new Font("Calibri", Font.BOLD, 20));
        name = new JTextField();
        name.setBounds(400, 230, 350, 40);
        name.setBorder(null);

        emailL = new JLabel("Email ");
        emailL.setBounds(225, 290, 150, 40);
        emailL.setFont(new Font("Calibri", Font.BOLD, 20));
        email = new JTextField();
        email.setBounds(400, 290, 350, 40);
        email.setBorder(null);

        teleponL = new JLabel("Phone");
        teleponL.setBounds(225, 350, 150, 40);
        teleponL.setFont(new Font("Calibri", Font.BOLD, 20));
        telepon = new JTextField();
        telepon.setBounds(400, 350, 350, 40);
        telepon.setBorder(null);
        
        passL = new JLabel("Password ");        
        passL.setBounds(225, 410, 150, 40);
        passL.setFont(new Font("Calibri", Font.BOLD, 20));
        pass = new JPasswordField(100);
        pass.setBounds(400, 410, 350, 40);
        pass.setBorder(null);
        
        // Button Submit
        iconRegister = new ImageIcon(resizeImage("assets/register.png"));
        iconRegister1 = new ImageIcon(resizeImage("assets/register1.png"));
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
        
        // Button Back
        iconBack = new ImageIcon(resizeImage("assets/backo.png"));
        iconBack1 = new ImageIcon(resizeImage("assets/backo1.png"));
        btn_back = new JButton (iconBack);
        btn_back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_back.setIcon(iconBack);
        btn_back.setBounds(400, 480, 150, 60);
        btn_back.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        jfr_registrasi.dispose();
                        new PanelRegister();
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

        // Add to Panel
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
        Panel.add(btn_back);

        // Add to Frame
        jfr_registrasi.add(Panel);
        jfr_registrasi.setLocationRelativeTo(null);
        jfr_registrasi.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String password = new String(pass.getPassword());
        int a = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (a == JOptionPane.YES_OPTION) {
            if (name.getText().isEmpty() || email.getText().isEmpty() || telepon.getText().isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Input all the data!", "Alert", JOptionPane.WARNING_MESSAGE);
            } else {
                Customer customer = new Customer();
                customer.setNama(name.getText());
                customer.setPassword(new String(pass.getPassword()));
                customer.setEmail(email.getText());
                customer.setTelepon(telepon.getText());
                if (Controller.insertNewCustomer(customer)) {
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

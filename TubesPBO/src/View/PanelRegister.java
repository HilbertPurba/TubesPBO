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
import Model.User;
import Controller.*;
/**
 *
 * @author Gilbert
 */
public class PanelRegister implements ActionListener {
    
    JFrame registrasiFrame = new JFrame("Register Screen");
    JLabel namaLabel, emailLabel, teleponLabel, passLabel;
    JTextField name, email, telepon;
    JTextArea alamat;
    JPasswordField pass;
    JPanel Panel;
    JButton submitButton;
    
    public PanelRegister() {
        registrasiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registrasiFrame.setSize(300, 300);

        Panel = new JPanel();
        Panel.setLayout(null);

        JLabel judul1 = new JLabel("Please Register First");
        judul1.setBounds(40, 40, 400, 40);

        namaLabel = new JLabel("Name                  :");
        emailLabel = new JLabel("Email                  :");
        teleponLabel = new JLabel("Phone                 :");
        passLabel = new JLabel("Password            :");

        namaLabel.setBounds(40, 130, 150, 40);
        name = new JTextField();
        name.setBounds(190, 130, 350, 40);
        name.setBorder(null);

        emailLabel.setBounds(40, 190, 150, 40);
        email = new JTextField();
        email.setBounds(190, 190, 350, 40);
        email.setBorder(null);

        teleponLabel.setBounds(40, 250, 150, 40);
        telepon = new JTextField();
        telepon.setBounds(190, 250, 350, 40);
        telepon.setBorder(null);
        
        passLabel.setBounds(40, 310, 150, 40);
        pass = new JPasswordField(100);
        pass.setBounds(190, 310, 350, 40);
        pass.setBorder(null);
        
        submitButton = new JButton("Register");
        submitButton.setBounds(280, 360, 150, 50);
        submitButton.addActionListener(this);

        Panel.add(judul1);
        Panel.add(namaLabel);
        Panel.add(teleponLabel);
        Panel.add(emailLabel);
        Panel.add(passLabel);
        Panel.add(name);
        Panel.add(email);
        Panel.add(telepon);
        Panel.add(pass);
        Panel.add(submitButton);


        registrasiFrame.add(Panel);
        registrasiFrame.getContentPane().setBackground(Color.WHITE);
        registrasiFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        registrasiFrame.setLocationRelativeTo(null);
        registrasiFrame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        String nama = this.name.getText();
//        String email = this.email.getText();
//        String noTelepon = this.telepon.getText();
//        String password = new String(pass.getPassword());
//        int a = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
//        if (a == JOptionPane.YES_OPTION) {
//            if (nama.length() == 0 || email.length() == 0 || noTelepon.length() == 0 || password.length() == 0) {
//                JOptionPane.showMessageDialog(null, "Input all the data!", "Alert", JOptionPane.WARNING_MESSAGE);
//            } else {
//                User newUser = new User();
//                newUser.setNama(nama);
//                newUser.setPassword(password);
//                newUser.setEmail(email);
//                newUser.setTelepon(noTelepon);
//                if (Controller.insertNewUser(newUser)) {
//                    JOptionPane.showMessageDialog(null, "Registration Complete!\nPlease Login!");
//                    registrasiFrame.dispose();
//                    new PanelLogin();
//                } else {
//                    JOptionPane.showMessageDialog(null, "Data can't be inserted!", "Alert", JOptionPane.WARNING_MESSAGE);
//                }
//            }
//        }
    }
}

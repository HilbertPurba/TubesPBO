/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import controller.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Model.UserManager;

/**
 *
 * @author Jennifer Florentina
 */
public class PanelLogin implements ActionListener {

    JFrame loginFrame = new JFrame("Login");
    JPanel textfieldPanel = new JPanel();
    JLabel emailLabel, passwordLabel;
    JToggleButton eyeButton;
    JTextField email;
    JPasswordField pass;
    JButton submitButton;

    public PanelLogin() {
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        emailLabel = new JLabel("Email     : ");
        emailLabel.setBounds(20, 20, 180, 50);

        passwordLabel = new JLabel("Password      : ");
        passwordLabel.setBounds(20, 90, 180, 50);

        email = new JTextField(100);
        email.setBounds(180, 20, 380, 50);
        email.setBorder(null);

        pass = new JPasswordField(100);
        pass.setBounds(180, 90, 330, 50);
        pass.setBorder(null);

        textfieldPanel = new JPanel();
        textfieldPanel.setBounds(380, 150, 590, 170);
        textfieldPanel.setBackground(new Color(221, 243, 245));
        textfieldPanel.add(emailLabel);
        textfieldPanel.add(email);
        textfieldPanel.add(passwordLabel);
        textfieldPanel.add(pass);
        textfieldPanel.setLayout(null);

        submitButton = new JButton("Login");
        submitButton.setBounds(820, 350, 150, 50);
        submitButton.addActionListener(this);

        loginFrame.add(textfieldPanel);
        loginFrame.add(submitButton);
        loginFrame.getContentPane().setBackground(Color.WHITE);
        loginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

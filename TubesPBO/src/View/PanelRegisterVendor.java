/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Gilbert
 */
public class PanelRegisterVendor extends JPanel {

    JFrame registrasiFrame = new JFrame("Registrasi Vendor");

    public PanelRegisterVendor() {
        this.setBackground(Color.WHITE);
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBackground(Color.WHITE);
        this.add(panelForm);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;

        panelForm.add(new JLabel("Nama: "), c);
        c.gridy++;
        panelForm.add(new JLabel("Email: "), c);
        c.gridy++;
        panelForm.add(new JLabel("Nomor Telp: "), c);
        c.gridy++;
        panelForm.add(new JLabel("Password: "), c);
        c.gridy++;

        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        JTextField tfNama = new JTextField(12);
        panelForm.add(tfNama, c);
        c.gridy++;
        JTextField tfEmail = new JTextField(12);
        panelForm.add(tfEmail, c);
        c.gridy++;
        JTextField tfNomorTelp = new JTextField(12);
        panelForm.add(tfNomorTelp, c);
        c.gridy++;
        JPasswordField tfPassword = new JPasswordField(12);
        panelForm.add(tfPassword, c);
        c.gridy++;

        JLabel buttonRegister = new JLabel();
        buttonRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonRegister.addMouseListener(
                new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {

            }
        }
        );

        this.add(buttonRegister, BorderLayout.SOUTH);
        registrasiFrame.add(panelForm);
        registrasiFrame.getContentPane().setBackground(Color.WHITE);
        registrasiFrame.setLocationRelativeTo(null);
        registrasiFrame.setVisible(true);
    }
}

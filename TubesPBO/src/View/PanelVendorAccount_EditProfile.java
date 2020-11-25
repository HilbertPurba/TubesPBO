/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.User;
import Model.UserManager;
import static View.DashboardVendor.frame;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class PanelVendorAccount_EditProfile extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel labelEmail, labelTelepon;
    private JTextField tfEmail, tfTelepon;
    private GridBagConstraints gbc;
    private ImageIcon iconOk, iconBack, iconBack1;
    private JButton btnOk, btnBack;
    
    private Image resizeImage(String url) {
        Image dimg = null;

        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        return dimg;
    }
    
    public PanelVendorAccount_EditProfile() {
        labelEmail = new JLabel("Email: ");
        tfEmail = new JTextField(UserManager.getInstance().getUser().getEmail(), 20);
        
        labelTelepon = new JLabel("Telepon: ");
        tfTelepon = new JTextField(UserManager.getInstance().getUser().getTelepon(), 20);
        
        iconOk = new ImageIcon(resizeImage("assets/ok.png"));
        btnOk = new JButton(iconOk);
        btnOk.setBorderPainted(false);
        btnOk.setFocusPainted(false);
        btnOk.setContentAreaFilled(false);
        btnOk.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnOk.addActionListener(this);
        
        iconBack = new ImageIcon(resizeImage("assets/back.png"));
        iconBack1 = new ImageIcon(resizeImage("assets/back1.png"));
        btnBack = new JButton(iconBack);
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBack.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        btnBack.setIcon(iconBack);
                        dispose();
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btnBack.setIcon(iconBack);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btnBack.setIcon(iconBack1);
                    }
                }
        );
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);
        btnBack.setContentAreaFilled(false);
            
        panel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(15, 0, 0, 0);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelEmail, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(tfEmail, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelTelepon, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(tfTelepon, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(btnOk, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(btnBack, gbc);
        
        setTitle("Edit Profile");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setResizable(true);
        getContentPane().add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnOk) {
            if(tfEmail.getText().isEmpty() || tfTelepon.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Masih ada data yang kosong. Mohon diisi",  "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                int option = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin?",  "Update", JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.OK_OPTION) {
                    UserManager.getInstance().getUser().setEmail(tfEmail.getText());
                    UserManager.getInstance().getUser().setTelepon(tfTelepon.getText());
                    if(Controller.updateProfilCustomer(UserManager.getInstance())) {
                        JOptionPane.showMessageDialog(null, "Update Data Sukses. Anda akan diminta untuk Login kembali dengan Data yang baru", "Success", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        frame.dispose();
                        UserManager.getInstance().logOut();
                        new PanelLogin();
                    } else {
                        JOptionPane.showMessageDialog(null, "Pembaharuan data gagal");
                    }
                }
            }
        }
    }
}


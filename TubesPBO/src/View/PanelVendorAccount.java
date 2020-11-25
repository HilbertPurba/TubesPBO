/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.UserManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class PanelVendorAccount extends JPanel {
    private JPanel header, content;
    private JLabel title, nama, email, telepon;
    private ImageIcon iconEdit, iconEdit1, iconEdit2;
    private JButton btn_edit;
    private GridBagConstraints gbc;
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
    
    public PanelVendorAccount  () {
        setLayout(new BorderLayout());
        header = new JPanel();
        header.setBackground(java.awt.Color.white);
        
        //judul
        title = new JLabel("PROFIL VENDOR");
        title.setFont(new Font("Calibri", Font.BOLD, 60));
        title.setForeground(new Color(2,91,149));
        header.add(title);
        
        content = new JPanel(new GridBagLayout());
        
        // isi
        nama = new JLabel("Nama       : " + UserManager.getInstance().getUser().getNama());
        nama.setFont(new Font("Segoe UI",  Font.BOLD, 35));
        email = new JLabel("Email        : " + UserManager.getInstance().getUser().getEmail());
        email.setFont(new Font("Segoe UI",  Font.BOLD, 35));
        telepon = new JLabel("Telepon    : " + UserManager.getInstance().getUser().getTelepon());
        telepon.setFont(new Font("Segoe UI",  Font.BOLD, 35));
        iconEdit = new ImageIcon(resizeImage("assets/edit.png"));
        iconEdit1 = new ImageIcon(resizeImage("assets/edit1.png"));
        iconEdit2 = new ImageIcon(resizeImage("assets/edit2.png"));
        btn_edit = new JButton(iconEdit);
        btn_edit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_edit.setIcon(iconEdit);
        btn_edit.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        btn_edit.setIcon(iconEdit2);
                        new PanelVendorAccount_EditProfile();
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btn_edit.setIcon(iconEdit);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btn_edit.setIcon(iconEdit1);
                    }
                }
        );
        
        btn_edit.setBorderPainted(false);
        btn_edit.setFocusPainted(false);
        btn_edit.setContentAreaFilled(false);
        
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        content.add(nama, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        content.add(email, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        content.add(telepon, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        content.add(btn_edit, gbc);
        
        add(header, BorderLayout.PAGE_START);
        add(content, BorderLayout.CENTER);
    }
}

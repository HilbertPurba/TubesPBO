/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.Produk;
import Model.User;
import Model.UserManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;	
import javax.swing.JLabel;
import javax.swing.JPanel;	
import javax.swing.JPanel;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class PanelAdminSeeTransaction extends JPanel implements ActionListener {
    private JPanel header, content;
    private JLabel title, judul;
    private JLabel[] nama;
    private GridBagConstraints gbc;
    private ArrayList<User> listUser = Controller.getUserToko(UserManager.getInstance().getUser().getID());
    private int jumlahUser = 0;
    private JButton btn_see[];
    private ImageIcon iconSee, iconSee1;
    private Image resizeImage(String url) {
        Image dimg = null;

        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(60, 20, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        return dimg;
    }
  
    public PanelAdminSeeTransaction(){
        setLayout(new BorderLayout());
        header = new JPanel();
        header.setBackground(Color.WHITE);
                
        title = new JLabel("LIHAT TRANSAKSI");
        title.setFont(new Font("Calibri", Font.BOLD, 60));
        title.setForeground(Color.red);
        header.add(title);
        
        content = new JPanel(new GridBagLayout());
        
        judul = new JLabel("Daftar Nama Toko : ");
        judul.setFont(new Font("Segoe UI", Font.BOLD, 35));
        judul.setForeground(Color.red);
        
        for (int i=0;i< listUser.size();i++){
            jumlahUser++;
        }

        iconSee = new ImageIcon(resizeImage("assets/see.png"));

        nama = new JLabel[jumlahUser];
        btn_see = new JButton[jumlahUser];
        
        int counter = 0;
        
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridy = 1;
      
        for (int i = 0;i<jumlahUser;i++){
            nama[counter] = new JLabel(listUser.get(i).getNama());
            nama[counter].setFont(new Font("Segoe UI", Font.PLAIN, 25));
            btn_see[counter] = new JButton(iconSee);
            btn_see[counter].setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn_see[counter].setBorderPainted(false);
            btn_see[counter].setFocusPainted(false);
            btn_see[counter].setContentAreaFilled(false);
            btn_see[counter].addActionListener(this);
            
            gbc.gridx = 0;
            content.add(nama[counter], gbc);

            gbc.gridx = 1;
            content.add(btn_see[counter], gbc);

            gbc.gridy++;
            counter++;
        }
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        content.add(judul, gbc);
        
        add(header, BorderLayout.PAGE_START);
        add(content, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        for(int i = 0;i<jumlahUser;i++){
            if (ae.getSource() == btn_see[i]){
                new PanelAdminSeeTransaction_See(nama[i].getText());
            }
        }
    }
}

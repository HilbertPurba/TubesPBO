/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
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
public class PanelCustomerAccount extends JPanel {
    private JPanel header, content;
    private JLabel title, nama, email, telepon;
    private ImageIcon iconEdit, iconEdit1, iconEdit2;
    private JButton btn_edit;
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
    
    public PanelCustomerAccount () {
        setLayout(new BorderLayout());
        header = new JPanel();
        header.setBackground(java.awt.Color.white);
        
        title = new JLabel("PROFIL CUSTOMER");
        title.setFont(new Font("Calibri", Font.BOLD, 72));
        title.setForeground(new Color(253,170,0));
        header.add(title);
        
        content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        nama = new JLabel("Nama: Test");
        nama.setFont(new Font("Calibri",  Font.BOLD, 42));
        nama.setAlignmentX(Component.CENTER_ALIGNMENT);
        email = new JLabel("Email: test@domain.com");
        email.setFont(new Font("Calibri",  Font.BOLD, 42));
        email.setAlignmentX(Component.CENTER_ALIGNMENT);
        telepon = new JLabel("Telepon: 081231293219");
        telepon.setFont(new Font("Calibri",  Font.BOLD, 42));
        telepon.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(nama);
        content.add(email);
        content.add(telepon);
        
        iconEdit = new ImageIcon(resizeImage("assets/edit.png"));
        iconEdit1 = new ImageIcon(resizeImage("assets/edit1.png"));
        iconEdit2 = new ImageIcon(resizeImage("assets/edit2.png"));
        btn_edit = new JButton(iconEdit);
        btn_edit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn_edit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_edit.setIcon(iconEdit);
        btn_edit.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        btn_edit.setIcon(iconEdit2);
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
        content.add(btn_edit);
        
        add(header, BorderLayout.PAGE_START);
        add(content);
    }
}

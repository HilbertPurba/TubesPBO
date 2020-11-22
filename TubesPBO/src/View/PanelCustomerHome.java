/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.UserManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hilbert
 */
public class PanelCustomerHome extends JPanel {
    //CardLayout component
    private JPanel header, content;
    private JLabel title, desc;
    
    public PanelCustomerHome () {
        setLayout(new BorderLayout());
        header = new JPanel();
        header.setBackground(java.awt.Color.white);
        
        title = new JLabel("SELAMAT DATANG, " + UserManager.getInstance().getUser().getNama().toUpperCase());
        title.setFont(new Font("Calibri", Font.BOLD, 72));
        title.setForeground(new Color(253,170,0));
        header.add(title);
        
        content = new JPanel();
        desc = new JLabel("Pilih Produk: ");
        content.add(desc);
        
        add(header, BorderLayout.PAGE_START);
        add(content, BorderLayout.CENTER);
    }
}

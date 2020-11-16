/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hilbert
 */
public class PanelKeranjang extends JPanel {
    private JPanel header, content;
    private JLabel title, desc;
    
    public PanelKeranjang() {
        setLayout(new BorderLayout());
        header = new JPanel();
        header.setBackground(java.awt.Color.white);
        
        title = new JLabel("KERANJANG");
        title.setFont(new Font("Calibri", Font.BOLD, 36));
        title.setForeground(java.awt.Color.BLACK);
        header.add(title);
        
        content = new JPanel();
        desc = new JLabel("Keranjang kamu: ");
        content.add(desc);
        
        add(header, BorderLayout.PAGE_START);
        add(content, BorderLayout.CENTER);
    }
}

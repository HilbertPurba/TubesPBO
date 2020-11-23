/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class PanelAdminSeeTransaction extends JPanel {
    private JPanel header, content;
    private JLabel title, judul;
    private JLabel namaL;
    private GridBagConstraints gbc;
    
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
        
//        for (int i=0;i< listProd.size();i++){
//        
//        }
        
        namaL = new JLabel("Nama Customer        ");
        namaL.setFont(new Font("Segoe UI", Font.BOLD, 20));
        
        //isi
        
        //counter
        
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridy = 2;
        
        //looping isi
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        content.add(judul, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        content.add(namaL, gbc);
        
        add(header, BorderLayout.PAGE_START);
        add(content, BorderLayout.CENTER);
    }
}

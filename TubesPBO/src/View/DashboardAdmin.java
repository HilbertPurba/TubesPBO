/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
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

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class DashboardAdmin {
    //CardLayout component
    private CardLayout cl;
    private PanelAdminSeeTransaction panelSeeTransaction;
    private PanelAdminCancelTransaction panelCancelTransaction;
    
    //Frame component
    private JFrame frame;
    
    //Panel compoenent
    private JPanel clPanel, panelNav;
    private JButton btn_seeTransaction, btn_cancelTransaaction;
    private ImageIcon iconSeeTransaction, iconCancelTransaction;
    private ImageIcon iconSeeTransaction1, iconCancelTransaction1;
    private ImageIcon iconSeeTransaction2, iconCancelTransaction2;
    
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
    
    public DashboardAdmin() {
        panelNav = new JPanel();
        panelNav.setBackground(java.awt.Color.white);
        
        // See
        iconSeeTransaction = new ImageIcon(resizeImage("assets/transaction.png"));
        iconSeeTransaction1 = new ImageIcon(resizeImage("assets/transaction1.png"));
        iconSeeTransaction2 = new ImageIcon(resizeImage("assets/transaction2.png"));
        btn_seeTransaction = new JButton(iconSeeTransaction);
        btn_seeTransaction.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_seeTransaction.setIcon(iconSeeTransaction);
        btn_seeTransaction.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        btn_seeTransaction.setIcon(iconSeeTransaction2);
                        cl.show(clPanel, "panelSeeTransaction");
                        frame.setTitle("Menu Lihat Transaksi");
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btn_seeTransaction.setIcon(iconSeeTransaction1);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btn_seeTransaction.setIcon(iconSeeTransaction);
                    }
                }
        );
        btn_seeTransaction.setBorderPainted(false);
        btn_seeTransaction.setFocusPainted(false);
        btn_seeTransaction.setContentAreaFilled(false);
        panelNav.add(btn_seeTransaction);
        
        // Cancel
        iconCancelTransaction = new ImageIcon(resizeImage("assets/cancelTR.png"));
        iconCancelTransaction1 = new ImageIcon(resizeImage("assets/cancelTR1.png"));
        iconCancelTransaction2 = new ImageIcon(resizeImage("assets/cancelTR2.png"));
        btn_cancelTransaaction = new JButton(iconCancelTransaction);
        btn_cancelTransaaction.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_cancelTransaaction.setIcon(iconCancelTransaction);
        btn_cancelTransaaction.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        btn_cancelTransaaction.setIcon(iconCancelTransaction2);
                        cl.show(clPanel, "panelCancelTransaction");
                        frame.setTitle("Menu Cancel Transaction");
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btn_cancelTransaaction.setIcon(iconCancelTransaction1);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btn_cancelTransaaction.setIcon(iconCancelTransaction);
                    }
                }
        );
        btn_cancelTransaaction.setBorderPainted(false);
        btn_cancelTransaaction.setFocusPainted(false);
        btn_cancelTransaaction.setContentAreaFilled(false);
        panelNav.add(btn_cancelTransaaction);
        
        cl = new CardLayout();
        clPanel = new JPanel();
        clPanel.setLayout(cl);
        
        panelSeeTransaction = new PanelAdminSeeTransaction();
        panelCancelTransaction = new PanelAdminCancelTransaction();
        
        clPanel.add(panelSeeTransaction, "panelSeeTransaction");
        clPanel.add(panelCancelTransaction, "panelCancelTransaction");
        
        frame = new JFrame("Menu Utama");
        frame.add(clPanel);
        frame.add(panelNav, BorderLayout.PAGE_END);
        frame.setSize(1000,1000);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

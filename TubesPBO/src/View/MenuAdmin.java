/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
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
 * @author Lenovo
 */
public class MenuAdmin {
    private JFrame frame;
    private JPanel panelTop, panelNav, panelContent, panelBottom;
    private JButton btn_seeTransaction, btn_cancelTransaction;
    private ImageIcon iconSeeTransaction, iconCancelTransaction;
    private ImageIcon iconSeeTransaction1, iconCancelTransaction1;
    private JLabel title;
    public Image resizeImage(String url) {
        Image dimg = null;

        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        return dimg;
    }
    
    public MenuAdmin() {
        // Panel Set Up
        frame = new JFrame("Menu Admin");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelTop = new JPanel();
        panelTop.setSize(JFrame.MAXIMIZED_BOTH, 80);
        frame.add(panelTop, BorderLayout.NORTH);
        
        title = new JLabel("Selamat Datang, Admin!");
        title.setSize(400, 80);
        title.setFont(new Font("Calibri", Font.BOLD, 36));
        panelTop.add(title);
        
        panelBottom = new JPanel();
        panelBottom.setSize(400, 80);
        panelBottom.setBackground(java.awt.Color.white);
        frame.add(panelBottom, BorderLayout.SOUTH);
        
        // See Transaction
        iconSeeTransaction = new ImageIcon(resizeImage("assets/transaction.png"));
        iconSeeTransaction1 = new ImageIcon(resizeImage("assets/transaction1.png"));
        btn_seeTransaction = new JButton(iconSeeTransaction);
        btn_seeTransaction.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_seeTransaction.setIcon(iconSeeTransaction1);
        btn_seeTransaction.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btn_seeTransaction.setIcon(iconSeeTransaction);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btn_seeTransaction.setIcon(iconSeeTransaction1);
                    }
                }
        );
        btn_seeTransaction.setBorderPainted(false);
        btn_seeTransaction.setFocusPainted(false);
        btn_seeTransaction.setContentAreaFilled(false);
        panelBottom.add(btn_seeTransaction);
        
        // Cancel Transaction
        iconCancelTransaction = new ImageIcon(resizeImage("assets/cancelTR.png"));
        iconCancelTransaction1 = new ImageIcon(resizeImage("assets/cancelTR1.png"));
        btn_cancelTransaction = new JButton(iconCancelTransaction);
        btn_cancelTransaction.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_cancelTransaction.setIcon(iconCancelTransaction1);
        btn_cancelTransaction.addMouseListener(
                new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent me){
                        
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent me){
                        btn_cancelTransaction.setIcon(iconCancelTransaction);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent me){
                        btn_cancelTransaction.setIcon(iconCancelTransaction1);
                    }
                }
        );
        btn_cancelTransaction.setBorderPainted(false);
        btn_cancelTransaction.setFocusPainted(false);
        btn_cancelTransaction.setContentAreaFilled(false);
        panelBottom.add(btn_cancelTransaction);
        
        frame.setVisible(true);
    }
}

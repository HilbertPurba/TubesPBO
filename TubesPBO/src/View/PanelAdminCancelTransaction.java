/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.ListTransaksiToko;
import Model.Transaksi;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class PanelAdminCancelTransaction extends JPanel implements ActionListener {

    private JPanel header, panel;
    private ImageIcon iconSee, iconSee1;
    private GridBagConstraints gbc;
    private JLabel judul, judul1;
    private ImageIcon iconOk;
    private JButton btn_ok;
    private JLabel idTr[], namaProd[], nama[], totalHarga[], jumlahProduk[], status[];
    private JLabel idTrL, namaProdL, namaL, totalHargaL, jumlahProdukL, statusL, namaProdukL;
    private List<ListTransaksiToko> newList = ListTransaksiToko.getAllTransaksiToko();
    private JButton btn_see[];

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

    public PanelAdminCancelTransaction() {
        setLayout(new BorderLayout());
        header = new JPanel();
        header.setBackground(Color.WHITE);

        judul = new JLabel("CANCEL TRANSAKSI");
        judul.setFont(new Font("Calibri", Font.BOLD, 60));
        judul.setForeground(Color.red);
        header.add(judul);

        panel = new JPanel(new GridBagLayout());

        judul1 = new JLabel("Daftar Transaksi: ");
        judul1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        judul1.setForeground(Color.red);

        idTrL = new JLabel("ID Transaksi       ");
        idTrL.setFont(new Font("Segoe UI", Font.BOLD, 16));
        namaProdukL = new JLabel("Nama Produk             ");
        namaProdukL.setFont(new Font("Segoe UI", Font.BOLD, 16));
        namaL = new JLabel("Nama User      ");
        namaL.setFont(new Font("Segoe UI", Font.BOLD, 16));
        totalHargaL = new JLabel("Total Harga        ");
        totalHargaL.setFont(new Font("Segoe UI", Font.BOLD, 16));
        jumlahProdukL = new JLabel("Jumlah       ");
        jumlahProdukL.setFont(new Font("Segoe UI", Font.BOLD, 16));
        statusL = new JLabel("Status    ");
        statusL.setFont(new Font("Segoe UI", Font.BOLD, 16));
        iconSee = new ImageIcon(resizeImage("assets/see.png"));

        //isi
        idTr = new JLabel[newList.size()];
        nama = new JLabel[newList.size()];
        namaProd = new JLabel[newList.size()];
        totalHarga = new JLabel[newList.size()];
        jumlahProduk = new JLabel[newList.size()];
        status = new JLabel[newList.size()];
        btn_see = new JButton[newList.size()];

        //counter
        int counter = 0;

        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.gridy = 2;

        for (int i = 0; i < newList.size(); i++) {
            idTr[counter] = new JLabel("" +newList.get(i).getId_transaksi());
            idTr[counter].setFont(new Font("Segoe UI", Font.PLAIN, 14));
            namaProd[counter] = new JLabel(newList.get(i).getNama_prod());
            namaProd[counter].setFont(new Font("Segoe UI", Font.PLAIN, 14));
            nama[counter] = new JLabel(newList.get(i).getNamaPengguna());
            nama[counter].setFont(new Font("Segoe UI", Font.PLAIN, 14));
            jumlahProduk[counter] = new JLabel("" + newList.get(i).getJumlah_beli());
            jumlahProduk[counter].setFont(new Font("Segoe UI", Font.PLAIN, 14));
            totalHarga[counter] = new JLabel("" + newList.get(i).getTotal_harga());
            totalHarga[counter].setFont(new Font("Segoe UI", Font.PLAIN, 14));
            status[counter] = new JLabel(newList.get(i).getStatus());
            status[counter].setFont(new Font("Segoe UI", Font.PLAIN, 14));
            
            gbc.gridx = 1;
            panel.add(idTr[counter], gbc);
            
            gbc.gridx = 2;
            panel.add(namaProd[counter], gbc);
            
            gbc.gridx = 3;
            panel.add(nama[counter], gbc);
            
            gbc.gridx = 4;
            panel.add(totalHarga[counter], gbc);
            
            gbc.gridx = 5;
            panel.add(jumlahProduk[counter], gbc);
            
            gbc.gridx = 6;
            panel.add(status[counter], gbc);

            gbc.gridx = 0;
            btn_see[counter] = new JButton(iconSee);
            btn_see[counter].setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn_see[counter].setBorderPainted(false);
            btn_see[counter].setFocusPainted(false);
            btn_see[counter].setContentAreaFilled(false);
            btn_see[counter].addActionListener(this);
            panel.add(btn_see[counter], gbc);

            gbc.gridy++;
            counter++;
        }
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(judul1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(idTrL, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(namaProdukL, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(namaL, gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 1;
        panel.add(totalHargaL, gbc);
        
        gbc.gridx = 5;
        gbc.gridy = 1;
        panel.add(jumlahProdukL, gbc);
        
        gbc.gridx = 6;
        gbc.gridy = 1;
        panel.add(statusL, gbc);
        
        add(header, BorderLayout.PAGE_START);
        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < newList.size(); i++) {
            if (ae.getSource() == btn_see[i]) {
                int option = JOptionPane.showConfirmDialog(null, "Yakin ingin Cancel Transaksi", "Update", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    if(Transaksi.hapusTransaksi(Integer.parseInt(idTr[i].getText()))){
                        JOptionPane.showMessageDialog(null, "Transaksi berhasil dibatalkan!");
                    }
                }
            }
        }

    }
}
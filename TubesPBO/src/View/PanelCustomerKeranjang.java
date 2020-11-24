/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.ProdukBeli;
import Model.Transaksi;
import Model.TransaksiManager;
import Model.UserManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class PanelCustomerKeranjang extends JPanel implements ActionListener {

    private JPanel header, content;
    private JLabel title, desc, namaProd[], merkProd[], jumlahBeliProd[], hargaProd[];
    private JButton btn_checkout[];
    private GridBagConstraints gbc;
    private ImageIcon iconCheckout;
    private List<ProdukBeli> listProd;

    private Image resizeImage(String url) {
        Image dimg = null;

        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(90, 25, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        return dimg;
    }

    public PanelCustomerKeranjang() {
        setLayout(new BorderLayout());
        header = new JPanel();
        header.setBackground(java.awt.Color.white);

        title = new JLabel("KERANJANG");
        title.setFont(new Font("Calibri", Font.BOLD, 60));
        title.setForeground(new Color(253, 170, 0));
        header.add(title);

        content = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        listProd = Controller.getProdukBeli();

        desc = new JLabel("Keranjang Kamu: ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        content.add(desc, gbc);

        iconCheckout = new ImageIcon(resizeImage("assets/add.png"));

        listProd = Controller.getProdukBeli();
        namaProd = new JLabel[listProd.size()];
        merkProd = new JLabel[listProd.size()];
        jumlahBeliProd = new JLabel[listProd.size()];
        hargaProd = new JLabel[listProd.size()];
        btn_checkout = new JButton[listProd.size()];

        int counter = 0;
        content.add(desc);
        gbc.gridy = 1;
        for (int i = 0; i < listProd.size(); i++) {
            gbc.gridx = 0;
            namaProd[counter] = new JLabel(listProd.get(i).getNama());
            namaProd[counter].setFont(new Font("Segoe UI", Font.PLAIN, 18));
            merkProd[counter] = new JLabel(listProd.get(i).getMerk());
            merkProd[counter].setFont(new Font("Segoe UI", Font.PLAIN, 18));
            jumlahBeliProd[counter] = new JLabel(String.valueOf(listProd.get(i).getJumlahBeli()));
            jumlahBeliProd[counter].setFont(new Font("Segoe UI", Font.PLAIN, 18));
            hargaProd[counter] = new JLabel("Rp. " + String.valueOf(listProd.get(i).getHarga()));
            hargaProd[counter].setFont(new Font("Segoe UI", Font.PLAIN, 18));
            btn_checkout[counter] = new JButton(iconCheckout);
            btn_checkout[counter].setBorderPainted(false);
            btn_checkout[counter].setFocusPainted(false);
            btn_checkout[counter].setContentAreaFilled(false);
            btn_checkout[counter].addActionListener(this);

            gbc.gridx += 3;
            content.add(namaProd[counter], gbc);

            gbc.gridx += 3;
            content.add(merkProd[counter], gbc);

            gbc.gridx += 3;
            content.add(jumlahBeliProd[counter], gbc);

            gbc.gridx += 3;
            content.add(hargaProd[counter], gbc);

            gbc.gridx += 3;
            content.add(btn_checkout[counter], gbc);

            gbc.gridy++;
            counter++;
        }

        add(header, BorderLayout.PAGE_START);
        add(content, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame("Checkout");
        JPanel header = new JPanel();
        
        String namaProdSelect = null;
        String harga = null;
        
        for (int i = 0; i < listProd.size(); i++) {
            if (e.getSource() == btn_checkout[i]) {
                namaProdSelect = namaProd[i].getText();
                harga = hargaProd[i].getText();
            }
        }
        
        JLabel judul = new JLabel("Checkout Produk " + namaProdSelect);
        header.add(judul);

        JPanel content = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 0, 0, 0);

        JLabel lbNama = new JLabel("Nama Penerima");
        JTextField tfNama = new JTextField(UserManager.getInstance().getUser().getNama(), 15);

        JLabel lbNoTelp = new JLabel("Nomor Telepon");
        JTextField tfNoTelp = new JTextField(15);

        JLabel lbAlamat = new JLabel("Alamat");
        JTextArea taAlamat = new JTextArea(5, 15);
        
        String[] arrMetodePembayaran = {"", "Debit", "Kredit", "COD"};
        JLabel lbMetodePembayaran = new JLabel("Metode Pembayaran");
        JComboBox cbMetodePembayaran = new JComboBox(arrMetodePembayaran);
        
        String[] arrMetodePengiriman = {"", "JNE", "SiCepat", "J&T"};
        JLabel lbMetodePengiriman = new JLabel("Metode Pengiriman");
        JComboBox cbMetodePengiriman = new JComboBox(arrMetodePengiriman);
        
        JLabel lbKodePromo = new JLabel("Kode Promo");
        JTextField tfKodePromo = new JTextField(15);
       
        
        JLabel lbTotalHarga = new JLabel("Total Harga");
        JLabel value = new JLabel(harga);
        JLabel ketPromo = new JLabel();
        
        tfKodePromo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tfKodePromo.getText().equals("GHZ10PERSEN")) {
                    value.setText("Rp. " + String.valueOf(Integer.parseInt(value.getText().substring(4)) * 90 / 100));
                    ketPromo.setText("Anda mendapatkan diskon 10% dari GHz!!!");
                } else {
                    ketPromo.setText(null);
                    value.setText("Rp. " + String.valueOf(Integer.parseInt(value.getText().substring(4)) * 100 / 90));
                }
            }
        });
        
        JButton addTransaksi = new JButton("Lakukan Transaksi");

        gbc.gridx = 0;
        gbc.gridy = 0;
        content.add(lbNama, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        content.add(tfNama, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        content.add(lbNoTelp, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        content.add(tfNoTelp, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        content.add(lbAlamat, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        content.add(taAlamat, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        content.add(lbMetodePembayaran, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        content.add(cbMetodePembayaran, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        content.add(lbMetodePengiriman, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        content.add(cbMetodePengiriman, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        content.add(lbKodePromo, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        content.add(tfKodePromo, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        content.add(lbTotalHarga, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        content.add(value, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 7;
        content.add(ketPromo, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 8;
        content.add(addTransaksi, gbc);
        
        addTransaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((tfNoTelp.getText().isEmpty() || taAlamat.getText().isEmpty()) || 
                        cbMetodePembayaran.getSelectedItem().toString().equals("") || 
                        cbMetodePengiriman.getSelectedItem().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "Field tidak boleh ada yang kosong", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    int option = JOptionPane.showConfirmDialog(null, "Apakah sudah yakin dengan data yang ditulis?", "Are you sure?", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        Transaksi newTransaksi = new Transaksi();
                        newTransaksi.setNamaLengkap(tfNama.getText());
                        newTransaksi.setNoTelepon(tfNoTelp.getText());
                        newTransaksi.setAlamat(taAlamat.getText());
                        newTransaksi.setJenisPembayaran(cbMetodePembayaran.getSelectedItem().toString());
                        newTransaksi.setJenisPengiriman(cbMetodePengiriman.getSelectedItem().toString());
                        newTransaksi.setKodePromo(tfKodePromo.getText());
                        newTransaksi.setTotalHarga(Integer.parseInt(value.getText().substring(4)));
                        TransaksiManager.getInstance().setTransaksi(newTransaksi);
                        if(Controller.insertNewTransaksi(newTransaksi) && Controller.insertConnectorTransaksi(newTransaksi)) {
                            JOptionPane.showMessageDialog(null, "Transaksi Berhasil!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Transaksi Gagal");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Transaksi Batal");
                    }
                }
            }
        });
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());
        frame.add(header, BorderLayout.NORTH);
        frame.add(content, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
    }
}

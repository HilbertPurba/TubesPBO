/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Controller.Controller;
import Controller.DatabaseHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class Vendor extends User {

    private List<Vendor> listVendor;
    static DatabaseHandler conn = new DatabaseHandler();

    public Vendor(int ID, String nama, String email, String password, String telepon, int TipeUser) {
        super(ID, nama, email, password, telepon, TipeUser);
    }

    public Vendor(String nama, String email, String password, String telepon, int TipeUser) {
        super(nama, email, password, telepon, TipeUser);
    }

    public Vendor() {
    }

    
    
//    //tes insert ke list
//    public void printProduct(){
//        for(Produk produk: listProduk){
//            JOptionPane.showMessageDialog(null, produk.getNamaProduk()+"\n"+produk.getHarga());
//        }
//    }

    @Override
    public void getUserBerdasarkanTipe() {
        conn.connect();
        String query = "SELECT * FROM pengguna WHERE tipeUser = 1";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Vendor vendor = new Vendor();
                vendor.setID(rs.getInt("id"));
                vendor.setNama(rs.getString("nama"));
                vendor.setEmail(rs.getString("email"));
                vendor.setPassword(rs.getString("password"));
                vendor.setTelepon(rs.getString("noTelp"));
                vendor.setTipeUser(rs.getInt("tipeUser"));
                this.listVendor.add(vendor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

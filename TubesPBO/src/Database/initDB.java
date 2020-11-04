/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class initDB {
    static final String url = "jdbc:mysql://localhost/";
    static String updatedUrl = "";
    static final String nama = "db_olshop";
    static final String query = "CREATE DATABASE " + nama;
    
    private Connection con;
    private Statement sts;
    
    private ResultSet rs;
    
    static final String tableAdmin = "CREATE TABLE Admin ("
            + "id_admin VARCHAR(10) NOT NULL, "
            + "nama VARCHAR(255) NOT NULL, "
            + "email VARCHAR(255) NOT NULL, "
            + "password VARCHAR(255) NOT NULL, "
            + "noTelp VARCHAR(255) NOT NULL, "
            + "PRIMARY KEY (id_admin))";
    
    static final String baseAdminData = "INSERT INTO Admin ("
            + "'id_admin', 'nama', 'email', 'password', 'noTelp') "
            + "VALUES "
            + "('A001', 'Kevin', 'kevin@gmail.com', '123456', '08159761575')";
    
    static final String tableCustomer = "CREATE TABLE Customer ("
            + "id_cust VARCHAR(10) NOT NULL, "
            + "nama VARCHAR(255) NOT NULL, "
            + "email VARCHAR(255) NOT NULL, "
            + "password VARCHAR(255) NOT NULL, "
            + "noTelp VARCHAR(255) NOT NULL, "
            + "PRIMARY KEY(id_cust))";
    
    static final String baseCustomerData = "INSERT INTO Customer ("
            + "'id_cust', 'nama', 'email', 'password', 'noTelp') "
            + "VALUES "
            + "('C001', 'Zefanya', 'zefa@gmail.com', '123456', '085155340807'), "
            + "('C002', 'Gilbert', 'gibe@gmail.com', '123456', '087944568989'), "
            + "('C003', 'Hilbert', 'hilbert@gmail.com', '123456', '096899468989') ";
    
    static final String tableVendor = "CREATE TABLE Vendor ("
            + "id_vendor VARCHAR(10) NOT NULL, "
            + "nama VARCHAR(255) NOT NULL, "
            + "email VARCHAR(255) NOT NULL, "
            + "password VARCHAR(255) NOT NULL, "
            + "noTelp VARCHAR(255) NOT NULL, "
            + "PRIMARY KEY(id_vendor))";
    
    static final String baseVendorData = "INSERT INTO Vendor ("
            + "'id_vendor', 'nama', 'email', 'password', 'noTelp') "
            + "VALUES "
            + "('V001', 'Megacomp', 'megacomp@gmail.com', '123456', '085644987946'), "
            + "('V002', 'Gramedia Online', 'gramed@gmail.com', '123456', '08659964646'), "
            + "('V003', '3Second Online', 'threesecond@gmail.com', '123456', '086566894949') ";
    
    static final String tableProduct = "CREATE TABLE Product ("
            + "id_prod VARCHAR(10) NOT NULL, "
            + "id_vendor VARCHAR(10) NOT NULL, "
            + "nama VARCHAR(255) NOT NULL, "
            + "merk VARCHAR(255) NOT NULL, "
            + "harga INT(15) NOT NULL, "
            + "stok INT(5) NOT NULL, "
            + "PRIMARY KEY (id_prod), "
            + "FOREIGN KEY (id_vendor) REFERENCES Vendor(id_vendor))";
    
    static final String baseProductData = "INSERT INTO Product ("
            + "'id_prod', 'id_vendor', 'nama', 'merk', 'harga', 'stok') "
            + "VALUES "
            + "('P001', 'V001', 'Mouse Logitech G33', 'Logitech'," + "'" + 200000 + "', " + "'" + 10 + "'), "
            + "('P002', 'V002', 'Buku Mengaji Cerdas', 'Mizan'," + "'" + 25000 + "', " + "'" + 20 + "'), "
            + "('P003', 'V003', 'Kaos Trendy Yellow', '3Second'," + "'" + 50000 + "', " + "'" + 5 + "') ";
    
    static final String tableKeranjang = "CREATE TABLE Keranjang ("
            + "id_keranjang VARCHAR(10) NOT NULL, " 
            + "id_cust VARCHAR(10) NOT NULL, "
            + "id_prod VARCHAR(10) NOT NULL, "
            + "jumlah_total INT(10) NOT NULL, "
            + "harga_total INT(15) NOT NULL, "
            + "PRIMARY KEY(id_keranjang), "
            + "FOREIGN KEY (id_cust) REFERENCES Customer(id_cust), "
            + "FOREIGN KEY (id_prod) REFERENCES Product(id_prod))";
    
    static final String baseKeranjangData = "INSERT INTO Keranjang ("
            + "'id_keranjang', 'id_cust', 'id_prod', 'jumlah_total', 'harga_total') "
            + "VALUES "
            + "('K001', 'C001', 'P001'," + "'" + 1 + "', " + "'" + 200000 + "'), "
            + "('K002', 'C002', 'P002'," + "'" + 2 + "', " + "'" + 50000 + "'), "
            + "('K003', 'C003', 'P003'," + "'" + 4 + "', " + "'" + 200000 + "') ";
    
    static final String tableTransaksi = "CREATE TABLE Transaksi ("
            + "id_transaksi VARCHAR(10) NOT NULL, "
            + "id_keranjang VARCHAR(10) NOT NULL, "
            + "nama VARCHAR(255) NOT NULL, "
            + "noTelp VARCHAR(50) NOT NULL, "
            + "alamat VARCHAR(255) NOT NULL, "
            + "jenis_pembayaran VARCHAR(255) NOT NULL, "
            + "jenis_pengiriman VARCHAR(255) NOT NULL, "
            + "kode_promo VARCHAR(255) NOT NULL, "
            + "total_harga INT(15) NOT NULL, "
            + "PRIMARY KEY (id_transaksi), "
            + "FOREIGN KEY (id_keranjang) REFERENCES Keranjang(id_keranjang))";
    
    static final String baseTransaksiData = "INSERT INTO Transaksi ("
            + "'id_transaksi', 'id_keranjang', 'nama', 'noTelp', 'alamat', 'jenis_pembayaran', 'jenis_pengiriman', 'kode_promo', 'total_harga') "
            + "VALUES "
            + "('T001', 'K001', 'Zefanya', '085155340807', 'Kopo', 'COD', '-', 'DISC10K, " + "'" + 190000 + "'), "
            + "('T002', 'K002', 'Gilbert', '087944568989', 'Bitung', 'Transfer Bank', 'JNE', 'DISC10K', " + "'" + 40000 + "'), "
            + "('T003', 'K003', 'Hilbert', '096899468989', 'Pasir Kaliki', 'Transfer Bank', 'JNT', '-', " + "'" + 200000 + "') ";

    public void initDB(){
        con = null;
        sts = null;
        
        try {
            System.out.println("Connecting to SQL...");
            con = DriverManager.getConnection(url, "root", "");
            
            rs = con.getMetaData().getCatalogs();
            
            while(rs.next()){
                String dbName = rs.getString(1);
                
                if(dbName.equals(nama)){
                    JOptionPane.showMessageDialog(new JLabel(), "Database exists!");
                }
            }
            
            System.out.println("Creating Database");
            sts = con.createStatement();
            
            sts.execute(query);
            System.out.println("Database has been created.");
            
            updatedUrl = "jdbc:mysql://localhost/" + nama;
            
        } catch (SQLException se){
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (sts != null){
                    sts.close();
                }
                
                if (con != null){
                    con.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
    }
    
    // Admin
    public void createTableAdmin(){
        try {
            con = DriverManager.getConnection(updatedUrl, "root", "");
            sts = con.createStatement();
            
            sts.executeUpdate(tableAdmin);
            System.out.println("Table 'Admin' has been created!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sts != null){
                    sts.close();
                }
                
                if (con != null){
                    con.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
        
        try {
            con = DriverManager.getConnection(updatedUrl, "root", "");
            sts = con.createStatement();
            
            sts.executeUpdate(baseAdminData);
            System.out.println("Data 'Admin' has been updated");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (sts != null){
                    sts.close();
                }
                
                if (con != null){
                    con.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
    }
    
    // Customer
    public void createTableCustomer(){
        try {
            con = DriverManager.getConnection(updatedUrl, "root", "");
            sts = con.createStatement();
            
            sts.executeUpdate(tableCustomer);
            System.out.println("Table 'Customer' has been created!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sts != null){
                    sts.close();
                }
                
                if (con != null){
                    con.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
        
        try {
            con = DriverManager.getConnection(updatedUrl, "root", "");
            sts = con.createStatement();
            
            sts.executeUpdate(baseCustomerData);
            System.out.println("Data 'Customer' has been updated");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (sts != null){
                    sts.close();
                }
                
                if (con != null){
                    con.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
    }
    
    // Vendor
    public void createTableVendor(){
        try {
            con = DriverManager.getConnection(updatedUrl, "root", "");
            sts = con.createStatement();
            
            sts.executeUpdate(tableVendor);
            System.out.println("Table 'Vendor' has been created!");
            
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (sts != null){
                    sts.close();
                }
                
                if (con != null){
                    con.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
        
        try {
            con = DriverManager.getConnection(updatedUrl, "root", "");
            sts = con.createStatement();
            
            sts.executeUpdate(baseVendorData);
            System.out.println("Data 'Vendor' has been updated");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (sts != null){
                    sts.close();
                }
                
                if (con != null){
                    con.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
    }
    
    // Product
    public void createTableProduct(){
        try {
            con = DriverManager.getConnection(updatedUrl, "root", "");
            sts = con.createStatement();
            
            sts.executeUpdate(tableProduct);
            System.out.println("Table 'Product' has been created!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sts != null){
                    sts.close();
                }
                
                if (con != null){
                    con.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
        
        try {
            con = DriverManager.getConnection(updatedUrl, "root", "");
            sts = con.createStatement();
            
            sts.executeUpdate(baseProductData);
            System.out.println("Data 'Product' has been updated");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (sts != null){
                    sts.close();
                }
                
                if (con != null){
                    con.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
    }
    
    // Keranjang
    public void createTableKeranjang(){
        try {
            con = DriverManager.getConnection(updatedUrl, "root", "");
            sts = con.createStatement();
            
            sts.executeUpdate(tableKeranjang);
            System.out.println("Table 'Keranjang' has been created!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sts != null){
                    sts.close();
                }
                
                if (con != null){
                    con.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
        
        try {
            con = DriverManager.getConnection(updatedUrl, "root", "");
            sts = con.createStatement();
            
            sts.executeUpdate(baseKeranjangData);
            System.out.println("Data 'Keranjang' has been updated");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (sts != null){
                    sts.close();
                }
                
                if (con != null){
                    con.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
    }
    
    // Transaksi
    public void createTableTransaksi(){
        try {
            con = DriverManager.getConnection(updatedUrl, "root", "");
            sts = con.createStatement();
            
            sts.executeUpdate(tableTransaksi);
            System.out.println("Table 'Transaksi' has been created!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sts != null){
                    sts.close();
                }
                
                if (con != null){
                    con.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
        
        try {
            con = DriverManager.getConnection(updatedUrl, "root", "");
            sts = con.createStatement();
            
            sts.executeUpdate(baseTransaksiData);
            System.out.println("Data 'Transaksi' has been updated");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (sts != null){
                    sts.close();
                }
                
                if (con != null){
                    con.close();
                }
            } catch (SQLException se){
                se.printStackTrace();
            }
        }
    }
}

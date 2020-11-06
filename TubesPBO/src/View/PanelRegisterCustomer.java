/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

// import Controler.PasswordConverterToMd5;
import Controller.DatabaseHandler;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Lenovo
 */
public class PanelRegisterCustomer extends JPanel {
    
    JFrame registrasiFrame = new JFrame("Registrasi Customer");
    
    private Connection con;
    private String query;
    private Statement st;
    
    public PanelRegisterCustomer(){
        this.setBackground(Color.WHITE);
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBackground(Color.WHITE);
        this.add(panelForm);
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;
        
        panelForm.add(new JLabel("Nama : "),c);
        c.gridy++;
        panelForm.add(new JLabel("Email: "), c);
        c.gridy++;
        panelForm.add(new JLabel("Nomor Telp: "), c);
        c.gridy++;
        panelForm.add(new JLabel("Password: "), c);
        c.gridy++;
        
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        JTextField tfNama = new JTextField(12);
        panelForm.add(tfNama, c);
        c.gridy++;
        JTextField tfEmail = new JTextField(12);
        panelForm.add(tfEmail, c);
        c.gridy++;
        JTextField tfNomorTelp = new JTextField(12);
        panelForm.add(tfNomorTelp, c);
        c.gridy++;
        JPasswordField tfPassword = new JPasswordField(12);
        panelForm.add(tfPassword, c);
        c.gridy++;
        
        //Register
        // ImageIcon iconRegister = new ImageIcon(resizeImage("../Pict/register.png"));
        // ImageIcon iconRegister2 = new ImageIcon(resizeImage("../Pict/register1.png"));

        JLabel buttonRegister = new JLabel();
        buttonRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // buttonRegister.setIcon(iconRegister2);
        
        buttonRegister.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent me) {
                        try {            
                            con = DatabaseHandler.getConnection();
                            st = con.createStatement();
                            // String pw = PasswordConverterToMd5.passConverter(String.copyValueOf(tfPassword.getPassword()));
                            
                            query = "insert into customer " +
                                    "(name, username, password, phoneNumber, email, address, balance, type) " +
                                    "values ('" + tfNama.getText() + "', '" + tfPassword + "', '" +
                                    tfNomorTelp.getText() + "', '" + tfEmail.getText();
                            st.executeUpdate(query);
                            
                            System.out.println("Inserted");

//                            connectDB.closeConnection();
                        } catch (Exception insert){
                            System.err.println("Couldn't insert.");
                            System.err.println(insert.getMessage());
                        }
                    }

                    // @Override
                    // public void mouseEntered(MouseEvent me) {
                    //    buttonRegister.setIcon(iconRegister);
                    // }

                    // @Override
                    // public void mouseExited(MouseEvent me) {
                    //    buttonRegister.setIcon(iconRegister2);
                    // }
                }
        );
        this.add(buttonRegister, BorderLayout.SOUTH);
        registrasiFrame.add(panelForm);
        registrasiFrame.getContentPane().setBackground(Color.WHITE);
        registrasiFrame.setLocationRelativeTo(null);
        registrasiFrame.setVisible(true);
    }

    private Image resizeImage(String url) {
        Image dimg = null;

        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(65, 26, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        return dimg;
    }
    
    
}

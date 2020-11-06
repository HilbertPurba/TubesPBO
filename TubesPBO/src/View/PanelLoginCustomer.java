/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

// import Controller.PasswordConverterToMd5;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
// import programdriver.TubesPBO;
// import user.Current;
// import static user.Current.handler;
// import static user.Current.mainMenu;
// import user.Customer;

/**
 *
 * @author Lenovo
 */
public class PanelLoginCustomer extends JPanel {
    public PanelLoginCustomer(){
        this.setBackground(Color.WHITE);
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBackground(Color.WHITE);
        this.add(panelForm);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;

        panelForm.add(new JLabel("Username: "), c);
        c.gridy++;
        panelForm.add(new JLabel("Password: "), c);
        c.gridy++;

        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        JTextField tfUsername = new JTextField(12);
        panelForm.add(tfUsername, c);
        c.gridy++;
        JPasswordField tfPassword = new JPasswordField(12);
        panelForm.add(tfPassword, c);
        c.gridy++;

        //Login
        // ImageIcon iconRegister = new ImageIcon(resizeImage("../Pict/login.png"));
        // ImageIcon iconRegister2 = new ImageIcon(resizeImage("../Pict/login1.png"));

        JLabel buttonRegister = new JLabel();
        JLabel labelAttempt = new JLabel("");
        buttonRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // buttonRegister.setIcon(iconRegister2);

        buttonRegister.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent me) {
                        //rgs = register
                        System.out.println("tes");
                        String rgsUsername = tfUsername.getText();
                        String rgsPassword = null;
                        // try {
                        //    rgsPassword = PasswordConverterToMd5.passConverter(String.copyValueOf(tfPassword.getPassword()));
                        // } catch (NoSuchAlgorithmException ex) {
                        //    Logger.getLogger(FrameLoginCustomer.class.getName()).log(Level.SEVERE, null, ex);
                        // }
                        // Customer c = null;
                        boolean status = false;
                        // if (!rgsUsername.isEmpty() && !rgsPassword.isEmpty()) {
                        //    for (Customer customer1  : Current.listCustomer) {
                        //            if(rgsUsername.equals(customer1.getUsername()) && rgsPassword.equals(customer1.getPassword())){
                        //                c = customer1;
                        //                status = true;
                        //                break;
                        //            }
                        //    }
                            if(!status){
                                tfUsername.setText("");
                                tfPassword.setText("");
                                labelAttempt.setText("Invalid Username or Password.");
                            } else{
                                // Current.currentUser = c;
                                // Current.initUser();
                                // mainMenu = new MainMenu(handler);
                                // mainMenu.setVisible(true);
                                // Start.fc.dispose();
                                // start();
                            }
                        // }
                    }

                    // @Override
                    // public void mouseEntered(MouseEvent me) {
                    //    buttonRegister.setIcon(iconRegister);
                    // }

                    // @Override
                    // public void mouseExited(MouseEvent me) {
                    //     buttonRegister.setIcon(iconRegister2);
                    // }
                }
        );
        this.add(buttonRegister, BorderLayout.EAST);
        this.add(labelAttempt, BorderLayout.SOUTH);
    }
    
    public Image resizeImage(String url) {
        Image dimg = null;

        try {
            BufferedImage img = ImageIO.read(new File(url));
            dimg = img.getScaledInstance(65, 26, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        return dimg;
    }
    
    // public void start(){
    //     if (Current.currentUser != null && Current.currentDriver != null && Current.currentVendor != null) {
    //         Current.initTracking();
    //     }
    // }
}

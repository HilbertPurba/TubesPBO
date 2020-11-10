/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.enums.TipeUser;
/**
 *
 * @author Lenovo
 */
public class User {
    private int ID;
    private String nama;
    private String email;
    private TipeUser tipeUser;
    private String password;
    private String telepon;

    public User(int ID, String nama,String email, TipeUser tipeUser, String password, String telepon) {
        this.ID = ID;
        this.nama = nama;
        this.email = email;
        this.tipeUser = tipeUser;
        this.password = password;
        this.telepon = telepon;
    }

    public User() {
    }

    public User(String nama, String email, TipeUser tipeUser, String password, String telepon) {
        this.nama = nama;
        this.email = email;
        this.tipeUser = tipeUser;
        this.password = password;
        this.telepon = telepon;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

}

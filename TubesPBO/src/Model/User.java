/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.enums.TipeUserEnums;
/**
 *
 * @author Lenovo
 */
public class User {

    private int ID;
    private TipeUserEnums TipeUser;
    private String nama;
    private String email;
    private String password;
    private String telepon;

    public User(int ID, TipeUserEnums TipeUser, String nama, String email, String password, String telepon) {
        this.ID = ID;
        this.TipeUser = TipeUser;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.telepon = telepon;
    }

    public User(String nama, String email, String password, String telepon) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.telepon = telepon;
    }

    public User() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public TipeUserEnums getTipeUser() {
        return TipeUser;
    }

    public void setTipeUser(TipeUserEnums TipeUser) {
        this.TipeUser = TipeUser;
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

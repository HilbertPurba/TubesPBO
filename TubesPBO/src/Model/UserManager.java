/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Gilbert
 * @author Hilbert
 * @author Zefanya
 */
public class UserManager {
    private static UserManager instance;
    private User user;
    private Produk produk;
    
    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public User getUser() {
        return user;
    }
    
    public Produk getProduk(){
        return produk;
    }
    
    public void logOut() {
        instance = null;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
}

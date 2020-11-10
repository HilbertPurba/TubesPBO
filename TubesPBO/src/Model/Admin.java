/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 *
 * @author Lenovo
 */
public class Admin extends User{

    public Admin(int ID, String nama, String email, String password, String telepon) {
        super(ID, nama, email, password, telepon);
    }

    public Admin(String nama, String email, String password, String telepon) {
        super(nama, email, password, telepon);
    }

    public Admin() {
    }
    
   
}

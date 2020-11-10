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
public class Admin extends User{

    public Admin(int ID, TipeUserEnums TipeUser, String nama, String email, String password, String telepon) {
        super(ID, TipeUser, nama, email, password, telepon);
    }

    public Admin(String nama, String email, String password, String telepon) {
        super(nama, email, password, telepon);
    }

    public Admin() {
    }

}

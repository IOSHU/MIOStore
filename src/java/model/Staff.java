/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hieule
 */
public class Staff extends Person{
    public Staff(String username, String password) {
        super(username, password);
    }

    public Staff(int id, String name, String username, String password, String address, String phone, String email, Role role) {
        super(id, name, username, password, address, phone, email, role);
    }   
}

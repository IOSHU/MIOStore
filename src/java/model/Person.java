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
public class Person {
    private int id;
    private String name;
    private String username;
    private String password;
    private String address;
    private String phone;
    private String email;
    private Role role;

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public Person(String name, String username, String password, String address, String phone, String email, Role role) {
        this.id = -1;
        this.name = name;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }
    
    public Person(int id, String name, String username, String password, String address, String phone, String email, Role role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", address=" + address + ", phone=" + phone + ", email=" + email + ", role=" + role + '}';
    }

    
    
}

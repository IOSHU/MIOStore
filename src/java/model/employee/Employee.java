/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.employee;

import java.sql.Date;
import model.Role;

/**
 *
 * @author hieule
 */
public class Employee {
    private int id;
    private Account account;
    private FullName fullName;
    private Address address;
    private String phone;
    private String email;
    private String department;
    private Date birthday;
    private String gender;
    private Role role;

    public Employee(int id, Account account, FullName fullName, Address address, String phone, String email, String department, Date birthday, String gender, Role role) {
        this.id = id;
        this.account = account;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.department = department;
        this.birthday = birthday;
        this.gender = gender;
        this.role = role;
    }
    
    public Employee(Account account, FullName fullName, Address address, Role role) {
        this.id = -1;
        this.account = account;
        this.fullName = fullName;
        this.address = address;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.fullName.toString();
    }
}

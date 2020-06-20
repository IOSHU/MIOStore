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
public enum Role {
    CUSTOMER(0), SALESREP(1), MANAGER(2), STAFF(3);
    
    private final int value;
    private Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

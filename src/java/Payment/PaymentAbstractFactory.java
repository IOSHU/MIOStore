/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payment;

/**
 *
 * @author User
 */
public abstract class PaymentAbstractFactory {
    abstract BankCard bankCardPaying();
    abstract Cash cashPaying();
    abstract MOMO MOMOPaying();
}
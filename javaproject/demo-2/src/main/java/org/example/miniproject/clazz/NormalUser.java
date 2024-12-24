package org.example.miniproject.clazz;

public class NormalUser extends User implements Payable{
    private Payment payment;
    @Override
    public boolean inputPayment(VendingMachine vendingMachine) {
        vendingMachine.setPayment(payment);
        return false;
    }
}

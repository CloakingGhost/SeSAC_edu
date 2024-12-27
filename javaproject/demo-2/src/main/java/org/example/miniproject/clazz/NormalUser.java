package org.example.miniproject.clazz;

public class NormalUser extends User implements Payable{
    private Payment payment;
    @Override
    public void inputPayment(VendingMachine vendingMachine) {
        vendingMachine.setPayment(payment);
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "NormalUser{" +
                "payment=" + payment +
                '}';
    }
}

package org.example.miniproject.clazz;

public abstract class Payment {
    private int cash;
    public abstract boolean payProcess(Product<ProductType> product);

    public Payment(int cash) {
        this.cash = cash;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}

package org.example.miniproject.clazz;

public class Product<T extends ProductType> {
    private String name;
    private int price;
    private int remain;
    private T type;

    public Product(String name, int price, T type) {
        this.name = name;
        this.price = price;
        this.remain = 0;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRemain() {
        return remain;
    }

    public boolean setRemain(int amount) {
        if (amount < 0) return false;
        this.remain = amount;
        return true;
    }

    public void decreaseRemain() {
        --remain;
        if (remain < 0) remain = 0;
    }

    public void increaseRemain() {
        ++remain;
    }

    public T getType() {
        return type;
    }

    public boolean isEmpty() {
        return remain == 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", remain=" + remain +
                ", type=" + type +
                '}';
    }
}
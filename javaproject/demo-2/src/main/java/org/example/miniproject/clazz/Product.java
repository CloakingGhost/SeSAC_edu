package org.example.miniproject.clazz;

public class Product<T extends ProductType> {
    private String name;
    private int price;
    private int remain;
    private T type;

    /**
     * Product 생성자
     *
     * @param name 제품 이름
     * @param price 제품 가격
     * @param type 제품의 유형 (Enum: ProductType)
     * */
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

    /** 재고량 1 감소 */
    public void decreaseRemain() {
        --remain;
        if (remain < 0) remain = 0;
    }

    /** 재고량 1 증가 */
    public void increaseRemain() {
        ++remain;
    }

    /** 재고량 amount 증가
     * @param amount 양(량)
     * */
    public void increaseRemain(int amount) {
        remain += amount;
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
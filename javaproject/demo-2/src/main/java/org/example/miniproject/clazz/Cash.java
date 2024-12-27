package org.example.miniproject.clazz;

public class Cash extends Payment{
    private int cash;

    public Cash(int cash) {
        super(cash);
    }

    @Override
    public boolean payProcess(Product<ProductType> product) {
        int price = product.getPrice();

        // 잔액보다 물건 가격이 크면 return false
        if (price < cash) return false;
        // 아니면 (결제 가능하면)
        // 잔액을 물건 가격만큼 줄이고
        cash -= price;
        return true;
        // true 받는 곳에서 product의 재고 1 감소
    }

    @Override
    public String toString() {
        return "Cash{" +
                "cash=" + cash +
                '}';
    }
}

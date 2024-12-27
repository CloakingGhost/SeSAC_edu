package org.example.miniproject.clazz;

public class Manager extends User{

    public void showProducts(VendingMachine vendingMachine){
        vendingMachine.displayProductAll();
    }
    public void showRevenue(VendingMachine vendingMachine) {
        System.out.println("vendingMachine.revenue = " + vendingMachine.revenue);
    }

    // 상품을 이름으로 찾아서 해당 함수에 넣어서 실행, 변경할 값도 같이 받음
    public void updateProductPrice(Product<ProductType> product, int price) {
        product.setPrice(price);
    }
}

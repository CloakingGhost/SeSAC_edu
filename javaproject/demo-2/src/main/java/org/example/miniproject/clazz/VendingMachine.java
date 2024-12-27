package org.example.miniproject.clazz;

import java.util.*;

public abstract class VendingMachine {
    protected int revenue;
    protected Payment payment;
    protected Map<ProductType, List<Product<ProductType>>> productMap;

    public VendingMachine() {
        productMap = new HashMap<>();
        payment = null;
        revenue = 0;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public boolean pay(String name) {
        Product<ProductType> product = findByName(name);
        if (product == null) {
            // 올바르지 않은 입력값 (이름)
            return false;
        }

        boolean isWork = payment.payProcess(product);
        if (isWork) {
            // TODO 이렇게 해도 변화반영이 되나??
            // 생각의 근거는 참조 객체로 메모리 주소가 담긴 변수를 통해
            // 값을 변경했기 때문에 반영이 될거라 추측
            // 결과: 예상대로 되었음
            product.decreaseRemain();
            revenue += product.getPrice();
            return true;
        }
        // 결제 진행 안 됨
        return false;
    }


    public boolean isSoldOut(Product<ProductType> product) {
        return product.isEmpty();
    }

    public void displayProductAll() {
        for (Map.Entry<ProductType, List<Product<ProductType>>> p : productMap.entrySet()) {
            ProductType key = p.getKey();
            System.out.println("Type = " + key);
            List<Product<ProductType>> value = p.getValue();

            for (Product<ProductType> v : value) {
                System.out.printf("name: %s, price: %d, remain: %s\n", v.getName(), v.getPrice(), isSoldOut(v) ? "Sold Out" : v.getRemain());
            }
        }
    }

    public void displayAvailablePurchase() {
        for (Map.Entry<ProductType, List<Product<ProductType>>> p : productMap.entrySet()) {
            ProductType key = p.getKey();
            System.out.println("Type = " + key);
            List<Product<ProductType>> value = p.getValue();

            for (Product<ProductType> v : value) {
                // "X" 구매 불가 : 금액 부족
                // "⌀" 재고 없음
                // "O" 구매 가능
                String availablePurchase = "O";
                if (v.getRemain() == 0) {
                    availablePurchase = "⌀";
                } else if (payment.getCash() < v.getPrice()) {
                    availablePurchase = "X";
                }

                System.out.printf("name: %s, price: %d, Available Purchase: %s\n", v.getName(), v.getPrice(), availablePurchase);
            }
        }
    }

    //** 상품목록 추가 */
    public void updateProduct(Product<ProductType>... products) {
        for (Product<ProductType> product : products) {
            updateProduct(product, 0);
        }
    }
    //static factory pattern
    // 상품 추가
    // 기존 상품에 재고 수량 추가


    //** 상품목록 추가, 상품 재고량 증가 */
    public void updateProduct(Product<ProductType> product, int amount) {

        // 타입에 해당하는 상품목록(리스트), 없으면 리스트 생성
        List<Product<ProductType>> products = productMap.getOrDefault(product.getType(), new ArrayList<>());
        // product가 있으면 수량 추가
        for (Product<ProductType> p : products) {
            if (p.getName().equals(product.getName())) {
                p.increaseRemain(amount);
                return;
            }

        }
        // 없으면 추가
        products.add(product);
        productMap.put(product.getType(), products);


    }

    public Product<ProductType> deleteProduct(String name) {
        for (List<Product<ProductType>> lst : productMap.values()) {
            for (int i = 0; i < lst.size(); i++) {
                if (name.equals(lst.get(i).getName())) {
                    return lst.remove(i);
                }
            }
        }

        return null;

    }

    private List<Product<ProductType>> findListByName(String name) {
        for (List<Product<ProductType>> lst : productMap.values()) {
            for (Product<ProductType> product : lst) {
                if (name.equals(product.getName())) {
                    return lst;
                }
            }
        }

        return null;
    }

    private Product<ProductType> findByName(String name) {

        for (List<Product<ProductType>> lst : productMap.values()) {
            for (Product<ProductType> product : lst) {
                if (name.equals(product.getName())) {
                    return product;
                }
            }
        }

        return null;

        /*
        return productMap.values().stream()
                .flatMap(List::stream) // List<Product<ProductType>>를 개별 Product로 펼침
                .filter(product -> name.equals(product.getName())) // 이름이 일치하는 Product 필터링
                .findFirst() // 첫 번째 결과 가져오기
                .orElse(null); // 없으면 null 반환
        */
    }

    // 새로운 타입의 K, V 생성
    // V.add(product)


    private boolean isContains(String name) {
        Product<ProductType> product = findByName(name);
        return product != null;
    }
}

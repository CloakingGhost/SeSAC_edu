package org.example.miniproject.clazz;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class VendingMachine {
    protected Payment payment;
    protected Map<ProductType, List<Product<ProductType>>> productMap;

    public abstract void setPayment(Payment payment);

    public abstract void payProcess();


    public boolean isSoldOut(Product<ProductType> product){
        return product.isEmpty();
    }
    public void displayProductAll(){
        for (Map.Entry<ProductType, List<Product<ProductType>>> p : productMap.entrySet()) {
            ProductType key = p.getKey();
            System.out.println("Type = " + key);
            List<Product<ProductType>> value = p.getValue();
            byte count = 0;
            for (Product<ProductType> v : value) {
                System.out.printf("name: %s, price: %d, remain: %d\n",v.getName(), v.getPrice(), v.getRemain());
            }
        }
    }
}

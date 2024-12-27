package org.example.demo3.myProduct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    public static final List<Product> products = new ArrayList<>();
    private Long id = 0L;
    //create
    @PostMapping("/products")
    public Product createProduct(){
        Product product = new Product(++id, "product " + id, (int) (100 * id));
        return product;
    }
}

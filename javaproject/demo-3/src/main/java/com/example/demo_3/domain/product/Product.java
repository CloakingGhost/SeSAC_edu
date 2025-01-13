package com.example.demo_3.domain.product;

import com.example.demo_3.domain.product.dto.requset.ProductRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer price;

    @Builder
    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Product update(ProductRequestDto requestDto) {
        name = requestDto.getName();
        price = requestDto.getPrice();
        return this;
    }
}

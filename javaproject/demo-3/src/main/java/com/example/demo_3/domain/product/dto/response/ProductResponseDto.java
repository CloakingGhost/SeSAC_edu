package com.example.demo_3.domain.product.dto.response;

import com.example.demo_3.domain.product.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductResponseDto {
    private Long id;
    private String name;
    private Integer price;

    public static ProductResponseDto from(Product entity) {
        return ProductResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .build();
    }

}

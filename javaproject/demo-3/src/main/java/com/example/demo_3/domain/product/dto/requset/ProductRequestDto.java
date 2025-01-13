package com.example.demo_3.domain.product.dto.requset;

import com.example.demo_3.domain.product.Product;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
@Builder
@AllArgsConstructor
public class ProductRequestDto {
    @Length(min = 1)
    private String name;

    @Min(value = 0)
    private Integer price;

    public Product toEntity(){
        return Product.builder()
                .name(name)
                .price(price)
                .build();
    }
}

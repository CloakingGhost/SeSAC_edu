package com.example.demo_3.domain.product;

import com.example.demo_3.domain.product.dto.requset.ProductRequestDto;
import com.example.demo_3.domain.product.dto.response.ProductResponseDto;
import com.example.demo_3.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    @Transactional
    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = productRepository.save(requestDto.toEntity());

        return ProductResponseDto.from(product);
    }

    public ProductResponseDto readProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return ProductResponseDto.from(product);
    }

    public List<ProductResponseDto> readProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductResponseDto::from).toList();
    }

    @Transactional
    public ProductResponseDto updateProduct(Long id, ProductRequestDto requestDto) {
        Product product = productRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return ProductResponseDto.from(product.update(requestDto));
    }

    @Transactional
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        productRepository.delete(product);
    }
}

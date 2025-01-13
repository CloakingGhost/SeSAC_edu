package com.example.demo_3.domain.product;

import com.example.demo_3.domain.product.dto.requset.ProductRequestDto;
import com.example.demo_3.domain.product.dto.response.ProductResponseDto;
import com.example.demo_3.global.common.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    public final ProductService productService;

    // 생성 DTO return responseDTO
    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponseDto>> createProduct(@Valid @RequestBody ProductRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Create", "CREATE", productService.createProduct(requestDto)));
    }

    // 단건 조회 id return responseDTO
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponseDto>> readProduct(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(productService.readProduct(id)));
    }

    // 다건 조회 전체 return responseDTO
    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductResponseDto>>> readProducts() {
        return ResponseEntity.ok(ApiResponse.ok(productService.readProducts()));
    }
    // 업데이트 id(paht), dto return responseDTO

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponseDto>> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequestDto requestDto) {
        return ResponseEntity.ok(ApiResponse.ok(productService.updateProduct(id, requestDto)));
    }

    // 삭제 id return Void
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}

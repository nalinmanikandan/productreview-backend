package com.backend2.productreview.service;
import com.backend2.productreview.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto getProduct(Long productId);
    List<ProductDto> getAllProducts();
    ProductDto updateProduct(Long productId, ProductDto updatedProduct);
    void deleteProduct(Long productId);
}

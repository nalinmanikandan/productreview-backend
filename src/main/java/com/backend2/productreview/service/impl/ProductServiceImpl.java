package com.backend2.productreview.service.impl;
import com.backend2.productreview.dto.ProductDto;
import com.backend2.productreview.exception.ResourceNotFoundException;
import com.backend2.productreview.mapper.ProductMapper;
import com.backend2.productreview.repository.ProductRepository;
import com.backend2.productreview.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.backend2.productreview.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductDto createProduct(ProductDto productDto){

        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct  = productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto getProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product Not Found In Database : "+productId));
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map((product) -> ProductMapper.mapToProductDto(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto updatedProduct) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found In Database : " + productId));
        product.setProductName(updatedProduct.getProductName());
        product.setDescription(updatedProduct.getDescription());
        product.setBrandName(updatedProduct.getBrandName());
        Product updatedProductEntity = productRepository.save(product);
        return ProductMapper.mapToProductDto(updatedProductEntity);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found In Database : " + productId));
        productRepository.deleteById(productId);
    }


}
